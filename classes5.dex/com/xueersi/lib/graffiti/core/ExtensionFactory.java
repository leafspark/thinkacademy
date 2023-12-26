package com.xueersi.lib.graffiti.core;

public abstract class ExtensionFactory {
    public int[] businessTypes() {
        return null;
    }

    public abstract Extension create();

    public abstract int messageType();

    public int[] pointTypes() {
        return null;
    }
}
