package com.yanzhenjie.andserver.framework.view;

import com.yanzhenjie.andserver.http.ResponseBody;

public class BodyView implements View {
    private ResponseBody mBody;

    public boolean rest() {
        return true;
    }

    public BodyView(ResponseBody responseBody) {
        this.mBody = responseBody;
    }

    public Object output() {
        return this.mBody;
    }
}
