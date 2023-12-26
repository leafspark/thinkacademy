package com.tal.app.thinkacademy.live.business.vote.entity;

import java.util.Map;

public class VoteArray {
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

    public String toString() {
        return "VoteArray{pattern='" + this.pattern + '\'' + ", interactId='" + this.interactId + '\'' + ", options=" + this.options + ", pub=" + this.pub + ", hascorrect=" + this.hascorrect + '}';
    }
}
