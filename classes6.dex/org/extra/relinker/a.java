package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import okio.internal._BufferKt;
import org.extra.relinker.c;

public class a implements c.a {

    /* renamed from: org.extra.relinker.a$a  reason: collision with other inner class name */
    private static class C0000a {
        public ZipFile a;
        public ZipEntry b;

        public C0000a(ZipFile zipFile, ZipEntry zipEntry) {
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    private String[] a(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    private C0000a a(Context context, String[] strArr, String str, d dVar) {
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
                d dVar2 = dVar;
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
                            dVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                return new C0000a(zipFile, entry);
                            }
                            i8++;
                            i2 = 0;
                        }
                        String str5 = str;
                        d dVar3 = dVar;
                        i6 = i7;
                        i = 5;
                    } else {
                        String str6 = str;
                        d dVar4 = dVar;
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.extra.relinker.a$a} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009a A[SYNTHETIC, Splitter:B:67:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.io.File r13, org.extra.relinker.d r14) {
        /*
            r9 = this;
            r0 = 0
            org.extra.relinker.a$a r10 = r9.a(r10, r11, r12, r14)     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x008e
            r11 = 0
            r1 = r11
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x0081
            java.lang.String r1 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0094 }
            r4[r11] = r12     // Catch:{ all -> 0x0094 }
            r14.a((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0094 }
            boolean r1 = r13.exists()     // Catch:{ IOException -> 0x007f }
            if (r1 != 0) goto L_0x0025
            boolean r1 = r13.createNewFile()     // Catch:{ IOException -> 0x007f }
            if (r1 != 0) goto L_0x0025
            goto L_0x007f
        L_0x0025:
            java.util.zip.ZipFile r1 = r10.a     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0071, all -> 0x0068 }
            java.util.zip.ZipEntry r4 = r10.b     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0071, all -> 0x0068 }
            java.io.InputStream r1 = r1.getInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0071, all -> 0x0068 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0072, all -> 0x0066 }
            r4.<init>(r13)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0072, all -> 0x0066 }
            long r5 = r9.a(r1, r4)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0073, all -> 0x0063 }
            java.io.FileDescriptor r7 = r4.getFD()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0073, all -> 0x0063 }
            r7.sync()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0073, all -> 0x0063 }
            long r7 = r13.length()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0073, all -> 0x0063 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x004c
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0094 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x0094 }
            goto L_0x007f
        L_0x004c:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0094 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x0094 }
            r13.setReadable(r3, r11)     // Catch:{ all -> 0x0094 }
            r13.setExecutable(r3, r11)     // Catch:{ all -> 0x0094 }
            r13.setWritable(r3)     // Catch:{ all -> 0x0094 }
            java.util.zip.ZipFile r10 = r10.a     // Catch:{ IOException -> 0x0062 }
            if (r10 == 0) goto L_0x0062
            r10.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            return
        L_0x0063:
            r11 = move-exception
            r0 = r4
            goto L_0x006a
        L_0x0066:
            r11 = move-exception
            goto L_0x006a
        L_0x0068:
            r11 = move-exception
            r1 = r0
        L_0x006a:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0094 }
            r9.a((java.io.Closeable) r0)     // Catch:{ all -> 0x0094 }
            throw r11     // Catch:{ all -> 0x0094 }
        L_0x0071:
            r1 = r0
        L_0x0072:
            r4 = r0
        L_0x0073:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0094 }
            goto L_0x007c
        L_0x0077:
            r1 = r0
        L_0x0078:
            r4 = r0
        L_0x0079:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0094 }
        L_0x007c:
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x0094 }
        L_0x007f:
            r1 = r2
            goto L_0x0009
        L_0x0081:
            java.lang.String r11 = "FATAL! Couldn't extract the library from the APK!"
            r14.a((java.lang.String) r11)     // Catch:{ all -> 0x0094 }
            java.util.zip.ZipFile r10 = r10.a     // Catch:{ IOException -> 0x008d }
            if (r10 == 0) goto L_0x008d
            r10.close()     // Catch:{ IOException -> 0x008d }
        L_0x008d:
            return
        L_0x008e:
            org.extra.relinker.b r11 = new org.extra.relinker.b     // Catch:{ all -> 0x0094 }
            r11.<init>(r12)     // Catch:{ all -> 0x0094 }
            throw r11     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r11 = move-exception
            r0 = r10
            goto L_0x0098
        L_0x0097:
            r11 = move-exception
        L_0x0098:
            if (r0 == 0) goto L_0x00a1
            java.util.zip.ZipFile r10 = r0.a     // Catch:{ IOException -> 0x00a1 }
            if (r10 == 0) goto L_0x00a1
            r10.close()     // Catch:{ IOException -> 0x00a1 }
        L_0x00a1:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.extra.relinker.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, org.extra.relinker.d):void");
    }

    private long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[_BufferKt.SEGMENTING_THRESHOLD];
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

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
