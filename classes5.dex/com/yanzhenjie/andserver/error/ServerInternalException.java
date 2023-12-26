package com.yanzhenjie.andserver.error;

public class ServerInternalException extends BasicException {
    private static final String MESSAGE = "Server internal error";

    public ServerInternalException(String str) {
        super(500, String.format("%s, %s.", new Object[]{MESSAGE, str}));
    }

    public ServerInternalException(String str, Throwable th) {
        super(500, String.format("%s, %s.", new Object[]{MESSAGE, str}), th);
    }

    public ServerInternalException(Throwable th) {
        super(500, String.format("%s.", new Object[]{MESSAGE}), th);
    }
}
