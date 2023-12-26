package com.bonree.sdk.bc;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class g {
    private static int a = 1;
    private static int b = 2;

    private g() {
    }

    private static byte[] a(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt != '.' || i == 3 || i2 == 0) {
                    return null;
                }
                bArr[i] = (byte) i3;
                i3 = 0;
                i++;
                i2 = 0;
            } else if (i2 == 3) {
                return null;
            } else {
                if (i2 > 0 && i3 == 0) {
                    return null;
                }
                i2++;
                i3 = (i3 * 10) + (charAt - '0');
                if (i3 > 255) {
                    return null;
                }
            }
        }
        if (i != 3 || i2 == 0) {
            return null;
        }
        bArr[i] = (byte) i3;
        return bArr;
    }

    private static byte[] b(String str) {
        int i;
        byte[] a2;
        byte[] bArr = new byte[16];
        int i2 = -1;
        String[] split = str.split(":", -1);
        int length = split.length - 1;
        if (split[0].length() != 0) {
            i = 0;
        } else if (length <= 0 || split[1].length() != 0) {
            return null;
        } else {
            i = 1;
        }
        if (split[length].length() == 0) {
            if (length - i <= 0 || split[length - 1].length() != 0) {
                return null;
            }
            length--;
        }
        if ((length - i) + 1 > 8) {
            return null;
        }
        int i3 = 0;
        while (true) {
            if (i > length) {
                break;
            }
            if (split[i].length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i3;
            } else if (split[i].indexOf(46) < 0) {
                int i4 = 0;
                while (i4 < split[i].length()) {
                    try {
                        if (Character.digit(split[i].charAt(i4), 16) < 0) {
                            return null;
                        }
                        i4++;
                    } catch (NumberFormatException unused) {
                    }
                }
                int parseInt = Integer.parseInt(split[i], 16);
                if (parseInt > 65535) {
                    break;
                } else if (parseInt < 0) {
                    break;
                } else {
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (parseInt >>> 8);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) parseInt;
                }
            } else if (i < length || i > 6 || (a2 = a(split[i], 1)) == null) {
                return null;
            } else {
                int i6 = 0;
                while (i6 < 4) {
                    bArr[i3] = a2[i6];
                    i6++;
                    i3++;
                }
            }
            i++;
        }
        if (i3 < 16 && i2 < 0) {
            return null;
        }
        if (i2 >= 0) {
            int i7 = (16 - i3) + i2;
            System.arraycopy(bArr, i2, bArr, i7, i3 - i2);
            while (i2 < i7) {
                bArr[i2] = 0;
                i2++;
            }
        }
        return bArr;
        return null;
    }

    private static int[] c(String str, int i) {
        byte[] a2 = a(str, 1);
        if (a2 == null) {
            return null;
        }
        int[] iArr = new int[a2.length];
        for (int i2 = 0; i2 < a2.length; i2++) {
            iArr[i2] = a2[i2] & 255;
        }
        return iArr;
    }

    public static byte[] a(String str, int i) {
        if (i == 1) {
            return a(str);
        }
        if (i == 2) {
            return b(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    private static boolean d(String str) {
        return a(str, 1) != null;
    }

    public static String a(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    private static String a(int[] iArr) {
        return iArr[0] + "." + iArr[1] + "." + iArr[2] + "." + iArr[3];
    }

    private static ca[] a(String str, boolean z) throws UnknownHostException {
        ca[] a2;
        ca[] a3;
        try {
            as asVar = new as(str, 1);
            ca[] a4 = asVar.a();
            if (a4 == null) {
                if (asVar.b() == 4 && (a3 = new as(str, 28).a()) != null) {
                    return a3;
                }
                throw new UnknownHostException("unknown host");
            } else if (!z || (a2 = new as(str, 28).a()) == null) {
                return a4;
            } else {
                ca[] caVarArr = new ca[(a4.length + a2.length)];
                System.arraycopy(a4, 0, caVarArr, 0, a4.length);
                System.arraycopy(a2, 0, caVarArr, a4.length, a2.length);
                return caVarArr;
            }
        } catch (dc unused) {
            throw new UnknownHostException("invalid name");
        }
    }

    private static InetAddress a(String str, ca caVar) throws UnknownHostException {
        InetAddress inetAddress;
        if (caVar instanceof f) {
            inetAddress = ((f) caVar).c_();
        } else {
            inetAddress = ((b) caVar).b_();
        }
        return InetAddress.getByAddress(str, inetAddress.getAddress());
    }

    private static InetAddress e(String str) throws UnknownHostException {
        try {
            return g(str);
        } catch (UnknownHostException unused) {
            return a(str, a(str, false)[0]);
        }
    }

    private static InetAddress[] f(String str) throws UnknownHostException {
        try {
            return new InetAddress[]{g(str)};
        } catch (UnknownHostException unused) {
            ca[] a2 = a(str, true);
            InetAddress[] inetAddressArr = new InetAddress[a2.length];
            for (int i = 0; i < a2.length; i++) {
                inetAddressArr[i] = a(str, a2[i]);
            }
            return inetAddressArr;
        }
    }

    private static InetAddress g(String str) throws UnknownHostException {
        byte[] a2 = a(str, 1);
        if (a2 != null) {
            return InetAddress.getByAddress(str, a2);
        }
        byte[] a3 = a(str, 2);
        if (a3 != null) {
            return InetAddress.getByAddress(str, a3);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static InetAddress b(String str, int i) throws UnknownHostException {
        if (i == 1 || i == 2) {
            byte[] a2 = a(str, i);
            if (a2 != null) {
                return InetAddress.getByAddress(str, a2);
            }
            throw new UnknownHostException("Invalid address: " + str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    private static String b(InetAddress inetAddress) throws UnknownHostException {
        ca[] a2 = new as(cg.a(inetAddress), 12).a();
        if (a2 != null) {
            return ((bs) a2[0]).d().toString();
        }
        throw new UnknownHostException("unknown address");
    }

    public static int a(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int a(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress a(InetAddress inetAddress, int i) {
        int i2;
        int a2 = a(a(inetAddress)) << 3;
        if (i < 0 || i > a2) {
            throw new IllegalArgumentException("invalid mask length");
        } else if (i == a2) {
            return inetAddress;
        } else {
            byte[] address = inetAddress.getAddress();
            int i3 = i / 8;
            int i4 = i3 + 1;
            while (true) {
                if (i4 >= address.length) {
                    break;
                }
                address[i4] = 0;
                i4++;
            }
            byte b2 = 0;
            for (i2 = 0; i2 < i % 8; i2++) {
                b2 |= 1 << (7 - i2);
            }
            address[i3] = (byte) (address[i3] & b2);
            try {
                return InetAddress.getByAddress(address);
            } catch (UnknownHostException unused) {
                throw new IllegalArgumentException("invalid address");
            }
        }
    }

    private static int[] c(String str) {
        byte[] a2 = a(str, 1);
        if (a2 == null) {
            return null;
        }
        int[] iArr = new int[a2.length];
        for (int i = 0; i < a2.length; i++) {
            iArr[i] = a2[i] & 255;
        }
        return iArr;
    }
}
