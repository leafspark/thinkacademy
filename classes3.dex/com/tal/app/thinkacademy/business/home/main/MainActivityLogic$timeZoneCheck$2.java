package com.tal.app.thinkacademy.business.home.main;

import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.MainActivityLogic$timeZoneCheck$2", f = "MainActivityLogic.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainActivityLogic.kt */
final class MainActivityLogic$timeZoneCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $timeZone;
    int label;
    final /* synthetic */ MainActivityLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityLogic$timeZoneCheck$2(MainActivityLogic mainActivityLogic, String str, Continuation<? super MainActivityLogic$timeZoneCheck$2> continuation) {
        super(2, continuation);
        this.this$0 = mainActivityLogic;
        this.$timeZone = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityLogic$timeZoneCheck$2(this.this$0, this.$timeZone, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityLogic$timeZoneCheck$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.apiTimezoneCheck(this.$timeZone, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TimeZoneCheckEntity timeZoneCheckEntity = (TimeZoneCheckEntity) obj;
        if (timeZoneCheckEntity != null) {
            MainActivityLogic mainActivityLogic = this.this$0;
            if (timeZoneCheckEntity.getInvalid() == 1) {
                ToastUtils.setGravity(17, 0, 0);
                ToastUtils.showShort(R.string.the_time_zone_has_been_switched_to, new Object[]{TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone()});
            }
            ShareDataManager.getInstance().put("real_show_time_zone", timeZoneCheckEntity.getInvalid() == 0 ? TimeZone.getDefault().getID() : TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
            String timeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            if (!Intrinsics.areEqual((Object) timeZone, (Object) mainActivityLogic.mCurrentTimeZone)) {
                mainActivityLogic.mCurrentTimeZone = timeZone;
                XesLog.i(mainActivityLogic.TAG, new Object[]{Intrinsics.stringPlus("时区信息已经改变，发送flutter，当前为=", mainActivityLogic.mCurrentTimeZone)});
                HwFlutterUtil.INSTANCE.sendEventToFlutterSwitchTimeZone();
            }
        }
        return Unit.INSTANCE;
    }
}
