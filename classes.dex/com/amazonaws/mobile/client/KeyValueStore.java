package com.amazonaws.mobile.client;

import java.util.Map;

interface KeyValueStore {
    void clear();

    String get(String str);

    Map<String, String> get(String... strArr);

    void set(String str, String str2);

    void set(Map<String, String> map);
}
