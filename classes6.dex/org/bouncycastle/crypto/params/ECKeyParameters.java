package org.bouncycastle.crypto.params;

import java.util.Objects;

public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    protected ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        Objects.requireNonNull(eCDomainParameters, "'parameters' cannot be null");
        this.parameters = eCDomainParameters;
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
