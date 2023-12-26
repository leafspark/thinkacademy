package atd.a;

import atd.s0.a;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

abstract class b {
    private static final SSLSocketFactory a;

    static {
        try {
            a = new k();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException(a.a(-103017749473856L), e);
        }
    }

    b() {
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return a(httpURLConnection);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        httpsURLConnection.setSSLSocketFactory(a);
        return httpsURLConnection;
    }

    /* access modifiers changed from: package-private */
    public abstract HttpURLConnection a(HttpURLConnection httpURLConnection);
}
