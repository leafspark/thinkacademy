package com.didi.hummer.adapter.http;

import java.io.Serializable;
import java.util.Map;

public class HttpResponse<T> implements Serializable {
    public T data;
    public Error error = new Error(0, (String) null);
    public Map<String, String> header;
    public String message;
    public int status;

    public static class Error implements Serializable {
        public int code;
        public String msg;

        public Error(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public String toString() {
            return "Error{code=" + this.code + ", msg='" + this.msg + '\'' + '}';
        }
    }
}
