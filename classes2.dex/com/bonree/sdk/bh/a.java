package com.bonree.sdk.bh;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class a {
    private static final Map<Character, Inet4Address> a = new HashMap();
    private static final Map<Character, Inet6Address> b = new HashMap();
    private static Inet4Address[] c = {a('a', 198, 41, 0, 4), a('b', 192, 228, 79, 201), a('c', 192, 33, 4, 12), a('d', 199, 7, 91, 13), a('e', 192, 203, 230, 10), a('f', 192, 5, 5, 241), a('g', 192, 112, 36, 4), a('h', 198, 97, 190, 53), a('i', 192, 36, 148, 17), a('j', 192, 58, 128, 30), a('k', 193, 0, 14, 129), a('l', 199, 7, 83, 42), a('m', 202, 12, 27, 33)};
    private static Inet6Address[] d = {a('a', 8193, 1283, 47678, 0, 0, 0, 2, 48), a('b', 8193, 1280, 132, 0, 0, 0, 0, 11), a('c', 8193, 1280, 2, 0, 0, 0, 0, 12), a('d', 8193, 1280, 45, 0, 0, 0, 0, 13), a('f', 8193, 1280, 47, 0, 0, 0, 0, 15), a('h', 8193, 1280, 1, 0, 0, 0, 0, 83), a('i', 8193, 2046, 0, 0, 0, 0, 0, 83), a('j', 8193, 1283, 3111, 0, 0, 0, 2, 48), a('l', 8193, 1280, 3, 0, 0, 0, 0, 66), a('m', 8193, 3523, 0, 0, 0, 0, 0, 53)};

    private static Inet4Address a(char c2, int i, int i2, int i3, int i4) {
        try {
            Inet4Address inet4Address = (Inet4Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{(byte) i, (byte) i2, (byte) i3, (byte) i4});
            a.put(Character.valueOf(c2), inet4Address);
            return inet4Address;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static Inet6Address a(char c2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        try {
            Inet6Address inet6Address = (Inet6Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{32, 1, (byte) (i2 >> 8), (byte) i2, (byte) (i3 >> 8), (byte) i3, 0, 0, 0, 0, 0, 0, (byte) (i7 >> 8), (byte) i7, (byte) (i8 >> 8), (byte) i8});
            b.put(Character.valueOf(c2), inet6Address);
            return inet6Address;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static Inet4Address a(Random random) {
        return c[random.nextInt(13)];
    }

    private static Inet6Address b(Random random) {
        return d[random.nextInt(10)];
    }

    private static Inet4Address a(char c2) {
        return a.get(Character.valueOf(c2));
    }

    private static Inet6Address b(char c2) {
        return b.get(Character.valueOf(c2));
    }
}
