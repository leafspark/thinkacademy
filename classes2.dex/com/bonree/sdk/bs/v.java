package com.bonree.sdk.bs;

import com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class v {
    private List<NetworkRequestExtraBean> a = Collections.synchronizedList(new ArrayList());
    private Map<String, Integer> b = Collections.synchronizedMap(new LinkedHashMap());

    public final synchronized List a() {
        if (this.b.size() <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (String add : this.b.keySet()) {
            linkedList.add(add);
        }
        return Arrays.asList(this.b.keySet().toArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x003b }
            r1 = 0
            if (r0 != 0) goto L_0x0039
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x000f
            goto L_0x0039
        L_0x000f:
            java.util.List<com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean> r0 = r4.a     // Catch:{ all -> 0x003b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003b }
        L_0x0015:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x003b }
            com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean r2 = (com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean) r2     // Catch:{ all -> 0x003b }
            java.lang.String r3 = r2.getKey()     // Catch:{ all -> 0x003b }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0015
            java.lang.String r3 = r2.getValue()     // Catch:{ all -> 0x003b }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0015
            monitor-exit(r4)
            return r2
        L_0x0037:
            monitor-exit(r4)
            return r1
        L_0x0039:
            monitor-exit(r4)
            return r1
        L_0x003b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.v.a(java.lang.String, java.lang.String):com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0048
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x000e
            goto L_0x0048
        L_0x000e:
            com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean r0 = r2.a(r3, r4)     // Catch:{ all -> 0x004b }
            r1 = 1
            if (r0 == 0) goto L_0x001a
            r0.setInfo(r5)     // Catch:{ all -> 0x004b }
            monitor-exit(r2)
            return r1
        L_0x001a:
            com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean r0 = new com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean     // Catch:{ all -> 0x004b }
            r0.<init>(r3, r4, r5)     // Catch:{ all -> 0x004b }
            java.util.List<com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean> r4 = r2.a     // Catch:{ all -> 0x004b }
            r4.add(r0)     // Catch:{ all -> 0x004b }
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r2.b     // Catch:{ all -> 0x004b }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x004b }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x004b }
            if (r4 != 0) goto L_0x0038
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r2.b     // Catch:{ all -> 0x004b }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004b }
            r4.put(r3, r5)     // Catch:{ all -> 0x004b }
            goto L_0x0046
        L_0x0038:
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r2.b     // Catch:{ all -> 0x004b }
            int r4 = r4.intValue()     // Catch:{ all -> 0x004b }
            int r4 = r4 + r1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x004b }
            r5.put(r3, r4)     // Catch:{ all -> 0x004b }
        L_0x0046:
            monitor-exit(r2)
            return r1
        L_0x0048:
            r3 = 0
            monitor-exit(r2)
            return r3
        L_0x004b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.v.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0024 }
            r1 = 0
            if (r0 != 0) goto L_0x0022
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0022
        L_0x000f:
            com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean r4 = r2.a(r3, r4)     // Catch:{ all -> 0x0024 }
            if (r4 != 0) goto L_0x0017
            monitor-exit(r2)
            return r1
        L_0x0017:
            java.util.List<com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean> r0 = r2.a     // Catch:{ all -> 0x0024 }
            r0.remove(r4)     // Catch:{ all -> 0x0024 }
            r2.a(r3)     // Catch:{ all -> 0x0024 }
            r3 = 1
            monitor-exit(r2)
            return r3
        L_0x0022:
            monitor-exit(r2)
            return r1
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.v.b(java.lang.String, java.lang.String):boolean");
    }

    private void a(String str) {
        Integer num = this.b.get(str);
        if (num == null) {
            return;
        }
        if (num.intValue() == 1) {
            this.b.remove(str);
        } else {
            this.b.put(str, Integer.valueOf(num.intValue() - 1));
        }
    }

    public final synchronized boolean b() {
        if (this.a.size() <= 0) {
            return false;
        }
        this.a.remove(0);
        a(this.a.get(0).getKey());
        return true;
    }

    public final synchronized int c() {
        return this.a.size();
    }

    public final synchronized void d() {
        this.a.clear();
    }
}
