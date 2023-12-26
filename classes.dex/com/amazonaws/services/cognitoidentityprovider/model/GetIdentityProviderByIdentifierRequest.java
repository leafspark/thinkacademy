package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetIdentityProviderByIdentifierRequest extends AmazonWebServiceRequest implements Serializable {
    private String idpIdentifier;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetIdentityProviderByIdentifierRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getIdpIdentifier() {
        return this.idpIdentifier;
    }

    public void setIdpIdentifier(String str) {
        this.idpIdentifier = str;
    }

    public GetIdentityProviderByIdentifierRequest withIdpIdentifier(String str) {
        this.idpIdentifier = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getIdpIdentifier() != null) {
            sb.append("IdpIdentifier: " + getIdpIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31;
        if (getIdpIdentifier() != null) {
            i = getIdpIdentifier().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityProviderByIdentifierRequest)) {
            return false;
        }
        GetIdentityProviderByIdentifierRequest getIdentityProviderByIdentifierRequest = (GetIdentityProviderByIdentifierRequest) obj;
        if ((getIdentityProviderByIdentifierRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (getIdentityProviderByIdentifierRequest.getUserPoolId() != null && !getIdentityProviderByIdentifierRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null) ^ (getIdpIdentifier() == null)) {
            return false;
        }
        return getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null || getIdentityProviderByIdentifierRequest.getIdpIdentifier().equals(getIdpIdentifier());
    }
}
