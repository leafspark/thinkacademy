package com.bonree.sdk.bm;

import com.bonree.sdk.az.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class b extends a {
    public static final d b = new b();
    private static int c = 999;
    private static final String d = "]: [";

    private b() {
        super("b", 999);
    }

    public final List<String> c() {
        try {
            Set<String> a = a(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), StandardCharsets.UTF_8)), true);
            if (a.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(a.size());
            arrayList.addAll(a);
            return arrayList;
        } catch (IOException e) {
            a.log(Level.WARNING, "Exception in findDNSByExec", e);
            return null;
        }
    }

    public final boolean d() {
        return a.e();
    }

    private static Set<String> a(BufferedReader bufferedReader, boolean z) throws UnknownHostException, IOException {
        InetAddress byName;
        String hostAddress;
        HashSet hashSet = new HashSet(6);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashSet;
            }
            int indexOf = readLine.indexOf(d);
            if (indexOf != -1) {
                String substring = readLine.substring(1, indexOf);
                int i = indexOf + 4;
                int length = readLine.length() - 1;
                if (length < i) {
                    Logger logger = a;
                    logger.warning("Malformed property detected: \"" + readLine + '\"');
                } else {
                    String substring2 = readLine.substring(i, length);
                    if (!substring2.isEmpty() && !((!substring.endsWith(".dns") && !substring.endsWith(".dns1") && !substring.endsWith(".dns2") && !substring.endsWith(".dns3") && !substring.endsWith(".dns4")) || (byName = InetAddress.getByName(substring2)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0)) {
                        hashSet.add(hostAddress);
                    }
                }
            }
        }
    }
}
