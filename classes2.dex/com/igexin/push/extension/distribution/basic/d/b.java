package com.igexin.push.extension.distribution.basic.d;

import android.content.ContentValues;
import com.igexin.push.extension.distribution.basic.c.e;
import com.igexin.push.extension.distribution.basic.e.a;

public class b {
    public static b a;
    private static final String b = ("EXT-" + b.class.getName());
    private static a c = null;

    public static b a() {
        if (a == null) {
            a = new b();
            c = new a(e.a);
        }
        return a;
    }

    public void a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put("value", str);
        c.a("extconfig", (String) null, contentValues);
    }

    public void a(long j) {
        e.i = j;
        a(6, String.valueOf(j));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r4 = this;
            r0 = 0
            com.igexin.push.extension.distribution.basic.e.a r1 = com.igexin.push.extension.distribution.basic.c.e.e     // Catch:{ Exception -> 0x0065, all -> 0x005e }
            java.lang.String r2 = "select key, value from extconfig order by key"
            android.database.Cursor r0 = r1.a((java.lang.String) r2, (java.lang.String[]) r0)     // Catch:{ Exception -> 0x0065, all -> 0x005e }
            if (r0 == 0) goto L_0x005b
        L_0x000b:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x0065, all -> 0x005e }
            if (r1 == 0) goto L_0x005b
            java.lang.String r1 = "key"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x0065, all -> 0x005e }
            int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x0065, all -> 0x005e }
            r2 = 11
            java.lang.String r3 = "value"
            if (r1 == r2) goto L_0x0033
            r2 = 12
            if (r1 == r2) goto L_0x0033
            r2 = 14
            if (r1 != r2) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            int r2 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x000b }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x000b }
            goto L_0x004a
        L_0x0033:
            int r2 = r0.getColumnIndex(r3)     // Catch:{ Exception -> 0x000b }
            byte[] r2 = r0.getBlob(r2)     // Catch:{ Exception -> 0x000b }
            if (r2 == 0) goto L_0x0041
            byte[] r2 = com.igexin.b.b.a.c(r2)     // Catch:{ Exception -> 0x000b }
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            goto L_0x000b
        L_0x0044:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x000b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x000b }
            r2 = r3
        L_0x004a:
            r3 = 4
            if (r1 == r3) goto L_0x0058
            r3 = 6
            if (r1 == r3) goto L_0x0051
            goto L_0x000b
        L_0x0051:
            long r1 = java.lang.Long.parseLong(r2)     // Catch:{  }
            com.igexin.push.extension.distribution.basic.c.e.i = r1     // Catch:{  }
            goto L_0x000b
        L_0x0058:
            com.igexin.push.extension.distribution.basic.c.e.d = r2     // Catch:{  }
            goto L_0x000b
        L_0x005b:
            if (r0 == 0) goto L_0x006a
            goto L_0x0067
        L_0x005e:
            r1 = move-exception
            if (r0 == 0) goto L_0x0064
            r0.close()
        L_0x0064:
            throw r1
        L_0x0065:
            if (r0 == 0) goto L_0x006a
        L_0x0067:
            r0.close()
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.d.b.b():void");
    }
}
