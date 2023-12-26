package atd.m;

import android.content.Context;
import atd.i.c;
import atd.i.d;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class e extends d {

    class a implements Comparator<NetworkInterface> {
        a(e eVar) {
        }

        /* renamed from: a */
        public int compare(NetworkInterface networkInterface, NetworkInterface networkInterface2) {
            return !networkInterface2.getName().contains(atd.s0.a.a(-73640173169216L)) ? 0 : -1;
        }
    }

    public String a() {
        return atd.s0.a.a(-73408244935232L);
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        return Arrays.asList(new String[]{atd.s0.a.a(-73421129837120L), atd.s0.a.a(-72716755200576L)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String c(Context context) throws c {
        try {
            ArrayList<T> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Collections.sort(list, new a(this));
            for (T inetAddresses : list) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                return hostAddress;
                            }
                            int indexOf = hostAddress.indexOf(37);
                            if (indexOf >= 0) {
                                hostAddress = hostAddress.substring(0, indexOf);
                            }
                            return hostAddress.toUpperCase(Locale.US);
                        }
                    }
                }
            }
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        } catch (SocketException e) {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, e);
        }
    }
}
