package atd.e;

public enum a {
    Y(atd.s0.a.a(-91391273003584L)),
    N(atd.s0.a.a(-91683330779712L));
    
    private final String mValue;

    private a(String str) {
        this.mValue = str;
    }

    public static a a(String str) throws atd.a0.a {
        if (str == null) {
            return N;
        }
        for (a aVar : values()) {
            if (str.equalsIgnoreCase(aVar.mValue)) {
                return aVar;
            }
        }
        throw new atd.a0.a(atd.s0.a.a(-91309668624960L), c.DATA_ELEMENT_INVALID_FORMAT);
    }

    public boolean b() {
        return atd.s0.a.a(-91348323330624L).equals(this.mValue);
    }

    public boolean a() {
        return atd.s0.a.a(-91374093134400L).equals(this.mValue);
    }
}
