package com.wcappel.ffbackend.misc;


import com.wcappel.ffbackend.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DraftOrder {
    private int round;
    private final int maxRounds = 12;
    private List<Team> order;
    private int currentPickInRound;
    private boolean finished;

    protected DraftOrder(List<Team> leagueTeams) {
        this.round = 1;
        this.currentPickInRound = 1;
        this.finished = false;
        this.order = new ArrayList<Team>(leagueTeams);
        Collections.shuffle(this.order);
    }

    public int getRound() {
        return round;
    }

    public List<Team> getOrder() {
        return order;
    }

    public int getCurrentPickInRound() {
        return currentPickInRound;
    }

    public void generateDraftOrder(List<Team> leagueTeams) {
       this.order = leagueTeams;
    }

    public void flipOrder() {
        Collections.reverse(this.order);
    }

    public int nextPick() {
        if (this.currentPickInRound < this.order.size()) {
            this.currentPickInRound++;
        } else{
            this.nextRound();
        }
        return this.currentPickInRound;
    }

    public void nextRound() {
        if (this.round < this.maxRounds) {
            this.round++;
            this.currentPickInRound = 1;
            this.flipOrder();
        } else {
            this.finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "DraftOrder{" +
                "round=" + round +
                ", maxRounds=" + maxRounds +
                ", order=" + order +
                ", currentPickInRound=" + currentPickInRound +
                '}';
    }
}
