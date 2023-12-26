package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBody;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBody;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBody;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerDataBean;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBody;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckRequest;
import com.tal.app.thinkacademy.business.shop.bean.CheckCanGotoBuyBean;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateClassListData;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo;
import com.tal.app.thinkacademy.business.shop.bean.QueryCategoryTaxInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData;
import com.tal.app.thinkacademy.business.shop.bean.ShopCouponRecommendInfoBean;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.StudentFollowCheckResult;
import com.tal.app.thinkacademy.business.shop.bean.TeacherDetailsHeader;
import com.tal.app.thinkacademy.business.shop.bean.UserInfo;
import com.tal.app.thinkacademy.business.shop.bean.request.ClassListDataRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.ContactVerifyRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.GradeAggregateRequestHead;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyEmailRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyPhoneRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.QueryCategoryTaxRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.RedeemCodeRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.SubmitIntentionRequestData;
import com.tal.app.thinkacademy.business.shop.bean.request.TeacherDeatilsRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList;
import com.tal.app.thinkacademy.business.shop.bean.request.UserInfoRequest;
import com.tal.app.thinkacademy.business.shop.bean.request.WishRequestBean;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020!0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020$0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ'\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020'0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010+H§@ø\u0001\u0000¢\u0006\u0002\u0010,J#\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010/H§@ø\u0001\u0000¢\u0006\u0002\u00100J)\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002060\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002060\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ#\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u00032\b\b\u0001\u0010\u0005\u001a\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;J#\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u00032\b\b\u0001\u0010\u0005\u001a\u00020:H§@ø\u0001\u0000¢\u0006\u0002\u0010;J#\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ#\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0001\u0010A\u001a\u00020BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ)\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020F0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ)\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020H0\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ#\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0\u00032\b\b\u0001\u0010A\u001a\u00020KH§@ø\u0001\u0000¢\u0006\u0002\u0010L\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/ShopApi;", "", "getAuthRedeem", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponse;", "body", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/RedeemCodeRequest;", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListData;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBody;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCheckCanGotoBuy", "Lcom/tal/app/thinkacademy/business/shop/bean/CheckCanGotoBuyBean;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ShopClassDetailRequest;", "getClassDetail", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailInfoBean;", "getClassList", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateClassListData;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ClassListDataRequest;", "getContactVerify", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ContactVerifyRequest;", "getCouponRecommend", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopCouponRecommendInfoBean;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequest;", "getEmailModify", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ModifyEmailRequest;", "getGradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/UserInfoRequest;", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/UserInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneModify", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ModifyPhoneRequest;", "getQueryCategoryTax", "Lcom/tal/app/thinkacademy/business/shop/bean/QueryCategoryTaxInfoBean;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/QueryCategoryTaxRequest;", "getShopGoodsApiMallPage", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/GradeAggregateRequestHead;", "getShopHomeBanner", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerDataBean;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBody;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShopHomeList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeData;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeBody;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStuFollowAdd", "Lcom/tal/app/thinkacademy/business/shop/bean/StudentFollowCheckResult;", "getStuFollowCancel", "getStuFollowCheck", "getStuWishAdd", "Lcom/tal/app/thinkacademy/business/shop/bean/request/WishRequestBean;", "getStuWishCancel", "getTeacherDetailsHeader", "Lcom/tal/app/thinkacademy/business/shop/bean/TeacherDetailsHeader;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDeatilsRequest;", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDeatilsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeacherDetailsList", "Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDetailsList;", "getUserInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/UserInfo;", "postLeaveInfo", "Body", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBody;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryClazzByCourseId", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassData;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassListRequestData;", "submitIntention", "Lcom/tal/app/thinkacademy/business/shop/bean/request/SubmitIntentionRequestData;", "timeZoneCheck", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/TimeZoneCheckEntity;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/TimeZoneCheckRequest;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/TimeZoneCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopApi.kt */
public interface ShopApi {
    @POST("v1/exam/api/auth/redeem")
    Object getAuthRedeem(@Body ShopRequestCommonBody<RedeemCodeRequest> shopRequestCommonBody, Continuation<? super HiResponse<RedeemCodeResponse>> continuation);

    @POST("/v1/manage/api/channel/list")
    Object getChannelList(@Body ChannelListBody channelListBody, Continuation<? super HiResponse<ChannelListData>> continuation);

    @POST("v1/aggregate/signup/checkv2")
    Object getCheckCanGotoBuy(@Body ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super HiResponse<CheckCanGotoBuyBean>> continuation);

    @POST("v1/aggregate/goods/details")
    Object getClassDetail(@Body ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super HiResponse<ShopClassDetailInfoBean>> continuation);

    @POST("v1/shop/goods/api/queryGoodsByModule")
    Object getClassList(@Body ShopRequestCommonBody<ClassListDataRequest> shopRequestCommonBody, Continuation<? super HiResponse<GradeAggregateClassListData>> continuation);

    @POST("v1/ucenter/common/contact/verify")
    Object getContactVerify(@Body ShopRequestCommonBody<ContactVerifyRequest> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/coupon/api/recommend")
    Object getCouponRecommend(@Body ShopRequestCommonBody<CouponRecommendRequest> shopRequestCommonBody, Continuation<? super HiResponse<ShopCouponRecommendInfoBean>> continuation);

    @POST("v1/ucenter/account/email/modify")
    Object getEmailModify(@Body ShopRequestCommonBody<ModifyEmailRequest> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/basic/client/grade/queryWithoutHide")
    Object getGradeStageList(@Body UserInfoRequest userInfoRequest, Continuation<? super HiResponse<GradeStageList>> continuation);

    @POST("v1/ucenter/account/phone/modify")
    Object getPhoneModify(@Body ShopRequestCommonBody<ModifyPhoneRequest> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/shop/goods/api/queryCategoryTax")
    Object getQueryCategoryTax(@Body ShopRequestCommonBody<QueryCategoryTaxRequest> shopRequestCommonBody, Continuation<? super HiResponse<QueryCategoryTaxInfoBean>> continuation);

    @POST("v1/shop/goods/api/mallPage")
    Object getShopGoodsApiMallPage(@Body ShopRequestCommonBody<GradeAggregateRequestHead> shopRequestCommonBody, Continuation<? super HiResponse<GradeAggregateDetailInfo>> continuation);

    @POST("/v1/manage/api/resource/query")
    Object getShopHomeBanner(@Body ShopBannerBody shopBannerBody, Continuation<? super HiResponse<List<ShopBannerDataBean>>> continuation);

    @POST("/v1/shop/goods/api/mallPage")
    Object getShopHomeList(@Body ShopHomeBody shopHomeBody, Continuation<? super HiResponse<ShopHomeData>> continuation);

    @POST("v1/shop/goods/stu/follow/add")
    Object getStuFollowAdd(@Body ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super HiResponse<StudentFollowCheckResult>> continuation);

    @POST("v1/shop/goods/stu/follow/cancel")
    Object getStuFollowCancel(@Body ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/shop/goods/stu/follow/check")
    Object getStuFollowCheck(@Body ShopRequestCommonBody<ShopClassDetailRequest> shopRequestCommonBody, Continuation<? super HiResponse<StudentFollowCheckResult>> continuation);

    @POST("v1/shop/goods/stu/wish/add")
    Object getStuWishAdd(@Body ShopRequestCommonBody<WishRequestBean> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/shop/goods/stu/wish/cancel")
    Object getStuWishCancel(@Body ShopRequestCommonBody<WishRequestBean> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/teacher/basic_info/profile")
    Object getTeacherDetailsHeader(@Body TeacherDeatilsRequest teacherDeatilsRequest, Continuation<? super HiResponse<TeacherDetailsHeader>> continuation);

    @POST("v1/shop/goods/api/queryTeacherClazzV2")
    Object getTeacherDetailsList(@Body TeacherDeatilsRequest teacherDeatilsRequest, Continuation<? super HiResponse<TeacherDetailsList>> continuation);

    @POST("v2/ucenter/basic_info/user/get")
    Object getUserInfo(@Body UserInfoRequest userInfoRequest, Continuation<? super HiResponse<UserInfo>> continuation);

    @POST("v1/crm/client/submitLeads")
    Object postLeaveInfo(@Body LeaveInfoPostBody leaveInfoPostBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/shop/goods/api/queryClazzByCourseId")
    Object queryClazzByCourseId(@Body ShopRequestCommonBody<ShopClassListRequestData> shopRequestCommonBody, Continuation<? super HiResponse<ShopClassData>> continuation);

    @POST("v1/saleslead/intentionCollection")
    Object submitIntention(@Body ShopRequestCommonBody<SubmitIntentionRequestData> shopRequestCommonBody, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/i18n/api/time/get/check")
    Object timeZoneCheck(@Body TimeZoneCheckRequest timeZoneCheckRequest, Continuation<? super HiResponse<TimeZoneCheckEntity>> continuation);
}
