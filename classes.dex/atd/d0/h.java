package atd.d0;

import atd.c0.d;
import atd.f0.f;
import atd.g0.b;
import atd.s0.a;
import atd.y.c;
import com.adyen.threeds2.exception.SDKRuntimeException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

final class h extends e {
    private static final OAEPParameterSpec a = new OAEPParameterSpec(a.a(-798420199336512L), a.a(-798454559074880L), MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);

    static {
        a.a(-799326437435968L);
        a.a(-799098804169280L);
    }

    h() {
    }

    public String a() {
        return a.a(-798823926262336L);
    }

    public d a(f fVar, b bVar) {
        b.a(bVar, atd.g0.d.class);
        return a(fVar.e());
    }

    public d a(atd.c0.b bVar) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(bVar.e());
            instance.init(bVar.f());
            return new d(instance.generateKey(), bVar);
        } catch (NoSuchAlgorithmException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public byte[] a(d dVar, RSAPublicKey rSAPublicKey) throws SDKRuntimeException {
        try {
            Cipher instance = Cipher.getInstance(a.a(-798871170902592L));
            instance.init(3, rSAPublicKey, a);
            return instance.wrap(dVar);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }
}
