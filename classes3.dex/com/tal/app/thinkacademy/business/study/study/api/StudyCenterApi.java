package com.tal.app.thinkacademy.business.study.study.api;

import com.tal.app.thinkacademy.business.study.study.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.AllSchoolsList;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInData;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInStatus;
import com.tal.app.thinkacademy.business.study.study.entity.CheckStudentInClass;
import com.tal.app.thinkacademy.business.study.study.entity.ClassCalendarEntity;
import com.tal.app.thinkacademy.business.study.study.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.CurrentSchool;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Nickname;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean;
import com.tal.app.thinkacademy.business.study.study.entity.PrepareClassBean;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBackBean;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBean;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedClassList;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedPaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity;
import com.tal.app.thinkacademy.business.study.study.entity.request.AllSchoolsRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.ChangeNickNameRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.CheckInRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.ClassCalendarRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.EnterRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequestData;
import com.tal.app.thinkacademy.business.study.study.entity.request.GoGlobalRequestHeader;
import com.tal.app.thinkacademy.business.study.study.entity.request.InitModuleRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.MaterialsReportRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.ModifyNickNameRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.PaperDetailRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.PaperOverviewRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.RecordedCalendarRequestData;
import com.tal.app.thinkacademy.business.study.study.entity.request.RecordedPaperOverviewRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.SwitchOptionsRequest;
import com.tal.app.thinkacademy.business.study.study.entity.request.SyncHomeWork;
import com.tal.app.thinkacademy.business.study.study.entity.request.TeachMethodRequest;
import com.tal.app.thinkacademy.common.entity.BaseRequestBean;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.common.entity.InitEntryInfoBean;
import com.tal.app.thinkacademy.common.entity.ReadyRequestBean;
import com.tal.app.thinkacademy.common.entity.SwitchLogin;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00032\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ/\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00032\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J#\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00032\b\b\u0001\u0010\u001e\u001a\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u0004\u0018\u00010&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J#\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u00032\b\b\u0001\u0010\u0007\u001a\u00020,H§@ø\u0001\u0000¢\u0006\u0002\u0010-J#\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u00032\b\b\u0001\u0010\u0007\u001a\u00020/H§@ø\u0001\u0000¢\u0006\u0002\u00100J#\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00032\b\b\u0001\u0010\u001e\u001a\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J#\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u00032\b\b\u0001\u0010\u001e\u001a\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J#\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00032\b\b\u0001\u0010\u001e\u001a\u000207H§@ø\u0001\u0000¢\u0006\u0002\u00108J#\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u00032\b\b\u0001\u0010\u001e\u001a\u00020#H§@ø\u0001\u0000¢\u0006\u0002\u0010$J/\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u00032\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020=0\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ/\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0\u00032\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ#\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\u00032\b\b\u0001\u0010\u0007\u001a\u00020BH§@ø\u0001\u0000¢\u0006\u0002\u0010CJ/\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0\u00032\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020F0\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0007\u001a\u00020JH§@ø\u0001\u0000¢\u0006\u0002\u0010KJ#\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0\u00032\b\b\u0001\u0010\u001e\u001a\u00020NH§@ø\u0001\u0000¢\u0006\u0002\u0010OJ+\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ;\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010U\u001a\u00020V2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010WH§@ø\u0001\u0000¢\u0006\u0002\u0010XJ;\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010U\u001a\u00020V2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010ZH§@ø\u0001\u0000¢\u0006\u0002\u0010[J#\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010]0\u00032\b\b\u0001\u0010^\u001a\u00020_H§@ø\u0001\u0000¢\u0006\u0002\u0010`J!\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0007\u001a\u00020bH§@ø\u0001\u0000¢\u0006\u0002\u0010cJ!\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020fH§@ø\u0001\u0000¢\u0006\u0002\u0010gJ \u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010e0\u00030i2\b\b\u0001\u0010\u0007\u001a\u00020fH'J!\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0007\u001a\u00020kH§@ø\u0001\u0000¢\u0006\u0002\u0010l\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/api/StudyCenterApi;", "", "checkStudentClass", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckStudentInClass;", "url", "", "body", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/CheckInRequest;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/request/CheckInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountList", "Lcom/tal/app/thinkacademy/business/study/study/entity/AccountListEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSchoolsList", "Lcom/tal/app/thinkacademy/business/study/study/entity/AllSchoolsList;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/AllSchoolsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassCalendar", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassCalendarEntity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/ClassCalendarRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/ClassCalendarRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassListByStuId", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassListEntity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/GoGlobalRequest;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/GoGlobalRequestHeader;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/GoGlobalRequestData;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/GoGlobalRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentSchool", "Lcom/tal/app/thinkacademy/business/study/study/entity/CurrentSchool;", "getHomeWorkJumpUrl", "Body", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMaterialsList", "Lcom/tal/app/thinkacademy/business/study/study/entity/LearnMaterialsEntity;", "Lcom/tal/app/thinkacademy/common/entity/BaseRequestBean;", "(Lcom/tal/app/thinkacademy/common/entity/BaseRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetStatus", "Lokhttp3/ResponseBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNickname", "Lcom/tal/app/thinkacademy/business/study/study/entity/Nickname;", "getPaperDetail", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperDetailRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperDetailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaperOverview", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperOverviewRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperOverviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaybackInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBackBean;", "getPlaybackOfflineData", "Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean;", "getPrepareClass", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBean;", "Lcom/tal/app/thinkacademy/common/entity/ReadyRequestBean;", "(Lcom/tal/app/thinkacademy/common/entity/ReadyRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrepareClassDate", "Lcom/tal/app/thinkacademy/business/study/study/entity/PrepareClassBean;", "getRecordedCalendarData", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedCalendarRequestData;", "getRecordedClassList", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedClassList;", "getRecordedPaperOverview", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedPaperOverviewRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedPaperOverviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSwitchOptions", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/SwitchOptionsRequest;", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "modifyNickname", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/ModifyNickNameRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/ModifyNickNameRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportMaterialsDownload", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/MaterialsReportRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/MaterialsReportRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCheckInData", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "requestCheckInStatus", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInStatus;", "requestInitModule", "cache", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/InitModuleRequest;", "(Ljava/lang/String;ZLcom/tal/app/thinkacademy/business/study/study/entity/request/InitModuleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPlaybackEnter", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/EnterRequest;", "(Ljava/lang/String;ZLcom/tal/app/thinkacademy/business/study/study/entity/request/EnterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestTeachMethod", "Lcom/tal/app/thinkacademy/business/study/study/entity/TeachMethodEntity;", "requestBody", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/TeachMethodRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/TeachMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNickname", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/ChangeNickNameRequest;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/ChangeNickNameRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchLogin", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "Lcom/tal/app/thinkacademy/common/entity/SwitchLogin;", "(Lcom/tal/app/thinkacademy/common/entity/SwitchLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchLoginApi", "Lretrofit2/Call;", "syncHomeWork", "Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyCenterApi.kt */
public interface StudyCenterApi {
    @POST
    Object checkStudentClass(@Url String str, @Body CheckInRequest checkInRequest, Continuation<? super HiResponse<CheckStudentInClass>> continuation);

    @POST("v1/ucenter/account/associated/list")
    Object getAccountList(@Body String str, Continuation<? super HiResponse<AccountListEntity>> continuation);

    @POST("/v1/studyCenter/signup/getSignUpSchools")
    Object getAllSchoolsList(@Body AllSchoolsRequest allSchoolsRequest, Continuation<? super HiResponse<AllSchoolsList>> continuation);

    @POST("v1/studyCenter/classCalendar")
    Object getClassCalendar(@Body ClassCalendarRequest classCalendarRequest, Continuation<? super HiResponse<ClassCalendarEntity>> continuation);

    @POST("v1/studyCenter/classList/v3")
    Object getClassListByStuId(@Body GoGlobalRequest<GoGlobalRequestHeader, GoGlobalRequestData> goGlobalRequest, Continuation<? super HiResponse<ClassListEntity>> continuation);

    @POST("/v1/studyCenter/signup/getCurrentSchoolSignUpStatus")
    Object getCurrentSchool(@Body GoGlobalRequest<GoGlobalRequestHeader, GoGlobalRequestData> goGlobalRequest, Continuation<? super HiResponse<CurrentSchool>> continuation);

    @POST("homework-api/student/neirongyun/jumpUrl")
    Object getHomeWorkJumpUrl(@Body JumpParamsEntity jumpParamsEntity, Continuation<? super HiResponse<String>> continuation);

    @POST("/classroom-hub/material/student/detail")
    Object getMaterialsList(@Body BaseRequestBean baseRequestBean, Continuation<? super HiResponse<LearnMaterialsEntity>> continuation);

    @POST("/classroom-hub/raw/classroom/health")
    Object getNetStatus(Continuation<? super ResponseBody> continuation);

    @POST("v1/ucenter/basic_info/user/nickname/get")
    Object getNickname(@Body String str, Continuation<? super HiResponse<Nickname>> continuation);

    @POST("/homework-api/student/paperDetail")
    Object getPaperDetail(@Body PaperDetailRequest paperDetailRequest, Continuation<? super HiResponse<PaperDetailEntity>> continuation);

    @POST("/homework-api/student/paperOverview")
    Object getPaperOverview(@Body PaperOverviewRequest paperOverviewRequest, Continuation<? super HiResponse<PaperDetailEntity>> continuation);

    @POST("/api/hub/playback/info")
    Object getPlaybackInfo(@Body BaseRequestBean baseRequestBean, Continuation<? super HiResponse<ReadyClassBackBean>> continuation);

    @POST("/api/playback/v1/download")
    Object getPlaybackOfflineData(@Body BaseRequestBean baseRequestBean, Continuation<? super HiResponse<PlaybackOfflineBean>> continuation);

    @POST("/api/hub/classroom/student/preClassPrepare")
    Object getPrepareClass(@Body ReadyRequestBean readyRequestBean, Continuation<? super HiResponse<ReadyClassBean>> continuation);

    @POST("/classroom-hub/classroom/student/preClassPrepare")
    Object getPrepareClassDate(@Body BaseRequestBean baseRequestBean, Continuation<? super HiResponse<PrepareClassBean>> continuation);

    @POST("v1/studyCenter/record/getSchedule")
    Object getRecordedCalendarData(@Body GoGlobalRequest<GoGlobalRequestHeader, RecordedCalendarRequestData> goGlobalRequest, Continuation<? super HiResponse<RecordedCalendarListEntity>> continuation);

    @POST("v1/studyCenter/record/getCourseList")
    Object getRecordedClassList(@Body GoGlobalRequest<GoGlobalRequestHeader, GoGlobalRequestData> goGlobalRequest, Continuation<? super HiResponse<RecordedClassList>> continuation);

    @POST("/beibo/student/paperOverview")
    Object getRecordedPaperOverview(@Body RecordedPaperOverviewRequest recordedPaperOverviewRequest, Continuation<? super HiResponse<RecordedPaperDetailEntity>> continuation);

    @POST("v1/studyCenter/signup/getSwitchOptions")
    Object getSwitchOptions(@Body GoGlobalRequest<GoGlobalRequestHeader, SwitchOptionsRequest> goGlobalRequest, Continuation<? super HiResponse<SwitchOptionsList>> continuation);

    @POST("classroom-hub/coin/student/initEntry")
    Object initEntryInfoData(@Body String str, Continuation<? super HiResponse<InitEntryInfoBean>> continuation);

    @POST("v2/ucenter/basic_info/user/modify")
    Object modifyNickname(@Body ModifyNickNameRequest modifyNickNameRequest, Continuation<? super HiResponse<Object>> continuation);

    @POST("/classroom-hub/material/student/view/increment")
    Object reportMaterialsDownload(@Body MaterialsReportRequest materialsReportRequest, Continuation<? super HiResponse<EmptyBean>> continuation);

    @POST
    Object requestCheckInData(@Url String str, @Body CheckInRequest checkInRequest, Continuation<? super HiResponse<CheckInData>> continuation);

    @POST
    Object requestCheckInStatus(@Url String str, @Body CheckInRequest checkInRequest, Continuation<? super HiResponse<CheckInStatus>> continuation);

    @POST
    Object requestInitModule(@Url String str, @Header("tal_use_cache") boolean z, @Body InitModuleRequest initModuleRequest, Continuation<? super HiResponse<Object>> continuation);

    @POST
    Object requestPlaybackEnter(@Url String str, @Header("tal_use_cache") boolean z, @Body EnterRequest enterRequest, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/studyCenter/teachMethod")
    Object requestTeachMethod(@Body TeachMethodRequest teachMethodRequest, Continuation<? super HiResponse<TeachMethodEntity>> continuation);

    @POST("v1/ucenter/basic_info/user/nickname/modify")
    Object setNickname(@Body ChangeNickNameRequest changeNickNameRequest, Continuation<? super HiResponse<Object>> continuation);

    @POST("v1/ucenter/account/switch_login")
    Object switchLogin(@Body SwitchLogin switchLogin, Continuation<? super HiResponse<UserBean>> continuation);

    @POST("v1/ucenter/account/switch_login")
    Call<HiResponse<UserBean>> switchLoginApi(@Body SwitchLogin switchLogin);

    @POST("/homework-api/student/sync")
    Object syncHomeWork(@Body SyncHomeWork syncHomeWork, Continuation<? super HiResponse<Object>> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyCenterApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getClassListByStuId$default(StudyCenterApi studyCenterApi, GoGlobalRequest goGlobalRequest, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    goGlobalRequest = new GoGlobalRequest((Object) null, (Object) null, 3, (DefaultConstructorMarker) null);
                }
                return studyCenterApi.getClassListByStuId(goGlobalRequest, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassListByStuId");
        }

        public static /* synthetic */ Object getSwitchOptions$default(StudyCenterApi studyCenterApi, GoGlobalRequest goGlobalRequest, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    goGlobalRequest = new GoGlobalRequest((Object) null, (Object) null, 3, (DefaultConstructorMarker) null);
                }
                return studyCenterApi.getSwitchOptions(goGlobalRequest, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSwitchOptions");
        }

        public static /* synthetic */ Object getCurrentSchool$default(StudyCenterApi studyCenterApi, GoGlobalRequest goGlobalRequest, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    goGlobalRequest = new GoGlobalRequest((Object) null, (Object) null, 3, (DefaultConstructorMarker) null);
                }
                return studyCenterApi.getCurrentSchool(goGlobalRequest, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentSchool");
        }

        public static /* synthetic */ Object getRecordedClassList$default(StudyCenterApi studyCenterApi, GoGlobalRequest goGlobalRequest, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    goGlobalRequest = new GoGlobalRequest((Object) null, (Object) null, 3, (DefaultConstructorMarker) null);
                }
                return studyCenterApi.getRecordedClassList(goGlobalRequest, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordedClassList");
        }
    }
}
