package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class AbortIncompleteMultipartUpload implements Serializable {
    private int daysAfterInitiation;

    public int getDaysAfterInitiation() {
        return this.daysAfterInitiation;
    }

    public void setDaysAfterInitiation(int i) {
        this.daysAfterInitiation = i;
    }

    public AbortIncompleteMultipartUpload withDaysAfterInitiation(int i) {
        setDaysAfterInitiation(i);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.daysAfterInitiation == ((AbortIncompleteMultipartUpload) obj).daysAfterInitiation) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.daysAfterInitiation;
    }

    /* access modifiers changed from: protected */
    public AbortIncompleteMultipartUpload clone() throws CloneNotSupportedException {
        try {
            return (AbortIncompleteMultipartUpload) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}
