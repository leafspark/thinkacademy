package org.bouncycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCJcaJceHelper extends ProviderJcaJceHelper {
    private static volatile Provider bcProvider;

    public BCJcaJceHelper() {
        super(getBouncyCastleProvider());
    }

    private static synchronized Provider getBouncyCastleProvider() {
        synchronized (BCJcaJceHelper.class) {
            Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
            if (provider instanceof BouncyCastleProvider) {
                return provider;
            }
            if (bcProvider != null) {
                Provider provider2 = bcProvider;
                return provider2;
            }
            bcProvider = new BouncyCastleProvider();
            Provider provider3 = bcProvider;
            return provider3;
        }
    }
}
