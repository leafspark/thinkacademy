package com.amazonaws;

public enum Protocol {
    HTTP("http"),
    HTTPS("https");
    
    private final String protocol;

    private Protocol(String str) {
        this.protocol = str;
    }

    public String toString() {
        return this.protocol;
    }
}
