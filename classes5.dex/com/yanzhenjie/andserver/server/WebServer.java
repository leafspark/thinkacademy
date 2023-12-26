package com.yanzhenjie.andserver.server;

import android.content.Context;
import com.yanzhenjie.andserver.ComponentRegister;
import com.yanzhenjie.andserver.DispatcherHandler;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.server.BasicServer;
import org.apache.httpcore.protocol.HttpRequestHandler;

public class WebServer extends BasicServer<Builder> {
    private Context mContext;
    private String mGroup;

    public static Builder newBuilder(Context context, String str) {
        return new Builder(context, str);
    }

    private WebServer(Builder builder) {
        super(builder);
        this.mContext = builder.context;
        this.mGroup = builder.group;
    }

    /* access modifiers changed from: protected */
    public HttpRequestHandler requestHandler() {
        DispatcherHandler dispatcherHandler = new DispatcherHandler(this.mContext);
        ComponentRegister componentRegister = new ComponentRegister(this.mContext);
        dispatcherHandler.addErrorCall(this.mRequestErrorCall);
        componentRegister.register(dispatcherHandler, this.mGroup);
        return dispatcherHandler;
    }

    public static class Builder extends BasicServer.Builder<Builder, WebServer> implements Server.Builder<Builder, WebServer> {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public String group;

        private Builder(Context context2, String str) {
            this.context = context2;
            this.group = str;
        }

        public WebServer build() {
            return new WebServer(this);
        }
    }
}
