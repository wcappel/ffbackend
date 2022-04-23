package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable public class TradeId implements Serializable {
    @Column(name="Trade_id", nullable = false) @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int tradeId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = League.class) @JoinColumn(name="League")
        private League league;

    public TradeId() {}

    public TradeId(int tradeId, League league) {
        this.tradeId = tradeId;
        this.league = league;
    }

    @Override
    public String toString() {
        return "TradeId{" +
                "tradeId=" + tradeId +
                ", league=" + league +
                '}';
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
