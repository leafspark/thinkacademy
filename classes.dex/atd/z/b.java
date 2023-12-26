package atd.z;

import atd.s0.a;
import com.adyen.threeds2.ErrorMessage;

public final class b implements ErrorMessage {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public b(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String getErrorCode() {
        return this.b;
    }

    public String getErrorDescription() {
        return this.c;
    }

    public String getErrorDetails() {
        return this.d;
    }

    public String getTransactionID() {
        return this.a;
    }

    public String toString() {
        return a.a(-800640697428544L) + getTransactionID() + a.a(-800705121937984L) + getErrorCode() + a.a(-800511848409664L) + getErrorDescription() + a.a(-800872625662528L) + getErrorDetails();
    }
}
