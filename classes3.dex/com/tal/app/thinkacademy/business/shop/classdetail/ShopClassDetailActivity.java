package com.tal.app.thinkacademy.business.shop.classdetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.flyco.roundview.RoundTextView;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.CanGotoBuyExtra;
import com.tal.app.thinkacademy.business.shop.bean.CategoryTaxInfo;
import com.tal.app.thinkacademy.business.shop.bean.CheckCanGotoBuyBean;
import com.tal.app.thinkacademy.business.shop.bean.CouponRecommendUseCouponInfo;
import com.tal.app.thinkacademy.business.shop.bean.QueryCategoryTaxInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponseGrade;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailCourseInfo;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailGrade;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTrialLesson;
import com.tal.app.thinkacademy.business.shop.bean.ShopCouponRecommendInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopDetailPositionLocationInfo;
import com.tal.app.thinkacademy.business.shop.bean.StudentFollowCheckResult;
import com.tal.app.thinkacademy.business.shop.bean.UserInfo;
import com.tal.app.thinkacademy.business.shop.bean.request.ContactVerifyRequest;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindPhoneDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkEMailDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.LinkPhoneNumberDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.NotSupportActivityDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.RedeemCodeSuccessDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.RedeemQualificationDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ReminderTwoButton;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.SignUpReminderDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.TakeAdmissionDialog;
import com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.entity.HwCommonPlayerParams;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u001a\b\u0007\u0018\u0000 \u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020FH\u0002J\u0018\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u001dH\u0014J\b\u0010L\u001a\u00020FH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010@2\u0006\u0010N\u001a\u00020\bH\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001dH\u0002J\u0012\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010+H\u0002J\b\u0010T\u001a\u00020FH\u0002J\u0012\u0010U\u001a\u00020F2\b\u0010V\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010W\u001a\u00020FH\u0002J\b\u0010X\u001a\u00020FH\u0002J\b\u0010Y\u001a\u00020FH\u0002J\u001a\u0010Z\u001a\u00020F2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\H\u0002J\u0012\u0010^\u001a\u00020F2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\b\u0010a\u001a\u00020FH\u0002J\b\u0010b\u001a\u00020FH\u0002J\b\u0010c\u001a\u00020FH\u0002J\b\u0010d\u001a\u00020FH\u0002J\b\u0010e\u001a\u00020FH\u0002J\b\u0010f\u001a\u00020\u001dH\u0002J\u0010\u0010g\u001a\u00020F2\u0006\u0010h\u001a\u00020\bH\u0002J\u0012\u0010i\u001a\u00020F2\b\u0010j\u001a\u0004\u0018\u00010kH\u0014J\b\u0010l\u001a\u00020FH\u0014J\b\u0010m\u001a\u00020FH\u0014J\b\u0010n\u001a\u00020FH\u0002J\b\u0010o\u001a\u00020FH\u0002J\b\u0010p\u001a\u00020FH\u0002J\b\u0010q\u001a\u00020FH\u0002J\u0010\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020\u001dH\u0002J\u0010\u0010t\u001a\u00020F2\u0006\u0010u\u001a\u00020\u001dH\u0002J\u0012\u0010v\u001a\u00020F2\b\u0010w\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010x\u001a\u00020F2\b\u0010y\u001a\u0004\u0018\u00010\u00122\b\u0010z\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010{\u001a\u00020FH\u0002J\u0012\u0010|\u001a\u00020F2\b\u0010}\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010~\u001a\u00020FH\u0002J\u0013\u0010\u001a\u00020F2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\u001d\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\u00122\t\u0010S\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J/\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\b\u0010y\u001a\u0004\u0018\u00010\u00122\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010N\u001a\u00020\bH\u0002J\t\u0010\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R*\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020@0?j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020@`AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivityShopClassDetailBinding;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailAdapter;", "mBaseTop", "", "mBinderEmailDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/BindEmailDialog;", "mBinderPhoneDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/BindPhoneDialog;", "mBtnBuyState", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel$DetailBuySate;", "mCancelStuFollowDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton;", "mClassId", "", "mCommonReminder", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/SignUpReminderDialog;", "mCourseHighLightsDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/CourseHighLightsDialog;", "mFootView", "Landroid/view/View;", "mHandler", "com/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$mHandler$1", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$mHandler$1;", "mIsHasReportScrollItem", "", "mIsOnResume", "mIsShowAdmissionDialog", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLinkEmailDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/LinkEMailDialog;", "mLinkNumberDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/LinkPhoneNumberDialog;", "mNotSupportActivityDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/NotSupportActivityDialog;", "mPriceInfoDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PriceInfoDialog;", "mQueryCategoryTaxInfoBean", "Lcom/tal/app/thinkacademy/business/shop/bean/QueryCategoryTaxInfoBean;", "mRedeemCodeSuccessDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/RedeemCodeSuccessDialog;", "mRedeemQualificationDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/RedeemQualificationDialog;", "mRemainTime", "", "mSchoolCode", "mShopClassDetailInfoBean", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailInfoBean;", "mShopCouponRecommendInfoBean", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopCouponRecommendInfoBean;", "mSkuId", "mStuFollowState", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$StuFollowState;", "mStuFollowSuccessDialog", "mStudentInfo", "Lcom/tal/app/thinkacademy/business/shop/classdetail/StudentInfo;", "mTabHeight", "mTabLayoutIndexMap", "Ljava/util/HashMap;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopDetailPositionLocationInfo;", "Lkotlin/collections/HashMap;", "mTakeAdmissionDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/TakeAdmissionDialog;", "mTempIsWished", "addFootView", "", "checkAndUpdateIndication", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "diagnosisProcess", "findTabLayoutPositionInfo", "pos", "getBuyBtnLayoutParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isMatchParent", "getTaxPrice", "info", "goToShare", "gotoAdmissionTest", "examId", "gotoBuy", "gotoLogin", "gotoOrderPage", "gotoPlay", "trialLessons", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTrialLesson;", "gotoSuitableFor", "portrait", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPortrait;", "hideFullLoading", "initData", "initRecyclerViewFoot", "initScrollListen", "initView", "isCanGotoBuy", "listScrollByTabIndex", "index", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeFootView", "reportScrollItem", "requestDetail", "setFullState", "setTopBarTitle", "isDefault", "setWishBtnState", "isWish", "showBindEmailDialog", "email", "showBindPhoneDialog", "phone", "callCode", "showCancelStudFollowDialog", "showCommonBuyReminder", "str", "showFullEmpty", "showFullError", "msg", "showFullLoading", "showLinkEmailDialog", "showLinkNumberDialog", "showNotSupportActivityDialog", "showRedeemDialog", "showRedeemSuccessDialog", "code", "Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponse;", "showStuFollowSuccessDialog", "showTakeAdmissionDialog", "times", "updateBuyArea", "updateCouponInfo", "updateDownTime", "updateTabIndication", "updateTabLayout", "Companion", "StuFollowState", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
public final class ShopClassDetailActivity extends BaseVmActivity<ShopClassDetailViewModel, ActivityShopClassDetailBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ShopClassDetailActivity";
    private static final int WHAT_UPDATE_TIME = 1;
    private ShopClassDetailAdapter mAdapter = new ShopClassDetailAdapter();
    private int mBaseTop = SizeUtils.dp2px(40.0f);
    private BindEmailDialog mBinderEmailDialog;
    private BindPhoneDialog mBinderPhoneDialog;
    /* access modifiers changed from: private */
    public ShopClassDetailViewModel.DetailBuySate mBtnBuyState = ShopClassDetailViewModel.DetailBuySate.Enroll;
    private ReminderTwoButton mCancelStuFollowDialog;
    /* access modifiers changed from: private */
    public String mClassId = "0";
    private SignUpReminderDialog mCommonReminder;
    private CourseHighLightsDialog mCourseHighLightsDialog;
    private View mFootView;
    private final ShopClassDetailActivity$mHandler$1 mHandler;
    /* access modifiers changed from: private */
    public boolean mIsHasReportScrollItem;
    private boolean mIsOnResume;
    /* access modifiers changed from: private */
    public boolean mIsShowAdmissionDialog;
    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager((Context) this, 1, false);
    private LinkEMailDialog mLinkEmailDialog;
    private LinkPhoneNumberDialog mLinkNumberDialog;
    private NotSupportActivityDialog mNotSupportActivityDialog;
    private PriceInfoDialog mPriceInfoDialog;
    private QueryCategoryTaxInfoBean mQueryCategoryTaxInfoBean;
    private RedeemCodeSuccessDialog mRedeemCodeSuccessDialog;
    private RedeemQualificationDialog mRedeemQualificationDialog;
    private long mRemainTime;
    private String mSchoolCode;
    /* access modifiers changed from: private */
    public ShopClassDetailInfoBean mShopClassDetailInfoBean;
    private ShopCouponRecommendInfoBean mShopCouponRecommendInfoBean;
    /* access modifiers changed from: private */
    public String mSkuId = "0";
    private StuFollowState mStuFollowState;
    private ReminderTwoButton mStuFollowSuccessDialog;
    private StudentInfo mStudentInfo;
    private int mTabHeight = SizeUtils.dp2px(34.0f);
    private HashMap<Integer, ShopDetailPositionLocationInfo> mTabLayoutIndexMap = new HashMap<>();
    private TakeAdmissionDialog mTakeAdmissionDialog;
    /* access modifiers changed from: private */
    public boolean mTempIsWished;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$StuFollowState;", "", "(Ljava/lang/String;I)V", "FOLLOW_UNKNOWN", "FOLLOW_CAN_ADDED", "FOLLOW_CAN_CANCEL", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    private enum StuFollowState {
        FOLLOW_UNKNOWN,
        FOLLOW_CAN_ADDED,
        FOLLOW_CAN_CANCEL
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ShopClassDetailViewModel.DetailBuySate.values().length];
            iArr[ShopClassDetailViewModel.DetailBuySate.Full.ordinal()] = 1;
            iArr[ShopClassDetailViewModel.DetailBuySate.AutoPay.ordinal()] = 2;
            iArr[ShopClassDetailViewModel.DetailBuySate.CourseEnd.ordinal()] = 3;
            iArr[ShopClassDetailViewModel.DetailBuySate.ForSell.ordinal()] = 4;
            iArr[ShopClassDetailViewModel.DetailBuySate.Coupon.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[StuFollowState.values().length];
            iArr2[StuFollowState.FOLLOW_CAN_ADDED.ordinal()] = 1;
            iArr2[StuFollowState.FOLLOW_CAN_CANCEL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[StateData.DataStatus.values().length];
            iArr3[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public ShopClassDetailActivity() {
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
        this.mSchoolCode = string;
        this.mStuFollowState = StuFollowState.FOLLOW_UNKNOWN;
        this.mHandler = new ShopClassDetailActivity$mHandler$1(this, Looper.getMainLooper());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$Companion;", "", "()V", "TAG", "", "WHAT_UPDATE_TIME", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ShopClassDetailActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        StudentInfo studentInfo = new StudentInfo(getMViewModel(), (XesBaseActivity) this, new ShopClassDetailActivity$onCreate$1(this));
        this.mStudentInfo = studentInfo;
        studentInfo.viewmModelObserve();
        initView();
        initScrollListen();
        initData();
    }

    private final void initView() {
        setTopBarTitle(true);
        TextView titleView = getBinding().titleView.getTitleView();
        if (titleView != null) {
            titleView.setEllipsize(TextUtils.TruncateAt.END);
        }
        getBinding().recyclerView.setLayoutManager(this.mLinearLayoutManager);
        getBinding().recyclerView.setAdapter(this.mAdapter);
        initRecyclerViewFoot();
        this.mAdapter.addChildClickViewIds(new int[]{R.id.price_desc_btn, R.id.course_high_lights_title, R.id.teaching_video, R.id.suit_info, R.id.tv_class_phone_num});
        this.mAdapter.setOnItemClickListener(new ShopClassDetailActivity$$ExternalSyntheticLambda7(this));
        this.mAdapter.setOnItemChildClickListener(new ShopClassDetailActivity$$ExternalSyntheticLambda6(this));
        getBinding().btnGotoBuy.setOnClickListener(new ShopClassDetailActivity$$ExternalSyntheticLambda9(this));
        getBinding().titleView.setOnTitleBarListener(new ShopClassDetailActivity$initView$4(this));
        getBinding().btnWish.setOnClickListener(new ShopClassDetailActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m244initView$lambda0(ShopClassDetailActivity shopClassDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ShopClassDetailSpec spec;
        ShopClassDetailCourseInfo courseInfo;
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj instanceof MultiItemEntity) {
            int itemType = ((MultiItemEntity) obj).getItemType();
            if (itemType == ShopClassDetailItemType.TeacherCard.getType()) {
                if (obj instanceof ShopClassDetailTeacher) {
                    ShopClassDetailTeacher shopClassDetailTeacher = (ShopClassDetailTeacher) obj;
                    if (shopClassDetailTeacher.getTeacherType() == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("teacherId", shopClassDetailTeacher.getTeacherId());
                        XesRoute.getInstance().navigation("/shop/teacher_details_activity", bundle);
                        ShopTrack.INSTANCE.hw_teacher_click(shopClassDetailActivity.mClassId, String.valueOf(shopClassDetailTeacher.getTeacherId()), ShopTrack.ShopPageType.SHOP_CLASS_DETAIL.getType());
                    }
                }
            } else if (itemType == ShopClassDetailItemType.ScheduleMore.getType()) {
                ShopClassDetailDataManager instance = ShopClassDetailDataManager.Companion.getInstance();
                ShopClassDetailInfoBean shopClassDetailInfoBean = shopClassDetailActivity.mShopClassDetailInfoBean;
                List<ShopClassDetailSyllabu> list = null;
                instance.setMDetailOperation(shopClassDetailInfoBean == null ? null : shopClassDetailInfoBean.getLocal_class_detail_operation());
                ShopClassDetailDataManager instance2 = ShopClassDetailDataManager.Companion.getInstance();
                ShopClassDetailInfoBean shopClassDetailInfoBean2 = shopClassDetailActivity.mShopClassDetailInfoBean;
                if (!(shopClassDetailInfoBean2 == null || (spec = shopClassDetailInfoBean2.getSpec()) == null || (courseInfo = spec.getCourseInfo()) == null)) {
                    list = courseInfo.getSyllabus();
                }
                instance2.setMSyllabusList(list);
                shopClassDetailActivity.startActivity(new Intent((Context) shopClassDetailActivity, SyllabusScheduleActivity.class));
                ShopTrack.INSTANCE.hw_syllabus_click(shopClassDetailActivity.mClassId);
            } else if (itemType == ShopClassDetailItemType.Admission.getType()) {
                shopClassDetailActivity.showLoading();
                StudentInfo studentInfo = shopClassDetailActivity.mStudentInfo;
                if (studentInfo != null) {
                    studentInfo.getAccountList(AccountListTypeEnum.Admission);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0097, code lost:
        r6 = r6.getHighlight();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: initView$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m245initView$lambda4(com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailActivity r4, com.chad.library.adapter.base.BaseQuickAdapter r5, android.view.View r6, int r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r6 = r6.getId()
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.price_desc_btn
            r1 = 0
            if (r6 != r0) goto L_0x004f
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog r5 = r4.mPriceInfoDialog
            if (r5 != 0) goto L_0x0026
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog r5 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog
            r6 = r4
            android.content.Context r6 = (android.content.Context) r6
            r5.<init>(r6)
            r4.mPriceInfoDialog = r5
        L_0x0026:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog r5 = r4.mPriceInfoDialog
            if (r5 != 0) goto L_0x002b
            goto L_0x003e
        L_0x002b:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r6 = r4.mShopClassDetailInfoBean
            if (r6 != 0) goto L_0x0030
            goto L_0x003b
        L_0x0030:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r6 = r6.getSpec()
            if (r6 != 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            java.lang.String r1 = r6.getFeeDescClazz()
        L_0x003b:
            r5.setText(r1)
        L_0x003e:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.PriceInfoDialog r5 = r4.mPriceInfoDialog
            if (r5 != 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r5.show()
        L_0x0046:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r5 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r4 = r4.mClassId
            r5.hw_price_description_click(r4)
            goto L_0x0185
        L_0x004f:
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.course_high_lights_title
            r2 = 1
            r3 = 0
            if (r6 != r0) goto L_0x00f8
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog r6 = r4.mCourseHighLightsDialog
            if (r6 != 0) goto L_0x0063
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog r6 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            r6.<init>(r0)
            r4.mCourseHighLightsDialog = r6
        L_0x0063:
            java.util.List r5 = r5.getData()
            java.lang.Object r5 = r5.get(r7)
            boolean r6 = r5 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r6 == 0) goto L_0x0185
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog r6 = r4.mCourseHighLightsDialog
            if (r6 != 0) goto L_0x0074
            goto L_0x0085
        L_0x0074:
            r7 = r5
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r7 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r7
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r7 = r7.getDynamic()
            if (r7 != 0) goto L_0x007e
            goto L_0x0082
        L_0x007e:
            java.util.List r1 = r7.getHighlight()
        L_0x0082:
            r6.setData(r1)
        L_0x0085:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.CourseHighLightsDialog r6 = r4.mCourseHighLightsDialog
            if (r6 != 0) goto L_0x008a
            goto L_0x008d
        L_0x008a:
            r6.show()
        L_0x008d:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r5 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r5
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r6 = r5.getDynamic()
            if (r6 != 0) goto L_0x0097
        L_0x0095:
            r6 = r3
            goto L_0x00a2
        L_0x0097:
            java.util.List r6 = r6.getHighlight()
            if (r6 != 0) goto L_0x009e
            goto L_0x0095
        L_0x009e:
            int r6 = r6.size()
        L_0x00a2:
            if (r6 <= 0) goto L_0x0185
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r5 = r5.getDynamic()
            if (r5 != 0) goto L_0x00b0
            goto L_0x00e6
        L_0x00b0:
            java.util.List r5 = r5.getHighlight()
            if (r5 != 0) goto L_0x00b7
            goto L_0x00e6
        L_0x00b7:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00bd:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00e6
            java.lang.Object r0 = r5.next()
            int r1 = r3 + 1
            if (r3 >= 0) goto L_0x00ce
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00ce:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight r0 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight) r0
            java.lang.String r0 = r0.getTitle()
            r7.append(r0)
            int r0 = r6 + -1
            if (r3 >= r0) goto L_0x00e4
            r0 = 7
            if (r3 <= r0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            java.lang.String r0 = " · "
            r7.append(r0)
        L_0x00e4:
            r3 = r1
            goto L_0x00bd
        L_0x00e6:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r5 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r4 = r4.mClassId
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "stringBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r5.hw_courses_highlights_click(r4, r6)
            goto L_0x0185
        L_0x00f8:
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.teaching_video
            if (r6 != r0) goto L_0x0126
            java.util.List r5 = r5.getData()
            java.lang.Object r5 = r5.get(r7)
            boolean r6 = r5 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r6 == 0) goto L_0x0118
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r5 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r5
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r5 = r5.getStaticData()
            if (r5 != 0) goto L_0x0111
            goto L_0x0115
        L_0x0111:
            java.util.List r1 = r5.getTrialLessons()
        L_0x0115:
            r4.gotoPlay(r1)
        L_0x0118:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r5 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r4 = r4.mClassId
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopPageType r6 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopPageType.SHOP_CLASS_DETAIL
            java.lang.String r6 = r6.getType()
            r5.hw_teaching_video_click(r4, r6)
            goto L_0x0185
        L_0x0126:
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.suit_info
            if (r6 != r0) goto L_0x014e
            java.util.List r5 = r5.getData()
            java.lang.Object r5 = r5.get(r7)
            boolean r6 = r5 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r6 == 0) goto L_0x0146
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r5 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r5
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r5 = r5.getStaticData()
            if (r5 != 0) goto L_0x013f
            goto L_0x0143
        L_0x013f:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait r1 = r5.getPortrait()
        L_0x0143:
            r4.gotoSuitableFor(r1)
        L_0x0146:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r5 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r4 = r4.mClassId
            r5.hw_suitable_for_click(r4)
            goto L_0x0185
        L_0x014e:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tv_class_phone_num
            if (r6 != r5) goto L_0x0185
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r5 = r4.mShopClassDetailInfoBean
            if (r5 != 0) goto L_0x0157
            goto L_0x0185
        L_0x0157:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r5 = r5.getSpec()
            if (r5 != 0) goto L_0x015e
            goto L_0x0185
        L_0x015e:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlatformContent r5 = r5.getPlatformContent()
            if (r5 != 0) goto L_0x0165
            goto L_0x0185
        L_0x0165:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailClassRoom r5 = r5.getClassRoom()
            if (r5 != 0) goto L_0x016c
            goto L_0x0185
        L_0x016c:
            java.lang.String r5 = r5.getVenuePhone()
            if (r5 != 0) goto L_0x0173
            goto L_0x0185
        L_0x0173:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r2 = r3
        L_0x017e:
            if (r2 == 0) goto L_0x0185
            android.content.Context r4 = (android.content.Context) r4
            com.tal.app.thinkacademy.common.utils.CommonUtilsKt.startCallPhoneNumber(r5, r4)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailActivity.m245initView$lambda4(com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailActivity, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m246initView$lambda5(ShopClassDetailActivity shopClassDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        if (CommonUtilsKt.isFastClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (UserInfoBll.Companion.getInstance().isGuest()) {
            shopClassDetailActivity.gotoLogin();
            if (shopClassDetailActivity.mBtnBuyState == ShopClassDetailViewModel.DetailBuySate.Enroll) {
                ShopTrack.INSTANCE.hw_classdetal_enroll_click(shopClassDetailActivity.mClassId);
            }
        } else if (!shopClassDetailActivity.isCanGotoBuy()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            ShopClassDetailInfoBean shopClassDetailInfoBean = shopClassDetailActivity.mShopClassDetailInfoBean;
            boolean z = false;
            if (shopClassDetailInfoBean != null && shopClassDetailInfoBean.getPurchased()) {
                z = true;
            }
            if (z) {
                shopClassDetailActivity.showCommonBuyReminder(shopClassDetailActivity.getString(R.string.dialog_purchased_text));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ShopClassDetailInfoBean shopClassDetailInfoBean2 = shopClassDetailActivity.mShopClassDetailInfoBean;
            if ((shopClassDetailInfoBean2 == null ? null : shopClassDetailInfoBean2.getActivityInfo()) != null) {
                shopClassDetailActivity.showNotSupportActivityDialog();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            shopClassDetailActivity.gotoBuy();
            ShopTrack.INSTANCE.hw_classdetal_enroll_click(shopClassDetailActivity.mClassId);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-8  reason: not valid java name */
    public static final void m247initView$lambda8(ShopClassDetailActivity shopClassDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        if (UserInfoBll.Companion.getInstance().isGuest()) {
            shopClassDetailActivity.gotoLogin();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (shopClassDetailActivity.getBinding().btnWish.isSelected()) {
            ShopClassDetailInfoBean shopClassDetailInfoBean = shopClassDetailActivity.mShopClassDetailInfoBean;
            if (shopClassDetailInfoBean != null) {
                shopClassDetailActivity.showLoading();
                shopClassDetailActivity.getMViewModel().requestStuWishCancel(shopClassDetailInfoBean);
            }
        } else {
            ShopClassDetailInfoBean shopClassDetailInfoBean2 = shopClassDetailActivity.mShopClassDetailInfoBean;
            if (shopClassDetailInfoBean2 != null) {
                shopClassDetailActivity.showLoading();
                shopClassDetailActivity.getMViewModel().requestStuWishAdd(shopClassDetailInfoBean2);
            }
        }
        ShopTrack.INSTANCE.hw_wish_click(shopClassDetailActivity.mClassId);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void gotoBuy() {
        showLoading();
        StudentInfo studentInfo = this.mStudentInfo;
        if (studentInfo != null) {
            studentInfo.getAccountList(AccountListTypeEnum.GoToBuy);
        }
    }

    /* access modifiers changed from: private */
    public final void gotoAdmissionTest(String str) {
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            String touchHost = UrlUtils.INSTANCE.getTouchHost();
            Bundle bundle = new Bundle();
            StringBuffer stringBuffer = new StringBuffer(touchHost);
            stringBuffer.append("/quiz/evaluation/instruction/" + str + "?fromClientType=native");
            bundle.putString("jump_key", stringBuffer.toString());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            return;
        }
        gotoLogin();
    }

    private final void gotoLogin() {
        XesRoute instance = XesRoute.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString("login_page_path", "班级详情页");
        Unit unit = Unit.INSTANCE;
        instance.navigation("/login/login_activity", bundle);
    }

    private final boolean isCanGotoBuy() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mBtnBuyState.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4) ? false : true;
        }
        ImageView imageView = getBinding().btnWish;
        this.mTempIsWished = imageView == null ? false : imageView.isSelected();
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.mStuFollowState.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                showCancelStudFollowDialog();
                ShopTrack.INSTANCE.hw_classdetal_cancel_alerts_click(this.mClassId);
            }
            return false;
        }
        ShopTrack.INSTANCE.hw_classdetal_alerts_click(this.mClassId);
        showLoading();
        getMViewModel().checkPhoneMailBinding();
        return false;
    }

    private final void showCancelStudFollowDialog() {
        ShopTrack.INSTANCE.hw_classdetal_cancel_show(this.mClassId);
        if (this.mCancelStuFollowDialog == null) {
            ReminderTwoButton reminderTwoButton = new ReminderTwoButton((Context) this, new ShopClassDetailActivity$showCancelStudFollowDialog$1(this));
            this.mCancelStuFollowDialog = reminderTwoButton;
            reminderTwoButton.setTitle(getString(R.string.cancel_availability_alerts));
            ReminderTwoButton reminderTwoButton2 = this.mCancelStuFollowDialog;
            if (reminderTwoButton2 != null) {
                reminderTwoButton2.setButtonText(getString(R.string.tv_cancel), getString(R.string.tv_confirm));
            }
            ReminderTwoButton reminderTwoButton3 = this.mCancelStuFollowDialog;
            if (reminderTwoButton3 != null) {
                reminderTwoButton3.setButtonColor(getColor(R.color.color_f4f6fa), getColor(R.color.color_172b4d), getColor(R.color.color_fff3dc), getColor(R.color.color_ffaa0a));
            }
            ReminderTwoButton reminderTwoButton4 = this.mCancelStuFollowDialog;
            if (reminderTwoButton4 != null) {
                reminderTwoButton4.setMsgText(getString(R.string.cancel_availability_alerts_msg));
            }
        }
        ReminderTwoButton reminderTwoButton5 = this.mCancelStuFollowDialog;
        if (reminderTwoButton5 != null) {
            reminderTwoButton5.show();
        }
    }

    private final void showStuFollowSuccessDialog() {
        if (this.mTempIsWished) {
            ShopTrack.INSTANCE.hw_classdetal_notify2_show(this.mClassId);
        } else {
            ShopTrack.INSTANCE.hw_classdetal_notify1_show(this.mClassId);
        }
        if (this.mStuFollowSuccessDialog == null) {
            ReminderTwoButton reminderTwoButton = new ReminderTwoButton((Context) this, new ShopClassDetailActivity$showStuFollowSuccessDialog$1(this));
            this.mStuFollowSuccessDialog = reminderTwoButton;
            reminderTwoButton.setTitle(getString(R.string.we_will_notify_you));
            ReminderTwoButton reminderTwoButton2 = this.mStuFollowSuccessDialog;
            if (reminderTwoButton2 != null) {
                reminderTwoButton2.setButtonText(getString(R.string.detail_wish_list), getString(R.string.i_got_it));
            }
            ReminderTwoButton reminderTwoButton3 = this.mStuFollowSuccessDialog;
            if (reminderTwoButton3 != null) {
                reminderTwoButton3.setButtonColor(getColor(R.color.color_fff3dc), getColor(R.color.color_ffaa0a), getColor(R.color.color_fff3dc), getColor(R.color.color_ffaa0a));
            }
            ReminderTwoButton reminderTwoButton4 = this.mStuFollowSuccessDialog;
            if (reminderTwoButton4 != null) {
                reminderTwoButton4.setMsgText(getString(R.string.detail_stu_follow_success_msg));
            }
        }
        ReminderTwoButton reminderTwoButton5 = this.mStuFollowSuccessDialog;
        if (reminderTwoButton5 != null) {
            reminderTwoButton5.show();
        }
    }

    static /* synthetic */ void gotoPlay$default(ShopClassDetailActivity shopClassDetailActivity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        shopClassDetailActivity.gotoPlay(list);
    }

    private final void gotoPlay(List<ShopClassDetailTrialLesson> list) {
        if (list != null && (!list.isEmpty())) {
            XesRoute instance = XesRoute.getInstance();
            Bundle bundle = new Bundle();
            List arrayList = new ArrayList();
            String url = list.get(0).getUrl();
            if (url == null) {
                url = "";
            }
            arrayList.add(url);
            bundle.putSerializable(HwCommonPlayerActivity.COMMON_PLAYER_PARAMS, new HwCommonPlayerParams(list.get(0).getName(), VideoPlayerSceneType.SHOP_CLASS_DETAIL, arrayList));
            Unit unit = Unit.INSTANCE;
            instance.navigation("/study/hw_common_player_activity", bundle);
        }
    }

    private final void gotoSuitableFor(ShopClassDetailPortrait shopClassDetailPortrait) {
        ShopClassDetailDataManager instance = ShopClassDetailDataManager.Companion.getInstance();
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        instance.setMDetailOperation(shopClassDetailInfoBean == null ? null : shopClassDetailInfoBean.getLocal_class_detail_operation());
        if (shopClassDetailPortrait != null) {
            startActivity(new Intent((Context) this, SuitableForActivity.class));
        }
    }

    private final void initData() {
        String stringExtra = getIntent().getStringExtra("skuId");
        if (stringExtra == null) {
            stringExtra = "0";
        }
        this.mSkuId = stringExtra;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getMShopDetailList().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda13(this));
        getMViewModel().getMShopCouponRecommendInfoBean().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda12(this));
        getMViewModel().getMQueryCategoryTaxInfoBean().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda4(this));
        getMViewModel().getMWishAdd().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda16(this));
        getMViewModel().getMWishCancel().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda17(this));
        getMViewModel().getMStudentFollowCheck().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda3(this));
        getMViewModel().getMStuFollowAdd().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda5(this));
        getMViewModel().getMStuFollowCancel().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda15(this));
        getMViewModel().getMCheckCanGotoBuy().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda10(this));
        getMViewModel().getMRedeemCode().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getMPhoneVerify().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda11(this));
        getMViewModel().getMMailVerify().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getCheckPhoneMailBinding().observe(lifecycleOwner, new ShopClassDetailActivity$$ExternalSyntheticLambda14(this));
        getBinding().refreshLayout.setOnRefreshListener(new ShopClassDetailActivity$$ExternalSyntheticLambda8(this));
        showFullLoading();
        requestDetail();
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-13  reason: not valid java name */
    public static final void m230initData$lambda13(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.getBinding().refreshLayout.finishRefresh();
        shopClassDetailActivity.hideFullLoading();
        int i = 0;
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            List list = (List) stateData.getData();
            if ((list == null ? 0 : list.size()) > 0) {
                List list2 = (List) stateData.getData();
                MultiItemEntity multiItemEntity = list2 == null ? null : (MultiItemEntity) list2.get(0);
                if (multiItemEntity instanceof ShopClassDetailItemCommon) {
                    ShopClassDetailItemCommon shopClassDetailItemCommon = (ShopClassDetailItemCommon) multiItemEntity;
                    if (shopClassDetailItemCommon.getData() instanceof ShopClassDetailInfoBean) {
                        shopClassDetailActivity.mShopClassDetailInfoBean = (ShopClassDetailInfoBean) shopClassDetailItemCommon.getData();
                        ShopClassDetailSpec spec = ((ShopClassDetailInfoBean) shopClassDetailItemCommon.getData()).getSpec();
                        if (spec != null) {
                            i = spec.getClazzId();
                        }
                        String valueOf = String.valueOf(i);
                        shopClassDetailActivity.mClassId = valueOf;
                        shopClassDetailActivity.mAdapter.setMClassId(valueOf);
                        ShopTrack.INSTANCE.hw_shop_class_detail_pv(shopClassDetailActivity.mClassId);
                        shopClassDetailActivity.updateTabLayout();
                        shopClassDetailActivity.updateBuyArea();
                        shopClassDetailActivity.getMViewModel().requestShopCouponRecommend(shopClassDetailActivity.mShopClassDetailInfoBean);
                    }
                }
                shopClassDetailActivity.addFootView();
                shopClassDetailActivity.mAdapter.setList((Collection) stateData.getData());
                shopClassDetailActivity.hideFullLoading();
                return;
            }
            shopClassDetailActivity.showFullEmpty();
            XesLog.dt(TAG, new Object[]{"mShopDetailList 获取数据为空"});
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        shopClassDetailActivity.showFullError(CommonKtxKt.formatBadResult(stateData));
        XesLog.dt(TAG, new Object[]{"mShopDetailList 获取数据失败"});
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-14  reason: not valid java name */
    public static final void m231initData$lambda14(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            shopClassDetailActivity.mShopCouponRecommendInfoBean = (ShopCouponRecommendInfoBean) stateData.getData();
            shopClassDetailActivity.updateCouponInfo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-15  reason: not valid java name */
    public static final void m232initData$lambda15(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            shopClassDetailActivity.mQueryCategoryTaxInfoBean = (QueryCategoryTaxInfoBean) stateData.getData();
            shopClassDetailActivity.updateCouponInfo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-16  reason: not valid java name */
    public static final void m233initData$lambda16(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            shopClassDetailActivity.setWishBtnState(true);
            ToastUtils.showLong(R.string.added_to_wish_list);
            return;
        }
        ToastUtils.showLong(R.string.failed_to_add_wish_list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-17  reason: not valid java name */
    public static final void m234initData$lambda17(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            shopClassDetailActivity.setWishBtnState(false);
            ToastUtils.showLong(R.string.removed_from_wish_list);
            return;
        }
        ToastUtils.showLong(R.string.failed_to_remove_from_wish_list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-18  reason: not valid java name */
    public static final void m235initData$lambda18(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        boolean z = true;
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            StudentFollowCheckResult studentFollowCheckResult = (StudentFollowCheckResult) stateData.getData();
            if (studentFollowCheckResult != null && studentFollowCheckResult.getStatus() == 1) {
                shopClassDetailActivity.mStuFollowState = StuFollowState.FOLLOW_CAN_ADDED;
                shopClassDetailActivity.setFullState();
                return;
            }
            StudentFollowCheckResult studentFollowCheckResult2 = (StudentFollowCheckResult) stateData.getData();
            if (studentFollowCheckResult2 == null || studentFollowCheckResult2.getStatus() != 2) {
                z = false;
            }
            if (z) {
                shopClassDetailActivity.mStuFollowState = StuFollowState.FOLLOW_CAN_CANCEL;
                shopClassDetailActivity.setFullState();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-19  reason: not valid java name */
    public static final void m236initData$lambda19(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            StudentFollowCheckResult studentFollowCheckResult = (StudentFollowCheckResult) stateData.getData();
            boolean z = false;
            if (studentFollowCheckResult != null && studentFollowCheckResult.getStatus() == 0) {
                z = true;
            }
            if (z) {
                shopClassDetailActivity.mStuFollowState = StuFollowState.FOLLOW_CAN_CANCEL;
                shopClassDetailActivity.setFullState();
                shopClassDetailActivity.setWishBtnState(true);
                shopClassDetailActivity.showStuFollowSuccessDialog();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-20  reason: not valid java name */
    public static final void m237initData$lambda20(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            shopClassDetailActivity.mStuFollowState = StuFollowState.FOLLOW_CAN_ADDED;
            shopClassDetailActivity.setFullState();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-22  reason: not valid java name */
    public static final void m238initData$lambda22(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        String phone;
        String phone2;
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] != 1) {
            shopClassDetailActivity.showCommonBuyReminder(stateData.getMsg());
        } else if (stateData.getData() != null) {
            CheckCanGotoBuyBean checkCanGotoBuyBean = (CheckCanGotoBuyBean) stateData.getData();
            if (checkCanGotoBuyBean != null) {
                if (checkCanGotoBuyBean.getContinue()) {
                    shopClassDetailActivity.gotoOrderPage();
                } else if (checkCanGotoBuyBean.getHelper() != null) {
                    int status = checkCanGotoBuyBean.getHelper().getStatus();
                    String str = "";
                    int i = -1;
                    if (status == 1) {
                        CanGotoBuyExtra extra = checkCanGotoBuyBean.getHelper().getExtra();
                        int examId = extra == null ? -1 : extra.getExamId();
                        CanGotoBuyExtra extra2 = checkCanGotoBuyBean.getHelper().getExtra();
                        if (extra2 != null) {
                            i = extra2.getLeftChance();
                        }
                        CanGotoBuyExtra extra3 = checkCanGotoBuyBean.getHelper().getExtra();
                        if (!(extra3 == null || (phone = extra3.getPhone()) == null)) {
                            str = phone;
                        }
                        shopClassDetailActivity.showTakeAdmissionDialog(i, examId, str, checkCanGotoBuyBean.getHelper().getStatusDesc());
                    } else if (status == 2) {
                        CanGotoBuyExtra extra4 = checkCanGotoBuyBean.getHelper().getExtra();
                        int examId2 = extra4 == null ? -1 : extra4.getExamId();
                        CanGotoBuyExtra extra5 = checkCanGotoBuyBean.getHelper().getExtra();
                        if (extra5 != null) {
                            i = extra5.getLeftChance();
                        }
                        CanGotoBuyExtra extra6 = checkCanGotoBuyBean.getHelper().getExtra();
                        if (!(extra6 == null || (phone2 = extra6.getPhone()) == null)) {
                            str = phone2;
                        }
                        shopClassDetailActivity.showTakeAdmissionDialog(i, examId2, str, checkCanGotoBuyBean.getHelper().getStatusDesc());
                    } else if (status == 4) {
                        shopClassDetailActivity.showLinkEmailDialog();
                    } else if (status == 5) {
                        shopClassDetailActivity.showLinkNumberDialog();
                    } else if (status == 6) {
                        StudentInfo studentInfo = shopClassDetailActivity.mStudentInfo;
                        if (studentInfo != null) {
                            studentInfo.gotoPerfectInfo();
                        }
                    } else if (status != 604) {
                        shopClassDetailActivity.showCommonBuyReminder(checkCanGotoBuyBean.getHelper().getStatusDesc());
                    } else {
                        shopClassDetailActivity.showCommonBuyReminder(shopClassDetailActivity.getString(R.string.course_limit_for_new_users));
                    }
                } else {
                    shopClassDetailActivity.showCommonBuyReminder(stateData.getMsg());
                }
            }
        } else {
            shopClassDetailActivity.showCommonBuyReminder(stateData.getMsg());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-23  reason: not valid java name */
    public static final void m239initData$lambda23(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        String localRedeemCode;
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            RedeemQualificationDialog redeemQualificationDialog = shopClassDetailActivity.mRedeemQualificationDialog;
            if (redeemQualificationDialog != null) {
                redeemQualificationDialog.dismiss();
            }
            shopClassDetailActivity.requestDetail();
            RedeemCodeResponse redeemCodeResponse = (RedeemCodeResponse) stateData.getData();
            String str = "";
            if (!(redeemCodeResponse == null || (localRedeemCode = redeemCodeResponse.getLocalRedeemCode()) == null)) {
                str = localRedeemCode;
            }
            shopClassDetailActivity.showRedeemSuccessDialog(str, (RedeemCodeResponse) stateData.getData());
            return;
        }
        ToastUtils.showLong(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-24  reason: not valid java name */
    public static final void m240initData$lambda24(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            LinkPhoneNumberDialog linkPhoneNumberDialog = shopClassDetailActivity.mLinkNumberDialog;
            if (linkPhoneNumberDialog != null) {
                linkPhoneNumberDialog.dismiss();
            }
            ContactVerifyRequest contactVerifyRequest = (ContactVerifyRequest) stateData.getData();
            String str = null;
            String contactInfo = contactVerifyRequest == null ? null : contactVerifyRequest.getContactInfo();
            ContactVerifyRequest contactVerifyRequest2 = (ContactVerifyRequest) stateData.getData();
            if (contactVerifyRequest2 != null) {
                str = contactVerifyRequest2.getCountryCallingCode();
            }
            shopClassDetailActivity.showBindPhoneDialog(contactInfo, str);
            return;
        }
        ToastUtils.showLong(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-25  reason: not valid java name */
    public static final void m241initData$lambda25(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            LinkEMailDialog linkEMailDialog = shopClassDetailActivity.mLinkEmailDialog;
            if (linkEMailDialog != null) {
                linkEMailDialog.dismiss();
            }
            ContactVerifyRequest contactVerifyRequest = (ContactVerifyRequest) stateData.getData();
            shopClassDetailActivity.showBindEmailDialog(contactVerifyRequest == null ? null : contactVerifyRequest.getContactInfo());
            return;
        }
        ToastUtils.showLong(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-26  reason: not valid java name */
    public static final void m242initData$lambda26(ShopClassDetailActivity shopClassDetailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        shopClassDetailActivity.hideLoading();
        boolean z = false;
        if (WhenMappings.$EnumSwitchMapping$2[stateData.getStatus().ordinal()] == 1) {
            UserInfo userInfo = (UserInfo) stateData.getData();
            String str = null;
            CharSequence email = userInfo == null ? null : userInfo.getEmail();
            if (email == null || email.length() == 0) {
                shopClassDetailActivity.showLinkEmailDialog();
                return;
            }
            UserInfo userInfo2 = (UserInfo) stateData.getData();
            if (userInfo2 != null) {
                str = userInfo2.getPhone();
            }
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (z) {
                shopClassDetailActivity.showLinkNumberDialog();
                return;
            }
            shopClassDetailActivity.showLoading();
            shopClassDetailActivity.getMViewModel().requestStuFollowAdd(shopClassDetailActivity.mSkuId);
            return;
        }
        ToastUtils.showLong(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-27  reason: not valid java name */
    public static final void m243initData$lambda27(ShopClassDetailActivity shopClassDetailActivity, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(shopClassDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, "it");
        shopClassDetailActivity.requestDetail();
    }

    /* access modifiers changed from: private */
    public final void gotoOrderPage() {
        String touchHost = UrlUtils.INSTANCE.getTouchHost();
        Bundle bundle = new Bundle();
        StringBuffer stringBuffer = new StringBuffer(touchHost);
        stringBuffer.append("/app-v2/order/create/" + this.mSkuId + "?orderOrigin=1&fromClientType=native");
        bundle.putString("jump_key", stringBuffer.toString());
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
    }

    private final void showRedeemSuccessDialog(String str, RedeemCodeResponse redeemCodeResponse) {
        int i;
        boolean z;
        int i2;
        ShopClassDetailSpec spec;
        List<ShopClassDetailGrade> gradeList;
        List<RedeemCodeResponseGrade> gradeList2;
        List<ShopClassDetailGrade> gradeList3;
        List<RedeemCodeResponseGrade> gradeList4;
        if (this.mRedeemCodeSuccessDialog == null) {
            this.mRedeemCodeSuccessDialog = new RedeemCodeSuccessDialog((Context) this, new ShopClassDetailActivity$showRedeemSuccessDialog$1(this));
        }
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null) {
            ShopClassDetailSpec spec2 = shopClassDetailInfoBean.getSpec();
            boolean z2 = false;
            int levelDegreeStar = spec2 == null ? 0 : spec2.getLevelDegreeStar();
            ShopClassDetailSpec spec3 = shopClassDetailInfoBean.getSpec();
            int subjectId = spec3 == null ? 0 : spec3.getSubjectId();
            if (redeemCodeResponse == null || (gradeList4 = redeemCodeResponse.getGradeList()) == null) {
                i = 0;
            } else {
                i = gradeList4.size();
            }
            ShopClassDetailSpec spec4 = shopClassDetailInfoBean.getSpec();
            int size = (spec4 == null || (gradeList3 = spec4.getGradeList()) == null) ? 0 : gradeList3.size();
            if (i > 0 && size > 0 && (spec = shopClassDetailInfoBean.getSpec()) != null && (gradeList = spec.getGradeList()) != null) {
                Iterator it = gradeList.iterator();
                int i3 = 0;
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ShopClassDetailGrade shopClassDetailGrade = (ShopClassDetailGrade) next;
                    if (!(redeemCodeResponse == null || (gradeList2 = redeemCodeResponse.getGradeList()) == null)) {
                        int i5 = 0;
                        for (Object next2 : gradeList2) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (shopClassDetailGrade.getId() == ((RedeemCodeResponseGrade) next2).getGradeId()) {
                                z = true;
                                break loop0;
                            }
                            i5 = i6;
                        }
                        continue;
                    }
                    i3 = i4;
                }
            }
            z = false;
            if ((redeemCodeResponse == null ? 0 : redeemCodeResponse.getLevelDegreeStar()) >= levelDegreeStar) {
                if (redeemCodeResponse == null) {
                    i2 = 0;
                } else {
                    i2 = redeemCodeResponse.getSubjectId();
                }
                if (i2 == subjectId && z) {
                    z2 = true;
                }
            }
            RedeemCodeSuccessDialog redeemCodeSuccessDialog = this.mRedeemCodeSuccessDialog;
            if (redeemCodeSuccessDialog != null) {
                redeemCodeSuccessDialog.setData(z2, str, redeemCodeResponse);
            }
            RedeemCodeSuccessDialog redeemCodeSuccessDialog2 = this.mRedeemCodeSuccessDialog;
            if (redeemCodeSuccessDialog2 != null) {
                redeemCodeSuccessDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showLinkEmailDialog() {
        if (this.mLinkEmailDialog == null) {
            this.mLinkEmailDialog = new LinkEMailDialog((Context) this, new ShopClassDetailActivity$showLinkEmailDialog$1(this));
        }
        LinkEMailDialog linkEMailDialog = this.mLinkEmailDialog;
        if (linkEMailDialog != null) {
            linkEMailDialog.show();
        }
    }

    private final void showBindEmailDialog(String str) {
        if (this.mBinderEmailDialog == null) {
            this.mBinderEmailDialog = new BindEmailDialog((Context) this, LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new ShopClassDetailActivity$showBindEmailDialog$1(this));
        }
        BindEmailDialog bindEmailDialog = this.mBinderEmailDialog;
        if (bindEmailDialog != null) {
            BindEmailDialog.setData$default(bindEmailDialog, str, (String) null, 2, (Object) null);
        }
        BindEmailDialog bindEmailDialog2 = this.mBinderEmailDialog;
        if (bindEmailDialog2 != null) {
            bindEmailDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showLinkNumberDialog() {
        if (this.mLinkNumberDialog == null) {
            this.mLinkNumberDialog = new LinkPhoneNumberDialog((Context) this, new ShopClassDetailActivity$showLinkNumberDialog$1(this));
        }
        LinkPhoneNumberDialog linkPhoneNumberDialog = this.mLinkNumberDialog;
        if (linkPhoneNumberDialog != null) {
            linkPhoneNumberDialog.show();
        }
    }

    private final void showBindPhoneDialog(String str, String str2) {
        if (this.mBinderPhoneDialog == null) {
            this.mBinderPhoneDialog = new BindPhoneDialog((Context) this, LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new ShopClassDetailActivity$showBindPhoneDialog$1(this));
        }
        BindPhoneDialog bindPhoneDialog = this.mBinderPhoneDialog;
        if (bindPhoneDialog != null) {
            bindPhoneDialog.setData(str, str2);
        }
        BindPhoneDialog bindPhoneDialog2 = this.mBinderPhoneDialog;
        if (bindPhoneDialog2 != null) {
            bindPhoneDialog2.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ShopClassDetailActivity.super.onResume();
        ToastUtils.setGravity(17, 0, 0);
        if (this.mIsOnResume) {
            showFullLoading();
            requestDetail();
        }
        this.mIsOnResume = true;
        if (this.mShopClassDetailInfoBean != null) {
            ShopTrack.INSTANCE.hw_shop_class_detail_pv(this.mClassId);
        }
    }

    private final void showTakeAdmissionDialog(int i, int i2, String str, String str2) {
        if (i > 0) {
            this.mIsShowAdmissionDialog = true;
            ShopTrack.INSTANCE.hw_classdetal_test_show(this.mClassId);
        } else {
            this.mIsShowAdmissionDialog = false;
            ShopTrack.INSTANCE.hw_classdetal_unablesign_show(this.mClassId);
        }
        if (this.mTakeAdmissionDialog == null) {
            this.mTakeAdmissionDialog = new TakeAdmissionDialog((Context) this, new ShopClassDetailActivity$showTakeAdmissionDialog$1(this, i2));
        }
        TakeAdmissionDialog takeAdmissionDialog = this.mTakeAdmissionDialog;
        if (takeAdmissionDialog != null) {
            takeAdmissionDialog.setMClassId(this.mClassId);
        }
        TakeAdmissionDialog takeAdmissionDialog2 = this.mTakeAdmissionDialog;
        if (takeAdmissionDialog2 != null) {
            takeAdmissionDialog2.setData(i, i2, str, str2);
        }
        TakeAdmissionDialog takeAdmissionDialog3 = this.mTakeAdmissionDialog;
        if (takeAdmissionDialog3 != null) {
            takeAdmissionDialog3.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showRedeemDialog() {
        ShopTrack.INSTANCE.hw_classdetal_redeem_show(this.mClassId);
        if (this.mRedeemQualificationDialog == null) {
            this.mRedeemQualificationDialog = new RedeemQualificationDialog((Context) this, new ShopClassDetailActivity$showRedeemDialog$1(this));
        }
        RedeemQualificationDialog redeemQualificationDialog = this.mRedeemQualificationDialog;
        if (redeemQualificationDialog != null) {
            redeemQualificationDialog.setMClassId(this.mClassId);
        }
        RedeemQualificationDialog redeemQualificationDialog2 = this.mRedeemQualificationDialog;
        if (redeemQualificationDialog2 != null) {
            redeemQualificationDialog2.show();
        }
    }

    private final void showCommonBuyReminder(String str) {
        if (this.mCommonReminder == null) {
            this.mCommonReminder = new SignUpReminderDialog((Context) this);
        }
        SignUpReminderDialog signUpReminderDialog = this.mCommonReminder;
        if (signUpReminderDialog != null) {
            signUpReminderDialog.setData(str);
        }
        SignUpReminderDialog signUpReminderDialog2 = this.mCommonReminder;
        if (signUpReminderDialog2 != null) {
            signUpReminderDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    public final void requestDetail() {
        getMViewModel().requestShopClassDetail(this.mSkuId);
    }

    private final void initRecyclerViewFoot() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.lib_common_ui_list_foot;
        ViewGroup viewGroup = getBinding().recyclerView;
        this.mFootView = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
    }

    /* access modifiers changed from: private */
    public final void showFullLoading() {
        LoadStatusView loadStatusView;
        if (this.mShopClassDetailInfoBean == null && (loadStatusView = getBinding().loadStatusView) != null) {
            loadStatusView.showFullLoadingView(R.color.color_f4f6fa);
        }
    }

    private final void showFullEmpty() {
        if (this.mShopClassDetailInfoBean == null) {
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            if (loadStatusView != null) {
                int i = R.drawable.fail_internet_connection;
                String string = getString(R.string.data_is_empty);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_is_empty)");
                String string2 = getString(R.string.fail_btn_hint);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.fail_btn_hint)");
                LoadStatusView.showErrorView$default(loadStatusView, i, string, string2, (String) null, new ShopClassDetailActivity$showFullEmpty$1(this), 8, (Object) null);
            }
            LoadStatusView loadStatusView2 = getBinding().loadStatusView;
            if (loadStatusView2 != null) {
                loadStatusView2.setContentBg(R.color.color_f4f6fa);
            }
        }
    }

    private final void showFullError(String str) {
        LoadStatusView loadStatusView;
        if (this.mShopClassDetailInfoBean == null && (loadStatusView = getBinding().loadStatusView) != null) {
            LoadStatusView.showErrorView$default(loadStatusView, 0, (String) null, (String) null, str, new ShopClassDetailActivity$showFullError$1(this), 7, (Object) null);
        }
    }

    private final void hideFullLoading() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            loadStatusView.restoreView();
        }
    }

    private final void removeFootView() {
        View view = this.mFootView;
        if (view != null && view.getParent() != null) {
            this.mAdapter.removeFooterView(view);
        }
    }

    private final void addFootView() {
        View view = this.mFootView;
        if (view != null && view.getParent() == null) {
            BaseQuickAdapter.addFooterView$default(this.mAdapter, view, 0, 0, 6, (Object) null);
        }
    }

    private final void updateCouponInfo() {
        int i;
        int i2;
        List<CouponRecommendUseCouponInfo> useCouponInfo;
        List<CouponRecommendUseCouponInfo> useCouponInfo2;
        ConfigInfo.CurrencyDesc schoolCurrency = SchoolConstants.INSTANCE.getSchoolCurrency(this.mSchoolCode);
        ShopCouponRecommendInfoBean shopCouponRecommendInfoBean = this.mShopCouponRecommendInfoBean;
        if (shopCouponRecommendInfoBean != null) {
            if (shopCouponRecommendInfoBean == null || (useCouponInfo2 = shopCouponRecommendInfoBean.getUseCouponInfo()) == null) {
                i = 0;
            } else {
                i = useCouponInfo2.size();
            }
            ShopCouponRecommendInfoBean shopCouponRecommendInfoBean2 = this.mShopCouponRecommendInfoBean;
            if ((shopCouponRecommendInfoBean2 == null ? 0 : shopCouponRecommendInfoBean2.getCanUseCount()) > 0 && i > 0) {
                getBinding().couponGroup.setVisibility(0);
                getBinding().downtimeGroup.setVisibility(8);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(false));
                getBinding().btnGotoBuy.setSelected(true);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_buy_enroll);
                this.mHandler.removeMessages(1);
                getBinding().couponInfoDesc.setVisibility(0);
                ShopCouponRecommendInfoBean shopCouponRecommendInfoBean3 = this.mShopCouponRecommendInfoBean;
                if (!(shopCouponRecommendInfoBean3 == null || (useCouponInfo = shopCouponRecommendInfoBean3.getUseCouponInfo()) == null)) {
                    int i3 = 0;
                    int i4 = 0;
                    for (Object next : useCouponInfo) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i3 += ((CouponRecommendUseCouponInfo) next).getDiscount();
                        i4 = i5;
                    }
                    TextView textView = getBinding().couponInfoDesc;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getString(R.string.shop_class_detail_coupon_info_desc, new Object[]{SchoolConstants.INSTANCE.getSchoolPrice(schoolCurrency, i3)});
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.shop_…rice(currencyDesc,price))");
                    String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    textView.setText(format);
                }
                ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
                if (shopClassDetailInfoBean != null) {
                    shopClassDetailInfoBean.getShowPrice();
                    if (shopClassDetailInfoBean.getPerShowPrice() > 0) {
                        getBinding().couponDiscountedPriceCompany.setVisibility(0);
                        i2 = shopClassDetailInfoBean.getPerShowPrice();
                    } else {
                        getBinding().couponDiscountedPriceCompany.setVisibility(8);
                        QueryCategoryTaxInfoBean queryCategoryTaxInfoBean = this.mQueryCategoryTaxInfoBean;
                        if ((queryCategoryTaxInfoBean == null ? null : queryCategoryTaxInfoBean.getList()) != null) {
                            i2 = getTaxPrice(this.mQueryCategoryTaxInfoBean);
                        } else {
                            i2 = shopClassDetailInfoBean.getShowPrice();
                        }
                    }
                    getBinding().couponDiscountedPrice.setText(SchoolConstants.INSTANCE.getSchoolPrice(schoolCurrency, i2));
                }
            }
        }
    }

    private final int getTaxPrice(QueryCategoryTaxInfoBean queryCategoryTaxInfoBean) {
        int i;
        int i2;
        List<CategoryTaxInfo> list;
        boolean z = false;
        if (queryCategoryTaxInfoBean == null || (list = queryCategoryTaxInfoBean.getList()) == null) {
            i2 = 0;
            i = 0;
        } else {
            int i3 = 0;
            i2 = 0;
            i = 0;
            for (Object next : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CategoryTaxInfo categoryTaxInfo = (CategoryTaxInfo) next;
                i2 += categoryTaxInfo.getFee();
                i += categoryTaxInfo.getTax();
                i3 = i4;
            }
        }
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null && shopClassDetailInfoBean.getShowPriceIsInclude() == 0) {
            z = true;
        }
        return z ? i2 + i : i2;
    }

    private final void setWishBtnState(boolean z) {
        getBinding().btnWish.setSelected(z);
    }

    private final void setFullState() {
        if (this.mBtnBuyState == ShopClassDetailViewModel.DetailBuySate.Full) {
            getBinding().couponGroup.setVisibility(8);
            getBinding().downtimeGroup.setVisibility(8);
            getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(true));
            this.mHandler.removeMessages(1);
            int i = WhenMappings.$EnumSwitchMapping$1[this.mStuFollowState.ordinal()];
            if (i == 1) {
                getBinding().btnGotoBuy.setHasData(false);
                getBinding().btnGotoBuy.setSelected(true);
                getBinding().btnGotoBuy.setText(R.string.get_availability_alerts);
                ShopTrack.INSTANCE.hw_classdetal_alerts_show(this.mClassId);
            } else if (i != 2) {
                getBinding().btnGotoBuy.setHasData(false);
                if (UserInfoBll.Companion.getInstance().isGuest()) {
                    getBinding().btnGotoBuy.setSelected(true);
                    getBinding().btnGotoBuy.setText(R.string.get_availability_alerts);
                    ShopTrack.INSTANCE.hw_classdetal_alerts_show(this.mClassId);
                    return;
                }
                getBinding().btnGotoBuy.setSelected(false);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_buy_full);
                ShopTrack.INSTANCE.hw_classdetal_full_show(this.mClassId);
            } else {
                getBinding().btnGotoBuy.setHasData(true);
                getBinding().btnGotoBuy.setSelected(false);
                getBinding().btnGotoBuy.setText(R.string.cancel_availability_alerts);
                ShopTrack.INSTANCE.hw_classdetal_cancel_alerts_show(this.mClassId);
            }
        }
    }

    private final void showNotSupportActivityDialog() {
        if (this.mNotSupportActivityDialog == null) {
            this.mNotSupportActivityDialog = new NotSupportActivityDialog((Context) this, this.mSkuId, new ShopClassDetailActivity$showNotSupportActivityDialog$1(this));
        }
        NotSupportActivityDialog notSupportActivityDialog = this.mNotSupportActivityDialog;
        if (notSupportActivityDialog != null) {
            notSupportActivityDialog.show();
        }
    }

    private final void updateBuyArea() {
        ShopTrack.INSTANCE.hw_wish_show(this.mClassId);
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null) {
            setWishBtnState(shopClassDetailInfoBean.getInWish());
            ShopClassDetailViewModel.DetailBuySate detailBuySate = getMViewModel().getDetailBuySate(shopClassDetailInfoBean);
            this.mBtnBuyState = detailBuySate;
            int i = WhenMappings.$EnumSwitchMapping$0[detailBuySate.ordinal()];
            if (i == 1) {
                getMViewModel().requestStuFollowCheck(this.mSkuId);
                setFullState();
            } else if (i == 2) {
                getBinding().couponGroup.setVisibility(8);
                getBinding().downtimeGroup.setVisibility(8);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(true));
                getBinding().btnGotoBuy.setHasData(false);
                getBinding().btnGotoBuy.setSelected(false);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_auto_pay);
                this.mHandler.removeMessages(1);
            } else if (i == 3) {
                getBinding().couponGroup.setVisibility(8);
                getBinding().downtimeGroup.setVisibility(8);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(true));
                getBinding().btnGotoBuy.setHasData(false);
                getBinding().btnGotoBuy.setSelected(false);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_buy_course_end);
                this.mHandler.removeMessages(1);
                ShopTrack.INSTANCE.hw_classdetal_course_end(this.mClassId);
            } else if (i == 4) {
                this.mRemainTime = shopClassDetailInfoBean.getRemainSellTime();
                getBinding().couponGroup.setVisibility(8);
                getBinding().downtimeGroup.setVisibility(0);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(false));
                getBinding().btnGotoBuy.setHasData(false);
                getBinding().btnGotoBuy.setSelected(false);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_for_sale);
                updateDownTime();
            } else if (i != 5) {
                getBinding().couponGroup.setVisibility(8);
                getBinding().downtimeGroup.setVisibility(8);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(true));
                getBinding().btnGotoBuy.setSelected(true);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_buy_enroll);
                this.mHandler.removeMessages(1);
                ShopTrack.INSTANCE.hw_classdetal_enroll_show(this.mClassId);
            } else {
                getBinding().couponGroup.setVisibility(0);
                getBinding().downtimeGroup.setVisibility(8);
                getBinding().btnGotoBuy.setLayoutParams(getBuyBtnLayoutParams(false));
                getBinding().btnGotoBuy.setSelected(true);
                getBinding().btnGotoBuy.setText(R.string.shop_class_detail_buy_enroll);
                this.mHandler.removeMessages(1);
            }
        }
    }

    private final ConstraintLayout.LayoutParams getBuyBtnLayoutParams(boolean z) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, SizeUtils.dp2px(44.0f));
        if (z) {
            layoutParams.leftToRight = R.id.btn_wish;
            layoutParams.rightToRight = 0;
            layoutParams.topToBottom = R.id.coupon_info_desc;
            layoutParams.leftMargin = SizeUtils.dp2px(16.0f);
            layoutParams.rightMargin = SizeUtils.dp2px(16.0f);
            layoutParams.topMargin = SizeUtils.dp2px(8.0f);
        } else {
            layoutParams.width = SizeUtils.dp2px(120.0f);
            layoutParams.rightToRight = 0;
            layoutParams.topToBottom = R.id.coupon_info_desc;
            layoutParams.leftMargin = SizeUtils.dp2px(16.0f);
            layoutParams.rightMargin = SizeUtils.dp2px(16.0f);
            layoutParams.topMargin = SizeUtils.dp2px(8.0f);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void updateDownTime() {
        CharSequence charSequence;
        if (this.mRemainTime < 0) {
            this.mRemainTime = 0;
        }
        long j = (long) 1000;
        long j2 = this.mRemainTime / j;
        long j3 = (long) 60;
        long j4 = j2 % j3;
        long j5 = (j2 / j3) % j3;
        long j6 = (j2 / ((long) 3600)) % j3;
        long j7 = j2 / ((long) 86400);
        RoundTextView roundTextView = getBinding().downtimeDayNum;
        if (j7 < 100) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            charSequence = format;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s", Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            charSequence = format2;
        }
        roundTextView.setText(charSequence);
        TextView textView = getBinding().downtimeHourNum;
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView.setText(format3);
        TextView textView2 = getBinding().downtimeMinNum;
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String format4 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5)}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
        textView2.setText(format4);
        RoundTextView roundTextView2 = getBinding().downtimeSecNum;
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        String format5 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
        Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
        roundTextView2.setText(format5);
        long j8 = this.mRemainTime;
        if (j8 > 0) {
            this.mRemainTime = j8 - j;
            if (this.mBtnBuyState == ShopClassDetailViewModel.DetailBuySate.ForSell) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000);
            }
        }
    }

    private final void setTopBarTitle(boolean z) {
        if (z) {
            getBinding().titleView.setTitle(R.string.course_information);
            return;
        }
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null) {
            getBinding().titleView.setTitle(shopClassDetailInfoBean.getTitle());
        }
    }

    /* access modifiers changed from: private */
    public final void listScrollByTabIndex(int i) {
        ShopClassDetailInfoBean shopClassDetailInfoBean;
        List<ShopDetailPositionLocationInfo> local_class_detail_position;
        if (i >= 0 && (shopClassDetailInfoBean = this.mShopClassDetailInfoBean) != null && (local_class_detail_position = shopClassDetailInfoBean.getLocal_class_detail_position()) != null && i < local_class_detail_position.size()) {
            getBinding().recyclerView.smoothScrollToPosition(local_class_detail_position.get(i).getPosition());
        }
    }

    private final void initScrollListen() {
        getBinding().positionTabLayout.addOnTabSelectedListener(new ShopClassDetailActivity$initScrollListen$1(this));
        getBinding().recyclerView.addOnScrollListener(new ShopClassDetailActivity$initScrollListen$2(this));
    }

    /* access modifiers changed from: private */
    public final void reportScrollItem() {
        this.mIsHasReportScrollItem = true;
        int findFirstVisibleItemPosition = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.mLinearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
            if (this.mAdapter.hasHeaderLayout() && findFirstVisibleItemPosition - 1 < 0) {
                findFirstVisibleItemPosition = 0;
            }
            if (this.mAdapter.hasFooterLayout() && findLastVisibleItemPosition == this.mAdapter.getItemCount() - 1) {
                findLastVisibleItemPosition--;
            }
        }
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                int i = findFirstVisibleItemPosition + 1;
                try {
                    getMViewModel().reportItem((MultiItemEntity) this.mAdapter.getData().get(findFirstVisibleItemPosition));
                } catch (Exception unused) {
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition = i;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if ((r1.length() > 0) == true) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkAndUpdateIndication() {
        /*
            r4 = this;
            androidx.recyclerview.widget.LinearLayoutManager r0 = r4.mLinearLayoutManager
            int r0 = r0.findFirstVisibleItemPosition()
            if (r0 < 0) goto L_0x0050
            if (r0 != 0) goto L_0x0018
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding) r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r1 = r1.titleView
            int r2 = com.tal.app.thinkacademy.business.shop.R.string.course_information
            r1.setTitle(r2)
            goto L_0x004d
        L_0x0018:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r1 = r4.mShopClassDetailInfoBean
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0020
        L_0x001e:
            r2 = r3
            goto L_0x0034
        L_0x0020:
            java.lang.String r1 = r1.getTitle()
            if (r1 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0031
            r1 = r2
            goto L_0x0032
        L_0x0031:
            r1 = r3
        L_0x0032:
            if (r1 != r2) goto L_0x001e
        L_0x0034:
            if (r2 == 0) goto L_0x004d
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding r1 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding) r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r1 = r1.titleView
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r2 = r4.mShopClassDetailInfoBean
            if (r2 != 0) goto L_0x0044
            r2 = 0
            goto L_0x0048
        L_0x0044:
            java.lang.String r2 = r2.getTitle()
        L_0x0048:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setTitle(r2)
        L_0x004d:
            r4.updateTabIndication(r0)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailActivity.checkAndUpdateIndication():void");
    }

    private final void updateTabIndication(int i) {
        View findViewByPosition;
        ShopDetailPositionLocationInfo findTabLayoutPositionInfo = findTabLayoutPositionInfo(i);
        if (findTabLayoutPositionInfo != null && (findViewByPosition = this.mLinearLayoutManager.findViewByPosition(findTabLayoutPositionInfo.getPosition())) != null) {
            if (findViewByPosition.getTop() < this.mBaseTop) {
                getBinding().positionTabLayout.setVisibility(0);
                getBinding().positionTabLayout.setScrollPosition(findTabLayoutPositionInfo.getTabIndex(), 0.0f, true);
                return;
            }
            if (findTabLayoutPositionInfo.getTabIndex() == 1) {
                getBinding().positionTabLayout.setVisibility(8);
            } else {
                getBinding().positionTabLayout.setVisibility(0);
            }
            getBinding().positionTabLayout.setScrollPosition(findTabLayoutPositionInfo.getTabIndex() - 1, 0.0f, true);
        }
    }

    private final ShopDetailPositionLocationInfo findTabLayoutPositionInfo(int i) {
        List<ShopDetailPositionLocationInfo> local_class_detail_position;
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        ShopDetailPositionLocationInfo shopDetailPositionLocationInfo = null;
        if (!(shopClassDetailInfoBean == null || (local_class_detail_position = shopClassDetailInfoBean.getLocal_class_detail_position()) == null)) {
            int i2 = 0;
            for (Object next : local_class_detail_position) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                shopDetailPositionLocationInfo = (ShopDetailPositionLocationInfo) next;
                if (i < shopDetailPositionLocationInfo.getPosition()) {
                    return shopDetailPositionLocationInfo;
                }
                i2 = i3;
            }
        }
        return shopDetailPositionLocationInfo;
    }

    private final void updateTabLayout() {
        TabLayout.Tab tabAt;
        CharSequence text;
        String obj;
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null) {
            List<ShopDetailPositionLocationInfo> local_class_detail_position = shopClassDetailInfoBean.getLocal_class_detail_position();
            int i = 0;
            int size = local_class_detail_position == null ? 0 : local_class_detail_position.size();
            int tabCount = getBinding().positionTabLayout.getTabCount();
            if (size > tabCount) {
                int i2 = size - tabCount;
                int i3 = 0;
                while (i3 < i2) {
                    i3++;
                    getBinding().positionTabLayout.addTab(getBinding().positionTabLayout.newTab());
                }
            } else {
                int i4 = tabCount - size;
                int i5 = 0;
                while (i5 < i4) {
                    i5++;
                    getBinding().positionTabLayout.removeTabAt(0);
                }
            }
            List<ShopDetailPositionLocationInfo> local_class_detail_position2 = shopClassDetailInfoBean.getLocal_class_detail_position();
            if (local_class_detail_position2 != null) {
                for (Object next : local_class_detail_position2) {
                    int i6 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ShopDetailPositionLocationInfo shopDetailPositionLocationInfo = (ShopDetailPositionLocationInfo) next;
                    TabLayout.Tab tabAt2 = getBinding().positionTabLayout.getTabAt(i);
                    String str = "";
                    if (!(tabAt2 == null || (text = tabAt2.getText()) == null || (obj = text.toString()) == null)) {
                        str = obj;
                    }
                    String string = getString(shopDetailPositionLocationInfo.getTabNameResId());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(shopDetailPosi…ocationInfo.tabNameResId)");
                    if (!Intrinsics.areEqual((Object) str, (Object) string) && (tabAt = getBinding().positionTabLayout.getTabAt(i)) != null) {
                        tabAt.setText(string);
                    }
                    i = i6;
                }
            }
            checkAndUpdateIndication();
        }
    }

    /* access modifiers changed from: private */
    public final void goToShare() {
        StringBuffer stringBuffer = new StringBuffer(UrlUtils.INSTANCE.getTouchHost());
        stringBuffer.append(Intrinsics.stringPlus("/courses/detail/", this.mSkuId));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ShopClassDetailActivity.super.onDestroy();
        ShopClassDetailDataManager.Companion.getInstance().clearData();
        StudentInfo studentInfo = this.mStudentInfo;
        if (studentInfo != null) {
            studentInfo.onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    public final void diagnosisProcess() {
        ShopClassDetailInfoBean shopClassDetailInfoBean = this.mShopClassDetailInfoBean;
        if (shopClassDetailInfoBean != null) {
            showLoading();
            getMViewModel().requestCheckCanGotoBuy(shopClassDetailInfoBean);
        }
    }

    /* access modifiers changed from: protected */
    public ActivityShopClassDetailBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityShopClassDetailBinding inflate = ActivityShopClassDetailBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
