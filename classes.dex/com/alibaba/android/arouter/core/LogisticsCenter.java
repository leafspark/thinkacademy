package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

public class LogisticsCenter {
    static ThreadPoolExecutor executor;
    private static Context mContext;
    private static boolean registerByPlugin;

    private static void loadRouterMap() {
        registerByPlugin = false;
    }

    private static void register(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof IRouteRoot) {
                    registerRouteRoot((IRouteRoot) newInstance);
                } else if (newInstance instanceof IProviderGroup) {
                    registerProvider((IProviderGroup) newInstance);
                } else if (newInstance instanceof IInterceptorGroup) {
                    registerInterceptor((IInterceptorGroup) newInstance);
                } else {
                    ILogger iLogger = ARouter.logger;
                    iLogger.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
                }
            } catch (Exception unused) {
                ILogger iLogger2 = ARouter.logger;
                iLogger2.error("ARouter::", "register class error:" + str);
            }
        }
    }

    private static void registerRouteRoot(IRouteRoot iRouteRoot) {
        markRegisteredByPlugin();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(Warehouse.groupsIndex);
        }
    }

    private static void registerInterceptor(IInterceptorGroup iInterceptorGroup) {
        markRegisteredByPlugin();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(Warehouse.interceptorsIndex);
        }
    }

    private static void registerProvider(IProviderGroup iProviderGroup) {
        markRegisteredByPlugin();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(Warehouse.providersIndex);
        }
    }

    private static void markRegisteredByPlugin() {
        if (!registerByPlugin) {
            registerByPlugin = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb A[Catch:{ Exception -> 0x01ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r8, java.util.concurrent.ThreadPoolExecutor r9) throws com.alibaba.android.arouter.exception.HandlerException {
        /*
            java.lang.Class<com.alibaba.android.arouter.core.LogisticsCenter> r0 = com.alibaba.android.arouter.core.LogisticsCenter.class
            monitor-enter(r0)
            mContext = r8     // Catch:{ all -> 0x01cd }
            executor = r9     // Catch:{ all -> 0x01cd }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01ac }
            loadRouterMap()     // Catch:{ Exception -> 0x01ac }
            boolean r9 = registerByPlugin     // Catch:{ Exception -> 0x01ac }
            r3 = 0
            if (r9 == 0) goto L_0x001e
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r9 = "ARouter::"
            java.lang.String r4 = "Load router map by arouter-auto-register plugin."
            r8.info(r9, r4)     // Catch:{ Exception -> 0x01ac }
            goto L_0x0137
        L_0x001e:
            boolean r9 = com.alibaba.android.arouter.launcher.ARouter.debuggable()     // Catch:{ Exception -> 0x01ac }
            if (r9 != 0) goto L_0x0056
            boolean r9 = com.alibaba.android.arouter.utils.PackageUtils.isNewVersion(r8)     // Catch:{ Exception -> 0x01ac }
            if (r9 == 0) goto L_0x002b
            goto L_0x0056
        L_0x002b:
            com.alibaba.android.arouter.facade.template.ILogger r9 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Load router map from cache."
            r9.info(r4, r5)     // Catch:{ Exception -> 0x01ac }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "SP_AROUTER_CACHE"
            boolean r5 = r8 instanceof android.content.Context     // Catch:{ Exception -> 0x01ac }
            if (r5 != 0) goto L_0x0041
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x01ac }
            goto L_0x0047
        L_0x0041:
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ Exception -> 0x01ac }
            android.content.SharedPreferences r8 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.getSharedPreferences(r8, r4, r3)     // Catch:{ Exception -> 0x01ac }
        L_0x0047:
            java.lang.String r4 = "ROUTER_MAP"
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ Exception -> 0x01ac }
            r5.<init>()     // Catch:{ Exception -> 0x01ac }
            java.util.Set r8 = r8.getStringSet(r4, r5)     // Catch:{ Exception -> 0x01ac }
            r9.<init>(r8)     // Catch:{ Exception -> 0x01ac }
            goto L_0x008f
        L_0x0056:
            com.alibaba.android.arouter.facade.template.ILogger r9 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Run with debug mode or new install, rebuild router map."
            r9.info(r4, r5)     // Catch:{ Exception -> 0x01ac }
            android.content.Context r9 = mContext     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "com.alibaba.android.arouter.routes"
            java.util.Set r9 = com.alibaba.android.arouter.utils.ClassUtils.getFileNameByPackageName(r9, r4)     // Catch:{ Exception -> 0x01ac }
            boolean r4 = r9.isEmpty()     // Catch:{ Exception -> 0x01ac }
            if (r4 != 0) goto L_0x008c
            java.lang.String r4 = "SP_AROUTER_CACHE"
            boolean r5 = r8 instanceof android.content.Context     // Catch:{ Exception -> 0x01ac }
            if (r5 != 0) goto L_0x0078
            android.content.SharedPreferences r4 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x01ac }
            goto L_0x007f
        L_0x0078:
            r5 = r8
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x01ac }
            android.content.SharedPreferences r4 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.getSharedPreferences(r5, r4, r3)     // Catch:{ Exception -> 0x01ac }
        L_0x007f:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x01ac }
            java.lang.String r5 = "ROUTER_MAP"
            android.content.SharedPreferences$Editor r4 = r4.putStringSet(r5, r9)     // Catch:{ Exception -> 0x01ac }
            r4.apply()     // Catch:{ Exception -> 0x01ac }
        L_0x008c:
            com.alibaba.android.arouter.utils.PackageUtils.updateVersion(r8)     // Catch:{ Exception -> 0x01ac }
        L_0x008f:
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "ARouter::"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ac }
            r5.<init>()     // Catch:{ Exception -> 0x01ac }
            java.lang.String r6 = "Find router map finished, map size = "
            r5.append(r6)     // Catch:{ Exception -> 0x01ac }
            int r6 = r9.size()     // Catch:{ Exception -> 0x01ac }
            r5.append(r6)     // Catch:{ Exception -> 0x01ac }
            java.lang.String r6 = ", cost "
            r5.append(r6)     // Catch:{ Exception -> 0x01ac }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01ac }
            long r6 = r6 - r1
            r5.append(r6)     // Catch:{ Exception -> 0x01ac }
            java.lang.String r1 = " ms."
            r5.append(r1)     // Catch:{ Exception -> 0x01ac }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x01ac }
            r8.info(r4, r1)     // Catch:{ Exception -> 0x01ac }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01ac }
            java.util.Iterator r8 = r9.iterator()     // Catch:{ Exception -> 0x01ac }
        L_0x00c5:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x01ac }
            if (r9 == 0) goto L_0x0137
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x01ac }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x01ac }
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Root"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x01ac }
            if (r4 == 0) goto L_0x00f3
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x01ac }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x01ac }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IRouteRoot r9 = (com.alibaba.android.arouter.facade.template.IRouteRoot) r9     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IRouteRoot r9 = (com.alibaba.android.arouter.facade.template.IRouteRoot) r9     // Catch:{ Exception -> 0x01ac }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r4 = com.alibaba.android.arouter.core.Warehouse.groupsIndex     // Catch:{ Exception -> 0x01ac }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x01ac }
            goto L_0x00c5
        L_0x00f3:
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Interceptors"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x01ac }
            if (r4 == 0) goto L_0x0115
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x01ac }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x01ac }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IInterceptorGroup r9 = (com.alibaba.android.arouter.facade.template.IInterceptorGroup) r9     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IInterceptorGroup r9 = (com.alibaba.android.arouter.facade.template.IInterceptorGroup) r9     // Catch:{ Exception -> 0x01ac }
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r4 = com.alibaba.android.arouter.core.Warehouse.interceptorsIndex     // Catch:{ Exception -> 0x01ac }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x01ac }
            goto L_0x00c5
        L_0x0115:
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Providers"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x01ac }
            if (r4 == 0) goto L_0x00c5
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x01ac }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x01ac }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01ac }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IProviderGroup r9 = (com.alibaba.android.arouter.facade.template.IProviderGroup) r9     // Catch:{ Exception -> 0x01ac }
            com.alibaba.android.arouter.facade.template.IProviderGroup r9 = (com.alibaba.android.arouter.facade.template.IProviderGroup) r9     // Catch:{ Exception -> 0x01ac }
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r4 = com.alibaba.android.arouter.core.Warehouse.providersIndex     // Catch:{ Exception -> 0x01ac }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x01ac }
            goto L_0x00c5
        L_0x0137:
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r9 = "ARouter::"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ac }
            r4.<init>()     // Catch:{ Exception -> 0x01ac }
            java.lang.String r5 = "Load root element finished, cost "
            r4.append(r5)     // Catch:{ Exception -> 0x01ac }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01ac }
            long r5 = r5 - r1
            r4.append(r5)     // Catch:{ Exception -> 0x01ac }
            java.lang.String r1 = " ms."
            r4.append(r1)     // Catch:{ Exception -> 0x01ac }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x01ac }
            r8.info(r9, r1)     // Catch:{ Exception -> 0x01ac }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r8 = com.alibaba.android.arouter.core.Warehouse.groupsIndex     // Catch:{ Exception -> 0x01ac }
            int r8 = r8.size()     // Catch:{ Exception -> 0x01ac }
            if (r8 != 0) goto L_0x016a
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r9 = "ARouter::"
            java.lang.String r1 = "No mapping files were found, check your configuration please!"
            r8.error(r9, r1)     // Catch:{ Exception -> 0x01ac }
        L_0x016a:
            boolean r8 = com.alibaba.android.arouter.launcher.ARouter.debuggable()     // Catch:{ Exception -> 0x01ac }
            if (r8 == 0) goto L_0x01aa
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x01ac }
            java.lang.String r9 = "ARouter::"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x01ac }
            java.lang.String r2 = "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01ac }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r5 = com.alibaba.android.arouter.core.Warehouse.groupsIndex     // Catch:{ Exception -> 0x01ac }
            int r5 = r5.size()     // Catch:{ Exception -> 0x01ac }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01ac }
            r4[r3] = r5     // Catch:{ Exception -> 0x01ac }
            r3 = 1
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r5 = com.alibaba.android.arouter.core.Warehouse.interceptorsIndex     // Catch:{ Exception -> 0x01ac }
            int r5 = r5.size()     // Catch:{ Exception -> 0x01ac }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01ac }
            r4[r3] = r5     // Catch:{ Exception -> 0x01ac }
            r3 = 2
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r5 = com.alibaba.android.arouter.core.Warehouse.providersIndex     // Catch:{ Exception -> 0x01ac }
            int r5 = r5.size()     // Catch:{ Exception -> 0x01ac }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01ac }
            r4[r3] = r5     // Catch:{ Exception -> 0x01ac }
            java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x01ac }
            r8.debug(r9, r1)     // Catch:{ Exception -> 0x01ac }
        L_0x01aa:
            monitor-exit(r0)
            return
        L_0x01ac:
            r8 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r9 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01cd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
            r1.<init>()     // Catch:{ all -> 0x01cd }
            java.lang.String r2 = "ARouter::ARouter init logistics center exception! ["
            r1.append(r2)     // Catch:{ all -> 0x01cd }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x01cd }
            r1.append(r8)     // Catch:{ all -> 0x01cd }
            java.lang.String r8 = "]"
            r1.append(r8)     // Catch:{ all -> 0x01cd }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x01cd }
            r9.<init>(r8)     // Catch:{ all -> 0x01cd }
            throw r9     // Catch:{ all -> 0x01cd }
        L_0x01cd:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.init(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    public static Postcard buildProvider(String str) {
        RouteMeta routeMeta = Warehouse.providersIndex.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("ARouter::Fatal exception when loading group meta. [" + r12.getMessage() + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0195, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b0, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("Init provider failed! " + r12.getMessage());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0024, B:39:0x017c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void completion(com.alibaba.android.arouter.facade.Postcard r12) {
        /*
            java.lang.Class<com.alibaba.android.arouter.core.LogisticsCenter> r0 = com.alibaba.android.arouter.core.LogisticsCenter.class
            monitor-enter(r0)
            if (r12 == 0) goto L_0x01bb
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r1 = com.alibaba.android.arouter.core.Warehouse.routes     // Catch:{ all -> 0x01b9 }
            java.lang.String r2 = r12.getPath()     // Catch:{ all -> 0x01b9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x01b9 }
            com.alibaba.android.arouter.facade.model.RouteMeta r1 = (com.alibaba.android.arouter.facade.model.RouteMeta) r1     // Catch:{ all -> 0x01b9 }
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 != 0) goto L_0x00dc
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r1 = com.alibaba.android.arouter.core.Warehouse.groupsIndex     // Catch:{ all -> 0x01b9 }
            java.lang.String r5 = r12.getGroup()     // Catch:{ all -> 0x01b9 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x01b9 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x01b9 }
            if (r1 == 0) goto L_0x00b0
            boolean r5 = com.alibaba.android.arouter.launcher.ARouter.debuggable()     // Catch:{ Exception -> 0x008f }
            if (r5 == 0) goto L_0x0049
            com.alibaba.android.arouter.facade.template.ILogger r5 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x008f }
            java.lang.String r6 = "ARouter::"
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = "The group [%s] starts loading, trigger by [%s]"
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
            r9[r4] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r12.getPath()     // Catch:{ Exception -> 0x008f }
            r9[r2] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = java.lang.String.format(r7, r8, r9)     // Catch:{ Exception -> 0x008f }
            r5.debug(r6, r7)     // Catch:{ Exception -> 0x008f }
        L_0x0049:
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x008f }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x008f }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ Exception -> 0x008f }
            com.alibaba.android.arouter.facade.template.IRouteGroup r1 = (com.alibaba.android.arouter.facade.template.IRouteGroup) r1     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r5 = com.alibaba.android.arouter.core.Warehouse.routes     // Catch:{ Exception -> 0x008f }
            r1.loadInto(r5)     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r1 = com.alibaba.android.arouter.core.Warehouse.groupsIndex     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
            r1.remove(r5)     // Catch:{ Exception -> 0x008f }
            boolean r1 = com.alibaba.android.arouter.launcher.ARouter.debuggable()     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x008a
            com.alibaba.android.arouter.facade.template.ILogger r1 = com.alibaba.android.arouter.launcher.ARouter.logger     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = "ARouter::"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = "The group [%s] has already been loaded, trigger by [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
            r3[r4] = r8     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r12.getPath()     // Catch:{ Exception -> 0x008f }
            r3[r2] = r4     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = java.lang.String.format(r6, r7, r3)     // Catch:{ Exception -> 0x008f }
            r1.debug(r5, r2)     // Catch:{ Exception -> 0x008f }
        L_0x008a:
            completion(r12)     // Catch:{ all -> 0x01b9 }
            goto L_0x01b7
        L_0x008f:
            r12 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            r2.<init>()     // Catch:{ all -> 0x01b9 }
            java.lang.String r3 = "ARouter::Fatal exception when loading group meta. ["
            r2.append(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b9 }
            r2.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b9 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b9 }
            throw r1     // Catch:{ all -> 0x01b9 }
        L_0x00b0:
            com.alibaba.android.arouter.exception.NoRouteFoundException r1 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            r2.<init>()     // Catch:{ all -> 0x01b9 }
            java.lang.String r3 = "ARouter::There is no route match the path ["
            r2.append(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.String r3 = r12.getPath()     // Catch:{ all -> 0x01b9 }
            r2.append(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.String r3 = "], in group ["
            r2.append(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r12.getGroup()     // Catch:{ all -> 0x01b9 }
            r2.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b9 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b9 }
            throw r1     // Catch:{ all -> 0x01b9 }
        L_0x00dc:
            java.lang.Class r5 = r1.getDestination()     // Catch:{ all -> 0x01b9 }
            r12.setDestination(r5)     // Catch:{ all -> 0x01b9 }
            com.alibaba.android.arouter.facade.enums.RouteType r5 = r1.getType()     // Catch:{ all -> 0x01b9 }
            r12.setType(r5)     // Catch:{ all -> 0x01b9 }
            int r5 = r1.getPriority()     // Catch:{ all -> 0x01b9 }
            r12.setPriority(r5)     // Catch:{ all -> 0x01b9 }
            int r5 = r1.getExtra()     // Catch:{ all -> 0x01b9 }
            r12.setExtra(r5)     // Catch:{ all -> 0x01b9 }
            android.net.Uri r5 = r12.getUri()     // Catch:{ all -> 0x01b9 }
            if (r5 == 0) goto L_0x0159
            java.util.Map r6 = com.alibaba.android.arouter.utils.TextUtils.splitQueryParameters(r5)     // Catch:{ all -> 0x01b9 }
            java.util.Map r7 = r1.getParamsType()     // Catch:{ all -> 0x01b9 }
            boolean r8 = com.alibaba.android.arouter.utils.MapUtils.isNotEmpty(r7)     // Catch:{ all -> 0x01b9 }
            if (r8 == 0) goto L_0x0150
            java.util.Set r8 = r7.entrySet()     // Catch:{ all -> 0x01b9 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01b9 }
        L_0x0114:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x01b9 }
            if (r9 == 0) goto L_0x013a
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x01b9 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x01b9 }
            java.lang.Object r10 = r9.getValue()     // Catch:{ all -> 0x01b9 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x01b9 }
            java.lang.Object r11 = r9.getKey()     // Catch:{ all -> 0x01b9 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01b9 }
            java.lang.Object r9 = r9.getKey()     // Catch:{ all -> 0x01b9 }
            java.lang.Object r9 = r6.get(r9)     // Catch:{ all -> 0x01b9 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01b9 }
            setValue(r12, r10, r11, r9)     // Catch:{ all -> 0x01b9 }
            goto L_0x0114
        L_0x013a:
            android.os.Bundle r6 = r12.getExtras()     // Catch:{ all -> 0x01b9 }
            java.lang.String r8 = "wmHzgD4lOj5o4241"
            java.util.Set r7 = r7.keySet()     // Catch:{ all -> 0x01b9 }
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x01b9 }
            java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x01b9 }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x01b9 }
            r6.putStringArray(r8, r7)     // Catch:{ all -> 0x01b9 }
        L_0x0150:
            java.lang.String r6 = "NTeRQWvye18AkPd6G"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01b9 }
            r12.withString(r6, r5)     // Catch:{ all -> 0x01b9 }
        L_0x0159:
            int[] r5 = com.alibaba.android.arouter.core.LogisticsCenter.AnonymousClass1.$SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType     // Catch:{ all -> 0x01b9 }
            com.alibaba.android.arouter.facade.enums.RouteType r6 = r1.getType()     // Catch:{ all -> 0x01b9 }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x01b9 }
            r5 = r5[r6]     // Catch:{ all -> 0x01b9 }
            if (r5 == r2) goto L_0x016e
            if (r5 == r3) goto L_0x016a
            goto L_0x01b7
        L_0x016a:
            r12.greenChannel()     // Catch:{ all -> 0x01b9 }
            goto L_0x01b7
        L_0x016e:
            java.lang.Class r1 = r1.getDestination()     // Catch:{ all -> 0x01b9 }
            java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r2 = com.alibaba.android.arouter.core.Warehouse.providers     // Catch:{ all -> 0x01b9 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x01b9 }
            com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ all -> 0x01b9 }
            if (r2 != 0) goto L_0x01b1
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0195 }
            java.lang.reflect.Constructor r2 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0195 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x0195 }
            com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ Exception -> 0x0195 }
            android.content.Context r3 = mContext     // Catch:{ Exception -> 0x0195 }
            r2.init(r3)     // Catch:{ Exception -> 0x0195 }
            java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r3 = com.alibaba.android.arouter.core.Warehouse.providers     // Catch:{ Exception -> 0x0195 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x0195 }
            goto L_0x01b1
        L_0x0195:
            r12 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            r2.<init>()     // Catch:{ all -> 0x01b9 }
            java.lang.String r3 = "Init provider failed! "
            r2.append(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b9 }
            r2.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b9 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b9 }
            throw r1     // Catch:{ all -> 0x01b9 }
        L_0x01b1:
            r12.setProvider(r2)     // Catch:{ all -> 0x01b9 }
            r12.greenChannel()     // Catch:{ all -> 0x01b9 }
        L_0x01b7:
            monitor-exit(r0)
            return
        L_0x01b9:
            r12 = move-exception
            goto L_0x01c3
        L_0x01bb:
            com.alibaba.android.arouter.exception.NoRouteFoundException r12 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b9 }
            java.lang.String r1 = "ARouter::No postcard!"
            r12.<init>(r1)     // Catch:{ all -> 0x01b9 }
            throw r12     // Catch:{ all -> 0x01b9 }
        L_0x01c3:
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.completion(com.alibaba.android.arouter.facade.Postcard):void");
    }

    /* renamed from: com.alibaba.android.arouter.core.LogisticsCenter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.AnonymousClass1.<clinit>():void");
        }
    }

    private static void setValue(Postcard postcard, Integer num, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (num != null) {
                try {
                    if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                        postcard.withBoolean(str, Boolean.parseBoolean(str2));
                    } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                        postcard.withByte(str, Byte.valueOf(str2).byteValue());
                    } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                        postcard.withShort(str, Short.valueOf(str2).shortValue());
                    } else if (num.intValue() == TypeKind.INT.ordinal()) {
                        postcard.withInt(str, Integer.valueOf(str2).intValue());
                    } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                        postcard.withLong(str, Long.valueOf(str2).longValue());
                    } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                        postcard.withFloat(str, Float.valueOf(str2).floatValue());
                    } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                        postcard.withDouble(str, Double.valueOf(str2).doubleValue());
                    } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                        postcard.withString(str, str2);
                    } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                        if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                            postcard.withString(str, str2);
                        } else {
                            postcard.withString(str, str2);
                        }
                    }
                } catch (Throwable th) {
                    ILogger iLogger = ARouter.logger;
                    iLogger.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
                }
            } else {
                postcard.withString(str, str2);
            }
        }
    }

    public static void suspend() {
        Warehouse.clear();
    }
}
