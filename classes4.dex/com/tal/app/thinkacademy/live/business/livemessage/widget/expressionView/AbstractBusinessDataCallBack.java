package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView;

public abstract class AbstractBusinessDataCallBack {
    public void onDataFail(int i, String str) {
    }

    public void onDataFail(int i, String str, int i2) {
    }

    public abstract void onDataSucess(Object... objArr);
}
