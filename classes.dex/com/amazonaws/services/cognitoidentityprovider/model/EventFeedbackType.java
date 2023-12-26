package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

public class EventFeedbackType implements Serializable {
    private Date feedbackDate;
    private String feedbackValue;
    private String provider;

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public EventFeedbackType withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public EventFeedbackType withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public EventFeedbackType withProvider(String str) {
        this.provider = str;
        return this;
    }

    public Date getFeedbackDate() {
        return this.feedbackDate;
    }

    public void setFeedbackDate(Date date) {
        this.feedbackDate = date;
    }

    public EventFeedbackType withFeedbackDate(Date date) {
        this.feedbackDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue() + ",");
        }
        if (getProvider() != null) {
            sb.append("Provider: " + getProvider() + ",");
        }
        if (getFeedbackDate() != null) {
            sb.append("FeedbackDate: " + getFeedbackDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getFeedbackValue() == null ? 0 : getFeedbackValue().hashCode()) + 31) * 31) + (getProvider() == null ? 0 : getProvider().hashCode())) * 31;
        if (getFeedbackDate() != null) {
            i = getFeedbackDate().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventFeedbackType)) {
            return false;
        }
        EventFeedbackType eventFeedbackType = (EventFeedbackType) obj;
        if ((eventFeedbackType.getFeedbackValue() == null) ^ (getFeedbackValue() == null)) {
            return false;
        }
        if (eventFeedbackType.getFeedbackValue() != null && !eventFeedbackType.getFeedbackValue().equals(getFeedbackValue())) {
            return false;
        }
        if ((eventFeedbackType.getProvider() == null) ^ (getProvider() == null)) {
            return false;
        }
        if (eventFeedbackType.getProvider() != null && !eventFeedbackType.getProvider().equals(getProvider())) {
            return false;
        }
        if ((eventFeedbackType.getFeedbackDate() == null) ^ (getFeedbackDate() == null)) {
            return false;
        }
        return eventFeedbackType.getFeedbackDate() == null || eventFeedbackType.getFeedbackDate().equals(getFeedbackDate());
    }
}
