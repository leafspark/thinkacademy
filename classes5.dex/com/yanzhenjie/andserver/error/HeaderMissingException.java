package com.yanzhenjie.andserver.error;

public class HeaderMissingException extends BasicException {
    private static final String MESSAGE = "Missing header [%s] for method parameter.";

    public HeaderMissingException(String str) {
        super(400, String.format(MESSAGE, new Object[]{str}));
    }

    public HeaderMissingException(String str, Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{str}), th);
    }

    public HeaderMissingException(Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{""}), th);
    }
}
