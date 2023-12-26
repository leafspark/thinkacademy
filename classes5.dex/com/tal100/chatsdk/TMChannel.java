package com.tal100.chatsdk;

import java.util.List;

public class TMChannel implements ITMChannel {
    public long mNativeChannel;
    public long mNativeListener;

    /* access modifiers changed from: package-private */
    public native int nativeKickoutOtherClient(String str);

    /* access modifiers changed from: package-private */
    public native int nativeSendChannelBinaryData(String[] strArr, byte[] bArr, int i, long[] jArr);

    /* access modifiers changed from: package-private */
    public native int nativeSendChannelData(String[] strArr, String str, long[] jArr);

    public TMChannel(long j, long j2) {
        this.mNativeChannel = j;
        this.mNativeListener = j2;
    }

    public int sendData(List<String> list, String str, long[] jArr) {
        String[] strArr;
        if (str == null) {
            return 11;
        }
        if (list == null || list.isEmpty()) {
            strArr = new String[0];
        } else {
            strArr = new String[list.size()];
            list.toArray(strArr);
        }
        return nativeSendChannelData(strArr, str, jArr);
    }

    public int sendBinaryData(List<String> list, byte[] bArr, int i, long[] jArr) {
        String[] strArr;
        if (list == null || list.isEmpty() || bArr == null) {
            return 11;
        }
        if (list == null || list.isEmpty()) {
            strArr = new String[0];
        } else {
            strArr = new String[list.size()];
            list.toArray(strArr);
        }
        return nativeSendChannelBinaryData(strArr, bArr, i, jArr);
    }

    public int kickoutOtherClient(String str) {
        if (str == null) {
            return 11;
        }
        return nativeKickoutOtherClient(str);
    }
}
