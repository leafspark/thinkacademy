package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class GetUserPoolMfaConfigResult implements Serializable {
    private String mfaConfiguration;
    private SmsMfaConfigType smsMfaConfiguration;
    private SoftwareTokenMfaConfigType softwareTokenMfaConfiguration;

    public SmsMfaConfigType getSmsMfaConfiguration() {
        return this.smsMfaConfiguration;
    }

    public void setSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
    }

    public GetUserPoolMfaConfigResult withSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
        return this;
    }

    public SoftwareTokenMfaConfigType getSoftwareTokenMfaConfiguration() {
        return this.softwareTokenMfaConfiguration;
    }

    public void setSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
    }

    public GetUserPoolMfaConfigResult withSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
        return this;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public GetUserPoolMfaConfigResult withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public GetUserPoolMfaConfigResult withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsMfaConfiguration() != null) {
            sb.append("SmsMfaConfiguration: " + getSmsMfaConfiguration() + ",");
        }
        if (getSoftwareTokenMfaConfiguration() != null) {
            sb.append("SoftwareTokenMfaConfiguration: " + getSoftwareTokenMfaConfiguration() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getSmsMfaConfiguration() == null ? 0 : getSmsMfaConfiguration().hashCode()) + 31) * 31;
        if (getSoftwareTokenMfaConfiguration() == null) {
            i = 0;
        } else {
            i = getSoftwareTokenMfaConfiguration().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getMfaConfiguration() != null) {
            i2 = getMfaConfiguration().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserPoolMfaConfigResult)) {
            return false;
        }
        GetUserPoolMfaConfigResult getUserPoolMfaConfigResult = (GetUserPoolMfaConfigResult) obj;
        if ((getUserPoolMfaConfigResult.getSmsMfaConfiguration() == null) ^ (getSmsMfaConfiguration() == null)) {
            return false;
        }
        if (getUserPoolMfaConfigResult.getSmsMfaConfiguration() != null && !getUserPoolMfaConfigResult.getSmsMfaConfiguration().equals(getSmsMfaConfiguration())) {
            return false;
        }
        if ((getUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() == null) ^ (getSoftwareTokenMfaConfiguration() == null)) {
            return false;
        }
        if (getUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() != null && !getUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration().equals(getSoftwareTokenMfaConfiguration())) {
            return false;
        }
        if ((getUserPoolMfaConfigResult.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        return getUserPoolMfaConfigResult.getMfaConfiguration() == null || getUserPoolMfaConfigResult.getMfaConfiguration().equals(getMfaConfiguration());
    }
}
