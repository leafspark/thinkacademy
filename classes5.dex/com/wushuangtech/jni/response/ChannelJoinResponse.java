package com.wushuangtech.jni.response;

import com.wushuangtech.library.JNIResponse;

public class ChannelJoinResponse extends JNIResponse {
    private final String mChannelName;
    private final int mRole;
    private final long mUid;

    public ChannelJoinResponse(JNIResponse.Result result, String str, long j, int i) {
        super(result);
        this.mChannelName = str;
        this.mUid = j;
        this.mRole = i;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public long getUid() {
        return this.mUid;
    }

    public int getRole() {
        return this.mRole;
    }
}
