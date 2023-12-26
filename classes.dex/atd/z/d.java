package atd.z;

import atd.s0.a;
import com.adyen.threeds2.RuntimeErrorEvent;

public final class d implements RuntimeErrorEvent {
    private final String a;
    private final String b;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String getErrorCode() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.b;
    }

    public String toString() {
        return a.a(-800821086054976L) + getErrorCode() + a.a(-800043696974400L) + getErrorMessage();
    }
}
