package com.bonree.sdk.am;

import com.bonree.sdk.agent.business.entity.DeviceStateInfoBean;

public class k {
    private DeviceStateInfoBean a;
    private int b;

    k(DeviceStateInfoBean deviceStateInfoBean) {
        this.b = 0;
        this.a = deviceStateInfoBean;
    }

    public final void a(DeviceStateInfoBean deviceStateInfoBean) {
        this.a = deviceStateInfoBean;
    }

    public final DeviceStateInfoBean a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.b++;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        int i = this.b - 1;
        this.b = i;
        return i;
    }

    private int a(int i) {
        int i2 = this.b - i;
        this.b = i2;
        return i2;
    }

    public k() {
    }

    public static StringBuilder a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb;
    }
}
