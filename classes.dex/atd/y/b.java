package atd.y;

import atd.s0.a;
import atd.z.d;
import com.adyen.threeds2.RuntimeErrorEvent;

public enum b {
    UNKNOWN(a.a(-803827563162176L), a.a(-803861922900544L)),
    MESSAGE_VERSIONS_MISMATCH(a.a(-804063786363456L), a.a(-803333641923136L)),
    MESSAGE_INDICES_MISMATCH(a.a(-803720188979776L), a.a(-803544095320640L)),
    ACTIVITY_WEAK_REFERENCE_MISSING(a.a(-803080238852672L), a.a(-802942799899200L)),
    ACTIVITY_REFERENCE_MISSING(a.a(-802135346047552L), a.a(-802534778006080L));
    
    private final String mErrorCode;
    private final String mErrorMessage;

    private b(String str, String str2) {
        this.mErrorCode = str;
        this.mErrorMessage = str2;
    }

    public RuntimeErrorEvent a() {
        return new d(this.mErrorCode, this.mErrorMessage);
    }

    public RuntimeErrorEvent a(String str) {
        return new d(this.mErrorCode, this.mErrorMessage);
    }
}
