package com.amazonaws.handlers;

import java.util.List;

public class HandlerChainFactory {
    public List<RequestHandler2> newRequestHandlerChain(String str) {
        return createRequestHandlerChain(str, RequestHandler.class);
    }

    public List<RequestHandler2> newRequestHandler2Chain(String str) {
        return createRequestHandlerChain(str, RequestHandler2.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7 A[SYNTHETIC, Splitter:B:39:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.amazonaws.handlers.RequestHandler2> createRequestHandlerChain(java.lang.String r6, java.lang.Class<?> r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Class r2 = r5.getClass()     // Catch:{ Exception -> 0x0099 }
            java.io.InputStream r6 = r2.getResourceAsStream(r6)     // Catch:{ Exception -> 0x0099 }
            if (r6 != 0) goto L_0x0011
            return r0
        L_0x0011:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0099 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0099 }
            java.nio.charset.Charset r4 = com.amazonaws.util.StringUtils.UTF8     // Catch:{ Exception -> 0x0099 }
            r3.<init>(r6, r4)     // Catch:{ Exception -> 0x0099 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0099 }
        L_0x001d:
            java.lang.String r6 = r2.readLine()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r6 != 0) goto L_0x0027
            r2.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            return r0
        L_0x0027:
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r1 == 0) goto L_0x0034
            goto L_0x001d
        L_0x0034:
            r1 = 2
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r3 = 0
            r1[r3] = r7     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r3 = 1
            java.lang.Class r4 = r5.getClass()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r1[r3] = r4     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.Class r1 = com.amazonaws.util.ClassLoaderHelper.loadClass(r6, r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            boolean r3 = r7.isInstance(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            if (r3 == 0) goto L_0x006d
            java.lang.Class<com.amazonaws.handlers.RequestHandler2> r6 = com.amazonaws.handlers.RequestHandler2.class
            if (r7 != r6) goto L_0x0059
            com.amazonaws.handlers.RequestHandler2 r1 = (com.amazonaws.handlers.RequestHandler2) r1     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r0.add(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            goto L_0x001d
        L_0x0059:
            java.lang.Class<com.amazonaws.handlers.RequestHandler> r6 = com.amazonaws.handlers.RequestHandler.class
            if (r7 != r6) goto L_0x0067
            com.amazonaws.handlers.RequestHandler r1 = (com.amazonaws.handlers.RequestHandler) r1     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            com.amazonaws.handlers.RequestHandler2 r6 = com.amazonaws.handlers.RequestHandler2.adapt(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r0.add(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            goto L_0x001d
        L_0x0067:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r6.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            throw r6     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
        L_0x006d:
            com.amazonaws.AmazonClientException r0 = new com.amazonaws.AmazonClientException     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r1.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r3 = "Unable to instantiate request handler chain for client.  Listed request handler ('"
            r1.append(r3)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r1.append(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r6 = "') does not implement the "
            r1.append(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r1.append(r7)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r6 = " API."
            r1.append(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r0.<init>((java.lang.String) r6)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            throw r0     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
        L_0x0091:
            r6 = move-exception
            r1 = r2
            goto L_0x00b5
        L_0x0094:
            r6 = move-exception
            r1 = r2
            goto L_0x009a
        L_0x0097:
            r6 = move-exception
            goto L_0x00b5
        L_0x0099:
            r6 = move-exception
        L_0x009a:
            com.amazonaws.AmazonClientException r7 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            r0.<init>()     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "Unable to instantiate request handler chain for client: "
            r0.append(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = r6.getMessage()     // Catch:{ all -> 0x0097 }
            r0.append(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0097 }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x0097 }
            throw r7     // Catch:{ all -> 0x0097 }
        L_0x00b5:
            if (r1 == 0) goto L_0x00ba
            r1.close()     // Catch:{ IOException -> 0x00ba }
        L_0x00ba:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.handlers.HandlerChainFactory.createRequestHandlerChain(java.lang.String, java.lang.Class):java.util.List");
    }
}
