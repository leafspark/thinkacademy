package com.coloros.ocs.base.common.constant;

public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 11;
    public static final int AUTHCODE_EXPECTED = 1004;
    public static final int AUTHCODE_INVALID = 1007;
    public static final int AUTHCODE_RECYCLE = 1006;
    public static final int AUTHENTICATE_FAIL = 1002;
    public static final int AUTHENTICATE_SUCCESS = 1001;
    public static final int CANCELED = 6;
    public static final int CAPABILITY_EXCEPTION = 1008;
    public static final int CLIENT_UNKNOWN = 12;
    public static final int CONNECTED = 1;
    public static final int CONNECTED_SUCCESS_UNBIND = 5;
    public static final int CONNECTING = 2;
    public static final int CONNECT_FAILED = 3;
    public static final int DISCONNECT = 4;
    public static final int INTERNAL_ERROR = 7;
    public static final int INTERRUPTED = 9;
    public static final int RECONNECTING = 14;
    public static final int SERVICE_ABNORMAL_EXIT = 13;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TASK_NULL = 8;
    public static final int TIMEOUT = 10;
    public static final int TIME_EXPIRED = 1003;
    public static final int VERSION_INCOMPATIBLE = 1005;

    public static String getStatusCodeString(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
                return "CONNECTED";
            case 2:
                return "CONNECTING";
            case 3:
                return "CONNECT_FAILED";
            case 4:
                return "DISCONNECT";
            case 5:
                return "SUCCESS_UNBIND";
            case 6:
                return "CANCELED";
            case 7:
                return "INTERNAL_ERROR";
            case 8:
                return "TASK_NULL";
            case 9:
                return "INTERRUPTED";
            case 10:
                return "TIMEOUT";
            case 11:
                return "API_NOT_CONNECTED";
            case 12:
                return "CLIENT_UNKNOWN";
            case 13:
                return "SERVICE_ABNORMAL_EXIT";
            case 14:
                return "RECONNECTING";
            default:
                switch (i) {
                    case 1001:
                        return "AUTHENTICATE_SUCCESS";
                    case 1002:
                        return "AUTHENTICATE_FAIL";
                    case 1003:
                        return "TIME_EXPIRED";
                    case AUTHCODE_EXPECTED /*1004*/:
                        return "AUTHCODE_EXPECTED";
                    case VERSION_INCOMPATIBLE /*1005*/:
                        return "VERSION_INCOMPATIBLE";
                    case AUTHCODE_RECYCLE /*1006*/:
                        return "AUTHCODE_RECYCLE";
                    case AUTHCODE_INVALID /*1007*/:
                        return "AUTHCODE_INVALID";
                    case CAPABILITY_EXCEPTION /*1008*/:
                        return "CAPABILITY_EXCEPTION";
                    default:
                        StringBuilder sb = new StringBuilder(32);
                        sb.append("unknown status code: ");
                        sb.append(i);
                        return sb.toString();
                }
        }
    }

    protected CommonStatusCodes() {
    }
}
