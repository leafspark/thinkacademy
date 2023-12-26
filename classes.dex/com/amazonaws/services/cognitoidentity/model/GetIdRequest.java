package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetIdRequest extends AmazonWebServiceRequest implements Serializable {
    private String accountId;
    private String identityPoolId;
    private Map<String, String> logins;

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public GetIdRequest withAccountId(String str) {
        this.accountId = str;
        return this;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public GetIdRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public GetIdRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public GetIdRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccountId() != null) {
            sb.append("AccountId: " + getAccountId() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getAccountId() == null ? 0 : getAccountId().hashCode()) + 31) * 31) + (getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode())) * 31;
        if (getLogins() != null) {
            i = getLogins().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdRequest)) {
            return false;
        }
        GetIdRequest getIdRequest = (GetIdRequest) obj;
        if ((getIdRequest.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        if (getIdRequest.getAccountId() != null && !getIdRequest.getAccountId().equals(getAccountId())) {
            return false;
        }
        if ((getIdRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getIdRequest.getIdentityPoolId() != null && !getIdRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getIdRequest.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        return getIdRequest.getLogins() == null || getIdRequest.getLogins().equals(getLogins());
    }
}
