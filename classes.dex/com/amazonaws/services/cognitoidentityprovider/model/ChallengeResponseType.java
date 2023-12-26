package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class ChallengeResponseType implements Serializable {
    private String challengeName;
    private String challengeResponse;

    public String getChallengeName() {
        return this.challengeName;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public ChallengeResponseType withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public void setChallengeName(ChallengeName challengeName2) {
        this.challengeName = challengeName2.toString();
    }

    public ChallengeResponseType withChallengeName(ChallengeName challengeName2) {
        this.challengeName = challengeName2.toString();
        return this;
    }

    public String getChallengeResponse() {
        return this.challengeResponse;
    }

    public void setChallengeResponse(String str) {
        this.challengeResponse = str;
    }

    public ChallengeResponseType withChallengeResponse(String str) {
        this.challengeResponse = str;
        return this;
    }

    public void setChallengeResponse(ChallengeResponse challengeResponse2) {
        this.challengeResponse = challengeResponse2.toString();
    }

    public ChallengeResponseType withChallengeResponse(ChallengeResponse challengeResponse2) {
        this.challengeResponse = challengeResponse2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getChallengeResponse() != null) {
            sb.append("ChallengeResponse: " + getChallengeResponse());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getChallengeName() == null ? 0 : getChallengeName().hashCode()) + 31) * 31;
        if (getChallengeResponse() != null) {
            i = getChallengeResponse().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChallengeResponseType)) {
            return false;
        }
        ChallengeResponseType challengeResponseType = (ChallengeResponseType) obj;
        if ((challengeResponseType.getChallengeName() == null) ^ (getChallengeName() == null)) {
            return false;
        }
        if (challengeResponseType.getChallengeName() != null && !challengeResponseType.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if ((challengeResponseType.getChallengeResponse() == null) ^ (getChallengeResponse() == null)) {
            return false;
        }
        return challengeResponseType.getChallengeResponse() == null || challengeResponseType.getChallengeResponse().equals(getChallengeResponse());
    }
}
