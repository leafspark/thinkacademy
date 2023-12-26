package com.tal.app.thinkacademy.business.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.flyco.roundview.RoundLinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tal.app.thinkacademy.business.shop.adapter.TeacherDeatilsAdapter;
import com.tal.app.thinkacademy.business.shop.bean.RecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.business.shop.bean.TeacherDetailsHeader;
import com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherVideoNode;
import com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.shop.viewmodel.TeacherDetailsVm;
import com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout;
import com.tal.app.thinkacademy.business.shop.widget.view.TeacherLabelView;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.entity.HwCommonPlayerParams;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020!H\u0014J\b\u00100\u001a\u00020!H\u0014J\u0012\u00101\u001a\u00020!2\b\b\u0002\u00102\u001a\u00020\u001fH\u0002J\u0014\u00103\u001a\u00020!2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/TeacherDetailsActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/TeacherDetailsVm;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivityTeacherDetailsBinding;", "()V", "classPosition", "", "mFootView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getMFootView", "()Landroid/view/View;", "mFootView$delegate", "Lkotlin/Lazy;", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mTeacherAvBgs", "", "mTeacherDeatilsAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/TeacherDeatilsAdapter;", "mTeacherId", "mTeacherName", "", "nodeHeaderList", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "startPosition", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "getHeaderData", "", "getListData", "getListError", "gotoPlay", "node", "Lcom/tal/app/thinkacademy/business/shop/bean/teachernode/TeacherVideoNode;", "initAdapter", "initData", "initListener", "initTitle", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setSeleted", "profileSeleted", "showHeaderDataEmpty", "msg", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsActivity.kt */
public final class TeacherDetailsActivity extends BaseVmActivity<TeacherDetailsVm, ActivityTeacherDetailsBinding> {
    /* access modifiers changed from: private */
    public int classPosition;
    private final Lazy mFootView$delegate = LazyKt.lazy(new TeacherDetailsActivity$mFootView$2(this));
    /* access modifiers changed from: private */
    public LinearLayoutManager mLinearLayoutManager;
    private int[] mTeacherAvBgs = {R.drawable.bus_shop_teacher_iv_bule, R.drawable.bus_shop_teacher_iv_green, R.drawable.bus_shop_teacher_iv_pink, R.drawable.bus_shop_teacher_iv_purple, R.drawable.bus_shop_teacher_iv_yellow};
    /* access modifiers changed from: private */
    public TeacherDeatilsAdapter mTeacherDeatilsAdapter;
    /* access modifiers changed from: private */
    public int mTeacherId = -1;
    /* access modifiers changed from: private */
    public String mTeacherName = "";
    private List<? extends BaseNode> nodeHeaderList;
    private int startPosition;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TeacherDetailsActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final View getMFootView() {
        return (View) this.mFootView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        TeacherDetailsActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        initData();
        initView();
        initListener();
    }

    private final void initData() {
        Intent intent = getIntent();
        int i = -1;
        if (intent != null) {
            i = intent.getIntExtra("teacherId", -1);
        }
        this.mTeacherId = i;
    }

    private final void initView() {
        initTitle();
        initAdapter();
        getHeaderData();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getMTeacherDetailsHeader().observe(lifecycleOwner, new TeacherDetailsActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getMTeacherDetailsList().observe(lifecycleOwner, new TeacherDetailsActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m209initView$lambda2(TeacherDetailsActivity teacherDetailsActivity, StateData stateData) {
        TeacherDeatilsAdapter teacherDeatilsAdapter;
        Intrinsics.checkNotNullParameter(teacherDetailsActivity, "this$0");
        LoadStatusView loadStatusView = teacherDetailsActivity.getBinding().loadStatusView;
        if (loadStatusView != null) {
            loadStatusView.restoreView();
        }
        boolean z = true;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            Intrinsics.checkNotNullExpressionValue(stateData, "it");
            teacherDetailsActivity.showHeaderDataEmpty(CommonKtxKt.formatBadResult(stateData));
        } else if (stateData.getData() != null) {
            TeacherDetailsHeader teacherDetailsHeader = (TeacherDetailsHeader) stateData.getData();
            if (teacherDetailsHeader != null) {
                ArraysKt.shuffle(teacherDetailsActivity.mTeacherAvBgs);
                ImageView imageView = teacherDetailsActivity.getBinding().ivTeacherAvBg;
                if (imageView != null) {
                    imageView.setImageResource(teacherDetailsActivity.mTeacherAvBgs[0]);
                }
                ImageView imageView2 = teacherDetailsActivity.getBinding().ivTeacherAv;
                if (imageView2 != null) {
                    XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, imageView2, (Context) teacherDetailsActivity, teacherDetailsHeader.getAvatar(), SizeUtils.dp2px(10.0f), 0, R.drawable.icon_think_launch, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
                }
                String name = teacherDetailsHeader.getName();
                if (name == null) {
                    name = "";
                }
                teacherDetailsActivity.mTeacherName = name;
                TextView textView = teacherDetailsActivity.getBinding().tvTeacherName;
                if (textView != null) {
                    textView.setText(teacherDetailsHeader.getName());
                }
                CharSequence education = teacherDetailsHeader.getEducation();
                if (education == null || StringsKt.isBlank(education)) {
                    TextView textView2 = teacherDetailsActivity.getBinding().tvTeacherSchool;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                } else {
                    TextView textView3 = teacherDetailsActivity.getBinding().tvTeacherSchool;
                    if (textView3 != null) {
                        textView3.setText(teacherDetailsHeader.getEducation());
                    }
                    TextView textView4 = teacherDetailsActivity.getBinding().tvTeacherSchool;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                }
                CharSequence identityTag = teacherDetailsHeader.getIdentityTag();
                if (identityTag == null || StringsKt.isBlank(identityTag)) {
                    TextView textView5 = teacherDetailsActivity.getBinding().tvTeacherIdentity;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                } else {
                    TextView textView6 = teacherDetailsActivity.getBinding().tvTeacherIdentity;
                    if (textView6 != null) {
                        textView6.setText(teacherDetailsHeader.getIdentityTag());
                    }
                    TextView textView7 = teacherDetailsActivity.getBinding().tvTeacherIdentity;
                    if (textView7 != null) {
                        textView7.setVisibility(0);
                    }
                }
                Collection highlightList = teacherDetailsHeader.getHighlightList();
                if (highlightList == null || highlightList.isEmpty()) {
                    AutoLineFeedLayout autoLineFeedLayout = teacherDetailsActivity.getBinding().autoLineFeedLayout;
                    if (autoLineFeedLayout != null) {
                        autoLineFeedLayout.setVisibility(8);
                    }
                } else {
                    List<String> highlightList2 = teacherDetailsHeader.getHighlightList();
                    if (highlightList2 != null) {
                        for (String text : highlightList2) {
                            TeacherLabelView teacherLabelView = new TeacherLabelView((Context) teacherDetailsActivity, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                            teacherLabelView.setText(text);
                            AutoLineFeedLayout autoLineFeedLayout2 = teacherDetailsActivity.getBinding().autoLineFeedLayout;
                            if (autoLineFeedLayout2 != null) {
                                autoLineFeedLayout2.addView(teacherLabelView);
                            }
                        }
                    }
                    AutoLineFeedLayout autoLineFeedLayout3 = teacherDetailsActivity.getBinding().autoLineFeedLayout;
                    if (autoLineFeedLayout3 != null) {
                        autoLineFeedLayout3.setVisibility(0);
                    }
                }
                teacherDetailsActivity.nodeHeaderList = teacherDetailsHeader.getNodeList();
                List<BaseNode> nodeList = teacherDetailsHeader.getNodeList();
                teacherDetailsActivity.classPosition = nodeList == null ? 0 : nodeList.size();
                Collection nodeList2 = teacherDetailsHeader.getNodeList();
                if (nodeList2 != null && !nodeList2.isEmpty()) {
                    z = false;
                }
                if (!z && (teacherDeatilsAdapter = teacherDetailsActivity.mTeacherDeatilsAdapter) != null) {
                    teacherDeatilsAdapter.setList(teacherDetailsHeader.getNodeList());
                }
                ShopTrack.INSTANCE.hw_shop_teacher_pv(String.valueOf(teacherDetailsActivity.mTeacherId), teacherDetailsActivity.mTeacherName);
            }
            teacherDetailsActivity.getListData();
        } else {
            showHeaderDataEmpty$default(teacherDetailsActivity, (String) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m210initView$lambda4(TeacherDetailsActivity teacherDetailsActivity, StateData stateData) {
        TeacherDetailsList teacherDetailsList;
        Intrinsics.checkNotNullParameter(teacherDetailsActivity, "this$0");
        teacherDetailsActivity.getListError();
        LoadStatusView loadStatusView = teacherDetailsActivity.getBinding().loadStatusView;
        if (loadStatusView != null) {
            loadStatusView.restoreView();
        }
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1 && stateData.getData() != null && (teacherDetailsList = (TeacherDetailsList) stateData.getData()) != null) {
            Collection nodeList = teacherDetailsList.getNodeList();
            if (!(nodeList == null || nodeList.isEmpty())) {
                Collection collection = teacherDetailsActivity.nodeHeaderList;
                if (!(collection == null || collection.isEmpty())) {
                    teacherDetailsActivity.getBinding().headerLabel.setVisibility(0);
                    teacherDetailsActivity.setSeleted(true);
                }
                TeacherDeatilsAdapter teacherDeatilsAdapter = teacherDetailsActivity.mTeacherDeatilsAdapter;
                if (teacherDeatilsAdapter != null) {
                    List<BaseNode> nodeList2 = teacherDetailsList.getNodeList();
                    Intrinsics.checkNotNull(nodeList2);
                    teacherDeatilsAdapter.addData(nodeList2);
                }
            }
        }
    }

    private final void initListener() {
        LinearLayout linearLayout = getBinding().headerLabelOne;
        if (linearLayout != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(linearLayout, 300, new TeacherDetailsActivity$initListener$1(this));
        }
        LinearLayout linearLayout2 = getBinding().headerLabelTwo;
        if (linearLayout2 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(linearLayout2, 300, new TeacherDetailsActivity$initListener$2(this));
        }
    }

    private final void initTitle() {
        TitleBar titleBar = getBinding().titleView;
        if (titleBar != null) {
            titleBar.setLineVisible(false);
        }
        TitleBar titleBar2 = getBinding().titleView;
        if (titleBar2 != null) {
            titleBar2.setOnTitleBarListener(new TeacherDetailsActivity$initTitle$1(this));
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = SizeUtils.dp2px(136.0f);
        getBinding().appBarLayout.addOnOffsetChangedListener(new TeacherDetailsActivity$$ExternalSyntheticLambda4(this, intRef));
    }

    /* access modifiers changed from: private */
    /* renamed from: initTitle$lambda-5  reason: not valid java name */
    public static final void m208initTitle$lambda5(TeacherDetailsActivity teacherDetailsActivity, Ref.IntRef intRef, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(teacherDetailsActivity, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$height");
        TitleBar titleBar = teacherDetailsActivity.getBinding().titleView;
        if (titleBar != null) {
            titleBar.setTitle(intRef.element < Math.abs(i) ? teacherDetailsActivity.mTeacherName : "");
        }
    }

    private final void initAdapter() {
        BaseQuickAdapter baseQuickAdapter;
        this.mTeacherDeatilsAdapter = new TeacherDeatilsAdapter();
        this.mLinearLayoutManager = new LinearLayoutManager((Context) this, 1, false);
        getBinding().recycleView.setLayoutManager(this.mLinearLayoutManager);
        getBinding().recycleView.setAdapter(this.mTeacherDeatilsAdapter);
        View mFootView = getMFootView();
        if (!(mFootView == null || mFootView.getParent() != null || (baseQuickAdapter = this.mTeacherDeatilsAdapter) == null)) {
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, mFootView, 0, 0, 6, (Object) null);
        }
        TeacherDeatilsAdapter teacherDeatilsAdapter = this.mTeacherDeatilsAdapter;
        if (teacherDeatilsAdapter != null) {
            teacherDeatilsAdapter.setOnItemClickListener(new TeacherDetailsActivity$$ExternalSyntheticLambda3(this));
        }
        getBinding().recycleView.setOnScrollChangeListener(new TeacherDetailsActivity$$ExternalSyntheticLambda0(this));
        getBinding().recycleView.addOnScrollListener(new TeacherDetailsActivity$initAdapter$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initAdapter$lambda-9  reason: not valid java name */
    public static final void m207initAdapter$lambda9(TeacherDetailsActivity teacherDetailsActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String num;
        RecordedSpec spec;
        List<RecordedTeacherItem> teacherList;
        RecordedTeacherItem recordedTeacherItem;
        String sysName;
        String subject;
        String l;
        Intrinsics.checkNotNullParameter(teacherDetailsActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        TeacherDeatilsAdapter teacherDeatilsAdapter = teacherDetailsActivity.mTeacherDeatilsAdapter;
        Object obj = null;
        BaseNode baseNode = teacherDeatilsAdapter == null ? null : (BaseNode) teacherDeatilsAdapter.getItem(i);
        if (baseNode instanceof ShopClassGoodsData) {
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            String valueOf = String.valueOf(teacherDetailsActivity.mTeacherId);
            String str6 = teacherDetailsActivity.mTeacherName;
            ShopClassGoodsData shopClassGoodsData = (ShopClassGoodsData) baseNode;
            ShopClassGoodsSpecData spec2 = shopClassGoodsData.getSpec();
            shopTrack.hw_shop_teacher_classes_click(valueOf, str6, spec2 == null ? -1 : spec2.getClazzId());
            XesRoute instance = XesRoute.getInstance();
            Bundle bundle = new Bundle();
            bundle.putString("skuId", String.valueOf(shopClassGoodsData.getId()));
            ShopClassGoodsSpecData spec3 = shopClassGoodsData.getSpec();
            if (spec3 != null) {
                obj = Integer.valueOf(spec3.getClazzId());
            }
            bundle.putString(LearnMaterialsListActivityKt.CLASSID, String.valueOf(obj));
            Unit unit = Unit.INSTANCE;
            instance.navigation("/shop/class_detail_activity", bundle);
        } else if (baseNode instanceof TeacherVideoNode) {
            ShopTrack.INSTANCE.hw_shop_teacher_video_click(String.valueOf(teacherDetailsActivity.mTeacherId), teacherDetailsActivity.mTeacherName);
            teacherDetailsActivity.gotoPlay((TeacherVideoNode) baseNode);
        } else if (baseNode instanceof ShopRecordedItemData) {
            Bundle bundle2 = new Bundle();
            StringBuilder sb = new StringBuilder();
            sb.append(UrlUtils.INSTANCE.getTouchAppV2Host());
            sb.append("/courses/recorded-detail/");
            ShopRecordedItemData shopRecordedItemData = (ShopRecordedItemData) baseNode;
            sb.append(shopRecordedItemData.getId());
            bundle2.putString("jump_key", sb.toString());
            boolean z = true;
            bundle2.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle("").setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle2);
            ShopTrack shopTrack2 = ShopTrack.INSTANCE;
            String title = shopRecordedItemData.getTitle();
            if (title == null) {
                str = "";
            } else {
                str = title;
            }
            Long id = shopRecordedItemData.getId();
            if (id == null || (l = id.toString()) == null) {
                str2 = "";
            } else {
                str2 = l;
            }
            RecordedSpec spec4 = shopRecordedItemData.getSpec();
            if (spec4 == null || (subject = spec4.getSubject()) == null) {
                str3 = "";
            } else {
                str3 = subject;
            }
            RecordedSpec spec5 = shopRecordedItemData.getSpec();
            if (spec5 != null) {
                obj = spec5.getTeacherList();
            }
            Collection collection = (Collection) obj;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (z || (spec = shopRecordedItemData.getSpec()) == null || (teacherList = spec.getTeacherList()) == null || (recordedTeacherItem = teacherList.get(0)) == null || (sysName = recordedTeacherItem.getSysName()) == null) {
                str4 = "";
            } else {
                str4 = sysName;
            }
            Integer showPrice = shopRecordedItemData.getShowPrice();
            if (showPrice == null || (num = showPrice.toString()) == null) {
                str5 = "";
            } else {
                str5 = num;
            }
            shopTrack2.hw_recorded_class_card_click(str, str2, str3, str4, str5, "teacher detail页面");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initAdapter$lambda-10  reason: not valid java name */
    public static final void m206initAdapter$lambda10(TeacherDetailsActivity teacherDetailsActivity, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(teacherDetailsActivity, "this$0");
        LinearLayoutManager linearLayoutManager = teacherDetailsActivity.mLinearLayoutManager;
        boolean z = false;
        int findFirstVisibleItemPosition = linearLayoutManager == null ? 0 : linearLayoutManager.findFirstVisibleItemPosition();
        teacherDetailsActivity.startPosition = findFirstVisibleItemPosition;
        int i5 = teacherDetailsActivity.classPosition;
        if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < i5) {
            z = true;
        }
        teacherDetailsActivity.setSeleted(z);
    }

    /* access modifiers changed from: private */
    public final void getHeaderData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        }
        getMViewModel().getTeacherDetailsHeader(this.mTeacherId);
    }

    private final void getListData() {
        getMViewModel().getTeacherDetailsList((Context) this, this.mTeacherId);
    }

    static /* synthetic */ void showHeaderDataEmpty$default(TeacherDetailsActivity teacherDetailsActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        teacherDetailsActivity.showHeaderDataEmpty(str);
    }

    private final void showHeaderDataEmpty(String str) {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            int i = R.drawable.fail_internet_connection;
            String string = getString(R.string.data_is_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_is_empty)");
            String string2 = getString(R.string.fail_btn_hint);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.fail_btn_hint)");
            loadStatusView.showErrorView(i, string, string2, str, new TeacherDetailsActivity$showHeaderDataEmpty$1(this));
        }
        LoadStatusView loadStatusView2 = getBinding().loadStatusView;
        if (loadStatusView2 != null) {
            loadStatusView2.setContentBg(R.color.color_f4f6fa);
        }
    }

    private final void getListError() {
        getBinding().headerLabel.setVisibility(8);
    }

    static /* synthetic */ void setSeleted$default(TeacherDetailsActivity teacherDetailsActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        teacherDetailsActivity.setSeleted(z);
    }

    /* access modifiers changed from: private */
    public final void setSeleted(boolean z) {
        if (z) {
            TextView textView = getBinding().headerLabelTvOne;
            if (textView != null) {
                textView.setSelected(true);
            }
            RoundLinearLayout roundLinearLayout = getBinding().headerLabelInOne;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(0);
            }
            TextView textView2 = getBinding().headerLabelTvTwo;
            if (textView2 != null) {
                textView2.setSelected(false);
            }
            RoundLinearLayout roundLinearLayout2 = getBinding().headerLabelInTwo;
            if (roundLinearLayout2 != null) {
                roundLinearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = getBinding().headerLabelTvTwo;
        if (textView3 != null) {
            textView3.setSelected(true);
        }
        RoundLinearLayout roundLinearLayout3 = getBinding().headerLabelInTwo;
        if (roundLinearLayout3 != null) {
            roundLinearLayout3.setVisibility(0);
        }
        TextView textView4 = getBinding().headerLabelTvOne;
        if (textView4 != null) {
            textView4.setSelected(false);
        }
        RoundLinearLayout roundLinearLayout4 = getBinding().headerLabelInOne;
        if (roundLinearLayout4 != null) {
            roundLinearLayout4.setVisibility(8);
        }
    }

    private final void gotoPlay(TeacherVideoNode teacherVideoNode) {
        if (teacherVideoNode != null) {
            XesRoute instance = XesRoute.getInstance();
            Bundle bundle = new Bundle();
            List arrayList = new ArrayList();
            String videoUrl = teacherVideoNode.getVideoUrl();
            if (videoUrl == null) {
                videoUrl = "";
            }
            arrayList.add(videoUrl);
            bundle.putSerializable(HwCommonPlayerActivity.COMMON_PLAYER_PARAMS, new HwCommonPlayerParams("", VideoPlayerSceneType.SHOP_TEACHER_DETAILS, arrayList));
            Unit unit = Unit.INSTANCE;
            instance.navigation("/study/hw_common_player_activity", bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        TeacherDetailsActivity.super.onStart();
        ShopTrack.INSTANCE.hw_shop_teacher_pv(String.valueOf(this.mTeacherId), this.mTeacherName);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        TeacherDetailsActivity.super.onStop();
        ShopTrack.INSTANCE.hw_shop_teacher_leave(String.valueOf(this.mTeacherId), this.mTeacherName);
    }

    /* access modifiers changed from: protected */
    public ActivityTeacherDetailsBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityTeacherDetailsBinding inflate = ActivityTeacherDetailsBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
