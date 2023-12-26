package com.bonree.sdk.f;

import com.bonree.sdk.bb.f;
import com.bonree.sdk.be.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

final class g {
    private final File a;

    g(String str) {
        File file = new File(str);
        this.a = file;
        if (!file.exists() && !file.mkdirs()) {
            a.a().e("upload local dir mk failed!", new Object[0]);
        }
    }

    private boolean a(String str, String str2) {
        try {
            return f.a(new File(this.a, str).getAbsolutePath(), str2);
        } catch (IOException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.io.File a() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.io.File r0 = r3.b()     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r2 = r0.exists()     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0026
            boolean r2 = r0.isDirectory()     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0015
            goto L_0x0026
        L_0x0015:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0024
            int r2 = r0.length     // Catch:{ all -> 0x0028 }
            if (r2 > 0) goto L_0x001f
            goto L_0x0024
        L_0x001f:
            r1 = 0
            r0 = r0[r1]     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return r0
        L_0x0024:
            monitor-exit(r3)
            return r1
        L_0x0026:
            monitor-exit(r3)
            return r1
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.g.a():java.io.File");
    }

    /* access modifiers changed from: package-private */
    public final File b() {
        if (!this.a.exists() || !this.a.isDirectory()) {
            return null;
        }
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(String str) {
        boolean delete;
        delete = new File(this.a, str).delete();
        com.bonree.sdk.be.f fVar = com.bonree.sdk.d.a.a;
        fVar.a("del " + str + " is " + delete);
        return delete;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str, Object obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(this.a, str)));
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Throwable unused) {
        }
    }

    static Object a(File file) throws IOException, ClassNotFoundException {
        if (file == null) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object readObject = objectInputStream.readObject();
        objectInputStream.close();
        return readObject;
    }
}
