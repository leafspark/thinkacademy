package com.igexin.b.a.c.a;

import com.igexin.sdk.IUserLoggerInterface;

public class a implements b {
    private IUserLoggerInterface a;
    private final StringBuffer b = new StringBuffer();

    private void b() {
        if (this.b.length() > 0) {
            if (this.b.toString().contains("\n")) {
                for (String str : this.b.toString().split("\n")) {
                    IUserLoggerInterface iUserLoggerInterface = this.a;
                    if (iUserLoggerInterface != null) {
                        iUserLoggerInterface.log("[GT-PUSH] " + str);
                    }
                }
            } else {
                this.a.log("[GT-PUSH] " + this.b.toString());
            }
            this.b.setLength(0);
        }
    }

    public void a() {
        if (this.a != null) {
            b();
        }
    }

    public void a(IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface != null) {
            this.a = iUserLoggerInterface;
        }
    }

    public void a(String str) {
        if (this.a != null) {
            b();
            IUserLoggerInterface iUserLoggerInterface = this.a;
            iUserLoggerInterface.log("[GT-PUSH] " + str);
            return;
        }
        b(str);
    }

    public void b(String str) {
        if (this.b.length() + str.length() < 5120) {
            StringBuffer stringBuffer = this.b;
            stringBuffer.append(str);
            stringBuffer.append("\n");
        } else if (this.b.length() <= 5120 && this.b.length() + 135 > 5120) {
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
            stringBuffer2.append("\n");
        }
    }
}
