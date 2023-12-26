package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$requestShopClassDetail$2", f = "ShopClassDetailViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopClassDetailViewModel.kt */
final class ShopClassDetailViewModel$requestShopClassDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShopRequestCommonBody<ShopClassDetailRequest> $requestBody;
    int label;
    final /* synthetic */ ShopClassDetailViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailViewModel$requestShopClassDetail$2(ShopClassDetailViewModel shopClassDetailViewModel, ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super ShopClassDetailViewModel$requestShopClassDetail$2> continuation) {
        super(2, continuation);
        this.this$0 = shopClassDetailViewModel;
        this.$requestBody = shopRequestCommonBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopClassDetailViewModel$requestShopClassDetail$2(this.this$0, this.$requestBody, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopClassDetailViewModel$requestShopClassDetail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0111, code lost:
        if (r5 <= 0) goto L_0x0118;
     */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x053b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0 A[Catch:{ Exception -> 0x0118 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x001b
            if (r2 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r25)
            r2 = r25
            goto L_0x002e
        L_0x0013:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r25)
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel r2 = r0.this$0
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r4 = r0.$requestBody
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.label = r3
            java.lang.Object r2 = r2.getShopClassDetail(r4, r5)
            if (r2 != r1) goto L_0x002e
            return r1
        L_0x002e:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r2 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r2
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            java.lang.String r10 = "ShopClassDetailViewModel"
            r11 = 0
            if (r2 != 0) goto L_0x003e
            goto L_0x0545
        L_0x003e:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel r12 = r0.this$0
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            r13 = 0
            if (r4 != 0) goto L_0x0049
            r4 = r13
            goto L_0x0051
        L_0x0049:
            int r4 = r4.getClazzId()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
        L_0x0051:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r12.mClassId = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            r2.setLocal_class_detail_position(r4)
            java.util.List r4 = r2.getLocal_class_detail_position()
            if (r4 != 0) goto L_0x0069
            goto L_0x0087
        L_0x0069:
            com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo r5 = new com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo
            int r6 = r1.size()
            java.util.List r7 = r2.getLocal_class_detail_position()
            if (r7 != 0) goto L_0x0077
            r7 = r11
            goto L_0x007b
        L_0x0077:
            int r7 = r7.size()
        L_0x007b:
            int r8 = com.tal.app.thinkacademy.business.shop.R.string.shop_class_detail_tab_course
            r5.<init>(r6, r7, r8)
            boolean r4 = r4.add(r5)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L_0x0087:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r14 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseTitle
            int r5 = r4.getType()
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r14
            r6 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r1.add(r14)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r14 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseCard
            int r5 = r4.getType()
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            r1.add(r14)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailExamEntrance r4 = r2.getExamEntrance()
            if (r4 != 0) goto L_0x00b1
            r4 = r11
            goto L_0x00b5
        L_0x00b1:
            int r4 = r4.getStatus()
        L_0x00b5:
            if (r4 == 0) goto L_0x00ca
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r14 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r4 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.Admission
            int r5 = r4.getType()
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r14
            r6 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r1.add(r14)
        L_0x00ca:
            java.lang.String r4 = r2.getOperation()     // Catch:{ Exception -> 0x0117 }
            java.lang.Class<com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation> r5 = com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation.class
            java.lang.Object r4 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson(r4, r5)     // Catch:{ Exception -> 0x0117 }
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r4 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r4     // Catch:{ Exception -> 0x0117 }
            r2.setLocal_class_detail_operation(r4)     // Catch:{ Exception -> 0x0118 }
            if (r4 == 0) goto L_0x0118
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r5 = r4.getDynamic()     // Catch:{ Exception -> 0x0118 }
            if (r5 != 0) goto L_0x00e3
        L_0x00e1:
            r5 = r11
            goto L_0x00ee
        L_0x00e3:
            java.util.List r5 = r5.getHighlight()     // Catch:{ Exception -> 0x0118 }
            if (r5 != 0) goto L_0x00ea
            goto L_0x00e1
        L_0x00ea:
            int r5 = r5.size()     // Catch:{ Exception -> 0x0118 }
        L_0x00ee:
            if (r5 > 0) goto L_0x0113
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r5 = r4.getStaticData()     // Catch:{ Exception -> 0x0118 }
            if (r5 != 0) goto L_0x00f8
            r5 = r13
            goto L_0x00fc
        L_0x00f8:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait r5 = r5.getPortrait()     // Catch:{ Exception -> 0x0118 }
        L_0x00fc:
            if (r5 != 0) goto L_0x0113
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r5 = r4.getStaticData()     // Catch:{ Exception -> 0x0118 }
            if (r5 != 0) goto L_0x0106
        L_0x0104:
            r5 = r11
            goto L_0x0111
        L_0x0106:
            java.util.List r5 = r5.getTrialLessons()     // Catch:{ Exception -> 0x0118 }
            if (r5 != 0) goto L_0x010d
            goto L_0x0104
        L_0x010d:
            int r5 = r5.size()     // Catch:{ Exception -> 0x0118 }
        L_0x0111:
            if (r5 <= 0) goto L_0x0118
        L_0x0113:
            r1.add(r4)     // Catch:{ Exception -> 0x0118 }
            goto L_0x0118
        L_0x0117:
            r4 = r13
        L_0x0118:
            r16 = r4
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            if (r4 == 0) goto L_0x0254
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            java.util.List r4 = r4.getTeacherList()
            if (r4 != 0) goto L_0x012c
            r4 = r11
            goto L_0x0130
        L_0x012c:
            int r4 = r4.size()
        L_0x0130:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r5 = r2.getSpec()
            java.util.List r5 = r5.getTutorList()
            if (r5 != 0) goto L_0x013c
            r5 = r11
            goto L_0x0140
        L_0x013c:
            int r5 = r5.size()
        L_0x0140:
            int r6 = r4 + r5
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.String r9 = "老师数量为 "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            r7[r11] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r10, r7)
            if (r6 <= 0) goto L_0x0192
            java.util.List r7 = r2.getLocal_class_detail_position()
            if (r7 != 0) goto L_0x015c
            goto L_0x017a
        L_0x015c:
            com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo r8 = new com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo
            int r9 = r1.size()
            java.util.List r14 = r2.getLocal_class_detail_position()
            if (r14 != 0) goto L_0x016a
            r14 = r11
            goto L_0x016e
        L_0x016a:
            int r14 = r14.size()
        L_0x016e:
            int r15 = com.tal.app.thinkacademy.business.shop.R.string.shop_class_detail_tab_teacher
            r8.<init>(r9, r14, r15)
            boolean r7 = r7.add(r8)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
        L_0x017a:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r7 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.TeacherTitle
            int r18 = r8.getType()
            r19 = 0
            r20 = 0
            r21 = 6
            r22 = 0
            r17 = r7
            r17.<init>(r18, r19, r20, r21, r22)
            r1.add(r7)
        L_0x0192:
            if (r4 <= 0) goto L_0x01f3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r7 = r2.getSpec()
            java.util.List r7 = r7.getTeacherList()
            if (r7 != 0) goto L_0x019f
            goto L_0x01f3
        L_0x019f:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = r11
        L_0x01a6:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x01f1
            java.lang.Object r9 = r7.next()
            int r14 = r8 + 1
            if (r8 >= 0) goto L_0x01b7
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x01b7:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher r9 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher) r9
            if (r6 != r3) goto L_0x01c9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
            goto L_0x01ec
        L_0x01c9:
            if (r8 != 0) goto L_0x01d9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
            goto L_0x01ec
        L_0x01d9:
            if (r5 != 0) goto L_0x01ec
            int r15 = r4 + -1
            if (r8 != r15) goto L_0x01ec
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
        L_0x01ec:
            r1.add(r9)
            r8 = r14
            goto L_0x01a6
        L_0x01f1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x01f3:
            if (r5 <= 0) goto L_0x0254
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r7 = r2.getSpec()
            java.util.List r7 = r7.getTutorList()
            if (r7 != 0) goto L_0x0200
            goto L_0x0254
        L_0x0200:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = r11
        L_0x0207:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0252
            java.lang.Object r9 = r7.next()
            int r14 = r8 + 1
            if (r8 >= 0) goto L_0x0218
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0218:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher r9 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher) r9
            if (r6 != r3) goto L_0x022a
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
            goto L_0x024d
        L_0x022a:
            if (r8 != 0) goto L_0x023c
            if (r4 != 0) goto L_0x023c
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
            goto L_0x024d
        L_0x023c:
            int r15 = r5 + -1
            if (r8 != r15) goto L_0x024d
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r9.setLocal_position_type(r8)
        L_0x024d:
            r1.add(r9)
            r8 = r14
            goto L_0x0207
        L_0x0252:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0254:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            if (r4 != 0) goto L_0x025c
        L_0x025a:
            r4 = r11
            goto L_0x026e
        L_0x025c:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r4 = r4.getCourseInfo()
            if (r4 != 0) goto L_0x0263
            goto L_0x025a
        L_0x0263:
            java.util.List r4 = r4.getSyllabus()
            if (r4 != 0) goto L_0x026a
            goto L_0x025a
        L_0x026a:
            int r4 = r4.size()
        L_0x026e:
            r5 = 5
            if (r4 <= 0) goto L_0x0344
            java.util.List r6 = r2.getLocal_class_detail_position()
            if (r6 != 0) goto L_0x0278
            goto L_0x0296
        L_0x0278:
            com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo r7 = new com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo
            int r8 = r1.size()
            java.util.List r9 = r2.getLocal_class_detail_position()
            if (r9 != 0) goto L_0x0286
            r9 = r11
            goto L_0x028a
        L_0x0286:
            int r9 = r9.size()
        L_0x028a:
            int r14 = com.tal.app.thinkacademy.business.shop.R.string.shop_class_detail_tab_schedule
            r7.<init>(r8, r9, r14)
            boolean r6 = r6.add(r7)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0296:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r6 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r7 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleTitle
            int r15 = r7.getType()
            r17 = 0
            r18 = 4
            r19 = 0
            r14 = r6
            r14.<init>(r15, r16, r17, r18, r19)
            r1.add(r6)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r6 = r2.getSpec()
            if (r6 != 0) goto L_0x02b3
            goto L_0x031e
        L_0x02b3:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r6 = r6.getCourseInfo()
            if (r6 != 0) goto L_0x02ba
            goto L_0x031e
        L_0x02ba:
            java.util.List r6 = r6.getSyllabus()
            if (r6 != 0) goto L_0x02c1
            goto L_0x031e
        L_0x02c1:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = r11
        L_0x02c8:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x031c
            java.lang.Object r8 = r6.next()
            int r9 = r7 + 1
            if (r7 >= 0) goto L_0x02d9
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x02d9:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu r8 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu) r8
            r8.setLocal_position_num(r9)
            r14 = 4
            if (r4 != r3) goto L_0x02ef
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r15 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r15 = r15.getType()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r15)
            r8.setLocal_position_type(r15)
            goto L_0x0314
        L_0x02ef:
            if (r7 != 0) goto L_0x02ff
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r15 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r15 = r15.getType()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r15)
            r8.setLocal_position_type(r15)
            goto L_0x0314
        L_0x02ff:
            if (r4 > r5) goto L_0x0314
            if (r7 == r14) goto L_0x0307
            int r15 = r4 + -1
            if (r7 != r15) goto L_0x0314
        L_0x0307:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r15 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r15 = r15.getType()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r15)
            r8.setLocal_position_type(r15)
        L_0x0314:
            r1.add(r8)
            if (r7 != r14) goto L_0x031a
            goto L_0x031e
        L_0x031a:
            r7 = r9
            goto L_0x02c8
        L_0x031c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x031e:
            if (r4 <= r5) goto L_0x0344
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r4 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r6 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleMore
            int r15 = r6.getType()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r6 = r2.getSpec()
            if (r6 != 0) goto L_0x0331
            r16 = r13
            goto L_0x0337
        L_0x0331:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r6 = r6.getCourseInfo()
            r16 = r6
        L_0x0337:
            r17 = 0
            r18 = 4
            r19 = 0
            r14 = r4
            r14.<init>(r15, r16, r17, r18, r19)
            r1.add(r4)
        L_0x0344:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            if (r4 != 0) goto L_0x034c
        L_0x034a:
            r4 = r11
            goto L_0x0368
        L_0x034c:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r4 = r4.getCourseInfo()
            if (r4 != 0) goto L_0x0353
            goto L_0x034a
        L_0x0353:
            java.lang.String r4 = r4.getDescription()
            if (r4 != 0) goto L_0x035a
            goto L_0x034a
        L_0x035a:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0364
            r4 = r3
            goto L_0x0365
        L_0x0364:
            r4 = r11
        L_0x0365:
            if (r4 != r3) goto L_0x034a
            r4 = r3
        L_0x0368:
            r6 = 2
            if (r4 == 0) goto L_0x041c
            java.util.List r4 = r2.getLocal_class_detail_position()
            if (r4 != 0) goto L_0x0372
            goto L_0x0390
        L_0x0372:
            com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo r7 = new com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo
            int r8 = r1.size()
            java.util.List r9 = r2.getLocal_class_detail_position()
            if (r9 != 0) goto L_0x0380
            r9 = r11
            goto L_0x0384
        L_0x0380:
            int r9 = r9.size()
        L_0x0384:
            int r14 = com.tal.app.thinkacademy.business.shop.R.string.shop_class_detail_tab_details
            r7.<init>(r8, r9, r14)
            boolean r4 = r4.add(r7)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L_0x0390:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r4 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r7 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseDetailTitle
            int r15 = r7.getType()
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            r14 = r4
            r14.<init>(r15, r16, r17, r18, r19)
            r1.add(r4)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r4 = r2.getSpec()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo r4 = r4.getCourseInfo()
            java.lang.String r4 = r4.getDescription()
            r14 = r4
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r4 = ","
            java.lang.String[] r15 = new java.lang.String[]{r4}
            r16 = 0
            java.util.List r4 = kotlin.text.StringsKt.split$default(r14, r15, r16, r17, r18, r19)
            int r7 = r4.size()
            if (r7 <= 0) goto L_0x041c
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r8 = r11
        L_0x03cf:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x041c
            java.lang.Object r9 = r4.next()
            int r14 = r8 + 1
            if (r8 >= 0) goto L_0x03e0
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x03e0:
            java.lang.String r9 = (java.lang.String) r9
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseDetailPic r15 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseDetailPic
            r15.<init>(r9, r13, r6, r13)
            if (r7 != r3) goto L_0x03f7
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r15.setLocal_position_type(r8)
            goto L_0x0417
        L_0x03f7:
            if (r8 != 0) goto L_0x0406
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r9 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r9 = r9.getType()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r15.setLocal_position_type(r9)
        L_0x0406:
            int r9 = r7 + -1
            if (r8 != r9) goto L_0x0417
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r8 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r8 = r8.getType()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r15.setLocal_position_type(r8)
        L_0x0417:
            r1.add(r15)
            r8 = r14
            goto L_0x03cf
        L_0x041c:
            com.tal.app.thinkacademy.common.imconfig.CourseStorePurchaseGuide r4 = r12.getBuySteps()
            if (r4 != 0) goto L_0x0424
            goto L_0x0545
        L_0x0424:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r2 = r2.getSpec()
            if (r2 != 0) goto L_0x0433
            r2 = r11
            goto L_0x0437
        L_0x0433:
            int r2 = r2.getCourseType()
        L_0x0437:
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r3
            if (r2 == r6) goto L_0x0446
            r6 = 3
            if (r2 == r6) goto L_0x0446
            if (r2 == r5) goto L_0x0446
            goto L_0x0448
        L_0x0446:
            r8.element = r11
        L_0x0448:
            java.util.List r2 = r4.getSteps()
            if (r2 != 0) goto L_0x0450
            goto L_0x04b9
        L_0x0450:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r5 = r11
        L_0x0457:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x04b7
            java.lang.Object r6 = r2.next()
            int r9 = r5 + 1
            if (r5 >= 0) goto L_0x0468
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0468:
            com.tal.app.thinkacademy.common.imconfig.Step r6 = (com.tal.app.thinkacademy.common.imconfig.Step) r6
            com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep r5 = new com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 127(0x7f, float:1.78E-43)
            r23 = 0
            r14 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            if (r6 != 0) goto L_0x0485
            r12 = r11
            goto L_0x0489
        L_0x0485:
            boolean r12 = r6.isHide()
        L_0x0489:
            r5.setHide(r12)
            if (r6 != 0) goto L_0x0490
            r12 = r13
            goto L_0x0494
        L_0x0490:
            java.lang.String r12 = r6.getDesc()
        L_0x0494:
            r5.setDesc(r12)
            if (r6 != 0) goto L_0x049b
            r6 = r13
            goto L_0x049f
        L_0x049b:
            java.lang.String r6 = r6.getTitle()
        L_0x049f:
            r5.setTitle(r6)
            boolean r6 = r8.element
            if (r6 == 0) goto L_0x04a8
        L_0x04a6:
            r6 = r3
            goto L_0x04b0
        L_0x04a8:
            boolean r6 = r5.isHide()
            if (r6 != 0) goto L_0x04af
            goto L_0x04a6
        L_0x04af:
            r6 = r11
        L_0x04b0:
            if (r6 == 0) goto L_0x04b5
            r7.add(r5)
        L_0x04b5:
            r5 = r9
            goto L_0x0457
        L_0x04b7:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x04b9:
            int r2 = r7.size()
            if (r2 <= 0) goto L_0x04d7
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r5 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r6 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.StepsTitle
            int r13 = r6.getType()
            java.lang.String r14 = java.lang.String.valueOf(r2)
            r15 = 0
            r16 = 4
            r17 = 0
            r12 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            r1.add(r5)
        L_0x04d7:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r5 = r7.iterator()
            r6 = r11
        L_0x04de:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0543
            java.lang.Object r7 = r5.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x04ef
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x04ef:
            com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep r7 = (com.tal.app.thinkacademy.business.shop.bean.ShopBuyStepsStep) r7
            if (r2 != r3) goto L_0x04fd
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r9 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r9 = r9.getType()
            r7.setLocal_position_type(r9)
            goto L_0x053b
        L_0x04fd:
            if (r6 != 0) goto L_0x0508
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r9 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r9 = r9.getType()
            r7.setLocal_position_type(r9)
        L_0x0508:
            int r9 = r2 + -1
            if (r6 != r9) goto L_0x053b
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r9 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r9 = r9.getType()
            r7.setLocal_position_type(r9)
            java.lang.String r9 = r4.getFaq_desc()
            if (r9 != 0) goto L_0x051d
        L_0x051b:
            r9 = r11
            goto L_0x052b
        L_0x051d:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x0527
            r9 = r3
            goto L_0x0528
        L_0x0527:
            r9 = r11
        L_0x0528:
            if (r9 != r3) goto L_0x051b
            r9 = r3
        L_0x052b:
            if (r9 == 0) goto L_0x053b
            java.lang.String r9 = r4.getFaq_desc()
            r7.setLocal_faq_desc(r9)
            java.lang.String r9 = r4.getFag_name()
            r7.setLocal_faq_name(r9)
        L_0x053b:
            r7.setLocal_position(r6)
            r1.add(r7)
            r6 = r8
            goto L_0x04de
        L_0x0543:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0545:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel r2 = r0.this$0
            com.tal.app.thinkacademy.common.base.StateLiveData r2 = r2.getMShopDetailList()
            r2.postSuccess(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "requestShopClassDetail success"
            r1[r11] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r10, r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$requestShopClassDetail$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
