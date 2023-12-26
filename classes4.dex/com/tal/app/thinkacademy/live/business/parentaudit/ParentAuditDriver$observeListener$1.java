package com.tal.app.thinkacademy.live.business.parentaudit;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParentAuditDriver.kt */
final class ParentAuditDriver$observeListener$1 extends Lambda implements Function1<RtcPlayerListenerBody, Unit> {
    final /* synthetic */ ParentAuditDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ParentAuditDriver$observeListener$1(ParentAuditDriver parentAuditDriver) {
        super(1);
        this.this$0 = parentAuditDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RtcPlayerListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "$this$observeListener");
        final ParentAuditDriver parentAuditDriver = this.this$0;
        rtcPlayerListenerBody.isOnline(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                if (parentAuditDriver.isChildStudent(j)) {
                    StudentVideoBean.ListBean access$getMMyChildInfo$p = parentAuditDriver.mMyChildInfo;
                    ParentAuditDriver parentAuditDriver = parentAuditDriver;
                    if (rtcUserState.getMIsOnline()) {
                        access$getMMyChildInfo$p.setPullStreamState(0);
                        access$getMMyChildInfo$p.setOpenMic(rtcUserState.getMIsOpenMic());
                        access$getMMyChildInfo$p.setOpenCamera(rtcUserState.getMIsOpenCamera());
                        access$getMMyChildInfo$p.setStudentOnline(rtcUserState.getMIsOnline());
                    } else {
                        access$getMMyChildInfo$p.setPullStreamState(3);
                        access$getMMyChildInfo$p.setOpenCamera(rtcUserState.getMIsOpenCamera());
                        access$getMMyChildInfo$p.setStudentOnline(false);
                        access$getMMyChildInfo$p.setShowEmoji(false);
                        access$getMMyChildInfo$p.setRaiseHandUp(false);
                        access$getMMyChildInfo$p.setOnStageAction(false);
                        access$getMMyChildInfo$p.setOpenMic(false);
                    }
                    parentAuditDriver.bindSurfaceView(access$getMMyChildInfo$p);
                    BaseParentAuditPluginView access$getMPluginView$p = parentAuditDriver.mPluginView;
                    if (access$getMPluginView$p != null) {
                        access$getMPluginView$p.showChildInfo(access$getMMyChildInfo$p);
                    }
                }
            }
        });
        final ParentAuditDriver parentAuditDriver2 = this.this$0;
        rtcPlayerListenerBody.onRtcStateChanged(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                if (parentAuditDriver2.isChildStudent(j)) {
                    StudentVideoBean.ListBean access$getMMyChildInfo$p = parentAuditDriver2.mMyChildInfo;
                    ParentAuditDriver parentAuditDriver = parentAuditDriver2;
                    XesLog.i(ParentAuditDriver.TAG, Intrinsics.stringPlus("onRtcStateChanged uid = ", Long.valueOf(rtcUserState.getMUid())));
                    access$getMMyChildInfo$p.setOpenCamera(rtcUserState.getMIsOpenCamera());
                    access$getMMyChildInfo$p.setOpenMic(rtcUserState.getMIsOpenMic());
                    if (access$getMMyChildInfo$p.isOpenCamera()) {
                        access$getMMyChildInfo$p.setPullStreamState(2);
                    }
                    parentAuditDriver.bindSurfaceView(access$getMMyChildInfo$p);
                    BaseParentAuditPluginView access$getMPluginView$p = parentAuditDriver.mPluginView;
                    if (access$getMPluginView$p != null) {
                        access$getMPluginView$p.showChildInfo(access$getMMyChildInfo$p);
                    }
                }
            }
        });
        final ParentAuditDriver parentAuditDriver3 = this.this$0;
        rtcPlayerListenerBody.onVolumeChange(new Function2<Long, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, int i) {
                BaseParentAuditPluginView access$getMPluginView$p;
                StudentVideoBean.ListBean unused = parentAuditDriver3.mMyChildInfo;
                ParentAuditDriver parentAuditDriver = parentAuditDriver3;
                if (parentAuditDriver.isChildStudent(j) && (access$getMPluginView$p = parentAuditDriver.mPluginView) != null) {
                    access$getMPluginView$p.showMicVolume(j, i);
                }
            }
        });
    }
}
