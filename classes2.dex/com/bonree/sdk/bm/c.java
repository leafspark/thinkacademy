package com.bonree.sdk.bm;

import com.bonree.sdk.az.a;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class c extends a {
    public static final d b = new c();
    private static int c = 1000;

    protected c() {
        super(com.bonree.sdk.ao.c.b, ResultCode.KARAOKE_SUCCESS);
    }

    public final List<String> c() {
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            ArrayList arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke((Object) null, new Object[]{strArr[i]});
                if (!(str == null || str.length() == 0 || arrayList.contains(str) || (byName = InetAddress.getByName(str)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0 || arrayList.contains(hostAddress))) {
                    arrayList.add(hostAddress);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (Exception e) {
            a.log(Level.WARNING, "Exception in findDNSByReflection", e);
        }
    }

    public final boolean d() {
        return a.e();
    }
}
