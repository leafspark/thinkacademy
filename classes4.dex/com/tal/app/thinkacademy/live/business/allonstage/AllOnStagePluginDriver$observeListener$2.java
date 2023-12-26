package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net.ApiResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiResponse;", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginDriver.kt */
final class AllOnStagePluginDriver$observeListener$2 extends Lambda implements Function1<ApiResponse<List<? extends StudentVideoBean.ListBean>>, Unit> {
    final /* synthetic */ AllOnStagePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginDriver$observeListener$2(AllOnStagePluginDriver allOnStagePluginDriver) {
        super(1);
        this.this$0 = allOnStagePluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ApiResponse<List<StudentVideoBean.ListBean>>) (ApiResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ApiResponse<List<StudentVideoBean.ListBean>> apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "$this$observeListener");
        final AllOnStagePluginDriver allOnStagePluginDriver = this.this$0;
        apiResponse.success(new Function1<List<? extends StudentVideoBean.ListBean>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends StudentVideoBean.ListBean>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends StudentVideoBean.ListBean> list) {
                StudentVideoBean.ListBean selfBean;
                boolean z;
                boolean z2;
                if (list != null) {
                    AllOnStagePluginDriver allOnStagePluginDriver = allOnStagePluginDriver;
                    int size = list.size();
                    int i = 0;
                    while (i < size) {
                        int i2 = i + 1;
                        StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) list.get(i);
                        allOnStagePluginDriver.mAllStudentMap.put(Long.valueOf(listBean.getUserId()), listBean);
                        i = i2;
                    }
                    BaseAllOnStagePluginView access$getMPluginView$p = allOnStagePluginDriver.mPluginView;
                    if (access$getMPluginView$p != null) {
                        access$getMPluginView$p.setStudentSize(list.size());
                    }
                }
                RtcViewModel access$getMRtcViewModel$p = allOnStagePluginDriver.mRtcViewModel;
                if (access$getMRtcViewModel$p != null) {
                    AllOnStagePluginDriver allOnStagePluginDriver2 = allOnStagePluginDriver;
                    ArrayList<Long> remoteList = access$getMRtcViewModel$p.getRemoteList();
                    if (remoteList != null) {
                        XesLog.i(AllOnStagePluginDriver.TAG, Intrinsics.stringPlus("全员上台 remoteUsers ：", GsonUtils.toJson(remoteList)));
                        int size2 = remoteList.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            int i4 = i3 + 1;
                            StudentVideoBean.ListBean listBean2 = (StudentVideoBean.ListBean) allOnStagePluginDriver2.mAllStudentMap.get(remoteList.get(i3));
                            if (listBean2 != null && !allOnStagePluginDriver2.getMOnlineStudentList().contains(listBean2)) {
                                Long l = remoteList.get(i3);
                                Intrinsics.checkNotNullExpressionValue(l, "remoteUsers[i]");
                                RtcUserState remoteState = access$getMRtcViewModel$p.getRemoteState(l.longValue());
                                if (remoteState == null) {
                                    z = false;
                                } else {
                                    z = remoteState.getMIsOpenMic();
                                }
                                listBean2.setOpenMic(z);
                                if (remoteState == null) {
                                    z2 = false;
                                } else {
                                    z2 = remoteState.getMIsOpenCamera();
                                }
                                listBean2.setOpenCamera(z2);
                                XesLog.i(AllOnStagePluginDriver.TAG, Intrinsics.stringPlus("上线学员 ：", Long.valueOf(listBean2.getUserId())));
                                allOnStagePluginDriver2.getMOnlineStudentList().add(allOnStagePluginDriver2.getMOnlineStudentList().size(), listBean2);
                            }
                            i3 = i4;
                        }
                    }
                    AllOnStageViewModel access$getMViewModel$p = allOnStagePluginDriver2.mViewModel;
                    if (!(access$getMViewModel$p == null || (selfBean = access$getMViewModel$p.getSelfBean()) == null)) {
                        selfBean.setOpenCamera(access$getMRtcViewModel$p.getMLocalVideoEnable());
                        selfBean.setOpenMic(access$getMRtcViewModel$p.getMLocalAudioEnable());
                        if (!allOnStagePluginDriver2.getMOnlineStudentList().contains(selfBean)) {
                            allOnStagePluginDriver2.getMOnlineStudentList().add(0, selfBean);
                        }
                        XesLog.i(AllOnStagePluginDriver.TAG, "接口请求成功，添加个人信息到学生列表");
                    }
                    BaseAllOnStagePluginView access$getMPluginView$p2 = allOnStagePluginDriver2.mPluginView;
                    if (access$getMPluginView$p2 != null) {
                        access$getMPluginView$p2.setRoomStudents(allOnStagePluginDriver2.getMOnlineStudentList());
                    }
                }
            }
        });
    }
}
