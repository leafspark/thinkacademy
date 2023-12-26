package com.adyen.threeds2.internal;

import com.adyen.threeds2.Warning;

public final class j implements Warning {
    private final String a;
    private final String b;
    private final Warning.Severity c;

    public j(String str, String str2, Warning.Severity severity) {
        this.a = str;
        this.b = str2;
        this.c = severity;
    }

    public String getID() {
        return this.a;
    }

    public String getMessage() {
        return this.b;
    }

    public Warning.Severity getSeverity() {
        return this.c;
    }
}
