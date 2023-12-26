package com.yanzhenjie.andserver.error;

public class CookieMissingException extends BasicException {
    private static final String MESSAGE = "Missing cookie [%s] for method parameter.";

    public CookieMissingException(String str) {
        super(400, String.format(MESSAGE, new Object[]{str}));
    }

    public CookieMissingException(String str, Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{str}), th);
    }

    public CookieMissingException(Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{""}), th);
    }
}
