package com.bonree.sdk.common.gson;

import java.lang.reflect.Field;

public interface FieldNamingStrategy {
    String translateName(Field field);
}