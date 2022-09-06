package com.wcappel.ffbackend.misc;

public class DraftOutput {

	private boolean draftSuccess;
	private String user;
	private String league;
	private String playerName;
	private String playerPos;
	private String timestamp;

	public DraftOutput(final boolean draftSuccess, String user, final String league,
					   final String playerName, String playerPos, final String timestamp) {
		this.draftSuccess = draftSuccess;
		this.user = user;
		this.league = league;
		this.playerName = playerName;
		this.playerPos = playerPos;
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public String getLeague() {
		return league;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerPos() {
		return playerPos;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean isDraftSuccess() {
		return draftSuccess;
	}
}
