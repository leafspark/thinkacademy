package com.bonree.sdk.agent.engine.external;

import com.bonree.sdk.agent.engine.network.cronet.BrUrlRequestBuilder;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.k;
import com.bonree.sdk.n.a;
import java.util.concurrent.Executor;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UrlRequest;

public class CronetInstrumentation {
    private static final String CRONET_NEWURLREQUESTBUILDER = "Cronet/newUrlRequestBuilder";
    private static final String CRONET_VERSINO = "cronet";

    public static ExperimentalUrlRequest.Builder newUrlRequestBuilder(ExperimentalCronetEngine experimentalCronetEngine, String str, UrlRequest.Callback callback, Executor executor) {
        if (g.a().b()) {
            a aVar = new a();
            MethodInfo.beforeMethod(CRONET_NEWURLREQUESTBUILDER, 1, str, aVar.X());
            BrUrlRequestBuilder brUrlRequestBuilder = new BrUrlRequestBuilder(str, callback, executor, experimentalCronetEngine, aVar);
            MethodInfo.afterMethod(CRONET_NEWURLREQUESTBUILDER, 1, str, aVar.X());
            k.b().a(u.c(str), u.b(str), "", brUrlRequestBuilder, k.a.a);
            return brUrlRequestBuilder;
        }
        MethodInfo.beforeMethod(CRONET_NEWURLREQUESTBUILDER, 1, str, (String) null);
        try {
            ExperimentalUrlRequest.Builder newUrlRequestBuilder = experimentalCronetEngine.newUrlRequestBuilder(str, callback, executor);
            MethodInfo.afterMethod(CRONET_NEWURLREQUESTBUILDER, 1, str, (String) null);
            return newUrlRequestBuilder;
        } catch (Exception e) {
            MethodInfo.afterMethod(CRONET_NEWURLREQUESTBUILDER, 1, str, (String) null);
            throw e;
        }
    }
}
