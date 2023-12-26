package com.didi.hummer.component.toast;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.render.component.view.HMBase;
import java.lang.reflect.Field;

@Component("Toast")
public class Toast {
    @JsMethod("show")
    public static void show(String str, int i) {
        android.widget.Toast makeText = android.widget.Toast.makeText(HummerSDK.appContext, str, i <= 2000 ? 0 : 1);
        hook(makeText);
        makeText.show();
    }

    @JsMethod("custom")
    public static void custom(HMBase hMBase, int i) {
        android.widget.Toast toast = new android.widget.Toast(HummerSDK.appContext);
        hook(toast);
        toast.setDuration(i <= 2000 ? 0 : 1);
        toast.setView(hMBase.getView());
        toast.show();
    }

    private static void hook(android.widget.Toast toast) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = android.widget.Toast.class.getDeclaredField("mTN");
                declaredField.setAccessible(true);
                Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                Object obj = declaredField.get(toast);
                declaredField2.set(obj, new SafelyHandlerWrapper((Handler) declaredField2.get(obj)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class SafelyHandlerWrapper extends Handler {
        private Handler impl;

        public SafelyHandlerWrapper(Handler handler) {
            this.impl = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                this.impl.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            this.impl.handleMessage(message);
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
