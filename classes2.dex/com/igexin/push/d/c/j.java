package com.igexin.push.d.c;

public class j extends c {
    public byte a;
    public Object b;

    public void a(byte[] bArr) {
    }

    public byte[] c() {
        byte b2 = this.a;
        byte[] bytes = (b2 == 1 || b2 == 2 || (b2 != 3 && (b2 == 4 || b2 == 5))) ? ((String) this.b).getBytes() : null;
        if (bytes == null) {
            return null;
        }
        byte[] bArr = new byte[(bytes.length + 2)];
        bArr[0] = this.a;
        bArr[1] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 2, bytes.length);
        return bArr;
    }
}
