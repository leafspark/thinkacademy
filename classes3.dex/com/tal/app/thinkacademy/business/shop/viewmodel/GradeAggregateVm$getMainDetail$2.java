package com.tal.app.thinkacademy.business.shop.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$getMainDetail$2", f = "GradeAggregateVm.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: GradeAggregateVm.kt */
final class GradeAggregateVm$getMainDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GradeAggregateVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateVm$getMainDetail$2(GradeAggregateVm gradeAggregateVm, String str, Continuation<? super GradeAggregateVm$getMainDetail$2> continuation) {
        super(2, continuation);
        this.this$0 = gradeAggregateVm;
        this.$pageId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GradeAggregateVm$getMainDetail$2 gradeAggregateVm$getMainDetail$2 = new GradeAggregateVm$getMainDetail$2(this.this$0, this.$pageId, continuation);
        gradeAggregateVm$getMainDetail$2.L$0 = obj;
        return gradeAggregateVm$getMainDetail$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GradeAggregateVm$getMainDetail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r3v1, types: [int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r3v3, types: [int, boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r1 = r24
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L_0x001f
            if (r2 != r3) goto L_0x0017
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r25)
            r2 = r25
            goto L_0x003c
        L_0x0017:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r25)
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm r4 = r1.this$0
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository r4 = r4.repository
            java.lang.String r5 = r1.$pageId
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r2
            r1.label = r3
            java.lang.Object r2 = r4.getGradeAggregateInfo(r5, r6)
            if (r2 != r0) goto L_0x003c
            return r0
        L_0x003c:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r2 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r2
            java.lang.String r4 = "GradeAggregateVm"
            r5 = 0
            if (r2 != 0) goto L_0x0045
            goto L_0x03da
        L_0x0045:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r2.setMLocalNodeList(r0)
            java.lang.String r0 = r2.getContent()     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead> r6 = com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r6)     // Catch:{ Exception -> 0x00a7 }
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r0 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead) r0     // Catch:{ Exception -> 0x00a7 }
            if (r0 != 0) goto L_0x005e
            goto L_0x00a7
        L_0x005e:
            r2.setMLocalContent(r0)     // Catch:{ Exception -> 0x00a7 }
            java.util.List r6 = r0.getDescription()     // Catch:{ Exception -> 0x00a7 }
            if (r6 != 0) goto L_0x0069
            r6 = r5
            goto L_0x006d
        L_0x0069:
            int r6 = r6.size()     // Catch:{ Exception -> 0x00a7 }
        L_0x006d:
            java.util.List r0 = r0.getDescription()     // Catch:{ Exception -> 0x00a7 }
            if (r0 != 0) goto L_0x0074
            goto L_0x00a7
        L_0x0074:
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x00a7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00a7 }
            r7 = r5
        L_0x007b:
            boolean r8 = r0.hasNext()     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x00a5
            java.lang.Object r8 = r0.next()     // Catch:{ Exception -> 0x00a7 }
            int r9 = r7 + 1
            if (r7 >= 0) goto L_0x008c
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x00a7 }
        L_0x008c:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHeadDescription r8 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHeadDescription) r8     // Catch:{ Exception -> 0x00a7 }
            int r10 = r6 + -1
            if (r7 != r10) goto L_0x0095
            r8.setMLocalIsLast(r3)     // Catch:{ Exception -> 0x00a7 }
        L_0x0095:
            java.util.List r7 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x00a7 }
            if (r7 != 0) goto L_0x009c
            goto L_0x00a3
        L_0x009c:
            boolean r7 = r7.add(r8)     // Catch:{ Exception -> 0x00a7 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a3:
            r7 = r9
            goto L_0x007b
        L_0x00a5:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            java.util.List r0 = r2.getModuleContents()
            if (r0 != 0) goto L_0x00af
            goto L_0x03da
        L_0x00af:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r6 = r0.iterator()
            r0 = r5
        L_0x00b6:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x03d8
            java.lang.Object r7 = r6.next()
            int r8 = r0 + 1
            if (r0 >= 0) goto L_0x00c7
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00c7:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateFilterModuleContent r7 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateFilterModuleContent) r7
            int r0 = r7.getType()
            r9 = 24
            r10 = 0
            if (r0 == r9) goto L_0x021c
            switch(r0) {
                case 8: goto L_0x01e4;
                case 9: goto L_0x01c3;
                case 10: goto L_0x012c;
                case 11: goto L_0x00d7;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            goto L_0x03d5
        L_0x00d7:
            java.lang.String r0 = r7.getContent()     // Catch:{ Exception -> 0x03d5 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode> r7 = com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r7)     // Catch:{ Exception -> 0x03d5 }
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode r0 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode) r0     // Catch:{ Exception -> 0x03d5 }
            if (r0 != 0) goto L_0x00e6
            goto L_0x00ef
        L_0x00e6:
            r7 = 11
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)     // Catch:{ Exception -> 0x03d5 }
            r0.setType(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x00ef:
            if (r0 != 0) goto L_0x00f2
            goto L_0x00f5
        L_0x00f2:
            r0.setExpanded(r3)     // Catch:{ Exception -> 0x03d5 }
        L_0x00f5:
            if (r0 != 0) goto L_0x00f8
            goto L_0x0102
        L_0x00f8:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x03d5 }
            r7.<init>()     // Catch:{ Exception -> 0x03d5 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x03d5 }
            r0.setChildNode(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x0102:
            if (r0 != 0) goto L_0x0106
            goto L_0x03d5
        L_0x0106:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ Exception -> 0x03d5 }
            r2.setHavaClassItem(r7)     // Catch:{ Exception -> 0x03d5 }
            java.util.List r7 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x0114
            goto L_0x011b
        L_0x0114:
            boolean r7 = r7.add(r0)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x011b:
            java.util.List r7 = r2.getMLocalClassList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x0123
            goto L_0x03d5
        L_0x0123:
            boolean r0 = r7.add(r0)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03d5 }
            goto L_0x03d5
        L_0x012c:
            java.lang.String r0 = r7.getContent()     // Catch:{ Exception -> 0x03d5 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode> r7 = com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r7)     // Catch:{ Exception -> 0x03d5 }
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode r0 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode) r0     // Catch:{ Exception -> 0x03d5 }
            if (r0 != 0) goto L_0x013b
            goto L_0x0144
        L_0x013b:
            r7 = 10
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)     // Catch:{ Exception -> 0x03d5 }
            r0.setType(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x0144:
            if (r0 != 0) goto L_0x0147
            goto L_0x014a
        L_0x0147:
            r0.setExpanded(r3)     // Catch:{ Exception -> 0x03d5 }
        L_0x014a:
            if (r0 != 0) goto L_0x014d
            goto L_0x0157
        L_0x014d:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x03d5 }
            r7.<init>()     // Catch:{ Exception -> 0x03d5 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x03d5 }
            r0.setChildNode(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x0157:
            if (r0 != 0) goto L_0x015b
            goto L_0x03d5
        L_0x015b:
            java.util.List r7 = r0.getTeacherList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x0163
            r7 = r5
            goto L_0x0167
        L_0x0163:
            int r7 = r7.size()     // Catch:{ Exception -> 0x03d5 }
        L_0x0167:
            if (r7 <= 0) goto L_0x01b2
            java.util.List r9 = r0.getTeacherList()     // Catch:{ Exception -> 0x03d5 }
            if (r9 != 0) goto L_0x0171
            r9 = r10
            goto L_0x0177
        L_0x0171:
            java.lang.Object r9 = r9.get(r5)     // Catch:{ Exception -> 0x03d5 }
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode r9 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode) r9     // Catch:{ Exception -> 0x03d5 }
        L_0x0177:
            if (r9 != 0) goto L_0x017a
            goto L_0x0181
        L_0x017a:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ Exception -> 0x03d5 }
            r9.setTop(r11)     // Catch:{ Exception -> 0x03d5 }
        L_0x0181:
            java.util.List r9 = r0.getTeacherList()     // Catch:{ Exception -> 0x03d5 }
            if (r9 != 0) goto L_0x0188
            goto L_0x0191
        L_0x0188:
            int r7 = r7 + -1
            java.lang.Object r7 = r9.get(r7)     // Catch:{ Exception -> 0x03d5 }
            r10 = r7
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode r10 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode) r10     // Catch:{ Exception -> 0x03d5 }
        L_0x0191:
            if (r10 != 0) goto L_0x0194
            goto L_0x019b
        L_0x0194:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ Exception -> 0x03d5 }
            r10.setBottom(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x019b:
            java.util.List r7 = r0.getChildNode()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x01a2
            goto L_0x01b2
        L_0x01a2:
            java.util.List r9 = r0.getTeacherList()     // Catch:{ Exception -> 0x03d5 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ Exception -> 0x03d5 }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ Exception -> 0x03d5 }
            boolean r7 = r7.addAll(r9)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ Exception -> 0x03d5 }
        L_0x01b2:
            java.util.List r7 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x01ba
            goto L_0x03d5
        L_0x01ba:
            boolean r0 = r7.add(r0)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03d5 }
            goto L_0x03d5
        L_0x01c3:
            java.lang.String r0 = r7.getContent()     // Catch:{ Exception -> 0x03d5 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode> r7 = com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r7)     // Catch:{ Exception -> 0x03d5 }
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode r0 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode) r0     // Catch:{ Exception -> 0x03d5 }
            if (r0 != 0) goto L_0x01d3
            goto L_0x03d5
        L_0x01d3:
            java.util.List r7 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x01db
            goto L_0x03d5
        L_0x01db:
            boolean r0 = r7.add(r0)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03d5 }
            goto L_0x03d5
        L_0x01e4:
            java.lang.String r0 = r7.getContent()     // Catch:{ Exception -> 0x03d5 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml> r9 = com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r9)     // Catch:{ Exception -> 0x03d5 }
            java.lang.String r9 = "fromJson(\n              …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)     // Catch:{ Exception -> 0x03d5 }
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml r0 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml) r0     // Catch:{ Exception -> 0x03d5 }
            int r9 = r7.getId()     // Catch:{ Exception -> 0x03d5 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x03d5 }
            r0.setMLocalComponentID(r9)     // Catch:{ Exception -> 0x03d5 }
            int r7 = r7.getType()     // Catch:{ Exception -> 0x03d5 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x03d5 }
            r0.setMLocalComponentType(r7)     // Catch:{ Exception -> 0x03d5 }
            java.util.List r7 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03d5 }
            if (r7 != 0) goto L_0x0213
            goto L_0x03d5
        L_0x0213:
            boolean r0 = r7.add(r0)     // Catch:{ Exception -> 0x03d5 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03d5 }
            goto L_0x03d5
        L_0x021c:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r9 = "留资组件获取"
            r0[r5] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r0)
            java.lang.String r0 = r7.getContent()     // Catch:{ Exception -> 0x03c7 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.UserLeaveInfoBean> r9 = com.tal.app.thinkacademy.business.shop.bean.UserLeaveInfoBean.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r0, r9)     // Catch:{ Exception -> 0x03c7 }
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveInfoBean r0 = (com.tal.app.thinkacademy.business.shop.bean.UserLeaveInfoBean) r0     // Catch:{ Exception -> 0x03c7 }
            if (r0 != 0) goto L_0x0235
            goto L_0x03b5
        L_0x0235:
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponent r0 = r0.getComponentData()     // Catch:{ Exception -> 0x03c7 }
            if (r0 != 0) goto L_0x023d
            goto L_0x03b5
        L_0x023d:
            java.util.List r9 = r0.getDataList()     // Catch:{ Exception -> 0x03c7 }
            if (r9 != 0) goto L_0x0245
            r9 = r5
            goto L_0x0249
        L_0x0245:
            int r9 = r9.size()     // Catch:{ Exception -> 0x03c7 }
        L_0x0249:
            if (r9 <= 0) goto L_0x03aa
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x03c7 }
            java.lang.String r11 = "留资组件，数据大小为 = "
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)     // Catch:{ Exception -> 0x03c7 }
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r9)     // Catch:{ Exception -> 0x03c7 }
            r10[r5] = r9     // Catch:{ Exception -> 0x03c7 }
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r10)     // Catch:{ Exception -> 0x03c7 }
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ Exception -> 0x03c7 }
            r9.<init>()     // Catch:{ Exception -> 0x03c7 }
            r9.element = r3     // Catch:{ Exception -> 0x03c7 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x03c7 }
            r10.<init>()     // Catch:{ Exception -> 0x03c7 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x03c7 }
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData r15 = new com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData     // Catch:{ Exception -> 0x03c7 }
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 511(0x1ff, float:7.16E-43)
            r23 = 0
            r11 = r15
            r3 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r11 = r0.getHost()     // Catch:{ Exception -> 0x03c2 }
            r3.setHost(r11)     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r11 = r0.getSecret()     // Catch:{ Exception -> 0x03c2 }
            r3.setSecret(r11)     // Catch:{ Exception -> 0x03c2 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x03c2 }
            r11.<init>()     // Catch:{ Exception -> 0x03c2 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r12 = r0.getClue()     // Catch:{ Exception -> 0x03c2 }
            if (r12 != 0) goto L_0x02b1
            java.lang.String r12 = ""
        L_0x02b1:
            r11.add(r12)     // Catch:{ Exception -> 0x03c2 }
            r3.setTags(r11)     // Catch:{ Exception -> 0x03c2 }
            java.util.List r11 = r0.getDataList()     // Catch:{ Exception -> 0x03c2 }
            if (r11 != 0) goto L_0x02be
            goto L_0x0321
        L_0x02be:
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch:{ Exception -> 0x03c2 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x03c2 }
            r12 = r5
        L_0x02c5:
            boolean r13 = r11.hasNext()     // Catch:{ Exception -> 0x03c2 }
            if (r13 == 0) goto L_0x031f
            java.lang.Object r13 = r11.next()     // Catch:{ Exception -> 0x03c2 }
            int r14 = r12 + 1
            if (r12 >= 0) goto L_0x02d6
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x03c2 }
        L_0x02d6:
            com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData r13 = (com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData) r13     // Catch:{ Exception -> 0x03c2 }
            boolean r12 = r13.getShow()     // Catch:{ Exception -> 0x03c2 }
            if (r12 == 0) goto L_0x031d
            boolean r12 = r9.element     // Catch:{ Exception -> 0x03c2 }
            if (r12 == 0) goto L_0x02ed
            com.tal.app.thinkacademy.business.shop.bean.LeaveDataType r12 = com.tal.app.thinkacademy.business.shop.bean.LeaveDataType.DATA_HEAD     // Catch:{ Exception -> 0x03c2 }
            int r12 = r12.getValue()     // Catch:{ Exception -> 0x03c2 }
            r13.setMLocalType(r12)     // Catch:{ Exception -> 0x03c2 }
            r9.element = r5     // Catch:{ Exception -> 0x03c2 }
        L_0x02ed:
            java.lang.String r12 = "gradeId"
            java.lang.String r15 = r13.getKey()     // Catch:{ Exception -> 0x03c2 }
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)     // Catch:{ Exception -> 0x03c2 }
            if (r12 == 0) goto L_0x0302
            com.tal.app.thinkacademy.business.shop.bean.LeaveLayoutType r12 = com.tal.app.thinkacademy.business.shop.bean.LeaveLayoutType.LAYOUT_SINGLE_SELECT     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r12 = r12.getTypeName()     // Catch:{ Exception -> 0x03c2 }
            r13.setOptionsType(r12)     // Catch:{ Exception -> 0x03c2 }
        L_0x0302:
            java.lang.String r12 = "email"
            java.lang.String r15 = r13.getKey()     // Catch:{ Exception -> 0x03c2 }
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)     // Catch:{ Exception -> 0x03c2 }
            if (r12 == 0) goto L_0x0317
            r12 = 1
            r3.setShowEmailSubscribe(r12)     // Catch:{ Exception -> 0x0313 }
            goto L_0x0317
        L_0x0313:
            r0 = move-exception
            r3 = r12
            goto L_0x03c8
        L_0x0317:
            r13.setMLocalLeaveButtonData(r3)     // Catch:{ Exception -> 0x03c2 }
            r10.add(r13)     // Catch:{ Exception -> 0x03c2 }
        L_0x031d:
            r12 = r14
            goto L_0x02c5
        L_0x031f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x03c2 }
        L_0x0321:
            int r9 = r10.size()     // Catch:{ Exception -> 0x03c2 }
            int r11 = r10.size()     // Catch:{ Exception -> 0x03c2 }
            r12 = 1
            if (r11 <= r12) goto L_0x0336
            com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$getMainDetail$2$invokeSuspend$lambda-11$lambda-10$lambda-8$$inlined$sortBy$1 r11 = new com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$getMainDetail$2$invokeSuspend$lambda-11$lambda-10$lambda-8$$inlined$sortBy$1     // Catch:{ Exception -> 0x03c2 }
            r11.<init>()     // Catch:{ Exception -> 0x03c2 }
            java.util.Comparator r11 = (java.util.Comparator) r11     // Catch:{ Exception -> 0x03c2 }
            kotlin.collections.CollectionsKt.sortWith(r10, r11)     // Catch:{ Exception -> 0x03c2 }
        L_0x0336:
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r11 = "留资组件，可显示的组件长度为 = "
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r13)     // Catch:{ Exception -> 0x03c2 }
            r12[r5] = r11     // Catch:{ Exception -> 0x03c2 }
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r12)     // Catch:{ Exception -> 0x03c2 }
            if (r9 <= 0) goto L_0x03b3
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode r9 = new com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r14 = r0.getTitle()     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r15 = r0.getIntro()     // Catch:{ Exception -> 0x03c2 }
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 48
            r21 = 0
            r13 = r9
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r0 = r0.getTitle()     // Catch:{ Exception -> 0x03c2 }
            r3.setComponentName(r0)     // Catch:{ Exception -> 0x03c2 }
            int r0 = r7.getId()     // Catch:{ Exception -> 0x03c2 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x03c2 }
            r3.setComponentId(r0)     // Catch:{ Exception -> 0x03c2 }
            java.util.List r0 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03c2 }
            if (r0 != 0) goto L_0x037d
            goto L_0x0384
        L_0x037d:
            boolean r0 = r0.add(r9)     // Catch:{ Exception -> 0x03c2 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03c2 }
        L_0x0384:
            java.util.List r0 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03c2 }
            if (r0 != 0) goto L_0x038b
            goto L_0x0395
        L_0x038b:
            r7 = r10
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x03c2 }
            boolean r0 = r0.addAll(r7)     // Catch:{ Exception -> 0x03c2 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03c2 }
        L_0x0395:
            r3.setMLocalButtonTypeChild(r10)     // Catch:{ Exception -> 0x03c2 }
            java.util.List r0 = r2.getMLocalNodeList()     // Catch:{ Exception -> 0x03c2 }
            if (r0 != 0) goto L_0x039f
            goto L_0x03b3
        L_0x039f:
            boolean r0 = r0.add(r3)     // Catch:{ Exception -> 0x03c2 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ Exception -> 0x03c2 }
            goto L_0x03b3
        L_0x03a7:
            r0 = move-exception
            r3 = r11
            goto L_0x03c8
        L_0x03aa:
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x03c7 }
            java.lang.String r3 = "留资组件，数据大小为0"
            r0[r5] = r3     // Catch:{ Exception -> 0x03c2 }
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r0)     // Catch:{ Exception -> 0x03c2 }
        L_0x03b3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x03c2 }
        L_0x03b5:
            if (r10 != 0) goto L_0x03c5
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x03c7 }
            java.lang.String r3 = "留资组件，==null"
            r0[r5] = r3     // Catch:{ Exception -> 0x03c2 }
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r0)     // Catch:{ Exception -> 0x03c2 }
            goto L_0x03c5
        L_0x03c2:
            r0 = move-exception
            r3 = 1
            goto L_0x03c8
        L_0x03c5:
            r3 = 1
            goto L_0x03d5
        L_0x03c7:
            r0 = move-exception
        L_0x03c8:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.String r9 = "留资组件，转换异常 = "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r0)
            r7[r5] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r7)
        L_0x03d5:
            r0 = r8
            goto L_0x00b6
        L_0x03d8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03da:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = "getMainDetail success"
            r0[r5] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r0)
            com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm r0 = r1.this$0
            com.tal.app.thinkacademy.common.base.StateLiveData r0 = r0.getMMainDetail()
            r0.postSuccess(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$getMainDetail$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
