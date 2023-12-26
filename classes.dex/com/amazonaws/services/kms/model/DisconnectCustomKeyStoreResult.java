package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class DisconnectCustomKeyStoreResult implements Serializable {
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
        if (obj == null || !(obj instanceof DisconnectCustomKeyStoreResult)) {
            return false;
        }
        DisconnectCustomKeyStoreResult disconnectCustomKeyStoreResult = (DisconnectCustomKeyStoreResult) obj;
        return true;
    }
}
