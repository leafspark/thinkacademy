package atd.r0;

import atd.y.a;
import com.adyen.threeds2.exception.InvalidInputException;
import java.security.InvalidParameterException;
import java.util.UUID;

public final class f {
    public static void a(Object obj, a aVar) throws InvalidInputException {
        if (obj == null) {
            throw aVar.a(new InvalidParameterException("Object is null"));
        }
    }

    public static void b(String str, a aVar) throws InvalidInputException {
        a((Object) str, aVar);
        try {
            if (!UUID.fromString(str).toString().equalsIgnoreCase(str)) {
                throw aVar.a(new InvalidParameterException("Value and UUID do not match"));
            }
        } catch (IllegalArgumentException unused) {
            throw aVar.a(new InvalidParameterException("Value not a UUID"));
        }
    }

    public static void a(String str, a aVar) throws InvalidInputException {
        if (str == null || str.length() == 0) {
            throw aVar.a(new InvalidParameterException("Value is empty"));
        }
    }

    public static void a(int i, int i2, a aVar) throws InvalidInputException {
        if (i < i2) {
            throw aVar.a();
        }
    }
}
