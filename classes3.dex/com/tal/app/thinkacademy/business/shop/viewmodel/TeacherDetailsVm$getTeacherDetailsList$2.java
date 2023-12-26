package com.tal.app.thinkacademy.business.shop.viewmodel;

import android.content.Context;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.RecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedData;
import com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherClasslistTitleNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.TeacherDetailsVm$getTeacherDetailsList$2", f = "TeacherDetailsVm.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"detailsList"}, s = {"L$0"})
/* compiled from: TeacherDetailsVm.kt */
final class TeacherDetailsVm$getTeacherDetailsList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $teacherId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TeacherDetailsVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeacherDetailsVm$getTeacherDetailsList$2(TeacherDetailsVm teacherDetailsVm, int i, Context context, Continuation<? super TeacherDetailsVm$getTeacherDetailsList$2> continuation) {
        super(2, continuation);
        this.this$0 = teacherDetailsVm;
        this.$teacherId = i;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeacherDetailsVm$getTeacherDetailsList$2(this.this$0, this.$teacherId, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeacherDetailsVm$getTeacherDetailsList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(T t) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        List<RecordedTeacherItem> tutorList;
        List<RecordedTeacherItem> teacherList;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            this.L$0 = objectRef3;
            this.L$1 = objectRef3;
            this.label = 1;
            T teacherDetailsList = this.this$0.mRepository.getTeacherDetailsList(this.$teacherId, this);
            if (teacherDetailsList == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef3;
            t = teacherDetailsList;
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2.element = t;
        TeacherDetailsList teacherDetailsList2 = (TeacherDetailsList) objectRef.element;
        if (teacherDetailsList2 != null) {
            Context context = this.$context;
            List arrayList = new ArrayList();
            Collection shortGoodsList = teacherDetailsList2.getShortGoodsList();
            if (!(shortGoodsList == null || shortGoodsList.isEmpty())) {
                arrayList.add(new TeacherClasslistTitleNode(context.getString(R.string.short_term_class), (List) null, 2, (DefaultConstructorMarker) null));
                List<ShopClassGoodsData> shortGoodsList2 = teacherDetailsList2.getShortGoodsList();
                Intrinsics.checkNotNull(shortGoodsList2);
                arrayList.addAll(shortGoodsList2);
            }
            Collection longGoodsList = teacherDetailsList2.getLongGoodsList();
            if (!(longGoodsList == null || longGoodsList.isEmpty())) {
                arrayList.add(new TeacherClasslistTitleNode(context.getString(R.string.long_term_class), (List) null, 2, (DefaultConstructorMarker) null));
                List<ShopClassGoodsData> longGoodsList2 = teacherDetailsList2.getLongGoodsList();
                Intrinsics.checkNotNull(longGoodsList2);
                arrayList.addAll(longGoodsList2);
            }
            Collection recordGoodsList = teacherDetailsList2.getRecordGoodsList();
            if (recordGoodsList != null && !recordGoodsList.isEmpty()) {
                z = false;
            }
            if (!z) {
                arrayList.add(new TeacherClasslistTitleNode(context.getString(R.string.recorded_courses), (List) null, 2, (DefaultConstructorMarker) null));
                List<TeacherRecordedData> recordGoodsList2 = teacherDetailsList2.getRecordGoodsList();
                if (recordGoodsList2 != null) {
                    for (TeacherRecordedData teacherRecordedData : recordGoodsList2) {
                        List arrayList2 = new ArrayList();
                        TeacherRecordedSpec spec = teacherRecordedData.getSpec();
                        if (!(spec == null || (teacherList = spec.getTeacherList()) == null)) {
                            Boxing.boxBoolean(arrayList2.addAll(teacherList));
                        }
                        TeacherRecordedSpec spec2 = teacherRecordedData.getSpec();
                        if (!(spec2 == null || (tutorList = spec2.getTutorList()) == null)) {
                            Boxing.boxBoolean(arrayList2.addAll(tutorList));
                        }
                        List<ShopRecordedItemData> recordList = teacherDetailsList2.getRecordList();
                        if (recordList != null) {
                            Long id = teacherRecordedData.getId();
                            TeacherRecordedSpec spec3 = teacherRecordedData.getSpec();
                            String subjectFullName = spec3 == null ? null : spec3.getSubjectFullName();
                            Integer showOrgPrice = teacherRecordedData.getShowOrgPrice();
                            Integer showPrice = teacherRecordedData.getShowPrice();
                            TeacherRecordedSpec spec4 = teacherRecordedData.getSpec();
                            String subject = spec4 == null ? null : spec4.getSubject();
                            TeacherRecordedSpec spec5 = teacherRecordedData.getSpec();
                            Boxing.boxBoolean(recordList.add(new ShopRecordedItemData(id, subjectFullName, showOrgPrice, showPrice, new RecordedSpec(subject, spec5 == null ? null : spec5.getLessonCount(), arrayList2))));
                        }
                    }
                }
                List<ShopRecordedItemData> recordList2 = teacherDetailsList2.getRecordList();
                Intrinsics.checkNotNull(recordList2);
                arrayList.addAll(recordList2);
            }
            ((TeacherDetailsList) objectRef.element).setNodeList(arrayList);
        }
        this.this$0.getMTeacherDetailsList().postSuccess(objectRef.element);
        return Unit.INSTANCE;
    }
}
