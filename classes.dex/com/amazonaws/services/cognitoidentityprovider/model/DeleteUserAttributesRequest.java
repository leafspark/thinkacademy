package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private List<String> userAttributeNames;

    public List<String> getUserAttributeNames() {
        return this.userAttributeNames;
    }

    public void setUserAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.userAttributeNames = null;
        } else {
            this.userAttributeNames = new ArrayList(collection);
        }
    }

    public DeleteUserAttributesRequest withUserAttributeNames(String... strArr) {
        if (getUserAttributeNames() == null) {
            this.userAttributeNames = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.userAttributeNames.add(add);
        }
        return this;
    }

    public DeleteUserAttributesRequest withUserAttributeNames(Collection<String> collection) {
        setUserAttributeNames(collection);
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public DeleteUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributeNames() != null) {
            sb.append("UserAttributeNames: " + getUserAttributeNames() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserAttributeNames() == null ? 0 : getUserAttributeNames().hashCode()) + 31) * 31;
        if (getAccessToken() != null) {
            i = getAccessToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserAttributesRequest)) {
            return false;
        }
        DeleteUserAttributesRequest deleteUserAttributesRequest = (DeleteUserAttributesRequest) obj;
        if ((deleteUserAttributesRequest.getUserAttributeNames() == null) ^ (getUserAttributeNames() == null)) {
            return false;
        }
        if (deleteUserAttributesRequest.getUserAttributeNames() != null && !deleteUserAttributesRequest.getUserAttributeNames().equals(getUserAttributeNames())) {
            return false;
        }
        if ((deleteUserAttributesRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        return deleteUserAttributesRequest.getAccessToken() == null || deleteUserAttributesRequest.getAccessToken().equals(getAccessToken());
    }
}
