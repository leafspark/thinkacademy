package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class GetFederationTokenResult implements Serializable {
    private Credentials credentials;
    private FederatedUser federatedUser;
    private Integer packedPolicySize;

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public GetFederationTokenResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public FederatedUser getFederatedUser() {
        return this.federatedUser;
    }

    public void setFederatedUser(FederatedUser federatedUser2) {
        this.federatedUser = federatedUser2;
    }

    public GetFederationTokenResult withFederatedUser(FederatedUser federatedUser2) {
        this.federatedUser = federatedUser2;
        return this;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public GetFederationTokenResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getFederatedUser() != null) {
            sb.append("FederatedUser: " + getFederatedUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31) + (getFederatedUser() == null ? 0 : getFederatedUser().hashCode())) * 31;
        if (getPackedPolicySize() != null) {
            i = getPackedPolicySize().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenResult)) {
            return false;
        }
        GetFederationTokenResult getFederationTokenResult = (GetFederationTokenResult) obj;
        if ((getFederationTokenResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (getFederationTokenResult.getCredentials() != null && !getFederationTokenResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((getFederationTokenResult.getFederatedUser() == null) ^ (getFederatedUser() == null)) {
            return false;
        }
        if (getFederationTokenResult.getFederatedUser() != null && !getFederationTokenResult.getFederatedUser().equals(getFederatedUser())) {
            return false;
        }
        if ((getFederationTokenResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        return getFederationTokenResult.getPackedPolicySize() == null || getFederationTokenResult.getPackedPolicySize().equals(getPackedPolicySize());
    }
}
