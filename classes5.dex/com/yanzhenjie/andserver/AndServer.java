package com.yanzhenjie.andserver;

import android.content.Context;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.server.ProxyServer;
import com.yanzhenjie.andserver.server.WebServer;
import kbuild.autoconf;

public class AndServer {
    public static final String INFO = String.format("AndServer/%1$s", new Object[]{BuildConfig.PROJECT_VERSION});
    public static final String TAG = "AndServer";

    public static Server.Builder webServer(Context context) {
        return WebServer.newBuilder(context, autoconf.jvCONFIG_BUILD_CONFIG_NAME);
    }

    public static Server.Builder webServer(Context context, String str) {
        return WebServer.newBuilder(context, str);
    }

    public static Server.ProxyBuilder proxyServer() {
        return ProxyServer.newBuilder();
    }

    @Deprecated
    public static Server.Builder serverBuilder(Context context) {
        return webServer(context);
    }

    @Deprecated
    public static Server.Builder serverBuilder(Context context, String str) {
        return webServer(context, str);
    }
}
