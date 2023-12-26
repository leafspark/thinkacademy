package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class AdminSetUserMFAPreferenceRequest extends AmazonWebServiceRequest implements Serializable {
    private SMSMfaSettingsType sMSMfaSettings;
    private SoftwareTokenMfaSettingsType softwareTokenMfaSettings;
    private String userPoolId;
    private String username;

    public SMSMfaSettingsType getSMSMfaSettings() {
        return this.sMSMfaSettings;
    }

    public void setSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
    }

    public AdminSetUserMFAPreferenceRequest withSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
        return this;
    }

    public SoftwareTokenMfaSettingsType getSoftwareTokenMfaSettings() {
        return this.softwareTokenMfaSettings;
    }

    public void setSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
    }

    public AdminSetUserMFAPreferenceRequest withSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminSetUserMFAPreferenceRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminSetUserMFAPreferenceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSMSMfaSettings() != null) {
            sb.append("SMSMfaSettings: " + getSMSMfaSettings() + ",");
        }
        if (getSoftwareTokenMfaSettings() != null) {
            sb.append("SoftwareTokenMfaSettings: " + getSoftwareTokenMfaSettings() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getSMSMfaSettings() == null ? 0 : getSMSMfaSettings().hashCode()) + 31) * 31;
        if (getSoftwareTokenMfaSettings() == null) {
            i = 0;
        } else {
            i = getSoftwareTokenMfaSettings().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31;
        if (getUserPoolId() != null) {
            i2 = getUserPoolId().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminSetUserMFAPreferenceRequest)) {
            return false;
        }
        AdminSetUserMFAPreferenceRequest adminSetUserMFAPreferenceRequest = (AdminSetUserMFAPreferenceRequest) obj;
        if ((adminSetUserMFAPreferenceRequest.getSMSMfaSettings() == null) ^ (getSMSMfaSettings() == null)) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getSMSMfaSettings() != null && !adminSetUserMFAPreferenceRequest.getSMSMfaSettings().equals(getSMSMfaSettings())) {
            return false;
        }
        if ((adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() == null) ^ (getSoftwareTokenMfaSettings() == null)) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null && !adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings().equals(getSoftwareTokenMfaSettings())) {
            return false;
        }
        if ((adminSetUserMFAPreferenceRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getUsername() != null && !adminSetUserMFAPreferenceRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminSetUserMFAPreferenceRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return adminSetUserMFAPreferenceRequest.getUserPoolId() == null || adminSetUserMFAPreferenceRequest.getUserPoolId().equals(getUserPoolId());
    }
}
