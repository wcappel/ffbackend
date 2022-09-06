package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.misc.*;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Player;
import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.LeagueRepository;
import com.wcappel.ffbackend.repository.RosterRepository;
import com.wcappel.ffbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller @RequestMapping("/ffapi/v1/draft") public class DraftController {
	@Autowired private TeamRepository teamRepository;
	@Autowired private RosterRepository rosterRepository;
	@Autowired private LeagueRepository leagueRepository;
	@Autowired private DraftOrderHolder draftOrderHolder;


	@PostMapping("/startdraft/league={league}") void startDraft(@PathVariable int league) {
		Optional<League> draftingLeague = leagueRepository.findByLeagueId(league);

		if (draftingLeague.isPresent()) {
			List<Team> leagueTeams = teamRepository.getTeamsByLeague(league);
			if (draftOrderHolder.getLeagueDraftOrder(draftingLeague.get()) == null) {
				draftOrderHolder.createLeagueDraftOrder(draftingLeague.get(), leagueTeams);
//				System.out.println(leagueTeams.toString());
				System.out.println("Draft Order:");
				System.out.println(draftOrderHolder.getLeagueDraftOrder(draftingLeague.get()));
			}
		}
	}

	@MessageMapping("/draftreq/{league}")
	@SendTo("/draftfeed/{league}")
	public DraftOutput draftPlayer(DraftRequest draftRequest, @DestinationVariable int league) throws Exception {
		int userLeague = Integer.parseInt(draftRequest.getLeague());
		boolean draftSuccess = false;
		System.out.println(draftRequest);

		Optional<League> draftingLeague = leagueRepository.findByLeagueId(userLeague);

		if (draftingLeague.isPresent()) {
			DraftOrder currentLeagueDraftInfo = draftOrderHolder.getLeagueDraftOrder(draftingLeague.get());
			// Always check to see what team the request is for based on the user and the league
			// Perform checks here and add to database

			List<Team> userTeamList = teamRepository.getTeamsByLeagueAndUser(userLeague,
					draftRequest.getUser());
			Team currTeam = null;
			if (userTeamList.size() == 0) {
				System.out.println("User does not have a team in this league!");
			} else if (userTeamList.size() == 1) {
				currTeam = userTeamList.get(0);
			} else {
				System.out.println("User has more than 1 team in the league (illegal)!");
			}


			if (currTeam != null) {
				// Check to see if it is currently the team's turn to draft!
				int currentPickInRound = currentLeagueDraftInfo.getCurrentPickInRound();

				if (currentLeagueDraftInfo.getOrder().get(currentPickInRound - 1).getTeamId().getTeamName().equals(currTeam.getTeamId().getTeamName())) {
					// Check if the player that is picked is not already rostered (will not be in list)
					List<PlayerDTO> unrosteredDTOList = rosterRepository
							.getUnrosteredPlayers(userLeague);

					List<PlayerId> unrostered = unrosteredDTOList.stream()
							.map(dto -> new PlayerId(dto.getName(), dto.getPosition()))
							.collect(Collectors.toList());

					System.out.println(unrostered.toString());
					PlayerId reqPlayer = new PlayerId(draftRequest.getPlayerName(), draftRequest.getPlayerPos());
					if (unrostered.contains(reqPlayer)) {
						// Draft player
						Roster draftReqResult = rosterRepository.save(new Roster(
								new RosterId(new League(userLeague), new Player(reqPlayer)),
								currTeam.getTeamId().getTeamName(),
								"BNCH"
						));

						draftSuccess = true;
						currentLeagueDraftInfo.nextPick();
						System.out.println(currentLeagueDraftInfo);
					} else {
						// Invalid draft request
						System.out.println("Invalid draft request (player DNE or is not unrostered).");
					}
				} else {
					System.out.println("It is not this team's turn to draft!");
				}
			}
		} else{
			System.out.println("League ID in draft request DNE!");
		}


		final String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
		return new DraftOutput(draftSuccess, draftRequest.getUser(), draftRequest.getLeague(), draftRequest.getPlayerName(),
				draftRequest.getPlayerPos(), timestamp);
	}

}
