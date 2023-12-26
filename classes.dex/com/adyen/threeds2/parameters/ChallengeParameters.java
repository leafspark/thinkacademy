package com.adyen.threeds2.parameters;

import android.content.Context;

public final class ChallengeParameters {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static String getEmbeddedRequestorAppURL(Context context) {
        return "adyen3ds2://" + context.getPackageName();
    }

    public String get3DSServerTransactionID() {
        return this.a;
    }

    public String getAcsRefNumber() {
        return this.c;
    }

    public String getAcsSignedContent() {
        return this.d;
    }

    public String getAcsTransactionID() {
        return this.b;
    }

    public String getThreeDSRequestorAppURL() {
        return this.e;
    }

    public void set3DSServerTransactionID(String str) {
        this.a = str;
    }

    public void setAcsRefNumber(String str) {
        this.c = str;
    }

    public void setAcsSignedContent(String str) {
        this.d = str;
    }

    public void setAcsTransactionID(String str) {
        this.b = str;
    }

    public void setThreeDSRequestorAppURL(String str) {
        this.e = str;
    }
}
