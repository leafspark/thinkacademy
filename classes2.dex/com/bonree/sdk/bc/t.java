package com.bonree.sdk.bc;

import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class t {
    private static int f = 1024;
    private static String g = ".gz";
    private byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;

    public t(byte[] bArr) {
        this.a = bArr;
        this.b = 0;
        this.c = bArr.length;
        this.d = -1;
        this.e = -1;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c - this.b;
    }

    private void e(int i) throws Cdo {
        if (i > b()) {
            throw new Cdo("end of input");
        }
    }

    public final void a(int i) {
        int length = this.a.length;
        int i2 = this.b;
        if (i <= length - i2) {
            this.c = i2 + i;
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public final void c() {
        this.c = this.a.length;
    }

    public final int d() {
        return this.c;
    }

    public final void b(int i) {
        if (i <= this.a.length) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public final void c(int i) {
        byte[] bArr = this.a;
        if (i < bArr.length) {
            this.b = i;
            this.c = bArr.length;
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of input");
    }

    public final void e() {
        this.d = this.b;
        this.e = this.c;
    }

    public final void f() {
        int i = this.d;
        if (i >= 0) {
            this.b = i;
            this.c = this.e;
            this.d = -1;
            this.e = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public final int g() throws Cdo {
        e(1);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final int h() throws Cdo {
        e(2);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        this.b = i2 + 1;
        return ((bArr[i] & 255) << 8) + (bArr[i2] & 255);
    }

    public final long i() throws Cdo {
        e(4);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = i2 + 1;
        this.b = i3;
        int i4 = i3 + 1;
        this.b = i4;
        this.b = i4 + 1;
        return (((long) (bArr[i] & 255)) << 24) + ((long) ((bArr[i2] & 255) << 16)) + ((long) ((bArr[i3] & 255) << 8)) + ((long) (bArr[i4] & 255));
    }

    public final void a(byte[] bArr, int i, int i2) throws Cdo {
        e(i2);
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final byte[] d(int i) throws Cdo {
        e(i);
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, this.b, bArr, 0, i);
        this.b += i;
        return bArr;
    }

    public final byte[] j() {
        int b2 = b();
        byte[] bArr = new byte[b2];
        System.arraycopy(this.a, this.b, bArr, 0, b2);
        this.b += b2;
        return bArr;
    }

    public final byte[] k() throws Cdo {
        e(1);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return d(bArr[i] & 255);
    }

    public t() {
    }

    public static byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[PictureFileUtils.KB];
        while (true) {
            int read = inputStream.read(bArr, 0, PictureFileUtils.KB);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    public static byte[] b(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[PictureFileUtils.KB];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, PictureFileUtils.KB);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }
}
