package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class SetUserMFAPreferenceResult implements Serializable {
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
        if (obj == null || !(obj instanceof SetUserMFAPreferenceResult)) {
            return false;
        }
        SetUserMFAPreferenceResult setUserMFAPreferenceResult = (SetUserMFAPreferenceResult) obj;
        return true;
    }
}
