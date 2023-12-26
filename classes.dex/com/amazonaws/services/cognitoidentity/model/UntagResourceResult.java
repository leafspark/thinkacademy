package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

public class UntagResourceResult implements Serializable {
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
        if (obj == null || !(obj instanceof UntagResourceResult)) {
            return false;
        }
        UntagResourceResult untagResourceResult = (UntagResourceResult) obj;
        return true;
    }
}
