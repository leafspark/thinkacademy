package com.tal.app.thinkacademy.live.business.vote.entity;

import java.util.Map;

public class VoteArrayF {
    private long sendTime;
    private VoteBean vote_f;

    public long getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public VoteBean getVote() {
        return this.vote_f;
    }

    public void setVote(VoteBean voteBean) {
        this.vote_f = voteBean;
    }

    public static class VoteBean {
        private boolean hascorrect;
        private String interactId;
        private Map<String, Map<String, String>> options;
        private String pattern;
        private boolean pub;

        public String getPattern() {
            return this.pattern;
        }

        public void setPattern(String str) {
            this.pattern = str;
        }

        public String getInteractId() {
            return this.interactId;
        }

        public void setInteractId(String str) {
            this.interactId = str;
        }

        public boolean isPub() {
            return this.pub;
        }

        public void setPub(boolean z) {
            this.pub = z;
        }

        public boolean isHascorrect() {
            return this.hascorrect;
        }

        public void setHascorrect(boolean z) {
            this.hascorrect = z;
        }

        public Map<String, Map<String, String>> getOptions() {
            return this.options;
        }

        public void setOptions(Map<String, Map<String, String>> map) {
            this.options = map;
        }
    }
}
