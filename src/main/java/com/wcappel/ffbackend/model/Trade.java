package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.TradeId;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;

@Entity @Table(name="Trades") public class Trade {
    @JsonUnwrapped @EmbeddedId TradeId tradeId;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="initiatedBy", referencedColumnName = "Team_name")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Team initiatedBy;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="proposedTo", referencedColumnName = "Team_name")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Team proposedTo;
    @Column(name="User_approved") private boolean userApproved;
    @Column(name="Comm_approved") private boolean commApproved;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="initP1Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="initP1Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster initP1;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="initP2Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="initP2Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster initP2;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="initP3Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="initP3Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster initP3;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="propP1Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="propP1Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster propP1;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="propP2Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="propP2Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster propP2;
    @ManyToOne @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="propP3Name", referencedColumnName = "Player_name")),
            @JoinColumnOrFormula(column = @JoinColumn(name="propP3Pos", referencedColumnName = "Position")),
            @JoinColumnOrFormula(formula = @JoinFormula(value="League", referencedColumnName = "League"))
    }) private Roster propP3;

    public Trade() {}

    public Trade(TradeId tradeId, Team initiatedBy, Team proposedTo, boolean userApproved, boolean commApproved, Roster initP1, Roster initP2, Roster initP3, Roster propP1, Roster propP2, Roster propP3) {
        this.tradeId = tradeId;
        this.initiatedBy = initiatedBy;
        this.proposedTo = proposedTo;
        this.userApproved = userApproved;
        this.commApproved = commApproved;
        this.initP1 = initP1;
        this.initP2 = initP2;
        this.initP3 = initP3;
        this.propP1 = propP1;
        this.propP2 = propP2;
        this.propP3 = propP3;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", initiatedBy=" + initiatedBy +
                ", proposedTo=" + proposedTo +
                ", userApproved=" + userApproved +
                ", commApproved=" + commApproved +
                ", initP1=" + initP1 +
                ", initP2=" + initP2 +
                ", initP3=" + initP3 +
                ", propP1=" + propP1 +
                ", propP2=" + propP2 +
                ", propP3=" + propP3 +
                '}';
    }

    public TradeId getTradeId() {
        return tradeId;
    }

    public void setTradeId(TradeId tradeId) {
        this.tradeId = tradeId;
    }

    public Team getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(Team initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public Team getProposedTo() {
        return proposedTo;
    }

    public void setProposedTo(Team proposedTo) {
        this.proposedTo = proposedTo;
    }

    public boolean isUserApproved() {
        return userApproved;
    }

    public void setUserApproved(boolean userApproved) {
        this.userApproved = userApproved;
    }

    public boolean isCommApproved() {
        return commApproved;
    }

    public void setCommApproved(boolean commApproved) {
        this.commApproved = commApproved;
    }

    public Roster getInitP1() {
        return initP1;
    }

    public void setInitP1(Roster initP1) {
        this.initP1 = initP1;
    }

    public Roster getInitP2() {
        return initP2;
    }

    public void setInitP2(Roster initP2) {
        this.initP2 = initP2;
    }

    public Roster getInitP3() {
        return initP3;
    }

    public void setInitP3(Roster initP3) {
        this.initP3 = initP3;
    }

    public Roster getPropP1() {
        return propP1;
    }

    public void setPropP1(Roster propP1) {
        this.propP1 = propP1;
    }

    public Roster getPropP2() {
        return propP2;
    }

    public void setPropP2(Roster propP2) {
        this.propP2 = propP2;
    }

    public Roster getPropP3() {
        return propP3;
    }

    public void setPropP3(Roster propP3) {
        this.propP3 = propP3;
    }
}
