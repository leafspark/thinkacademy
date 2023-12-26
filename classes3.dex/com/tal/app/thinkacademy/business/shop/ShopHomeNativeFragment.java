package com.tal.app.thinkacademy.business.shop;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.main.shop.MyIndicator;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopListener;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopNativeListAdapter;
import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerDataBean;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerResource;
import com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.business.home.main.shop.view.ChannelSelectDialog;
import com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm;
import com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmFragment;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.IndicatorConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\r\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\"\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u000bH\u0014J\b\u00108\u001a\u000200H\u0002J\n\u00109\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010:\u001a\u00020\u0012H\u0016J\b\u0010;\u001a\u00020)H\u0016J\b\u0010<\u001a\u00020)H\u0002J\n\u0010=\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u000200H\u0002J\b\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000200H\u0002J\b\u0010B\u001a\u000200H\u0002J\b\u0010C\u001a\u000200H\u0002J\b\u0010D\u001a\u000200H\u0002J\b\u0010E\u001a\u000200H\u0016J\u0010\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020\u000bH\u0016J\b\u0010H\u001a\u000200H\u0016J\b\u0010I\u001a\u000200H\u0016J\u001a\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u00182\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u000200H\u0002J\u0018\u0010P\u001a\u0002002\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u000200H\u0002J\b\u0010T\u001a\u000200H\u0002J,\u0010U\u001a\u0002002\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010Z\u001a\u00020\u000bH\u0002J\u0012\u0010[\u001a\u0002002\b\u0010\\\u001a\u0004\u0018\u00010)H\u0002J\b\u0010]\u001a\u000200H\u0002J\u0010\u0010^\u001a\u0002002\u0006\u0010\\\u001a\u00020)H\u0002J\u0010\u0010_\u001a\u0002002\u0006\u0010`\u001a\u00020\u000bH\u0002J\b\u0010a\u001a\u000200H\u0002J\b\u0010b\u001a\u000200H\u0002J\u0012\u0010c\u001a\u0002002\b\u0010d\u001a\u0004\u0018\u00010)H\u0002J\b\u0010e\u001a\u000200H\u0002J\u0012\u0010f\u001a\u0002002\b\u0010d\u001a\u0004\u0018\u00010)H\u0002J\b\u0010g\u001a\u000200H\u0002J\b\u0010h\u001a\u000200H\u0002J\b\u0010i\u001a\u000200H\u0002J\b\u0010j\u001a\u000200H\u0002J\b\u0010k\u001a\u000200H\u0002J\u0010\u0010l\u001a\u0002002\u0006\u0010m\u001a\u00020\u000bH\u0002R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "Lcom/tal/app/thinkacademy/business/home/main/shop/vm/ShopHomeNativeVm;", "Lcom/tal/app/thinkacademy/business/shop/databinding/LayoutShopHomeFragmentBinding;", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;", "()V", "banner", "Lcom/youth/banner/Banner;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerResource;", "Lcom/youth/banner/adapter/BannerImageAdapter;", "isSelect", "", "mAppOnBackCallback", "com/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment$mAppOnBackCallback$1", "Lcom/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment$mAppOnBackCallback$1;", "mBannerAdapter", "mBannerHashMap", "Ljava/util/HashMap;", "", "mChannelSelectDialog", "Lcom/tal/app/thinkacademy/business/home/main/shop/view/ChannelSelectDialog;", "mDefaultChannel", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "mFootView", "Landroid/view/View;", "mIsListOffset", "mIsNativePage", "mIsReportCostTime", "mIsSelectedPrimary", "mLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "mListErrorDesc", "Landroid/widget/TextView;", "mListErrorImage", "Landroid/widget/ImageView;", "mListErrorInfo", "mListErrorView", "mListHeadView", "mOnCreateTime", "", "mSchoolCode", "", "mShopNativeListAdapter", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopNativeListAdapter;", "mStartDisplayTime", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "addFootView", "", "addHeadView", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "enterMallModule", "getChannelDialog", "getChannelId", "getChannelName", "getLinkUrl", "getListErrorView", "hideFullLoading", "hideListError", "initHeadBanner", "initRecyclerViewFoot", "initTimeZone", "initTitle", "leaveMallModule", "onDestroy", "onHiddenChanged", "hidden", "onPause", "onResume", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "removeFootView", "removeHeadView", "reportPageCostTime", "isError", "errorMsg", "requestFullData", "requestHome", "setChannelList", "list", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "defaultChannel", "isServerBack", "setTitleChannelName", "name", "setTitleColor", "setTitleDesc", "setTitleOffset", "offset", "showChannelDialog", "showFullEmpty", "showFullError", "msg", "showFullLoading", "showListError", "showListErrorEmpty", "startShopShow", "stopShopShow", "switchNativeOrWebIntroduce", "timeZoneTipShow", "updateListErrorView", "isHasHead", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
public final class ShopHomeNativeFragment extends BaseVmFragment<ShopHomeNativeVm, LayoutShopHomeFragmentBinding> implements ShopListener {
    private Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner;
    /* access modifiers changed from: private */
    public boolean isSelect;
    private ShopHomeNativeFragment$mAppOnBackCallback$1 mAppOnBackCallback = new ShopHomeNativeFragment$mAppOnBackCallback$1(this);
    /* access modifiers changed from: private */
    public BannerImageAdapter<ShopBannerResource> mBannerAdapter;
    /* access modifiers changed from: private */
    public HashMap<Integer, Boolean> mBannerHashMap = new HashMap<>();
    private ChannelSelectDialog mChannelSelectDialog;
    /* access modifiers changed from: private */
    public Channel mDefaultChannel;
    private View mFootView;
    private boolean mIsListOffset = true;
    private boolean mIsNativePage = UserInfoBll.Companion.getInstance().getShoppingMallReviewed();
    private boolean mIsReportCostTime;
    private boolean mIsSelectedPrimary = true;
    private GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
    private TextView mListErrorDesc;
    private ImageView mListErrorImage;
    private TextView mListErrorInfo;
    private View mListErrorView;
    private View mListHeadView;
    private long mOnCreateTime;
    /* access modifiers changed from: private */
    public String mSchoolCode = "";
    /* access modifiers changed from: private */
    public ShopNativeListAdapter mShopNativeListAdapter = new ShopNativeListAdapter(this);
    private long mStartDisplayTime = System.currentTimeMillis();
    private WebAgent mWebAgent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopHomeNativeFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutShopHomeFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutShopHomeFragmentBinding inflate = LayoutShopHomeFragmentBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, attach)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        ShopHomeNativeFragment.super.onViewCreated(view, bundle);
        XesLog.dt(this.TAG, new Object[]{"onViewCreated"});
        this.isSelect = true;
        enterMallModule();
        XesTabBottomLayout.clipBottomPadding(getBinding().rlShopRoot);
        this.mOnCreateTime = System.currentTimeMillis();
        if (!UserInfoBll.Companion.getInstance().getShoppingMallReviewed()) {
            this.mIsReportCostTime = true;
        }
        initTitle();
        setTitleColor();
        setTitleOffset(false);
        getBinding().recyclerView.setLayoutManager(this.mLayoutManager);
        initHeadBanner();
        initRecyclerViewFoot();
        initTimeZone();
        getBinding().recyclerView.setAdapter(this.mShopNativeListAdapter);
        ShopNativeListAdapter shopNativeListAdapter = this.mShopNativeListAdapter;
        RecyclerView recyclerView = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        shopNativeListAdapter.setShopRecyclerView(recyclerView);
        getMViewModel().getMChannelList().observe(getViewLifecycleOwner(), new ShopHomeNativeFragment$$ExternalSyntheticLambda4(this));
        getMViewModel().getMHomeDataList().observe(getViewLifecycleOwner(), new ShopHomeNativeFragment$$ExternalSyntheticLambda3(this));
        getBinding().refreshLayout.setOnRefreshListener(new ShopHomeNativeFragment$$ExternalSyntheticLambda8(this));
        getMViewModel().getMBannerData().observe(getViewLifecycleOwner(), new ShopHomeNativeFragment$$ExternalSyntheticLambda2(this));
        getBinding().recyclerView.addOnScrollListener(new ShopHomeNativeFragment$onViewCreated$5(this));
        requestFullData();
        getMViewModel().getTimeZoneCheck().observe(getViewLifecycleOwner(), new ShopHomeNativeFragment$$ExternalSyntheticLambda1(this));
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("seleted_time_zone").observe(lifecycleOwner, new ShopHomeNativeFragment$$ExternalSyntheticLambda6(this));
        XesActivityManager.Companion.getInstance().addFrontBackCallback(this.mAppOnBackCallback);
        XesDataBus.with("on_app_exit").observe(lifecycleOwner, new ShopHomeNativeFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc  */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m194onViewCreated$lambda1(com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment r5, com.tal.app.thinkacademy.common.entity.StateData r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r6.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x00cb
            java.lang.String r0 = r5.TAG
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "getChannelList 成功 start"
            r3[r2] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r3)
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r0 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r0
            if (r0 != 0) goto L_0x002a
        L_0x0028:
            r0 = r2
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = r0.getSelectorTitle()
            if (r0 != 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x003b
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            if (r0 != r1) goto L_0x0028
            r0 = r1
        L_0x003f:
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0047
            r5.setTitleDesc(r3)
            goto L_0x005b
        L_0x0047:
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r0 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r0
            if (r0 != 0) goto L_0x0050
            goto L_0x0058
        L_0x0050:
            java.lang.String r0 = r0.getSelectorTitle()
            if (r0 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r3 = r0
        L_0x0058:
            r5.setTitleDesc(r3)
        L_0x005b:
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r0 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r0
            r3 = 0
            if (r0 != 0) goto L_0x0066
            r0 = r3
            goto L_0x006a
        L_0x0066:
            java.util.List r0 = r0.getList()
        L_0x006a:
            if (r0 == 0) goto L_0x00bc
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r0 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r0
            if (r0 != 0) goto L_0x0076
            goto L_0x00e2
        L_0x0076:
            java.util.List r0 = r0.getList()
            if (r0 != 0) goto L_0x007d
            goto L_0x00e2
        L_0x007d:
            int r4 = r0.size()
            if (r4 <= 0) goto L_0x00ad
            java.lang.Object r4 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r4 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r4
            if (r4 != 0) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r3 = r4.getDefaultChannel()
        L_0x0090:
            java.lang.Object r6 = r6.getData()
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData r6 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData) r6
            if (r6 != 0) goto L_0x009a
            r6 = r2
            goto L_0x009e
        L_0x009a:
            boolean r6 = r6.isServerDefaultChannelId()
        L_0x009e:
            r5.setChannelList(r0, r3, r6)
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "getChannelList 成功"
            r6[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
            goto L_0x00e2
        L_0x00ad:
            r5.showFullEmpty()
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "getChannelList 数据为空1"
            r6[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
            goto L_0x00e2
        L_0x00bc:
            r5.showFullEmpty()
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "getChannelList 数据为空2"
            r6[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
            goto L_0x00e2
        L_0x00cb:
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.String r6 = com.tal.app.thinkacademy.common.CommonKtxKt.formatBadResult(r6)
            r5.showFullError(r6)
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "getChannelList 获取数据失败"
            r6[r2] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment.m194onViewCreated$lambda1(com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m195onViewCreated$lambda2(ShopHomeNativeFragment shopHomeNativeFragment, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        shopHomeNativeFragment.getBinding().refreshLayout.finishRefresh();
        shopHomeNativeFragment.hideFullLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            List list = (List) stateData.getData();
            if ((list == null ? 0 : list.size()) > 0) {
                shopHomeNativeFragment.hideListError();
                shopHomeNativeFragment.addFootView();
                shopHomeNativeFragment.mShopNativeListAdapter.setList((Collection) stateData.getData());
                XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{"getHomeDataList 成功"});
                return;
            }
            XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{"getHomeDataList 数据为空"});
            shopHomeNativeFragment.showListErrorEmpty();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        shopHomeNativeFragment.showListError(CommonKtxKt.formatBadResult(stateData));
        XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{"getHomeDataList 获取失败"});
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m196onViewCreated$lambda3(ShopHomeNativeFragment shopHomeNativeFragment, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, "it");
        if (shopHomeNativeFragment.mDefaultChannel != null) {
            shopHomeNativeFragment.requestHome();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m197onViewCreated$lambda6(ShopHomeNativeFragment shopHomeNativeFragment, StateData stateData) {
        Integer id;
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        int i = 0;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{"getBanner success"});
            Channel channel = shopHomeNativeFragment.mDefaultChannel;
            if (channel != null && (id = channel.getId()) != null) {
                int intValue = id.intValue();
                if (stateData.getData() != null) {
                    List list = (List) stateData.getData();
                    if ((list == null ? 0 : list.size()) > 0) {
                        List list2 = (List) stateData.getData();
                        ShopBannerDataBean shopBannerDataBean = list2 == null ? null : (ShopBannerDataBean) list2.get(0);
                        if (shopBannerDataBean != null) {
                            List<ShopBannerResource> resources = shopBannerDataBean.getResources();
                            if (resources != null) {
                                i = resources.size();
                            }
                            Integer channelId = shopBannerDataBean.getChannelId();
                            if (channelId != null && intValue == channelId.intValue() && i > 0) {
                                shopHomeNativeFragment.addHeadView();
                                BannerImageAdapter<ShopBannerResource> bannerImageAdapter = shopHomeNativeFragment.mBannerAdapter;
                                if (bannerImageAdapter != null) {
                                    bannerImageAdapter.setDatas(shopBannerDataBean.getResources());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{"getBanner error"});
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m198onViewCreated$lambda7(ShopHomeNativeFragment shopHomeNativeFragment, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
            TimeZoneCheckEntity timeZoneCheckEntity = (TimeZoneCheckEntity) stateData.getData();
            if (timeZoneCheckEntity != null && timeZoneCheckEntity.getInvalid() == 1) {
                ToastUtils.showShort(R.string.the_time_zone_has_been_switched_to, new Object[]{TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone()});
            }
            ShareDataManager instance = ShareDataManager.getInstance();
            TimeZoneCheckEntity timeZoneCheckEntity2 = (TimeZoneCheckEntity) stateData.getData();
            instance.put("real_show_time_zone", timeZoneCheckEntity2 != null && timeZoneCheckEntity2.getInvalid() == 0 ? TimeZone.getDefault().getID() : TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
            String timeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = shopHomeNativeFragment.getBinding().tvTimeZone;
            String string = shopHomeNativeFragment.getString(R.string.time_zone_tip, new Object[]{timeZone});
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …one\n                    )");
            Context context = shopHomeNativeFragment.getContext();
            textHighLightUtil.setTextHighLightColorSize(textView, string, timeZone, context == null ? -1 : context.getColor(R.color.color_3370FF), SizeUtils.dp2px(14.0f));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m199onViewCreated$lambda8(ShopHomeNativeFragment shopHomeNativeFragment, String str) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        shopHomeNativeFragment.mSchoolCode = "";
        shopHomeNativeFragment.requestHome();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m200onViewCreated$lambda9(ShopHomeNativeFragment shopHomeNativeFragment, String str) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        if (shopHomeNativeFragment.isSelect) {
            shopHomeNativeFragment.isSelect = false;
            XesLog.it(shopHomeNativeFragment.TAG, new Object[]{"App退出"});
            shopHomeNativeFragment.leaveMallModule();
        }
    }

    private final void updateListErrorView(boolean z) {
        getBinding().recyclerView.post(new ShopHomeNativeFragment$$ExternalSyntheticLambda9(z, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateListErrorView$lambda-11  reason: not valid java name */
    public static final void m202updateListErrorView$lambda11(boolean z, ShopHomeNativeFragment shopHomeNativeFragment) {
        int i;
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        if (z) {
            i = shopHomeNativeFragment.getBinding().recyclerView.getHeight() - SizeUtils.dp2px(154.0f);
            XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{Intrinsics.stringPlus("h1 = ", Integer.valueOf(i))});
        } else {
            i = shopHomeNativeFragment.getBinding().recyclerView.getHeight();
            XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{Intrinsics.stringPlus("h2 = ", Integer.valueOf(i))});
        }
        View listErrorView = shopHomeNativeFragment.getListErrorView();
        if (listErrorView != null && i > 0) {
            ViewGroup.LayoutParams layoutParams = listErrorView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
            }
            XesLog.dt(shopHomeNativeFragment.TAG, new Object[]{Intrinsics.stringPlus("h3 = ", Integer.valueOf(i))});
        }
        LinearLayout footerLayout = shopHomeNativeFragment.mShopNativeListAdapter.getFooterLayout();
        if (footerLayout != null) {
            footerLayout.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public final void showFullLoading() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            loadStatusView.showFullLoadingView(R.color.color_f4f6fa);
        }
    }

    private final void reportPageCostTime(boolean z, String str) {
        if (!this.mIsReportCostTime) {
            this.mIsReportCostTime = true;
            ShopTrack.INSTANCE.hw_shop_page_take_up_time((((float) (System.currentTimeMillis() - this.mOnCreateTime)) * 1.0f) / ((float) 1000), z, str, ShopTrack.ShopPageType.SHOP_HOME);
        }
    }

    private final void showFullEmpty() {
        reportPageCostTime(true, "频道列表为空");
        if (this.mDefaultChannel == null) {
            Context context = getContext();
            if (context != null) {
                LoadStatusView loadStatusView = getBinding().loadStatusView;
                if (loadStatusView != null) {
                    int i = R.drawable.fail_internet_connection;
                    String string = context.getString(R.string.data_is_empty);
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.data_is_empty)");
                    String string2 = context.getString(R.string.fail_btn_hint);
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(R.string.fail_btn_hint)");
                    LoadStatusView.showErrorView$default(loadStatusView, i, string, string2, (String) null, new ShopHomeNativeFragment$showFullEmpty$1$1(this), 8, (Object) null);
                }
                LoadStatusView loadStatusView2 = getBinding().loadStatusView;
                if (loadStatusView2 != null) {
                    loadStatusView2.setContentBg(R.color.color_f4f6fa);
                }
            }
            ShopTrack.INSTANCE.hw_shop_pv("", true);
        }
    }

    private final void showFullError(String str) {
        reportPageCostTime(true, str == null ? "" : str);
        if (this.mDefaultChannel == null) {
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            if (loadStatusView != null) {
                LoadStatusView.showErrorView$default(loadStatusView, 0, (String) null, (String) null, str, new ShopHomeNativeFragment$showFullError$1(this), 7, (Object) null);
            }
            ShopTrack.INSTANCE.hw_shop_pv("", true);
        }
    }

    private final void hideFullLoading() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            loadStatusView.restoreView();
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View getListErrorView() {
        /*
            r5 = this;
            android.view.View r0 = r5.mListErrorView
            if (r0 != 0) goto L_0x0055
            android.view.LayoutInflater r0 = r5.getLayoutInflater()
            int r1 = com.tal.app.thinkacademy.business.shop.R.layout.shop_home_list_error_layout
            androidx.viewbinding.ViewBinding r2 = r5.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding r2 = (com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding) r2
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerView
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r3 = 0
            boolean r4 = r0 instanceof android.view.LayoutInflater
            if (r4 != 0) goto L_0x001e
            android.view.View r0 = r0.inflate(r1, r2, r3)
            goto L_0x0024
        L_0x001e:
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            android.view.View r0 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.inflate(r0, r1, r2, r3)
        L_0x0024:
            r5.mListErrorView = r0
            r1 = 0
            if (r0 != 0) goto L_0x002b
            r0 = r1
            goto L_0x0033
        L_0x002b:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.list_error_image
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0033:
            r5.mListErrorImage = r0
            android.view.View r0 = r5.mListErrorView
            if (r0 != 0) goto L_0x003b
            r0 = r1
            goto L_0x0043
        L_0x003b:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.list_error_msg
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0043:
            r5.mListErrorDesc = r0
            android.view.View r0 = r5.mListErrorView
            if (r0 != 0) goto L_0x004a
            goto L_0x0053
        L_0x004a:
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.list_error_info
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0053:
            r5.mListErrorInfo = r1
        L_0x0055:
            android.view.View r0 = r5.mListErrorView
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment.getListErrorView():android.view.View");
    }

    private final void showListError(String str) {
        View listErrorView;
        View view;
        reportPageCostTime(true, str == null ? "" : str);
        if (this.mShopNativeListAdapter.getData().isEmpty() && (listErrorView = getListErrorView()) != null) {
            if (listErrorView.getParent() == null && (view = this.mListErrorView) != null) {
                BaseQuickAdapter.addFooterView$default(this.mShopNativeListAdapter, view, 0, 0, 6, (Object) null);
            }
            ImageView imageView = this.mListErrorImage;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.fail_internet_connection);
            }
            TextView textView = this.mListErrorDesc;
            if (textView != null) {
                Context context = getContext();
                textView.setText(context == null ? null : context.getText(R.string.fail_hint));
            }
            TextView textView2 = this.mListErrorInfo;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
    }

    private final void showListErrorEmpty() {
        String name;
        View view;
        reportPageCostTime(true, "获取数据失败");
        if (this.mShopNativeListAdapter.getData().isEmpty()) {
            View listErrorView = getListErrorView();
            if (listErrorView != null) {
                if (listErrorView.getParent() == null && (view = this.mListErrorView) != null) {
                    BaseQuickAdapter.addFooterView$default(this.mShopNativeListAdapter, view, 0, 0, 6, (Object) null);
                }
                ImageView imageView = this.mListErrorImage;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.no_current_courses);
                }
                TextView textView = this.mListErrorDesc;
                if (textView != null) {
                    Context context = getContext();
                    textView.setText(context == null ? null : context.getText(R.string.no_courses_under_category));
                }
            }
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            Channel channel = this.mDefaultChannel;
            String str = "";
            if (!(channel == null || (name = channel.getName()) == null)) {
                str = name;
            }
            shopTrack.hw_shop_pv(str, true);
        }
    }

    private final void hideListError() {
        View view;
        String name;
        String str = "";
        reportPageCostTime(false, str);
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        Channel channel = this.mDefaultChannel;
        if (!(channel == null || (name = channel.getName()) == null)) {
            str = name;
        }
        shopTrack.hw_shop_pv(str, false);
        View listErrorView = getListErrorView();
        if (listErrorView != null && listErrorView.getParent() != null && (view = this.mListErrorView) != null) {
            this.mShopNativeListAdapter.removeFooterView(view);
        }
    }

    private final void initTitle() {
        getBinding().titleName.setOnClickListener(new ShopHomeNativeFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initTitle$lambda-19  reason: not valid java name */
    public static final void m193initTitle$lambda19(ShopHomeNativeFragment shopHomeNativeFragment, View view) {
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        shopHomeNativeFragment.showChannelDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void setTitleDesc(String str) {
        getBinding().titleDes.setText(str);
        ChannelSelectDialog channelDialog = getChannelDialog();
        if (channelDialog != null) {
            channelDialog.setChannelSelectTitle(str);
        }
    }

    private final void initHeadBanner() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.shop_list_head_view;
        ViewGroup viewGroup = getBinding().recyclerView;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        this.mListHeadView = inflate;
        if (inflate != null) {
            this.banner = (Banner) inflate.findViewById(R.id.shop_banner);
            BannerAdapter bannerAdapter = (BannerImageAdapter) new ShopHomeNativeFragment$initHeadBanner$1$1(this);
            this.mBannerAdapter = bannerAdapter;
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner2 = this.banner;
            if (banner2 != null) {
                banner2.setAdapter(bannerAdapter);
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner3 = this.banner;
            if (banner3 != null) {
                banner3.setIndicator(new MyIndicator(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner4 = this.banner;
            if (banner4 != null) {
                banner4.setIndicatorSelectedColorRes(R.color.color_ffffff);
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner5 = this.banner;
            if (banner5 != null) {
                banner5.setIndicatorNormalColorRes(R.color.color_80000000);
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner6 = this.banner;
            if (banner6 != null) {
                banner6.setIndicatorGravity(1);
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner7 = this.banner;
            if (banner7 != null) {
                banner7.setIndicatorSelectedWidth(SizeUtils.dp2px(15.0f));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner8 = this.banner;
            if (banner8 != null) {
                banner8.setIndicatorNormalWidth(SizeUtils.dp2px(5.0f));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner9 = this.banner;
            if (banner9 != null) {
                banner9.setIndicatorSpace(SizeUtils.dp2px(5.0f));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner10 = this.banner;
            if (banner10 != null) {
                banner10.setIndicatorMargins(new IndicatorConfig.Margins(SizeUtils.dp2px(5.0f), 0, SizeUtils.dp2px(5.0f), SizeUtils.dp2px(6.0f)));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner11 = this.banner;
            if (banner11 != null) {
                banner11.setBannerRound((float) SizeUtils.dp2px(10.0f));
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner12 = this.banner;
            if (banner12 != null) {
                banner12.addBannerLifecycleObserver((LifecycleOwner) this);
            }
            Banner<ShopBannerResource, BannerImageAdapter<ShopBannerResource>> banner13 = this.banner;
            if (banner13 != null) {
                banner13.addOnPageChangeListener(new ShopHomeNativeFragment$initHeadBanner$1$2(this));
            }
        }
    }

    private final void setTitleColor() {
        boolean z = UserInfoBll.Companion.getInstance().getSelectedChannel() != null;
        this.mIsSelectedPrimary = z;
        if (z) {
            getBinding().titleName.setTextColor(getResources().getColor(R.color.color_ff172b4d, (Resources.Theme) null));
        } else {
            getBinding().titleName.setTextColor(getResources().getColor(R.color.color_a2aab8, (Resources.Theme) null));
        }
    }

    /* access modifiers changed from: private */
    public final void setTitleOffset(boolean z) {
        if (this.mIsListOffset != z) {
            this.mIsListOffset = z;
            if (!(getBinding().titleDes.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                return;
            }
            if (this.mIsListOffset) {
                getBinding().titleDes.getLayoutParams().width = getResources().getDimensionPixelOffset(R.dimen.size_92dp);
                getBinding().titleDes.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.size_14dp));
                return;
            }
            getBinding().titleDes.getLayoutParams().width = getResources().getDimensionPixelOffset(R.dimen.size_170dp);
            getBinding().titleDes.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.size_20dp));
        }
    }

    /* access modifiers changed from: private */
    public final void setTitleChannelName(String str) {
        setTitleColor();
        getBinding().titleName.setText(str);
    }

    static /* synthetic */ void setChannelList$default(ShopHomeNativeFragment shopHomeNativeFragment, List list, Channel channel, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        shopHomeNativeFragment.setChannelList(list, channel, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setChannelList(java.util.List<com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelDialogSection> r17, com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            if (r1 != 0) goto L_0x0008
            goto L_0x0110
        L_0x0008:
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()
            com.tal.app.thinkacademy.common.entity.ChannelSaveData r2 = r2.getSelectedChannel()
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = "415"
            java.lang.String r3 = r3.getString(r5, r6, r4)
            com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r4 = r0.mDefaultChannel
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0028
            r4 = r5
            goto L_0x0029
        L_0x0028:
            r4 = r6
        L_0x0029:
            r7 = 0
            if (r2 == 0) goto L_0x00b2
            java.lang.String r8 = r2.getSchoolCode()
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x005e
            java.lang.String r3 = r0.TAG
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r7 = "channel,本地有,且正确"
            r5[r6] = r7
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r3, r5)
            com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r3 = new com.tal.app.thinkacademy.business.home.main.shop.bean.Channel
            r9 = 0
            java.lang.Integer r10 = r2.getId()
            java.lang.String r11 = r2.getName()
            r12 = 0
            r13 = 0
            r14 = 25
            r15 = 0
            r8 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            java.lang.String r2 = r2.getName()
            r0.setTitleChannelName(r2)
            goto L_0x00fd
        L_0x005e:
            if (r19 == 0) goto L_0x0093
            java.lang.String r2 = r0.TAG
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r5 = "channel,本地有，但是分校不符，服务端返回了，按服务端。"
            r3[r6] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r2, r3)
            com.tal.app.thinkacademy.common.entity.ChannelSaveData r2 = new com.tal.app.thinkacademy.common.entity.ChannelSaveData
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 7
            r13 = 0
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13)
            if (r18 != 0) goto L_0x007d
        L_0x0078:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x0084
        L_0x007d:
            java.lang.Integer r3 = r18.getId()
            if (r3 != 0) goto L_0x0084
            goto L_0x0078
        L_0x0084:
            r2.setId(r3)
            if (r18 != 0) goto L_0x008b
            r3 = r7
            goto L_0x008f
        L_0x008b:
            java.lang.String r3 = r18.getName()
        L_0x008f:
            r2.setName(r3)
            goto L_0x00a7
        L_0x0093:
            java.lang.String r2 = r0.TAG
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r5 = "channel,本地有，但是分校不符，服务端没有返回，清空"
            r3[r6] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r2, r3)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()
            r2.putSelectedChannel(r7)
        L_0x00a7:
            if (r18 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            java.lang.String r7 = r18.getName()
        L_0x00ae:
            r0.setTitleChannelName(r7)
            goto L_0x00fb
        L_0x00b2:
            java.lang.String r2 = r0.TAG
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r8 = "channel,本地没有保存的默认channelId。"
            r3[r6] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r2, r3)
            if (r19 == 0) goto L_0x00f1
            java.lang.String r2 = r0.TAG
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r5 = "channel,本地没有，但是服务端返回了，按服务端。"
            r3[r6] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r2, r3)
            com.tal.app.thinkacademy.common.entity.ChannelSaveData r2 = new com.tal.app.thinkacademy.common.entity.ChannelSaveData
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 7
            r13 = 0
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13)
            if (r18 != 0) goto L_0x00dc
        L_0x00d7:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x00e3
        L_0x00dc:
            java.lang.Integer r3 = r18.getId()
            if (r3 != 0) goto L_0x00e3
            goto L_0x00d7
        L_0x00e3:
            r2.setId(r3)
            if (r18 != 0) goto L_0x00ea
            r3 = r7
            goto L_0x00ee
        L_0x00ea:
            java.lang.String r3 = r18.getName()
        L_0x00ee:
            r2.setName(r3)
        L_0x00f1:
            if (r18 != 0) goto L_0x00f4
            goto L_0x00f8
        L_0x00f4:
            java.lang.String r7 = r18.getName()
        L_0x00f8:
            r0.setTitleChannelName(r7)
        L_0x00fb:
            r3 = r18
        L_0x00fd:
            r0.mDefaultChannel = r3
            com.tal.app.thinkacademy.business.home.main.shop.view.ChannelSelectDialog r2 = r16.getChannelDialog()
            if (r2 != 0) goto L_0x0106
            goto L_0x010b
        L_0x0106:
            com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r3 = r0.mDefaultChannel
            r2.setData(r1, r3)
        L_0x010b:
            if (r4 == 0) goto L_0x0110
            r16.requestHome()
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment.setChannelList(java.util.List, com.tal.app.thinkacademy.business.home.main.shop.bean.Channel, boolean):void");
    }

    private final ChannelSelectDialog getChannelDialog() {
        Context context = getContext();
        if (context != null && this.mChannelSelectDialog == null) {
            this.mChannelSelectDialog = new ChannelSelectDialog(context, new ShopHomeNativeFragment$getChannelDialog$1$1(this));
        }
        return this.mChannelSelectDialog;
    }

    /* access modifiers changed from: private */
    public final void removeHeadView() {
        View view;
        if (this.mShopNativeListAdapter.getHeaderLayoutCount() > 0 && (view = this.mListHeadView) != null) {
            this.mShopNativeListAdapter.removeHeaderView(view);
        }
        updateListErrorView(false);
    }

    private final void addHeadView() {
        View view;
        if (this.mShopNativeListAdapter.getHeaderLayoutCount() == 0 && (view = this.mListHeadView) != null) {
            BaseQuickAdapter.addHeaderView$default(this.mShopNativeListAdapter, view, 0, 0, 6, (Object) null);
        }
        updateListErrorView(true);
    }

    private final void showChannelDialog() {
        String name;
        ChannelSelectDialog channelDialog = getChannelDialog();
        if (channelDialog != null) {
            channelDialog.updateData();
        }
        ChannelSelectDialog channelDialog2 = getChannelDialog();
        if (channelDialog2 != null) {
            channelDialog2.show();
        }
        ShopHomeNativeVm mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.getChannelList();
        }
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        Channel channel = this.mDefaultChannel;
        String str = "";
        if (!(channel == null || (name = channel.getName()) == null)) {
            str = name;
        }
        shopTrack.hw_shop_channel_show(str);
    }

    private final void initRecyclerViewFoot() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.lib_common_ui_list_foot;
        ViewGroup viewGroup = getBinding().recyclerView;
        this.mFootView = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public final void removeFootView() {
        View view = this.mFootView;
        if (view != null && view.getParent() != null) {
            this.mShopNativeListAdapter.removeFooterView(view);
        }
    }

    private final void addFootView() {
        View view = this.mFootView;
        if (view != null && view.getParent() == null) {
            BaseQuickAdapter.addFooterView$default(this.mShopNativeListAdapter, view, 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void requestHome() {
        Integer id;
        Channel channel = this.mDefaultChannel;
        if (channel != null && (id = channel.getId()) != null) {
            int intValue = id.intValue();
            this.mBannerHashMap.clear();
            ShopHomeNativeVm mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.getShopHomeBannerList(intValue);
            }
            ShopHomeNativeVm mViewModel2 = getMViewModel();
            if (mViewModel2 != null) {
                mViewModel2.getHomeDataList(intValue);
            }
        }
    }

    public void onResume() {
        ShopHomeNativeFragment.super.onResume();
        startShopShow();
        switchNativeOrWebIntroduce();
        XesLog.dt(this.TAG, new Object[]{"onResume"});
        if (isVisible() && !Intrinsics.areEqual((Object) this.mSchoolCode, (Object) ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR))) {
            timeZoneTipShow();
        }
    }

    public void onPause() {
        ShopHomeNativeFragment.super.onPause();
        stopShopShow();
        XesLog.dt(this.TAG, new Object[]{"onPause"});
    }

    public void onHiddenChanged(boolean z) {
        String str = this.TAG;
        XesLog.dt(str, new Object[]{"商城首页>>>onHiddenChanged,isHidden=" + z + "，isViewCreated=" + getMIsViewCreated()});
        if (getMIsViewCreated()) {
            ShopHomeNativeFragment.super.onHiddenChanged(z);
            if (z) {
                stopShopShow();
                leaveMallModule();
            } else {
                startShopShow();
                enterMallModule();
                if (!Intrinsics.areEqual((Object) this.mSchoolCode, (Object) ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR))) {
                    timeZoneTipShow();
                }
            }
            this.isSelect = !z;
        }
    }

    private final void startShopShow() {
        this.mStartDisplayTime = System.currentTimeMillis();
    }

    private final void stopShopShow() {
        String name;
        float currentTimeMillis = (((float) (System.currentTimeMillis() - this.mStartDisplayTime)) * 1.0f) / ((float) 1000);
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        Channel channel = this.mDefaultChannel;
        String str = "";
        if (!(channel == null || (name = channel.getName()) == null)) {
            str = name;
        }
        shopTrack.hw_shop_leave(str, currentTimeMillis);
    }

    private final String getLinkUrl() {
        String str = SchoolConstants.INSTANCE.getSchoolMallTouchUrlHost(8601) + "/app-v2/goods/up-hobby";
        Intrinsics.checkNotNullExpressionValue(str, "urlBuilder.toString()");
        return str;
    }

    private final void requestFullData() {
        FragmentListener fragmentListener;
        if (this.mIsNativePage) {
            LinearLayout linearLayout = getBinding().titleLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            SmartRefreshLayout smartRefreshLayout = getBinding().refreshLayout;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.setVisibility(0);
            }
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            if (loadStatusView != null) {
                loadStatusView.setVisibility(0);
            }
            FrameLayout frameLayout = getBinding().webParent;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            showFullLoading();
            if (this.mDefaultChannel != null) {
                requestHome();
            } else if (isViewModelInitialized()) {
                getMViewModel().getChannelList();
            }
        } else {
            LinearLayout linearLayout2 = getBinding().titleLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            SmartRefreshLayout smartRefreshLayout2 = getBinding().refreshLayout;
            if (smartRefreshLayout2 != null) {
                smartRefreshLayout2.setVisibility(8);
            }
            LoadStatusView loadStatusView2 = getBinding().loadStatusView;
            if (loadStatusView2 != null) {
                loadStatusView2.setVisibility(8);
            }
            FrameLayout frameLayout2 = getBinding().webParent;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            if (this.mWebAgent == null) {
                WebAgent webAgentParent = new WebAgent(getmActivity()).applyConfig(new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build()).setWebAgentParent(getBinding().webParent, new ViewGroup.LayoutParams(-1, -1));
                this.mWebAgent = webAgentParent;
                if (!(webAgentParent == null || (fragmentListener = this.mFragmentListener) == null)) {
                    fragmentListener.process(webAgentParent);
                }
                StickyLiveData with = XesDataBus.with("user_change_school");
                LifecycleOwner lifecycleOwner = getmActivity();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "getmActivity()");
                with.observe(lifecycleOwner, new ShopHomeNativeFragment$$ExternalSyntheticLambda7(this));
            }
            WebAgent webAgent = this.mWebAgent;
            if (webAgent != null) {
                webAgent.loadUrl(getLinkUrl());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: requestFullData$lambda-30  reason: not valid java name */
    public static final void m201requestFullData$lambda30(ShopHomeNativeFragment shopHomeNativeFragment, Object obj) {
        WebAgent webAgent;
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        if (!shopHomeNativeFragment.mIsNativePage && (webAgent = shopHomeNativeFragment.mWebAgent) != null) {
            webAgent.loadUrl(shopHomeNativeFragment.getLinkUrl());
        }
    }

    private final void switchNativeOrWebIntroduce() {
        if (this.mIsNativePage != UserInfoBll.Companion.getInstance().getShoppingMallReviewed()) {
            this.mIsNativePage = !this.mIsNativePage;
            requestFullData();
        }
    }

    public int getChannelId() {
        Integer id;
        Channel channel = this.mDefaultChannel;
        if (channel == null || (id = channel.getId()) == null) {
            return 0;
        }
        return id.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getChannelName() {
        /*
            r2 = this;
            com.tal.app.thinkacademy.business.home.main.shop.bean.Channel r0 = r2.mDefaultChannel
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            java.lang.String r0 = r0.getName()
            if (r0 != 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.ShopHomeNativeFragment.getChannelName():java.lang.String");
    }

    private final void initTimeZone() {
        ImageView imageView = getBinding().ivTimeZoneClose;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 500, new ShopHomeNativeFragment$initTimeZone$1(this));
        }
        timeZoneTipShow();
    }

    private final void timeZoneTipShow() {
        boolean z = true;
        if (PadUtils.isPad(Utils.getApp()) || !TimeZoneUtil.INSTANCE.isShowTimeZoneBranchSchool()) {
            LinearLayout linearLayout = getBinding().llTimeZoneTip;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            String timeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = getBinding().tvTimeZone;
            String string = getString(R.string.time_zone_tip, new Object[]{timeZone});
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.time_zone_tip, timeZone)");
            Context context = getContext();
            textHighLightUtil.setTextHighLightColorSize(textView, string, timeZone, context == null ? -1 : context.getColor(R.color.color_3370FF), SizeUtils.dp2px(14.0f));
            CharSequence appTimeZone = TimeZoneUtil.INSTANCE.getAppTimeZone();
            if (appTimeZone == null || StringsKt.isBlank(appTimeZone)) {
                if (TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool()) {
                    LinearLayout linearLayout2 = getBinding().llTimeZoneTip;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                } else {
                    LinearLayout linearLayout3 = getBinding().llTimeZoneTip;
                    if (linearLayout3 != null && linearLayout3.getVisibility() == 8) {
                        ShopTrack.INSTANCE.hw_time_zone_show();
                    }
                    LinearLayout linearLayout4 = getBinding().llTimeZoneTip;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(0);
                    }
                }
            } else if (!TimeZoneUtil.INSTANCE.appTimeZoneEqualsSetting()) {
                LinearLayout linearLayout5 = getBinding().llTimeZoneTip;
                if (linearLayout5 != null && linearLayout5.getVisibility() == 8) {
                    ShopTrack.INSTANCE.hw_time_zone_show();
                }
                LinearLayout linearLayout6 = getBinding().llTimeZoneTip;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
            } else if (TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool()) {
                LinearLayout linearLayout7 = getBinding().llTimeZoneTip;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(8);
                }
            } else {
                LinearLayout linearLayout8 = getBinding().llTimeZoneTip;
                if (linearLayout8 != null && linearLayout8.getVisibility() == 8) {
                    ShopTrack.INSTANCE.hw_time_zone_show();
                }
                LinearLayout linearLayout9 = getBinding().llTimeZoneTip;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
            }
        }
        CharSequence string2 = ShareDataManager.getInstance().getString("time_zone", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string2 == null || StringsKt.isBlank(string2)) {
            CharSequence id = TimeZone.getDefault().getID();
            if (!(id == null || id.length() == 0)) {
                z = false;
            }
            if (z) {
                ShareDataManager.getInstance().put("real_show_time_zone", TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
            } else if (isViewModelInitialized()) {
                String id2 = TimeZone.getDefault().getID();
                Intrinsics.checkNotNullExpressionValue(id2, "getDefault().id");
                getMViewModel().timeZoneCheck(id2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void enterMallModule() {
        XesLog.it(this.TAG, new Object[]{"进入商城模块"});
        ShopTrack.INSTANCE.enterMallModule();
    }

    /* access modifiers changed from: private */
    public final void leaveMallModule() {
        XesLog.it(this.TAG, new Object[]{"离开商城模块"});
        ShopTrack.INSTANCE.leaveMallModule();
    }

    public void onDestroy() {
        ShopHomeNativeFragment.super.onDestroy();
        XesLog.it(this.TAG, new Object[]{"删除切后台监控"});
        XesActivityManager.Companion.getInstance().removeFrontBackCallback(this.mAppOnBackCallback);
    }
}
