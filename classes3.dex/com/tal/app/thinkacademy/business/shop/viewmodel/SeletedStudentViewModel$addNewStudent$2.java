package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$addNewStudent$2", f = "SeletedStudentViewModel.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SeletedStudentViewModel.kt */
final class SeletedStudentViewModel$addNewStudent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $firstName;
    final /* synthetic */ Integer $gradeId;
    final /* synthetic */ String $lastName;
    final /* synthetic */ String $nickName;
    Object L$0;
    int label;
    final /* synthetic */ SeletedStudentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeletedStudentViewModel$addNewStudent$2(SeletedStudentViewModel seletedStudentViewModel, String str, String str2, String str3, Integer num, String str4, Continuation<? super SeletedStudentViewModel$addNewStudent$2> continuation) {
        super(2, continuation);
        this.this$0 = seletedStudentViewModel;
        this.$nickName = str;
        this.$firstName = str2;
        this.$lastName = str3;
        this.$gradeId = num;
        this.$email = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeletedStudentViewModel$addNewStudent$2(this.this$0, this.$nickName, this.$firstName, this.$lastName, this.$gradeId, this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeletedStudentViewModel$addNewStudent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<AddNewStudent> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<AddNewStudent> addNewStudent = this.this$0.getAddNewStudent();
            this.L$0 = addNewStudent;
            this.label = 1;
            Object addNewStudent2 = this.this$0.getRepository().addNewStudent(this.$nickName, this.$firstName, this.$lastName, this.$gradeId, this.$email, this);
            if (addNewStudent2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = addNewStudent;
            obj = addNewStudent2;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        return Unit.INSTANCE;
    }
}
