package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;

public class SM2KeyExchangePublicParameters implements CipherParameters {
    private final ECPublicKeyParameters ephemeralPublicKey;
    private final ECPublicKeyParameters staticPublicKey;

    public SM2KeyExchangePublicParameters(ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2) {
        Objects.requireNonNull(eCPublicKeyParameters, "staticPublicKey cannot be null");
        Objects.requireNonNull(eCPublicKeyParameters2, "ephemeralPublicKey cannot be null");
        if (eCPublicKeyParameters.getParameters().equals(eCPublicKeyParameters2.getParameters())) {
            this.staticPublicKey = eCPublicKeyParameters;
            this.ephemeralPublicKey = eCPublicKeyParameters2;
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ECPublicKeyParameters getStaticPublicKey() {
        return this.staticPublicKey;
    }
}
