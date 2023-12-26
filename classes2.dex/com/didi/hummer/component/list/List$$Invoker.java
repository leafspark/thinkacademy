package com.didi.hummer.component.list;

import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class List$$Invoker extends BaseInvoker<List> {
    public String getName() {
        return "List";
    }

    /* access modifiers changed from: protected */
    public List createInstance(JSValue jSValue, Object[] objArr) {
        return new List(this.mHummerContext, jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: boolean} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(com.didi.hummer.component.list.List r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            r6 = this;
            r8.hashCode()
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1738844252: goto L_0x00cc;
                case -1352024204: goto L_0x00c1;
                case -1259530691: goto L_0x00b6;
                case -1250991063: goto L_0x00ab;
                case -980170895: goto L_0x00a0;
                case -746082806: goto L_0x0095;
                case -692803550: goto L_0x008a;
                case -402165756: goto L_0x007f;
                case -402165208: goto L_0x0071;
                case -333855302: goto L_0x0063;
                case 495720030: goto L_0x0055;
                case 672127869: goto L_0x0047;
                case 796768860: goto L_0x0039;
                case 925617692: goto L_0x002b;
                case 1085444827: goto L_0x001d;
                case 1122173511: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x00d6
        L_0x000f:
            java.lang.String r0 = "setShowScrollBar"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0019
            goto L_0x00d6
        L_0x0019:
            r3 = 15
            goto L_0x00d6
        L_0x001d:
            java.lang.String r0 = "refresh"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0027
            goto L_0x00d6
        L_0x0027:
            r3 = 14
            goto L_0x00d6
        L_0x002b:
            java.lang.String r0 = "dbg_getDescription"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0035
            goto L_0x00d6
        L_0x0035:
            r3 = 13
            goto L_0x00d6
        L_0x0039:
            java.lang.String r0 = "setOnLoadMore"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0043
            goto L_0x00d6
        L_0x0043:
            r3 = 12
            goto L_0x00d6
        L_0x0047:
            java.lang.String r0 = "stopLoadMore"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0051
            goto L_0x00d6
        L_0x0051:
            r3 = 11
            goto L_0x00d6
        L_0x0055:
            java.lang.String r0 = "setRefreshView"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x005f
            goto L_0x00d6
        L_0x005f:
            r3 = 10
            goto L_0x00d6
        L_0x0063:
            java.lang.String r0 = "setOnRefresh"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x006d
            goto L_0x00d6
        L_0x006d:
            r3 = 9
            goto L_0x00d6
        L_0x0071:
            java.lang.String r0 = "scrollTo"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x007b
            goto L_0x00d6
        L_0x007b:
            r3 = 8
            goto L_0x00d6
        L_0x007f:
            java.lang.String r0 = "scrollBy"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0088
            goto L_0x00d6
        L_0x0088:
            r3 = 7
            goto L_0x00d6
        L_0x008a:
            java.lang.String r0 = "setLoadMoreView"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0093
            goto L_0x00d6
        L_0x0093:
            r3 = 6
            goto L_0x00d6
        L_0x0095:
            java.lang.String r0 = "setOnUpdate"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x009e
            goto L_0x00d6
        L_0x009e:
            r3 = 5
            goto L_0x00d6
        L_0x00a0:
            java.lang.String r0 = "scrollToPosition"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00a9
            goto L_0x00d6
        L_0x00a9:
            r3 = 4
            goto L_0x00d6
        L_0x00ab:
            java.lang.String r0 = "setBounces"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00b4
            goto L_0x00d6
        L_0x00b4:
            r3 = 3
            goto L_0x00d6
        L_0x00b6:
            java.lang.String r0 = "setOnCreate"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00bf
            goto L_0x00d6
        L_0x00bf:
            r3 = 2
            goto L_0x00d6
        L_0x00c1:
            java.lang.String r0 = "stopPullRefresh"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00ca
            goto L_0x00d6
        L_0x00ca:
            r3 = r1
            goto L_0x00d6
        L_0x00cc:
            java.lang.String r0 = "setOnRegister"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r3 = r2
        L_0x00d6:
            r4 = 0
            r8 = 0
            switch(r3) {
                case 0: goto L_0x02b8;
                case 1: goto L_0x02b4;
                case 2: goto L_0x02a3;
                case 3: goto L_0x0290;
                case 4: goto L_0x027d;
                case 5: goto L_0x026c;
                case 6: goto L_0x0251;
                case 7: goto L_0x01e6;
                case 8: goto L_0x017b;
                case 9: goto L_0x0169;
                case 10: goto L_0x014d;
                case 11: goto L_0x0139;
                case 12: goto L_0x0127;
                case 13: goto L_0x0106;
                case 14: goto L_0x00f2;
                case 15: goto L_0x00de;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            goto L_0x02c8
        L_0x00de:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x00ed
            r0 = r9[r2]
            if (r0 == 0) goto L_0x00ed
            r9 = r9[r2]
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x00ed:
            r7.setShowScrollBar(r2)
            goto L_0x02c8
        L_0x00f2:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0101
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0101
            r9 = r9[r2]
            java.lang.Number r9 = (java.lang.Number) r9
            int r2 = r9.intValue()
        L_0x0101:
            r7.refresh(r2)
            goto L_0x02c8
        L_0x0106:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0112
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0112
            r0 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r0 = (com.didi.hummer.core.engine.JSCallback) r0
            goto L_0x0113
        L_0x0112:
            r0 = r8
        L_0x0113:
            int r3 = r9.length
            if (r3 <= r1) goto L_0x0122
            r3 = r9[r1]
            if (r3 == 0) goto L_0x0122
            r9 = r9[r1]
            java.lang.Number r9 = (java.lang.Number) r9
            int r2 = r9.intValue()
        L_0x0122:
            r7.dbg_getDescription(r0, r2)
            goto L_0x02c8
        L_0x0127:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0133
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0133
            r9 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r9 = (com.didi.hummer.core.engine.JSCallback) r9
            goto L_0x0134
        L_0x0133:
            r9 = r8
        L_0x0134:
            r7.setOnLoadMore(r9)
            goto L_0x02c8
        L_0x0139:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0148
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0148
            r9 = r9[r2]
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x0148:
            r7.stopLoadMore(r2)
            goto L_0x02c8
        L_0x014d:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x015c
            r0 = r9[r2]
            if (r0 == 0) goto L_0x015c
            r9 = r9[r2]
            java.lang.Number r9 = (java.lang.Number) r9
            long r4 = r9.longValue()
        L_0x015c:
            com.didi.hummer.pool.ObjectPool r9 = r6.mInstanceManager
            java.lang.Object r9 = r9.get(r4)
            com.didi.hummer.render.component.view.HMBase r9 = (com.didi.hummer.render.component.view.HMBase) r9
            r7.setRefreshView(r9)
            goto L_0x02c8
        L_0x0169:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0175
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0175
            r9 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r9 = (com.didi.hummer.core.engine.JSCallback) r9
            goto L_0x0176
        L_0x0175:
            r9 = r8
        L_0x0176:
            r7.setOnRefresh(r9)
            goto L_0x02c8
        L_0x017b:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x01ad
            r0 = r9[r2]
            boolean r0 = r0 instanceof java.lang.String
            if (r0 == 0) goto L_0x01aa
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = com.didi.hummer.core.util.HMGsonUtil.isJsonObject(r0)
            if (r0 != 0) goto L_0x0198
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = com.didi.hummer.core.util.HMGsonUtil.isJsonArray(r0)
            if (r0 == 0) goto L_0x01aa
        L_0x0198:
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            com.didi.hummer.component.list.List$$Invoker$1 r2 = new com.didi.hummer.component.list.List$$Invoker$1
            r2.<init>()
            java.lang.reflect.Type r2 = r2.getType()
            java.lang.Object r0 = com.didi.hummer.core.util.HMGsonUtil.fromJson(r0, r2)
            goto L_0x01ae
        L_0x01aa:
            r0 = r9[r2]
            goto L_0x01ae
        L_0x01ad:
            r0 = r8
        L_0x01ae:
            int r2 = r9.length
            if (r2 <= r1) goto L_0x01e0
            r2 = r9[r1]
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x01dd
            r2 = r9[r1]
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = com.didi.hummer.core.util.HMGsonUtil.isJsonObject(r2)
            if (r2 != 0) goto L_0x01cb
            r2 = r9[r1]
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = com.didi.hummer.core.util.HMGsonUtil.isJsonArray(r2)
            if (r2 == 0) goto L_0x01dd
        L_0x01cb:
            r9 = r9[r1]
            java.lang.String r9 = (java.lang.String) r9
            com.didi.hummer.component.list.List$$Invoker$2 r1 = new com.didi.hummer.component.list.List$$Invoker$2
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r9 = com.didi.hummer.core.util.HMGsonUtil.fromJson(r9, r1)
            goto L_0x01e1
        L_0x01dd:
            r9 = r9[r1]
            goto L_0x01e1
        L_0x01e0:
            r9 = r8
        L_0x01e1:
            r7.scrollTo(r0, r9)
            goto L_0x02c8
        L_0x01e6:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0218
            r0 = r9[r2]
            boolean r0 = r0 instanceof java.lang.String
            if (r0 == 0) goto L_0x0215
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = com.didi.hummer.core.util.HMGsonUtil.isJsonObject(r0)
            if (r0 != 0) goto L_0x0203
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = com.didi.hummer.core.util.HMGsonUtil.isJsonArray(r0)
            if (r0 == 0) goto L_0x0215
        L_0x0203:
            r0 = r9[r2]
            java.lang.String r0 = (java.lang.String) r0
            com.didi.hummer.component.list.List$$Invoker$3 r2 = new com.didi.hummer.component.list.List$$Invoker$3
            r2.<init>()
            java.lang.reflect.Type r2 = r2.getType()
            java.lang.Object r0 = com.didi.hummer.core.util.HMGsonUtil.fromJson(r0, r2)
            goto L_0x0219
        L_0x0215:
            r0 = r9[r2]
            goto L_0x0219
        L_0x0218:
            r0 = r8
        L_0x0219:
            int r2 = r9.length
            if (r2 <= r1) goto L_0x024b
            r2 = r9[r1]
            boolean r2 = r2 instanceof java.lang.String
            if (r2 == 0) goto L_0x0248
            r2 = r9[r1]
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = com.didi.hummer.core.util.HMGsonUtil.isJsonObject(r2)
            if (r2 != 0) goto L_0x0236
            r2 = r9[r1]
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = com.didi.hummer.core.util.HMGsonUtil.isJsonArray(r2)
            if (r2 == 0) goto L_0x0248
        L_0x0236:
            r9 = r9[r1]
            java.lang.String r9 = (java.lang.String) r9
            com.didi.hummer.component.list.List$$Invoker$4 r1 = new com.didi.hummer.component.list.List$$Invoker$4
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r9 = com.didi.hummer.core.util.HMGsonUtil.fromJson(r9, r1)
            goto L_0x024c
        L_0x0248:
            r9 = r9[r1]
            goto L_0x024c
        L_0x024b:
            r9 = r8
        L_0x024c:
            r7.scrollBy(r0, r9)
            goto L_0x02c8
        L_0x0251:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0260
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0260
            r9 = r9[r2]
            java.lang.Number r9 = (java.lang.Number) r9
            long r4 = r9.longValue()
        L_0x0260:
            com.didi.hummer.pool.ObjectPool r9 = r6.mInstanceManager
            java.lang.Object r9 = r9.get(r4)
            com.didi.hummer.render.component.view.HMBase r9 = (com.didi.hummer.render.component.view.HMBase) r9
            r7.setLoadMoreView(r9)
            goto L_0x02c8
        L_0x026c:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0278
            r0 = r9[r2]
            if (r0 == 0) goto L_0x0278
            r9 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r9 = (com.didi.hummer.core.engine.JSCallback) r9
            goto L_0x0279
        L_0x0278:
            r9 = r8
        L_0x0279:
            r7.setOnUpdate(r9)
            goto L_0x02c8
        L_0x027d:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x028c
            r0 = r9[r2]
            if (r0 == 0) goto L_0x028c
            r9 = r9[r2]
            java.lang.Number r9 = (java.lang.Number) r9
            int r2 = r9.intValue()
        L_0x028c:
            r7.scrollToPosition(r2)
            goto L_0x02c8
        L_0x0290:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x029f
            r0 = r9[r2]
            if (r0 == 0) goto L_0x029f
            r9 = r9[r2]
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x029f:
            r7.setBounces(r2)
            goto L_0x02c8
        L_0x02a3:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x02af
            r0 = r9[r2]
            if (r0 == 0) goto L_0x02af
            r9 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r9 = (com.didi.hummer.core.engine.JSCallback) r9
            goto L_0x02b0
        L_0x02af:
            r9 = r8
        L_0x02b0:
            r7.setOnCreate(r9)
            goto L_0x02c8
        L_0x02b4:
            r7.stopPullRefresh()
            goto L_0x02c8
        L_0x02b8:
            int r0 = r9.length
            if (r0 <= 0) goto L_0x02c4
            r0 = r9[r2]
            if (r0 == 0) goto L_0x02c4
            r9 = r9[r2]
            com.didi.hummer.core.engine.JSCallback r9 = (com.didi.hummer.core.engine.JSCallback) r9
            goto L_0x02c5
        L_0x02c4:
            r9 = r8
        L_0x02c5:
            r7.setOnRegister(r9)
        L_0x02c8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.list.List$$Invoker.invoke(com.didi.hummer.component.list.List, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
