package com.tal.app.thinkacademy.business.study.study.vm;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.adapter.ClassStatea;
import com.tal.app.thinkacademy.business.study.study.entity.ClassGroups;
import com.tal.app.thinkacademy.business.study.study.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Course;
import com.tal.app.thinkacademy.business.study.study.entity.Record;
import com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt;
import com.tal.app.thinkacademy.business.studycenter.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.vm.StudyCenterVM$getClassListData$2", f = "StudyCenterVM.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StudyCenterVM.kt */
final class StudyCenterVM$getClassListData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ StudyCenterVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyCenterVM$getClassListData$2(StudyCenterVM studyCenterVM, Context context, Continuation<? super StudyCenterVM$getClassListData$2> continuation) {
        super(2, continuation);
        this.this$0 = studyCenterVM;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StudyCenterVM$getClassListData$2(this.this$0, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StudyCenterVM$getClassListData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ClassGroups classGroups;
        ClassGroups classGroups2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = PlanListRepositoryKt.getClassList(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ClassListEntity classListEntity = (ClassListEntity) obj2;
        if (classListEntity != null) {
            Context context = this.$context;
            classListEntity.setClassList(new ArrayList());
            Collection classGroups3 = classListEntity.getClassGroups();
            boolean z = false;
            if (!(classGroups3 == null || classGroups3.isEmpty())) {
                List<ClassGroups> classGroups4 = classListEntity.getClassGroups();
                String str = null;
                if (Intrinsics.areEqual((Object) (classGroups4 == null || (classGroups2 = classGroups4.get(0)) == null) ? null : classGroups2.getTabStatus(), (Object) ClassStatea.CURRENT.getStatename())) {
                    Collection records = classListEntity.getClassGroups().get(0).getRecords();
                    if (!(records == null || records.isEmpty())) {
                        classListEntity.getClassList().addAll(classListEntity.getClassGroups().get(0).getRecords());
                    }
                }
                List<ClassGroups> classGroups5 = classListEntity.getClassGroups();
                if ((classGroups5 == null ? 0 : classGroups5.size()) > 1) {
                    List<ClassGroups> classGroups6 = classListEntity.getClassGroups();
                    if (!(classGroups6 == null || (classGroups = classGroups6.get(1)) == null)) {
                        str = classGroups.getTabStatus();
                    }
                    if (Intrinsics.areEqual((Object) str, (Object) ClassStatea.COMPLETED.getStatename())) {
                        Collection records2 = classListEntity.getClassGroups().get(1).getRecords();
                        if (records2 == null || records2.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            List<Record> classList = classListEntity.getClassList();
                            Record record = r5;
                            Record record2 = new Record((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 3, context.getString(R.string.completed), (String) null, (String) null, (SwitchType) null, 237567, (DefaultConstructorMarker) null);
                            classList.add(record);
                            classListEntity.getClassList().addAll(classListEntity.getClassGroups().get(1).getRecords());
                        }
                    }
                }
            }
        }
        this.this$0.getClassList().postSuccess(classListEntity);
        return Unit.INSTANCE;
    }
}
