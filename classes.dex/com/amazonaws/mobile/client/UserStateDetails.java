package com.amazonaws.mobile.client;

import java.util.Map;

public class UserStateDetails {
    private final Map<String, String> details;
    private Exception exception;
    private final UserState userState;

    public UserStateDetails(UserState userState2, Map<String, String> map) {
        this.userState = userState2;
        this.details = map;
    }

    public UserState getUserState() {
        return this.userState;
    }

    public Map<String, String> getDetails() {
        return this.details;
    }

    /* access modifiers changed from: protected */
    public void setException(Exception exc) {
        this.exception = exc;
    }

    /* access modifiers changed from: protected */
    public Exception getException() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UserStateDetails)) {
            return super.equals(obj);
        }
        UserStateDetails userStateDetails = (UserStateDetails) obj;
        if (!this.userState.equals(userStateDetails.userState)) {
            return false;
        }
        Map<String, String> map = userStateDetails.details;
        Map<String, String> map2 = this.details;
        if (map == map2) {
            return true;
        }
        if (map2 == null) {
            return false;
        }
        return map2.equals(map);
    }
}
