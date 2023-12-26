package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcConnectSuccess;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.abilitypack.photowall.PhotoWallViewModel;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.exam.api.ExamApi;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.homework.api.HomeworkApi;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage;
import com.tal.app.thinkacademy.live.business.homework.entity.body.PlanIdBody;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveViewPad;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveViewPhone;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import kotlin.Pair;
import retrofit2.Call;

public class BigClassTitleBarBarDelegate extends BaseClassRoomTitleBarDelegate {
    private static final String EXAM_INFO = "/api/hub/classroom/exam/examInfo";
    private static final String KEY_HOMEWORK_BOX_CHECK = "homework_box_check";
    private static final String PHOTO_BOX_URL = "/classroom-hub/wall/student/photoBox";
    private static final String READ_NEW_MESSAGE_URL = "/classroom-hub/wall/student/readNewMessage";
    private BaseDialog mGradingDialog;
    private PhotoWallViewModel mPhotoWallViewModel = null;
    /* access modifiers changed from: private */
    public long mUid;
    private ChatBoxViewModel mViewModel;
    /* access modifiers changed from: private */
    public MediaControlLiveViewPad mediaViewPad;
    /* access modifiers changed from: private */
    public MediaControlLiveViewPhone mediaViewPhone;
    public Observer<PluginEventData> observerGrouoVideoCallEnd = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (!Long.toString(BigClassTitleBarBarDelegate.this.mUid).equals(pluginEventData.getData())) {
                return;
            }
            if (BigClassTitleBarBarDelegate.this.isPad) {
                if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                    BigClassTitleBarBarDelegate.this.mediaViewPad.setGrouoVideoCall(false);
                }
            } else if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.setGrouoVideoCall(false);
            }
        }
    };
    public Observer<PluginEventData> observerGrouoVideoCallStart = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (!Long.toString(BigClassTitleBarBarDelegate.this.mUid).equals(pluginEventData.getData())) {
                return;
            }
            if (BigClassTitleBarBarDelegate.this.isPad) {
                if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                    BigClassTitleBarBarDelegate.this.mediaViewPad.setGrouoVideoCall(true);
                }
            } else if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.setGrouoVideoCall(true);
            }
        }
    };
    public Observer<PluginEventData> observerGroupVideoCall = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("videoCallStart".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(false, EnableState.TEACHER_LINK);
            } else if ("videoCallEnd".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(true, EnableState.TEACHER_LINK);
            }
        }
    };
    public Observer<PluginEventData> observerHasStudentVideo = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPad.setStudentWindowButton(true);
            }
            if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.setStudentWindowButton(true);
            }
        }
    };
    public Observer<PluginEventData> observerHomework = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPad.showHomeworkButton();
                BigClassTitleBarBarDelegate.this.requestNewMessage();
            }
            if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.showHomeworkButton();
                BigClassTitleBarBarDelegate.this.requestNewMessage();
            }
        }
    };
    public Observer<PluginEventData> observerInputMsgEnable = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.setInputMsgEnable("1".equals(pluginEventData.getData()));
            }
        }
    };
    public Observer<PluginEventData> observerPrivateMsgState = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                BigClassTitleBarBarDelegate.this.mediaViewPhone.setPrivateMsgState(EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData()));
            }
        }
    };
    public Observer<PluginEventData> observerSwitchEnable = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
        }
    };
    public Observer<PluginEventData> observerTutorVideoCall = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("videoCallTutorOn".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(false, EnableState.TUTOR_LINK);
            } else if ("videoCallTutorOff".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(true, EnableState.TUTOR_LINK);
            }
        }
    };
    public Observer<PluginEventData> observerVideoCall = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("videoCallStart".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(false, EnableState.TEACHER_LINK);
            } else if ("videoCallEnd".equals(pluginEventData.getData())) {
                BigClassTitleBarBarDelegate.this.setSwitchEnable(true, EnableState.TEACHER_LINK);
            }
        }
    };
    protected boolean raiseHand = false;
    private EnableState state = EnableState.ANIMATION;

    public void init(Context context, MediaControlLiveDriver mediaControlLiveDriver, DataStorage dataStorage, boolean z) {
        super.init(context, mediaControlLiveDriver, dataStorage, z);
        if (!z) {
            this.mViewModel = AbilityPack.get().getViewModel(ChatBoxViewModel.class);
        }
        this.mPhotoWallViewModel = AbilityPack.get().getViewModel(PhotoWallViewModel.class);
        registerDataBus();
        registerEvent();
        requestExamReport(true);
        EnterConfigProxy enterConfig = this.mDataStorage.getEnterConfig();
        UserInfoProxy userInfo = this.mDataStorage.getUserInfo();
        this.raiseHand = enterConfig.isRaiseHand();
        this.mUid = Long.parseLong(userInfo.getId());
        boolean z2 = this.raiseHand;
        if (!z2) {
            return;
        }
        if (z) {
            MediaControlLiveViewPad mediaControlLiveViewPad = this.mediaViewPad;
            if (mediaControlLiveViewPad != null) {
                mediaControlLiveViewPad.setRaiseHand(z2);
                return;
            }
            return;
        }
        MediaControlLiveViewPhone mediaControlLiveViewPhone = this.mediaViewPhone;
        if (mediaControlLiveViewPhone != null) {
            mediaControlLiveViewPhone.setRaiseHand(z2);
        }
    }

    public BaseMediaControlView getMediaView() {
        if (this.isPad) {
            if (this.mediaViewPad == null) {
                MediaControlLiveViewPad mediaControlLiveViewPad = new MediaControlLiveViewPad(this.mContext, this.mDataStorage);
                this.mediaViewPad = mediaControlLiveViewPad;
                mediaControlLiveViewPad.setDriver(this.mDriver);
                this.mediaViewPad.setRaiseHand(this.raiseHand);
            }
            return this.mediaViewPad;
        }
        if (this.mediaViewPhone == null) {
            MediaControlLiveViewPhone mediaControlLiveViewPhone = new MediaControlLiveViewPhone(this.mContext, this.mDataStorage);
            this.mediaViewPhone = mediaControlLiveViewPhone;
            mediaControlLiveViewPhone.setDriver(this.mDriver);
            this.mediaViewPhone.setRaiseHand(this.raiseHand);
        }
        return this.mediaViewPhone;
    }

    public void onMessage(String str, String str2) {
        if (!TextUtils.equals("homework_box_check", str) && TextUtils.equals(str, "auto_feedback")) {
            this.teacherFeedbackHelper.receiveIrcMessage(str2);
        }
    }

    public Pair<Boolean, Long> isFrequently() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            return chatBoxViewModel.isFrequently();
        }
        return null;
    }

    public void showGradingDialog(HomeworkEntity homeworkEntity) {
        boolean isWallCanCorrect = this.mDataStorage.getEnterConfig().isWallCanCorrect();
        if (this.isPad) {
            MediaControlLiveViewPad mediaControlLiveViewPad = this.mediaViewPad;
            if (mediaControlLiveViewPad != null) {
                mediaControlLiveViewPad.closeHomeworkWindow();
                this.mediaViewPad.showHomeworkDetail(homeworkEntity, isWallCanCorrect, true);
                return;
            }
            return;
        }
        MediaControlLiveViewPhone mediaControlLiveViewPhone = this.mediaViewPhone;
        if (mediaControlLiveViewPhone != null) {
            mediaControlLiveViewPhone.closeHomeworkWindow();
            this.mediaViewPhone.showHomeworkDetail(homeworkEntity, isWallCanCorrect, true);
        }
    }

    private void registerDataBus() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe(this, new BigClassTitleBarBarDelegate$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$registerDataBus$0$BigClassTitleBarBarDelegate(Object obj) {
        if (obj == null) {
            return;
        }
        if ("end".equals((String) obj)) {
            setSwitchEnable(true, EnableState.CAMERA);
        } else {
            setSwitchEnable(false, EnableState.CAMERA);
        }
    }

    private void registerEvent() {
        PluginEventBus.register(this, DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
        PluginEventBus.register(this, DataBusKey.STUDENTVIDEO_KEY, this.observerHasStudentVideo);
        PluginEventBus.register(this, DataBusKey.SWITCHENABLE_KEY, this.observerSwitchEnable);
        PluginEventBus.register(this, DataBusKey.LIVE_MSG_UNABLE, this.observerInputMsgEnable);
        PluginEventBus.register(this, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
        PluginEventBus.register(this, DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STATUS, this.observerGroupVideoCall);
        PluginEventBus.register(this, DataBusKey.VIDEO_CALL_F_STATUS, this.observerTutorVideoCall);
        PluginEventBus.register(this, DataBusKey.LIVE_PRIVATE_MSG_STATE, this.observerPrivateMsgState);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGrouoVideoCallStart);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        XesDataBus.with(DataBusKey.BASIC_REQUEST_SUCCESS).observe(this, new BigClassTitleBarBarDelegate$$ExternalSyntheticLambda1(this));
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.getMListenerBody().observerSticky(this, false, new Observer<ChatBoxListenerBody>() {
                public void onChanged(ChatBoxListenerBody chatBoxListenerBody) {
                    if ((chatBoxListenerBody instanceof IrcConnectSuccess) && BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                        BigClassTitleBarBarDelegate.this.mediaViewPhone.ircConnectSuccess();
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$registerEvent$1$BigClassTitleBarBarDelegate(Object obj) {
        if (obj != null) {
            this.raiseHand = ((Boolean) obj).booleanValue();
            if (this.isPad) {
                MediaControlLiveViewPad mediaControlLiveViewPad = this.mediaViewPad;
                if (mediaControlLiveViewPad != null) {
                    mediaControlLiveViewPad.setRaiseHand(this.raiseHand);
                    return;
                }
                return;
            }
            MediaControlLiveViewPhone mediaControlLiveViewPhone = this.mediaViewPhone;
            if (mediaControlLiveViewPhone != null) {
                mediaControlLiveViewPhone.setRaiseHand(this.raiseHand);
            }
        }
    }

    public void requestExamReport(final boolean z) {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        boolean z2 = this.isPad;
        Call<HiResponse<ExamInfo>> examInfo = ((ExamApi) Api.create(ExamApi.class)).getExamInfo(ImConfig.INSTANCE.getOverseaApi() + EXAM_INFO, new ExamInfoBody(tryParseInt));
        AnonymousClass13 r1 = new OmyCallback<HiResponse<ExamInfo>>(new IError() {
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
                        BigClassTitleBarBarDelegate.this.showNoExamReport();
                    } else {
                        BigClassTitleBarBarDelegate.this.showExamReportDialog(studentReportUrl);
                    }
                } else if (data.getShowReportEnter() == 1) {
                    if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                        BigClassTitleBarBarDelegate.this.mediaViewPad.showExamReportButton();
                    }
                    if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                        BigClassTitleBarBarDelegate.this.mediaViewPhone.showExamReportButton();
                    }
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
    public void setSwitchEnable(boolean z, EnableState enableState) {
        this.state = enableState;
        MediaControlLiveViewPad mediaControlLiveViewPad = this.mediaViewPad;
        if (mediaControlLiveViewPad != null) {
            mediaControlLiveViewPad.setStudentSwitchEnable(z, enableState);
        }
        MediaControlLiveViewPhone mediaControlLiveViewPhone = this.mediaViewPhone;
        if (mediaControlLiveViewPhone != null) {
            mediaControlLiveViewPhone.setStudentSwitchEnable(z, enableState);
        }
    }

    /* access modifiers changed from: private */
    public void requestNewMessage() {
        int tryParseInt = ParseUtils.tryParseInt(this.mDataStorage.getPlanInfo().getId(), 0);
        Call<HiResponse<PhotoBoxMessage>> newMessage = ((HomeworkApi) Api.create(HomeworkApi.class)).getNewMessage(ImConfig.INSTANCE.getOverseaApi() + READ_NEW_MESSAGE_URL, new PlanIdBody(tryParseInt));
        AnonymousClass15 r1 = new OmyCallback<HiResponse<PhotoBoxMessage>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<PhotoBoxMessage> hiResponse) {
                if (!hiResponse.getData().isHaveNewMessage()) {
                    return;
                }
                if (BigClassTitleBarBarDelegate.this.isPad) {
                    if (BigClassTitleBarBarDelegate.this.mediaViewPad != null) {
                        BigClassTitleBarBarDelegate.this.mediaViewPad.showHomeworkDot();
                    }
                } else if (BigClassTitleBarBarDelegate.this.mediaViewPhone != null) {
                    BigClassTitleBarBarDelegate.this.mediaViewPhone.showHomeworkDot();
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
        PluginEventBus.unregister(DataBusKey.SHOW_HOMEWORK_KEY, this.observerHomework);
        PluginEventBus.unregister(DataBusKey.STUDENTVIDEO_KEY, this.observerHasStudentVideo);
        PluginEventBus.unregister(DataBusKey.SWITCHENABLE_KEY, this.observerSwitchEnable);
        PluginEventBus.unregister(DataBusKey.LIVE_MSG_UNABLE, this.observerInputMsgEnable);
        PluginEventBus.unregister(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.mDriver.observerScreenShot);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STATUS, this.observerGroupVideoCall);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_F_STATUS, this.observerTutorVideoCall);
        PluginEventBus.unregister(DataBusKey.LIVE_PRIVATE_MSG_STATE, this.observerPrivateMsgState);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGrouoVideoCallStart);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        MediaControlLiveViewPad mediaControlLiveViewPad = this.mediaViewPad;
        if (mediaControlLiveViewPad != null) {
            mediaControlLiveViewPad.onDestroy();
            this.mediaViewPad = null;
        }
        MediaControlLiveViewPhone mediaControlLiveViewPhone = this.mediaViewPhone;
        if (mediaControlLiveViewPhone != null) {
            mediaControlLiveViewPhone.onDestroy();
            this.mediaViewPhone = null;
        }
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
