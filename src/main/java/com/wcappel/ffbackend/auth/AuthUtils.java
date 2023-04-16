package com.wcappel.ffbackend.auth;

import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.model.User;
import com.wcappel.ffbackend.repository.LeagueRepository;
import com.wcappel.ffbackend.repository.UserRepository;

public class AuthUtils {
    public static User getUserInfo(ReturnedTokenInfo tokenInfo, UserRepository userRepository) {
        return userRepository.getUserByEmail(tokenInfo.getEmail());
    }

    public static boolean checkUserHasAccessToLeague(ReturnedTokenInfo tokenInfo,
                                              int league,
                                              LeagueRepository leagueRepository,
                                              UserRepository userRepository) {
        String currentUsername = userRepository.getUserByEmail(tokenInfo.getEmail()).getUsername();
        return leagueRepository.checkUserHasTeamInLeague(league, currentUsername);
    }

    public static boolean checkUserIsCommissioner(ReturnedTokenInfo tokenInfo,
                                                  int league,
                                                  LeagueRepository leagueRepository,
                                                  UserRepository userRepository) {
        String currentUsername = userRepository.getUserByEmail(tokenInfo.getEmail()).getUsername();
        return currentUsername.equals(leagueRepository.getLeagueCommissioner(league));
    }

    public static boolean checkUserIsTeamOwner(ReturnedTokenInfo tokenInfo,
                                               Team team,
                                               UserRepository userRepository) {
        String currentUsername = userRepository.getUserByEmail(tokenInfo.getEmail()).getUsername();
        return currentUsername.equals(team.getOwner().getUsername());
    }
}
