package atd.i0;

import atd.s0.a;
import atd.y.c;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public final class g {
    static {
        a.a(-791788769831488L);
    }

    public static RSAPrivateKey a(BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(a.a(-792579043813952L)).generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public static RSAPublicKey b(BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(a.a(-792561863944768L)).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }
}
