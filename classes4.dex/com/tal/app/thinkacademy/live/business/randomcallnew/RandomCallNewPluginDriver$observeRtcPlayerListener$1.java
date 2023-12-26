package com.tal.app.thinkacademy.live.business.randomcallnew;

import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.BaseRandomCallPhotoWallPluginView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallNewPluginDriver.kt */
final class RandomCallNewPluginDriver$observeRtcPlayerListener$1 extends Lambda implements Function1<RtcPlayerListenerBody, Unit> {
    final /* synthetic */ RandomCallNewPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RandomCallNewPluginDriver$observeRtcPlayerListener$1(RandomCallNewPluginDriver randomCallNewPluginDriver) {
        super(1);
        this.this$0 = randomCallNewPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RtcPlayerListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "$this$observeListener");
        final RandomCallNewPluginDriver randomCallNewPluginDriver = this.this$0;
        rtcPlayerListenerBody.isOnline(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Integer num;
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                RandomCallViewModel access$getMViewModel$p = randomCallNewPluginDriver.mViewModel;
                Pair<Integer, RandomCallUserBean> studentPosition = access$getMViewModel$p == null ? null : access$getMViewModel$p.getStudentPosition(Long.valueOf(j));
                if (studentPosition != null && (num = (Integer) studentPosition.getFirst()) != null) {
                    RandomCallNewPluginDriver randomCallNewPluginDriver = randomCallNewPluginDriver;
                    int intValue = num.intValue();
                    RandomCallUserBean randomCallUserBean = (RandomCallUserBean) studentPosition.getSecond();
                    if (randomCallUserBean != null) {
                        int i = 0;
                        if (rtcUserState.getMIsOnline()) {
                            XesLog.i(RandomCallNewPluginDriver.TAG, "学员上线>>>" + GsonUtil.getInstance().objToJson(studentPosition.getSecond()) + "，视频流状态=" + rtcUserState.getMIsOpenCamera());
                        } else {
                            RtcViewModel access$getMRtcViewModel$p = randomCallNewPluginDriver.mRtcViewModel;
                            if (access$getMRtcViewModel$p != null) {
                                access$getMRtcViewModel$p.stopRemoteVideo(j);
                            }
                            XesLog.i(RandomCallNewPluginDriver.TAG, Intrinsics.stringPlus("学员下线>>>", GsonUtil.getInstance().objToJson(studentPosition.getSecond())));
                            i = 3;
                        }
                        randomCallUserBean.setPullStreamState(i);
                    }
                    BaseRandomCallPhotoWallPluginView access$getMPhotoWallPluginView$p = randomCallNewPluginDriver.mPhotoWallPluginView;
                    if (access$getMPhotoWallPluginView$p != null) {
                        access$getMPhotoWallPluginView$p.refresh(intValue);
                    }
                }
            }
        });
        final RandomCallNewPluginDriver randomCallNewPluginDriver2 = this.this$0;
        rtcPlayerListenerBody.onRtcStateChanged(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Integer num;
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                RandomCallViewModel access$getMViewModel$p = randomCallNewPluginDriver2.mViewModel;
                Pair<Integer, RandomCallUserBean> studentPosition = access$getMViewModel$p == null ? null : access$getMViewModel$p.getStudentPosition(Long.valueOf(j));
                if (studentPosition != null && (num = (Integer) studentPosition.getFirst()) != null) {
                    RandomCallNewPluginDriver randomCallNewPluginDriver = randomCallNewPluginDriver2;
                    int intValue = num.intValue();
                    RandomCallUserBean randomCallUserBean = (RandomCallUserBean) studentPosition.getSecond();
                    if (randomCallUserBean != null) {
                        if (rtcUserState.getMIsOpenCamera()) {
                            randomCallUserBean.setPullStreamState(2);
                        }
                        XesLog.i(RandomCallNewPluginDriver.TAG, "学员视频流状态变化>>>" + GsonUtil.getInstance().objToJson(studentPosition.getSecond()) + "，视频流状态=" + rtcUserState.getMIsOpenCamera());
                    }
                    BaseRandomCallPhotoWallPluginView access$getMPhotoWallPluginView$p = randomCallNewPluginDriver.mPhotoWallPluginView;
                    if (access$getMPhotoWallPluginView$p != null) {
                        access$getMPhotoWallPluginView$p.refresh(intValue);
                    }
                }
            }
        });
        final RandomCallNewPluginDriver randomCallNewPluginDriver3 = this.this$0;
        rtcPlayerListenerBody.onLocalVideoChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Integer num;
                String uid;
                RandomCallViewModel access$getMViewModel$p = randomCallNewPluginDriver3.mViewModel;
                Long l = null;
                if (access$getMViewModel$p != null) {
                    UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                    if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
                        l = Long.valueOf(Long.parseLong(uid));
                    }
                    l = access$getMViewModel$p.getStudentPosition(l);
                }
                if (l != null && (num = (Integer) l.getFirst()) != null) {
                    RandomCallNewPluginDriver randomCallNewPluginDriver = randomCallNewPluginDriver3;
                    int intValue = num.intValue();
                    XesLog.i(RandomCallNewPluginDriver.TAG, "本人视频流状态变化>>>" + GsonUtil.getInstance().objToJson(l.getSecond()) + "，本人视频流状态=" + z);
                    BaseRandomCallPhotoWallPluginView access$getMPhotoWallPluginView$p = randomCallNewPluginDriver.mPhotoWallPluginView;
                    if (access$getMPhotoWallPluginView$p != null) {
                        access$getMPhotoWallPluginView$p.refresh(intValue);
                    }
                }
            }
        });
    }
}
