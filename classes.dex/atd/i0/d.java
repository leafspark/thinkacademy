package atd.i0;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public enum d {
    P256(atd.s0.a.a(-795293463145024L), new b());
    
    private final String mApiName;
    private final ECParameterSpec mECParameterSpec;

    private interface a {
        ECParameterSpec a();
    }

    private static final class b implements a {
        b() {
        }

        public ECParameterSpec a() {
            EllipticCurve ellipticCurve = new EllipticCurve(new ECFieldFp(new BigInteger(atd.s0.a.a(-796663557712448L), 16)), new BigInteger(atd.s0.a.a(-796934140652096L), 16), new BigInteger(atd.s0.a.a(-796105211963968L), 16), new BigInteger(atd.s0.a.a(-796375794903616L), 16).toByteArray());
            BigInteger bigInteger = new BigInteger(atd.s0.a.a(-795753024645696L), 16);
            BigInteger bigInteger2 = new BigInteger(atd.s0.a.a(-796023607585344L), 16);
            return new ECParameterSpec(ellipticCurve, new ECPoint(bigInteger, bigInteger2), new BigInteger(atd.s0.a.a(-795194678897216L), 16), 1);
        }
    }

    private d(String str, a aVar) {
        this.mApiName = str;
        this.mECParameterSpec = aVar.a();
    }

    public static d a(String str) {
        for (d dVar : values()) {
            if (dVar.mApiName.equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException(atd.s0.a.a(-795465261836864L));
    }

    /* access modifiers changed from: package-private */
    public ECParameterSpec b() {
        return this.mECParameterSpec;
    }

    public String a() {
        return this.mApiName;
    }
}
