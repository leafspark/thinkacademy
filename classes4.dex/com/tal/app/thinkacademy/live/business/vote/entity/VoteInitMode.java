package com.tal.app.thinkacademy.live.business.vote.entity;

public class VoteInitMode {
    private String commitVote;
    private String getVoteStatistics;

    public String getCommitVote() {
        return this.commitVote;
    }

    public void setCommitVote(String str) {
        this.commitVote = str;
    }

    public String getGetVoteStatistics() {
        return this.getVoteStatistics;
    }

    public void setGetVoteStatistics(String str) {
        this.getVoteStatistics = str;
    }
}
