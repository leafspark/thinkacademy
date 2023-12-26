package com.didi.hummer.context;

import java.io.Serializable;

public class HummerError implements Serializable {
    public int errCode;
    public String errMsg;

    public HummerError(int i, String str) {
        this.errCode = i;
        this.errMsg = str;
    }
}
