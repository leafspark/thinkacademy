package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "pageId", "", "actionMap", "", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiBackAgent.kt */
final class GraffitiBackAgent$setListener$1 extends Lambda implements Function2<String, Map<String, ? extends List<? extends WXWBAction>>, Unit> {
    final /* synthetic */ GraffitiBackAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiBackAgent$setListener$1(GraffitiBackAgent graffitiBackAgent) {
        super(2);
        this.this$0 = graffitiBackAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Map<String, ? extends List<? extends WXWBAction>>) (Map) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00be A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.String r20, java.util.Map<java.lang.String, ? extends java.util.List<? extends com.xueersi.lib.graffiti.WXWBAction>> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "pageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            java.lang.String r3 = r3.getMTeacherUid()
            r4 = -1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            if (r3 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r2.put(r1, r4)
        L_0x0022:
            java.lang.String r3 = "2"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r5 = r0.this$0
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r5 = r5.getMLiveRoomProvider()
            java.lang.String r5 = r5.getClassType()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            r5 = 95
            r6 = 0
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x00af
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            java.util.List r3 = r3.mPageKeyList
            if (r3 != 0) goto L_0x0047
        L_0x0045:
            r3 = r8
            goto L_0x0074
        L_0x0047:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x004d:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x006a
            java.lang.Object r9 = r3.next()
            r10 = r9
            com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage r10 = (com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage) r10
            java.lang.String r10 = r10.getPageKey()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r11 = r1
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r10 = android.text.TextUtils.equals(r10, r11)
            if (r10 == 0) goto L_0x004d
            goto L_0x006b
        L_0x006a:
            r9 = r8
        L_0x006b:
            com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage r9 = (com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage) r9
            if (r9 != 0) goto L_0x0070
            goto L_0x0045
        L_0x0070:
            java.util.List r3 = r9.getUserIdList()
        L_0x0074:
            if (r3 != 0) goto L_0x0077
            goto L_0x00a0
        L_0x0077:
            r9 = r3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x007e:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00a0
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            r11.append(r5)
            r11.append(r1)
            java.lang.String r10 = r11.toString()
            r2.put(r10, r4)
            goto L_0x007e
        L_0x00a0:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r4 = r0.this$0
            java.lang.Object[] r9 = new java.lang.Object[r7]
            java.lang.String r10 = "当前页授权涂鸦人员-远端，"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r3)
            r9[r6] = r3
            r4.log(r9)
        L_0x00af:
            if (r21 != 0) goto L_0x00b4
            r3 = r8
            goto L_0x01d1
        L_0x00b4:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            java.util.Set r4 = r21.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00be:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x01cf
            java.lang.Object r9 = r4.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getValue()
            java.util.List r10 = (java.util.List) r10
            java.lang.String r11 = "，共计有"
            if (r10 != 0) goto L_0x00d7
        L_0x00d4:
            r10 = r8
            goto L_0x0190
        L_0x00d7:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            boolean r12 = r10.hasNext()
            if (r12 != 0) goto L_0x00e5
            r12 = r8
            goto L_0x0110
        L_0x00e5:
            java.lang.Object r12 = r10.next()
            boolean r13 = r10.hasNext()
            if (r13 != 0) goto L_0x00f0
            goto L_0x0110
        L_0x00f0:
            r13 = r12
            com.xueersi.lib.graffiti.WXWBAction r13 = (com.xueersi.lib.graffiti.WXWBAction) r13
            long r13 = r13.getMsgId()
        L_0x00f7:
            java.lang.Object r15 = r10.next()
            r16 = r15
            com.xueersi.lib.graffiti.WXWBAction r16 = (com.xueersi.lib.graffiti.WXWBAction) r16
            long r16 = r16.getMsgId()
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x010a
            r12 = r15
            r13 = r16
        L_0x010a:
            boolean r15 = r10.hasNext()
            if (r15 != 0) goto L_0x00f7
        L_0x0110:
            com.xueersi.lib.graffiti.WXWBAction r12 = (com.xueersi.lib.graffiti.WXWBAction) r12
            if (r12 != 0) goto L_0x0115
            goto L_0x00d4
        L_0x0115:
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "本地DB 用户id "
            r13.append(r14)
            java.lang.Object r14 = r9.getKey()
            java.lang.String r14 = (java.lang.String) r14
            r13.append(r14)
            r13.append(r11)
            java.lang.Object r14 = r9.getValue()
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x0137
            r14 = r8
            goto L_0x013f
        L_0x0137:
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
        L_0x013f:
            r13.append(r14)
            java.lang.String r14 = "条，最后一条消息是"
            r13.append(r14)
            java.lang.String r14 = r12.getUniqueKey()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r10[r6] = r13
            r3.log(r10)
            java.lang.String r10 = r3.getMTeacherUid()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.Object r13 = r9.getKey()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r10 = android.text.TextUtils.equals(r10, r13)
            if (r10 == 0) goto L_0x016b
            r10 = r1
            goto L_0x0183
        L_0x016b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.Object r13 = r9.getKey()
            java.lang.String r13 = (java.lang.String) r13
            r10.append(r13)
            r10.append(r5)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
        L_0x0183:
            long r12 = r12.getMsgId()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r2.put(r10, r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x0190:
            if (r10 != 0) goto L_0x00be
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "本地DB 用户 "
            r12.append(r13)
            java.lang.Object r13 = r9.getKey()
            java.lang.String r13 = (java.lang.String) r13
            r12.append(r13)
            r12.append(r11)
            java.lang.Object r9 = r9.getValue()
            java.util.List r9 = (java.util.List) r9
            if (r9 != 0) goto L_0x01b4
            r9 = r8
            goto L_0x01bc
        L_0x01b4:
            int r9 = r9.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L_0x01bc:
            r12.append(r9)
            r9 = 26465(0x6761, float:3.7085E-41)
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r10[r6] = r9
            r3.log(r10)
            goto L_0x00be
        L_0x01cf:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x01d1:
            if (r3 != 0) goto L_0x01e2
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.String r5 = "本地DB数据为空,当前pageId "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)
            r4[r6] = r5
            r3.log(r4)
        L_0x01e2:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            java.util.Set r3 = r3.mLoadedPageSet
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L_0x0203
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r2 = r0.this$0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.String r4 = "已浏览过当前页，无须请求增量数据，pageId "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r1)
            r3[r6] = r1
            r2.log(r3)
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r1 = r0.this$0
            r1.syncAddActionList(r8)
            goto L_0x0208
        L_0x0203:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent r3 = r0.this$0
            r3.requestHistoryMsg(r1, r2)
        L_0x0208:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiBackAgent$setListener$1.invoke(java.lang.String, java.util.Map):void");
    }
}
