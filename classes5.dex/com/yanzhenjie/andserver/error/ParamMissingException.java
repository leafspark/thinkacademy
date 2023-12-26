package com.yanzhenjie.andserver.error;

public class ParamMissingException extends BasicException {
    private static final String MESSAGE = "Missing param [%s] for method parameter.";

    public ParamMissingException(String str) {
        super(400, String.format(MESSAGE, new Object[]{str}));
    }

    public ParamMissingException(String str, Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{str}), th);
    }

    public ParamMissingException(Throwable th) {
        super(400, String.format(MESSAGE, new Object[]{""}), th);
    }
}
