package com.tal.app.thinkacademy.live.business.studentvideo.adapter;

import android.view.LayoutInflater;
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
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.studentvideo.animator.HandUpAnimator;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class StudentAdapter extends RecyclerView.Adapter<MyHolder> {
    private static final int ITEM_STATUS_INIT = -1;
    private static final int ITEM_STATUS_PULL = 1;
    private static final int ITEM_STATUS_STOP = 2;
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.SMALL_CLASS_VIDEO_DRIVER;
    private int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    private SmallClassPluginDriver mDriver;
    private boolean mIsAllDisabled = false;
    private boolean mIsAllOnStage = false;
    private boolean mIsCollectiveSpeech = false;
    private LinearLayoutManager mLinearLayoutManager;
    private List<StudentVideoBean.ListBean> mList = new ArrayList();
    HashMap<Long, ImageView> mMicHashMap = new HashMap<>();
    private RecyclerView mRecyclerView;
    private volatile ArrayList<Long> mTopStudents = new ArrayList<>();
    private final int maxSize = 6;

    public void setAllOnStage(boolean z) {
        this.mIsAllOnStage = z;
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "setAllOnStage = " + this.mIsAllOnStage);
    }

    public void setAllDisabled(boolean z) {
        this.mIsAllDisabled = z;
    }

    public void setCollectiveSpeech(boolean z) {
        this.mIsCollectiveSpeech = z;
    }

    public StudentAdapter(SmallClassPluginDriver smallClassPluginDriver, RecyclerView recyclerView) {
        XesLog.i(TAG, "StudentAdapter init");
        this.mDriver = smallClassPluginDriver;
        this.mRecyclerView = recyclerView;
        this.mLinearLayoutManager = recyclerView.getLayoutManager();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                StudentAdapter.super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    StudentAdapter.this.pullStream();
                    XesLogTag access$000 = StudentAdapter.TAG;
                    XesLog.i(access$000, "SCROLL_STATE_IDLE = Thread = " + Thread.currentThread().getName());
                }
            }
        });
    }

    public boolean getStudentVisible(int i) {
        return i >= this.mLinearLayoutManager.findFirstVisibleItemPosition() && i <= this.mLinearLayoutManager.findLastVisibleItemPosition();
    }

    public void pullStream() {
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.mLinearLayoutManager.findLastVisibleItemPosition();
        XesLog.i(TAG, "pullStream start = " + findFirstVisibleItemPosition + ",end = " + findLastVisibleItemPosition);
        for (int i = findFirstVisibleItemPosition; i <= findLastVisibleItemPosition; i++) {
            startPull(this.mRecyclerView.findViewHolderForLayoutPosition(i), i);
        }
        if (this.mList.size() > 0) {
            for (int i2 = 0; i2 < this.mList.size(); i2++) {
                if ((i2 < findFirstVisibleItemPosition || i2 > findLastVisibleItemPosition) && !this.mList.get(i2).isOnStageAction() && this.mList.get(i2).getPullStreamState() != 0) {
                    this.mList.get(i2).setPullStreamState(0);
                    if (this.mDriver != null) {
                        XesLog.i(TAG, "stop stream position = " + i2);
                        this.mDriver.stopPullStream(this.mList.get(i2).getUserId());
                        notifyItemChanged(i2);
                    }
                }
            }
            this.mTopStudents.clear();
            for (int i3 = 0; i3 < this.mList.size(); i3++) {
                if ((i3 >= findFirstVisibleItemPosition && i3 <= findLastVisibleItemPosition) || this.mList.get(i3).isOnStageAction()) {
                    this.mTopStudents.add(Long.valueOf(this.mList.get(i3).getUserId()));
                }
            }
            SmallClassPluginDriver smallClassPluginDriver = this.mDriver;
            if (smallClassPluginDriver != null) {
                smallClassPluginDriver.updateTopStudents(this.mTopStudents);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startPull(com.tal.app.thinkacademy.live.business.studentvideo.adapter.StudentAdapter.MyHolder r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.mIsAllDisabled
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0012
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = TAG
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r0 = "startPull,全员屏蔽,return"
            r10[r1] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r10)
            return
        L_0x0012:
            java.util.List<com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean> r0 = r8.mList
            int r0 = r0.size()
            if (r10 >= r0) goto L_0x00c2
            if (r10 >= 0) goto L_0x001e
            goto L_0x00c2
        L_0x001e:
            if (r9 == 0) goto L_0x00c1
            r9.mCurrentStatus = r2
            java.util.List<com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean> r0 = r8.mList
            java.lang.Object r0 = r0.get(r10)
            com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean r0 = (com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean) r0
            long r3 = r0.getUserId()
            java.util.HashMap<java.lang.Long, android.widget.ImageView> r5 = r8.mMicHashMap
            java.lang.Long r6 = java.lang.Long.valueOf(r3)
            android.widget.ImageView r7 = r9.mStudentMicImage
            r5.put(r6, r7)
            int r0 = r0.getPullStreamState()
            if (r0 == 0) goto L_0x0040
            return
        L_0x0040:
            android.view.SurfaceView r0 = r9.mSurfaceView
            if (r0 != 0) goto L_0x0045
            return
        L_0x0045:
            java.util.List<com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean> r0 = r8.mList
            java.lang.Object r0 = r0.get(r10)
            com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean$ListBean r0 = (com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean) r0
            r0.setPullStreamState(r2)
            android.view.SurfaceView r0 = r9.mSurfaceView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0078
            android.view.SurfaceView r0 = r9.mSurfaceView
            android.view.ViewParent r0 = r0.getParent()
            android.widget.FrameLayout r5 = r9.mVideoContainer
            if (r0 != r5) goto L_0x0064
            r0 = r1
            goto L_0x0079
        L_0x0064:
            android.view.SurfaceView r0 = r9.mSurfaceView
            r5 = 8
            r0.setVisibility(r5)
            android.view.SurfaceView r0 = r9.mSurfaceView
            android.view.ViewParent r0 = r0.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.SurfaceView r5 = r9.mSurfaceView
            r0.removeView(r5)
        L_0x0078:
            r0 = r2
        L_0x0079:
            com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver r5 = r8.mDriver
            if (r5 == 0) goto L_0x0087
            android.view.SurfaceView r6 = r9.mSurfaceView
            r5.setUpRemoteSurfaceView(r6, r3)
            com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver r5 = r8.mDriver
            r5.startPullStream(r3)
        L_0x0087:
            if (r0 == 0) goto L_0x0095
            android.widget.FrameLayout r0 = r9.mVideoContainer
            r0.removeAllViews()
            android.widget.FrameLayout r0 = r9.mVideoContainer
            android.view.SurfaceView r3 = r9.mSurfaceView
            r0.addView(r3)
        L_0x0095:
            android.view.SurfaceView r0 = r9.mSurfaceView
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x00a2
            android.view.SurfaceView r0 = r9.mSurfaceView
            r0.setVisibility(r1)
        L_0x00a2:
            android.view.SurfaceView r9 = r9.mSurfaceView
            r9.requestLayout()
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = TAG
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "startPull 拉流 position = "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r0[r1] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r0)
        L_0x00c1:
            return
        L_0x00c2:
            com.tal.app.thinkacademy.lib.logger.XesLogTag r9 = TAG
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r0 = "startPull,数组越界,return"
            r10[r1] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.studentvideo.adapter.StudentAdapter.startPull(com.tal.app.thinkacademy.live.business.studentvideo.adapter.StudentAdapter$MyHolder, int):void");
    }

    public void delayToPullStream() {
        XesLog.i(TAG, "delayToPullStream");
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.postDelayed(new Runnable() {
                public void run() {
                    StudentAdapter.this.pullStream();
                }
            }, 200);
        }
    }

    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.live_business_student_video_item;
        return new MyHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
    }

    public void setData(List<StudentVideoBean.ListBean> list) {
        if (list != null) {
            this.mList = list;
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "setData 拉流 thread = " + Thread.currentThread().getName() + ",size = " + this.mList.size());
            notifyItemRangeChanged(0, this.mList.size());
            updateTopStudents();
            XesLog.i(xesLogTag, "setData over ");
            delayToPullStream();
        }
    }

    public void insertData(List<StudentVideoBean.ListBean> list) {
        if (list != null) {
            XesLog.i(TAG, "insertData 拉流 ");
            this.mList = list;
            int size = list.size();
            notifyItemInserted(size);
            notifyItemRangeChanged(size, this.mList.size() - size);
            updateTopStudents();
            delayToPullStream();
        }
    }

    public void removeData(List<StudentVideoBean.ListBean> list, int i) {
        if (list != null) {
            if (i < list.size()) {
                this.mMicHashMap.put(Long.valueOf(this.mList.get(i).getUserId()), (Object) null);
            }
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "removeData 拉流 position = " + i);
            this.mList = list;
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, this.mList.size() - i);
            updateTopStudents();
            delayToPullStream();
        }
    }

    public void changedData(List<StudentVideoBean.ListBean> list, int i) {
        if (list != null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "changedData 拉流 position = " + i + ",thread = " + Thread.currentThread().getName() + ",size = " + this.mList.size());
            this.mList = list;
            notifyItemChanged(i);
            updateTopStudents();
            XesLog.i(xesLogTag, "changedData over ");
        }
    }

    private void updateTopStudents() {
        this.mTopStudents.clear();
        if (this.mList.size() <= 6) {
            for (int i = 0; i < this.mList.size(); i++) {
                this.mTopStudents.add(Long.valueOf(this.mList.get(i).getUserId()));
            }
            SmallClassPluginDriver smallClassPluginDriver = this.mDriver;
            if (smallClassPluginDriver != null) {
                smallClassPluginDriver.updateTopStudents(this.mTopStudents);
            }
        }
    }

    public void onBindViewHolder(final MyHolder myHolder, int i) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "onBindViewHolder position =" + i);
        if (!this.mIsAllOnStage) {
            final StudentVideoBean.ListBean listBean = this.mList.get(i);
            if (listBean == null) {
                XesLog.i(xesLogTag, "onBindViewHolder bean is null position=" + i);
                return;
            }
            this.mMicHashMap.put(Long.valueOf(listBean.getUserId()), myHolder.mStudentMicImage);
            XesLog.i(xesLogTag, "onBindViewHolder  pull state = " + listBean.getPullStreamState() + ",position = " + i);
            if (!this.mIsAllDisabled && !listBean.isOnStageAction()) {
                checkHolderSurfaceView(myHolder, listBean.getUserId(), i);
            }
            myHolder.mName.setText(listBean.getNickName());
            ImageLoaderJ.loadCircle(myHolder.itemView.getContext(), listBean.getAvatar(), myHolder.mStudentHeadImage, R.drawable.common_self_image_user);
            if (listBean.isOnStageAction()) {
                myHolder.mStageHeadImage.setVisibility(0);
                myHolder.mStudentHeadImage.setVisibility(8);
                myHolder.mLevelImage.setVisibility(8);
                myHolder.mStudentHeadBgParent.setVisibility(0);
                myHolder.mHandUpAnimator.hide();
                myHolder.mEmojiView.setVisibility(8);
                myHolder.mEmojiViewBg.setVisibility(8);
            } else {
                myHolder.mStageHeadImage.setVisibility(8);
                myHolder.mStudentHeadImage.setVisibility(0);
                if (listBean.getLevel() == 0) {
                    myHolder.mLevelImage.setVisibility(8);
                } else {
                    int level = listBean.getLevel();
                    int[] iArr = this.levelIcons;
                    if (level > iArr.length) {
                        level = iArr.length;
                    }
                    myHolder.mLevelImage.setImageResource(this.levelIcons[level - 1]);
                    myHolder.mLevelImage.setVisibility(0);
                }
                myHolder.mStudentHeadBgParent.setVisibility((listBean.getPullStreamState() != 2 || this.mIsAllDisabled) ? 0 : 8);
            }
            if (listBean.isHerselfOff()) {
                myHolder.mStudentHeadBgParent.setVisibility(0);
                myHolder.mStudentMicImage.setEnabled(false);
            } else if (this.mIsCollectiveSpeech) {
                if (listBean.isOpenMic()) {
                    myHolder.mStudentMicImage.setEnabled(true);
                } else {
                    myHolder.mStudentMicImage.setEnabled(false);
                }
                myHolder.mStudentMicImage.setVisibility(0);
            } else {
                myHolder.mStudentMicImage.setVisibility(8);
            }
            if (!listBean.isRaiseHandUp() || listBean.isOnStageAction()) {
                myHolder.mHandUpAnimator.hide();
            } else {
                myHolder.mHandUpAnimator.show();
            }
            if (!listBean.isShowEmoji() || listBean.isOnStageAction() || listBean.isHerselfOff()) {
                myHolder.mEmojiView.setVisibility(8);
                myHolder.mEmojiViewBg.setVisibility(8);
            } else {
                myHolder.mEmojiView.setData((EmojiBean<?>) listBean.getEmojiBean(), (Boolean) false, (Function0<Unit>) new Function0<Unit>() {
                    public Unit invoke() {
                        listBean.setShowEmoji(false);
                        myHolder.mEmojiView.setVisibility(8);
                        myHolder.mEmojiViewBg.setVisibility(8);
                        return null;
                    }
                });
                myHolder.mEmojiView.setVisibility(0);
                myHolder.mEmojiViewBg.setVisibility(0);
            }
            if (listBean.isShowForbidUserView()) {
                myHolder.mVideoControlParent.setVisibility(0);
            } else {
                myHolder.mVideoControlParent.setVisibility(8);
            }
            XesLog.i(xesLogTag, "onBindViewHolder 拉流 position = " + i);
            if (this.mRecyclerView.getScrollState() == 0) {
                startPull(myHolder, i);
            }
        }
    }

    private void checkHolderSurfaceView(MyHolder myHolder, long j, int i) {
        myHolder.mSurfaceView = this.mDriver.getSurfaceView(j);
        boolean z = true;
        if (myHolder.mSurfaceView != null) {
            myHolder.mSurfaceView.setZOrderMediaOverlay(false);
            if (myHolder.mSurfaceView.getParent() == null) {
                if (myHolder.mVideoContainer.getChildCount() != 0) {
                    View childAt = myHolder.mVideoContainer.getChildAt(0);
                    if (childAt != null) {
                        childAt.setVisibility(8);
                    }
                    myHolder.mVideoContainer.removeAllViews();
                }
                myHolder.mVideoContainer.addView(myHolder.mSurfaceView);
                if (myHolder.mSurfaceView.getVisibility() != 0) {
                    myHolder.mSurfaceView.setVisibility(0);
                }
                XesLog.i(TAG, "onBindViewHolder  surface parent is null  position " + i);
            } else if (myHolder.mSurfaceView.getParent() != myHolder.mVideoContainer) {
                XesLogTag xesLogTag = TAG;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("onBindViewHolder  surface parent not null  ");
                if (myHolder.mSurfaceView.getParent() != myHolder.mVideoControlParent) {
                    z = false;
                }
                sb.append(z);
                sb.append(",position = ");
                sb.append(i);
                objArr[0] = sb.toString();
                XesLog.i(xesLogTag, objArr);
                myHolder.mSurfaceView.setVisibility(8);
                ((ViewGroup) myHolder.mSurfaceView.getParent()).removeView(myHolder.mSurfaceView);
                if (myHolder.mVideoContainer.getChildCount() != 0) {
                    myHolder.mVideoContainer.removeAllViews();
                }
                myHolder.mVideoContainer.addView(myHolder.mSurfaceView);
                if (myHolder.mSurfaceView.getVisibility() != 0) {
                    myHolder.mSurfaceView.setVisibility(0);
                }
            }
        } else {
            XesLog.i(TAG, "onBindViewHolder surfaceView is null position " + i);
        }
    }

    public void onViewDetachedFromWindow(MyHolder myHolder) {
        StudentAdapter.super.onViewDetachedFromWindow(myHolder);
        myHolder.mHandUpAnimator.release();
    }

    public int getItemCount() {
        List<StudentVideoBean.ListBean> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public RelativeLayout mBottomView;
        public int mCurrentStatus = -1;
        public EmojiView mEmojiView;
        public LinearLayout mEmojiViewBg;
        public HandUpAnimator mHandUpAnimator;
        public ImageView mHandUpImage;
        public View mHandUpViewBg;
        public ImageView mLevelImage;
        public TextView mName;
        public ImageView mStageHeadImage;
        public RelativeLayout mStudentHeadBgParent;
        public ImageView mStudentHeadImage;
        public ImageView mStudentMicImage;
        public SurfaceView mSurfaceView;
        public FrameLayout mVideoContainer;
        public RoundTextView mVideoControlBtn;
        public FrameLayout mVideoControlParent;

        public MyHolder(View view) {
            super(view);
            XesLog.i(StudentAdapter.TAG, "create MyHolder  ");
            this.mVideoContainer = (FrameLayout) view.findViewById(R.id.student_video_container);
            this.mName = (TextView) view.findViewById(R.id.student_name);
            this.mStudentHeadImage = (ImageView) view.findViewById(R.id.student_head);
            this.mStudentHeadBgParent = (RelativeLayout) view.findViewById(R.id.student_head_bg_parent);
            this.mLevelImage = (ImageView) view.findViewById(R.id.student_level);
            this.mStageHeadImage = (ImageView) view.findViewById(R.id.student_head_stage);
            this.mEmojiView = (EmojiView) view.findViewById(R.id.emoji_view);
            this.mEmojiViewBg = (LinearLayout) view.findViewById(R.id.emoji_view_bg);
            this.mHandUpViewBg = view.findViewById(R.id.hand_up_view_bg);
            this.mHandUpImage = (ImageView) view.findViewById(R.id.hand_up_image);
            this.mStudentMicImage = (ImageView) view.findViewById(R.id.ivStudentMic);
            this.mBottomView = (RelativeLayout) view.findViewById(R.id.bottom_layout);
            this.mVideoControlParent = (FrameLayout) view.findViewById(R.id.video_control_parent);
            this.mVideoControlBtn = view.findViewById(R.id.video_control_btn);
            reLayoutChildView();
            this.mHandUpAnimator = HandUpAnimator.create(this.mHandUpImage, this.mHandUpViewBg);
        }

        private void reLayoutChildView() {
            float studentStreamRate = LiveAreaCompat.getStudentStreamRate();
            this.itemView.getLayoutParams().width = (int) ((((float) LiveAreaContext.get().getHeadLp().height) * studentStreamRate) - ((float) (LiveAreaContext.get().getHeadLp().height / 76)));
            int i = LiveAreaContext.get().getHeadLp().height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mStudentHeadImage.getLayoutParams();
            int i2 = (i * 64) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams.height = i2;
            layoutParams.width = i2;
            int i3 = (i * 30) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams.topMargin = i3;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mStageHeadImage.getLayoutParams();
            layoutParams2.width = (i * 54) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams2.height = (i * 62) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLevelImage.getLayoutParams();
            layoutParams3.width = (i * 40) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams3.height = (i * 18) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            int i4 = (i * 4) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams3.leftMargin = i4;
            layoutParams3.topMargin = i4;
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mEmojiView.getLayoutParams();
            layoutParams4.height = i2;
            layoutParams4.width = i2;
            layoutParams4.topMargin = i3;
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.mHandUpImage.getLayoutParams();
            layoutParams5.width = (i * 78) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams5.height = (i * 117) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            ((RelativeLayout.LayoutParams) this.mBottomView.getLayoutParams()).height = (i * 28) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.mStudentMicImage.getLayoutParams();
            int i5 = i * 16;
            int i6 = i5 / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams6.width = i6;
            layoutParams6.height = i6;
            layoutParams6.rightMargin = i4;
            layoutParams6.bottomMargin = i4;
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams7.leftMargin = i4;
            layoutParams7.rightMargin = (i * 6) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams7.bottomMargin = i4;
            this.mName.setTextSize(0, (float) ((i * 14) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN));
            FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.mVideoControlBtn.getLayoutParams();
            layoutParams8.height = (i * 23) / 76;
            int i7 = (i * 5) / 76;
            layoutParams8.leftMargin = i7;
            layoutParams8.rightMargin = i7;
            this.mVideoControlBtn.setTextSize(0, (float) ((i * 10) / 76));
            this.mVideoControlBtn.getDelegate().setCornerRadius(SizeUtils.px2dp((float) (i5 / 76)));
            this.mVideoControlBtn.getDelegate().setStrokeWidth(SizeUtils.px2dp((float) ((i * 1) / 76)));
        }
    }
}
