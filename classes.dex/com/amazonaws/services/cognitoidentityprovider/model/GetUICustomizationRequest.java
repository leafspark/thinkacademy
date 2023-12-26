package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetUICustomizationRequest extends AmazonWebServiceRequest implements Serializable {
    private String clientId;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetUICustomizationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public GetUICustomizationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31;
        if (getClientId() != null) {
            i = getClientId().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUICustomizationRequest)) {
            return false;
        }
        GetUICustomizationRequest getUICustomizationRequest = (GetUICustomizationRequest) obj;
        if ((getUICustomizationRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (getUICustomizationRequest.getUserPoolId() != null && !getUICustomizationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((getUICustomizationRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        return getUICustomizationRequest.getClientId() == null || getUICustomizationRequest.getClientId().equals(getClientId());
    }
}
