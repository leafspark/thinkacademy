package atd.l0;

import android.content.Context;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.internal.j;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g {
    private final List<Warning> a;

    private g(Context context, ConfigParameters configParameters) {
        this.a = a(context, AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.SECURITY_APP_SIGNATURE), AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.SECURITY_TRUSTED_APP_STORES), AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.SECURITY_MALICIOUS_APPS));
    }

    public static g a(Context context, ConfigParameters configParameters) {
        return new g(context.getApplicationContext(), configParameters);
    }

    public List<Warning> a() {
        return this.a;
    }

    private List<Warning> a(Context context, String str, Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList();
        for (f a2 : a(str, collection, collection2)) {
            j a3 = a2.a(context);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    private List<f> a(String str, Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList();
        atd.m0.g gVar = new atd.m0.g();
        arrayList.add(new b(gVar));
        arrayList.add(new e(str, collection, collection2, gVar));
        arrayList.add(new c(gVar));
        arrayList.add(new a(gVar));
        arrayList.add(new d(gVar));
        return arrayList;
    }
}
