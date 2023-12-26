package atd.y;

import com.adyen.threeds2.exception.InvalidInputException;

public enum a {
    APPLICATION_CONTEXT(atd.s0.a.a(-806821155367488L)),
    CONFIG_PARAMETERS(atd.s0.a.a(-806211270011456L)),
    LOCALE(atd.s0.a.a(-806069536090688L)),
    DIRECTORY_SERVER_ID(atd.s0.a.a(-806224154913344L)),
    MESSAGE_VERSION(atd.s0.a.a(-805592794720832L)),
    CURRENT_ACTIVITY(atd.s0.a.a(-805485420538432L)),
    CHALLENGE_PARAMETERS(atd.s0.a.a(-805700168903232L)),
    CHALLENGE_STATUS_RECEIVER(atd.s0.a.a(-805085988579904L)),
    TIMEOUT(atd.s0.a.a(-805287852042816L)),
    SDK_TRANSACTION_ID(atd.s0.a.a(-805167592958528L)),
    DEVICE_DATA(atd.s0.a.a(-804488988125760L)),
    SDK_EPHEMERAL_PUBLIC_KEY(atd.s0.a.a(-804398793812544L)),
    SDK_APP_ID(atd.s0.a.a(-804596362308160L)),
    SDK_REFERENCE_NUMBER(atd.s0.a.a(-803947822246464L));
    
    private final String mErrorMessage;

    private a(String str) {
        this.mErrorMessage = str;
    }

    public InvalidInputException a() {
        return a((Throwable) null);
    }

    public InvalidInputException a(Throwable th) {
        return new InvalidInputException(this.mErrorMessage, (Throwable) null);
    }
}
