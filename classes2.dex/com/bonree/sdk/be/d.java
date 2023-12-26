package com.bonree.sdk.be;

import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public final class d implements f {
    private final PrintWriter f;
    private int g;
    private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private Date i = new Date();

    public final void a(String str) {
    }

    public d(String str) {
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            this.f = new PrintWriter(new FileOutputStream(str));
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public final void a(String str, Object... objArr) {
        if (this.g == 5) {
            a("debug", str, objArr);
        }
    }

    private void a(String str, String str2, Object... objArr) {
        String str3;
        if (objArr != null) {
            try {
                if (objArr.length > 0 && (objArr[0] instanceof f.a) && objArr[0] == f.a.JSON) {
                    Object[] objArr2 = new Object[(objArr.length - 1)];
                    System.arraycopy(objArr, 1, objArr2, 0, objArr.length - 1);
                    try {
                        if (objArr2[0] != null) {
                            objArr2[0] = ad.h(objArr2[0].toString());
                        }
                        objArr = objArr2;
                    } catch (Throwable th) {
                        th = th;
                        objArr = objArr2;
                        str3 = "write log format error: format is:" + str2 + "args: " + Arrays.toString(objArr) + "   error is:" + th.toString();
                        str = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
                        this.i.setTime(System.currentTimeMillis());
                        this.f.write(this.h.format(this.i) + " [" + str + "] " + str3 + "\n");
                        this.f.flush();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str3 = "write log format error: format is:" + str2 + "args: " + Arrays.toString(objArr) + "   error is:" + th.toString();
                str = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
                this.i.setTime(System.currentTimeMillis());
                this.f.write(this.h.format(this.i) + " [" + str + "] " + str3 + "\n");
                this.f.flush();
            }
        }
        str3 = String.format(str2, objArr);
        this.i.setTime(System.currentTimeMillis());
        try {
            this.f.write(this.h.format(this.i) + " [" + str + "] " + str3 + "\n");
            this.f.flush();
        } catch (Throwable th3) {
            this.f.write(this.h.format(this.i) + " [" + str + "] " + th3.getMessage() + "\n");
            this.f.flush();
        }
    }

    public final void b(String str, Object... objArr) {
        if (this.g >= 4) {
            a("verbose", str, objArr);
        }
    }

    public final void c(String str, Object... objArr) {
        if (this.g >= 3) {
            a("info", str, objArr);
        }
    }

    public final void d(String str, Object... objArr) {
        if (this.g >= 2) {
            a("warn", str, objArr);
        }
    }

    public final void e(String str, Object... objArr) {
        if (this.g > 0) {
            a(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str, objArr);
        }
    }

    public final void a(String str, Throwable th) {
        if (this.g > 0) {
            a(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str, new Object[0]);
            if (th != null) {
                th.printStackTrace(this.f);
            }
            this.f.flush();
        }
    }

    public final int a() {
        return this.g;
    }

    public final void a(int i2) {
        if (i2 <= 5 && i2 > 0) {
            this.g = i2;
            c("File Log Level: " + i2, new Object[0]);
        }
    }
}
