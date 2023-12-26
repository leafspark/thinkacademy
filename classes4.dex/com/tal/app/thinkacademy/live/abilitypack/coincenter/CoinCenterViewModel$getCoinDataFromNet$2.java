package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.yy.mobile.rollingtextview.RollingTextView;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel$getCoinDataFromNet$2", f = "CoinCenterViewModel.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoinCenterViewModel.kt */
final class CoinCenterViewModel$getCoinDataFromNet$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoinCenterRepository $repository;
    int label;
    final /* synthetic */ CoinCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoinCenterViewModel$getCoinDataFromNet$2(CoinCenterRepository coinCenterRepository, CoinCenterViewModel coinCenterViewModel, Continuation<? super CoinCenterViewModel$getCoinDataFromNet$2> continuation) {
        super(2, continuation);
        this.$repository = coinCenterRepository;
        this.this$0 = coinCenterViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new CoinCenterViewModel$getCoinDataFromNet$2(this.$repository, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$repository.studentCoinAndMedal(this.this$0.getPlanId(), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CoinData coinData = (CoinData) obj;
        if (coinData != null) {
            CoinCenterViewModel coinCenterViewModel = this.this$0;
            coinCenterViewModel.mCurrentCoinInfo = coinData;
            String totalCoin = coinData.getTotalCoin();
            if (totalCoin != null) {
                coinCenterViewModel.getMLiveRoomProvider().getDataStorage().getUserInfo().setGoldNum(Integer.parseInt(totalCoin));
            }
            boolean isSmallClass = coinCenterViewModel.getMLiveRoomProvider().isSmallClass();
            String str = EnterRoomMuteData.STATUS_UN_MUTE;
            if (isSmallClass) {
                RollingTextView mCoinTextView = coinCenterViewModel.getMCoinTextView();
                if (mCoinTextView != null) {
                    String planIdCoin = coinData.getPlanIdCoin();
                    if (planIdCoin != null) {
                        str = planIdCoin;
                    }
                    mCoinTextView.setText(str, false);
                }
            } else {
                RollingTextView mCoinTextView2 = coinCenterViewModel.getMCoinTextView();
                if (mCoinTextView2 != null) {
                    String totalCoin2 = coinData.getTotalCoin();
                    if (totalCoin2 != null) {
                        str = totalCoin2;
                    }
                    mCoinTextView2.setText(str, false);
                }
            }
            coinCenterViewModel.postUserInfo(coinData);
            String medalNum = coinData.getMedalNum();
            if (medalNum != null) {
                coinCenterViewModel.sendLevelUpMsg(Integer.parseInt(medalNum));
            }
            coinCenterViewModel.resetIsRunningAndClearLastEvent();
        }
        return Unit.INSTANCE;
    }
}
