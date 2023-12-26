package com.tal.app.thinkacademy.live.business.vote.entity.body;

public class InteractVoteStatusBody {
    private String interactionId;
    private int planId;

    public InteractVoteStatusBody(int i, String str) {
        this.planId = i;
        this.interactionId = str;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }
}
