package com.amazonaws.mobile.client;

public interface Callback<R> {
    void onError(Exception exc);

    void onResult(R r);
}
