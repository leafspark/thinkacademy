package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.AddStudentViewModel$addNewStudent$2", f = "AddStudentViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddStudentViewModel.kt */
final class AddStudentViewModel$addNewStudent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $firstName;
    final /* synthetic */ Integer $gradeId;
    final /* synthetic */ String $lastName;
    final /* synthetic */ String $nickName;
    int label;
    final /* synthetic */ AddStudentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddStudentViewModel$addNewStudent$2(AddStudentViewModel addStudentViewModel, String str, String str2, String str3, Integer num, String str4, Continuation<? super AddStudentViewModel$addNewStudent$2> continuation) {
        super(2, continuation);
        this.this$0 = addStudentViewModel;
        this.$nickName = str;
        this.$firstName = str2;
        this.$lastName = str3;
        this.$gradeId = num;
        this.$email = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddStudentViewModel$addNewStudent$2(this.this$0, this.$nickName, this.$firstName, this.$lastName, this.$gradeId, this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddStudentViewModel$addNewStudent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Integer id;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.repository.addNewStudent(this.$nickName, this.$firstName, this.$lastName, this.$gradeId, this.$email, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AddNewStudent addNewStudent = (AddNewStudent) obj;
        this.this$0.getAddNewStudent().postSuccess(addNewStudent);
        LoginTrack loginTrack = LoginTrack.INSTANCE;
        String str = null;
        if (!(addNewStudent == null || (id = addNewStudent.getId()) == null)) {
            str = id.toString();
        }
        loginTrack.addStudentResult(1, str);
        return Unit.INSTANCE;
    }
}
