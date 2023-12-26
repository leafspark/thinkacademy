package com.amazonaws.services.s3.model;

public enum GroupGrantee implements Grantee {
    AllUsers("http://acs.amazonaws.com/groups/global/AllUsers"),
    AuthenticatedUsers("http://acs.amazonaws.com/groups/global/AuthenticatedUsers"),
    LogDelivery("http://acs.amazonaws.com/groups/s3/LogDelivery");
    
    private String groupUri;

    public String getTypeIdentifier() {
        return "uri";
    }

    private GroupGrantee(String str) {
        this.groupUri = str;
    }

    public String getIdentifier() {
        return this.groupUri;
    }

    public void setIdentifier(String str) {
        throw new UnsupportedOperationException("Group grantees have preset identifiers that cannot be modified.");
    }

    public String toString() {
        return "GroupGrantee [" + this.groupUri + "]";
    }

    public static GroupGrantee parseGroupGrantee(String str) {
        for (GroupGrantee groupGrantee : values()) {
            if (groupGrantee.groupUri.equals(str)) {
                return groupGrantee;
            }
        }
        return null;
    }
}
