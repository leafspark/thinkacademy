package com.alibaba.fastjson.serializer;

public class ClobSeriliazer implements ObjectSerializer {
    public static final ClobSeriliazer instance = new ClobSeriliazer();

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        throw new com.alibaba.fastjson.JSONException("read string from reader error", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        throw new java.io.IOException("write clob error", r3);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:6:0x0013] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r3, java.lang.Object r4, java.lang.Object r5, java.lang.reflect.Type r6, int r7) throws java.io.IOException {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0006
            r3.writeNull()     // Catch:{ SQLException -> 0x0034 }
            return
        L_0x0006:
            java.sql.Clob r4 = (java.sql.Clob) r4     // Catch:{ SQLException -> 0x0034 }
            java.io.Reader r4 = r4.getCharacterStream()     // Catch:{ SQLException -> 0x0034 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0034 }
            r5.<init>()     // Catch:{ SQLException -> 0x0034 }
            r6 = 2048(0x800, float:2.87E-42)
            char[] r7 = new char[r6]     // Catch:{ Exception -> 0x002b }
        L_0x0015:
            r0 = 0
            int r1 = r4.read(r7, r0, r6)     // Catch:{ Exception -> 0x002b }
            if (r1 >= 0) goto L_0x0027
            java.lang.String r5 = r5.toString()     // Catch:{ SQLException -> 0x0034 }
            r4.close()     // Catch:{ SQLException -> 0x0034 }
            r3.write((java.lang.String) r5)     // Catch:{ SQLException -> 0x0034 }
            return
        L_0x0027:
            r5.append(r7, r0, r1)     // Catch:{ Exception -> 0x002b }
            goto L_0x0015
        L_0x002b:
            r3 = move-exception
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ SQLException -> 0x0034 }
            java.lang.String r5 = "read string from reader error"
            r4.<init>(r5, r3)     // Catch:{ SQLException -> 0x0034 }
            throw r4     // Catch:{ SQLException -> 0x0034 }
        L_0x0034:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "write clob error"
            r4.<init>(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ClobSeriliazer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }
}
