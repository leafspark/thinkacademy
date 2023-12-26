package com.tal100.chatsdk;

import java.util.List;

public interface ITMChannel {
    int kickoutOtherClient(String str);

    int sendBinaryData(List<String> list, byte[] bArr, int i, long[] jArr);

    int sendData(List<String> list, String str, long[] jArr);
}
