package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;

public class XDHUPublicParameters implements CipherParameters {
    private AsymmetricKeyParameter ephemeralPublicKey;
    private AsymmetricKeyParameter staticPublicKey;

    public XDHUPublicParameters(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        Objects.requireNonNull(asymmetricKeyParameter, "staticPublicKey cannot be null");
        if ((asymmetricKeyParameter instanceof X448PublicKeyParameters) || (asymmetricKeyParameter instanceof X25519PublicKeyParameters)) {
            Objects.requireNonNull(asymmetricKeyParameter2, "ephemeralPublicKey cannot be null");
            if (asymmetricKeyParameter.getClass().isAssignableFrom(asymmetricKeyParameter2.getClass())) {
                this.staticPublicKey = asymmetricKeyParameter;
                this.ephemeralPublicKey = asymmetricKeyParameter2;
                return;
            }
            throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
        }
        throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
    }

    public AsymmetricKeyParameter getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public AsymmetricKeyParameter getStaticPublicKey() {
        return this.staticPublicKey;
    }
}
