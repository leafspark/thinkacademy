package atd.e;

import atd.a0.a;
import java.util.Locale;

public enum b {
    SINGLE_TEXT_INPUT(1),
    SINGLE_SELECT(2),
    MULTI_SELECT(3),
    OUT_OF_BAND(4),
    HTML_UI(5);
    
    public static final String MESSAGE_FORMAT_INVALID_ID = null;
    private int mId;

    private b(int i) {
        this.mId = i;
    }

    public static b a(String str) throws a {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return a(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new a(String.format(Locale.ENGLISH, atd.s0.a.a(-91674740845120L), new Object[]{str}), e, c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    public static b a(int i) throws a {
        for (b bVar : values()) {
            if (bVar.mId == i) {
                return bVar;
            }
        }
        throw new a(String.format(Locale.ENGLISH, atd.s0.a.a(-91747755289152L), new Object[]{Integer.valueOf(i)}), c.DATA_ELEMENT_INVALID_FORMAT);
    }

    public int a() {
        return this.mId;
    }
}
