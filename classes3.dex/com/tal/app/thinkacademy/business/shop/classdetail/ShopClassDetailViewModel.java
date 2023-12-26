package com.tal.app.thinkacademy.business.shop.classdetail;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.bean.CheckCanGotoBuyBean;
import com.tal.app.thinkacademy.business.shop.bean.CouponRecommendProduct;
import com.tal.app.thinkacademy.business.shop.bean.CouponRecommendUseCouponInfo;
import com.tal.app.thinkacademy.business.shop.bean.QueryCategoryTaxInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse;
import com.tal.app.thinkacademy.business.shop.bean.ShopBuySteps;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailAttachedItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailGrade;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec;
import com.tal.app.thinkacademy.business.shop.bean.ShopCouponRecommendInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader;
import com.tal.app.thinkacademy.business.shop.bean.StudentFollowCheckResult;
import com.tal.app.thinkacademy.business.shop.bean.UserInfo;
import com.tal.app.thinkacademy.business.shop.bean.request.ContactVerifyRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequestProduct;
import com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequestSkuInfo;
import com.tal.app.thinkacademy.business.shop.bean.request.QueryCategoryTaxRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.RedeemCodeRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.TaxCategoryBean;
import com.tal.app.thinkacademy.business.shop.bean.request.WishRequestBean;
import com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.CourseStorePurchaseGuide;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 k2\u00020\u0001:\u0002klB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020<J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J!\u0010?\u001a\u0004\u0018\u00010\u000b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010D\u001a\u0004\u0018\u0001002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0010\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HJ!\u0010I\u001a\u0004\u0018\u00010\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020J0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010K\u001a\u0004\u0018\u00010\u001c2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020L0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010M\u001a\u0004\u0018\u00010H2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010N\u001a\u0004\u0018\u00010#2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020O0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010P\u001a\u0004\u0018\u00010,2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010Q\u001a\u0004\u0018\u0001002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010R\u001a\u0004\u0018\u00010,2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010S\u001a\u0004\u0018\u0001002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020T0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ!\u0010U\u001a\u0004\u0018\u0001002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020T0AH@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0012\u0010V\u001a\u00020W2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u000e\u0010X\u001a\u00020<2\u0006\u0010Y\u001a\u00020(J\u000e\u0010Z\u001a\u00020<2\u0006\u0010G\u001a\u00020HJ\u0010\u0010[\u001a\u00020<2\b\u0010\\\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010]\u001a\u00020<2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010`\u001a\u00020<2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010a\u001a\u00020<2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010b\u001a\u0004\u0018\u00010#J\u000e\u0010c\u001a\u00020<2\u0006\u0010d\u001a\u00020\u000fJ\u0010\u0010e\u001a\u00020<2\b\u0010G\u001a\u0004\u0018\u00010HJ\u000e\u0010f\u001a\u00020<2\u0006\u0010d\u001a\u00020\u000fJ\u000e\u0010g\u001a\u00020<2\u0006\u0010d\u001a\u00020\u000fJ\u000e\u0010h\u001a\u00020<2\u0006\u0010d\u001a\u00020\u000fJ\u000e\u0010i\u001a\u00020<2\u0006\u0010G\u001a\u00020HJ\u000e\u0010j\u001a\u00020<2\u0006\u0010G\u001a\u00020HR\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR(\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\"\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\"\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\"\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel;", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;", "()V", "checkPhoneMailBinding", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/shop/bean/UserInfo;", "getCheckPhoneMailBinding", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setCheckPhoneMailBinding", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "mCheckCanGotoBuy", "Lcom/tal/app/thinkacademy/business/shop/bean/CheckCanGotoBuyBean;", "getMCheckCanGotoBuy", "setMCheckCanGotoBuy", "mClassId", "", "mMailVerify", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ContactVerifyRequest;", "getMMailVerify", "setMMailVerify", "mPhoneVerify", "getMPhoneVerify", "setMPhoneVerify", "mQueryCategoryTaxInfoBean", "Lcom/tal/app/thinkacademy/business/shop/bean/QueryCategoryTaxInfoBean;", "getMQueryCategoryTaxInfoBean", "setMQueryCategoryTaxInfoBean", "mRedeemCode", "Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponse;", "getMRedeemCode", "setMRedeemCode", "mSchoolCode", "mShopBuySteps", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopBuySteps;", "mShopCouponRecommendInfoBean", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopCouponRecommendInfoBean;", "getMShopCouponRecommendInfoBean", "setMShopCouponRecommendInfoBean", "mShopDetailList", "", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "getMShopDetailList", "setMShopDetailList", "mStuFollowAdd", "Lcom/tal/app/thinkacademy/business/shop/bean/StudentFollowCheckResult;", "getMStuFollowAdd", "setMStuFollowAdd", "mStuFollowCancel", "", "getMStuFollowCancel", "setMStuFollowCancel", "mStudentFollowCheck", "getMStudentFollowCheck", "setMStudentFollowCheck", "mWishAdd", "getMWishAdd", "setMWishAdd", "mWishCancel", "getMWishCancel", "setMWishCancel", "", "getBuySteps", "Lcom/tal/app/thinkacademy/common/imconfig/CourseStorePurchaseGuide;", "getCheckCanGotoBuy", "body", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ShopClassDetailRequest;", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactVerify", "getDetailBuySate", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel$DetailBuySate;", "info", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailInfoBean;", "getQueryCategoryTax", "Lcom/tal/app/thinkacademy/business/shop/bean/request/QueryCategoryTaxRequest;", "getRedeemCode", "Lcom/tal/app/thinkacademy/business/shop/bean/request/RedeemCodeRequest;", "getShopClassDetail", "getShopCouponRecommend", "Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequest;", "getStuFollowAdd", "getStuFollowCancel", "getStuFollowCheck", "getStuWishAdd", "Lcom/tal/app/thinkacademy/business/shop/bean/request/WishRequestBean;", "getStuWishCancel", "isNeedRequestCouponInfo", "", "reportItem", "item", "requestCheckCanGotoBuy", "requestGetRedeemCode", "code", "requestMailVerify", "contactInfo", "countryCallingCode", "requestPhoneVerify", "requestQueryCategoryTax", "recommendInfo", "requestShopClassDetail", "skuId", "requestShopCouponRecommend", "requestStuFollowAdd", "requestStuFollowCancel", "requestStuFollowCheck", "requestStuWishAdd", "requestStuWishCancel", "Companion", "DetailBuySate", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailViewModel.kt */
public final class ShopClassDetailViewModel extends SeletedStudentViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ShopClassDetailViewModel";
    private StateLiveData<UserInfo> checkPhoneMailBinding = new StateLiveData<>();
    private StateLiveData<CheckCanGotoBuyBean> mCheckCanGotoBuy = new StateLiveData<>();
    /* access modifiers changed from: private */
    public String mClassId = "0";
    private StateLiveData<ContactVerifyRequest> mMailVerify = new StateLiveData<>();
    private StateLiveData<ContactVerifyRequest> mPhoneVerify = new StateLiveData<>();
    private StateLiveData<QueryCategoryTaxInfoBean> mQueryCategoryTaxInfoBean = new StateLiveData<>();
    private StateLiveData<RedeemCodeResponse> mRedeemCode = new StateLiveData<>();
    private String mSchoolCode;
    private ShopBuySteps mShopBuySteps;
    private StateLiveData<ShopCouponRecommendInfoBean> mShopCouponRecommendInfoBean = new StateLiveData<>();
    private StateLiveData<List<MultiItemEntity>> mShopDetailList = new StateLiveData<>();
    private StateLiveData<StudentFollowCheckResult> mStuFollowAdd = new StateLiveData<>();
    private StateLiveData<Object> mStuFollowCancel = new StateLiveData<>();
    private StateLiveData<StudentFollowCheckResult> mStudentFollowCheck = new StateLiveData<>();
    private StateLiveData<Object> mWishAdd = new StateLiveData<>();
    private StateLiveData<Object> mWishCancel = new StateLiveData<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel$DetailBuySate;", "", "(Ljava/lang/String;I)V", "Enroll", "Coupon", "ForSell", "Full", "CourseEnd", "AutoPay", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailViewModel.kt */
    public enum DetailBuySate {
        Enroll,
        Coupon,
        ForSell,
        Full,
        CourseEnd,
        AutoPay
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailViewModel$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ShopClassDetailViewModel() {
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
        this.mSchoolCode = string;
    }

    public final StateLiveData<List<MultiItemEntity>> getMShopDetailList() {
        return this.mShopDetailList;
    }

    public final void setMShopDetailList(StateLiveData<List<MultiItemEntity>> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mShopDetailList = stateLiveData;
    }

    public final StateLiveData<ShopCouponRecommendInfoBean> getMShopCouponRecommendInfoBean() {
        return this.mShopCouponRecommendInfoBean;
    }

    public final void setMShopCouponRecommendInfoBean(StateLiveData<ShopCouponRecommendInfoBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mShopCouponRecommendInfoBean = stateLiveData;
    }

    public final StateLiveData<QueryCategoryTaxInfoBean> getMQueryCategoryTaxInfoBean() {
        return this.mQueryCategoryTaxInfoBean;
    }

    public final void setMQueryCategoryTaxInfoBean(StateLiveData<QueryCategoryTaxInfoBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mQueryCategoryTaxInfoBean = stateLiveData;
    }

    public final StateLiveData<Object> getMWishAdd() {
        return this.mWishAdd;
    }

    public final void setMWishAdd(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mWishAdd = stateLiveData;
    }

    public final StateLiveData<Object> getMWishCancel() {
        return this.mWishCancel;
    }

    public final void setMWishCancel(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mWishCancel = stateLiveData;
    }

    public final StateLiveData<StudentFollowCheckResult> getMStudentFollowCheck() {
        return this.mStudentFollowCheck;
    }

    public final void setMStudentFollowCheck(StateLiveData<StudentFollowCheckResult> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mStudentFollowCheck = stateLiveData;
    }

    public final StateLiveData<StudentFollowCheckResult> getMStuFollowAdd() {
        return this.mStuFollowAdd;
    }

    public final void setMStuFollowAdd(StateLiveData<StudentFollowCheckResult> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mStuFollowAdd = stateLiveData;
    }

    public final StateLiveData<Object> getMStuFollowCancel() {
        return this.mStuFollowCancel;
    }

    public final void setMStuFollowCancel(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mStuFollowCancel = stateLiveData;
    }

    public final StateLiveData<CheckCanGotoBuyBean> getMCheckCanGotoBuy() {
        return this.mCheckCanGotoBuy;
    }

    public final void setMCheckCanGotoBuy(StateLiveData<CheckCanGotoBuyBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mCheckCanGotoBuy = stateLiveData;
    }

    public final StateLiveData<RedeemCodeResponse> getMRedeemCode() {
        return this.mRedeemCode;
    }

    public final void setMRedeemCode(StateLiveData<RedeemCodeResponse> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mRedeemCode = stateLiveData;
    }

    public final StateLiveData<ContactVerifyRequest> getMPhoneVerify() {
        return this.mPhoneVerify;
    }

    public final void setMPhoneVerify(StateLiveData<ContactVerifyRequest> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mPhoneVerify = stateLiveData;
    }

    public final StateLiveData<ContactVerifyRequest> getMMailVerify() {
        return this.mMailVerify;
    }

    public final void setMMailVerify(StateLiveData<ContactVerifyRequest> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mMailVerify = stateLiveData;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getShopClassDetail(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopClassDetail$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopClassDetail$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopClassDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopClassDetail$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopClassDetail$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getClassDetail(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getShopClassDetail(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestShopClassDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "skuId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestShopClassDetail$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestShopClassDetail$2(this, new ShopRequestCommonBody(new ShopClassDetailRequest(str), (ShopRequestCommonHeader) null), (Continuation<? super ShopClassDetailViewModel$requestShopClassDetail$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final CourseStorePurchaseGuide getBuySteps() {
        return SchoolConstants.INSTANCE.getBuySteps(this.mSchoolCode);
    }

    public final DetailBuySate getDetailBuySate(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        if (shopClassDetailInfoBean != null) {
            ShopClassDetailSpec spec = shopClassDetailInfoBean.getSpec();
            if (spec == null ? false : spec.getCourseClosed()) {
                return DetailBuySate.CourseEnd;
            }
            if (shopClassDetailInfoBean.getRemainSellTime() > 1000) {
                return DetailBuySate.ForSell;
            }
            if (shopClassDetailInfoBean.getSellStore() == shopClassDetailInfoBean.getStore()) {
                return DetailBuySate.Full;
            }
            if (shopClassDetailInfoBean.getSubscriptionsStatus() == 1) {
                return DetailBuySate.AutoPay;
            }
        }
        return DetailBuySate.Enroll;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getShopCouponRecommend(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.ShopCouponRecommendInfoBean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopCouponRecommend$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopCouponRecommend$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopCouponRecommend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopCouponRecommend$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getShopCouponRecommend$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getCouponRecommend(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getShopCouponRecommend(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isNeedRequestCouponInfo(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        if (getDetailBuySate(shopClassDetailInfoBean) == DetailBuySate.Enroll && shopClassDetailInfoBean != null && (shopClassDetailInfoBean.getPerShowPrice() > 0 || shopClassDetailInfoBean.getShowPrice() > 0)) {
            return true;
        }
        return false;
    }

    public final void requestShopCouponRecommend(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        List<ShopClassDetailGrade> gradeList;
        ShopClassDetailInfoBean shopClassDetailInfoBean2 = shopClassDetailInfoBean;
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            if (!isNeedRequestCouponInfo(shopClassDetailInfoBean)) {
                XesLog.dt(TAG, new Object[]{"requestShopCouponRecommend 不需要请求优惠券数据"});
            } else if (shopClassDetailInfoBean2 != null) {
                List arrayList = new ArrayList();
                int singleSellPrice = shopClassDetailInfoBean.getSingleSellPrice();
                int packagePrice = shopClassDetailInfoBean.getPackagePrice();
                ShopClassDetailSpec spec = shopClassDetailInfoBean.getSpec();
                int clazzId = spec == null ? 0 : spec.getClazzId();
                ShopClassDetailSpec spec2 = shopClassDetailInfoBean.getSpec();
                int courseId = spec2 == null ? 0 : spec2.getCourseId();
                ShopClassDetailSpec spec3 = shopClassDetailInfoBean.getSpec();
                int courseType = spec3 == null ? 0 : spec3.getCourseType();
                ShopClassDetailSpec spec4 = shopClassDetailInfoBean.getSpec();
                int goodsCategoryId = spec4 == null ? 0 : spec4.getGoodsCategoryId();
                List arrayList2 = new ArrayList();
                ShopClassDetailSpec spec5 = shopClassDetailInfoBean.getSpec();
                if (!(spec5 == null || (gradeList = spec5.getGradeList()) == null)) {
                    int i = 0;
                    for (Object next : gradeList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList2.add(Integer.valueOf(((ShopClassDetailGrade) next).getId()));
                        i = i2;
                    }
                }
                ShopClassDetailSpec spec6 = shopClassDetailInfoBean.getSpec();
                int levelDegreeId = spec6 == null ? 0 : spec6.getLevelDegreeId();
                ShopClassDetailSpec spec7 = shopClassDetailInfoBean.getSpec();
                String platformType = spec7 == null ? null : spec7.getPlatformType();
                int id = shopClassDetailInfoBean.getId();
                ShopClassDetailSpec spec8 = shopClassDetailInfoBean.getSpec();
                int subPlatformType = spec8 == null ? 0 : spec8.getSubPlatformType();
                ShopClassDetailSpec spec9 = shopClassDetailInfoBean.getSpec();
                int subjectId = spec9 == null ? 0 : spec9.getSubjectId();
                ShopClassDetailSpec spec10 = shopClassDetailInfoBean.getSpec();
                int term = spec10 == null ? 0 : spec10.getTerm();
                ShopClassDetailSpec spec11 = shopClassDetailInfoBean.getSpec();
                String year = spec11 == null ? null : spec11.getYear();
                CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo = r8;
                List list = arrayList2;
                CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo2 = new CouponRecommendRequestSkuInfo(clazzId, courseId, courseType, goodsCategoryId, arrayList2, levelDegreeId, platformType, id, subPlatformType, subjectId, term, year);
                arrayList.add(new CouponRecommendRequestProduct(1, singleSellPrice, packagePrice, couponRecommendRequestSkuInfo));
                List<ShopClassDetailAttachedItem> attachedItems = shopClassDetailInfoBean.getAttachedItems();
                if (attachedItems != null) {
                    Iterator it = attachedItems.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        Object next2 = it.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ShopClassDetailAttachedItem shopClassDetailAttachedItem = (ShopClassDetailAttachedItem) next2;
                        int price = shopClassDetailAttachedItem.getPrice();
                        int sellPrice = shopClassDetailInfoBean.getSellPrice();
                        CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo3 = r8;
                        Iterator it2 = it;
                        int i5 = i4;
                        CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo4 = new CouponRecommendRequestSkuInfo(clazzId, courseId, courseType, shopClassDetailAttachedItem.getCategory(), list, levelDegreeId, platformType, shopClassDetailAttachedItem.getSkuId(), subPlatformType, subjectId, term, year);
                        CouponRecommendRequestProduct couponRecommendRequestProduct = new CouponRecommendRequestProduct(1, price, sellPrice, couponRecommendRequestSkuInfo3);
                        if (shopClassDetailAttachedItem.getRequired() || shopClassDetailAttachedItem.getSelected()) {
                            arrayList.add(couponRecommendRequestProduct);
                        }
                        it = it2;
                        i3 = i5;
                    }
                }
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestShopCouponRecommend$1$3(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestShopCouponRecommend$1$4(this, new ShopRequestCommonBody(new CouponRecommendRequest(arrayList), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), shopClassDetailInfoBean2, (Continuation<? super ShopClassDetailViewModel$requestShopCouponRecommend$1$4>) null), 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getQueryCategoryTax(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.QueryCategoryTaxRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.QueryCategoryTaxInfoBean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getQueryCategoryTax$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getQueryCategoryTax$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getQueryCategoryTax$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getQueryCategoryTax$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getQueryCategoryTax$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getQueryCategoryTax(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getQueryCategoryTax(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestQueryCategoryTax(ShopClassDetailInfoBean shopClassDetailInfoBean, ShopCouponRecommendInfoBean shopCouponRecommendInfoBean) {
        List<CouponRecommendUseCouponInfo> useCouponInfo;
        List arrayList = new ArrayList();
        if (!(shopCouponRecommendInfoBean == null || (useCouponInfo = shopCouponRecommendInfoBean.getUseCouponInfo()) == null)) {
            int i = 0;
            for (Object next : useCouponInfo) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CouponRecommendUseCouponInfo couponRecommendUseCouponInfo = (CouponRecommendUseCouponInfo) next;
                arrayList.add(new CouponRecommendProduct(couponRecommendUseCouponInfo.getDiscount(), couponRecommendUseCouponInfo.getId()));
                List<CouponRecommendProduct> products = couponRecommendUseCouponInfo.getProducts();
                if (products != null) {
                    arrayList.addAll(products);
                }
                i = i2;
            }
        }
        if (shopClassDetailInfoBean != null) {
            List arrayList2 = new ArrayList();
            arrayList2.add(new TaxCategoryBean(shopClassDetailInfoBean.getClazzCategory(), shopClassDetailInfoBean.getSingleSellPrice(), shopClassDetailInfoBean.getId()));
            List<ShopClassDetailAttachedItem> attachedItems = shopClassDetailInfoBean.getAttachedItems();
            if (attachedItems != null) {
                int i3 = 0;
                for (Object next2 : attachedItems) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ShopClassDetailAttachedItem shopClassDetailAttachedItem = (ShopClassDetailAttachedItem) next2;
                    if (shopClassDetailAttachedItem.getRequired() || shopClassDetailAttachedItem.getSelected()) {
                        arrayList2.add(new TaxCategoryBean(shopClassDetailAttachedItem.getCategory(), shopClassDetailAttachedItem.getPrice(), shopClassDetailAttachedItem.getSkuId()));
                    }
                    i3 = i4;
                }
            }
            int i5 = 0;
            for (Object next3 : arrayList2) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TaxCategoryBean taxCategoryBean = (TaxCategoryBean) next3;
                int sellPrice = taxCategoryBean.getSellPrice();
                int i7 = 0;
                int i8 = 0;
                for (Object next4 : arrayList) {
                    int i9 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CouponRecommendProduct couponRecommendProduct = (CouponRecommendProduct) next4;
                    if (taxCategoryBean.getSkuId() == couponRecommendProduct.getSkuId()) {
                        i8 -= couponRecommendProduct.getDiscount();
                        sellPrice = taxCategoryBean.getSellPrice() + i8;
                    }
                    i7 = i9;
                }
                taxCategoryBean.setSellPrice(sellPrice);
                i5 = i6;
            }
            ConfigInfo.SchoolV2 schoolV2 = SchoolConstants.INSTANCE.getSchoolV2(this.mSchoolCode);
            int countryId = schoolV2 == null ? 2 : schoolV2.getCountryId();
            ShopClassDetailSpec spec = shopClassDetailInfoBean.getSpec();
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestQueryCategoryTax$2$3(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestQueryCategoryTax$2$4(this, new ShopRequestCommonBody(new QueryCategoryTaxRequest(arrayList2, countryId, spec == null ? null : spec.getPlatformType()), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), (Continuation<? super ShopClassDetailViewModel$requestQueryCategoryTax$2$4>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStuFollowCheck(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.StudentFollowCheckResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCheck$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCheck$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCheck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCheck$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCheck$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getStuFollowCheck(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getStuFollowCheck(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestStuFollowCheck(String str) {
        Intrinsics.checkNotNullParameter(str, "skuId");
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestStuFollowCheck$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestStuFollowCheck$2(this, new ShopRequestCommonBody(new ShopClassDetailRequest(str), (ShopRequestCommonHeader) null), (Continuation<? super ShopClassDetailViewModel$requestStuFollowCheck$2>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStuFollowAdd(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.StudentFollowCheckResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowAdd$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowAdd$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowAdd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowAdd$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowAdd$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getStuFollowAdd(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getStuFollowAdd(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestStuFollowAdd(String str) {
        Intrinsics.checkNotNullParameter(str, "skuId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestStuFollowAdd$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestStuFollowAdd$2(this, new ShopRequestCommonBody(new ShopClassDetailRequest(str), (ShopRequestCommonHeader) null), (Continuation<? super ShopClassDetailViewModel$requestStuFollowAdd$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStuFollowCancel(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCancel$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCancel$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCancel$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuFollowCancel$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getStuFollowCancel(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getStuFollowCancel(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestStuFollowCancel(String str) {
        Intrinsics.checkNotNullParameter(str, "skuId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestStuFollowCancel$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestStuFollowCancel$2(this, new ShopRequestCommonBody(new ShopClassDetailRequest(str), (ShopRequestCommonHeader) null), (Continuation<? super ShopClassDetailViewModel$requestStuFollowCancel$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStuWishAdd(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.WishRequestBean> r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishAdd$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishAdd$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishAdd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishAdd$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishAdd$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getStuWishAdd(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getStuWishAdd(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestStuWishAdd(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        Intrinsics.checkNotNullParameter(shopClassDetailInfoBean, "info");
        List arrayList = new ArrayList();
        arrayList.add(String.valueOf(shopClassDetailInfoBean.getId()));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestStuWishAdd$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestStuWishAdd$2(this, new ShopRequestCommonBody(new WishRequestBean(arrayList), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), (Continuation<? super ShopClassDetailViewModel$requestStuWishAdd$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStuWishCancel(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.WishRequestBean> r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishCancel$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishCancel$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishCancel$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getStuWishCancel$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getStuWishCancel(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getStuWishCancel(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestStuWishCancel(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        Intrinsics.checkNotNullParameter(shopClassDetailInfoBean, "info");
        List arrayList = new ArrayList();
        arrayList.add(String.valueOf(shopClassDetailInfoBean.getId()));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestStuWishCancel$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestStuWishCancel$2(this, new ShopRequestCommonBody(new WishRequestBean(arrayList), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), (Continuation<? super ShopClassDetailViewModel$requestStuWishCancel$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRedeemCode(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.RedeemCodeRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getRedeemCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getRedeemCode$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getRedeemCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getRedeemCode$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getRedeemCode$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getAuthRedeem(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getRedeemCode(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestGetRedeemCode(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestGetRedeemCode$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestGetRedeemCode$2(this, new ShopRequestCommonBody(new RedeemCodeRequest(str), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), str, (Continuation<? super ShopClassDetailViewModel$requestGetRedeemCode$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCheckCanGotoBuy(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.CheckCanGotoBuyBean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getCheckCanGotoBuy$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getCheckCanGotoBuy$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getCheckCanGotoBuy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getCheckCanGotoBuy$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getCheckCanGotoBuy$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getCheckCanGotoBuy(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getCheckCanGotoBuy(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void requestCheckCanGotoBuy(ShopClassDetailInfoBean shopClassDetailInfoBean) {
        Intrinsics.checkNotNullParameter(shopClassDetailInfoBean, "info");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestCheckCanGotoBuy$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestCheckCanGotoBuy$2(this, new ShopRequestCommonBody(new ShopClassDetailRequest(String.valueOf(shopClassDetailInfoBean.getId())), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), (Continuation<? super ShopClassDetailViewModel$requestCheckCanGotoBuy$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getContactVerify(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ContactVerifyRequest> r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getContactVerify$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getContactVerify$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getContactVerify$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getContactVerify$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$getContactVerify$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getContactVerify(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.getContactVerify(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void requestPhoneVerify$default(ShopClassDetailViewModel shopClassDetailViewModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        shopClassDetailViewModel.requestPhoneVerify(str, str2);
    }

    public final void requestPhoneVerify(String str, String str2) {
        ContactVerifyRequest contactVerifyRequest = new ContactVerifyRequest(str, str2, 0);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestPhoneVerify$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestPhoneVerify$2(this, new ShopRequestCommonBody(contactVerifyRequest, (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), contactVerifyRequest, (Continuation<? super ShopClassDetailViewModel$requestPhoneVerify$2>) null), 2, (Object) null);
    }

    public static /* synthetic */ void requestMailVerify$default(ShopClassDetailViewModel shopClassDetailViewModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        shopClassDetailViewModel.requestMailVerify(str, str2);
    }

    public final void requestMailVerify(String str, String str2) {
        ContactVerifyRequest contactVerifyRequest = new ContactVerifyRequest(str, str2, 2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$requestMailVerify$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$requestMailVerify$2(this, new ShopRequestCommonBody(contactVerifyRequest, new ShopRequestCommonHeader(this.mSchoolCode, (String) null)), contactVerifyRequest, (Continuation<? super ShopClassDetailViewModel$requestMailVerify$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserInfo> getCheckPhoneMailBinding() {
        return this.checkPhoneMailBinding;
    }

    public final void setCheckPhoneMailBinding(StateLiveData<UserInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.checkPhoneMailBinding = stateLiveData;
    }

    public final void checkPhoneMailBinding() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopClassDetailViewModel$checkPhoneMailBinding$1(this)), (CoroutineStart) null, new ShopClassDetailViewModel$checkPhoneMailBinding$2(this, (Continuation<? super ShopClassDetailViewModel$checkPhoneMailBinding$2>) null), 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        r0 = r0.getHighlight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void reportItem(com.chad.library.adapter.base.entity.MultiItemEntity r10) {
        /*
            r9 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r10.getItemType()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r1 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseCard
            int r1 = r1.getType()
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 != r1) goto L_0x004a
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon
            if (r0 == 0) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r10 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon) r10
            java.lang.Object r0 = r10.getData()
            boolean r0 = r0 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean
            if (r0 == 0) goto L_0x0149
            java.lang.Object r10 = r10.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean r10 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean) r10
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r10 = r10.getSpec()
            if (r10 != 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            java.lang.String r2 = r10.getFeeDescClazz()
        L_0x0033:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x003f
            int r10 = r2.length()
            if (r10 != 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r3 = r4
        L_0x003f:
            if (r3 != 0) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r10 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r0 = r9.mClassId
            r10.hw_price_description_show(r0)
            goto L_0x0149
        L_0x004a:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r1 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseHighlights
            int r1 = r1.getType()
            if (r0 != r1) goto L_0x00f0
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation
            if (r0 == 0) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r10 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation) r10
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r0 = r10.getDynamic()
            if (r0 != 0) goto L_0x0060
        L_0x005e:
            r0 = r4
            goto L_0x006b
        L_0x0060:
            java.util.List r0 = r0.getHighlight()
            if (r0 != 0) goto L_0x0067
            goto L_0x005e
        L_0x0067:
            int r0 = r0.size()
        L_0x006b:
            if (r0 <= 0) goto L_0x00c0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailDynamic r5 = r10.getDynamic()
            if (r5 != 0) goto L_0x0079
            goto L_0x00b0
        L_0x0079:
            java.util.List r5 = r5.getHighlight()
            if (r5 != 0) goto L_0x0080
            goto L_0x00b0
        L_0x0080:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = r4
        L_0x0087:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00b0
            java.lang.Object r7 = r5.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x0098
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0098:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight r7 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight) r7
            java.lang.String r7 = r7.getTitle()
            r1.append(r7)
            int r7 = r0 + -1
            if (r6 >= r7) goto L_0x00ae
            r7 = 7
            if (r6 <= r7) goto L_0x00a9
            goto L_0x00b0
        L_0x00a9:
            java.lang.String r6 = " · "
            r1.append(r6)
        L_0x00ae:
            r6 = r8
            goto L_0x0087
        L_0x00b0:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r0 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r3 = r9.mClassId
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "stringBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r0.hw_courses_highlights_show(r3, r1)
        L_0x00c0:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r0 = r10.getStaticData()
            if (r0 != 0) goto L_0x00c7
            goto L_0x00d2
        L_0x00c7:
            java.util.List r0 = r0.getTrialLessons()
            if (r0 != 0) goto L_0x00ce
            goto L_0x00d2
        L_0x00ce:
            int r4 = r0.size()
        L_0x00d2:
            if (r4 <= 0) goto L_0x00db
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r0 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r1 = r9.mClassId
            r0.hw_teaching_video_show(r1)
        L_0x00db:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData r10 = r10.getStaticData()
            if (r10 != 0) goto L_0x00e2
            goto L_0x00e6
        L_0x00e2:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPortrait r2 = r10.getPortrait()
        L_0x00e6:
            if (r2 == 0) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r10 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r0 = r9.mClassId
            r10.hw_suitable_for_show(r0)
            goto L_0x0149
        L_0x00f0:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r1 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.TeacherCard
            int r1 = r1.getType()
            if (r0 != r1) goto L_0x011a
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher
            if (r0 == 0) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher r10 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher) r10
            int r0 = r10.getTeacherType()
            if (r0 != r3) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r0 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r1 = r9.mClassId
            int r10 = r10.getTeacherId()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopPageType r2 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopPageType.SHOP_CLASS_DETAIL
            java.lang.String r2 = r2.getType()
            r0.hw_teacher_show(r1, r10, r2)
            goto L_0x0149
        L_0x011a:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r10 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.ScheduleTitle
            int r10 = r10.getType()
            if (r0 != r10) goto L_0x012a
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r10 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r0 = r9.mClassId
            r10.hw_syllabus_show(r0)
            goto L_0x0149
        L_0x012a:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r10 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.CourseDetailTitle
            int r10 = r10.getType()
            if (r0 != r10) goto L_0x013a
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r10 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r0 = r9.mClassId
            r10.hw_course_detail_show(r0)
            goto L_0x0149
        L_0x013a:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType r10 = com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType.StepsTitle
            int r10 = r10.getType()
            if (r0 != r10) goto L_0x0149
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r10 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            java.lang.String r0 = r9.mClassId
            r10.hw_steps_show(r0)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel.reportItem(com.chad.library.adapter.base.entity.MultiItemEntity):void");
    }
}
