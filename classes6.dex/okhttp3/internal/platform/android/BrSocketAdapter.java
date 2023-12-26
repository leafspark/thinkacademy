package okhttp3.internal.platform.android;

import com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory;
import com.bonree.sdk.bs.z;
import java.lang.reflect.Field;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.AndroidPlatform;

public final class BrSocketAdapter extends AndroidSocketAdapter {
    public BrSocketAdapter() throws ClassNotFoundException {
        super(Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl"));
    }

    public final boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return sSLSocketFactory instanceof BrSocketFactory;
    }

    public final boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    public final X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Field declaredField = BrSocketFactory.class.getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object a = z.a(declaredField.get((BrSocketFactory) sSLSocketFactory), "sslParameters");
            X509TrustManager x509TrustManager = (X509TrustManager) z.a(a, "x509TrustManager");
            if (x509TrustManager != null) {
                return x509TrustManager;
            }
            try {
                return (X509TrustManager) z.a(a, "trustManager");
            } catch (Throwable unused) {
                return x509TrustManager;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
