package com.bonree.sdk.br;

import com.bonree.sdk.bk.a;
import com.igexin.assist.sdk.AssistPushConsts;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class g {
    private static final Pattern a = Pattern.compile("\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z");
    private static final Pattern b = Pattern.compile("(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))");
    private static /* synthetic */ boolean c = true;

    public static Inet4Address a(CharSequence charSequence) {
        try {
            InetAddress byName = InetAddress.getByName(charSequence.toString());
            if (byName instanceof Inet4Address) {
                return (Inet4Address) byName;
            }
            throw new IllegalArgumentException();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Inet6Address b(CharSequence charSequence) {
        try {
            InetAddress byName = InetAddress.getByName(charSequence.toString());
            if (byName instanceof Inet6Address) {
                return (Inet6Address) byName;
            }
            throw new IllegalArgumentException();
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static boolean d(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return a.matcher(charSequence).matches();
    }

    private static boolean e(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return b.matcher(charSequence).matches();
    }

    private static InetAddress f(CharSequence charSequence) {
        if (!c(charSequence)) {
            return null;
        }
        try {
            return InetAddress.getByName(charSequence.toString());
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static a a(Inet6Address inet6Address) {
        String[] split = inet6Address.getHostAddress().split(":");
        String[] strArr = new String[32];
        int i = 0;
        for (int length = split.length - 1; length >= 0; length--) {
            String str = split[length];
            int length2 = 4 - str.length();
            int i2 = 0;
            while (i2 < length2) {
                strArr[i] = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE;
                i2++;
                i++;
            }
            int i3 = 0;
            while (i3 < str.length()) {
                strArr[i] = Character.toString(str.charAt(i3));
                i3++;
                i++;
            }
        }
        return a.a(strArr);
    }

    public static a a(Inet4Address inet4Address) {
        String[] split = inet4Address.getHostAddress().split("\\.");
        if (c || split.length == 4) {
            return a.a(split);
        }
        throw new AssertionError();
    }

    public static boolean c(CharSequence charSequence) {
        boolean z;
        if (charSequence == null) {
            z = false;
        } else {
            z = b.matcher(charSequence).matches();
        }
        if (z) {
            return true;
        }
        if (charSequence == null ? false : a.matcher(charSequence).matches()) {
            return true;
        }
        return false;
    }
}
