package com.yanzhenjie.andserver.error;

public class NotFoundException extends BasicException {
    private static final String MESSAGE = "The resource [%s] is not found.";

    public NotFoundException() {
        super(404, String.format(MESSAGE, new Object[]{""}));
    }

    public NotFoundException(String str) {
        super(404, String.format(MESSAGE, new Object[]{str}));
    }

    public NotFoundException(String str, Throwable th) {
        super(404, String.format(MESSAGE, new Object[]{str}), th);
    }

    public NotFoundException(Throwable th) {
        super(404, String.format(MESSAGE, new Object[]{""}), th);
    }
}
