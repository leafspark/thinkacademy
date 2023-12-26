package com.bonree.sdk.bc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ce {
    private static ce d;
    private String[] a = null;
    private bn[] b = null;
    private int c = -1;

    public ce() {
        if (f() || g()) {
            return;
        }
        if (this.a == null || this.b == null) {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("java.vendor");
            if (property.indexOf("Windows") != -1) {
                if (property.indexOf("95") == -1 && property.indexOf("98") == -1 && property.indexOf("ME") == -1) {
                    try {
                        Process exec = Runtime.getRuntime().exec("ipconfig /all");
                        a(exec.getInputStream());
                        exec.destroy();
                    } catch (Exception unused) {
                    }
                } else {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec("winipcfg /all /batch " + "winipcfg.out").waitFor();
                        a((InputStream) new FileInputStream(new File("winipcfg.out")));
                        new File("winipcfg.out").delete();
                    } catch (Exception unused2) {
                    }
                }
            } else if (property.indexOf("NetWare") != -1) {
                b("sys:/etc/resolv.cfg");
            } else if (property2.indexOf("Android") != -1) {
                l();
            } else {
                b("/etc/resolv.conf");
            }
        }
    }

    private static void a(String str, List list) {
        if (!list.contains(str)) {
            if (br.a("verbose")) {
                PrintStream printStream = System.out;
                printStream.println("adding server " + str);
            }
            list.add(str);
        }
    }

    private static void b(String str, List list) {
        if (br.a("verbose")) {
            PrintStream printStream = System.out;
            printStream.println("adding search " + str);
        }
        try {
            bn a2 = bn.a(str, bn.a);
            if (!list.contains(a2)) {
                list.add(a2);
            }
        } catch (dc unused) {
        }
    }

    private static int a(String str) {
        String substring = str.substring(6);
        try {
            int parseInt = Integer.parseInt(substring);
            if (parseInt < 0) {
                return -1;
            }
            if (br.a("verbose")) {
                PrintStream printStream = System.out;
                printStream.println("setting ndots " + substring);
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(List list, List list2) {
        if (this.a == null && list.size() > 0) {
            this.a = (String[]) list.toArray(new String[0]);
        }
        if (this.b == null && list2.size() > 0) {
            this.b = (bn[]) list2.toArray(new bn[0]);
        }
    }

    private void a(int i) {
        if (this.c < 0 && i > 0) {
            this.c = i;
        }
    }

    private boolean f() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), (List) arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a((List) arrayList, (List) arrayList2);
        if (this.a == null || this.b == null) {
            return false;
        }
        return true;
    }

    private boolean g() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke((Object) null, objArr);
            List<String> list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                for (String a2 : list) {
                    a(a2, (List) arrayList);
                }
            }
            if (list2.size() > 0) {
                for (String b2 : list2) {
                    b(b2, arrayList2);
                }
            }
            a((List) arrayList, (List) arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int i = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), (List) arrayList);
                    } else if (readLine.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String nextToken = stringTokenizer4.nextToken();
                            if (nextToken.startsWith("ndots:")) {
                                i = a(nextToken);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
            }
            bufferedReader.close();
            a((List) arrayList, (List) arrayList2);
            if (this.c < 0 && i > 0) {
                this.c = i;
            }
        } catch (FileNotFoundException unused2) {
        }
    }

    private void h() {
        b("/etc/resolv.conf");
    }

    private void i() {
        b("sys:/etc/resolv.cfg");
    }

    private void a(InputStream inputStream, Locale locale) {
        ResourceBundle resourceBundle;
        Locale locale2 = locale;
        String str = ce.class.getPackage().getName() + ".windows.DNSServer";
        if (locale2 != null) {
            resourceBundle = ResourceBundle.getBundle(str, locale2);
        } else {
            resourceBundle = ResourceBundle.getBundle(str);
        }
        String string = resourceBundle.getString("host_name");
        String string2 = resourceBundle.getString("primary_dns_suffix");
        String string3 = resourceBundle.getString("dns_suffix");
        String string4 = resourceBundle.getString("dns_servers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        if (!stringTokenizer.hasMoreTokens()) {
                            break;
                        }
                        String nextToken = stringTokenizer.nextToken();
                        if (readLine.indexOf(":") != -1) {
                            z = false;
                            z2 = false;
                        }
                        if (readLine.indexOf(string) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            try {
                                if (bn.a(nextToken, (bn) null).d() != 1) {
                                    b(nextToken, arrayList2);
                                }
                            } catch (dc unused) {
                            }
                        } else {
                            if (readLine.indexOf(string2) != -1) {
                                while (stringTokenizer.hasMoreTokens()) {
                                    nextToken = stringTokenizer.nextToken();
                                }
                                if (!nextToken.equals(":")) {
                                    b(nextToken, arrayList2);
                                }
                            } else {
                                if (!z) {
                                    if (readLine.indexOf(string3) == -1) {
                                        if (z2 || readLine.indexOf(string4) != -1) {
                                            while (stringTokenizer.hasMoreTokens()) {
                                                nextToken = stringTokenizer.nextToken();
                                            }
                                            if (!nextToken.equals(":")) {
                                                a(nextToken, (List) arrayList);
                                                z2 = true;
                                            }
                                        }
                                    }
                                }
                                while (stringTokenizer.hasMoreTokens()) {
                                    nextToken = stringTokenizer.nextToken();
                                }
                                if (!nextToken.equals(":")) {
                                    b(nextToken, arrayList2);
                                }
                            }
                            z = true;
                        }
                    } else {
                        try {
                            a((List) arrayList, (List) arrayList2);
                            return;
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                }
            }
        } catch (IOException unused3) {
        }
    }

    private void a(InputStream inputStream) {
        int intValue = Integer.getInteger("com.xbill.DNS.windows.parse.buffer", 8192).intValue();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, intValue);
        bufferedInputStream.mark(intValue);
        a((InputStream) bufferedInputStream, (Locale) null);
        if (this.a == null) {
            try {
                bufferedInputStream.reset();
                a((InputStream) bufferedInputStream, new Locale("", ""));
            } catch (IOException unused) {
            }
        }
    }

    private void j() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("winipcfg /all /batch " + "winipcfg.out").waitFor();
            a((InputStream) new FileInputStream(new File("winipcfg.out")));
            new File("winipcfg.out").delete();
        } catch (Exception unused) {
        }
    }

    private void k() {
        try {
            Process exec = Runtime.getRuntime().exec("ipconfig /all");
            a(exec.getInputStream());
            exec.destroy();
        } catch (Exception unused) {
        }
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke((Object) null, new Object[]{strArr[i]});
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception unused) {
        }
        a((List) arrayList, (List) arrayList2);
    }

    public final String[] a() {
        return this.a;
    }

    public final String b() {
        String[] strArr = this.a;
        if (strArr == null) {
            return null;
        }
        return strArr[0];
    }

    public final bn[] c() {
        return this.b;
    }

    public final int d() {
        int i = this.c;
        if (i < 0) {
            return 1;
        }
        return i;
    }

    public static synchronized ce e() {
        ce ceVar;
        synchronized (ce.class) {
            ceVar = d;
        }
        return ceVar;
    }

    private static void m() {
        ce ceVar = new ce();
        synchronized (ce.class) {
            d = ceVar;
        }
    }

    static {
        ce ceVar = new ce();
        synchronized (ce.class) {
            d = ceVar;
        }
    }
}
