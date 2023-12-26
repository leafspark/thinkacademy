package com.tal.app.thinkacademy.live.business.vote.entity;

import java.io.Serializable;

public class VoteStatusBean implements Serializable {
    public boolean interactState;
    public String option;
    public int userId;
    public boolean voteState;

    public String toString() {
        return "VoteStatusBean{userId=" + this.userId + ", option='" + this.option + '\'' + ", voteState=" + this.voteState + ", interactState=" + this.interactState + '}';
    }
}
