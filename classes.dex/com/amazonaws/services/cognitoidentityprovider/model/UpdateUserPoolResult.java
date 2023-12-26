package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class UpdateUserPoolResult implements Serializable {
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
        if (obj == null || !(obj instanceof UpdateUserPoolResult)) {
            return false;
        }
        UpdateUserPoolResult updateUserPoolResult = (UpdateUserPoolResult) obj;
        return true;
    }
}
