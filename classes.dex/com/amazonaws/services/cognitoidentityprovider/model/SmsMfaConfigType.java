package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class SmsMfaConfigType implements Serializable {
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public SmsMfaConfigType withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public SmsMfaConfigType withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsAuthenticationMessage() != null) {
            sb.append("SmsAuthenticationMessage: " + getSmsAuthenticationMessage() + ",");
        }
        if (getSmsConfiguration() != null) {
            sb.append("SmsConfiguration: " + getSmsConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getSmsAuthenticationMessage() == null) {
            i = 0;
        } else {
            i = getSmsAuthenticationMessage().hashCode();
        }
        int i3 = (i + 31) * 31;
        if (getSmsConfiguration() != null) {
            i2 = getSmsConfiguration().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsMfaConfigType)) {
            return false;
        }
        SmsMfaConfigType smsMfaConfigType = (SmsMfaConfigType) obj;
        if ((smsMfaConfigType.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (smsMfaConfigType.getSmsAuthenticationMessage() != null && !smsMfaConfigType.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((smsMfaConfigType.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        return smsMfaConfigType.getSmsConfiguration() == null || smsMfaConfigType.getSmsConfiguration().equals(getSmsConfiguration());
    }
}
