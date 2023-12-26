package com.tal.app.thinkacademy.live.business.mediacontroller.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.bumptech.glide.Glide;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.utils.NetWorkUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.HeartBeatUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.constants.MediaControlConstants;
import com.tal.app.thinkacademy.live.business.mediacontroller.helper.NetStateHelper;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.dialog.NetworkDialog;
import com.tal.app.thinkacademy.live.dialog.NetworkState;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class BaseMediaControlView extends BaseLivePluginView {
    public static final int BOTTOM_HEIGHT_PHONE = 85;
    /* access modifiers changed from: private */
    public View.OnClickListener backListener;
    protected View bottomRoot;
    public BaseMediaControlDriver driver;
    private NetworkState exitState = NetworkState.GOOD;
    protected ImageView ivBack;
    protected ImageView ivNetwork;
    protected ImageView ivPreview;
    protected ImageView ivRefresh;
    private NetworkState lastExitState = NetworkState.GOOD;
    protected AudioManager mAM;
    private View.OnClickListener mBackClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, BaseMediaControlView.class);
            XesLog.it("退出课堂，标题栏返回点击", new Object[0]);
            if (BaseMediaControlView.this.backListener != null) {
                BaseMediaControlView.this.backListener.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    };
    protected Context mContext;
    protected Handler mHandler;
    public ILiveRoomProvider mILiveRoomProvider;
    protected int mLastRxQuality = -1;
    private NetStateHelper mNetStateHelper = null;
    protected int mNetStatusResp = 0;
    protected RoundLinearLayout mNetWorkGood;
    protected RoundLinearLayout mNetWorkNormal;
    protected RoundLinearLayout mNetWorkWeak;
    private NetworkDialog mNetworkDialog = null;
    private final Runnable mNetworkDialogDismissRunnable = new BaseMediaControlView$$ExternalSyntheticLambda5(this);
    private Runnable mNetworkDialogRunnable = new BaseMediaControlView$$ExternalSyntheticLambda6(this);
    private Runnable mNetworkRunnable = new BaseMediaControlView$$ExternalSyntheticLambda4(this);
    protected Runnable mRunnable = new BaseMediaControlView$$ExternalSyntheticLambda3(this);
    protected int mRxQuality = 0;
    public boolean mShowing;
    protected int mTimeout = MediaControlConstants.DEFAULT_TIME_OUT;
    protected PopupWindow mToastNetWork;
    protected int[] mWifiStateIcons = {R.drawable.icon_wifi_navigation_good, R.drawable.icon_wifi_navigation_normal, R.drawable.icon_wifi_navigation_weak};
    protected View topRoot;
    protected TextView tvTitle;

    public abstract void setContentLayoutParams();

    public abstract void startAnim(boolean z);

    public BaseMediaControlView(Context context) {
        super(context);
        this.mContext = context;
        this.mHandler = new MHandler(this);
        show();
        this.mNetStateHelper = new NetStateHelper(new BaseMediaControlView$$ExternalSyntheticLambda2(this));
    }

    public /* synthetic */ void lambda$new$0$BaseMediaControlView(boolean z) {
        if (z) {
            Handler handler = this.mHandler;
            Runnable runnable = this.mNetworkDialogDismissRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        } else {
            Handler handler2 = this.mHandler;
            Runnable runnable2 = this.mNetworkDialogRunnable;
            if (!(handler2 instanceof Handler)) {
                handler2.post(runnable2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler2, runnable2);
            }
        }
    }

    public BaseMediaControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public BaseMediaControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public void setDriver(BaseMediaControlDriver baseMediaControlDriver) {
        this.driver = baseMediaControlDriver;
    }

    public void setILiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        this.mILiveRoomProvider = iLiveRoomProvider;
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        this.backListener = onClickListener;
    }

    public void initViews() {
        BaseMediaControlView.super.initViews();
        this.ivBack = (ImageView) findViewById(R.id.iv_media_controller_back);
        this.tvTitle = (TextView) findViewById(R.id.tv_media_controller_title);
        this.ivRefresh = (ImageView) findViewById(R.id.iv_media_controller_refresh);
        this.ivNetwork = (ImageView) findViewById(R.id.iv_media_controller_network);
        this.ivPreview = (ImageView) findViewById(R.id.iv_live_business_media_controller_controls_preview);
    }

    public void initData() {
        BaseMediaControlView.super.initData();
        this.mAM = (AudioManager) getContext().getSystemService("audio");
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        setFocusableInTouchMode(true);
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setOnClickListener(this.mBackClickListener);
        }
        this.ivRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, BaseMediaControlView.class);
                BaseMediaControlView.this.driver.refresh();
                DriverTrack.INSTANCE.classroomToolbarClick("刷新");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.ivNetwork.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, BaseMediaControlView.class);
                BaseMediaControlView.this.showNetWorkPop();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setScreenShotFilePath(String str) {
        Glide.with(this.mContext).load(new File(str)).into(this.ivPreview);
        this.ivPreview.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                BaseMediaControlView.this.ivPreview.setVisibility(8);
            }
        }, 3000);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        show(this.mTimeout);
        return false;
    }

    public void setTitle(String str) {
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void show() {
        show(this.mTimeout);
    }

    public void showLong() {
        show(this.mTimeout);
    }

    public void toggle() {
        if (this.mShowing) {
            hide();
        } else {
            show();
        }
    }

    public void show(int i) {
        if (i != 0) {
            try {
                this.mHandler.removeMessages(1);
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(1), (long) i);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (!this.mShowing) {
            this.mHandler.removeMessages(3);
            startAnim(true);
            Handler handler2 = this.mHandler;
            if (!(handler2 instanceof Handler)) {
                handler2.sendEmptyMessage(4);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler2, 4);
            }
            Handler handler3 = this.mHandler;
            if (!(handler3 instanceof Handler)) {
                handler3.sendEmptyMessage(2);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler3, 2);
            }
            this.mShowing = true;
        }
    }

    public void hide() {
        if (this.mShowing) {
            try {
                this.mHandler.removeMessages(1);
                startAnim(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mShowing = false;
        }
    }

    public void showNetWorkPop() {
        int i;
        if (this.mToastNetWork == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int i2 = R.layout.live_business_network_pop;
            PopupWindow popupWindow = new PopupWindow(!(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null), -2, -2, true);
            this.mToastNetWork = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mToastNetWork.setFocusable(false);
            this.mToastNetWork.setOutsideTouchable(false);
            View contentView = this.mToastNetWork.getContentView();
            this.mNetWorkGood = contentView.findViewById(R.id.layout_pop_network_good);
            this.mNetWorkNormal = contentView.findViewById(R.id.layout_pop_network_normal);
            this.mNetWorkWeak = contentView.findViewById(R.id.layout_pop_network_weak);
        }
        int measuredWidth = this.ivNetwork.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = SizeUtils.dp2px(30.0f);
        }
        int i3 = this.mRxQuality;
        if (i3 == 1 || i3 == 2) {
            this.mNetWorkGood.setVisibility(0);
            this.mNetWorkNormal.setVisibility(8);
            this.mNetWorkWeak.setVisibility(8);
            i = this.mNetWorkGood.getMeasuredWidth();
            if (i == 0) {
                i = SizeUtils.dp2px(200.0f);
            }
        } else if (i3 != 3) {
            this.mNetWorkGood.setVisibility(8);
            this.mNetWorkNormal.setVisibility(8);
            this.mNetWorkWeak.setVisibility(0);
            i = this.mNetWorkWeak.getMeasuredWidth();
            if (i == 0) {
                i = SizeUtils.dp2px(201.0f);
            }
        } else {
            this.mNetWorkGood.setVisibility(8);
            this.mNetWorkNormal.setVisibility(0);
            this.mNetWorkWeak.setVisibility(8);
            i = this.mNetWorkNormal.getMeasuredWidth();
            if (i == 0) {
                i = SizeUtils.dp2px(210.0f);
            }
        }
        this.mToastNetWork.showAsDropDown(this.ivNetwork, measuredWidth - i, SizeUtils.dp2px(12.0f));
        if (this.mHandler == null) {
            this.mHandler = new MHandler(this);
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(this.mRunnable, 3000);
    }

    /* access modifiers changed from: protected */
    public void onNetworkQuality(long j, int i, int i2) {
        if (j == 0) {
            this.mRxQuality = i2;
            updateNetwork();
            updateNetworkDialog("rtc", i2);
        }
    }

    public void updateNetwork() {
        Handler handler = this.mHandler;
        if (handler != null) {
            Runnable runnable = this.mNetworkRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        }
    }

    public /* synthetic */ void lambda$new$2$BaseMediaControlView() {
        switch (this.mRxQuality) {
            case 1:
            case 2:
                this.ivNetwork.setVisibility(0);
                this.ivNetwork.setImageResource(this.mWifiStateIcons[0]);
                return;
            case 3:
                this.ivNetwork.setVisibility(0);
                this.ivNetwork.setImageResource(this.mWifiStateIcons[1]);
                return;
            case 4:
            case 5:
            case 6:
                this.ivNetwork.setVisibility(0);
                this.ivNetwork.setImageResource(this.mWifiStateIcons[2]);
                return;
            default:
                this.ivNetwork.setVisibility(8);
                return;
        }
    }

    /* renamed from: dismissNetWorkPop */
    public void lambda$new$1$BaseMediaControlView() {
        PopupWindow popupWindow = this.mToastNetWork;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mToastNetWork.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onNetStatusChanged(int i) {
        this.mNetStatusResp = i;
        updateNetworkDialog("irc", i);
        HeartBeatUtil.setIrcCurrentCode(i);
        saveIrcCode(i);
    }

    private void saveIrcCode(int i) {
        HashMap<String, Integer> ircCodeCount = HeartBeatUtil.getIrcCodeCount();
        setSingleIrcCode(ircCodeCount, i + "");
    }

    private void setSingleIrcCode(HashMap<String, Integer> hashMap, String str) {
        Integer num = hashMap.get(str);
        if (num != null) {
            hashMap.put(str, Integer.valueOf(num.intValue() + 1));
        } else {
            hashMap.put(str, 1);
        }
    }

    private void updateNetworkDialog(String str, int i) {
        if (this.mNetStateHelper != null) {
            if (TextUtils.equals("rtc", str)) {
                this.mNetStateHelper.updateRtc(i);
            } else {
                this.mNetStateHelper.updateIrc(i);
            }
        }
    }

    public /* synthetic */ void lambda$new$3$BaseMediaControlView() {
        NetworkDialog networkDialog = this.mNetworkDialog;
        if (networkDialog != null && networkDialog.isShowing()) {
            try {
                this.mNetworkDialog.dismiss();
                this.mNetworkDialog = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$new$6$BaseMediaControlView() {
        Activity activity;
        if (this.mNetworkDialog == null) {
            NetworkDialog networkDialog = new NetworkDialog(getContext());
            this.mNetworkDialog = networkDialog;
            networkDialog.setDismissListener(new BaseMediaControlView$$ExternalSyntheticLambda1(this));
            this.mNetworkDialog.setGotItClickCall(new BaseMediaControlView$$ExternalSyntheticLambda0(this));
        }
        NetworkDialog networkDialog2 = this.mNetworkDialog;
        if (networkDialog2 != null && !networkDialog2.isShowing() && (activity = (Activity) getContext()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            this.mNetworkDialog.show();
        }
    }

    public /* synthetic */ void lambda$new$4$BaseMediaControlView() {
        this.mLastRxQuality = -1;
        this.lastExitState = NetworkState.GOOD;
    }

    public /* synthetic */ void lambda$new$5$BaseMediaControlView(View view) {
        NetStateHelper netStateHelper = this.mNetStateHelper;
        if (netStateHelper != null) {
            netStateHelper.stopCallback(NetWorkUtils.MINUTE);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
        NetworkDialog networkDialog = this.mNetworkDialog;
        if (networkDialog != null) {
            networkDialog.dismiss();
        }
        this.mNetworkDialogRunnable = null;
        this.mNetworkDialog = null;
        this.mNetworkRunnable = null;
        NetStateHelper netStateHelper = this.mNetStateHelper;
        if (netStateHelper != null) {
            netStateHelper.release();
            this.mNetStateHelper = null;
        }
    }

    public static class MHandler extends Handler {
        private WeakReference<BaseMediaControlView> mc;

        public MHandler(BaseMediaControlView baseMediaControlView) {
            this.mc = new WeakReference<>(baseMediaControlView);
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            BaseMediaControlView baseMediaControlView = (BaseMediaControlView) this.mc.get();
            if (baseMediaControlView == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            if (message.what == 1) {
                baseMediaControlView.hide();
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
