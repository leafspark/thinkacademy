package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class AdminConfirmSignUpResult implements Serializable {
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
        if (obj == null || !(obj instanceof AdminConfirmSignUpResult)) {
            return false;
        }
        AdminConfirmSignUpResult adminConfirmSignUpResult = (AdminConfirmSignUpResult) obj;
        return true;
    }
}
