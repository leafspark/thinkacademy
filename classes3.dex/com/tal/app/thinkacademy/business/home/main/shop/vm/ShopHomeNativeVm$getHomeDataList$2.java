package com.tal.app.thinkacademy.business.home.main.shop.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataList$2", f = "ShopHomeNativeVm.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopHomeNativeVm.kt */
final class ShopHomeNativeVm$getHomeDataList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $channelId;
    final /* synthetic */ Ref.LongRef $startCurrentTime;
    int label;
    final /* synthetic */ ShopHomeNativeVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeVm$getHomeDataList$2(ShopHomeNativeVm shopHomeNativeVm, int i, Ref.LongRef longRef, Continuation<? super ShopHomeNativeVm$getHomeDataList$2> continuation) {
        super(2, continuation);
        this.this$0 = shopHomeNativeVm;
        this.$channelId = i;
        this.$startCurrentTime = longRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopHomeNativeVm$getHomeDataList$2(this.this$0, this.$channelId, this.$startCurrentTime, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopHomeNativeVm$getHomeDataList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b5 A[Catch:{ Exception -> 0x01d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c1 A[Catch:{ Exception -> 0x01d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0224 A[Catch:{ Exception -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0230 A[Catch:{ Exception -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0293 A[Catch:{ Exception -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x029f A[Catch:{ Exception -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9 A[Catch:{ Exception -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e5 A[Catch:{ Exception -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0146 A[Catch:{ Exception -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0152 A[Catch:{ Exception -> 0x0169 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x002a
        L_0x000f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r14)
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm r14 = r13.this$0
            int r1 = r13.$channelId
            r3 = r13
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r13.label = r2
            java.lang.Object r14 = r14.getHomeDataListReal(r1, r3)
            if (r14 != r0) goto L_0x002a
            return r0
        L_0x002a:
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeData r14 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeData) r14
            java.lang.Object[] r0 = new java.lang.Object[r2]
            long r3 = java.lang.System.currentTimeMillis()
            kotlin.jvm.internal.Ref$LongRef r1 = r13.$startCurrentTime
            long r5 = r1.element
            long r3 = r3 - r5
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
            java.lang.String r3 = "mHomeDataList success costTime = "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            r3 = 0
            r0[r3] = r1
            java.lang.String r1 = "ShopHomeNativeVm"
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            if (r14 != 0) goto L_0x0054
            goto L_0x02e7
        L_0x0054:
            java.util.List r4 = r14.getModuleContents()
            if (r4 != 0) goto L_0x005c
            goto L_0x02c4
        L_0x005c:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = r3
        L_0x0063:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x02c4
            java.lang.Object r6 = r4.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x0074
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0074:
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataModuleContent r6 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataModuleContent) r6
            java.lang.Integer r5 = r6.getType()
            if (r5 != 0) goto L_0x007d
            goto L_0x0085
        L_0x007d:
            int r8 = r5.intValue()
            if (r8 != r2) goto L_0x0085
        L_0x0083:
            r8 = r2
            goto L_0x0091
        L_0x0085:
            r8 = 4
            if (r5 != 0) goto L_0x0089
            goto L_0x0090
        L_0x0089:
            int r9 = r5.intValue()
            if (r9 != r8) goto L_0x0090
            goto L_0x0083
        L_0x0090:
            r8 = r3
        L_0x0091:
            if (r8 == 0) goto L_0x0095
        L_0x0093:
            r8 = r2
            goto L_0x00a1
        L_0x0095:
            r8 = 5
            if (r5 != 0) goto L_0x0099
            goto L_0x00a0
        L_0x0099:
            int r9 = r5.intValue()
            if (r9 != r8) goto L_0x00a0
            goto L_0x0093
        L_0x00a0:
            r8 = r3
        L_0x00a1:
            java.lang.String r9 = "error = "
            r10 = 2
            r11 = 0
            if (r8 == 0) goto L_0x010a
            java.lang.String r5 = r6.getContent()     // Catch:{ Exception -> 0x00fc }
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1> r6 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r5, r6)     // Catch:{ Exception -> 0x00fc }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1 r5 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1) r5     // Catch:{ Exception -> 0x00fc }
            java.util.List r6 = r5.getCourseList()     // Catch:{ Exception -> 0x00fc }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x00fc }
            if (r6 == 0) goto L_0x00c4
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x00fc }
            if (r6 == 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r6 = r3
            goto L_0x00c5
        L_0x00c4:
            r6 = r2
        L_0x00c5:
            if (r6 != 0) goto L_0x02c1
            java.util.List r6 = r5.getCourseList()     // Catch:{ Exception -> 0x00fc }
            int r6 = r6.size()     // Catch:{ Exception -> 0x00fc }
            if (r6 <= 0) goto L_0x02c1
            java.lang.String r6 = r5.getTitle()     // Catch:{ Exception -> 0x00fc }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00fc }
            if (r6 == 0) goto L_0x00e2
            int r6 = r6.length()     // Catch:{ Exception -> 0x00fc }
            if (r6 != 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r6 = r3
            goto L_0x00e3
        L_0x00e2:
            r6 = r2
        L_0x00e3:
            if (r6 != 0) goto L_0x00f1
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode     // Catch:{ Exception -> 0x00fc }
            java.lang.String r8 = r5.getTitle()     // Catch:{ Exception -> 0x00fc }
            r6.<init>(r8, r11, r10, r11)     // Catch:{ Exception -> 0x00fc }
            r0.add(r6)     // Catch:{ Exception -> 0x00fc }
        L_0x00f1:
            java.util.List r5 = r5.getCourseList()     // Catch:{ Exception -> 0x00fc }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x00fc }
            r0.addAll(r5)     // Catch:{ Exception -> 0x00fc }
            goto L_0x02c1
        L_0x00fc:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r5)
            r6[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r6)
            goto L_0x02c1
        L_0x010a:
            if (r5 != 0) goto L_0x010e
            goto L_0x0177
        L_0x010e:
            int r8 = r5.intValue()
            if (r8 != r10) goto L_0x0177
            java.lang.String r5 = r6.getContent()     // Catch:{ Exception -> 0x0169 }
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType2> r6 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType2.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r5, r6)     // Catch:{ Exception -> 0x0169 }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType2 r5 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType2) r5     // Catch:{ Exception -> 0x0169 }
            java.util.List r6 = r5.getClazzList()     // Catch:{ Exception -> 0x0169 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x0169 }
            if (r6 == 0) goto L_0x0131
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x0169 }
            if (r6 == 0) goto L_0x012f
            goto L_0x0131
        L_0x012f:
            r6 = r3
            goto L_0x0132
        L_0x0131:
            r6 = r2
        L_0x0132:
            if (r6 != 0) goto L_0x02c1
            java.util.List r6 = r5.getClazzList()     // Catch:{ Exception -> 0x0169 }
            int r6 = r6.size()     // Catch:{ Exception -> 0x0169 }
            if (r6 <= 0) goto L_0x02c1
            java.lang.String r6 = r5.getTitle()     // Catch:{ Exception -> 0x0169 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0169 }
            if (r6 == 0) goto L_0x014f
            int r6 = r6.length()     // Catch:{ Exception -> 0x0169 }
            if (r6 != 0) goto L_0x014d
            goto L_0x014f
        L_0x014d:
            r6 = r3
            goto L_0x0150
        L_0x014f:
            r6 = r2
        L_0x0150:
            if (r6 != 0) goto L_0x015e
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode     // Catch:{ Exception -> 0x0169 }
            java.lang.String r8 = r5.getTitle()     // Catch:{ Exception -> 0x0169 }
            r6.<init>(r8, r11, r10, r11)     // Catch:{ Exception -> 0x0169 }
            r0.add(r6)     // Catch:{ Exception -> 0x0169 }
        L_0x015e:
            java.util.List r5 = r5.getClazzList()     // Catch:{ Exception -> 0x0169 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x0169 }
            r0.addAll(r5)     // Catch:{ Exception -> 0x0169 }
            goto L_0x02c1
        L_0x0169:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r5)
            r6[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r6)
            goto L_0x02c1
        L_0x0177:
            r8 = 12
            if (r5 != 0) goto L_0x017d
            goto L_0x01e6
        L_0x017d:
            int r12 = r5.intValue()
            if (r12 != r8) goto L_0x01e6
            java.lang.String r5 = r6.getContent()     // Catch:{ Exception -> 0x01d8 }
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12> r6 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r5, r6)     // Catch:{ Exception -> 0x01d8 }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12 r5 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12) r5     // Catch:{ Exception -> 0x01d8 }
            java.util.List r6 = r5.getCourseConfig()     // Catch:{ Exception -> 0x01d8 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x01d8 }
            if (r6 == 0) goto L_0x01a0
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x01d8 }
            if (r6 == 0) goto L_0x019e
            goto L_0x01a0
        L_0x019e:
            r6 = r3
            goto L_0x01a1
        L_0x01a0:
            r6 = r2
        L_0x01a1:
            if (r6 != 0) goto L_0x02c1
            java.util.List r6 = r5.getCourseConfig()     // Catch:{ Exception -> 0x01d8 }
            int r6 = r6.size()     // Catch:{ Exception -> 0x01d8 }
            if (r6 <= 0) goto L_0x02c1
            java.lang.String r6 = r5.getTitle()     // Catch:{ Exception -> 0x01d8 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x01d8 }
            if (r6 == 0) goto L_0x01be
            int r6 = r6.length()     // Catch:{ Exception -> 0x01d8 }
            if (r6 != 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r6 = r3
            goto L_0x01bf
        L_0x01be:
            r6 = r2
        L_0x01bf:
            if (r6 != 0) goto L_0x01cd
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode     // Catch:{ Exception -> 0x01d8 }
            java.lang.String r8 = r5.getTitle()     // Catch:{ Exception -> 0x01d8 }
            r6.<init>(r8, r11, r10, r11)     // Catch:{ Exception -> 0x01d8 }
            r0.add(r6)     // Catch:{ Exception -> 0x01d8 }
        L_0x01cd:
            java.util.List r5 = r5.getCourseConfig()     // Catch:{ Exception -> 0x01d8 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x01d8 }
            r0.addAll(r5)     // Catch:{ Exception -> 0x01d8 }
            goto L_0x02c1
        L_0x01d8:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r5)
            r6[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r6)
            goto L_0x02c1
        L_0x01e6:
            r8 = 22
            if (r5 != 0) goto L_0x01ec
            goto L_0x0255
        L_0x01ec:
            int r12 = r5.intValue()
            if (r12 != r8) goto L_0x0255
            java.lang.String r5 = r6.getContent()     // Catch:{ Exception -> 0x0247 }
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopGeneralShopData> r6 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopGeneralShopData.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r5, r6)     // Catch:{ Exception -> 0x0247 }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopGeneralShopData r5 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopGeneralShopData) r5     // Catch:{ Exception -> 0x0247 }
            java.util.List r6 = r5.getSkuList()     // Catch:{ Exception -> 0x0247 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x0247 }
            if (r6 == 0) goto L_0x020f
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x0247 }
            if (r6 == 0) goto L_0x020d
            goto L_0x020f
        L_0x020d:
            r6 = r3
            goto L_0x0210
        L_0x020f:
            r6 = r2
        L_0x0210:
            if (r6 != 0) goto L_0x02c1
            java.util.List r6 = r5.getSkuList()     // Catch:{ Exception -> 0x0247 }
            int r6 = r6.size()     // Catch:{ Exception -> 0x0247 }
            if (r6 <= 0) goto L_0x02c1
            java.lang.String r6 = r5.getTitle()     // Catch:{ Exception -> 0x0247 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0247 }
            if (r6 == 0) goto L_0x022d
            int r6 = r6.length()     // Catch:{ Exception -> 0x0247 }
            if (r6 != 0) goto L_0x022b
            goto L_0x022d
        L_0x022b:
            r6 = r3
            goto L_0x022e
        L_0x022d:
            r6 = r2
        L_0x022e:
            if (r6 != 0) goto L_0x023c
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode     // Catch:{ Exception -> 0x0247 }
            java.lang.String r8 = r5.getTitle()     // Catch:{ Exception -> 0x0247 }
            r6.<init>(r8, r11, r10, r11)     // Catch:{ Exception -> 0x0247 }
            r0.add(r6)     // Catch:{ Exception -> 0x0247 }
        L_0x023c:
            java.util.List r5 = r5.getSkuList()     // Catch:{ Exception -> 0x0247 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x0247 }
            r0.addAll(r5)     // Catch:{ Exception -> 0x0247 }
            goto L_0x02c1
        L_0x0247:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r5)
            r6[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r6)
            goto L_0x02c1
        L_0x0255:
            r8 = 23
            if (r5 != 0) goto L_0x025b
            goto L_0x02c1
        L_0x025b:
            int r5 = r5.intValue()
            if (r5 != r8) goto L_0x02c1
            java.lang.String r5 = r6.getContent()     // Catch:{ Exception -> 0x02b5 }
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRecordedClassData> r6 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRecordedClassData.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r5, r6)     // Catch:{ Exception -> 0x02b5 }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRecordedClassData r5 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRecordedClassData) r5     // Catch:{ Exception -> 0x02b5 }
            java.util.List r6 = r5.getRecordedCourseList()     // Catch:{ Exception -> 0x02b5 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x02b5 }
            if (r6 == 0) goto L_0x027e
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x02b5 }
            if (r6 == 0) goto L_0x027c
            goto L_0x027e
        L_0x027c:
            r6 = r3
            goto L_0x027f
        L_0x027e:
            r6 = r2
        L_0x027f:
            if (r6 != 0) goto L_0x02c1
            java.util.List r6 = r5.getRecordedCourseList()     // Catch:{ Exception -> 0x02b5 }
            int r6 = r6.size()     // Catch:{ Exception -> 0x02b5 }
            if (r6 <= 0) goto L_0x02c1
            java.lang.String r6 = r5.getTitle()     // Catch:{ Exception -> 0x02b5 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02b5 }
            if (r6 == 0) goto L_0x029c
            int r6 = r6.length()     // Catch:{ Exception -> 0x02b5 }
            if (r6 != 0) goto L_0x029a
            goto L_0x029c
        L_0x029a:
            r6 = r3
            goto L_0x029d
        L_0x029c:
            r6 = r2
        L_0x029d:
            if (r6 != 0) goto L_0x02ab
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r8 = r5.getTitle()     // Catch:{ Exception -> 0x02b5 }
            r6.<init>(r8, r11, r10, r11)     // Catch:{ Exception -> 0x02b5 }
            r0.add(r6)     // Catch:{ Exception -> 0x02b5 }
        L_0x02ab:
            java.util.List r5 = r5.getRecordedCourseList()     // Catch:{ Exception -> 0x02b5 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x02b5 }
            r0.addAll(r5)     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02c1
        L_0x02b5:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r5)
            r6[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r6)
        L_0x02c1:
            r5 = r7
            goto L_0x0063
        L_0x02c4:
            java.lang.String r14 = r14.getCta()
            if (r14 != 0) goto L_0x02cb
            goto L_0x02e7
        L_0x02cb:
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta> r4 = com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta.class
            java.lang.Object r14 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r14, r4)     // Catch:{ Exception -> 0x02d9 }
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta r14 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta) r14     // Catch:{ Exception -> 0x02d9 }
            if (r14 == 0) goto L_0x02e7
            r0.add(r14)     // Catch:{ Exception -> 0x02d9 }
            goto L_0x02e7
        L_0x02d9:
            r14 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "cta error = "
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r14)
            r4[r3] = r14
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r1, r4)
        L_0x02e7:
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm r14 = r13.this$0
            com.tal.app.thinkacademy.common.base.StateLiveData r14 = r14.getMHomeDataList()
            r14.postSuccess(r0)
            java.lang.Object[] r14 = new java.lang.Object[r2]
            long r4 = java.lang.System.currentTimeMillis()
            kotlin.jvm.internal.Ref$LongRef r0 = r13.$startCurrentTime
            long r6 = r0.element
            long r4 = r4 - r6
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            java.lang.String r2 = "mHomeDataList success costTime total = "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r14[r3] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataList$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
