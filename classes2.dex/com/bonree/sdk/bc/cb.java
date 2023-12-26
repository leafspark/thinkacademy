package com.bonree.sdk.bc;

public final class cb extends IllegalArgumentException {
    public cb(bn bnVar) {
        super("'" + bnVar + "' is not an absolute name");
    }

    private cb(String str) {
        super(str);
    }
}
