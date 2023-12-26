package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import java.util.List;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$modifyUserBasicInfo$2", f = "SeletedStudentViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SeletedStudentViewModel.kt */
final class SeletedStudentViewModel$modifyUserBasicInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatar;
    final /* synthetic */ String $firstName;
    final /* synthetic */ Integer $grade;
    final /* synthetic */ String $lastName;
    final /* synthetic */ String $nickName;
    Object L$0;
    int label;
    final /* synthetic */ SeletedStudentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeletedStudentViewModel$modifyUserBasicInfo$2(SeletedStudentViewModel seletedStudentViewModel, String str, String str2, String str3, String str4, Integer num, Continuation<? super SeletedStudentViewModel$modifyUserBasicInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = seletedStudentViewModel;
        this.$avatar = str;
        this.$nickName = str2;
        this.$firstName = str3;
        this.$lastName = str4;
        this.$grade = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeletedStudentViewModel$modifyUserBasicInfo$2(this.this$0, this.$avatar, this.$nickName, this.$firstName, this.$lastName, this.$grade, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeletedStudentViewModel$modifyUserBasicInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<Object> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<Object> modifyUserInfo = this.this$0.getModifyUserInfo();
            this.L$0 = modifyUserInfo;
            this.label = 1;
            Object modifyUserBasicInfo$default = LoginRepository.modifyUserBasicInfo$default(this.this$0.getRepository(), this.$avatar, this.$nickName, this.$firstName, this.$lastName, this.$grade, (List) null, this, 32, (Object) null);
            if (modifyUserBasicInfo$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = modifyUserInfo;
            obj = modifyUserBasicInfo$default;
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
