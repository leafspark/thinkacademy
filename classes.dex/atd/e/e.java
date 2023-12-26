package atd.e;

import atd.s0.a;

public enum e {
    Y(a.a(-86585204599360L)),
    N(a.a(-86327506561600L));
    
    public static final String INVALID_TRANS_STATUS_MSG = null;
    private final String mValue;

    private e(String str) {
        this.mValue = str;
    }

    public static e a(String str) throws atd.a0.a {
        if (str == null || str.isEmpty()) {
            return null;
        }
        for (e eVar : values()) {
            if (str.equalsIgnoreCase(eVar.mValue)) {
                return eVar;
            }
        }
        throw new atd.a0.a(a.a(-87143550347840L) + str, c.DATA_ELEMENT_INVALID_FORMAT);
    }

    public String a() {
        return this.mValue;
    }
}
