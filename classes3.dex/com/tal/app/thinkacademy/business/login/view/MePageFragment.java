package com.tal.app.thinkacademy.business.login.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.MeItemAdapter;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding;
import com.tal.app.thinkacademy.business.login.entity.BannersData;
import com.tal.app.thinkacademy.business.login.entity.Resource;
import com.tal.app.thinkacademy.business.login.presenter.MePageViewModel;
import com.tal.app.thinkacademy.business.login.view.item.MyPageRecyclerItem;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.MyCardView;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.BaseVmFragment;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.InitEntryInfoBean;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.user.BasicUserInfo;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.common.utils.ViewUtilKt;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001JB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\"\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020+H\u0016J\b\u00103\u001a\u00020#H\u0003J\b\u00104\u001a\u00020#H\u0016J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020 H\u0002J\u001a\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0002J\b\u0010>\u001a\u00020#H\u0002J\b\u0010?\u001a\u00020#H\u0017J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u00020#H\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020#H\u0002J\b\u0010F\u001a\u00020#H\u0002J\b\u0010G\u001a\u00020#H\u0002J\b\u0010H\u001a\u00020#H\u0002J\u0012\u0010I\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/MePageFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "Lcom/tal/app/thinkacademy/business/login/presenter/MePageViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/LayoutMeFragmentBinding;", "Landroid/view/View$OnClickListener;", "()V", "countryCallCode", "", "mBannersData", "Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "mFootView", "Landroid/view/View;", "getMFootView", "()Landroid/view/View;", "mFootView$delegate", "Lkotlin/Lazy;", "mInitEntryInfoBean", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/business/login/view/item/MyPageRecyclerItem;", "Lkotlin/collections/ArrayList;", "mMyPageRecyclerItem", "mShoppingMallList", "mUserInfo", "Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "phoneNum", "rvAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/MeItemAdapter;", "unpayNum", "", "userAvatar", "addFootView", "", "checkShoppingMallReviewed", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "", "initTimeZone", "initView", "isNetWorked", "onClick", "v", "onHiddenChanged", "hidden", "onRefreshUserInfo", "onResume", "onUnpaid", "num", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "saveUserInfo", "setItemDetail", "setListener", "setRecyclerView", "startObserve", "startUserInfo", "path", "timeZoneTipShow", "track", "key", "track_click_coins", "updateCoins", "updateUnpayNum", "uploadLog", "userLoginIn", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
public final class MePageFragment extends BaseVmFragment<MePageViewModel, LayoutMeFragmentBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MENU_ABOUT_US = "About Us";
    private static final String MENU_COURSE_TESTING = "COURSE_TESTING";
    private static final String MENU_CUSTOMER_SUPPORT = "Customer Support";
    private static final String MENU_FEEDBACK = "FEEDBACK";
    private static final String MENU_MY_COINS = "My Coins";
    private static final String MENU_MY_ORDERS = "My orders";
    private static final String MENU_PLACEMENT_TEST = "Placement Test";
    private static final String MENU_SETTINGS = "SETTINGS";
    public static final int ROUND_TYPE_ALL = 3;
    public static final int ROUND_TYPE_BOTTOM = 2;
    public static final int ROUND_TYPE_NORMAL = 0;
    public static final int ROUND_TYPE_TOP = 1;
    private String countryCallCode;
    /* access modifiers changed from: private */
    public BannersData mBannersData;
    private final Lazy mFootView$delegate = LazyKt.lazy(new MePageFragment$mFootView$2(this));
    private InitEntryInfoBean mInitEntryInfoBean;
    private LinearLayoutManager mLayoutManager;
    /* access modifiers changed from: private */
    public ArrayList<MyPageRecyclerItem> mList = new ArrayList<>();
    private MyPageRecyclerItem mMyPageRecyclerItem;
    private ArrayList<MyPageRecyclerItem> mShoppingMallList = new ArrayList<>();
    private BasicUserInfo mUserInfo;
    private String phoneNum;
    private MeItemAdapter rvAdapter;
    private int unpayNum;
    private String userAvatar;

    private final void updateCoins() {
    }

    private final View getMFootView() {
        Object value = this.mFootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mFootView>(...)");
        return (View) value;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/MePageFragment$Companion;", "", "()V", "MENU_ABOUT_US", "", "MENU_COURSE_TESTING", "MENU_CUSTOMER_SUPPORT", "MENU_FEEDBACK", "MENU_MY_COINS", "MENU_MY_ORDERS", "MENU_PLACEMENT_TEST", "MENU_SETTINGS", "ROUND_TYPE_ALL", "", "ROUND_TYPE_BOTTOM", "ROUND_TYPE_NORMAL", "ROUND_TYPE_TOP", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MePageFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LayoutMeFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutMeFragmentBinding inflate = LayoutMeFragmentBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, attach)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        MePageFragment.super.onViewCreated(view, bundle);
        initView();
        setListener();
        setItemDetail();
        setRecyclerView();
        updateCoins();
        updateUnpayNum();
        track("my_homepage_pv");
        checkShoppingMallReviewed();
        initTimeZone();
    }

    public void onResume() {
        MePageFragment.super.onResume();
        if (isVisible()) {
            onRefreshUserInfo();
        }
        checkShoppingMallReviewed();
    }

    public void onHiddenChanged(boolean z) {
        String str = this.TAG;
        XesLog.dt(str, new Object[]{"我的首页>>>onHiddenChanged,isHidden=" + z + "，isViewCreated=" + getMIsViewCreated()});
        if (getMIsViewCreated()) {
            MePageFragment.super.onHiddenChanged(z);
            if (!z) {
                onRefreshUserInfo();
            }
        }
    }

    public void startObserve() {
        MePageFragment.super.startObserve();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getBasicUserInfoData().observe(lifecycleOwner, new MePageFragment$$ExternalSyntheticLambda2(this));
        getMViewModel().getInitEntryInfoData().observe(lifecycleOwner, new MePageFragment$$ExternalSyntheticLambda3(this));
        getMViewModel().getBannersData().observe(lifecycleOwner, new MePageFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m86startObserve$lambda0(MePageFragment mePageFragment, StateData stateData) {
        MePageFragment mePageFragment2 = mePageFragment;
        Intrinsics.checkNotNullParameter(mePageFragment2, "this$0");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS && stateData.getData() != null) {
            mePageFragment2.mUserInfo = (BasicUserInfo) stateData.getData();
            Context context = mePageFragment.getmActivity();
            BasicUserInfo basicUserInfo = mePageFragment2.mUserInfo;
            Integer num = null;
            ImageLoaderJ.loadCircle(context, basicUserInfo == null ? null : basicUserInfo.getAvatar(), mePageFragment.getBinding().ivUser, R.drawable.self_image_user);
            TextView textView = mePageFragment.getBinding().tvName;
            BasicUserInfo basicUserInfo2 = mePageFragment2.mUserInfo;
            textView.setText(basicUserInfo2 == null ? null : basicUserInfo2.getNickName());
            TextView textView2 = mePageFragment.getBinding().tvCoinsAmount;
            BasicUserInfo basicUserInfo3 = mePageFragment2.mUserInfo;
            textView2.setText(Intrinsics.stringPlus("", basicUserInfo3 == null ? null : basicUserInfo3.getCoinAmount()));
            TextView textView3 = mePageFragment.getBinding().tvCard;
            CharSequence[] charSequenceArr = new CharSequence[2];
            charSequenceArr[0] = mePageFragment2.getString(R.string.no_with_dot);
            BasicUserInfo basicUserInfo4 = mePageFragment2.mUserInfo;
            charSequenceArr[1] = basicUserInfo4 == null ? null : basicUserInfo4.getCardNo();
            textView3.setText(TextUtils.concat(charSequenceArr));
            BasicUserInfo basicUserInfo5 = mePageFragment2.mUserInfo;
            String firstName = basicUserInfo5 == null ? null : basicUserInfo5.getFirstName();
            BasicUserInfo basicUserInfo6 = mePageFragment2.mUserInfo;
            String lastName = basicUserInfo6 == null ? null : basicUserInfo6.getLastName();
            BasicUserInfo basicUserInfo7 = mePageFragment2.mUserInfo;
            if (basicUserInfo7 != null) {
                num = basicUserInfo7.getGradeId();
            }
            if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || num == null) {
                mePageFragment.getBinding().groupEdit.setVisibility(0);
                LeanplumUtil.longTrack$default("change_profile_guide_show", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
            } else {
                mePageFragment.getBinding().groupEdit.setVisibility(8);
            }
            mePageFragment.saveUserInfo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    public static final void m87startObserve$lambda2(MePageFragment mePageFragment, StateData stateData) {
        Integer latestCoin;
        String num;
        Intrinsics.checkNotNullParameter(mePageFragment, "this$0");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS && stateData.getData() != null) {
            mePageFragment.mInitEntryInfoBean = (InitEntryInfoBean) stateData.getData();
            Collection collection = mePageFragment.mList;
            if (!(collection == null || collection.isEmpty())) {
                int i = 0;
                for (Object next : mePageFragment.mList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    MyPageRecyclerItem myPageRecyclerItem = (MyPageRecyclerItem) next;
                    if (Intrinsics.areEqual((Object) myPageRecyclerItem.getKey(), (Object) MENU_MY_COINS)) {
                        SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
                        myPageRecyclerItem.setRightResId(currentSchoolInfo != null && currentSchoolInfo.getCoinStoreEnabled() ? R.drawable.icon_arrow_right_banner : -1);
                        String str = "0";
                        if (!UserInfoBll.Companion.getInstance().isGuest()) {
                            InitEntryInfoBean initEntryInfoBean = mePageFragment.mInitEntryInfoBean;
                            if (!(initEntryInfoBean == null || (latestCoin = initEntryInfoBean.getLatestCoin()) == null || (num = latestCoin.toString()) == null)) {
                                str = num;
                            }
                        } else {
                            str = "";
                        }
                        myPageRecyclerItem.setTvRightContent(str);
                        MeItemAdapter meItemAdapter = mePageFragment.rvAdapter;
                        if (meItemAdapter != null) {
                            meItemAdapter.notifyItemChanged(i);
                        }
                    }
                    i = i2;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-5  reason: not valid java name */
    public static final void m88startObserve$lambda5(MePageFragment mePageFragment, StateData stateData) {
        List list;
        List<Resource> resources;
        Resource resource;
        Long resId;
        List<Resource> resources2;
        Resource resource2;
        String src;
        Intrinsics.checkNotNullParameter(mePageFragment, "this$0");
        Context context = mePageFragment.getContext();
        if (context == null) {
            ViewUtilKt.goneView(mePageFragment.getBinding().ivBanner);
        } else if (stateData.getStatus() == StateData.DataStatus.SUCCESS && stateData.getData() != null && stateData != null && (list = (List) stateData.getData()) != null) {
            if (!list.isEmpty()) {
                Collection resources3 = ((BannersData) list.get(0)).getResources();
                if (!(resources3 == null || resources3.isEmpty())) {
                    mePageFragment.mBannersData = (BannersData) list.get(0);
                    XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
                    ImageView imageView = mePageFragment.getBinding().ivBanner;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivBanner");
                    BannersData bannersData = mePageFragment.mBannersData;
                    String str = "";
                    if (!(bannersData == null || (resources2 = bannersData.getResources()) == null || (resource2 = resources2.get(0)) == null || (src = resource2.getSrc()) == null)) {
                        str = src;
                    }
                    XesImageLoader.loadRoundCornerImage$default(xesImageLoader, imageView, context, str, 0, 0, 0, (RoundedCornersTransformation.CornerType) null, 48, (Object) null);
                    ViewUtilKt.showView(mePageFragment.getBinding().ivBanner);
                    LoginTrack loginTrack = LoginTrack.INSTANCE;
                    BannersData bannersData2 = mePageFragment.mBannersData;
                    long j = 0;
                    if (!(bannersData2 == null || (resources = bannersData2.getResources()) == null || (resource = resources.get(0)) == null || (resId = resource.getResId()) == null)) {
                        j = resId.longValue();
                    }
                    loginTrack.showBanner(j);
                    return;
                }
            }
            ViewUtilKt.goneView(mePageFragment.getBinding().ivBanner);
        }
    }

    private final void setRecyclerView() {
        this.rvAdapter = new MeItemAdapter(this.mList, new MePageFragment$setRecyclerView$1(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        getBinding().rvShowDetail.setLayoutManager(this.mLayoutManager);
        getBinding().rvShowDetail.setAdapter(this.rvAdapter);
        getBinding().rvShowDetail.addItemDecoration(new MePageFragment$setRecyclerView$2(this));
        addFootView();
    }

    private final void addFootView() {
        BaseQuickAdapter baseQuickAdapter;
        View mFootView = getMFootView();
        MeItemAdapter meItemAdapter = this.rvAdapter;
        boolean z = false;
        if (meItemAdapter != null && !meItemAdapter.hasFooterLayout()) {
            z = true;
        }
        if (z && (baseQuickAdapter = this.rvAdapter) != null) {
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, mFootView, 0, 0, 6, (Object) null);
        }
    }

    private final void checkShoppingMallReviewed() {
        try {
            boolean shoppingMallReviewed = UserInfoBll.Companion.getInstance().getShoppingMallReviewed();
            XesLog.dt(this.TAG, new Object[]{Intrinsics.stringPlus("checkShoppingMallReviewed  = ", Boolean.valueOf(shoppingMallReviewed))});
            if (shoppingMallReviewed) {
                ArrayList<MyPageRecyclerItem> arrayList = this.mList;
                if (arrayList != null) {
                    if (!arrayList.containsAll(this.mShoppingMallList)) {
                        arrayList.addAll(1, this.mShoppingMallList);
                        arrayList.get(0).setLocal_round_type(1);
                        MeItemAdapter meItemAdapter = this.rvAdapter;
                        if (meItemAdapter != null) {
                            meItemAdapter.notifyDataSetChanged();
                        }
                    }
                }
                getBinding().cardParent.setVisibility(0);
                getBinding().cardSpace.setVisibility(8);
                return;
            }
            ArrayList<MyPageRecyclerItem> arrayList2 = this.mList;
            if (arrayList2.containsAll(this.mShoppingMallList)) {
                arrayList2.removeAll(this.mShoppingMallList);
                arrayList2.get(0).setLocal_round_type(3);
                MeItemAdapter meItemAdapter2 = this.rvAdapter;
                if (meItemAdapter2 != null) {
                    meItemAdapter2.notifyDataSetChanged();
                }
            }
            getBinding().cardParent.setVisibility(8);
            if (UserInfoBll.Companion.getInstance().isGuest()) {
                getBinding().cardSpace.setVisibility(0);
            }
        } catch (Exception e) {
            XesLog.dt(this.TAG, new Object[]{Intrinsics.stringPlus("checkShoppingMallReviewed,error=", e)});
        }
    }

    private final void initTimeZone() {
        View view = getBinding().llTimeZoneTip;
        if (view != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view, 500, MePageFragment$initTimeZone$1.INSTANCE);
        }
        timeZoneTipShow();
    }

    private final void setItemDetail() {
        String str;
        String str2;
        Integer latestCoin;
        ArrayList<MyPageRecyclerItem> arrayList = this.mList;
        if (this.mMyPageRecyclerItem == null) {
            int i = R.drawable.grouping_icon_my_coins;
            String string = getString(R.string.my_coins);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.my_coins)");
            SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
            boolean z = true;
            if (currentSchoolInfo == null || !currentSchoolInfo.getCoinStoreEnabled()) {
                z = false;
            }
            int i2 = z ? R.drawable.icon_arrow_right_banner : -1;
            if (!UserInfoBll.Companion.getInstance().isGuest()) {
                InitEntryInfoBean initEntryInfoBean = this.mInitEntryInfoBean;
                if (initEntryInfoBean == null || (latestCoin = initEntryInfoBean.getLatestCoin()) == null || (str2 = latestCoin.toString()) == null) {
                    str = "0";
                    this.mMyPageRecyclerItem = new MyPageRecyclerItem(MENU_MY_COINS, i, string, i2, str, 3, false, 64, (DefaultConstructorMarker) null);
                }
            } else {
                str2 = "";
            }
            str = str2;
            this.mMyPageRecyclerItem = new MyPageRecyclerItem(MENU_MY_COINS, i, string, i2, str, 3, false, 64, (DefaultConstructorMarker) null);
        }
        if (CollectionsKt.indexOf(this.mList, this.mMyPageRecyclerItem) == -1) {
            MyPageRecyclerItem myPageRecyclerItem = this.mMyPageRecyclerItem;
            Intrinsics.checkNotNull(myPageRecyclerItem);
            arrayList.add(0, myPageRecyclerItem);
        }
        ArrayList<MyPageRecyclerItem> arrayList2 = this.mShoppingMallList;
        int i3 = R.drawable.my_center_icon_wish_list;
        String string2 = getString(R.string.my_wish_list);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(string.my_wish_list)");
        arrayList2.add(new MyPageRecyclerItem(JumpToAgreementUtil.MENU_WISH_LIST, i3, string2, 0, (String) null, 0, false, 120, (DefaultConstructorMarker) null));
        int i4 = R.drawable.my_center_icon_test_result;
        String string3 = getString(R.string.my_test_Results);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(string.my_test_Results)");
        arrayList2.add(new MyPageRecyclerItem(JumpToAgreementUtil.MENU_TEST_RESULTS, i4, string3, 0, (String) null, 0, false, 120, (DefaultConstructorMarker) null));
        int i5 = R.drawable.my_center_icon_transfer;
        String string4 = getString(R.string.my_class_reschedule_transfer);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(string.my_class_reschedule_transfer)");
        arrayList2.add(new MyPageRecyclerItem(JumpToAgreementUtil.MENU_CLASS_TRANSFER, i5, string4, -1, "", 2, false, 64, (DefaultConstructorMarker) null));
        int i6 = R.mipmap.grouping_icon_feedback;
        String string5 = getString(R.string.feedback);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.feedback)");
        arrayList.add(new MyPageRecyclerItem(MENU_FEEDBACK, i6, string5, -1, "", 1, true));
        int i7 = R.mipmap.grouping_icon_test;
        String string6 = getString(R.string.Device_Test);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.Device_Test)");
        arrayList.add(new MyPageRecyclerItem(MENU_COURSE_TESTING, i7, string6, -1, "", 0, false, 64, (DefaultConstructorMarker) null));
        int i8 = R.mipmap.grouping_about_settings;
        String string7 = getString(R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.settings)");
        arrayList.add(new MyPageRecyclerItem(MENU_SETTINGS, i8, string7, -1, "", 2, false, 64, (DefaultConstructorMarker) null));
    }

    private final void onRefreshUserInfo() {
        this.phoneNum = ShareDataManager.getInstance().getString("user_phone", "", ShareDataManager.SHAREDATA_USER);
        this.countryCallCode = ShareDataManager.getInstance().getString("user_country_calling_code", "", ShareDataManager.SHAREDATA_USER);
        this.userAvatar = ShareDataManager.getInstance().getString("user_avatar", getResources().getResourceName(R.drawable.self_image_user), ShareDataManager.SHAREDATA_USER);
        TextView textView = getBinding().tvTimeZone;
        if (textView != null) {
            textView.setText(TimeZoneUtil.INSTANCE.getTimeZone());
        }
        timeZoneTipShow();
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            Intrinsics.checkNotNull(userInfoEntity);
            CharSequence nickName = userInfoEntity.getNickName();
            if (!TextUtils.isEmpty(nickName)) {
                getBinding().tvName.setText(nickName);
            } else {
                getBinding().tvName.setText(R.string.Login_tv_welcome);
            }
            UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            Intrinsics.checkNotNull(userInfoEntity2);
            String card = userInfoEntity2.getCard();
            getBinding().tvCard.setText(TextUtils.concat(new CharSequence[]{getString(R.string.no_with_dot), card}));
            ImageLoaderJ.loadCircle(getmActivity(), this.userAvatar, getBinding().ivUser, R.drawable.self_image_user);
            getBinding().groupUser.setVisibility(0);
            getBinding().groupGuest.setVisibility(8);
            getBinding().ivSwitchAccount.setVisibility(0);
            getMViewModel().getBasicUserInfo();
            getBinding().cardSpace.setVisibility(8);
        } else {
            getBinding().ivSwitchAccount.setVisibility(8);
            getBinding().groupUser.setVisibility(8);
            getBinding().groupGuest.setVisibility(0);
            getBinding().groupEdit.setVisibility(8);
            if (!UserInfoBll.Companion.getInstance().getShoppingMallReviewed()) {
                getBinding().cardSpace.setVisibility(0);
            }
        }
        getMViewModel().initEntryInfoData();
        if (!PadUtils.isPad(Utils.getApp())) {
            getMViewModel().bannersDataData();
        }
    }

    private final void timeZoneTipShow() {
        if (UserInfoBll.Companion.getInstance().isGuest() || !TimeZoneUtil.INSTANCE.isShowTimeZoneBranchSchool()) {
            RoundLinearLayout roundLinearLayout = getBinding().llTimeZoneTip;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(8);
                return;
            }
            return;
        }
        RoundLinearLayout roundLinearLayout2 = getBinding().llTimeZoneTip;
        if (roundLinearLayout2 != null) {
            roundLinearLayout2.setVisibility(0);
        }
    }

    private final void initView() {
        userLoginIn(getBinding().ivUser);
        userLoginIn(getBinding().tvName);
        MyCardView myCardView = getBinding().cardUnpaidCourse;
        int i = R.drawable.my_icon_unpaid_courses;
        String string = getString(R.string.my_card_unpaid_courses);
        Intrinsics.checkNotNullExpressionValue(string, "getString(string.my_card_unpaid_courses)");
        myCardView.setData(i, string, Color.parseColor("#3370FF"), R.drawable.my_card_next_blue, R.drawable.my_card_bottom_unpaid_course);
        MyCardView myCardView2 = getBinding().cardOrders;
        int i2 = R.drawable.my_icon_orders;
        String string2 = getString(R.string.my_card_orders);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.my_card_orders)");
        myCardView2.setData(i2, string2, Color.parseColor("#02CA8A"), R.drawable.my_card_next_green, R.drawable.my_card_bottom_orders);
        MyCardView myCardView3 = getBinding().cardCoupons;
        int i3 = R.drawable.my_icon_coupons;
        String string3 = getString(R.string.my_card_coupons);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.my_card_coupons)");
        myCardView3.setData(i3, string3, Color.parseColor("#FFAA0A"), R.drawable.my_card_next_yellow, R.drawable.my_card_bottom_coupons);
        if (getResources().getConfiguration().orientation == 2) {
            getBinding().tvCorners.getDelegate().setCornerRadius_TL(0);
            getBinding().tvCorners.getDelegate().setCornerRadius_TR(0);
        }
    }

    private final void setListener() {
        View.OnClickListener onClickListener = this;
        getBinding().ivSwitchAccount.setOnClickListener(onClickListener);
        getBinding().ivEdit.setOnClickListener(onClickListener);
        getBinding().tvCopy.setOnClickListener(onClickListener);
        getBinding().tvLogin.setOnClickListener(onClickListener);
        getBinding().cardUnpaidCourse.setOnClickListener(onClickListener);
        getBinding().cardOrders.setOnClickListener(onClickListener);
        getBinding().cardCoupons.setOnClickListener(onClickListener);
        Group group = getBinding().groupUser;
        Intrinsics.checkNotNull(group);
        int[] referencedIds = group.getReferencedIds();
        Intrinsics.checkNotNullExpressionValue(referencedIds, "refIds");
        int length = referencedIds.length;
        int i = 0;
        while (i < length) {
            int i2 = referencedIds[i];
            i++;
            LeanplumUtil.longTrack$default("click_change_profile_guide", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
            if (i2 != R.id.tv_copy) {
                findViewById(i2).setOnClickListener(new MePageFragment$$ExternalSyntheticLambda0(this));
            }
        }
        ImageView imageView = getBinding().ivBanner;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 500, new MePageFragment$setListener$2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-11  reason: not valid java name */
    public static final void m85setListener$lambda11(MePageFragment mePageFragment, View view) {
        Intrinsics.checkNotNullParameter(mePageFragment, "this$0");
        mePageFragment.startUserInfo("click_guide");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void userLoginIn(View view) {
        if (view != null) {
            RxUnDoubleUtil.setOnUnDoubleClickListener$default(RxUnDoubleUtil.INSTANCE, view, 0, new MePageFragment$userLoginIn$1(this), 1, (Object) null);
        }
    }

    private final void startUserInfo(String str) {
        Intent intent = new Intent(getActivity(), PersonalInfoActivity.class);
        Serializable serializable = this.mUserInfo;
        if (serializable != null) {
            intent.putExtra("user_info", serializable);
        }
        intent.putExtra("page_path", str);
        getmActivity().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final boolean isNetWorked() {
        return NetworkUtils.isConnected();
    }

    private final void updateUnpayNum() {
        StickyLiveData with = XesDataBus.with("me_page_unpay_num");
        LifecycleOwner lifecycleOwner = getmActivity();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "getmActivity()");
        with.observerSticky(lifecycleOwner, true, new MePageFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateUnpayNum$lambda-12  reason: not valid java name */
    public static final void m89updateUnpayNum$lambda12(MePageFragment mePageFragment, Integer num) {
        Intrinsics.checkNotNullParameter(mePageFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "it");
        mePageFragment.onUnpaid(num.intValue());
        XesDataBus.remove("me_page_unpay_num");
    }

    private final void saveUserInfo() {
        String str;
        String str2 = null;
        UserBean userBean = new UserBean((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 1023, (DefaultConstructorMarker) null);
        BasicUserInfo basicUserInfo = this.mUserInfo;
        userBean.setUid(basicUserInfo == null ? null : basicUserInfo.getId());
        BasicUserInfo basicUserInfo2 = this.mUserInfo;
        userBean.setAvatar(basicUserInfo2 == null ? null : basicUserInfo2.getAvatar());
        BasicUserInfo basicUserInfo3 = this.mUserInfo;
        userBean.setPhone(basicUserInfo3 == null ? null : basicUserInfo3.getPhone());
        BasicUserInfo basicUserInfo4 = this.mUserInfo;
        userBean.setEmail(basicUserInfo4 == null ? null : basicUserInfo4.getEmail());
        BasicUserInfo basicUserInfo5 = this.mUserInfo;
        userBean.setNickName(basicUserInfo5 == null ? null : basicUserInfo5.getNickName());
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            str = null;
        } else {
            str = userInfoEntity.getUnifiedAccessToken();
        }
        userBean.setUnifiedAccessToken(str);
        BasicUserInfo basicUserInfo6 = this.mUserInfo;
        userBean.setCountryCallingCode(basicUserInfo6 == null ? null : basicUserInfo6.getCountryCallingCode());
        BasicUserInfo basicUserInfo7 = this.mUserInfo;
        if (basicUserInfo7 != null) {
            str2 = basicUserInfo7.getCardNo();
        }
        userBean.setCard(str2);
        UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, MePageFragment.class);
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == R.id.iv_switch_account) {
            if (!UserInfoBll.Companion.getInstance().isGuest()) {
                startActivity(new Intent(getActivity(), MyAccountListActivity.class));
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("login_page_path", "settings");
                XesRoute.getInstance().navigation("/login/login_activity", bundle);
            }
        } else if (id == R.id.tv_login) {
            new Bundle().putString("login_source", "个人中心-头部");
            XesRoute.getInstance().navigation("/login/login_activity");
        } else if (id == R.id.iv_edit) {
            startUserInfo("click_edit");
        } else if (id == R.id.cl_coins) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("jump_key", Intrinsics.stringPlus(ShareDataManager.getInstance().getString("h5_Domain", "", ShareDataManager.SHAREDATA_NOT_CLEAR), "/rewardCoins"));
            bundle2.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle("Coins").build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle2);
            bundle2.clear();
            track_click_coins();
        } else if (id == R.id.tv_copy) {
            try {
                String substring = getBinding().tvCard.getText().toString().substring(3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                ClipboardUtilKt.copyClipboard(getActivity(), substring);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(getString(R.string.copied_successfully), new Object[0]);
        } else if (id == R.id.card_unpaid_course) {
            JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_UNPAID_COURSES, (Context) null, 2, (Object) null);
            if (this.unpayNum > 0) {
                ShareDataManager.getInstance().put("shopping_unpay_red_point_time", System.currentTimeMillis() / ((long) 1000), ShareDataManager.SHAREDATA_USER);
                XesDataBus.with("home_tab_red_point").postStickyData(new Pair("TAB_ME", false));
            }
            onUnpaid(0);
        } else if (id == R.id.card_orders) {
            JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_ORDERS_NEW, (Context) null, 2, (Object) null);
        } else if (id == R.id.card_coupons) {
            JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_COUPONS, (Context) null, 2, (Object) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: private */
    public final void uploadLog() {
        Context context = getmActivity();
        Intrinsics.checkNotNullExpressionValue(context, "getmActivity()");
        LoganHelper.newFileWithUpload$default(context, (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void track(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_login", UserInfoBll.Companion.getInstance().isGuest() ? "0" : DbParams.GZIP_DATA_EVENT);
        LeanplumUtil.commonTrack(str, hashMap);
    }

    private final void track_click_coins() {
        LeanplumUtil.commonTrack$default("app_click_coins_icon", (HashMap) null, 2, (Object) null);
    }

    private final void onUnpaid(int i) {
        this.unpayNum = i;
        if (getBinding().cardParent.getVisibility() == 0) {
            if (i > 0) {
                MyCardView myCardView = getBinding().cardUnpaidCourse;
                String string = getString(R.string.my_card_unpaid_courses);
                Intrinsics.checkNotNullExpressionValue(string, "getString(string.my_card_unpaid_courses)");
                myCardView.setData(0, string, Color.parseColor("#FF503F"), R.drawable.my_card_next_red, R.drawable.my_card_bottome_unpaid_course_has);
                getBinding().cardUnpaidCourseNotify.setVisibility(0);
                getBinding().cardUnpaidCourseNum.setVisibility(0);
                getBinding().cardUnpaidCourseNum.setText(String.valueOf(i));
                return;
            }
            MyCardView myCardView2 = getBinding().cardUnpaidCourse;
            int i2 = R.drawable.my_icon_unpaid_courses;
            String string2 = getString(R.string.my_card_unpaid_courses);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(string.my_card_unpaid_courses)");
            myCardView2.setData(i2, string2, Color.parseColor("#3370FF"), R.drawable.my_card_next_blue, R.drawable.my_card_bottom_unpaid_course);
            getBinding().cardUnpaidCourseNotify.setVisibility(8);
            getBinding().cardUnpaidCourseNum.setVisibility(8);
        }
    }
}
