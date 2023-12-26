package com.bonree.sdk.bs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.os.Build;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class m {
    private static final String a = "DnsServersDetector";
    private static final String[] b = {"8.8.8.8", "8.8.4.4"};
    private static final String c = "]: [";
    private Context d;

    private m(Context context) {
        this.d = context;
    }

    private String[] a() {
        String[] c2 = c();
        if (c2 != null && c2.length > 0) {
            return c2;
        }
        String[] b2 = b();
        if (b2 != null && b2.length > 0) {
            return b2;
        }
        String[] d2 = d();
        if (d2 == null || d2.length <= 0) {
            return b;
        }
        return d2;
    }

    private String[] b() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ConnectivityManager connectivityManager = (ConnectivityManager) this.d.getSystemService("connectivity");
            if (connectivityManager != null) {
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(network).isConnected()) {
                        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                        List<InetAddress> dnsServers = linkProperties.getDnsServers();
                        if (a(linkProperties)) {
                            for (InetAddress hostAddress : dnsServers) {
                                arrayList.add(hostAddress.getHostAddress());
                            }
                        } else {
                            for (InetAddress hostAddress2 : dnsServers) {
                                arrayList2.add(hostAddress2.getHostAddress());
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (arrayList.size() > 0) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String[] c() {
        if (Build.VERSION.SDK_INT < 26) {
            ArrayList arrayList = new ArrayList();
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
                String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
                for (int i = 0; i < 4; i++) {
                    String str = (String) method.invoke((Object) null, new Object[]{strArr[i]});
                    if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    return (String[]) arrayList.toArray(new String[0]);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String[] d() {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        try {
            Set<String> a2 = a((BufferedReader) new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream())));
            if (a2.size() > 0) {
                return (String[]) a2.toArray(new String[0]);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Set<String> a(BufferedReader bufferedReader) throws Exception {
        InetAddress byName;
        String hostAddress;
        HashSet hashSet = new HashSet(10);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashSet;
            }
            int indexOf = readLine.indexOf(c);
            if (indexOf != -1) {
                String substring = readLine.substring(1, indexOf);
                int i = indexOf + 4;
                int length = readLine.length() - 1;
                if (length >= i) {
                    String substring2 = readLine.substring(i, length);
                    if (!substring2.isEmpty() && !((!substring.endsWith(".dns") && !substring.endsWith(".dns1") && !substring.endsWith(".dns2") && !substring.endsWith(".dns3") && !substring.endsWith(".dns4")) || (byName = InetAddress.getByName(substring2)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0)) {
                        hashSet.add(hostAddress);
                    }
                }
            }
        }
    }

    private static boolean a(LinkProperties linkProperties) {
        for (RouteInfo isDefaultRoute : linkProperties.getRoutes()) {
            if (isDefaultRoute.isDefaultRoute()) {
                return true;
            }
        }
        return false;
    }
}
