package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class AdminSetUserPasswordResult implements Serializable {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "{" + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminSetUserPasswordResult)) {
            return false;
        }
        AdminSetUserPasswordResult adminSetUserPasswordResult = (AdminSetUserPasswordResult) obj;
        return true;
    }
}
