package com.yanzhenjie.andserver.http.cookie;

import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.Serializable;
import java.util.Locale;

public class Cookie implements Cloneable, Serializable {
    private static final String TSPECIALS = "/()<>@,;:\\\"[]?={} \t";
    private String comment;
    private String domain;
    private boolean isHttpOnly = false;
    private int maxAge = -1;
    private String name;
    private String path;
    private boolean secure;
    private String value;
    private int version = 0;

    public Cookie(String str, String str2) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The name of the cookie cannot be empty or null.");
        } else if (!isToken(str) || str.equalsIgnoreCase("Comment") || str.equalsIgnoreCase("Discard") || str.equalsIgnoreCase("Domain") || str.equalsIgnoreCase(HttpHeaders.EXPIRES) || str.equalsIgnoreCase("Max-Age") || str.equalsIgnoreCase("Path") || str.equalsIgnoreCase("Secure") || str.equalsIgnoreCase("Version") || str.startsWith("$")) {
            throw new IllegalArgumentException(String.format("This name [%1$s] is a reserved character.", new Object[]{str}));
        } else {
            this.name = str;
            this.value = str2;
        }
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setDomain(String str) {
        if (!StringUtils.isEmpty(str)) {
            this.domain = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.domain = null;
        }
    }

    public String getDomain() {
        return this.domain;
    }

    public void setMaxAge(int i) {
        this.maxAge = i;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setSecure(boolean z) {
        this.secure = z;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    private boolean isToken(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt >= 127 || TSPECIALS.indexOf(charAt) != -1) {
                return false;
            }
        }
        return true;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setHttpOnly(boolean z) {
        this.isHttpOnly = z;
    }

    public boolean isHttpOnly() {
        return this.isHttpOnly;
    }
}
