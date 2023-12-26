package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginDriver.kt */
final class AllOnStagePluginDriver$observeListener$3 extends Lambda implements Function1<RtcPlayerListenerBody, Unit> {
    final /* synthetic */ AllOnStagePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginDriver$observeListener$3(AllOnStagePluginDriver allOnStagePluginDriver) {
        super(1);
        this.this$0 = allOnStagePluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RtcPlayerListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "$this$observeListener");
        final AllOnStagePluginDriver allOnStagePluginDriver = this.this$0;
        rtcPlayerListenerBody.isOnline(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) allOnStagePluginDriver.mAllStudentMap.get(Long.valueOf(j));
                if (listBean != null) {
                    AllOnStagePluginDriver allOnStagePluginDriver = allOnStagePluginDriver;
                    XesLog.i(AllOnStagePluginDriver.TAG, "isOnline uid = " + rtcUserState.getMUid() + ",online = " + rtcUserState.getMIsOnline());
                    if (!rtcUserState.getMIsOnline()) {
                        int indexOf = allOnStagePluginDriver.getMOnlineStudentList().indexOf(listBean);
                        if (indexOf > -1) {
                            RtcViewModel access$getMRtcViewModel$p = allOnStagePluginDriver.mRtcViewModel;
                            if (access$getMRtcViewModel$p != null) {
                                access$getMRtcViewModel$p.stopRemoteVideo(j);
                            }
                            listBean.setPullStreamState(3);
                            listBean.setOpenCamera(rtcUserState.getMIsOpenCamera());
                            listBean.setStudentOnline(false);
                            listBean.setShowEmoji(false);
                            listBean.setRaiseHandUp(false);
                            listBean.setOnStageAction(false);
                            listBean.setOpenMic(false);
                            allOnStagePluginDriver.getMOnlineStudentList().remove(indexOf);
                            BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver.mPluginView;
                            if (access$getMPluginView$p != null) {
                                access$getMPluginView$p.removeStudent(allOnStagePluginDriver.getMOnlineStudentList(), indexOf);
                            }
                        }
                    } else if (!allOnStagePluginDriver.getMOnlineStudentList().contains(listBean)) {
                        listBean.setPullStreamState(0);
                        listBean.setOpenMic(rtcUserState.getMIsOpenMic());
                        listBean.setOpenCamera(rtcUserState.getMIsOpenCamera());
                        allOnStagePluginDriver.getMOnlineStudentList().add(allOnStagePluginDriver.getMOnlineStudentList().size(), listBean);
                        BaseAllOnStagePluginView access$getMPluginView$p2 = allOnStagePluginDriver.mPluginView;
                        if (access$getMPluginView$p2 != null) {
                            access$getMPluginView$p2.addStudent(allOnStagePluginDriver.getMOnlineStudentList(), allOnStagePluginDriver.getMOnlineStudentList().size() - 1);
                        }
                    }
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver2 = this.this$0;
        rtcPlayerListenerBody.onRtcStateChanged(new Function2<Long, RtcUserState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), (RtcUserState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, RtcUserState rtcUserState) {
                Intrinsics.checkNotNullParameter(rtcUserState, "state");
                StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) allOnStagePluginDriver2.mAllStudentMap.get(Long.valueOf(j));
                if (listBean != null) {
                    AllOnStagePluginDriver allOnStagePluginDriver = allOnStagePluginDriver2;
                    XesLog.i(AllOnStagePluginDriver.TAG, Intrinsics.stringPlus("onRtcStateChanged uid = ", Long.valueOf(rtcUserState.getMUid())));
                    int indexOf = allOnStagePluginDriver.getMOnlineStudentList().indexOf(listBean);
                    if (indexOf > -1) {
                        listBean.setOpenCamera(rtcUserState.getMIsOpenCamera());
                        listBean.setOpenMic(rtcUserState.getMIsOpenMic());
                        if (listBean.isOpenCamera()) {
                            listBean.setPullStreamState(2);
                        }
                        BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver.mPluginView;
                        if (access$getMPluginView$p != null) {
                            access$getMPluginView$p.changeStudent(allOnStagePluginDriver.getMOnlineStudentList(), indexOf);
                        }
                    }
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver3 = this.this$0;
        rtcPlayerListenerBody.onVolumeChange(new Function2<Long, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, int i) {
                TeacherOnStageMsg access$getMTeacherInfo$p = allOnStagePluginDriver3.mTeacherInfo;
                if (access$getMTeacherInfo$p != null) {
                    AllOnStagePluginDriver allOnStagePluginDriver = allOnStagePluginDriver3;
                    if (access$getMTeacherInfo$p.getTeacherAudioUid() == j) {
                        BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver.mPluginView;
                        if (access$getMPluginView$p != null) {
                            access$getMPluginView$p.setTeacherVolume(i);
                            return;
                        }
                        return;
                    }
                }
                BaseAllOnStagePluginView access$getMPluginView$p2 = allOnStagePluginDriver3.mPluginView;
                if (access$getMPluginView$p2 != null) {
                    access$getMPluginView$p2.setStudentVolume(j, i);
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver4 = this.this$0;
        rtcPlayerListenerBody.onLocalAudioChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver4.mPluginView;
                if (access$getMPluginView$p != null) {
                    access$getMPluginView$p.enableLocalMic(z);
                }
                if (allOnStagePluginDriver4.getMOnlineStudentList().size() > 0) {
                    allOnStagePluginDriver4.getMOnlineStudentList().get(0).setOpenMic(z);
                    BaseAllOnStagePluginView access$getMPluginView$p2 = allOnStagePluginDriver4.mPluginView;
                    if (access$getMPluginView$p2 != null) {
                        access$getMPluginView$p2.changeStudent(allOnStagePluginDriver4.getMOnlineStudentList(), 0);
                    }
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver5 = this.this$0;
        rtcPlayerListenerBody.onLocalVideoChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver5.mPluginView;
                if (access$getMPluginView$p != null) {
                    access$getMPluginView$p.enableLocalCamera(z);
                }
                if (allOnStagePluginDriver5.getMOnlineStudentList().size() > 0) {
                    allOnStagePluginDriver5.getMOnlineStudentList().get(0).setOpenCamera(z);
                    BaseAllOnStagePluginView access$getMPluginView$p2 = allOnStagePluginDriver5.mPluginView;
                    if (access$getMPluginView$p2 != null) {
                        access$getMPluginView$p2.changeStudent(allOnStagePluginDriver5.getMOnlineStudentList(), 0);
                    }
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver6 = this.this$0;
        rtcPlayerListenerBody.onNetworkQuality(new Function3<Long, Integer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).longValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, int i, int i2) {
                int i3;
                BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver6.mPluginView;
                if (access$getMPluginView$p != null) {
                    RtcViewModel access$getMRtcViewModel$p = allOnStagePluginDriver6.mRtcViewModel;
                    Integer valueOf = access$getMRtcViewModel$p == null ? null : Integer.valueOf(access$getMRtcViewModel$p.getMNetworkQualityPicId());
                    if (valueOf == null) {
                        i3 = R.drawable.icon_wifi_navigation_good;
                    } else {
                        i3 = valueOf.intValue();
                    }
                    access$getMPluginView$p.setNetWorkQuality(i3);
                }
            }
        });
        final AllOnStagePluginDriver allOnStagePluginDriver7 = this.this$0;
        rtcPlayerListenerBody.onStudentListUpdate(new Function1<List<StudentVideoBean.ListBean>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<StudentVideoBean.ListBean>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<StudentVideoBean.ListBean> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                allOnStagePluginDriver7.updateStudentList(list);
            }
        });
    }
}
