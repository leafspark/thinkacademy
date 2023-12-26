package com.amazonaws.services.s3.model;

public class Grant {
    private Grantee grantee = null;
    private Permission permission = null;

    public Grant(Grantee grantee2, Permission permission2) {
        this.grantee = grantee2;
        this.permission = permission2;
    }

    public Grantee getGrantee() {
        return this.grantee;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public int hashCode() {
        Grantee grantee2 = this.grantee;
        int i = 0;
        int hashCode = ((grantee2 == null ? 0 : grantee2.hashCode()) + 31) * 31;
        Permission permission2 = this.permission;
        if (permission2 != null) {
            i = permission2.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee2 = this.grantee;
        if (grantee2 == null) {
            if (grant.grantee != null) {
                return false;
            }
        } else if (!grantee2.equals(grant.grantee)) {
            return false;
        }
        return this.permission == grant.permission;
    }

    public String toString() {
        return "Grant [grantee=" + this.grantee + ", permission=" + this.permission + "]";
    }
}
