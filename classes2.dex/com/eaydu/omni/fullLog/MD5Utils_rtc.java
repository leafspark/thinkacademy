package com.eaydu.omni.fullLog;

import com.igexin.assist.sdk.AssistPushConsts;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils_rtc {
    public static String toMD5(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16);
            for (int i = 0; i < 32 - bigInteger.length(); i++) {
                bigInteger = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE + bigInteger;
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("没有md5这个算法！");
        }
    }
}
