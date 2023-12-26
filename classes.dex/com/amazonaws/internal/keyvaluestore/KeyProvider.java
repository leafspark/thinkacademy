package com.amazonaws.internal.keyvaluestore;

import java.security.Key;

interface KeyProvider {
    void deleteKey(String str);

    Key generateKey(String str) throws KeyNotGeneratedException;

    Key retrieveKey(String str) throws KeyNotFoundException;
}
