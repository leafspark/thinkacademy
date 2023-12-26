package com.igexin.push.core.d;

import android.os.IBinder;
import android.os.IInterface;

public class h implements IInterface {
    private IBinder a;
    private String b;

    private h(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    static h a(IBinder iBinder, String str) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
        return queryLocalInterface instanceof h ? (h) queryLocalInterface : new h(iBinder, str);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.recycle();
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r3 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            android.os.Parcel r1 = android.os.Parcel.obtain()
            java.lang.String r2 = r3.b     // Catch:{ all -> 0x0036 }
            r0.writeInterfaceToken(r2)     // Catch:{ all -> 0x0036 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x0016
            r0.writeString(r4)     // Catch:{ all -> 0x0036 }
        L_0x0016:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x001f
            r0.writeString(r5)     // Catch:{ all -> 0x0036 }
        L_0x001f:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x0028
            r0.writeString(r6)     // Catch:{ all -> 0x0036 }
        L_0x0028:
            android.os.IBinder r4 = r3.a     // Catch:{ all -> 0x0036 }
            r5 = 0
            r4.transact(r7, r0, r1, r5)     // Catch:{ all -> 0x0036 }
            r1.readException()     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r1.readString()     // Catch:{ all -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r0.recycle()     // Catch:{ Exception -> 0x003c }
            r1.recycle()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            java.lang.String r4 = ""
        L_0x003e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.d.h.a(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
    }

    public IBinder asBinder() {
        return this.a;
    }
}
