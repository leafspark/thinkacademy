package com.yanzhenjie.andserver.http.cookie;

import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.ObjectUtils;
import com.yanzhenjie.andserver.util.StringUtils;
import io.agora.rtc.Constants;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.apache.httpcore.Header;

public class StandardCookieProcessor implements CookieProcessor {
    private static final String ANCIENT_DATE;
    private static final ThreadLocal<DateFormat> COOKIE_DATE_FORMAT;
    private static final String COOKIE_DATE_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
    private static final BitSet DOMAIN_VALID = new BitSet(Constants.ERR_WATERMARK_ARGB);

    static {
        AnonymousClass1 r0 = new ThreadLocal<DateFormat>() {
            /* access modifiers changed from: protected */
            public DateFormat initialValue() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StandardCookieProcessor.COOKIE_DATE_PATTERN, Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat;
            }
        };
        COOKIE_DATE_FORMAT = r0;
        ANCIENT_DATE = ((DateFormat) r0.get()).format(new Date(10000));
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            DOMAIN_VALID.set(c);
        }
        for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
            DOMAIN_VALID.set(c2);
        }
        for (char c3 = 'A'; c3 <= 'Z'; c3 = (char) (c3 + 1)) {
            DOMAIN_VALID.set(c3);
        }
        BitSet bitSet = DOMAIN_VALID;
        bitSet.set(46);
        bitSet.set(45);
    }

    public List<Cookie> parseCookieHeader(Header[] headerArr) {
        if (ObjectUtils.isEmpty((Object[]) headerArr)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Header header : headerArr) {
            if (HttpHeaders.COOKIE.equalsIgnoreCase(header.getName())) {
                parserCookieValue(header.getValue(), arrayList);
            }
        }
        return arrayList;
    }

    private void parserCookieValue(String str, List<Cookie> list) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("=");
            int i = indexOf + 1;
            if (indexOf > 0 && i < nextToken.length()) {
                list.add(new Cookie(nextToken.substring(0, indexOf).trim(), nextToken.substring(i, nextToken.length()).trim()));
            }
        }
    }

    public String generateHeader(Cookie cookie) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cookie.getName());
        stringBuffer.append('=');
        String value = cookie.getValue();
        if (!StringUtils.isEmpty(value)) {
            validateCookieValue(value);
            stringBuffer.append(value);
        }
        int maxAge = cookie.getMaxAge();
        if (maxAge > -1) {
            stringBuffer.append("; Max-Age=");
            stringBuffer.append(maxAge);
            stringBuffer.append("; Expires=");
            if (maxAge == 0) {
                stringBuffer.append(ANCIENT_DATE);
            } else {
                COOKIE_DATE_FORMAT.get().format(new Date(System.currentTimeMillis() + (((long) maxAge) * 1000)), stringBuffer, new FieldPosition(0));
            }
        }
        String domain = cookie.getDomain();
        if (domain != null && domain.length() > 0) {
            validateDomain(domain);
            stringBuffer.append("; Domain=");
            stringBuffer.append(domain);
        }
        String path = cookie.getPath();
        if (path != null && path.length() > 0) {
            validatePath(path);
            stringBuffer.append("; Path=");
            stringBuffer.append(path);
        }
        if (cookie.getSecure()) {
            stringBuffer.append("; Secure");
        }
        if (cookie.isHttpOnly()) {
            stringBuffer.append("; HttpOnly");
        }
        return stringBuffer.toString();
    }

    private void validateCookieValue(String str) {
        int i;
        int length = str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            length--;
            i = 1;
        } else {
            i = 0;
        }
        char[] charArray = str.toCharArray();
        while (i < length) {
            char c = charArray[i];
            if (c < '!' || c == '\"' || c == ',' || c == ';' || c == '\\' || c == 127) {
                throw new IllegalArgumentException(String.format("The cookie's value [%1$s] is invalid.", new Object[]{str}));
            }
            i++;
        }
    }

    private void validateDomain(String str) {
        char[] charArray = str.toCharArray();
        char c = 65535;
        int i = 0;
        while (i < charArray.length) {
            char c2 = charArray[i];
            if (!DOMAIN_VALID.get(c2)) {
                throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", new Object[]{str}));
            } else if ((c == '.' || c == 65535) && (c2 == '.' || c2 == '-')) {
                throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", new Object[]{str}));
            } else if (c == '-' && c2 == '.') {
                throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", new Object[]{str}));
            } else {
                i++;
                c = c2;
            }
        }
        if (c == '.' || c == '-') {
            throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", new Object[]{str}));
        }
    }

    private void validatePath(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c < ' ' || c > '~' || c == ';') {
                throw new IllegalArgumentException(String.format("The cookie's path [%1$s] is invalid.", new Object[]{str}));
            }
        }
    }
}
