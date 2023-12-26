package com.bonree.sdk.at;

import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;

public class a {
    private NetWorkStateInfoBean a;
    private int b;

    a(NetWorkStateInfoBean netWorkStateInfoBean) {
        this.b = 0;
        this.a = netWorkStateInfoBean;
    }

    public final NetWorkStateInfoBean a() {
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

    /* access modifiers changed from: package-private */
    public final void a(NetWorkStateInfoBean netWorkStateInfoBean) {
        this.a = netWorkStateInfoBean;
    }

    public a() {
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2) || com.bonree.sdk.bk.a.a(str).a(com.bonree.sdk.bk.a.a(str2)) == 0;
    }
}
