package com.luck.picture.lib.widget.longimage;

import java.lang.reflect.InvocationTargetException;

public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
