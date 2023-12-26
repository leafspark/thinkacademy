package atd.e;

import atd.s0.a;
import java.util.Locale;

public enum d {
    CHALLENGE_REQUEST(a.a(-86971751656000L)),
    CHALLENGE_RESPONSE(a.a(-87349708778048L)),
    ERROR(a.a(-87405543352896L));
    
    private final String mValue;

    private d(String str) {
        this.mValue = str;
    }

    public static d a(String str) throws atd.a0.a {
        for (d dVar : (d[]) d.class.getEnumConstants()) {
            if (dVar.a().equals(str)) {
                return dVar;
            }
        }
        throw new atd.a0.a(String.format(Locale.ENGLISH, a.a(-87023291263552L), new Object[]{str}), c.MESSAGE_RECEIVED_INVALID);
    }

    public String a() {
        return this.mValue;
    }
}
