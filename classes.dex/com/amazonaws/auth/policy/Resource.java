package com.amazonaws.auth.policy;

public class Resource {
    private final String resource;

    public Resource(String str) {
        this.resource = str;
    }

    public String getId() {
        return this.resource;
    }
}
