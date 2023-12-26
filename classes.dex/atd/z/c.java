package atd.z;

import atd.s0.a;
import com.adyen.threeds2.ErrorMessage;
import com.adyen.threeds2.ProtocolErrorEvent;

public final class c implements ProtocolErrorEvent {
    private final String a;
    private final ErrorMessage b;

    public c(String str, ErrorMessage errorMessage) {
        this.a = str;
        this.b = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return this.b;
    }

    public String getSDKTransactionID() {
        return this.a;
    }

    public String toString() {
        return a.a(-800941345139264L) + getSDKTransactionID() + a.a(-800752366578240L) + getErrorMessage();
    }
}
