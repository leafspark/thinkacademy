package com.bonree.sdk.av;

import java.util.Objects;

public final class e {
    private String a;
    private String b;
    private String c;
    private String d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            return a(this.c, eVar.c) && a(this.d, eVar.d);
        }
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c, this.d});
    }

    public final String toString() {
        return "UserInfoRequest{appId='" + this.a + '\'' + ", deviceId='" + this.b + '\'' + ", userId='" + this.c + '\'' + ", extraInfo='" + this.d + '\'' + '}';
    }
}
