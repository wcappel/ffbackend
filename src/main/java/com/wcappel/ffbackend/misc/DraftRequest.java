package com.wcappel.ffbackend.misc;

public class DraftRequest {
	private String user;
	private String league;
	private String playerName;
	private String playerPos;

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

	@Override
	public String toString() {
		return "HelloMessage{" +
				"user='" + user + '\'' +
				", league='" + league + '\'' +
				", playerName='" + playerName + '\'' +
				", playerPos='" + playerPos + '\'' +
				'}';
	}
}
