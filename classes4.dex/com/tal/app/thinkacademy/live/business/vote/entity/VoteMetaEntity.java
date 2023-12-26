package com.tal.app.thinkacademy.live.business.vote.entity;

import java.util.List;

public class VoteMetaEntity {
    private int bizId;
    private String interactionId;
    private List<OptionsBean> options;
    private int planId;
    private int voteType;

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getVoteType() {
        return this.voteType;
    }

    public void setVoteType(int i) {
        this.voteType = i;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public List<OptionsBean> getOptions() {
        return this.options;
    }

    public void setOptions(List<OptionsBean> list) {
        this.options = list;
    }

    public static class OptionsBean {
        private boolean isAnswer;
        private String option;

        public String getOption() {
            return this.option;
        }

        public void setOption(String str) {
            this.option = str;
        }

        public boolean isIsAnswer() {
            return this.isAnswer;
        }

        public void setIsAnswer(boolean z) {
            this.isAnswer = z;
        }
    }
}
