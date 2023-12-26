package com.bonree.sdk.bc;

public final class am extends IllegalArgumentException {
    public am(long j) {
        super("Invalid DNS TTL: " + j);
    }
}
