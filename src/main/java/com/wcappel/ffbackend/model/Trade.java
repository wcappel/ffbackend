package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.TradeId;

import javax.persistence.*;

@Entity @Table(name="Trades") public class Trade {
    @JsonUnwrapped @EmbeddedId TradeId tradeId;
    @JoinColumn(name="Initiated_by", referencedColumnName = "Team_name")
        String initiatedBy;
    @JoinColumn(name="Proposed_to", referencedColumnName = "Team_name")
        String proposedTo;
    @Column(name="User_approved") private boolean userApproved;
    @Column(name="Comm_approved") private boolean commApproved;
    @JoinColumn(name="Init_p1_name", referencedColumnName = "Player_name", nullable = false)
        String initP1Name;
    @JoinColumn(name="Init_p1_pos", referencedColumnName = "Position", nullable = false)
        String initP1Pos;
    @JoinColumn(name="Init_p2_name", referencedColumnName = "Player_name")
        String initP2Name;
    @JoinColumn(name="Init_p2_pos", referencedColumnName = "Position")
        String initP2Pos;
    @JoinColumn(name="Init_p3_name", referencedColumnName = "Player_name")
        String initP3Name;
    @JoinColumn(name="Init_p3_pos", referencedColumnName = "Position")
        String initP3Pos;
    @JoinColumn(name="Prop_p1_name", referencedColumnName = "Player_name", nullable = false)
        String propP1Name;
    @JoinColumn(name="Prop_p1_pos", referencedColumnName = "Position", nullable = false)
        String propP1Pos;
    @JoinColumn(name="Prop_p2_name", referencedColumnName = "Player_name")
        String propP2Name;
    @JoinColumn(name="Prop_p2_pos", referencedColumnName = "Position")
        String propP2Pos;
    @JoinColumn(name="Prop_p3_name", referencedColumnName = "Player_name")
        String propP3Name;
    @JoinColumn(name="Prop_p3_pos", referencedColumnName = "Position")
        String propP3Pos;

    public Trade() {}

    public Trade(TradeId tradeId, String initiatedBy, String proposedTo, boolean userApproved,
                 boolean commApproved, String initP1Name, String initP1Pos, String initP2Name,
                 String initP2Pos, String initP3Name, String initP3Pos, String propP1Name, String propP1Pos,
                 String propP2Name, String propP2Pos, String propP3Name, String propP3Pos) {
        this.tradeId = tradeId;
        this.initiatedBy = initiatedBy;
        this.proposedTo = proposedTo;
        this.userApproved = userApproved;
        this.commApproved = commApproved;
        this.initP1Name = initP1Name;
        this.initP1Pos = initP1Pos;
        this.initP2Name = initP2Name;
        this.initP2Pos = initP2Pos;
        this.initP3Name = initP3Name;
        this.initP3Pos = initP3Pos;
        this.propP1Name = propP1Name;
        this.propP1Pos = propP1Pos;
        this.propP2Name = propP2Name;
        this.propP2Pos = propP2Pos;
        this.propP3Name = propP3Name;
        this.propP3Pos = propP3Pos;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", initiatedBy='" + initiatedBy + '\'' +
                ", proposedTo='" + proposedTo + '\'' +
                ", userApproved=" + userApproved +
                ", commApproved=" + commApproved +
                ", initP1Name='" + initP1Name + '\'' +
                ", initP1Pos='" + initP1Pos + '\'' +
                ", initP2Name='" + initP2Name + '\'' +
                ", initP2Pos='" + initP2Pos + '\'' +
                ", initP3Name='" + initP3Name + '\'' +
                ", initP3Pos='" + initP3Pos + '\'' +
                ", propP1Name='" + propP1Name + '\'' +
                ", propP1Pos='" + propP1Pos + '\'' +
                ", propP2Name='" + propP2Name + '\'' +
                ", propP2Pos='" + propP2Pos + '\'' +
                ", propP3Name='" + propP3Name + '\'' +
                ", propP3Pos='" + propP3Pos + '\'' +
                '}';
    }

    public TradeId getTradeId() {
        return tradeId;
    }

    public void setTradeId(TradeId tradeId) {
        this.tradeId = tradeId;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getProposedTo() {
        return proposedTo;
    }

    public void setProposedTo(String proposedTo) {
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

    public String getInitP1Name() {
        return initP1Name;
    }

    public void setInitP1Name(String initP1Name) {
        this.initP1Name = initP1Name;
    }

    public String getInitP1Pos() {
        return initP1Pos;
    }

    public void setInitP1Pos(String initP1Pos) {
        this.initP1Pos = initP1Pos;
    }

    public String getInitP2Name() {
        return initP2Name;
    }

    public void setInitP2Name(String initP2Name) {
        this.initP2Name = initP2Name;
    }

    public String getInitP2Pos() {
        return initP2Pos;
    }

    public void setInitP2Pos(String initP2Pos) {
        this.initP2Pos = initP2Pos;
    }

    public String getInitP3Name() {
        return initP3Name;
    }

    public void setInitP3Name(String initP3Name) {
        this.initP3Name = initP3Name;
    }

    public String getInitP3Pos() {
        return initP3Pos;
    }

    public void setInitP3Pos(String initP3Pos) {
        this.initP3Pos = initP3Pos;
    }

    public String getPropP1Name() {
        return propP1Name;
    }

    public void setPropP1Name(String propP1Name) {
        this.propP1Name = propP1Name;
    }

    public String getPropP1Pos() {
        return propP1Pos;
    }

    public void setPropP1Pos(String propP1Pos) {
        this.propP1Pos = propP1Pos;
    }

    public String getPropP2Name() {
        return propP2Name;
    }

    public void setPropP2Name(String propP2Name) {
        this.propP2Name = propP2Name;
    }

    public String getPropP2Pos() {
        return propP2Pos;
    }

    public void setPropP2Pos(String propP2Pos) {
        this.propP2Pos = propP2Pos;
    }

    public String getPropP3Name() {
        return propP3Name;
    }

    public void setPropP3Name(String propP3Name) {
        this.propP3Name = propP3Name;
    }

    public String getPropP3Pos() {
        return propP3Pos;
    }

    public void setPropP3Pos(String propP3Pos) {
        this.propP3Pos = propP3Pos;
    }
}
