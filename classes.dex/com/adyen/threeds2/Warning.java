package com.adyen.threeds2;

public interface Warning {

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    String getID();

    String getMessage();

    Severity getSeverity();
}
