package atd.x;

import atd.i0.h;
import atd.r0.f;
import atd.y.c;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<X509Certificate> a(String str, ConfigParameters configParameters) {
        if (str == null || str.isEmpty()) {
            return a(configParameters);
        }
        return a(str);
    }

    private static List<X509Certificate> b(String str) {
        ArrayList arrayList = new ArrayList();
        for (String a : b.b(str)) {
            try {
                arrayList.add(h.a(a));
            } catch (CertificateException e) {
                throw c.UNKNOWN_DIRECTORY_SERVER.a(e);
            }
        }
        return arrayList;
    }

    private static List<X509Certificate> a(ConfigParameters configParameters) {
        f.a((Object) configParameters, atd.y.a.CONFIG_PARAMETERS);
        return b(AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID));
    }

    private static List<X509Certificate> a(String str) {
        f.a(str, atd.y.a.DIRECTORY_SERVER_ID);
        return b(str);
    }
}
