package com.tal.app.thinkacademy.common.imconfig;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.ApiUrl;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.common.entity.CourseFilePoint;
import com.tal.app.thinkacademy.common.entity.GetSchoolListRequest;
import com.tal.app.thinkacademy.common.imconfig.ComonPackageInfo;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ConfigServerInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfigApi;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.common.network.EmptyPostBean;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0002J0\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0013\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001f\u001a\u00020\rJ&\u0010 \u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0018\u0001`#J&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`#J\u0006\u0010%\u001a\u00020\u000fJ\b\u0010&\u001a\u0004\u0018\u00010'J\u0012\u0010(\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0012J\b\u0010+\u001a\u0004\u0018\u00010,J\b\u0010-\u001a\u0004\u0018\u00010\u000fJ\b\u0010.\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010/\u001a\u00020\rJ&\u00100\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0018\u0001`#J\b\u00102\u001a\u0004\u0018\u000103J&\u00104\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000205\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000205\u0018\u0001`#J\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012J&\u00107\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`#J\u000e\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u000fJ\u0006\u0010:\u001a\u00020\u0015J\b\u0010;\u001a\u00020\rH\u0002J.\u0010<\u001a\u00020\r2&\u0010=\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\"\u0018\u0001`#J.\u0010>\u001a\u00020\r2&\u0010?\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`#J.\u0010@\u001a\u00020\r2&\u0010=\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0018\u0001`#J.\u0010A\u001a\u00020\r2&\u0010=\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000205\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000205\u0018\u0001`#J\u001b\u0010B\u001a\u00020\r2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\u0010DJ.\u0010E\u001a\u00020\r2&\u0010F\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`#R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006G"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ImConfig;", "", "()V", "mBakIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMBakIndex", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMBakIndex", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "mRetryCount", "getMRetryCount", "setMRetryCount", "commonPackage", "", "url", "", "zipMd5", "urlList", "", "downCommonPackage", "isHighest", "", "getCampusRouteList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "()[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "getCommonDistInfo", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CourseWares;", "getCommonInfo", "Lcom/tal/app/thinkacademy/common/imconfig/ComonPackageInfo$CommonInfo;", "getCommonPackageInfo", "getConfigInfo", "getCurrencyDesc", "Ljava/util/HashMap;", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "Lkotlin/collections/HashMap;", "getH5MallHost", "getHistoryMsgUrl", "getHostUrls", "Lcom/tal/app/thinkacademy/common/imconfig/HostUrlsInfo;", "getHostUrlsConfig", "getInternationalInfo", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "getIrcServer", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;", "getLiveClass", "getOverseaApi", "getSchoolList", "getSchoolMap", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolV2;", "getTeacherDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;", "getTeacherV2Map", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "getTimeZoneSwitchSchool", "getTimeZoneV2Map", "isExists", "fileName", "isUpDataCommonPackage", "retryOnGetHostFailed", "setCurrencyDescMap", "schoolsMap", "setH5MallHost", "h5MallHost", "setSchoolMap", "setTeacherV2Map", "setTimeZoneSwitchSchool", "timeZoneSwitchSchool", "([Ljava/lang/String;)V", "setTimeZoneV2Map", "timeZoneMap", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImConfig.kt */
public final class ImConfig {
    public static final ImConfig INSTANCE = new ImConfig();
    private static AtomicInteger mBakIndex = new AtomicInteger(0);
    private static AtomicInteger mRetryCount = new AtomicInteger(0);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImConfig.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getHistoryMsgUrl() {
        return "http://api.thethinkacademy.com/chat/v1/getHistoryBinaryMessages";
    }

    public final void getHostUrlsConfig() {
        getHostUrlsConfig$default(this, (String) null, 1, (Object) null);
    }

    private ImConfig() {
    }

    public final AtomicInteger getMBakIndex() {
        return mBakIndex;
    }

    public final void setMBakIndex(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        mBakIndex = atomicInteger;
    }

    public final AtomicInteger getMRetryCount() {
        return mRetryCount;
    }

    public final void setMRetryCount(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        mRetryCount = atomicInteger;
    }

    public final void getConfigInfo() {
        Call config$default = ImConfigApi.DefaultImpls.getConfig$default((ImConfigApi) Api.create(ImConfigApi.class), Intrinsics.stringPlus(ApiUrl.INSTANCE.getBASE_URL(), "v1/config/init"), (EmptyPostBean) null, 2, (Object) null);
        Callback imConfig$getConfigInfo$1 = new ImConfig$getConfigInfo$1(new ImConfig$getConfigInfo$2());
        if (!(config$default instanceof Call)) {
            config$default.enqueue(imConfig$getConfigInfo$1);
        } else {
            Retrofit2Instrumentation.enqueue(config$default, imConfig$getConfigInfo$1);
        }
    }

    public final List<ConfigInfo.Country> getInternationalInfo() {
        ConfigInfo.Country[] countryArr = (ConfigInfo.Country[]) ShareDataManager.getInstance().getCacheEntity(ConfigInfo.Country[].class, ShareDataKey.CONFIG_INFO, ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (countryArr == null) {
            return null;
        }
        return ArraysKt.toList(countryArr);
    }

    public final ConfigInfo.Teacher getTeacherDesc() {
        return (ConfigInfo.Teacher) ShareDataManager.getInstance().getCacheEntity(ConfigInfo.Teacher.class, ShareDataKey.CONFIG_TEACHER_DESC, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final void setCurrencyDescMap(HashMap<String, ConfigInfo.CurrencyDesc> hashMap) {
        if (hashMap != null) {
            ShareDataManager.getInstance().saveCacheGsonEntity(hashMap, ShareDataKey.CONFIG_CURRENCY_DESC, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final HashMap<String, ConfigInfo.CurrencyDesc> getCurrencyDesc() {
        try {
            return (HashMap) GsonUtil.getInstance().fromJson(ShareDataManager.getInstance().getString(ShareDataKey.CONFIG_CURRENCY_DESC, "", ShareDataManager.SHAREDATA_NOT_CLEAR), new ImConfig$getCurrencyDesc$localMap$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final ConfigInfo.SchoolRule[] getCampusRouteList() {
        return (ConfigInfo.SchoolRule[]) ShareDataManager.getInstance().getCacheEntity(ConfigInfo.SchoolRule[].class, ShareDataKey.CAMPUS_ROUTE, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final String getOverseaApi() {
        return ShareDataManager.getInstance().getString(ShareDataKey.OVERSEA_API, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final String getLiveClass() {
        return ShareDataManager.getInstance().getString(ShareDataKey.LIVE_CLASS, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final ConfigServerInfo.Servers.IRcProperty getIrcServer() {
        return (ConfigServerInfo.Servers.IRcProperty) ShareDataManager.getInstance().getCacheEntity(ConfigServerInfo.Servers.IRcProperty.class, ShareDataKey.IRC_SERVER, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    /* access modifiers changed from: private */
    public final void commonPackage(String str, String str2, List<String> list) {
        if (str != null && str2 != null) {
            String substring = str.substring(StringsKt.lastIndexOf$default(str, "/", 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            if (!TextUtils.equals(ShareDataManager.getInstance().getString(Intrinsics.stringPlus(substring, ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), "", ShareDataManager.SHAREDATA_CAN_CLEAR), str2)) {
                downCommonPackage(true, list, str, str2);
            }
        }
    }

    private final void downCommonPackage(boolean z, List<String> list, String str, String str2) {
        String absolutePath = AppUtil.getApplication().getFilesDir().getAbsolutePath();
        if (str == null) {
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                return;
            }
        }
        CourseFilePoint courseFilePoint = new CourseFilePoint();
        List arrayList = new ArrayList();
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            arrayList.add(str);
        }
        Collection collection2 = list;
        if (!(collection2 == null || collection2.isEmpty())) {
            arrayList.addAll(collection2);
        }
        courseFilePoint.setUrl(arrayList);
        courseFilePoint.setResBusinessType(ResourceBusinessType.TYPE_COURSE_COMMON_PACKAGE.name());
        courseFilePoint.setFilePath(Intrinsics.stringPlus(absolutePath, "/course_zip/"));
        courseFilePoint.setUnZipPath(Intrinsics.stringPlus(absolutePath, "/course_unzip/"));
        if (!StringUtils.isEmpty(charSequence)) {
            String substring = str.substring(StringsKt.lastIndexOf$default(charSequence, "/", 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            courseFilePoint.setFileName(substring);
        }
        if (str2 == null) {
            courseFilePoint.setMd5("");
        } else {
            courseFilePoint.setMd5(str2);
        }
        courseFilePoint.setIgnoreSRAVerify(true);
        courseFilePoint.setDiff(false);
        if (z) {
            courseFilePoint.setHighPriorityRes(true);
        }
        DownloadEngine.getInstance().download((FilePoint) courseFilePoint, (SimpleDownloadListener) null);
    }

    public final ConfigInfo.CourseWares getCommonPackageInfo() {
        return (ConfigInfo.CourseWares) ShareDataManager.getInstance().getCacheEntity(ConfigInfo.CourseWares.class, ShareDataKey.COMMON_COURSE_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final ConfigInfo.CourseWares getCommonDistInfo() {
        return (ConfigInfo.CourseWares) ShareDataManager.getInstance().getCacheEntity(ConfigInfo.CourseWares.class, ShareDataKey.COMMON_DIST_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final ComonPackageInfo.CommonInfo getCommonInfo() {
        return (ComonPackageInfo.CommonInfo) ShareDataManager.getInstance().getCacheEntity(ComonPackageInfo.CommonInfo.class, ShareDataKey.COMMON_INFO_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final boolean isUpDataCommonPackage() {
        if (getCommonInfo() != null) {
            ComonPackageInfo.CommonInfo commonInfo = getCommonInfo();
            String str = null;
            if ((commonInfo == null ? null : commonInfo.getCommonWebUrl()) != null) {
                ComonPackageInfo.CommonInfo commonInfo2 = getCommonInfo();
                if (commonInfo2 != null) {
                    str = commonInfo2.getDistUrl();
                }
                if (str != null) {
                    ComonPackageInfo.CommonInfo commonInfo3 = getCommonInfo();
                    Intrinsics.checkNotNull(commonInfo3);
                    String commonWebUrl = commonInfo3.getCommonWebUrl();
                    Intrinsics.checkNotNull(commonWebUrl);
                    ComonPackageInfo.CommonInfo commonInfo4 = getCommonInfo();
                    Intrinsics.checkNotNull(commonInfo4);
                    String commonWebUrl2 = commonInfo4.getCommonWebUrl();
                    Intrinsics.checkNotNull(commonWebUrl2);
                    String substring = commonWebUrl.substring(StringsKt.lastIndexOf$default(commonWebUrl2, "/", 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    ComonPackageInfo.CommonInfo commonInfo5 = getCommonInfo();
                    Intrinsics.checkNotNull(commonInfo5);
                    String distUrl = commonInfo5.getDistUrl();
                    Intrinsics.checkNotNull(distUrl);
                    ComonPackageInfo.CommonInfo commonInfo6 = getCommonInfo();
                    Intrinsics.checkNotNull(commonInfo6);
                    String distUrl2 = commonInfo6.getDistUrl();
                    Intrinsics.checkNotNull(distUrl2);
                    String substring2 = distUrl.substring(StringsKt.lastIndexOf$default(distUrl2, "/", 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    String string = ShareDataManager.getInstance().getString(Intrinsics.stringPlus(substring, ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), "", ShareDataManager.SHAREDATA_CAN_CLEAR);
                    String string2 = ShareDataManager.getInstance().getString(Intrinsics.stringPlus(substring2, ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), "", ShareDataManager.SHAREDATA_CAN_CLEAR);
                    ComonPackageInfo.CommonInfo commonInfo7 = getCommonInfo();
                    Intrinsics.checkNotNull(commonInfo7);
                    if (TextUtils.equals(string, commonInfo7.getCommonWebZipMd5())) {
                        ComonPackageInfo.CommonInfo commonInfo8 = getCommonInfo();
                        Intrinsics.checkNotNull(commonInfo8);
                        if (!TextUtils.equals(string2, commonInfo8.getDistZipMd5()) || !isExists("dist") || !isExists("common_web")) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean isExists(String str) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        return FileUtils.isFileExists(ImCoursesWareUtils.INSTANCE.getCourseWareUnpackPath() + str + '/');
    }

    /* access modifiers changed from: private */
    public final void retryOnGetHostFailed() {
        if (mRetryCount.get() >= 2) {
            mRetryCount.set(0);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()] == 1) {
            if (ApiUrl.INSTANCE.getMBakBaseUrlListPro().size() > mBakIndex.get()) {
                getHostUrlsConfig(ApiUrl.INSTANCE.getMBakBaseUrlListPro().get(mBakIndex.get()));
            }
            if (mBakIndex.get() == ApiUrl.INSTANCE.getMBakBaseUrlListPro().size() - 1) {
                mBakIndex.set(0);
            } else {
                AtomicInteger atomicInteger = mBakIndex;
                atomicInteger.set(atomicInteger.get() + 1);
            }
        }
        AtomicInteger atomicInteger2 = mRetryCount;
        atomicInteger2.set(atomicInteger2.get() + 1);
    }

    public static /* synthetic */ void getHostUrlsConfig$default(ImConfig imConfig, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ApiUrl.INSTANCE.getCONFIG_BASE_URL();
        }
        imConfig.getHostUrlsConfig(str);
    }

    public final void getHostUrlsConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Call hostConfig$default = ImConfigApi.DefaultImpls.getHostConfig$default((ImConfigApi) Api.create(ImConfigApi.class), Intrinsics.stringPlus(str, "api/smartline/v1/distribute"), (EmptyPostBean) null, 2, (Object) null);
        Callback imConfig$getHostUrlsConfig$1 = new ImConfig$getHostUrlsConfig$1(new ImConfig$getHostUrlsConfig$2());
        if (!(hostConfig$default instanceof Call)) {
            hostConfig$default.enqueue(imConfig$getHostUrlsConfig$1);
        } else {
            Retrofit2Instrumentation.enqueue(hostConfig$default, imConfig$getHostUrlsConfig$1);
        }
    }

    public final HostUrlsInfo getHostUrls() {
        return (HostUrlsInfo) ShareDataManager.getInstance().getCacheEntity(HostUrlsInfo.class, ShareDataKey.CONFIG_HOST_URLS, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final HashMap<String, String> getH5MallHost() {
        try {
            return (HashMap) GsonUtil.getInstance().fromJson(ShareDataManager.getInstance().getString(Intrinsics.stringPlus(ShareDataKey.CONFIG_H5_MAll_HOST, BaseUrlEx.Companion.getEnvironment().getEnvName()), "", ShareDataManager.SHAREDATA_NOT_CLEAR), new ImConfig$getH5MallHost$localMap$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setH5MallHost(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            ShareDataManager.getInstance().saveCacheGsonEntity(hashMap, Intrinsics.stringPlus(ShareDataKey.CONFIG_H5_MAll_HOST, BaseUrlEx.Companion.getEnvironment().getEnvName()), ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final HashMap<String, ConfigInfo.SchoolV2> getSchoolMap() {
        try {
            return (HashMap) GsonUtil.getInstance().fromJson(ShareDataManager.getInstance().getString(ShareDataKey.CONFIG_SCHOOL_MAP_V2, "", ShareDataManager.SHAREDATA_NOT_CLEAR), new ImConfig$getSchoolMap$localMap$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setSchoolMap(HashMap<String, ConfigInfo.SchoolV2> hashMap) {
        if (hashMap != null) {
            ShareDataManager.getInstance().saveCacheGsonEntity(hashMap, ShareDataKey.CONFIG_SCHOOL_MAP_V2, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final HashMap<String, ConfigInfo.TeacherName> getTeacherV2Map() {
        try {
            return (HashMap) GsonUtil.getInstance().fromJson(ShareDataManager.getInstance().getString(ShareDataKey.CONFIG_TEACHER_MAP_V2, "", ShareDataManager.SHAREDATA_NOT_CLEAR), new ImConfig$getTeacherV2Map$localMap$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setTeacherV2Map(HashMap<String, ConfigInfo.TeacherName> hashMap) {
        if (hashMap != null) {
            ShareDataManager.getInstance().saveCacheGsonEntity(hashMap, ShareDataKey.CONFIG_TEACHER_MAP_V2, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final void setTimeZoneV2Map(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            ShareDataManager.getInstance().saveCacheGsonEntity(hashMap, ShareDataKey.BRANCH_SCHOOL_TIME_ZONE_LIST, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final HashMap<String, String> getTimeZoneV2Map() {
        try {
            return (HashMap) GsonUtil.getInstance().fromJson(ShareDataManager.getInstance().getString(ShareDataKey.BRANCH_SCHOOL_TIME_ZONE_LIST, "", ShareDataManager.SHAREDATA_NOT_CLEAR), new ImConfig$getTimeZoneV2Map$localMap$1().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        if ((r4.length == 0) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTimeZoneSwitchSchool(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x000c
            int r2 = r4.length
            if (r2 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000a
        L_0x0009:
            r2 = r0
        L_0x000a:
            if (r2 == 0) goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            if (r0 != 0) goto L_0x001a
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r2 = "branch_school_support_time_zone"
            r0.saveCacheGsonEntity(r4, r2, r1)
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.imconfig.ImConfig.setTimeZoneSwitchSchool(java.lang.String[]):void");
    }

    public final List<String> getTimeZoneSwitchSchool() {
        String[] strArr = (String[]) ShareDataManager.getInstance().getCacheEntity(String[].class, ShareDataKey.BRANCH_SCHOOL_SUPPORT_TIME_ZONE, ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (strArr == null) {
            return null;
        }
        return ArraysKt.toList(strArr);
    }

    public final void getSchoolList() {
        GetSchoolListRequest getSchoolListRequest = new GetSchoolListRequest((String) null, 1, (DefaultConstructorMarker) null);
        String string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        XesLog.dt("LaunchActivity", Intrinsics.stringPlus("当前分校code:", string));
        SchoolListInfo mSchoolListInfo = SchoolConstants.INSTANCE.getMSchoolListInfo();
        getSchoolListRequest.setV(mSchoolListInfo == null ? null : mSchoolListInfo.getV());
        CharSequence charSequence = string;
        if (!(charSequence == null || charSequence.length() == 0)) {
            SchoolConstants schoolConstants = SchoolConstants.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(string, "schoolCode");
            SchoolDataInfo schoolInfo = schoolConstants.getSchoolInfo(string);
            CharSequence schoolWebSourceDomainOnline = schoolInfo == null ? null : schoolInfo.getSchoolWebSourceDomainOnline();
            if (schoolWebSourceDomainOnline == null || schoolWebSourceDomainOnline.length() == 0) {
                XesLog.dt("LaunchActivity", Intrinsics.stringPlus("当前分校h5域名为空,分校code=", string));
                getSchoolListRequest.setV((String) null);
            }
        }
        Call<HiResponse<SchoolListInfo>> schoolList = ((ImConfigApi) Api.create(ImConfigApi.class)).getSchoolList(Intrinsics.stringPlus(ApiUrl.INSTANCE.getBASE_URL(), "v1/config/allCampusWithConfigs"), getSchoolListRequest);
        Callback imConfig$getSchoolList$1 = new ImConfig$getSchoolList$1(new ImConfig$getSchoolList$2());
        if (!(schoolList instanceof Call)) {
            schoolList.enqueue(imConfig$getSchoolList$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) schoolList, imConfig$getSchoolList$1);
        }
    }
}
