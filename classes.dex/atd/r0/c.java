package atd.r0;

import atd.s0.a;
import com.adyen.threeds2.exception.InvalidInputException;
import java.util.Locale;

public final class c {
    static {
        a.a(-840467929164352L);
    }

    private static boolean a(Locale locale) {
        return (locale == null || locale.getLanguage() == null || locale.getCountry() == null) ? false : true;
    }

    public static void b(String str) throws InvalidInputException {
        if (str != null && !a(a(str))) {
            throw atd.y.a.LOCALE.a();
        }
    }

    private static Locale a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(a.a(-840442159360576L));
        int length = split.length;
        if (length == 1) {
            return new Locale(split[0]);
        }
        if (length == 2) {
            return new Locale(split[0], split[1]);
        }
        if (length != 3) {
            return null;
        }
        return new Locale(split[0], split[1], split[2]);
    }
}
