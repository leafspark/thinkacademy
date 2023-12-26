package com.didi.hummer.core.engine.base;

import java.lang.reflect.Type;

public interface IValueOperator {
    boolean booleanValue();

    double doubleValue();

    float floatValue();

    int intValue();

    boolean isBoolean();

    boolean isFunction();

    boolean isNull();

    boolean isNumber();

    boolean isString();

    <T> T jsonValueOf(Type type);

    long longValue();

    void protect();

    String stringValue();

    void unprotect();
}
