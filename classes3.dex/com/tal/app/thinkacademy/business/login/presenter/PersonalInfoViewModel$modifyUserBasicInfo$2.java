package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.entity.LinkedAccount;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.PersonalInfoViewModel$modifyUserBasicInfo$2", f = "PersonalInfoViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PersonalInfoViewModel.kt */
final class PersonalInfoViewModel$modifyUserBasicInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatar;
    final /* synthetic */ String $firstName;
    final /* synthetic */ Integer $grade;
    final /* synthetic */ String $lastName;
    final /* synthetic */ List<LinkedAccount> $linkedAccount;
    final /* synthetic */ String $nickName;
    Object L$0;
    int label;
    final /* synthetic */ PersonalInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalInfoViewModel$modifyUserBasicInfo$2(PersonalInfoViewModel personalInfoViewModel, String str, String str2, String str3, String str4, Integer num, List<LinkedAccount> list, Continuation<? super PersonalInfoViewModel$modifyUserBasicInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = personalInfoViewModel;
        this.$avatar = str;
        this.$nickName = str2;
        this.$firstName = str3;
        this.$lastName = str4;
        this.$grade = num;
        this.$linkedAccount = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersonalInfoViewModel$modifyUserBasicInfo$2(this.this$0, this.$avatar, this.$nickName, this.$firstName, this.$lastName, this.$grade, this.$linkedAccount, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersonalInfoViewModel$modifyUserBasicInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<Object> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<Object> changeUser = this.this$0.getChangeUser();
            this.L$0 = changeUser;
            this.label = 1;
            Object modifyUserBasicInfo = this.this$0.repository.modifyUserBasicInfo(this.$avatar, this.$nickName, this.$firstName, this.$lastName, this.$grade, this.$linkedAccount, this);
            if (modifyUserBasicInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = changeUser;
            obj = modifyUserBasicInfo;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        LoginTrack.INSTANCE.savePersonalInfoResult(1);
        return Unit.INSTANCE;
    }
}
