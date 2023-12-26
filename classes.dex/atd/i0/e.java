package atd.i0;

import atd.s0.a;
import atd.y.c;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import javax.crypto.KeyAgreement;

public final class e {
    static {
        a.a(-794554728770112L);
        a.a(-794576203606592L);
    }

    public static ECPublicKey a(d dVar, BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            return (ECPublicKey) KeyFactory.getInstance(a.a(-795336412817984L)).generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, bigInteger2), dVar.b()));
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public static ECPrivateKey a(d dVar, BigInteger bigInteger) {
        try {
            return (ECPrivateKey) KeyFactory.getInstance(a.a(-795357887654464L)).generatePrivate(new ECPrivateKeySpec(bigInteger, dVar.b()));
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public static KeyPair a(d dVar) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(a.a(-795345002752576L));
            instance.initialize(dVar.b(), new SecureRandom());
            return instance.generateKeyPair();
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public static byte[] a(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        try {
            KeyAgreement instance = KeyAgreement.getInstance(a.a(-794541843868224L));
            instance.init(eCPrivateKey);
            instance.doPhase(eCPublicKey, true);
            return instance.generateSecret();
        } catch (GeneralSecurityException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }
}
