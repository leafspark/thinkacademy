package atd.z;

import com.adyen.threeds2.CompletionEvent;

public final class a implements CompletionEvent {
    private final String a;
    private final String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String getSDKTransactionID() {
        return this.a;
    }

    public String getTransactionStatus() {
        return this.b;
    }

    public String toString() {
        return atd.s0.a.a(-801297827424832L) + getSDKTransactionID() + atd.s0.a.a(-801383726770752L) + getTransactionStatus();
    }
}
