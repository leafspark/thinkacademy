package atd.e;

import atd.d.d;
import atd.d.i;
import atd.s0.a;
import atd.z.b;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;

public enum c {
    MESSAGE_RECEIVED_INVALID(a.a(-91202294442560L), a.a(-91219474311744L), a.a(-91210884377152L), a.a(-91064855489088L)),
    MESSAGE_VERSION_NOT_SUPPORTED(a.a(-90399135558208L), a.a(-90416315427392L), a.a(-90407725492800L), a.a(-90588114119232L)),
    DATA_ELEMENT_MISSING(a.a(-90682603399744L), a.a(-90699783268928L), a.a(-90450675165760L), a.a(-90558049348160L)),
    MESSAGE_EXTENSION_MISSING(a.a(-89875149548096L), a.a(-89617451510336L), a.a(-89643221314112L), a.a(-90077013011008L)),
    DATA_ELEMENT_INVALID_FORMAT(a.a(-89969638828608L), a.a(-89986818697792L), a.a(-89978228763200L), a.a(-89084875565632L)),
    DUPLICATE_DATA_ELEMENT(a.a(-89480012556864L), a.a(-89497192426048L), a.a(-89522962229824L), a.a(-89351163537984L)),
    TRANSACTION_ID_NOT_RECOGNIZED(a.a(-88651083868736L), a.a(-88668263737920L), a.a(-88694033541696L), a.a(-88560889555520L)),
    DATA_DECRYPTION_FAILURE(a.a(-88951731579456L), a.a(-88968911448640L), a.a(-88960321514048L), a.a(-88818587593280L)),
    ACCESS_DENIED(a.a(-88874422168128L), a.a(-88891602037312L), a.a(-88917371841088L), a.a(-88225882106432L)),
    ISO_CODE_INVALID(a.a(-88062673349184L), a.a(-88079853218368L), a.a(-88071263283776L), a.a(-88440630471232L)),
    TRANSACTION_TIMED_OUT(a.a(-88255946877504L), a.a(-88273126746688L), a.a(-88298896550464L), a.a(-87581637012032L)),
    TRANSIENT_SYSTEM_FAILURE(a.a(-87418428254784L), a.a(-87435608123968L), a.a(-87461377927744L), a.a(-87830745115200L)),
    SYSTEM_CONNECTION_FAILURE(a.a(-87697601129024L), a.a(-87714780998208L), a.a(-87706191063616L), a.a(-87010406361664L));
    
    private final String mErrorCode;
    private final String mErrorComponent;
    private final String mErrorDescription;
    private final String mErrorMessageType;

    private c(String str, String str2, String str3, String str4) {
        this.mErrorCode = str;
        this.mErrorComponent = str2;
        this.mErrorDescription = str3;
        this.mErrorMessageType = str4;
    }

    public String a() {
        return this.mErrorCode;
    }

    public String b() {
        return this.mErrorComponent;
    }

    public String c() {
        return this.mErrorDescription;
    }

    public String d() {
        return this.mErrorMessageType;
    }

    public d a(i iVar, String str) {
        return new d(iVar.d(), iVar.h(), iVar.b(), iVar.f(), iVar.g(), this, str);
    }

    public ProtocolErrorEvent a(String str, String str2) {
        return new atd.z.c(str, new b(str, this.mErrorCode, this.mErrorDescription, str2));
    }

    public RuntimeErrorEvent a(String str) {
        return new atd.z.d(this.mErrorCode, this.mErrorDescription);
    }
}
