package com.amazonaws.mobile.client;

import java.util.Map;

final class DummyStore implements KeyValueStore {
    DummyStore() {
    }

    public Map<String, String> get(String... strArr) {
        throwNotInitializedException();
        return null;
    }

    public String get(String str) {
        throwNotInitializedException();
        return null;
    }

    public void set(Map<String, String> map) {
        throwNotInitializedException();
    }

    public void set(String str, String str2) {
        throwNotInitializedException();
    }

    public void clear() {
        throwNotInitializedException();
    }

    private void throwNotInitializedException() {
        throw new IllegalStateException("AWSMobileClient has not been initialized yet.");
    }
}
