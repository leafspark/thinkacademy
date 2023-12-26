package com.yanzhenjie.andserver.framework.view;

public class ObjectView implements View {
    private final boolean isRest;
    private final Object output;

    public ObjectView(boolean z, Object obj) {
        this.isRest = z;
        this.output = obj;
    }

    public boolean rest() {
        return this.isRest;
    }

    public Object output() {
        return this.output;
    }
}
