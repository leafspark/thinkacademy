package com.tal.app.thinkacademy.live.abilitypack.randomcall.listenbody;

import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallEndBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallStartBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u0016\u0017\u0018\u0019B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J)\u0010\u0011\u001a\u00020\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J)\u0010\u0013\u001a\u00020\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004J)\u0010\u0014\u001a\u00020\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J)\u0010\u0015\u001a\u00020\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0004R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000\u0001\u0004\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "randomCallLotteryEndAction", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "Lkotlin/ParameterName;", "name", "randomCallEndBean", "", "randomCallLotteryStartAction", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "randomCallStartBean", "randomCallPhotoWallEndAction", "randomCallPhotoWallStartAction", "dispatch", "listener", "onRandomCallLotteryEnd", "action", "onRandomCallLotteryStart", "onRandomCallPhotoWallEnd", "onRandomCallPhotoWallStart", "RandomCallLotteryEnd", "RandomCallLotteryStart", "RandomCallPhotoWallEnd", "RandomCallPhotoWallStart", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallLotteryStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallLotteryEnd;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallPhotoWallStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallPhotoWallEnd;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallListenerBody.kt */
public abstract class RandomCallListenerBody extends ListenerBody<RandomCallListenerBody> {
    private Function1<? super RandomCallEndBean, Unit> randomCallLotteryEndAction;
    private Function1<? super RandomCallStartBean, Unit> randomCallLotteryStartAction;
    private Function1<? super RandomCallEndBean, Unit> randomCallPhotoWallEndAction;
    private Function1<? super RandomCallStartBean, Unit> randomCallPhotoWallStartAction;

    public /* synthetic */ RandomCallListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RandomCallListenerBody() {
    }

    public void dispatch(RandomCallListenerBody randomCallListenerBody) {
        Function1<? super RandomCallEndBean, Unit> function1;
        Intrinsics.checkNotNullParameter(randomCallListenerBody, "listener");
        if (randomCallListenerBody instanceof RandomCallLotteryStart) {
            Function1<? super RandomCallStartBean, Unit> function12 = this.randomCallLotteryStartAction;
            if (function12 != null) {
                function12.invoke(((RandomCallLotteryStart) randomCallListenerBody).getRandomCallStartBean());
            }
        } else if (randomCallListenerBody instanceof RandomCallLotteryEnd) {
            Function1<? super RandomCallEndBean, Unit> function13 = this.randomCallLotteryEndAction;
            if (function13 != null) {
                function13.invoke(((RandomCallLotteryEnd) randomCallListenerBody).getRandomCallEndBean());
            }
        } else if (randomCallListenerBody instanceof RandomCallPhotoWallStart) {
            Function1<? super RandomCallStartBean, Unit> function14 = this.randomCallPhotoWallStartAction;
            if (function14 != null) {
                function14.invoke(((RandomCallPhotoWallStart) randomCallListenerBody).getRandomCallStartBean());
            }
        } else if ((randomCallListenerBody instanceof RandomCallPhotoWallEnd) && (function1 = this.randomCallPhotoWallEndAction) != null) {
            function1.invoke(((RandomCallPhotoWallEnd) randomCallListenerBody).getRandomCallEndBean());
        }
    }

    public final void onRandomCallLotteryStart(Function1<? super RandomCallStartBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.randomCallLotteryStartAction = function1;
    }

    public final void onRandomCallLotteryEnd(Function1<? super RandomCallEndBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.randomCallLotteryEndAction = function1;
    }

    public final void onRandomCallPhotoWallStart(Function1<? super RandomCallStartBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.randomCallPhotoWallStartAction = function1;
    }

    public final void onRandomCallPhotoWallEnd(Function1<? super RandomCallEndBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.randomCallPhotoWallEndAction = function1;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallLotteryStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "randomCallStartBean", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;)V", "getRandomCallStartBean", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "setRandomCallStartBean", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallListenerBody.kt */
    public static final class RandomCallLotteryStart extends RandomCallListenerBody {
        private RandomCallStartBean randomCallStartBean;

        public final RandomCallStartBean getRandomCallStartBean() {
            return this.randomCallStartBean;
        }

        public final void setRandomCallStartBean(RandomCallStartBean randomCallStartBean2) {
            Intrinsics.checkNotNullParameter(randomCallStartBean2, "<set-?>");
            this.randomCallStartBean = randomCallStartBean2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RandomCallLotteryStart(RandomCallStartBean randomCallStartBean2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(randomCallStartBean2, "randomCallStartBean");
            this.randomCallStartBean = randomCallStartBean2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallLotteryEnd;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "randomCallEndBean", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;)V", "getRandomCallEndBean", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "setRandomCallEndBean", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallListenerBody.kt */
    public static final class RandomCallLotteryEnd extends RandomCallListenerBody {
        private RandomCallEndBean randomCallEndBean;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RandomCallLotteryEnd(RandomCallEndBean randomCallEndBean2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(randomCallEndBean2, "randomCallEndBean");
            this.randomCallEndBean = randomCallEndBean2;
        }

        public final RandomCallEndBean getRandomCallEndBean() {
            return this.randomCallEndBean;
        }

        public final void setRandomCallEndBean(RandomCallEndBean randomCallEndBean2) {
            Intrinsics.checkNotNullParameter(randomCallEndBean2, "<set-?>");
            this.randomCallEndBean = randomCallEndBean2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallPhotoWallStart;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "randomCallStartBean", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;)V", "getRandomCallStartBean", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "setRandomCallStartBean", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallListenerBody.kt */
    public static final class RandomCallPhotoWallStart extends RandomCallListenerBody {
        private RandomCallStartBean randomCallStartBean;

        public final RandomCallStartBean getRandomCallStartBean() {
            return this.randomCallStartBean;
        }

        public final void setRandomCallStartBean(RandomCallStartBean randomCallStartBean2) {
            Intrinsics.checkNotNullParameter(randomCallStartBean2, "<set-?>");
            this.randomCallStartBean = randomCallStartBean2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RandomCallPhotoWallStart(RandomCallStartBean randomCallStartBean2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(randomCallStartBean2, "randomCallStartBean");
            this.randomCallStartBean = randomCallStartBean2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody$RandomCallPhotoWallEnd;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "randomCallEndBean", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;)V", "getRandomCallEndBean", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "setRandomCallEndBean", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallListenerBody.kt */
    public static final class RandomCallPhotoWallEnd extends RandomCallListenerBody {
        private RandomCallEndBean randomCallEndBean;

        public final RandomCallEndBean getRandomCallEndBean() {
            return this.randomCallEndBean;
        }

        public final void setRandomCallEndBean(RandomCallEndBean randomCallEndBean2) {
            Intrinsics.checkNotNullParameter(randomCallEndBean2, "<set-?>");
            this.randomCallEndBean = randomCallEndBean2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RandomCallPhotoWallEnd(RandomCallEndBean randomCallEndBean2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(randomCallEndBean2, "randomCallEndBean");
            this.randomCallEndBean = randomCallEndBean2;
        }
    }
}
