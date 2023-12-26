package com.igexin.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.protobuf.CodedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class a implements e {
    private long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    private b a(Context context, String[] strArr, String str, i iVar) {
        int i;
        String[] strArr2 = strArr;
        String[] a = a(context);
        int length = a.length;
        int i2 = 0;
        ZipFile zipFile = null;
        int i3 = 0;
        while (i3 < length) {
            String str2 = a[i3];
            int i4 = i2;
            while (true) {
                int i5 = i4 + 1;
                i = 5;
                if (i4 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i4 = i5;
                }
            }
            if (zipFile == null) {
                String str3 = str;
                i iVar2 = iVar;
            } else {
                int i6 = i2;
                while (true) {
                    int i7 = i6 + 1;
                    if (i6 < i) {
                        int length2 = strArr2.length;
                        int i8 = i2;
                        while (i8 < length2) {
                            String str4 = "lib" + File.separatorChar + strArr2[i8] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i2] = str4;
                            objArr[1] = str2;
                            iVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                return new b(zipFile, entry);
                            }
                            i8++;
                            i2 = 0;
                        }
                        String str5 = str;
                        i iVar3 = iVar;
                        i6 = i7;
                        i = 5;
                    } else {
                        String str6 = str;
                        i iVar4 = iVar;
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i3++;
            i2 = 0;
        }
        return null;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String[] a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr = new String[(applicationInfo.splitSourceDirs.length + 1)];
        strArr[0] = applicationInfo.sourceDir;
        System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr, 1, applicationInfo.splitSourceDirs.length);
        return strArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.igexin.a.b} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a6 A[SYNTHETIC, Splitter:B:70:0x00a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.io.File r13, com.igexin.a.i r14) {
        /*
            r9 = this;
            r0 = 0
            com.igexin.a.b r10 = r9.a(r10, r11, r12, r14)     // Catch:{ all -> 0x00a3 }
            if (r10 == 0) goto L_0x009a
            r11 = 0
            r1 = r11
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x0089
            java.lang.String r1 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00a0 }
            r4[r11] = r12     // Catch:{ all -> 0x00a0 }
            r14.a((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00a0 }
            boolean r1 = r13.exists()     // Catch:{ IOException -> 0x0087 }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r13.createNewFile()     // Catch:{ IOException -> 0x0087 }
            if (r1 != 0) goto L_0x0026
            goto L_0x0087
        L_0x0026:
            java.util.zip.ZipFile r1 = r10.a     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.util.zip.ZipEntry r4 = r10.b     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.io.InputStream r1 = r1.getInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006e, all -> 0x006a }
            r4.<init>(r13)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006e, all -> 0x006a }
            long r5 = r9.a(r1, r4)     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            java.io.FileDescriptor r7 = r4.getFD()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            r7.sync()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            long r7 = r13.length()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x004d
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a0 }
        L_0x0049:
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a0 }
            goto L_0x0087
        L_0x004d:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a0 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a0 }
            r13.setReadable(r3, r11)     // Catch:{ all -> 0x00a0 }
            r13.setExecutable(r3, r11)     // Catch:{ all -> 0x00a0 }
            r13.setWritable(r3)     // Catch:{ all -> 0x00a0 }
            if (r10 == 0) goto L_0x0067
            java.util.zip.ZipFile r11 = r10.a     // Catch:{ IOException -> 0x0067 }
            if (r11 == 0) goto L_0x0067
            java.util.zip.ZipFile r10 = r10.a     // Catch:{ IOException -> 0x0067 }
            r10.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return
        L_0x0068:
            r11 = move-exception
            goto L_0x006c
        L_0x006a:
            r11 = move-exception
            r4 = r0
        L_0x006c:
            r0 = r1
            goto L_0x0074
        L_0x006e:
            r4 = r0
            goto L_0x007d
        L_0x0070:
            r4 = r0
            goto L_0x0083
        L_0x0072:
            r11 = move-exception
            r4 = r0
        L_0x0074:
            r9.a((java.io.Closeable) r0)     // Catch:{ all -> 0x00a0 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a0 }
            throw r11     // Catch:{ all -> 0x00a0 }
        L_0x007b:
            r1 = r0
            r4 = r1
        L_0x007d:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0049
        L_0x0081:
            r1 = r0
            r4 = r1
        L_0x0083:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0049
        L_0x0087:
            r1 = r2
            goto L_0x0009
        L_0x0089:
            java.lang.String r11 = "FATAL! Couldn't extract the library from the APK!"
            r14.a((java.lang.String) r11)     // Catch:{ all -> 0x00a0 }
            if (r10 == 0) goto L_0x0099
            java.util.zip.ZipFile r11 = r10.a     // Catch:{ IOException -> 0x0099 }
            if (r11 == 0) goto L_0x0099
            java.util.zip.ZipFile r10 = r10.a     // Catch:{ IOException -> 0x0099 }
            r10.close()     // Catch:{ IOException -> 0x0099 }
        L_0x0099:
            return
        L_0x009a:
            com.igexin.a.c r11 = new com.igexin.a.c     // Catch:{ all -> 0x00a0 }
            r11.<init>(r12)     // Catch:{ all -> 0x00a0 }
            throw r11     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r11 = move-exception
            r0 = r10
            goto L_0x00a4
        L_0x00a3:
            r11 = move-exception
        L_0x00a4:
            if (r0 == 0) goto L_0x00af
            java.util.zip.ZipFile r10 = r0.a     // Catch:{ IOException -> 0x00af }
            if (r10 == 0) goto L_0x00af
            java.util.zip.ZipFile r10 = r0.a     // Catch:{ IOException -> 0x00af }
            r10.close()     // Catch:{ IOException -> 0x00af }
        L_0x00af:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.igexin.a.i):void");
    }
}
