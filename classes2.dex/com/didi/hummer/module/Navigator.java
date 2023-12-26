package com.didi.hummer.module;

import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.utils.JsSourceUtil;
import java.util.Map;

@Component("Navigator")
public class Navigator {
    @JsMethod("openPage")
    public static void openPage(HummerContext hummerContext, NavPage navPage, JSCallback jSCallback) {
        if (navPage != null) {
            navPage.url = JsSourceUtil.relativePath2AbsolutePath(navPage.url, hummerContext.getPageUrl());
            navPage.sourcePath = JsSourceUtil.relativePath2AbsolutePath(navPage.url, hummerContext.getJsSourcePath());
        }
        HummerAdapter.getNavigatorAdapter(hummerContext.getNamespace()).openPage(hummerContext.getBaseContext(), navPage, new Navigator$$ExternalSyntheticLambda0(jSCallback));
    }

    static /* synthetic */ void lambda$openPage$0(JSCallback jSCallback, Map map) {
        if (jSCallback != null) {
            jSCallback.call(map);
            jSCallback.release();
        }
    }

    @JsMethod("popPage")
    public static void popPage(HummerContext hummerContext, NavPage navPage) {
        HummerAdapter.getNavigatorAdapter(hummerContext.getNamespace()).popPage(hummerContext.getBaseContext(), navPage);
    }

    @JsMethod("popToPage")
    public static void popToPage(HummerContext hummerContext, NavPage navPage) {
        HummerAdapter.getNavigatorAdapter(hummerContext.getNamespace()).popToPage(hummerContext.getBaseContext(), navPage);
    }

    @JsMethod("popToRootPage")
    public static void popToRootPage(HummerContext hummerContext, NavPage navPage) {
        HummerAdapter.getNavigatorAdapter(hummerContext.getNamespace()).popToRootPage(hummerContext.getBaseContext(), navPage);
    }

    @JsMethod("popBack")
    public static void popBack(HummerContext hummerContext, int i, NavPage navPage) {
        HummerAdapter.getNavigatorAdapter(hummerContext.getNamespace()).popBack(hummerContext.getBaseContext(), i, navPage);
    }
}
