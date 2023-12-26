package com.tal.app.thinkacademy.live.business.randomcallnew.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceItemDecoration;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding;
import com.tal.app.thinkacademy.live.business.randomcallnew.adapter.RandomCallPhotoWallAdapter;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.listener.RandomCallPhotoWallListener;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b&\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0007H\u0002J\u000f\u00105\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u00106J\u0010\u00107\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020$J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u000201H\u0002J\b\u0010;\u001a\u000201H\u0002J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\u0016H\u0016J\b\u0010>\u001a\u000201H\u0002J\u000e\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u001aJ\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\u0010\u0010C\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006E"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/RandomCallPhotoWallInterface;", "context", "Landroid/content/Context;", "students", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "selected", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;)V", "levelBg", "", "levels", "mAdapter", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/adapter/RandomCallPhotoWallAdapter;", "mBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRandowCallPhotoWallPadBinding;", "getMBinding", "()Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRandowCallPhotoWallPadBinding;", "setMBinding", "(Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRandowCallPhotoWallPadBinding;)V", "mCurrentNumber", "", "mHandler", "Landroid/os/Handler;", "mRandomCallPhotoWallListener", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/listener/RandomCallPhotoWallListener;", "mRandomCallViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/RandomCallViewModel;", "mRandomSelectStudentPositions", "mRandomSelectStudentRunnable", "Ljava/lang/Runnable;", "mRtcModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mTextureHashMap", "Ljava/util/HashMap;", "", "Landroid/view/TextureView;", "Lkotlin/collections/HashMap;", "mTotalNumber", "getSelected", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "setSelected", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;)V", "getStudents", "()Ljava/util/ArrayList;", "setStudents", "(Ljava/util/ArrayList;)V", "destroy", "", "isStopSelectedStudent", "", "getFinalSelectStudent", "getFinalSelectStudentPosition", "()Ljava/lang/Integer;", "getTextureView", "uid", "initView", "initializeData", "initializeRandomSelectNumbers", "refresh", "position", "refreshSelectStudentView", "setRandomCallPhotoWallListener", "randomCallPhotoWallListener", "showSelectStudentView", "startRandomSelectStudentAnimation", "stopAllStream", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRandomCallPhotoWallPluginView.kt */
public abstract class BaseRandomCallPhotoWallPluginView extends BaseLivePluginView implements RandomCallPhotoWallInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RANDOM_CALL_NEW;
    private final int[] levelBg = {R.drawable.live_business_shape_bg_random_call_photo_wall_select_level1, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level2, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level3, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level4, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level5, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level6, R.drawable.live_business_shape_bg_random_call_photo_wall_select_level7};
    private final int[] levels = {R.drawable.icon_small_level1, R.drawable.icon_small_level2, R.drawable.icon_small_level3, R.drawable.icon_small_level4, R.drawable.icon_small_level5, R.drawable.icon_small_level6, R.drawable.icon_small_level7};
    private RandomCallPhotoWallAdapter mAdapter;
    private LiveBusinessLayoutRandowCallPhotoWallPadBinding mBinding;
    private int mCurrentNumber;
    private Handler mHandler;
    private RandomCallPhotoWallListener mRandomCallPhotoWallListener;
    private RandomCallViewModel mRandomCallViewModel;
    private final int[] mRandomSelectStudentPositions = new int[16];
    private Runnable mRandomSelectStudentRunnable;
    private RtcViewModel mRtcModel;
    private HashMap<Long, TextureView> mTextureHashMap = new HashMap<>();
    private final int mTotalNumber = 16;
    private RandomCallUserBean selected;
    private ArrayList<RandomCallUserBean> students;

    public final ArrayList<RandomCallUserBean> getStudents() {
        return this.students;
    }

    public final void setStudents(ArrayList<RandomCallUserBean> arrayList) {
        this.students = arrayList;
    }

    public final RandomCallUserBean getSelected() {
        return this.selected;
    }

    public final void setSelected(RandomCallUserBean randomCallUserBean) {
        this.selected = randomCallUserBean;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRandomCallPhotoWallPluginView(Context context, ArrayList<RandomCallUserBean> arrayList, RandomCallUserBean randomCallUserBean) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.students = arrayList;
        this.selected = randomCallUserBean;
        LiveBusinessLayoutRandowCallPhotoWallPadBinding bind = LiveBusinessLayoutRandowCallPhotoWallPadBinding.bind(this.RootView.findViewById(R.id.random_call_photo_wall_root_view));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(RootView.findViewBy…ll_photo_wall_root_view))");
        this.mBinding = bind;
        this.mRandomCallViewModel = AbilityPackKt.getAbilityPack().getViewModel(RandomCallViewModel.class);
        this.mRtcModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        initView();
        initializeData();
        ArrayList<RandomCallUserBean> arrayList2 = this.students;
        if (arrayList2 != null && arrayList2.size() > 1) {
            initializeRandomSelectNumbers();
            SoundPoolUtils.playSameTime(context, R.raw.live_business_random_call_photo_wall_bg, 0);
            XesLog.i(TAG, "开始照片墙随机选择动画");
            startRandomSelectStudentAnimation();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseRandomCallPhotoWallPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final LiveBusinessLayoutRandowCallPhotoWallPadBinding getMBinding() {
        return this.mBinding;
    }

    /* access modifiers changed from: protected */
    public final void setMBinding(LiveBusinessLayoutRandowCallPhotoWallPadBinding liveBusinessLayoutRandowCallPhotoWallPadBinding) {
        Intrinsics.checkNotNullParameter(liveBusinessLayoutRandowCallPhotoWallPadBinding, "<set-?>");
        this.mBinding = liveBusinessLayoutRandowCallPhotoWallPadBinding;
    }

    public final void setRandomCallPhotoWallListener(RandomCallPhotoWallListener randomCallPhotoWallListener) {
        Intrinsics.checkNotNullParameter(randomCallPhotoWallListener, "randomCallPhotoWallListener");
        this.mRandomCallPhotoWallListener = randomCallPhotoWallListener;
    }

    private final void initView() {
        ImageView imageView = this.mBinding.ivRandomCallPhotoWallTitleSelect;
        if (Intrinsics.areEqual(SchoolConstants.INSTANCE.schoolCode(), "85201")) {
            imageView.setImageResource(R.drawable.bg_random_call_photo_wall_title_hk);
        } else {
            imageView.setImageResource(R.drawable.bg_random_call_photo_wall_title);
        }
        RecyclerView recyclerView = this.mBinding.rvRandomCallPhotoWall;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 4);
        ArrayList<RandomCallUserBean> arrayList = this.students;
        if (arrayList != null) {
            int size = arrayList.size();
            boolean z = false;
            if (1 <= size && size < 4) {
                z = true;
            }
            if (z) {
                gridLayoutManager = new GridLayoutManager(this.mContext, arrayList.size());
            }
        }
        gridLayoutManager.setOrientation(1);
        this.mBinding.rvRandomCallPhotoWall.setLayoutManager((RecyclerView.LayoutManager) gridLayoutManager);
        this.mBinding.rvRandomCallPhotoWall.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.mBinding.rvRandomCallPhotoWall.addItemDecoration(new SpaceItemDecoration(0, 0, 0, 0, 0, 0));
    }

    private final void initializeData() {
        if (this.students == null) {
            setStudents(new ArrayList());
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mAdapter = new RandomCallPhotoWallAdapter(this, context, this.students);
        this.mBinding.rvRandomCallPhotoWall.setAdapter(this.mAdapter);
    }

    private final void initializeRandomSelectNumbers() {
        int length;
        Integer num;
        ArrayList<RandomCallUserBean> arrayList = this.students;
        if (arrayList != null && (length = this.mRandomSelectStudentPositions.length - 1) >= 0) {
            while (true) {
                int i = length - 1;
                if (length == this.mRandomSelectStudentPositions.length - 1) {
                    num = getFinalSelectStudentPosition();
                    if (num == null) {
                        BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView = this;
                        num = Integer.valueOf(new Random().nextInt(arrayList.size()));
                    }
                } else {
                    do {
                        num = Integer.valueOf(new Random().nextInt(arrayList.size()));
                    } while (num.intValue() == this.mRandomSelectStudentPositions[length + 1]);
                }
                if (num != null) {
                    this.mRandomSelectStudentPositions[length] = num.intValue();
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        XesLog.i(TAG, Intrinsics.stringPlus("生成照片墙随机选择学生下标顺序=", GsonUtil.getInstance().objToJson(this.mRandomSelectStudentPositions)));
    }

    private final void startRandomSelectStudentAnimation() {
        Handler handler;
        RandomCallUserBean randomCallUserBean;
        RandomCallUserBean randomCallUserBean2;
        int i = this.mCurrentNumber;
        if (i >= this.mTotalNumber) {
            XesLog.i(TAG, "照片墙随机选择动画结束");
            SoundPoolUtils.play(getContext(), R.raw.live_business_random_call_photo_wall_selected, 0);
            showSelectStudentView();
            return;
        }
        int i2 = i + 1;
        this.mCurrentNumber = i2;
        if (i2 % 2 == 1) {
            SoundPoolUtils.play(getContext(), R.raw.live_business_random_call_photo_wall_select1, 0);
        } else if (i2 % 2 == 0) {
            SoundPoolUtils.play(getContext(), R.raw.live_business_random_call_photo_wall_select2, 0);
        }
        int i3 = this.mCurrentNumber;
        if (i3 > 1) {
            ArrayList<RandomCallUserBean> arrayList = this.students;
            if (!(arrayList == null || (randomCallUserBean2 = arrayList.get(this.mRandomSelectStudentPositions[i3 - 2])) == null)) {
                randomCallUserBean2.setSelected(false);
            }
            refresh(this.mRandomSelectStudentPositions[this.mCurrentNumber - 2]);
        }
        ArrayList<RandomCallUserBean> arrayList2 = this.students;
        if (!(arrayList2 == null || (randomCallUserBean = arrayList2.get(this.mRandomSelectStudentPositions[this.mCurrentNumber - 1])) == null)) {
            randomCallUserBean.setSelected(true);
        }
        refresh(this.mRandomSelectStudentPositions[this.mCurrentNumber - 1]);
        long pow = (long) ((Math.pow((double) (this.mCurrentNumber - 1), 3.0d) / ((double) 6)) + ((double) 100));
        XesLog.i(TAG, "照片墙>>>第" + this.mCurrentNumber + "次选中第" + (this.mRandomSelectStudentPositions[this.mCurrentNumber - 1] + 1) + "个学员停留" + pow + "毫秒");
        if (this.mHandler == null) {
            BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView = this;
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mRandomSelectStudentRunnable == null) {
            BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView2 = this;
            this.mRandomSelectStudentRunnable = new BaseRandomCallPhotoWallPluginView$$ExternalSyntheticLambda1(this);
        }
        Runnable runnable = this.mRandomSelectStudentRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.postDelayed(runnable, pow);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startRandomSelectStudentAnimation$lambda-11$lambda-10  reason: not valid java name */
    public static final void m398startRandomSelectStudentAnimation$lambda11$lambda10(BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView) {
        Intrinsics.checkNotNullParameter(baseRandomCallPhotoWallPluginView, "this$0");
        baseRandomCallPhotoWallPluginView.startRandomSelectStudentAnimation();
    }

    private final void showSelectStudentView() {
        this.mBinding.clRandomCallPhotoWall.setVisibility(8);
        stopAllStream(false);
        this.mBinding.clRandomCallPhotoWallSelect.setVisibility(0);
        RandomCallUserBean randomCallUserBean = this.selected;
        if (randomCallUserBean != null) {
            XesLog.i(TAG, Intrinsics.stringPlus("显示照片墙选中学生=", GsonUtil.getInstance().objToJson(randomCallUserBean)));
            getMBinding().tvSelectStudentLevel.setText(Intrinsics.stringPlus("Lv", randomCallUserBean.getLevel()));
            Integer level = randomCallUserBean.getLevel();
            if (level != null) {
                if (level.intValue() > 0) {
                    int i = 6;
                    getMBinding().tvSelectStudentLevel.setBackgroundResource(this.levelBg[randomCallUserBean.getLevel().intValue() <= 7 ? randomCallUserBean.getLevel().intValue() - 1 : 6]);
                    ImageView imageView = getMBinding().ivStudentLevel;
                    int[] iArr = this.levels;
                    if (randomCallUserBean.getLevel().intValue() <= 7) {
                        i = randomCallUserBean.getLevel().intValue() - 1;
                    }
                    imageView.setImageResource(iArr[i]);
                    getMBinding().rlLevel.setVisibility(0);
                } else {
                    getMBinding().rlLevel.setVisibility(4);
                }
            }
            getMBinding().tvSelectStudentNickname.setText(randomCallUserBean.getNickName());
            ImageLoaderJ.loadCircle(getContext(), randomCallUserBean.getAvatar(), getMBinding().ivUserAvatarSelect, R.drawable.default_image_user);
            getMBinding().studentVideoContainerSelect.setOutlineProvider(new BaseRandomCallPhotoWallPluginView$showSelectStudentView$1$3(this));
            getMBinding().studentVideoContainerSelect.setClipToOutline(true);
            getMBinding().rlRandomCallPhotoWallSelectClose.setOnClickListener(new BaseRandomCallPhotoWallPluginView$$ExternalSyntheticLambda0(this));
            refreshSelectStudentView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSelectStudentView$lambda-16$lambda-15  reason: not valid java name */
    public static final void m397showSelectStudentView$lambda16$lambda15(BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView, View view) {
        Intrinsics.checkNotNullParameter(baseRandomCallPhotoWallPluginView, "this$0");
        RandomCallPhotoWallListener randomCallPhotoWallListener = baseRandomCallPhotoWallPluginView.mRandomCallPhotoWallListener;
        if (randomCallPhotoWallListener != null) {
            randomCallPhotoWallListener.onClickCloseBtn();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void refreshSelectStudentView() {
        RandomCallUserBean finalSelectStudent;
        String uid;
        boolean z;
        RtcUserState remoteState;
        String uid2;
        RandomCallViewModel randomCallViewModel = this.mRandomCallViewModel;
        boolean z2 = true;
        if ((randomCallViewModel != null && randomCallViewModel.isOpenStream()) && (finalSelectStudent = getFinalSelectStudent()) != null) {
            Long userId = finalSelectStudent.getUserId();
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            Long l = null;
            if (Intrinsics.areEqual(userId, (userInfoEntity == null || (uid2 = userInfoEntity.getUid()) == null) ? null : Long.valueOf(Long.parseLong(uid2)))) {
                RtcViewModel rtcViewModel = this.mRtcModel;
                if (rtcViewModel == null || !rtcViewModel.getMLocalVideoEnable()) {
                    z2 = false;
                }
                if (z2) {
                    getMBinding().rlUserAvatarSelect.setVisibility(8);
                } else {
                    getMBinding().rlUserAvatarSelect.setVisibility(0);
                }
            } else {
                Long userId2 = finalSelectStudent.getUserId();
                if (userId2 == null) {
                    z = false;
                } else {
                    long longValue = userId2.longValue();
                    RtcViewModel rtcViewModel2 = this.mRtcModel;
                    z = Intrinsics.areEqual((rtcViewModel2 == null || (remoteState = rtcViewModel2.getRemoteState(longValue)) == null) ? null : Boolean.valueOf(remoteState.getMIsOpenCamera()), true);
                }
                if (z) {
                    getMBinding().rlUserAvatarSelect.setVisibility(8);
                } else {
                    getMBinding().rlUserAvatarSelect.setVisibility(0);
                }
            }
            Long userId3 = finalSelectStudent.getUserId();
            if (userId3 != null) {
                long longValue2 = userId3.longValue();
                TextureView textureView = getTextureView(longValue2);
                if (textureView != null) {
                    if (textureView.getParent() == null) {
                        getMBinding().studentVideoContainerSelect.addView(textureView);
                    } else if (!Intrinsics.areEqual(textureView.getParent(), getMBinding().studentVideoContainerSelect)) {
                        ViewParent parent = textureView.getParent();
                        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                        View view = textureView;
                        ((ViewGroup) parent).removeView(view);
                        getMBinding().studentVideoContainerSelect.addView(view);
                    }
                    Long userId4 = finalSelectStudent.getUserId();
                    UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                    if (!(userInfoEntity2 == null || (uid = userInfoEntity2.getUid()) == null)) {
                        l = Long.valueOf(Long.parseLong(uid));
                    }
                    if (Intrinsics.areEqual(userId4, l)) {
                        RtcViewModel rtcViewModel3 = this.mRtcModel;
                        if (rtcViewModel3 != null) {
                            rtcViewModel3.setUpLocalVideo(textureView);
                        }
                    } else {
                        RtcViewModel rtcViewModel4 = this.mRtcModel;
                        if (rtcViewModel4 != null) {
                            rtcViewModel4.setUpRemoteVideo(textureView, longValue2);
                        }
                    }
                }
                RtcViewModel rtcViewModel5 = this.mRtcModel;
                if (rtcViewModel5 != null) {
                    rtcViewModel5.startRemoteVideo(longValue2);
                }
            }
        }
    }

    private final Integer getFinalSelectStudentPosition() {
        ArrayList<RandomCallUserBean> arrayList = this.students;
        if (arrayList != null) {
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                int i2 = i + 1;
                RandomCallUserBean randomCallUserBean = arrayList.get(i);
                Long userId = randomCallUserBean == null ? null : randomCallUserBean.getUserId();
                RandomCallUserBean selected2 = getSelected();
                if (Intrinsics.areEqual(userId, selected2 == null ? null : selected2.getUserId())) {
                    return Integer.valueOf(i);
                }
                i = i2;
            }
        }
        return null;
    }

    private final RandomCallUserBean getFinalSelectStudent() {
        Long l;
        ArrayList<RandomCallUserBean> arrayList = this.students;
        if (arrayList != null) {
            Iterator<RandomCallUserBean> it = arrayList.iterator();
            while (it.hasNext()) {
                RandomCallUserBean next = it.next();
                if (next == null) {
                    l = null;
                } else {
                    l = next.getUserId();
                }
                RandomCallUserBean selected2 = getSelected();
                if (Intrinsics.areEqual(l, selected2 == null ? null : selected2.getUserId())) {
                    return next;
                }
            }
        }
        return null;
    }

    public void refresh(int i) {
        if (this.mBinding.clRandomCallPhotoWall.getVisibility() == 0) {
            RandomCallPhotoWallAdapter randomCallPhotoWallAdapter = this.mAdapter;
            if (randomCallPhotoWallAdapter != null) {
                randomCallPhotoWallAdapter.notifyItemChanged(i);
            }
        } else if (this.mBinding.clRandomCallPhotoWallSelect.getVisibility() == 0) {
            refreshSelectStudentView();
        }
    }

    public void destroy(boolean z) {
        Handler handler;
        Runnable runnable = this.mRandomSelectStudentRunnable;
        if (!(runnable == null || (handler = this.mHandler) == null)) {
            handler.removeCallbacks(runnable);
        }
        stopAllStream(z);
    }

    public final TextureView getTextureView(long j) {
        TextureView textureView = this.mTextureHashMap.get(Long.valueOf(j));
        if (textureView == null) {
            RtcViewModel rtcViewModel = this.mRtcModel;
            textureView = rtcViewModel == null ? null : rtcViewModel.createTextureView();
            if (textureView != null) {
                TextureView put = this.mTextureHashMap.put(Long.valueOf(j), textureView);
            }
        }
        return textureView;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void stopAllStream(boolean r9) {
        /*
            r8 = this;
            com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel r0 = r8.mRandomCallViewModel
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r0 = r2
            goto L_0x000f
        L_0x0008:
            boolean r0 = r0.isOpenStream()
            if (r0 != r1) goto L_0x0006
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x00a8
            java.util.ArrayList<com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean> r0 = r8.students
            if (r0 != 0) goto L_0x0017
            goto L_0x00a8
        L_0x0017:
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x00a8
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00a8
            java.lang.Object r3 = r0.next()
            com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean r3 = (com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean) r3
            if (r3 == 0) goto L_0x0021
            r4 = 0
            if (r9 != 0) goto L_0x0048
            java.lang.Long r5 = r3.getUserId()
            com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean r6 = r8.getSelected()
            if (r6 != 0) goto L_0x003e
            r6 = r4
            goto L_0x0042
        L_0x003e:
            java.lang.Long r6 = r6.getUserId()
        L_0x0042:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 != 0) goto L_0x0021
        L_0x0048:
            java.lang.Long r5 = r3.getUserId()
            if (r5 != 0) goto L_0x0050
            r5 = r4
            goto L_0x005a
        L_0x0050:
            java.lang.Number r5 = (java.lang.Number) r5
            long r5 = r5.longValue()
            android.view.TextureView r5 = r8.getTextureView(r5)
        L_0x005a:
            if (r5 != 0) goto L_0x005d
            goto L_0x0070
        L_0x005d:
            android.view.ViewParent r6 = r5.getParent()
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x0068
            r4 = r6
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x0068:
            if (r4 != 0) goto L_0x006b
            goto L_0x0070
        L_0x006b:
            android.view.View r5 = (android.view.View) r5
            r4.removeView(r5)
        L_0x0070:
            java.lang.Long r3 = r3.getUserId()
            if (r3 != 0) goto L_0x0077
            goto L_0x0021
        L_0x0077:
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r5 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r5 = r5.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r5 = r5.getUserInfoEntity()
            if (r5 != 0) goto L_0x008b
        L_0x0089:
            r5 = r2
            goto L_0x009b
        L_0x008b:
            java.lang.String r5 = r5.getUid()
            if (r5 != 0) goto L_0x0092
            goto L_0x0089
        L_0x0092:
            long r5 = java.lang.Long.parseLong(r5)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0089
            r5 = r1
        L_0x009b:
            if (r5 != 0) goto L_0x0021
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r5 = r8.mRtcModel
            if (r5 != 0) goto L_0x00a3
            goto L_0x0021
        L_0x00a3:
            r5.stopRemoteVideo(r3)
            goto L_0x0021
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.randomcallnew.view.BaseRandomCallPhotoWallPluginView.stopAllStream(boolean):void");
    }
}
