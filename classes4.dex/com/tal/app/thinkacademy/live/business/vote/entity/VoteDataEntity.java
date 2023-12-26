package com.tal.app.thinkacademy.live.business.vote.entity;

import java.util.Map;

public class VoteDataEntity {
    private String by;
    private String name;
    private Map<String, Map<String, String>> optionsAnswer;
    private String type;

    public Map<String, Map<String, String>> getOptionsAnswer() {
        return this.optionsAnswer;
    }

    public void setOptionsAnswer(Map<String, Map<String, String>> map) {
        this.optionsAnswer = map;
    }

    public String getBy() {
        return this.by;
    }

    public void setBy(String str) {
        this.by = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
