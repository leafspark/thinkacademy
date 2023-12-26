package com.tal.app.thinkacademy.live.core.live;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.util.JsonUtil;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.FileIOUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.backplay.http.apis.LiveBackCoreApi;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataBackAndJoingPointBean;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.EnterRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.InitModuleRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.request.MetaDataRequest;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.live.bean.ReportDeviceBody;
import com.tal.app.thinkacademy.live.core.live.http.apis.LiveCoreApi;
import com.tal.app.thinkacademy.live.core.live.http.response.ClassroomDataEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.KeyEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import retrofit2.Call;

public class LiveViewModel extends BaseViewModel {
    public StateLiveData<EmojiDetailEntity> mEmojiDetailData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public EnterEntity mEnterEntity;
    private int mEnterIsPlayback = 2;
    public StateLiveData<EnterEntity> mEnterLiveData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public String mEnterPlanId;
    public StateLiveData<InitModuleEntity> mInitModuleLiveData = new StateLiveData<>();
    public StateLiveData<MetaDataEntity> mMetaData = new StateLiveData<>();
    public StateLiveData<ClassroomDataEntity> mRoomDataLiveData = new StateLiveData<>();

    public void requestEnter(final String str, String str2, String str3, int i, String str4, boolean z) {
        String str5 = str;
        String str6 = str2;
        this.mEnterPlanId = str6;
        this.mEnterIsPlayback = 0;
        int tryParseInt = ParseUtils.tryParseInt(str6, 0);
        int tryParseInt2 = ParseUtils.tryParseInt(str3, 0);
        int tryParseInt3 = ParseUtils.tryParseInt(str4, 0);
        final long currentTimeMillis = System.currentTimeMillis();
        Call requestEnter = ((LiveBackCoreApi) Api.create(LiveBackCoreApi.class)).requestEnter(str, new EnterRequest(i, tryParseInt, tryParseInt2, tryParseInt3, z ? 1 : 0));
        final String str7 = str;
        final String str8 = str2;
        AnonymousClass2 r0 = new OmyCallback<HiResponse<EnterEntity>>(new IError() {
            public void onFail(int i, String str) {
                LiveViewModel.this.mEnterLiveData.postFailure(i, str);
                XesLog.dt("Enter接口", new Object[]{str + "  errorCode=" + i + "  errorMsg=" + str});
            }

            public void onError(int i, String str) {
                LiveViewModel.this.mEnterLiveData.postError(i, str);
                XesLog.dt("Enter接口", new Object[]{str + "  errorCode=" + str + "  errorMsg=" + str});
            }
        }) {
            public void onSuccess(HiResponse<EnterEntity> hiResponse) {
                if (hiResponse.getData() != null) {
                    ((EnterEntity) hiResponse.getData()).setRequestDuration(System.currentTimeMillis() - currentTimeMillis);
                    XesDataBus.with("basic_request_success").postStickyData(Boolean.valueOf(((EnterEntity) hiResponse.getData()).getConfigs().isRaiseHand()));
                }
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(str7);
                sb.append(JsonUtil.toJson(hiResponse.getData() == null ? "Enter接口数据返回空" : ((EnterEntity) hiResponse.getData()).configs));
                objArr[0] = sb.toString();
                XesLog.dt("Enter接口", objArr);
                XesLog.it("GetCourseWareContentLog", new Object[]{"课堂页面>>>开始请求课件详情页接口"});
                ImCousesWare.INSTANCE.getCouseWareInfo(ParseUtils.tryParseInt(str8, 0), true);
                EnterEntity unused = LiveViewModel.this.mEnterEntity = (EnterEntity) hiResponse.getData();
            }
        };
        if (!(requestEnter instanceof Call)) {
            requestEnter.enqueue(r0);
        } else {
            Retrofit2Instrumentation.enqueue(requestEnter, r0);
        }
    }

    public void requestPlaybackEnter(final String str, String str2, String str3, int i, String str4, boolean z) {
        String str5 = str;
        this.mEnterIsPlayback = 1;
        String str6 = str2;
        int tryParseInt = ParseUtils.tryParseInt(str2, 0);
        int tryParseInt2 = ParseUtils.tryParseInt(str3, 0);
        int tryParseInt3 = ParseUtils.tryParseInt(str4, 0);
        final long currentTimeMillis = System.currentTimeMillis();
        Call requestPlaybackEnter = ((LiveBackCoreApi) Api.create(LiveBackCoreApi.class)).requestPlaybackEnter(str, true, new EnterRequest(i, tryParseInt, tryParseInt2, tryParseInt3, z ? 1 : 0));
        final String str7 = str;
        AnonymousClass4 r0 = new OmyCallback<HiResponse<EnterEntity>>(new IError() {
            public void onFail(int i, String str) {
                LiveViewModel.this.mEnterLiveData.postFailure(i, str);
                XesLog.dt("Enter接口", new Object[]{str + "  errorCode=" + i + "  errorMsg=" + str});
            }

            public void onError(int i, String str) {
                LiveViewModel.this.mEnterLiveData.postError(i, str);
                XesLog.dt("Enter接口", new Object[]{str + "  errorCode=" + str + "  errorMsg=" + str});
            }
        }) {
            public void onSuccess(HiResponse<EnterEntity> hiResponse) {
                if (hiResponse.getData() != null) {
                    ((EnterEntity) hiResponse.getData()).setRequestDuration(System.currentTimeMillis() - currentTimeMillis);
                    XesDataBus.with("basic_request_success").postStickyData(Boolean.valueOf(((EnterEntity) hiResponse.getData()).getConfigs().isRaiseHand()));
                }
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(str7);
                sb.append(JsonUtil.toJson(hiResponse.getData() == null ? "Enter接口数据返回空" : ((EnterEntity) hiResponse.getData()).configs));
                objArr[0] = sb.toString();
                XesLog.dt("Enter接口", objArr);
                LiveViewModel.this.mEnterLiveData.postSuccess((EnterEntity) hiResponse.getData());
            }
        };
        if (!(requestPlaybackEnter instanceof Call)) {
            requestPlaybackEnter.enqueue(r0);
        } else {
            Retrofit2Instrumentation.enqueue(requestPlaybackEnter, r0);
        }
    }

    public void requestInitModule(String str, int i, final int i2, boolean z) {
        boolean z2 = false;
        int tryParseInt = ParseUtils.tryParseInt(str, 0);
        String str2 = ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/initModule";
        LiveBackCoreApi liveBackCoreApi = (LiveBackCoreApi) Api.create(LiveBackCoreApi.class);
        if (i2 == 1) {
            z2 = true;
        }
        Call requestInitModule = liveBackCoreApi.requestInitModule(str2, z2, new InitModuleRequest(tryParseInt, i2, z ? 1 : 0));
        AnonymousClass6 r5 = new OmyCallback<HiResponse<InitModuleEntity>>(new IError() {
            public void onFail(int i, String str) {
                LiveViewModel.this.mEnterLiveData.postFailure(i, str);
                XesLog.dt("InitModule接口", new Object[]{"isPlayback=" + i2 + "  errorCode=" + i + "  errorMsg=" + str});
            }

            public void onError(int i, String str) {
                XesLog.dt("InitModule接口", new Object[]{"isPlayback=" + i2 + "  errorCode=" + i + "  errorMsg=" + str});
                LiveViewModel.this.mEnterLiveData.postError(i, str);
            }
        }) {
            public void onSuccess(HiResponse<InitModuleEntity> hiResponse) {
                LiveViewModel.this.mInitModuleLiveData.postSuccess((InitModuleEntity) hiResponse.getData());
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("isPlayback");
                sb.append(i2);
                sb.append(JsonUtil.toJson(hiResponse.getData() == null ? "InitModule数据是空" : hiResponse.getData()));
                objArr[0] = sb.toString();
                XesLog.dt("InitModule接口", objArr);
            }
        };
        if (!(requestInitModule instanceof Call)) {
            requestInitModule.enqueue(r5);
        } else {
            Retrofit2Instrumentation.enqueue(requestInitModule, r5);
        }
    }

    public void requestClassroomData(final KeyEntity keyEntity) {
        Call requestClassroomData = ((LiveBackCoreApi) Api.create(ImConfig.INSTANCE.getOverseaApi(), LiveBackCoreApi.class)).requestClassroomData(keyEntity);
        AnonymousClass8 r1 = new OmyCallback<HiResponse<ClassroomDataEntity>>(new IError() {
            public void onFail(int i, String str) {
                XesLog.dt("requestClassroomData", new Object[]{"keys=" + JsonUtil.toJson(keyEntity) + "  status=" + i + "  errorMsg=" + str});
                LiveViewModel.this.mEnterLiveData.postFailure(i, str);
            }

            public void onError(int i, String str) {
                XesLog.dt("requestClassroomData", new Object[]{"keys=" + JsonUtil.toJson(keyEntity) + "  errorCode=" + i + "  errorMsg=" + str});
                LiveViewModel.this.mEnterLiveData.postError(i, str);
            }
        }) {
            public void onSuccess(HiResponse<ClassroomDataEntity> hiResponse) {
                XesLog.dt("requestClassroomData", new Object[]{"keys=" + JsonUtil.toJson(keyEntity) + "  ClassroomData=" + JsonUtil.toJson(hiResponse)});
                LiveViewModel.this.mRoomDataLiveData.postSuccess((ClassroomDataEntity) hiResponse.getData());
            }
        };
        if (!(requestClassroomData instanceof Call)) {
            requestClassroomData.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue(requestClassroomData, r1);
        }
    }

    public void requestMetaData(String str, String str2, int i, int i2, int i3) {
        File file = new File(AppCacheUtil.getClassRoomOfflineMateInfoPath(str2), "mateinfo.txt");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (file.exists()) {
            List<String> readFile2List = FileIOUtils.readFile2List(file);
            try {
                MetaDataEntity metaDataEntity = new MetaDataEntity();
                ArrayList arrayList = new ArrayList();
                for (String str3 : readFile2List) {
                    if (str3 != null) {
                        if (str3.trim().length() != 0) {
                            MetaDataEvent metaDataEvent = (MetaDataEvent) GsonUtil.getInstance().fromJson(str3.trim(), MetaDataEvent.class);
                            if (metaDataEvent != null) {
                                arrayList.add(metaDataEvent);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    metaDataEntity.event = arrayList;
                    XesLog.dt("回放-课中", new Object[]{"本地mateInfo解析完成，使用离线模式，共计" + arrayList.size() + "条，耗时 " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms"});
                    this.mMetaData.postSuccess(metaDataEntity);
                    return;
                }
                XesLog.dt("回放-课中", new Object[]{"本地mateInfo解析完成，但没有数据，使用在线模式，耗时 " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms"});
            } catch (Exception e) {
                XesLog.dt("回放-课中", new Object[]{"本地mateInfo解析异常，使用在线模式"});
                e.printStackTrace();
            }
        }
        XesLog.dt("回放-课中", new Object[]{"请求mateInfo接口"});
        String str4 = str2;
        int i4 = i3;
        String str5 = str;
        Call requestMetaData = ((LiveBackCoreApi) Api.create(LiveBackCoreApi.class)).requestMetaData(str, new MetaDataRequest(i4, ParseUtils.tryParseInt(str2, 0), i, i2));
        AnonymousClass10 r2 = new OmyCallback<HiResponse<MetaDataEntity>>(new IError() {
            public void onFail(int i, String str) {
                LiveViewModel.this.mMetaData.postFailure(i, str);
            }

            public void onError(int i, String str) {
                LiveViewModel.this.mMetaData.postError(i, str);
            }
        }) {
            public void onSuccess(HiResponse<MetaDataEntity> hiResponse) {
                LiveViewModel.this.mMetaData.postSuccess((MetaDataEntity) hiResponse.getData());
            }
        };
        if (!(requestMetaData instanceof Call)) {
            requestMetaData.enqueue(r2);
        } else {
            Retrofit2Instrumentation.enqueue(requestMetaData, r2);
        }
    }

    public void getEmojiDetail() {
        if (!TextUtils.isEmpty(ImConfig.INSTANCE.getOverseaApi())) {
            Call<HiResponse<EmojiDetailEntity>> emojiDetail = ((LiveCoreApi) Api.create(ImConfig.INSTANCE.getOverseaApi(), LiveCoreApi.class)).getEmojiDetail();
            AnonymousClass12 r1 = new OmyCallback<HiResponse<EmojiDetailEntity>>(new IError() {
                public void onFail(int i, String str) {
                    LiveViewModel.this.mEmojiDetailData.postFailure(i, str);
                }

                public void onError(int i, String str) {
                    LiveViewModel.this.mEmojiDetailData.postError(i, str);
                }
            }) {
                public void onSuccess(HiResponse<EmojiDetailEntity> hiResponse) {
                    LiveViewModel.this.mEmojiDetailData.postSuccess((EmojiDetailEntity) hiResponse.getData());
                }
            };
            if (!(emojiDetail instanceof Call)) {
                emojiDetail.enqueue(r1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) emojiDetail, r1);
            }
        }
    }

    public ArrayList<MetaDataEvent> calculationMetadataTime(MetaDataEntity metaDataEntity) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<MetaDataEvent> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        fenleiEvent(metaDataEntity, arrayList, arrayList2, arrayList3);
        MetaDataEvent findClassStartTime = findClassStartTime(arrayList);
        if (findClassStartTime != null) {
            metaDataEntity.setGotoClassTime(findClassStartTime.getActionTs());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                MetaDataBackAndJoingPointBean metaDataBackAndJoingPointBean = new MetaDataBackAndJoingPointBean();
                metaDataBackAndJoingPointBean.setJoinRoomTime(((MetaDataEvent) arrayList.get(i)).getActionTs());
                metaDataBackAndJoingPointBean.setLeaveRoomTime(((MetaDataEvent) arrayList2.get(i)).getActionTs());
                metaDataBackAndJoingPointBean.setInterval(metaDataBackAndJoingPointBean.getJoinRoomTime() - metaDataBackAndJoingPointBean.getLeaveRoomTime());
                arrayList4.add(metaDataBackAndJoingPointBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            MetaDataEvent metaDataEvent = arrayList3.get(size);
            Iterator it = arrayList4.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((MetaDataBackAndJoingPointBean) it.next()).containInInterval(metaDataEvent.getActionTs() - metaDataEvent.getActionDuration(), metaDataEvent.getActionTs())) {
                        arrayList3.remove(metaDataEvent);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Iterator<MetaDataEvent> it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            MetaDataEvent next = it2.next();
            parseBizDataEvent(next);
            calculationBeginTimeAndRealDuration(next, findClassStartTime, arrayList4);
        }
        return arrayList3;
    }

    private void calculationBeginTimeAndRealDuration(MetaDataEvent metaDataEvent, MetaDataEvent metaDataEvent2, ArrayList<MetaDataBackAndJoingPointBean> arrayList) {
        MetaDataEvent metaDataEvent3 = metaDataEvent;
        long actionTs = metaDataEvent.getActionTs();
        long actionTs2 = actionTs - (metaDataEvent2 != null ? metaDataEvent2.getActionTs() : 0);
        long actionDuration = metaDataEvent.getActionDuration();
        Iterator<MetaDataBackAndJoingPointBean> it = arrayList.iterator();
        long j = actionDuration;
        while (it.hasNext()) {
            MetaDataBackAndJoingPointBean next = it.next();
            if (next.shouldSubInterval(actionTs)) {
                actionTs2 -= next.getInterval();
            }
            long j2 = actionTs2;
            if (j >= 0) {
                j = next.subDuration(actionTs - metaDataEvent.getActionDuration(), actionTs, j);
            }
            actionTs2 = j2;
        }
        metaDataEvent3.setActionDuration(j);
        metaDataEvent3.setEndTime(actionTs2);
        metaDataEvent3.setBeginTime(actionTs2 - j);
    }

    private void parseBizDataEvent(MetaDataEvent metaDataEvent) {
        try {
            JSONObject jSONObject = new JSONObject(metaDataEvent.getProperties());
            Iterator<String> keys = jSONObject.keys();
            if (keys.hasNext()) {
                String next = keys.next();
                metaDataEvent.setIrcType(next);
                metaDataEvent.setActionDuration(jSONObject.optJSONObject(next).optLong("actionDuration"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fenleiEvent(MetaDataEntity metaDataEntity, ArrayList<MetaDataEvent> arrayList, ArrayList<MetaDataEvent> arrayList2, ArrayList<MetaDataEvent> arrayList3) {
        if (metaDataEntity != null && metaDataEntity.getEvent() != null) {
            List<MetaDataEvent> event = metaDataEntity.getEvent();
            Collections.sort(event);
            for (MetaDataEvent metaDataEvent : event) {
                if (6 == metaDataEvent.getCategory()) {
                    arrayList.add(metaDataEvent);
                }
                if (7 == metaDataEvent.getCategory()) {
                    arrayList2.add(metaDataEvent);
                }
            }
            for (MetaDataEvent metaDataEvent2 : event) {
                if (5 == metaDataEvent2.getCategory()) {
                    arrayList3.add(metaDataEvent2);
                }
            }
        }
    }

    private MetaDataEvent findClassStartTime(ArrayList<MetaDataEvent> arrayList) {
        MetaDataEvent metaDataEvent = null;
        if (arrayList != null) {
            Iterator<MetaDataEvent> it = arrayList.iterator();
            long j = 2147483647L;
            while (it.hasNext()) {
                MetaDataEvent next = it.next();
                long actionTs = next.getActionTs();
                if (actionTs < j) {
                    metaDataEvent = next;
                    j = actionTs;
                }
            }
        }
        if (metaDataEvent != null) {
            arrayList.remove(metaDataEvent);
        }
        return metaDataEvent;
    }

    public void onResume() {
        LiveViewModel.super.onResume();
        if (this.mEnterIsPlayback != 1) {
            ImCousesWare.INSTANCE.addCourseWareEventListener(new ImCousesWare.CourseWareCallBack() {
                public void onCourseWareError(int i, String str, int i2) {
                    if (LiveViewModel.this.mEnterPlanId != null && LiveViewModel.this.mEnterPlanId.equals(String.valueOf(i2))) {
                        LiveViewModel.this.mEnterLiveData.postFailure(i, str);
                        ToastUtils.showShort(AppUtil.getApplication().getString(R.string.net_fail));
                    }
                }

                public void onCourseWareFailed(int i, String str, int i2) {
                    if (LiveViewModel.this.mEnterPlanId != null && LiveViewModel.this.mEnterPlanId.equals(String.valueOf(i2))) {
                        LiveViewModel.this.mEnterLiveData.postFailure(i, str);
                        ToastUtils.showShort(AppUtil.getApplication().getString(R.string.net_fail));
                    }
                }

                public void onCourseWareSuccess(CouseWareInfo.CourseInfoList.CourseInfoContent courseInfoContent, int i) {
                    if (LiveViewModel.this.mEnterPlanId != null && LiveViewModel.this.mEnterPlanId.equals(String.valueOf(i))) {
                        LiveViewModel.this.mEnterLiveData.postSuccess(LiveViewModel.this.mEnterEntity);
                    }
                }
            });
        }
    }

    public void reportDeviceInfo(ReportDeviceBody reportDeviceBody) {
        String overseaApi = ImConfig.INSTANCE.getOverseaApi();
        if (!TextUtils.isEmpty(overseaApi)) {
            Call<HiResponse<Object>> reportDeviceInfo = ((LiveCoreApi) Api.create(overseaApi, LiveCoreApi.class)).reportDeviceInfo(reportDeviceBody);
            AnonymousClass15 r0 = new OmyCallback<HiResponse<Object>>(new IError() {
                public void onError(int i, String str) {
                }

                public void onFail(int i, String str) {
                }
            }) {
                public void onSuccess(HiResponse<Object> hiResponse) {
                }
            };
            if (!(reportDeviceInfo instanceof Call)) {
                reportDeviceInfo.enqueue(r0);
            } else {
                Retrofit2Instrumentation.enqueue((Call) reportDeviceInfo, r0);
            }
        }
    }
}
