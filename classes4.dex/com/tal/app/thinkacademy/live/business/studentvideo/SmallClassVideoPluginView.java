package com.tal.app.thinkacademy.live.business.studentvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.studentvideo.adapter.MyDividerItemDecoration;
import com.tal.app.thinkacademy.live.business.studentvideo.adapter.StudentAdapter;
import com.tal.app.thinkacademy.live.business.studentvideo.animator.HandUpAnimator;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class SmallClassVideoPluginView extends AbstractStudentVideoPluginView<SmallClassPluginDriver> {
    private boolean isAudition = false;
    private boolean isCollectiveSpeech = false;
    private int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    public RelativeLayout mBottomView;
    private SmallClassPluginDriver mDriver;
    public EmojiView mEmojiView;
    public LinearLayout mEmojiViewBg;
    private HandUpAnimator mHandUpAnimator;
    public ImageView mHandUpImage;
    public View mHandUpViewBg;
    public ImageView mIvStudentMic;
    public ImageView mLevelImage;
    private LinearLayoutManager mLinearLayoutManager;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean mMyBean;
    public RelativeLayout mMyRootView;
    public TextView mName;
    public ImageView mStageHeadImage;
    private StudentAdapter mStudentAdapter;
    private LinearLayout mStudentBgView;
    public RelativeLayout mStudentHeadBgParent;
    public ImageView mStudentHeadImage;
    private RecyclerView mStudentRecyclerview;
    public FrameLayout mVideoContainer;

    public SmallClassVideoPluginView(Context context, boolean z) {
        super(context);
        this.isAudition = z;
        initView();
    }

    public SmallClassVideoPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public SmallClassVideoPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mStudentBgView = (LinearLayout) findViewById(R.id.student_bg_root_view);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.auditionBgRL);
        if (this.isAudition) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        LiveAreaLayoutParams headLp = LiveAreaContext.get().getHeadLp();
        int i = headLp.height;
        float f = (float) i;
        float studentStreamRate = f * LiveAreaCompat.getStudentStreamRate();
        int ceil = (int) Math.ceil((double) (((((float) headLp.width) - ((4.0f * f) / 3.0f)) - studentStreamRate) / studentStreamRate));
        for (int i2 = 0; i2 < ceil; i2++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(R.drawable.live_business_student_bg);
            imageView.setLayoutParams(new LinearLayout.LayoutParams((int) studentStreamRate, i));
            this.mStudentBgView.addView(imageView);
        }
        this.mMyRootView = (RelativeLayout) findViewById(R.id.my_root_view);
        this.mVideoContainer = (FrameLayout) findViewById(R.id.student_video_container);
        this.mName = (TextView) findViewById(R.id.student_name);
        this.mStudentHeadImage = (ImageView) findViewById(R.id.student_head);
        this.mStudentHeadBgParent = (RelativeLayout) findViewById(R.id.student_head_bg_parent);
        this.mLevelImage = (ImageView) findViewById(R.id.student_level);
        this.mStageHeadImage = (ImageView) findViewById(R.id.student_head_stage);
        this.mEmojiView = (EmojiView) findViewById(R.id.emoji_view);
        this.mEmojiViewBg = (LinearLayout) findViewById(R.id.emoji_view_bg);
        this.mHandUpViewBg = findViewById(R.id.hand_up_view_bg);
        this.mHandUpImage = (ImageView) findViewById(R.id.hand_up_image);
        this.mIvStudentMic = (ImageView) findViewById(R.id.ivStudentMic);
        this.mBottomView = (RelativeLayout) findViewById(R.id.bottom_layout);
        reLayoutChildView();
        this.mStudentRecyclerview = findViewById(R.id.student_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mStudentRecyclerview.setLayoutManager(this.mLinearLayoutManager);
        this.mStudentRecyclerview.setItemAnimator((RecyclerView.ItemAnimator) null);
        MyDividerItemDecoration myDividerItemDecoration = new MyDividerItemDecoration(getContext(), 0);
        int i3 = (i * 1) / 76;
        Bitmap createBitmap = Bitmap.createBitmap(i3, 1, Bitmap.Config.RGB_565);
        createBitmap.eraseColor(-16777216);
        myDividerItemDecoration.setDrawable(new BitmapDrawable((Resources) null, createBitmap));
        myDividerItemDecoration.setIntrinsicWidth(i3);
        this.mStudentRecyclerview.addItemDecoration(myDividerItemDecoration);
        this.mHandUpAnimator = HandUpAnimator.create(this.mHandUpImage, this.mHandUpViewBg);
    }

    private void reLayoutChildView() {
        if (this.mName != null) {
            float studentStreamRate = LiveAreaCompat.getStudentStreamRate();
            int i = LiveAreaContext.get().getHeadLp().height - (LiveAreaContext.get().getHeadLp().height / 76);
            int i2 = (int) (((float) i) * studentStreamRate);
            int childCount = this.mStudentBgView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mStudentBgView.getChildAt(i3);
                if (childAt != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.width = i2;
                    layoutParams.height = i;
                    layoutParams.rightMargin = LiveAreaContext.get().getHeadLp().height / 76;
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mMyRootView.getLayoutParams();
            layoutParams2.width = i2;
            layoutParams2.rightMargin = LiveAreaContext.get().getHeadLp().height / 76;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mStudentHeadImage.getLayoutParams();
            int i4 = (i * 64) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams3.height = i4;
            layoutParams3.width = i4;
            int i5 = (i * 30) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams3.topMargin = i5;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mStageHeadImage.getLayoutParams();
            layoutParams4.width = (i * 54) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams4.height = (i * 62) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.mLevelImage.getLayoutParams();
            layoutParams5.width = (i * 40) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams5.height = (i * 18) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            int i6 = (i * 4) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams5.leftMargin = i6;
            layoutParams5.topMargin = i6;
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.mEmojiView.getLayoutParams();
            layoutParams6.width = i4;
            layoutParams6.height = i4;
            layoutParams6.topMargin = i5;
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.mHandUpImage.getLayoutParams();
            layoutParams7.width = (i * 78) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams7.height = (i * 117) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            ((RelativeLayout.LayoutParams) this.mBottomView.getLayoutParams()).height = (i * 28) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.mIvStudentMic.getLayoutParams();
            int i7 = (i * 16) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams8.width = i7;
            layoutParams8.height = i7;
            layoutParams8.rightMargin = i6;
            layoutParams8.bottomMargin = i6;
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams9.leftMargin = i6;
            layoutParams9.rightMargin = (i * 6) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams9.bottomMargin = i6;
            this.mName.setTextSize(0, (float) ((i * 14) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN));
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        reLayoutChildView();
    }

    public void setDriver(SmallClassPluginDriver smallClassPluginDriver) {
        this.mDriver = smallClassPluginDriver;
        StudentAdapter studentAdapter = new StudentAdapter(this.mDriver, this.mStudentRecyclerview);
        this.mStudentAdapter = studentAdapter;
        this.mStudentRecyclerview.setAdapter(studentAdapter);
    }

    public void showRaiseHand(long j, boolean z) {
        StudentVideoBean.ListBean listBean;
        super.showRaiseHand(j, z);
        if (this.mHandUpAnimator == null) {
            return;
        }
        if (!z || (listBean = this.mMyBean) == null || listBean.isOnStageAction()) {
            this.mHandUpAnimator.hide();
        } else {
            this.mHandUpAnimator.show();
        }
    }

    public void showEmoji(long j, EmojiBean<Object> emojiBean, boolean z) {
        StudentVideoBean.ListBean listBean;
        super.showEmoji(j, emojiBean, z);
        if (this.mEmojiView == null) {
            return;
        }
        if (!z || (listBean = this.mMyBean) == null || listBean.isOnStageAction()) {
            this.mEmojiView.setVisibility(8);
            this.mEmojiViewBg.setVisibility(8);
            return;
        }
        this.mEmojiView.setData((EmojiBean<?>) emojiBean, (Boolean) false, (Function0<Unit>) new Function0<Unit>() {
            public Unit invoke() {
                SmallClassVideoPluginView.this.mMyBean.setShowEmoji(false);
                SmallClassVideoPluginView.this.mEmojiView.setVisibility(8);
                SmallClassVideoPluginView.this.mEmojiViewBg.setVisibility(8);
                return null;
            }
        });
        this.mEmojiView.setVisibility(0);
        this.mEmojiViewBg.setVisibility(0);
    }

    public void setAllOnStage(boolean z) {
        super.setAllOnStage(z);
        this.mStudentAdapter.setAllOnStage(z);
    }

    public void updateSmallClassVideoList(List<? extends StudentVideoBean.ListBean> list) {
        super.updateSmallClassVideoList(list);
        this.mStudentAdapter.setData(list);
    }

    public void addSmallClassVideo(List<? extends StudentVideoBean.ListBean> list) {
        super.addSmallClassVideo(list);
        this.mStudentAdapter.insertData(list);
    }

    public void removeSmallClassVideo(List<? extends StudentVideoBean.ListBean> list, int i) {
        super.removeSmallClassVideo(list, i);
        this.mStudentAdapter.removeData(list, i);
    }

    public void changeSmallClassVideo(List<? extends StudentVideoBean.ListBean> list, int i) {
        super.changeSmallClassVideo(list, i);
        this.mStudentAdapter.changedData(list, i);
    }

    public boolean isSmallStudentVisible(int i) {
        return this.mStudentAdapter.getStudentVisible(i);
    }

    public void setALLRemoteVideoDisable(boolean z) {
        super.setALLRemoteVideoDisable(z);
        this.mStudentAdapter.setAllDisabled(z);
    }

    public void updateSmallMic(long j, int i) {
        super.updateSmallMic(j, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_small_class2;
    }

    public void setCollectiveSpeech(boolean z) {
        this.isCollectiveSpeech = z;
        StudentAdapter studentAdapter = this.mStudentAdapter;
        if (studentAdapter != null) {
            studentAdapter.setCollectiveSpeech(z);
        }
    }

    public void addRenderView(SurfaceView surfaceView, int i, StudentVideoBean.ListBean listBean) {
        int i2;
        super.addRenderView(surfaceView, i, listBean);
        if (i == 0 && listBean != null) {
            this.mMyBean = listBean;
            this.mMyRootView.setVisibility(0);
            this.mName.setText(listBean.getNickName());
            ImageLoaderJ.loadCircle(getContext(), listBean.getAvatar(), this.mStudentHeadImage, R.drawable.common_self_image_user);
            if (listBean.isOnStageAction()) {
                this.mStageHeadImage.setVisibility(0);
                this.mStudentHeadImage.setVisibility(8);
                this.mLevelImage.setVisibility(8);
                this.mStudentHeadBgParent.setVisibility(0);
            } else {
                this.mStageHeadImage.setVisibility(8);
                this.mStudentHeadImage.setVisibility(0);
                if (listBean.getLevel() == 0) {
                    this.mLevelImage.setVisibility(8);
                } else {
                    int level = listBean.getLevel();
                    int[] iArr = this.levelIcons;
                    if (level > iArr.length) {
                        level = iArr.length;
                    }
                    this.mLevelImage.setImageResource(iArr[level - 1]);
                    this.mLevelImage.setVisibility(0);
                }
                if (listBean.getCameraPerm() == 1 || listBean.isOpenCamera()) {
                    addSurfaceView(surfaceView, this.mVideoContainer);
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                if (listBean.isDisableTheVideo()) {
                    i2 = 0;
                }
                this.mStudentHeadBgParent.setVisibility(i2);
            }
            if (listBean.isOnStageAction()) {
                this.mIvStudentMic.setVisibility(8);
                return;
            }
            if (listBean.isOpenMic()) {
                this.mIvStudentMic.setEnabled(true);
            } else {
                this.mIvStudentMic.setEnabled(false);
            }
            this.mIvStudentMic.setVisibility(0);
        }
    }

    private void addSurfaceView(SurfaceView surfaceView, FrameLayout frameLayout) {
        StudentVideoBean.ListBean listBean = this.mMyBean;
        if ((listBean == null || !listBean.isDisableTheVideo()) && surfaceView != null) {
            boolean z = true;
            if (surfaceView.getParent() != null) {
                if (surfaceView.getParent() != frameLayout) {
                    ((ViewGroup) surfaceView.getParent()).removeView(surfaceView);
                } else {
                    z = false;
                }
            }
            if (z) {
                frameLayout.removeAllViews();
                frameLayout.addView(surfaceView, 0);
            }
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            surfaceView.requestLayout();
        }
    }

    public void onDestroy() {
        HandUpAnimator handUpAnimator = this.mHandUpAnimator;
        if (handUpAnimator != null) {
            handUpAnimator.release();
            this.mHandUpAnimator = null;
        }
    }
}
