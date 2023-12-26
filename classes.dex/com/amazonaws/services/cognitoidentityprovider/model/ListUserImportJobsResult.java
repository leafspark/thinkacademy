package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUserImportJobsResult implements Serializable {
    private String paginationToken;
    private List<UserImportJobType> userImportJobs;

    public List<UserImportJobType> getUserImportJobs() {
        return this.userImportJobs;
    }

    public void setUserImportJobs(Collection<UserImportJobType> collection) {
        if (collection == null) {
            this.userImportJobs = null;
        } else {
            this.userImportJobs = new ArrayList(collection);
        }
    }

    public ListUserImportJobsResult withUserImportJobs(UserImportJobType... userImportJobTypeArr) {
        if (getUserImportJobs() == null) {
            this.userImportJobs = new ArrayList(userImportJobTypeArr.length);
        }
        for (UserImportJobType add : userImportJobTypeArr) {
            this.userImportJobs.add(add);
        }
        return this;
    }

    public ListUserImportJobsResult withUserImportJobs(Collection<UserImportJobType> collection) {
        setUserImportJobs(collection);
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public ListUserImportJobsResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserImportJobs() != null) {
            sb.append("UserImportJobs: " + getUserImportJobs() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserImportJobs() == null ? 0 : getUserImportJobs().hashCode()) + 31) * 31;
        if (getPaginationToken() != null) {
            i = getPaginationToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserImportJobsResult)) {
            return false;
        }
        ListUserImportJobsResult listUserImportJobsResult = (ListUserImportJobsResult) obj;
        if ((listUserImportJobsResult.getUserImportJobs() == null) ^ (getUserImportJobs() == null)) {
            return false;
        }
        if (listUserImportJobsResult.getUserImportJobs() != null && !listUserImportJobsResult.getUserImportJobs().equals(getUserImportJobs())) {
            return false;
        }
        if ((listUserImportJobsResult.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listUserImportJobsResult.getPaginationToken() == null || listUserImportJobsResult.getPaginationToken().equals(getPaginationToken());
    }
}
