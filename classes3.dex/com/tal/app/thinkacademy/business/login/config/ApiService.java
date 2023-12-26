package com.tal.app.thinkacademy.business.login.config;

import com.tal.app.thinkacademy.business.login.entity.AboutListEntity;
import com.tal.app.thinkacademy.business.login.entity.AccountCheckData;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
import com.tal.app.thinkacademy.business.login.entity.BannersData;
import com.tal.app.thinkacademy.business.login.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.login.entity.CurriculumListData;
import com.tal.app.thinkacademy.business.login.entity.DeviceConfig;
import com.tal.app.thinkacademy.business.login.entity.MasterUserBean;
import com.tal.app.thinkacademy.business.login.entity.NicknameBean;
import com.tal.app.thinkacademy.business.login.entity.SetPasswordData;
import com.tal.app.thinkacademy.business.login.entity.UseGetInfo;
import com.tal.app.thinkacademy.business.login.entity.post.AccountCheckRequest;
import com.tal.app.thinkacademy.business.login.entity.post.AccountLogin;
import com.tal.app.thinkacademy.business.login.entity.post.AddNewStudentRequest;
import com.tal.app.thinkacademy.business.login.entity.post.BannersRequest;
import com.tal.app.thinkacademy.business.login.entity.post.BindEmail;
import com.tal.app.thinkacademy.business.login.entity.post.ChangePassword;
import com.tal.app.thinkacademy.business.login.entity.post.CodeLogin;
import com.tal.app.thinkacademy.business.login.entity.post.GetCode;
import com.tal.app.thinkacademy.business.login.entity.post.GetGradeList;
import com.tal.app.thinkacademy.business.login.entity.post.ModifyUserInfo;
import com.tal.app.thinkacademy.business.login.entity.post.SecurityCheck;
import com.tal.app.thinkacademy.business.login.entity.post.SubmitFeedback;
import com.tal.app.thinkacademy.business.login.entity.post.UserinfoGetBody;
import com.tal.app.thinkacademy.business.login.entity.post.UserinfoGetBodyHead;
import com.tal.app.thinkacademy.common.entity.InitEntryInfoBean;
import com.tal.app.thinkacademy.common.entity.SwitchLogin;
import com.tal.app.thinkacademy.common.user.BasicUserInfo;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010 \u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J!\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010%J-\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!2\n\b\u0001\u0010(\u001a\u0004\u0018\u00010!H§@ø\u0001\u0000¢\u0006\u0002\u0010)J!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\b\b\u0001\u0010\u0005\u001a\u000201H§@ø\u0001\u0000¢\u0006\u0002\u00102J!\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J#\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J!\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u000208H§@ø\u0001\u0000¢\u0006\u0002\u00109J+\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010 \u001a\u00020!2\b\b\u0001\u0010\u0005\u001a\u00020<H§@ø\u0001\u0000¢\u0006\u0002\u0010=J\u001f\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010?0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J!\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020FH§@ø\u0001\u0000¢\u0006\u0002\u0010GJ!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020IH§@ø\u0001\u0000¢\u0006\u0002\u0010JJ!\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ!\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020NH§@ø\u0001\u0000¢\u0006\u0002\u0010OJ!\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020QH§@ø\u0001\u0000¢\u0006\u0002\u0010RJ+\u0010S\u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010(\u001a\u00020T2\b\b\u0001\u0010\u0005\u001a\u00020UH§@ø\u0001\u0000¢\u0006\u0002\u0010V\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/config/ApiService;", "", "accountCheck", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/business/login/entity/AccountCheckData;", "body", "Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckRequest;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountLogin", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "Lcom/tal/app/thinkacademy/business/login/entity/post/AccountLogin;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/AccountLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNewStudent", "Lcom/tal/app/thinkacademy/business/login/entity/AddNewStudent;", "Lcom/tal/app/thinkacademy/business/login/entity/post/AddNewStudentRequest;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/AddNewStudentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bannersData", "", "Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequest;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "basicInfoUserGet", "Lcom/tal/app/thinkacademy/business/login/entity/UseGetInfo;", "Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBody;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindEmail", "Lcom/tal/app/thinkacademy/business/login/entity/post/BindEmail;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/BindEmail;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePassword;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePassword;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUrl", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "codeLogin", "Lcom/tal/app/thinkacademy/business/login/entity/post/CodeLogin;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/CodeLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountList", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "schoolCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBasicUserInfo", "Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "getDeviceConfig", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "Lcom/tal/app/thinkacademy/business/login/entity/post/GetGradeList;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/GetGradeList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMasterUserInfo", "Lcom/tal/app/thinkacademy/business/login/entity/MasterUserBean;", "getNickname", "Lcom/tal/app/thinkacademy/business/login/entity/NicknameBean;", "getSmsCode", "Lcom/tal/app/thinkacademy/business/login/entity/post/GetCode;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/GetCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudentCurriculumList", "Lcom/tal/app/thinkacademy/business/login/entity/ClassListEntity;", "Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeZoneList", "", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "legalFiles", "Lcom/tal/app/thinkacademy/business/login/entity/AboutListEntity;", "loginOut", "modifyUserBasicInfo", "Lcom/tal/app/thinkacademy/business/login/entity/post/ModifyUserInfo;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/ModifyUserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "securityCheck", "Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheck;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheck;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lcom/tal/app/thinkacademy/business/login/entity/SetPasswordData;", "submitFeedback", "Lcom/tal/app/thinkacademy/business/login/entity/post/SubmitFeedback;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/SubmitFeedback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchLogin", "Lcom/tal/app/thinkacademy/common/entity/SwitchLogin;", "(Lcom/tal/app/thinkacademy/common/entity/SwitchLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPublicRead", "Lokhttp3/RequestBody;", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiService.kt */
public interface ApiService {
    @POST("v1/account/change/check")
    Object accountCheck(@Body AccountCheckRequest accountCheckRequest, Continuation<? super HiResponse<AccountCheckData>> continuation);

    @POST("v2/ucenter/account/login")
    @Headers({"local-sign-tag: true"})
    Object accountLogin(@Body AccountLogin accountLogin, Continuation<? super HiResponse<UserBean>> continuation);

    @POST("v1/ucenter/account/associated/add_new")
    Object addNewStudent(@Body AddNewStudentRequest addNewStudentRequest, Continuation<? super HiResponse<AddNewStudent>> continuation);

    @POST("v1/manage/api/resource/query")
    Object bannersData(@Body BannersRequest bannersRequest, Continuation<? super HiResponse<List<BannersData>>> continuation);

    @POST("v2/ucenter/basic_info/user/get")
    Object basicInfoUserGet(@Body UserinfoGetBody userinfoGetBody, Continuation<? super HiResponse<UseGetInfo>> continuation);

    @POST("v1/ucenter/account/email/bind")
    Object bindEmail(@Body BindEmail bindEmail, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/ucenter/account/password/modify")
    Object changePassword(@Body ChangePassword changePassword, Continuation<? super HiResponse<Object>> continuation);

    @POST
    Object checkUrl(@Url String str, Continuation<? super HiResponse<Object>> continuation);

    @POST("v2/ucenter/account/quick_login")
    @Headers({"local-sign-tag: true"})
    Object codeLogin(@Body CodeLogin codeLogin, Continuation<? super HiResponse<UserBean>> continuation);

    @POST("v1/ucenter/account/associated/list")
    Object getAccountList(@Body String str, @Header("schoolCode") String str2, Continuation<? super HiResponse<AccountListEntity>> continuation);

    @POST("v1/aggregate/user/info")
    Object getBasicUserInfo(@Body String str, Continuation<? super HiResponse<BasicUserInfo>> continuation);

    @POST("api/classroom/v1/deviceDetection")
    Object getDeviceConfig(Continuation<? super HiResponse<DeviceConfig>> continuation);

    @POST("v1/basic/client/grade/query")
    Object getGradeStageList(@Body GetGradeList getGradeList, Continuation<? super HiResponse<GradeStageList>> continuation);

    @POST("v1/ucenter/basic_info/master_user/get")
    Object getMasterUserInfo(@Body String str, Continuation<? super HiResponse<MasterUserBean>> continuation);

    @POST("v1/ucenter/basic_info/user/nickname/get")
    Object getNickname(@Body String str, Continuation<? super HiResponse<NicknameBean>> continuation);

    @POST("v2/ucenter/common/verification/send")
    @Headers({"local-sign-tag: true"})
    Object getSmsCode(@Body GetCode getCode, Continuation<? super HiResponse<Object>> continuation);

    @POST
    Object getStudentCurriculumList(@Url String str, @Body CurriculumListData curriculumListData, Continuation<? super HiResponse<ClassListEntity>> continuation);

    @POST("v1/i18n/api/time/get/timezone")
    Object getTimeZoneList(Continuation<? super HiResponse<String[]>> continuation);

    @POST("classroom-hub/coin/student/initEntry")
    Object initEntryInfoData(@Body String str, Continuation<? super HiResponse<InitEntryInfoBean>> continuation);

    @POST("v1/config/legalFiles")
    Object legalFiles(@Body String str, Continuation<? super HiResponse<AboutListEntity>> continuation);

    @POST("v1/ucenter/account/logout")
    Object loginOut(@Body String str, Continuation<? super HiResponse<Object>> continuation);

    @POST("v2/ucenter/basic_info/user/modify")
    Object modifyUserBasicInfo(@Body ModifyUserInfo modifyUserInfo, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/ucenter/common/verification/check")
    Object securityCheck(@Body SecurityCheck securityCheck, Continuation<? super HiResponse<Object>> continuation);

    @POST("v2/ucenter/account/password/reset")
    @Headers({"local-sign-tag: true"})
    Object setPassword(@Body ChangePassword changePassword, Continuation<? super HiResponse<SetPasswordData>> continuation);

    @POST("v1/feedback/submit")
    Object submitFeedback(@Body SubmitFeedback submitFeedback, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/ucenter/account/switch_login")
    Object switchLogin(@Body SwitchLogin switchLogin, Continuation<? super HiResponse<UserBean>> continuation);

    @POST("v1/basic/client/picture/uploadPublicRead")
    @Multipart
    Object uploadPublicRead(@Part("schoolCode") RequestBody requestBody, @Part MultipartBody.Part part, Continuation<? super HiResponse<String>> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object basicInfoUserGet$default(ApiService apiService, UserinfoGetBody userinfoGetBody, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    userinfoGetBody = new UserinfoGetBody((UserinfoGetBodyHead) null, 1, (DefaultConstructorMarker) null);
                }
                return apiService.basicInfoUserGet(userinfoGetBody, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: basicInfoUserGet");
        }
    }
}
