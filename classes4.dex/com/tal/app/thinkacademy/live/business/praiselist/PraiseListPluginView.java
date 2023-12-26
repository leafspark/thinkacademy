package com.tal.app.thinkacademy.live.business.praiselist;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.PermissionHelper;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.irc.IrcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.irc.IrcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding;
import com.tal.app.thinkacademy.live.business.praiselist.adapter.PraiseListAdapter;
import com.tal.app.thinkacademy.live.business.praiselist.bean.PraiseListData;
import com.tal.app.thinkacademy.live.business.praiselist.bean.PraiseListUserData;
import com.tal.app.thinkacademy.live.business.praiselist.delegate.AnimDelegate;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnimGroup;
import com.tal.app.thinkcademy.lib.commui.widget.likegroup.LikeMessage;
import com.tal.app.thinkcademy.lib.commui.widget.likegroup.PraiseController;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\rH\u0014J\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\rJ\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J \u00101\u001a\u00020\r2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0006\u00105\u001a\u00020\rH\u0002J\u0016\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/PraiseListPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutPraiseListGroupBinding;", "context", "Landroid/content/Context;", "data", "Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListData;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListData;)V", "getData", "()Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListData;", "mAnimDelegate", "Lcom/tal/app/thinkacademy/live/business/praiselist/delegate/AnimDelegate;", "mHasSelf", "", "mIrcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/irc/IrcViewModel;", "mPraiseController", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/PraiseController;", "mPraiseListViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/PraiseListViewModel;", "mStuListAdapter", "Lcom/tal/app/thinkacademy/live/business/praiselist/adapter/PraiseListAdapter;", "addLikeMessage", "", "interactId", "", "msg", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "destroy", "refreshLayout", "height", "", "requestSavePermission", "screenshotData", "bitmap", "Landroid/graphics/Bitmap;", "screenshotSaveCall", "success", "screenshotToLocal", "setupButton", "setupFlyView", "setupStuList", "setupTitle", "sortStuList", "list", "", "Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListUserData;", "moveToFirst", "update", "isForward", "showStudentNum", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListPluginView.kt */
public final class PraiseListPluginView extends BaseInteractBoxPluginView<LayoutPraiseListGroupBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IRC_TYPE_ROOM = "praise_list_point_like";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PRAISE_LIST;
    private final PraiseListData data;
    private AnimDelegate mAnimDelegate = new AnimDelegate();
    private boolean mHasSelf;
    /* access modifiers changed from: private */
    public IrcViewModel mIrcViewModel = IrcViewModelKt.getIrcViewModel(AbilityPack.Companion.get());
    private PraiseController mPraiseController = new PraiseController();
    /* access modifiers changed from: private */
    public PraiseListViewModel mPraiseListViewModel = PraiseListViewModelKt.getPraiseListViewModel(AbilityPack.Companion.get());
    private PraiseListAdapter mStuListAdapter;

    public final PraiseListData getData() {
        return this.data;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PraiseListPluginView(Context context, PraiseListData praiseListData) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(praiseListData, "data");
        this.data = praiseListData;
        setupTitle();
        setupButton();
        setupStuList();
        setupFlyView();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/PraiseListPluginView$Companion;", "", "()V", "IRC_TYPE_ROOM", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseListPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LayoutPraiseListGroupBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutPraiseListGroupBinding inflate = LayoutPraiseListGroupBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    private final void setupTitle() {
        LottieAnimationView lottieAnimationView = this.mBinding.layoutContent.lottieView;
        boolean z = true;
        String stringPlus = Intrinsics.stringPlus("praise_list_lottie_", Integer.valueOf(((getData().getPraiseType() - 1) % 3) + 1));
        lottieAnimationView.setImageAssetsFolder(Intrinsics.stringPlus(stringPlus, "/images"));
        lottieAnimationView.setAnimation(Intrinsics.stringPlus(stringPlus, "/data.json"));
        lottieAnimationView.playAnimation();
        lottieAnimationView.setRepeatCount(-1);
        this.mBinding.layoutContent.tvListTitle.setText(this.data.getFirstTitle());
        ViewGroup.LayoutParams layoutParams = this.mBinding.layoutContent.tvListTitle.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            CharSequence secondTitle = getData().getSecondTitle();
            if (!(secondTitle == null || secondTitle.length() == 0)) {
                z = false;
            }
            if (z) {
                marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.size_90dp);
            } else {
                marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.size_74dp);
            }
        }
        this.mBinding.layoutContent.tvListSubTitle.setText(this.data.getSecondTitle());
        this.mBinding.layoutContent.tvTopInfoLevel.setText(this.data.getLessonName());
        this.mBinding.layoutContent.tvTopInfoClass.setText(this.data.getCourseName());
        this.mBinding.layoutContent.tvTopInfoDate.setText(this.data.getDate());
    }

    private final void setupButton() {
        AnimDelegate animDelegate = this.mAnimDelegate;
        ImageView imageView = this.mBinding.ivLike;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.ivLike");
        ImageView imageView2 = this.mBinding.ivDownload;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.ivDownload");
        animDelegate.startBreathingAnim(imageView, imageView2);
        this.mBinding.ivLike.setOnClickListener(new PraiseListPluginView$$ExternalSyntheticLambda0(this));
        this.mBinding.ivDownload.setOnClickListener(new PraiseListPluginView$$ExternalSyntheticLambda1(this));
        this.mBinding.ivScreenshot.setOutlineProvider(new PraiseListPluginView$setupButton$3());
        this.mBinding.ivScreenshot.setClipToOutline(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButton$lambda-2  reason: not valid java name */
    public static final void m384setupButton$lambda2(PraiseListPluginView praiseListPluginView, View view) {
        Intrinsics.checkNotNullParameter(praiseListPluginView, "this$0");
        SoundPoolUtils.play(praiseListPluginView.getContext(), R.raw.live_business_praise_list_click, 0);
        AnimDelegate animDelegate = praiseListPluginView.mAnimDelegate;
        Intrinsics.checkNotNullExpressionValue(view, "it");
        animDelegate.startClickAnim(view);
        PraiseController praiseController = praiseListPluginView.mPraiseController;
        PraiseListViewModel praiseListViewModel = praiseListPluginView.mPraiseListViewModel;
        praiseController.userClickLike(praiseListViewModel == null ? null : praiseListViewModel.getUserAvatar());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButton$lambda-3  reason: not valid java name */
    public static final void m385setupButton$lambda3(PraiseListPluginView praiseListPluginView, View view) {
        Intrinsics.checkNotNullParameter(praiseListPluginView, "this$0");
        SoundPoolUtils.play(praiseListPluginView.getContext(), R.raw.live_business_praise_list_click, 0);
        AnimDelegate animDelegate = praiseListPluginView.mAnimDelegate;
        Intrinsics.checkNotNullExpressionValue(view, "it");
        animDelegate.startClickAnim(view);
        XesLog.i(TAG, "截图点击，判断存储权限");
        praiseListPluginView.requestSavePermission();
        LiveTrack.INSTANCE.praiseListDownload(praiseListPluginView.data.getInteractId());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void requestSavePermission() {
        if (PermissionUtils.isGranted("android.permission.WRITE_EXTERNAL_STORAGE")) {
            XesLog.i(TAG, "已经获取了存储权限，开始截图");
            screenshotToLocal();
            return;
        }
        XesLog.i(TAG, "未获取存储权限，开始申请权限");
        PermissionHelper permissionHelper = PermissionHelper.INSTANCE;
        FragmentActivity context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        permissionHelper.request(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new PraiseListPluginView$requestSavePermission$1(this));
    }

    /* access modifiers changed from: private */
    public final void screenshotToLocal() {
        ImageView imageView = this.mBinding.layoutContent.ivInfoSignet;
        imageView.setVisibility(0);
        PraiseListViewModel praiseListViewModel = this.mPraiseListViewModel;
        if (praiseListViewModel != null) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View root = this.mBinding.layoutContent.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mBinding.layoutContent.root");
            praiseListViewModel.screenshot(context, root);
        }
        this.mBinding.bgScreenshot.setVisibility(0);
        AnimDelegate animDelegate = this.mAnimDelegate;
        View view = this.mBinding.bgScreenshotWhite;
        Intrinsics.checkNotNullExpressionValue(view, "mBinding.bgScreenshotWhite");
        View view2 = this.mBinding.bgScreenshot;
        Intrinsics.checkNotNullExpressionValue(view2, "mBinding.bgScreenshot");
        View view3 = this.mBinding.layoutScreenshot;
        Intrinsics.checkNotNullExpressionValue(view3, "mBinding.layoutScreenshot");
        animDelegate.startScreenshotAnim(view, view2, view3, 120);
    }

    private final void setupStuList() {
        boolean z = this.data.getPraiseType() == 1 || this.data.getPraiseType() == 2;
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("系统榜单：", Boolean.valueOf(z)));
        this.mHasSelf = sortStuList(this.data.getStudentList(), z);
        if (this.data.getPublishType() != 1 || !this.mHasSelf) {
            this.mBinding.ivDownload.setVisibility(8);
        } else {
            this.mBinding.ivDownload.setVisibility(0);
        }
        Collection studentList = this.data.getStudentList();
        if (studentList == null || studentList.isEmpty()) {
            XesLog.e(tag, "列表数据为空");
            this.mBinding.layoutContent.emptyView.setVisibility(0);
            this.mBinding.ivLike.setVisibility(8);
            this.mBinding.tvLikeCount.setVisibility(8);
            this.mBinding.layoutContent.rvStuList.setVisibility(8);
            this.mBinding.layoutContent.btGroupLine1.setVisibility(8);
            this.mBinding.layoutContent.btGroupLine2.setVisibility(8);
            this.mBinding.layoutContent.btGroupLine3.setVisibility(8);
            return;
        }
        this.mBinding.layoutContent.emptyView.setVisibility(8);
        this.mBinding.ivLike.setVisibility(0);
        this.mBinding.tvLikeCount.setVisibility(0);
        RecyclerView.Adapter praiseListAdapter = new PraiseListAdapter(this.data.getStudentList());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        int size = this.data.getStudentList().size();
        if (1 <= size && size < 4) {
            praiseListAdapter.setAllType(0);
            gridLayoutManager.setSpanCount(size);
            int dp2px = SizeUtils.dp2px(45.0f);
            this.mBinding.layoutContent.rvStuList.setPadding(dp2px, SizeUtils.dp2px(90.0f), dp2px, 0);
            this.mBinding.layoutContent.btGroupLine1.setVisibility(0);
            this.mBinding.layoutContent.btGroupLine2.setVisibility(8);
            this.mBinding.layoutContent.btGroupLine3.setVisibility(8);
        } else {
            if (4 <= size && size < 11) {
                praiseListAdapter.setAllType(1);
                gridLayoutManager.setSpanCount(5);
                int dp2px2 = SizeUtils.dp2px(30.0f);
                this.mBinding.layoutContent.rvStuList.setPadding(dp2px2, SizeUtils.dp2px(12.0f), dp2px2, 0);
                this.mBinding.layoutContent.btGroupLine1.setVisibility(8);
                this.mBinding.layoutContent.btGroupLine2.setVisibility(0);
                this.mBinding.layoutContent.btGroupLine3.setVisibility(0);
            } else {
                if (11 <= size && size < 21) {
                    praiseListAdapter.setAllType(2);
                    gridLayoutManager.setSpanCount(4);
                    int dp2px3 = SizeUtils.dp2px(22.0f);
                    this.mBinding.layoutContent.rvStuList.setPadding(dp2px3, SizeUtils.dp2px(14.0f), dp2px3, 0);
                    this.mBinding.layoutContent.btGroupLine1.setVisibility(8);
                    this.mBinding.layoutContent.btGroupLine2.setVisibility(8);
                    this.mBinding.layoutContent.btGroupLine3.setVisibility(8);
                } else {
                    praiseListAdapter.setAllType(3);
                    gridLayoutManager.setSpanCount(5);
                    int dp2px4 = SizeUtils.dp2px(30.0f);
                    this.mBinding.layoutContent.rvStuList.setPadding(dp2px4, SizeUtils.dp2px(14.0f), dp2px4, 0);
                    this.mBinding.layoutContent.btGroupLine1.setVisibility(8);
                    this.mBinding.layoutContent.btGroupLine2.setVisibility(8);
                    this.mBinding.layoutContent.btGroupLine3.setVisibility(8);
                }
            }
        }
        PraiseListViewModel praiseListViewModel = this.mPraiseListViewModel;
        praiseListAdapter.setSelfId(praiseListViewModel == null ? null : praiseListViewModel.getUserId());
        if (this.data.getPublishType() == 2) {
            praiseListAdapter.openShowAnim(true, this.data.getShowStudentNum());
        }
        RecyclerView recyclerView = this.mBinding.layoutContent.rvStuList;
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(praiseListAdapter);
        this.mStuListAdapter = praiseListAdapter;
    }

    private final void setupFlyView() {
        PraiseController praiseController = this.mPraiseController;
        FlyAnimGroup flyAnimGroup = this.mBinding.flyAnimGroup;
        Intrinsics.checkNotNullExpressionValue(flyAnimGroup, "mBinding.flyAnimGroup");
        praiseController.bindFlyAnimGroup(flyAnimGroup);
        PraiseController praiseController2 = this.mPraiseController;
        TextView textView = this.mBinding.tvLikeCount;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.tvLikeCount");
        praiseController2.bindLikeCountView(textView);
        this.mBinding.flyAnimGroup.setFlyElements(new Integer[]{Integer.valueOf(R.drawable.ic_live_business_praise_list_like_element_1), Integer.valueOf(R.drawable.ic_live_business_praise_list_like_element_2), Integer.valueOf(R.drawable.ic_live_business_praise_list_like_element_3), Integer.valueOf(R.drawable.ic_live_business_praise_list_like_element_4)});
        this.mPraiseController.setUserClickEnd(new PraiseListPluginView$setupFlyView$1(this));
        this.mPraiseController.startPoll();
        XesLog.i(TAG, "开启点赞队列轮询");
    }

    private final boolean sortStuList(List<PraiseListUserData> list, boolean z) {
        int i;
        PraiseListUserData remove;
        PraiseListViewModel praiseListViewModel = this.mPraiseListViewModel;
        String userId = praiseListViewModel == null ? null : praiseListViewModel.getUserId();
        if (list == null) {
            i = -1;
        } else {
            int i2 = 0;
            i = -1;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((PraiseListUserData) next).getStudentId(), userId)) {
                    i = i2;
                }
                i2 = i3;
            }
        }
        if (i > -1 && z && list != null && (remove = list.remove(i)) != null) {
            list.add(0, remove);
        }
        if (i > -1) {
            return true;
        }
        return false;
    }

    public final void screenshotData(Bitmap bitmap) {
        this.mBinding.layoutContent.ivInfoSignet.setVisibility(8);
        if (bitmap == null) {
            XesLog.e(TAG, "截屏失败");
            return;
        }
        XesLog.s(TAG, "截屏成功");
        this.mBinding.ivScreenshot.setImageBitmap(bitmap);
    }

    public final void screenshotSaveCall(boolean z) {
        if (z) {
            ToastUtils.showLong(getContext().getString(R.string.player_save_screenshot_success), new Object[0]);
        }
    }

    public final void addLikeMessage(String str, LikeMessage likeMessage) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(likeMessage, "msg");
        if (!Intrinsics.areEqual(str, this.data.getInteractId())) {
            XesLog.e(TAG, Intrinsics.stringPlus("点赞消息，与当前互动不匹配 current:", this.data.getInteractId()));
            return;
        }
        XesLog.i(TAG, "添加点赞消息");
        this.mPraiseController.addQueueMessage(likeMessage);
    }

    public final void update(boolean z, int i) {
        PraiseListAdapter praiseListAdapter = this.mStuListAdapter;
        if (praiseListAdapter != null) {
            praiseListAdapter.updateShowStuNum(z, i);
        }
        PraiseListAdapter praiseListAdapter2 = this.mStuListAdapter;
        if (!(praiseListAdapter2 != null && i == praiseListAdapter2.getItemCount()) || !this.mHasSelf) {
            this.mBinding.ivDownload.setVisibility(8);
        } else {
            this.mBinding.ivDownload.setVisibility(0);
        }
    }

    public final void refreshLayout(int i) {
        ViewScaleUtil.scale(this.mBinding.getRoot(), (((float) i) * 1.0f) / ((float) SizeUtils.dp2px(645.0f)), 0, 0);
    }

    public final void destroy() {
        this.mAnimDelegate.destroy();
        this.mPraiseController.destroy();
        this.mPraiseListViewModel = null;
        this.mStuListAdapter = null;
    }
}
