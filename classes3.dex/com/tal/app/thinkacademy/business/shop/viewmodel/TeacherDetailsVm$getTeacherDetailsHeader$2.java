package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.business.shop.bean.TeacherDetailsHeader;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIngachievemNode;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIntroduceNode;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherVideoNode;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.TeacherDetailsVm$getTeacherDetailsHeader$2", f = "TeacherDetailsVm.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {"header"}, s = {"L$0"})
/* compiled from: TeacherDetailsVm.kt */
final class TeacherDetailsVm$getTeacherDetailsHeader$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $teacherId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TeacherDetailsVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeacherDetailsVm$getTeacherDetailsHeader$2(TeacherDetailsVm teacherDetailsVm, int i, Continuation<? super TeacherDetailsVm$getTeacherDetailsHeader$2> continuation) {
        super(2, continuation);
        this.this$0 = teacherDetailsVm;
        this.$teacherId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeacherDetailsVm$getTeacherDetailsHeader$2(this.this$0, this.$teacherId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeacherDetailsVm$getTeacherDetailsHeader$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(T t) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            this.L$0 = objectRef3;
            this.L$1 = objectRef3;
            this.label = 1;
            T teacherDetailsHeader = this.this$0.mRepository.getTeacherDetailsHeader(this.$teacherId, this);
            if (teacherDetailsHeader == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef3;
            t = teacherDetailsHeader;
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2.element = t;
        TeacherDetailsHeader teacherDetailsHeader2 = (TeacherDetailsHeader) objectRef.element;
        if (teacherDetailsHeader2 != null) {
            List arrayList = new ArrayList();
            CharSequence videoUrl = teacherDetailsHeader2.getVideoUrl();
            if (!(videoUrl == null || StringsKt.isBlank(videoUrl))) {
                arrayList.add(new TeacherVideoNode(teacherDetailsHeader2.getVideoUrl(), (List) null, 2, (DefaultConstructorMarker) null));
            }
            Collection achievementList = teacherDetailsHeader2.getAchievementList();
            if (!(achievementList == null || achievementList.isEmpty())) {
                List<String> achievementList2 = teacherDetailsHeader2.getAchievementList();
                Intrinsics.checkNotNull(achievementList2);
                arrayList.add(new TeacherIngachievemNode(achievementList2, (List) null, 2, (DefaultConstructorMarker) null));
            }
            CharSequence experience = teacherDetailsHeader2.getExperience();
            if (experience != null && !StringsKt.isBlank(experience)) {
                z = false;
            }
            if (!z) {
                arrayList.add(new TeacherIntroduceNode(teacherDetailsHeader2.getExperience(), teacherDetailsHeader2.getName(), teacherDetailsHeader2.getAvatar(), teacherDetailsHeader2.getEducation(), teacherDetailsHeader2.getHighlightList(), teacherDetailsHeader2.getTeacherId(), (List) null, 64, (DefaultConstructorMarker) null));
            }
            ((TeacherDetailsHeader) objectRef.element).setNodeList(arrayList);
        }
        this.this$0.getMTeacherDetailsHeader().postSuccess(objectRef.element);
        return Unit.INSTANCE;
    }
}
