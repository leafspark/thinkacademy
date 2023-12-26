package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class ECDHUPrivateParameters implements CipherParameters {
    private ECPrivateKeyParameters ephemeralPrivateKey;
    private ECPublicKeyParameters ephemeralPublicKey;
    private ECPrivateKeyParameters staticPrivateKey;

    public ECDHUPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2) {
        this(eCPrivateKeyParameters, eCPrivateKeyParameters2, (ECPublicKeyParameters) null);
    }

    public ECDHUPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters) {
        Objects.requireNonNull(eCPrivateKeyParameters, "staticPrivateKey cannot be null");
        Objects.requireNonNull(eCPrivateKeyParameters2, "ephemeralPrivateKey cannot be null");
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        if (parameters.equals(eCPrivateKeyParameters2.getParameters())) {
            if (eCPublicKeyParameters == null) {
                eCPublicKeyParameters = new ECPublicKeyParameters(new FixedPointCombMultiplier().multiply(parameters.getG(), eCPrivateKeyParameters2.getD()), parameters);
            } else if (!parameters.equals(eCPublicKeyParameters.getParameters())) {
                throw new IllegalArgumentException("ephemeral public key has different domain parameters");
            }
            this.staticPrivateKey = eCPrivateKeyParameters;
            this.ephemeralPrivateKey = eCPrivateKeyParameters2;
            this.ephemeralPublicKey = eCPublicKeyParameters;
            return;
        }
        throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }
}
