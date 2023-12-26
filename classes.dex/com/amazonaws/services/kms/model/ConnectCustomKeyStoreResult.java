package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class ConnectCustomKeyStoreResult implements Serializable {
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
        if (obj == null || !(obj instanceof ConnectCustomKeyStoreResult)) {
            return false;
        }
        ConnectCustomKeyStoreResult connectCustomKeyStoreResult = (ConnectCustomKeyStoreResult) obj;
        return true;
    }
}
