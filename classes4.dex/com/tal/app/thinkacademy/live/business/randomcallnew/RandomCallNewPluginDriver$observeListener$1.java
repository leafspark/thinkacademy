package com.tal.app.thinkacademy.live.business.randomcallnew;

import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.listenbody.RandomCallListenerBody;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallEndBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallStartBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallNewPluginDriver.kt */
final class RandomCallNewPluginDriver$observeListener$1 extends Lambda implements Function1<RandomCallListenerBody, Unit> {
    final /* synthetic */ RandomCallNewPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RandomCallNewPluginDriver$observeListener$1(RandomCallNewPluginDriver randomCallNewPluginDriver) {
        super(1);
        this.this$0 = randomCallNewPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RandomCallListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RandomCallListenerBody randomCallListenerBody) {
        Intrinsics.checkNotNullParameter(randomCallListenerBody, "$this$observeListener");
        final RandomCallNewPluginDriver randomCallNewPluginDriver = this.this$0;
        randomCallListenerBody.onRandomCallLotteryStart(new Function1<RandomCallStartBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RandomCallStartBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RandomCallStartBean randomCallStartBean) {
                Intrinsics.checkNotNullParameter(randomCallStartBean, "it");
                ArrayList<RandomCallUserBean> students = randomCallStartBean.getStudents();
                if (students != null) {
                    RandomCallNewPluginDriver randomCallNewPluginDriver = randomCallNewPluginDriver;
                    randomCallNewPluginDriver.destroyLotteryPluginView();
                    randomCallNewPluginDriver.loadLotteryPluginView(students, randomCallStartBean.getSelected());
                    randomCallNewPluginDriver.startRandomSelect();
                }
            }
        });
        final RandomCallNewPluginDriver randomCallNewPluginDriver2 = this.this$0;
        randomCallListenerBody.onRandomCallLotteryEnd(new Function1<RandomCallEndBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RandomCallEndBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RandomCallEndBean randomCallEndBean) {
                Intrinsics.checkNotNullParameter(randomCallEndBean, "it");
                randomCallNewPluginDriver2.destroyLotteryPluginView();
            }
        });
        final RandomCallNewPluginDriver randomCallNewPluginDriver3 = this.this$0;
        randomCallListenerBody.onRandomCallPhotoWallStart(new Function1<RandomCallStartBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RandomCallStartBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RandomCallStartBean randomCallStartBean) {
                Intrinsics.checkNotNullParameter(randomCallStartBean, "it");
                RandomCallViewModel access$getMViewModel$p = randomCallNewPluginDriver3.mViewModel;
                boolean z = false;
                if (access$getMViewModel$p != null && access$getMViewModel$p.isOpenStream()) {
                    z = true;
                }
                if (z) {
                    PluginEventBus.onEvent(DataBusKey.RANDOM_CALL_KEY, new PluginEventData(RandomCallNewPluginDriver.class, DataBusKey.RANDOM_CALL_KEY, "1"));
                }
                randomCallNewPluginDriver3.destroyRandomCallPhotoWallView(true);
                randomCallNewPluginDriver3.loadRandomCallPhotoWallView(randomCallStartBean.getStudents(), randomCallStartBean.getSelected());
            }
        });
        final RandomCallNewPluginDriver randomCallNewPluginDriver4 = this.this$0;
        randomCallListenerBody.onRandomCallPhotoWallEnd(new Function1<RandomCallEndBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RandomCallEndBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RandomCallEndBean randomCallEndBean) {
                Intrinsics.checkNotNullParameter(randomCallEndBean, "it");
                boolean z = true;
                randomCallNewPluginDriver4.destroyRandomCallPhotoWallView(!Intrinsics.areEqual(randomCallEndBean.isOnStage(), true));
                if (Intrinsics.areEqual(randomCallEndBean.getRecoverVideo(), true)) {
                    RandomCallViewModel access$getMViewModel$p = randomCallNewPluginDriver4.mViewModel;
                    if (access$getMViewModel$p == null || !access$getMViewModel$p.isOpenStream()) {
                        z = false;
                    }
                    if (z) {
                        PluginEventBus.onEvent(DataBusKey.RANDOM_CALL_KEY, new PluginEventData(RandomCallNewPluginDriver.class, DataBusKey.RANDOM_CALL_KEY, "2"));
                    }
                }
            }
        });
    }
}
