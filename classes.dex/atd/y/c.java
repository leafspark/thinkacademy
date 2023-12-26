package atd.y;

import atd.s0.a;
import com.adyen.threeds2.exception.SDKRuntimeException;

public enum c {
    CHALLENGE_PRESENTATION_FAILURE(a.a(-801731619121728L)),
    CRYPTO_FAILURE(a.a(-801632834873920L)),
    DEVICE_DATA_FAILURE(a.a(-801826108402240L)),
    SECURE_CHANNEL_SETUP_FAILURE(a.a(-801233402915392L)),
    UNKNOWN_DIRECTORY_SERVER(a.a(-801443856312896L));
    
    private final String mErrorMessage;

    private c(String str) {
        this.mErrorMessage = str;
    }

    public SDKRuntimeException a() {
        return a((Throwable) null);
    }

    public SDKRuntimeException a(Throwable th) {
        return new SDKRuntimeException(this.mErrorMessage, (String) null, (Throwable) null);
    }
}
