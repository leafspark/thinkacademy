package com.tal.app.thinkacademy.lib.route;

public class XesRoute extends AbsRouter {
    private XesRoute() {
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static XesRoute instance = new XesRoute();

        private SingletonHolder() {
        }
    }

    public static XesRoute getInstance() {
        return SingletonHolder.instance;
    }
}
