package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class ConfirmDeviceResult implements Serializable {
    private Boolean userConfirmationNecessary;

    public Boolean isUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public Boolean getUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public void setUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
    }

    public ConfirmDeviceResult withUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserConfirmationNecessary() != null) {
            sb.append("UserConfirmationNecessary: " + getUserConfirmationNecessary());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getUserConfirmationNecessary() == null) {
            i = 0;
        } else {
            i = getUserConfirmationNecessary().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmDeviceResult)) {
            return false;
        }
        ConfirmDeviceResult confirmDeviceResult = (ConfirmDeviceResult) obj;
        if ((confirmDeviceResult.getUserConfirmationNecessary() == null) ^ (getUserConfirmationNecessary() == null)) {
            return false;
        }
        return confirmDeviceResult.getUserConfirmationNecessary() == null || confirmDeviceResult.getUserConfirmationNecessary().equals(getUserConfirmationNecessary());
    }
}
