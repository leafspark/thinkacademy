package atd.j0;

import atd.r0.f;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.exception.InvalidInputException;

public final class a implements AuthenticationRequestParameters {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    public a(String str, String str2, String str3, String str4, String str5, String str6) throws InvalidInputException {
        f.a((Object) str, atd.y.a.SDK_TRANSACTION_ID);
        f.a((Object) str2, atd.y.a.DEVICE_DATA);
        f.a((Object) str3, atd.y.a.SDK_EPHEMERAL_PUBLIC_KEY);
        f.a((Object) str4, atd.y.a.SDK_APP_ID);
        f.a((Object) str5, atd.y.a.SDK_REFERENCE_NUMBER);
        f.a((Object) str6, atd.y.a.MESSAGE_VERSION);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public String getDeviceData() {
        return this.b;
    }

    public String getMessageVersion() {
        return this.f;
    }

    public String getSDKAppID() {
        return this.d;
    }

    public String getSDKEphemeralPublicKey() {
        return this.c;
    }

    public String getSDKReferenceNumber() {
        return this.e;
    }

    public String getSDKTransactionID() {
        return this.a;
    }
}
