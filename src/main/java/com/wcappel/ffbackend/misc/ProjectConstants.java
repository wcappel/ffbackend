package com.wcappel.ffbackend.misc;

import java.util.Arrays;
import java.util.List;

public final class ProjectConstants {
    private ProjectConstants() {}

    public static final List<String> ROSTER_POSITIONS = Arrays.asList("BNCH", "QB", "FLEX", "TE", "RB1", "RB2", "WR1", "WR2");

    public static final String MESSAGE_DRAFT_START = "The draft has started!";
    public static final String MESSAGE_DRAFT_END = "The draft has ended.";

    public static String CURRENT_PICK_MESSAGE(int pickNum, int roundNum, String pickingTeam) {
        return String.format("It is now Pick #%s in Round #%s, held by %s.", pickNum, roundNum, pickingTeam);
    }

    public static String PICK_RESULT_MESSAGE(String pickingTeam, String playerName, String playerPos) {
        return String.format("%s have chosen %s, %s.", pickingTeam, playerName, playerPos);
    }
}
