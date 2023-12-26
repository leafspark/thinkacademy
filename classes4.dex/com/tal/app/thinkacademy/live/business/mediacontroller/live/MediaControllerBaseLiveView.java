package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.TextDelegate;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.ViewUtils;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.photowall.PhotoWallViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.homework.adapter.HomeworkAdapter;
import com.tal.app.thinkacademy.live.business.homework.entity.EmptySource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEmpty;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedbackView;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.ui.TakePhotoActivity;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import com.tal.app.thinkacademy.live.core.interfaces.IBaseLiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MediaControllerBaseLiveView extends BaseMediaControlView implements IFeedbackAction {
    protected int classId;
    private Runnable correctWrongRunnable = new Runnable() {
        public void run() {
            if (MediaControllerBaseLiveView.this.mHomeworkDetailDialog != null) {
                ImageView imageView = (ImageView) MediaControllerBaseLiveView.this.mHomeworkDetailDialog.findViewById(R.id.correctWrongIV);
                TextView textView = (TextView) MediaControllerBaseLiveView.this.mHomeworkDetailDialog.findViewById(R.id.correctWrongTV);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        }
    };
    protected int currIn;
    protected MediaControlLiveDriver driver;
    protected FeedbackView feedbackView;
    protected boolean isCompatStudent = true;
    protected boolean isEnableSwitch = true;
    public boolean isFeedback;
    protected boolean isShowStudentWindow;
    public ImageView ivExamReport;
    protected ImageView ivFeedback;
    protected ImageView ivMore;
    protected RelativeLayout layoutHomework;
    protected boolean mCanCorrect;
    protected DataStorage mDataStorage;
    protected EasyPopup mFeedbackPopup;
    protected HomeworkAdapter mHomeworkAdapter;
    protected BaseDialog mHomeworkDetailDialog;
    private Handler mHomeworkHandler = null;
    protected EasyPopup mHomeworkPopup;
    protected EasyPopup mNoHomeworkPopup;
    private PhotoWallViewModel mPhotoWallViewModel = null;
    protected boolean mShow;
    protected String mTotalTimeStr;
    protected String name;
    protected int planId;
    protected boolean raiseHand;
    protected long startTime;
    protected EnableState state;
    protected EasyPopup studentWindow;
    protected ImageButton switchCompatStudent;
    protected String timeString;
    protected TextView tvHomeworkDot;
    protected TextView tvPlayTime;

    public MediaControllerBaseLiveView(Context context) {
        super(context);
    }

    public MediaControllerBaseLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaControllerBaseLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDriver(MediaControlLiveDriver mediaControlLiveDriver) {
        this.driver = mediaControlLiveDriver;
        super.setDriver(mediaControlLiveDriver);
    }

    public void initViews() {
        super.initViews();
        this.topRoot = findViewById(R.id.rl_media_controller_root_top);
        this.layoutHomework = (RelativeLayout) findViewById(R.id.layout_media_controller_homework);
        this.tvHomeworkDot = (TextView) findViewById(R.id.tv_media_controller_homework_dot);
        this.bottomRoot = findViewById(R.id.cl_media_controller_root_bottom);
        this.tvPlayTime = (TextView) findViewById(R.id.tv_media_controller_time);
        this.ivMore = (ImageView) findViewById(R.id.iv_media_controller_more);
        this.ivFeedback = (ImageView) findViewById(R.id.iv_media_controller_feedback);
        this.ivExamReport = (ImageView) findViewById(R.id.iv_media_controller_exam_report);
        this.ivFeedback.setVisibility(0);
    }

    public void initListener() {
        super.initListener();
        this.ivMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControllerBaseLiveView.class);
                if (!MediaControllerBaseLiveView.this.studentWindow.isShowing()) {
                    MediaControllerBaseLiveView.this.isShowStudentWindow = true;
                    MediaControllerBaseLiveView.this.studentWindow.showAtAnchorView(view, 2, 3, (-SizeUtils.dp2px(147.0f)) + view.getMeasuredWidth(), SizeUtils.dp2px(10.0f));
                    DriverTrack.INSTANCE.classroomToolbarClick("小组视频");
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.layoutHomework.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControllerBaseLiveView.class);
                MediaControllerBaseLiveView.this.clearHomeworkDot();
                PhotoBoxViewModel viewModel = AbilityPack.get().getViewModel(PhotoBoxViewModel.class);
                if (viewModel != null) {
                    viewModel.setMHomeworkEmpty(new HomeworkEmpty(MediaControllerBaseLiveView.this.topRoot, -(((MediaControllerBaseLiveView.this.topRoot.getMeasuredWidth() - MediaControllerBaseLiveView.this.layoutHomework.getRight()) + (MediaControllerBaseLiveView.this.layoutHomework.getMeasuredWidth() / 2)) - (SizeUtils.dp2px(133.0f) / 2)), SizeUtils.dp2px(6.0f), 8388613, EmptySource.TITLE));
                    viewModel.openBoxList();
                }
                LeanplumUtil.commonTrack(LeanplumUtil.click_exercisebox, new HashMap());
                DriverTrack.INSTANCE.classroomToolbarClick("作业盒子");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.ivExamReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControllerBaseLiveView.class);
                MediaControllerBaseLiveView.this.driver.requestExamReport(false);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.ivFeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControllerBaseLiveView.class);
                MediaControllerBaseLiveView.this.showFeedbackPop();
                MediaControllerBaseLiveView.this.driver.track_click_feedback(LeanplumUtil.click_feedback);
                DriverTrack.INSTANCE.classroomToolbarClick("反馈");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        PhotoBoxViewModel viewModel = AbilityPack.get().getViewModel(PhotoBoxViewModel.class);
        if (viewModel != null && this.driver != null) {
            viewModel.getMListenerData().observeListener(this.driver, false, "标题栏", new MediaControllerBaseLiveView$$ExternalSyntheticLambda3(this));
        }
    }

    public /* synthetic */ Unit lambda$initListener$0$MediaControllerBaseLiveView(PhotoBoxListenerBody photoBoxListenerBody) {
        if (!(photoBoxListenerBody instanceof PhotoBoxListenerBody.BoxNewMessage)) {
            return null;
        }
        showHomeworkDot();
        return null;
    }

    public void setStudentSwitchEnable(boolean z, EnableState enableState) {
        this.isEnableSwitch = z;
        this.state = enableState;
    }

    public void setScreenShotFilePath(String str) {
        super.setScreenShotFilePath(str);
        if (this.isFeedback) {
            this.feedbackView.setScreenshot(str);
            this.isFeedback = false;
        }
    }

    public void setStudentWindowButton(boolean z) {
        if (z && this.studentWindow == null) {
            this.ivMore.setVisibility(0);
            buildStudentWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void buildStudentWindow() {
        if (this.studentWindow == null) {
            EasyPopup easyPopup = new EasyPopup(getContext());
            this.studentWindow = easyPopup;
            easyPopup.setContentView(R.layout.live_business_popupwindow_studentvideo_controller).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setOnDismissListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda8(this)).createPopup();
            ImageButton imageButton = (ImageButton) this.studentWindow.getContentView().findViewById(R.id.sw_live_business_studentvideo_controller);
            this.switchCompatStudent = imageButton;
            imageButton.setSelected(true);
            this.switchCompatStudent.setOnClickListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda4(this));
        }
    }

    public /* synthetic */ void lambda$buildStudentWindow$1$MediaControllerBaseLiveView() {
        this.studentWindow.dismiss();
        this.isShowStudentWindow = false;
        hide();
    }

    public /* synthetic */ void lambda$buildStudentWindow$2$MediaControllerBaseLiveView(View view) {
        if (!this.isEnableSwitch) {
            if (this.state == EnableState.TEACHER_LINK || this.state == EnableState.TUTOR_LINK || this.state == EnableState.RANGE_LINK) {
                ToastUtils.showShort((CharSequence) "Please try again after the Video Link.");
            } else if (this.state == EnableState.CAMERA) {
                ToastUtils.showShort((CharSequence) "Please try again after the Photopost.");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        boolean z = !this.isCompatStudent;
        this.isCompatStudent = z;
        this.switchCompatStudent.setSelected(z);
        String str = "1";
        this.driver.updateStudentVideo(this.isCompatStudent ? str : EnterRoomMuteData.STATUS_UN_MUTE);
        PluginEventBus.onEvent(DataBusKey.USER_MUTE_BIG_CLASS_GROUP_VIDEO_KEY, new PluginEventData(MediaControllerBaseLiveView.class, DataBusKey.USER_MUTE_BIG_CLASS_GROUP_VIDEO_KEY, this.isCompatStudent ? str : EnterRoomMuteData.STATUS_UN_MUTE));
        DriverTrack driverTrack = DriverTrack.INSTANCE;
        if (!this.isCompatStudent) {
            str = EnterRoomMuteData.STATUS_UN_MUTE;
        }
        driverTrack.classroomToolbarVideo(str);
        HWEventTracking.get().ostaGroupVideoChange(this.isCompatStudent ? "on" : "off");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void buildHomeworkWindow(List<HomeworkEntity> list, boolean z, int i) {
        Activity activity = (Activity) this.mContext;
        if (list == null || list.isEmpty()) {
            if (this.mNoHomeworkPopup == null) {
                EasyPopup easyPopup = new EasyPopup(getContext());
                this.mNoHomeworkPopup = easyPopup;
                easyPopup.setContentView(R.layout.live_business_popupwindow_no_homework).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setWidth(SizeUtils.dp2px(133.0f)).setHeight(SizeUtils.dp2px(48.0f)).setOnDismissListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda6(this)).createPopup();
            }
            if (!this.mNoHomeworkPopup.isShowing() && !activity.isFinishing()) {
                this.mNoHomeworkPopup.showAsDropDown(this.topRoot, -(((this.topRoot.getMeasuredWidth() - this.layoutHomework.getRight()) + (this.layoutHomework.getMeasuredWidth() / 2)) - (SizeUtils.dp2px(133.0f) / 2)), -SizeUtils.dp2px(12.0f), 8388613);
                return;
            }
            return;
        }
        if (this.mHomeworkPopup == null) {
            this.mHomeworkPopup = new EasyPopup(getContext());
            LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
            this.mHomeworkPopup.setContentView(i).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setWidth(screenLp.width / 2).setHeight(screenLp.height).setAnimationStyle(R.style.homework_popup_anim_style).setOnDismissListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda7(this)).createPopup();
            this.mHomeworkPopup.getContentView().findViewById(R.id.view_live_business_homework_window).setOnClickListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda0(this));
        }
        this.mCanCorrect = z;
        HomeworkAdapter homeworkAdapter = this.mHomeworkAdapter;
        if (homeworkAdapter == null) {
            HomeworkAdapter homeworkAdapter2 = new HomeworkAdapter(list, 0);
            this.mHomeworkAdapter = homeworkAdapter2;
            homeworkAdapter2.setCanCorrect(z);
            RecyclerView findViewById = this.mHomeworkPopup.getContentView().findViewById(R.id.rv_live_business_homework_window);
            findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
            dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.live_business_homework_divider));
            findViewById.addItemDecoration(dividerItemDecoration);
            findViewById.setAdapter(this.mHomeworkAdapter);
            this.mHomeworkAdapter.addChildClickViewIds(new int[]{R.id.iv_live_business_homework_resubmit});
            this.mHomeworkAdapter.setOnItemChildClickListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda10(this));
            this.mHomeworkAdapter.setOnItemClickListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda11(this));
        } else {
            homeworkAdapter.setList(list);
            this.mHomeworkPopup.getContentView().findViewById(R.id.rv_live_business_homework_window).scrollToPosition(0);
        }
        if (!this.mHomeworkPopup.isShowing() && !activity.isFinishing()) {
            this.mHandler.removeMessages(1);
            this.mHomeworkPopup.showAtLocation(activity.findViewById(16908290), 8388613, 0, 0);
        }
    }

    public /* synthetic */ void lambda$buildHomeworkWindow$3$MediaControllerBaseLiveView() {
        show(this.mTimeout);
    }

    public /* synthetic */ void lambda$buildHomeworkWindow$4$MediaControllerBaseLiveView() {
        show(this.mTimeout);
    }

    public /* synthetic */ void lambda$buildHomeworkWindow$5$MediaControllerBaseLiveView(View view) {
        this.mHomeworkPopup.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$buildHomeworkWindow$6$MediaControllerBaseLiveView(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        HomeworkEntity homeworkEntity = (HomeworkEntity) baseQuickAdapter.getItem(i);
        if ("graffiti".equals(homeworkEntity.getTagType())) {
            resubmitDraw(homeworkEntity);
        } else {
            resubmitPhoto(homeworkEntity);
        }
        this.mHomeworkPopup.dismiss();
    }

    public /* synthetic */ void lambda$buildHomeworkWindow$7$MediaControllerBaseLiveView(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        showHomeworkDetail((HomeworkEntity) baseQuickAdapter.getItem(i), this.mCanCorrect, false);
        this.mHomeworkPopup.dismiss();
        LeanplumUtil.commonTrack(LeanplumUtil.click_exercise, new HashMap());
    }

    private void resubmitPhoto(HomeworkEntity homeworkEntity) {
        String string = ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (!TextUtils.equals(string, homeworkEntity.getInteractId())) {
            ToastUtils.showShort(R.string.interaction_ended);
            return;
        }
        ILiveRoomProvider liveRoomProvider = this.driver.getLiveRoomProvider();
        CourseInfoProxy courseInfo = liveRoomProvider.getDataStorage().getCourseInfo();
        this.mHandler.postDelayed(new MediaControllerBaseLiveView$$ExternalSyntheticLambda1(this, new PhotosMaintainData(Integer.valueOf(courseInfo.getPlanId()), Integer.valueOf(courseInfo.getClassId()), Integer.valueOf(courseInfo.getTutorId()), liveRoomProvider.getDataStorage().getTeacherInfo().getId(), string, 0L, 0L, true)), 500);
    }

    public /* synthetic */ void lambda$resubmitPhoto$8$MediaControllerBaseLiveView(PhotosMaintainData photosMaintainData) {
        TakePhotoActivity.Companion.startActivity(this.mContext, photosMaintainData);
    }

    private void resubmitDraw(HomeworkEntity homeworkEntity) {
        if (!TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR), homeworkEntity.getInteractId())) {
            ToastUtils.showShort(R.string.interaction_ended);
        } else {
            ((IBaseLiveControllerProvider) this.driver.getLiveRoomProvider()).dispatchIrcMessage("graffiti_board", wrapperDrawMessage(homeworkEntity));
        }
    }

    private String wrapperDrawMessage(HomeworkEntity homeworkEntity) {
        String string = ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject2.put("interactId", string);
            jSONObject2.put("pub", true);
            jSONObject2.put("totalTime", -1);
            jSONObject2.put("beginTime", -1);
            jSONObject2.put("imageUrl", ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_BG, "", ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject2.put("planId", this.planId);
            jSONObject2.put("extra", "graffiti");
            jSONObject.put("graffiti_board", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    public void closeHomeworkWindow() {
        EasyPopup easyPopup = this.mHomeworkPopup;
        if (easyPopup != null && easyPopup.isShowing()) {
            this.mHomeworkPopup.dismiss();
        }
    }

    public void showHomeworkDetail(HomeworkEntity homeworkEntity, boolean z, boolean z2) {
        String str;
        int i;
        int i2;
        int i3;
        String str2;
        String str3;
        if (this.mHomeworkDetailDialog == null) {
            this.mHomeworkDetailDialog = new BaseDialog(getContext());
            float f = 1.0f;
            if (PadUtils.isPad(this.mContext)) {
                f = 1.33f;
            }
            View inflate = inflate(this.mContext, R.layout.live_business_dialog_homework, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.iv_live_business_homework_content);
            findViewById.setScaleX(f);
            findViewById.setScaleY(f);
            this.mHomeworkDetailDialog.contentView(inflate).layoutParams(new ViewGroup.LayoutParams(-1, SizeUtils.dp2px(f * 324.0f))).gravity(17).dismissListener(MediaControllerBaseLiveView$$ExternalSyntheticLambda12.INSTANCE).canceledOnTouchOutside(true);
            this.mHomeworkDetailDialog.findViewById(R.id.iv_live_business_homework_close).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, MediaControllerBaseLiveView.class);
                    MediaControllerBaseLiveView.this.mHomeworkDetailDialog.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) this.mHomeworkDetailDialog.findViewById(R.id.layout_live_business_homework_frame);
        ImageView imageView = (ImageView) this.mHomeworkDetailDialog.findViewById(R.id.iv_live_business_homework_title);
        LottieAnimationView findViewById2 = this.mHomeworkDetailDialog.findViewById(R.id.homeworkLottie);
        ImageView imageView2 = (ImageView) this.mHomeworkDetailDialog.findViewById(R.id.correctWrongIV);
        TextView textView = (TextView) this.mHomeworkDetailDialog.findViewById(R.id.correctWrongTV);
        final LottieAnimationView findViewById3 = this.mHomeworkDetailDialog.findViewById(R.id.resubmitLottie);
        int correctStatus = homeworkEntity.getCorrectStatus();
        if (correctStatus == 0 || correctStatus == 3) {
            i2 = R.drawable.shape_live_business_homework_grading;
            i = R.drawable.icon_live_business_homework_title_grading;
            str = homeworkEntity.getPhotoUrl();
            findViewById2.setVisibility(8);
            imageView2.setVisibility(8);
            textView.setVisibility(8);
        } else if (correctStatus == 1) {
            if (this.mPhotoWallViewModel == null) {
                this.mPhotoWallViewModel = AbilityPack.get().getViewModel(PhotoWallViewModel.class);
            }
            i2 = R.drawable.shape_live_business_homework_correct;
            i = R.drawable.icon_live_business_homework_title_correct;
            str = homeworkEntity.getCorrectUrl();
            PhotoWallViewModel photoWallViewModel = this.mPhotoWallViewModel;
            boolean isAddCoinCorrect = photoWallViewModel != null ? photoWallViewModel.isAddCoinCorrect() : false;
            if (!z2 || ((!TopicConfig.INTERACT.equals(homeworkEntity.getTagType()) && !"question".equals(homeworkEntity.getTagType())) || !isAddCoinCorrect)) {
                i3 = 8;
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setImageAssetsFolder("homework/correct/images");
                findViewById2.setAnimation("homework/correct/data.json");
                TextDelegate textDelegate = new TextDelegate(findViewById2);
                if (ShareDataManager.getInstance().getInt("interact_correct_count_" + homeworkEntity.getInteractId(), 0, ShareDataManager.SHAREDATA_USER) > 1) {
                    if (this.mPhotoWallViewModel != null) {
                        str3 = "+" + this.mPhotoWallViewModel.getReviseCoin();
                    } else {
                        str3 = "";
                    }
                    textDelegate.setText("${c_num}", str3);
                } else {
                    if (this.mPhotoWallViewModel != null) {
                        str2 = "+" + this.mPhotoWallViewModel.getCorrectCoin();
                    } else {
                        str2 = "";
                    }
                    textDelegate.setText("${c_num}", str2);
                }
                findViewById2.setTextDelegate(textDelegate);
                findViewById2.setVisibility(0);
                if (this.mHomeworkHandler == null) {
                    this.mHomeworkHandler = new Handler(Looper.getMainLooper());
                }
                Handler handler = this.mHomeworkHandler;
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            SoundPoolUtils.play(MediaControllerBaseLiveView.this.mContext, R.raw.live_business_homework_get_coin, 0);
                        }
                    }, 1000);
                }
                findViewById2.playAnimation();
                i3 = 8;
            }
            imageView2.setVisibility(i3);
            textView.setVisibility(i3);
        } else {
            i2 = R.drawable.shape_live_business_homework_incorrect;
            i = R.drawable.icon_live_business_homework_title_incorrect;
            str = homeworkEntity.getCorrectUrl();
            findViewById2.setVisibility(8);
            if (!z2 || (!TopicConfig.INTERACT.equals(homeworkEntity.getTagType()) && !"question".equals(homeworkEntity.getTagType()))) {
                imageView2.setVisibility(8);
                textView.setVisibility(8);
            } else {
                Handler handler2 = this.mHomeworkHandler;
                if (handler2 != null) {
                    handler2.removeCallbacks(this.correctWrongRunnable);
                }
                imageView2.setVisibility(0);
                textView.setVisibility(0);
                if (this.mHomeworkHandler == null) {
                    this.mHomeworkHandler = new Handler(Looper.getMainLooper());
                }
                Handler handler3 = this.mHomeworkHandler;
                if (handler3 != null) {
                    handler3.postDelayed(this.correctWrongRunnable, 5000);
                }
            }
        }
        String str4 = str;
        ImageView imageView3 = (ImageView) this.mHomeworkDetailDialog.findViewById(R.id.iv_live_business_homework_resubmit);
        if (!TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR), homeworkEntity.getInteractId()) || correctStatus != 2 || !z) {
            imageView3.setVisibility(8);
            findViewById3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
            findViewById3.setImageAssetsFolder("homework/wrong/images");
            findViewById3.setAnimation("homework/wrong/data.json");
            TextDelegate textDelegate2 = new TextDelegate(findViewById3);
            textDelegate2.setText("${c_try}", getResources().getString(R.string.homework_try_again));
            findViewById3.setTextDelegate(textDelegate2);
            findViewById3.setVisibility(4);
            if (this.mHomeworkHandler == null) {
                this.mHomeworkHandler = new Handler(Looper.getMainLooper());
            }
            Handler handler4 = this.mHomeworkHandler;
            if (handler4 != null) {
                handler4.postDelayed(new Runnable() {
                    public void run() {
                        LottieAnimationView lottieAnimationView = findViewById3;
                        if (lottieAnimationView != null) {
                            lottieAnimationView.setVisibility(0);
                            findViewById3.playAnimation();
                        }
                    }
                }, 3000);
            }
        }
        imageView3.setOnClickListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda5(this, homeworkEntity));
        ImageLoaderJ.load(getContext(), str4, (ImageView) this.mHomeworkDetailDialog.findViewById(R.id.iv_live_business_homework_photo), R.drawable.hw_image_loading, R.drawable.hw_image_loading_fail, false);
        linearLayout.setBackgroundResource(i2);
        imageView.setImageResource(i);
        this.mHomeworkDetailDialog.show();
        InteractReportKt.XesLogReport("previewImage", "Photopost", homeworkEntity.getInteractId(), 1);
    }

    public /* synthetic */ void lambda$showHomeworkDetail$10$MediaControllerBaseLiveView(HomeworkEntity homeworkEntity, View view) {
        if ("graffiti".equals(homeworkEntity.getTagType())) {
            resubmitDraw(homeworkEntity);
        } else {
            resubmitPhoto(homeworkEntity);
        }
        this.mHomeworkDetailDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void closeHomeworkDetail() {
        BaseDialog baseDialog = this.mHomeworkDetailDialog;
        if (baseDialog != null && baseDialog.isShowing()) {
            this.mHomeworkDetailDialog.dismiss();
        }
    }

    public void showExamReportButton() {
        this.ivExamReport.setVisibility(0);
    }

    public void showHomeworkButton() {
        this.layoutHomework.setVisibility(0);
    }

    public void showHomeworkDot() {
        this.tvHomeworkDot.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void clearHomeworkDot() {
        this.tvHomeworkDot.setVisibility(8);
    }

    public void showFeedbackPop() {
        if (this.mFeedbackPopup == null) {
            FeedbackView feedbackView2 = new FeedbackView(this.mContext);
            this.feedbackView = feedbackView2;
            feedbackView2.setIAction(this);
            EasyPopup easyPopup = new EasyPopup(getContext());
            this.mFeedbackPopup = easyPopup;
            easyPopup.setContentView((View) this.feedbackView).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setWidth(SizeUtils.dp2px(293.0f)).setHeight(LiveAreaContext.get().getVisibleLp().height).setOnDismissListener(new MediaControllerBaseLiveView$$ExternalSyntheticLambda9(this)).createPopup();
        }
        if (!this.mFeedbackPopup.isShowing()) {
            this.mFeedbackPopup.showAtLocation(((Activity) this.mContext).findViewById(16908290), 8388613, 0, 0);
        }
    }

    public /* synthetic */ void lambda$showFeedbackPop$11$MediaControllerBaseLiveView() {
        show(this.mTimeout);
    }

    public void feedbackScreenshot() {
        this.isFeedback = true;
        this.driver.screenShot(ScreenShotToken.FEEDBACK);
    }

    public void sendFeedbackInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            ViewUtils.runOnUiThread(new MediaControllerBaseLiveView$$ExternalSyntheticLambda2(this, jSONObject));
        }
    }

    public /* synthetic */ void lambda$sendFeedbackInfo$12$MediaControllerBaseLiveView(JSONObject jSONObject) {
        this.driver.sendFeedback(jSONObject);
        try {
            this.mFeedbackPopup.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Toast.makeText(getContext(), this.mContext.getString(R.string.feedback_success_tip), 0).show();
        this.driver.track_click_feedback_send(LeanplumUtil.click_feedback_send);
    }

    public void dismissPopup() {
        EasyPopup easyPopup = this.mFeedbackPopup;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void initTitle(DataStorage dataStorage) {
        this.mDataStorage = dataStorage;
        String name2 = dataStorage.getPlanInfo().getName();
        this.name = name2;
        setTitle(name2);
    }

    /* access modifiers changed from: protected */
    public void initPlayTime(Runnable runnable) {
        String string = getResources().getString(R.string.default_time);
        long serveNowTime = this.mDataStorage.getRoomData().getServeNowTime();
        long endStampTime = this.mDataStorage.getPlanInfo().getEndStampTime();
        this.startTime = this.mDataStorage.getPlanInfo().getStartStampTime();
        this.timeString = getResources().getString(R.string.media_controller_live_time);
        String stringForTime = stringForTime(endStampTime - this.startTime);
        this.mTotalTimeStr = stringForTime;
        this.tvPlayTime.setText(String.format(this.timeString, new Object[]{string, stringForTime}));
        long j = this.startTime - serveNowTime;
        if (j < 0) {
            this.mHandler.postDelayed(runnable, 1000);
        } else {
            this.mHandler.postDelayed(runnable, j * 1000);
        }
    }

    /* access modifiers changed from: protected */
    public String stringForTime(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[]{Long.valueOf(j / 3600), Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)});
    }

    /* access modifiers changed from: protected */
    public void updateShowPlayTime() {
        DataStorage dataStorage;
        if (this.tvPlayTime != null && (dataStorage = this.mDataStorage) != null && dataStorage.getRoomData() != null) {
            long serveNowTime = this.mDataStorage.getRoomData().getServeNowTime() - this.startTime;
            if (serveNowTime > 0) {
                this.tvPlayTime.setText(String.format(this.timeString, new Object[]{stringForTime(serveNowTime), this.mTotalTimeStr}));
            }
        }
    }

    public void setRaiseHand(boolean z) {
        this.raiseHand = z;
    }

    public void onDestroy() {
        this.mShow = false;
        super.onDestroy();
    }
}
