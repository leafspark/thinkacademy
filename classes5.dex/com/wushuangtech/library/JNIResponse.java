package com.wushuangtech.library;

public class JNIResponse {
    protected Result mResult;

    public JNIResponse(Result result) {
        this.mResult = result;
    }

    public Result getResult() {
        return this.mResult;
    }

    public enum Result {
        SUCCESS(0),
        ERR_CONF_TIMEOUT(1),
        ERR_CONF_INVALIDPARAM(208),
        ERR_CONF_AUTHENTICATION(209),
        ERR_SERVER_CONNFAIL(301),
        ERR_SERVER_NOSERVERAVAILABLE(302),
        ERR_CONNECTION_CHANGED_BANNED_BY_SERVER(304),
        ERR_CONF_UNKNOWN(6);
        
        private int val;

        private Result(int i) {
            this.val = i;
        }

        public int value() {
            return this.val;
        }

        public static Result fromInt(int i) {
            if (i == 0) {
                return SUCCESS;
            }
            if (i == 1) {
                return ERR_CONF_TIMEOUT;
            }
            if (i == 208) {
                return ERR_CONF_INVALIDPARAM;
            }
            if (i == 209) {
                return ERR_CONF_AUTHENTICATION;
            }
            if (i == 301) {
                return ERR_SERVER_CONNFAIL;
            }
            if (i == 302) {
                return ERR_SERVER_NOSERVERAVAILABLE;
            }
            if (i != 304) {
                return ERR_CONF_UNKNOWN;
            }
            return ERR_CONNECTION_CHANGED_BANNED_BY_SERVER;
        }
    }
}
