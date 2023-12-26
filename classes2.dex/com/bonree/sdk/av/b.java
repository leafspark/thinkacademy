package com.bonree.sdk.av;

import java.util.Objects;

public class b {
    public String a;
    public String b;
    public String c;
    public String d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            return a(this.c, bVar.c) && a(this.d, bVar.d);
        }
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c, this.d});
    }

    public String toString() {
        return "UserInfoRequest{appId='" + this.a + '\'' + ", deviceId='" + this.b + '\'' + ", userId='" + this.c + '\'' + ", extraInfo='" + this.d + '\'' + '}';
    }
}
