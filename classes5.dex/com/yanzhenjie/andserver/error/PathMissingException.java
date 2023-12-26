package com.yanzhenjie.andserver.error;

public class PathMissingException extends BasicException {
    private static final String MESSAGE = "Missing param [%s] for path parameter.";

    public PathMissingException(String str) {
        super(400, String.format(MESSAGE, new Object[]{str}));
    }

    public PathMissingException(String str, Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{str}), th);
    }

    public PathMissingException(Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{""}), th);
    }
}
