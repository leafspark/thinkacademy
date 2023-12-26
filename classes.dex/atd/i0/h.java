package atd.i0;

import android.os.Build;
import atd.s0.a;
import atd.y.c;
import com.adyen.threeds2.internal.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.EnumSet;
import java.util.List;

public final class h {
    private static final CertificateFactory a;

    static {
        a.a(-791269078788672L);
        try {
            a = CertificateFactory.getInstance(a.a(-791230424083008L));
        } catch (CertificateException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public static X509Certificate a(String str) throws CertificateException {
        return a((InputStream) new ByteArrayInputStream(String.format(a.a(-791805949700672L), new Object[]{str}).getBytes(b.a)));
    }

    public static void a(X509Certificate x509Certificate, List<X509Certificate> list) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            instance.setCertificateEntry(a.a(-792076532640320L), x509Certificate);
            PKIXParameters pKIXParameters = new PKIXParameters(instance);
            CertPathValidator instance2 = CertPathValidator.getInstance(a.a(-792089417542208L));
            if (Build.VERSION.SDK_INT >= 24) {
                PKIXRevocationChecker pKIXRevocationChecker = (PKIXRevocationChecker) instance2.getRevocationChecker();
                if (pKIXRevocationChecker.getOcspResponder() == null) {
                    if (Security.getProperty(a.a(-792102302444096L)) == null) {
                        pKIXParameters.setRevocationEnabled(false);
                    }
                }
                pKIXRevocationChecker.setOptions(EnumSet.of(PKIXRevocationChecker.Option.SOFT_FAIL));
                pKIXParameters.addCertPathChecker(pKIXRevocationChecker);
            } else {
                pKIXParameters.setRevocationEnabled(false);
            }
            if (instance2.validate(a.generateCertPath(list), pKIXParameters) == null) {
                throw c.CRYPTO_FAILURE.a();
            }
        } catch (IOException | GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    private static X509Certificate a(InputStream inputStream) throws CertificateException {
        Certificate generateCertificate = a.generateCertificate(inputStream);
        if (generateCertificate instanceof X509Certificate) {
            return (X509Certificate) generateCertificate;
        }
        throw new CertificateException(a.a(-792196791724608L));
    }
}
