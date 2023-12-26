package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.dialog.BrowserDialog;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.abilitypack.photowall.PhotoWallViewModel;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.exam.api.ExamApi;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody;
import com.tal.app.thinkacademy.live.business.homework.api.HomeworkApi;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import com.tal.app.thinkacademy.live.business.homework.entity.body.PlanIdBody;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlSmallLiveViewPhone;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import retrofit2.Call;

public class PhoneSmallClassBarDelegate extends BaseClassRoomTitleBarDelegate {
    private static final String EXAM_INFO = "/api/hub/classroom/exam/examInfo";
    private static final String KEY_HOMEWORK_BOX_CHECK = "homework_box_check";
    private static final String PHOTO_BOX_URL = "/classroom-hub/wall/student/photoBox";
    private static final String READ_NEW_MESSAGE_URL = "/classroom-hub/wall/student/readNewMessage";
    private BrowserDialog mExamReportDialog;
    private BaseDialog mGradingDialog;
    private BaseDialog mNoExamReportDialog;
    private PhotoWallViewModel mPhotoWallViewModel = null;
    /* access modifiers changed from: private */
    public MediaControlSmallLiveViewPhone mediaViewSmall;
    public Observer<PluginEventData> observerHomework = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (PhoneSmallClassBarDelegate.this.mediaViewSmall != null) {
                PhoneSmallClassBarDelegate.this.mediaViewSmall.showHomeworkButton();
                PhoneSmallClassBarDelegate.this.requestNewMessage();
            }
        }
    };

    public void init(Context context, MediaControlLiveDriver mediaControlLiveDriver, DataStorage dataStorage, boolean z) {
        super.init(context, mediaControlLiveDriver, dataStorage, z);
        this.mPhotoWallViewModel = AbilityPack.get().getViewModel(PhotoWallViewModel.class);
        registerEvent();
        requestExamReport(true);
    }

    public BaseMediaControlView getMediaView() {
        if (this.mediaViewSmall == null) {
            MediaControlSmallLiveViewPhone mediaControlSmallLiveViewPhone = new MediaControlSmallLiveViewPhone(this.mContext, this.mDataStorage);
            this.mediaViewSmall = mediaControlSmallLiveViewPhone;
            mediaControlSmallLiveViewPhone.setDriver(this.mDriver);
        }
        return this.mediaViewSmall;
    }

    public void onMessage(String str, String str2) {
        if (!TextUtils.equals("homework_box_check", str) && TextUtils.equals(str, "auto_feedback")) {
            this.teacherFeedbackHelper.receiveIrcMessage(str2);
        }
    }

    private void registerEvent() {
        PluginEventBus.register(this, DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
        PluginEventBus.register(this, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
    }

    private void unregisterEvent() {
        PluginEventBus.unregister(DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
        PluginEventBus.unregister(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
    }

    public void showGradingDialog(HomeworkEntity homeworkEntity) {
        boolean isWallCanCorrect = this.mDataStorage.getEnterConfig().isWallCanCorrect();
        MediaControlSmallLiveViewPhone mediaControlSmallLiveViewPhone = this.mediaViewSmall;
        if (mediaControlSmallLiveViewPhone != null) {
            mediaControlSmallLiveViewPhone.closeHomeworkWindow();
            this.mediaViewSmall.showHomeworkDetail(homeworkEntity, isWallCanCorrect, true);
        }
    }

    public void requestExamReport(final boolean z) {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        Call<HiResponse<ExamInfo>> examInfo = ((ExamApi) Api.create(ExamApi.class)).getExamInfo(ImConfig.INSTANCE.getOverseaApi() + EXAM_INFO, new ExamInfoBody(tryParseInt));
        AnonymousClass3 r1 = new OmyCallback<HiResponse<ExamInfo>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<ExamInfo> hiResponse) {
                ExamInfo data = hiResponse.getData();
                if (!z) {
                    String studentReportUrl = data.getStudentReportUrl();
                    if (TextUtils.isEmpty(studentReportUrl)) {
                        PhoneSmallClassBarDelegate.this.showNoExamReport();
                    } else {
                        PhoneSmallClassBarDelegate.this.showExamReportDialog(studentReportUrl);
                    }
                } else if (data.getShowReportEnter() == 1 && PhoneSmallClassBarDelegate.this.mediaViewSmall != null) {
                    PhoneSmallClassBarDelegate.this.mediaViewSmall.showExamReportButton();
                }
            }
        };
        if (!(examInfo instanceof Call)) {
            examInfo.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) examInfo, r1);
        }
    }

    /* access modifiers changed from: private */
    public void requestNewMessage() {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        Call<HiResponse<PhotoBoxMessage>> newMessage = ((HomeworkApi) Api.create(HomeworkApi.class)).getNewMessage(ImConfig.INSTANCE.getOverseaApi() + READ_NEW_MESSAGE_URL, new PlanIdBody(tryParseInt));
        AnonymousClass5 r1 = new OmyCallback<HiResponse<PhotoBoxMessage>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<PhotoBoxMessage> hiResponse) {
                if (hiResponse.getData().isHaveNewMessage() && PhoneSmallClassBarDelegate.this.mediaViewSmall != null) {
                    PhoneSmallClassBarDelegate.this.mediaViewSmall.showHomeworkDot();
                }
            }
        };
        if (!(newMessage instanceof Call)) {
            newMessage.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) newMessage, r1);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        MediaControlSmallLiveViewPhone mediaControlSmallLiveViewPhone = this.mediaViewSmall;
        if (mediaControlSmallLiveViewPhone != null) {
            mediaControlSmallLiveViewPhone.onDestroy();
            this.mediaViewSmall = null;
        }
        unregisterEvent();
    }

    private void updateUserCoins(int i) {
        try {
            int goldNum = this.mDriver.getLiveRoomProvider().getDataStorage().getUserInfo().getGoldNum() + i;
            this.mDriver.getLiveRoomProvider().getDataStorage().getUserInfo().setGoldNum(goldNum);
            PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(this.mDriver.getClass(), DataBusKey.USERCOINS_KEY, String.valueOf(goldNum), new CoinEventData(GoldSource.PHOTOS_ON_THE_WALL_GOLD, i, true, true)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
