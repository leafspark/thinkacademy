package com.igexin.push.core.bean;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.push.core.d;

public class k extends BaseAction {
    private String a;
    private boolean b;
    private boolean c;
    private String d;

    private String d() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.g.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public String c() {
        String d2;
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        String str3 = this.a;
        if (this.b) {
            if (str3.indexOf("?") > 0) {
                sb2 = new StringBuilder();
                sb2.append(str3);
                str2 = "&cid=";
            } else {
                sb2 = new StringBuilder();
                sb2.append(str3);
                str2 = "?cid=";
            }
            sb2.append(str2);
            sb2.append(d.u);
            str3 = sb2.toString();
        }
        if (!this.c || (d2 = d()) == null) {
            return str3;
        }
        if (str3.indexOf("?") > 0) {
            sb = new StringBuilder();
            sb.append(str3);
            str = "&nettype=";
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            str = "?nettype=";
        }
        sb.append(str);
        sb.append(d2);
        return sb.toString();
    }
}
