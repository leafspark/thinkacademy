package com.bonree.sdk.az;

import com.bonree.sdk.agent.business.entity.UserInfoBean;

public class a {
    private static Boolean c;
    private UserInfoBean a;
    private int b;

    a(String str, String str2) {
        UserInfoBean userInfoBean = new UserInfoBean();
        this.a = userInfoBean;
        userInfoBean.userId = str;
        this.a.extraInfo = str2;
    }

    /* access modifiers changed from: package-private */
    public final UserInfoBean a() {
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

    public final int d() {
        return this.b;
    }

    public a() {
    }

    public static boolean e() {
        if (c == null) {
            try {
                Class.forName("android.Manifest");
                c = Boolean.TRUE;
            } catch (Exception unused) {
                c = Boolean.FALSE;
            }
        }
        return c.booleanValue();
    }
}
