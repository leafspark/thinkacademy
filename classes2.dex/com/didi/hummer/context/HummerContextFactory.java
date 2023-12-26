package com.didi.hummer.context;

import android.content.Context;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.context.jsc.JSCHummerContext;
import com.didi.hummer.context.napi.NAPIHummerContext;
import com.didi.hummer.render.style.HummerLayout;

public class HummerContextFactory {
    private static IHummerContextCreator contextCreator;

    public interface IHummerContextCreator {
        HummerContext create(Context context);

        HummerContext create(HummerLayout hummerLayout, String str);
    }

    public static void setHummerContextCreator(IHummerContextCreator iHummerContextCreator) {
        contextCreator = iHummerContextCreator;
    }

    public static HummerContext createContext(Context context) {
        IHummerContextCreator iHummerContextCreator = contextCreator;
        if (iHummerContextCreator != null) {
            return iHummerContextCreator.create(context);
        }
        if (HummerSDK.getJsEngine() == 5 || HummerSDK.getJsEngine() == 6) {
            return new NAPIHummerContext(context);
        }
        return new JSCHummerContext(context);
    }

    public static HummerContext createContext(HummerLayout hummerLayout) {
        return createContext(hummerLayout, (String) null);
    }

    public static HummerContext createContext(HummerLayout hummerLayout, String str) {
        IHummerContextCreator iHummerContextCreator = contextCreator;
        if (iHummerContextCreator != null) {
            return iHummerContextCreator.create(hummerLayout, str);
        }
        if (HummerSDK.getJsEngine() == 5 || HummerSDK.getJsEngine() == 6) {
            return new NAPIHummerContext(hummerLayout, str);
        }
        return new JSCHummerContext(hummerLayout, str);
    }
}
