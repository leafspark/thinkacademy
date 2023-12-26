package com.didi.hummer.component.canvas;

import android.content.Context;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerStyleUtils;

@Component("CanvasPath")
public class CanvasPath extends HMBase {
    private Context context;
    private Path path = new Path();

    /* access modifiers changed from: protected */
    public View createViewInstance(Context context2) {
        return null;
    }

    public CanvasPath(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
        this.context = hummerContext;
    }

    public Path getPath() {
        return this.path;
    }

    private float dp2px(Object obj) {
        return HummerStyleUtils.convertNumber(obj);
    }

    @JsMethod("moveTo")
    public void moveTo(Object obj, Object obj2) {
        try {
            Log.i("CanvasPath22222", "x:" + obj);
            Log.i("CanvasPath22222", "y:" + obj2);
            this.path.moveTo(dp2px(obj), dp2px(obj2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsMethod("lineTo")
    public void lineTo(Object obj, Object obj2) {
        this.path.lineTo(dp2px(obj), dp2px(obj2));
    }

    @JsMethod("close")
    public void close() {
        this.path.close();
    }
}
