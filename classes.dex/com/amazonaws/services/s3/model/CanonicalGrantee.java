package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class CanonicalGrantee implements Grantee, Serializable {
    private String displayName = null;
    private String id = null;

    public String getTypeIdentifier() {
        return "id";
    }

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public void setIdentifier(String str) {
        this.id = str;
    }

    public String getIdentifier() {
        return this.id;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.id.equals(((CanonicalGrantee) obj).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }
}
