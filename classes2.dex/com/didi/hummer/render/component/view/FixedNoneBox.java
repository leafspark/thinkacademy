package com.didi.hummer.render.component.view;

import android.content.Context;
import android.view.View;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;

public class FixedNoneBox extends HMBase<View> {
    public FixedNoneBox(HummerContext hummerContext) {
        super(hummerContext, (JSValue) null, (String) null);
        onCreate();
    }

    /* access modifiers changed from: protected */
    public View createViewInstance(Context context) {
        return new View(context);
    }

    public void onCreate() {
        super.onCreate();
        getYogaNode().setWidth(0.0f);
        getYogaNode().setHeight(0.0f);
    }
}
