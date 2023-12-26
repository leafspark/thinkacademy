package com.didi.hummer.adapter.storage;

import java.util.List;
import java.util.Map;

public interface IStorageAdapter {
    List<String> allKeys();

    boolean exist(String str);

    Object get(String str);

    Map<String, Object> getAll();

    void remove(String str);

    void removeAll();

    void set(String str, Object obj);

    void setNamespace(String str);
}
