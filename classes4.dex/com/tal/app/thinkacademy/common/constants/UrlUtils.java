package com.tal.app.thinkacademy.common.constants;

import android.text.TextUtils;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b=\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020\u0004H\u0002J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/common/constants/UrlUtils;", "", "()V", "URL_ALPHA_AUSTRALIA", "", "URL_ALPHA_CANADA", "URL_ALPHA_HK", "URL_ALPHA_MALAYSIA", "URL_ALPHA_MARS", "URL_ALPHA_SGP", "URL_ALPHA_THINK_CHINESE", "URL_ALPHA_TMC", "URL_ALPHA_UK", "URL_ALPHA_USA", "URL_DEV_AUSTRALIA", "URL_DEV_CANADA", "URL_DEV_HK", "URL_DEV_MALAYSIA", "URL_DEV_MARS", "URL_DEV_SGP", "URL_DEV_THINK_CHINESE", "URL_DEV_TMC", "URL_DEV_UK", "URL_DEV_USA", "URL_PRE_AUSTRALIA", "URL_PRE_CANADA", "URL_PRE_HK", "URL_PRE_MALAYSIA", "URL_PRE_MARS", "URL_PRE_SGP", "URL_PRE_THINK_CHINESE", "URL_PRE_TMC", "URL_PRE_UK", "URL_PRE_USA", "URL_PROD_AUSTRALIA", "URL_PROD_CANADA", "URL_PROD_HK", "URL_PROD_MALAYSIA", "URL_PROD_MARS", "URL_PROD_SGP", "URL_PROD_THINK_CHINESE", "URL_PROD_TMC", "URL_PROD_UK", "URL_PROD_USA", "URL_STUDENT_BETA", "URL_STUDENT_PRE", "URL_STUDENT_PROD", "URL_TEST_AUSTRALIA", "URL_TEST_CANADA", "URL_TEST_HK", "URL_TEST_MALAYSIA", "URL_TEST_MARS", "URL_TEST_SGP", "URL_TEST_THINK_CHINESE", "URL_TEST_TMC", "URL_TEST_UK", "URL_TEST_USA", "studentHost", "getStudentHost", "()Ljava/lang/String;", "studentHost$delegate", "Lkotlin/Lazy;", "getStudentDomain", "getTouchAppV2Host", "getTouchHost", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlUtils.kt */
public final class UrlUtils {
    public static final UrlUtils INSTANCE = new UrlUtils();
    public static final String URL_ALPHA_AUSTRALIA = "https://alpha-touch-au.thethinkacademy.com";
    public static final String URL_ALPHA_CANADA = "https://alpha-touch-ca.thethinkacademy.com";
    public static final String URL_ALPHA_HK = "https://alpha-touch-hk.thethinkacademy.com";
    public static final String URL_ALPHA_MALAYSIA = "https://alpha-touch-my.thethinkacademy.com";
    public static final String URL_ALPHA_MARS = "https://alpha-touch-mars.thethinkacademy.com";
    public static final String URL_ALPHA_SGP = "https://alpha-touch.thinkacademy.sg";
    public static final String URL_ALPHA_THINK_CHINESE = "http://alpha-touch-chinese.thethinkacademy.com";
    public static final String URL_ALPHA_TMC = "https://alpha-touch.globalmathclub.com";
    public static final String URL_ALPHA_UK = "https://alpha-touch.thinkacademy.uk";
    public static final String URL_ALPHA_USA = "https://alpha-touch.thethinkacademy.com";
    public static final String URL_DEV_AUSTRALIA = "https://dev-touch-au.thethinkacademy.com";
    public static final String URL_DEV_CANADA = "https://dev-touch-ca.thethinkacademy.com";
    public static final String URL_DEV_HK = "https://dev-touch-hk.thethinkacademy.com";
    public static final String URL_DEV_MALAYSIA = "https://dev-touch-my.thethinkacademy.com";
    public static final String URL_DEV_MARS = "https://dev-touch-mars.thethinkacademy.com";
    public static final String URL_DEV_SGP = "https://dev-touch.thinkacademy.sg";
    public static final String URL_DEV_THINK_CHINESE = "https://dev-touch-chinese.thethinkacademy.com";
    public static final String URL_DEV_TMC = "https://dev-touch.globalmathclub.com";
    public static final String URL_DEV_UK = "https://dev-touch.thinkacademy.uk";
    public static final String URL_DEV_USA = "https://dev-touch.thethinkacademy.com";
    public static final String URL_PRE_AUSTRALIA = "https://pre-prod-touch-au.thethinkacademy.com";
    public static final String URL_PRE_CANADA = "https://pre-prod-touch-ca.thethinkacademy.com";
    public static final String URL_PRE_HK = "https://pre-prod-touch-hk.thethinkacademy.com";
    public static final String URL_PRE_MALAYSIA = "https://pre-prod-touch-my.thethinkacademy.com";
    public static final String URL_PRE_MARS = "https://pre-prod-touch-mars.thethinkacademy.com";
    public static final String URL_PRE_SGP = "https://pre-prod-touch.thinkacademy.sg";
    public static final String URL_PRE_THINK_CHINESE = "https://pre-prod-touch-chinese.thethinkacademy.com";
    public static final String URL_PRE_TMC = "https://pre-prod-touch.globalmathclub.com";
    public static final String URL_PRE_UK = "https://pre-prod-touch.thinkacademy.uk";
    public static final String URL_PRE_USA = "https://pre-prod-touch.thethinkacademy.com";
    public static final String URL_PROD_AUSTRALIA = "https://touch-au.thethinkacademy.com";
    public static final String URL_PROD_CANADA = "https://touch.thinkacademy.ca";
    public static final String URL_PROD_HK = "https://touch-hk.thethinkacademy.com";
    public static final String URL_PROD_MALAYSIA = "https://touch.thinkacademymy.com";
    public static final String URL_PROD_MARS = "https://touch-mars.thethinkacademy.com";
    public static final String URL_PROD_SGP = "https://touch.thinkacademy.sg";
    public static final String URL_PROD_THINK_CHINESE = "https://touch-chinese.thethinkacademy.com";
    public static final String URL_PROD_TMC = "https://touch.globalmathclub.com";
    public static final String URL_PROD_UK = "https://touch.thinkacademy.uk";
    public static final String URL_PROD_USA = "https://touch.thethinkacademy.com";
    private static final String URL_STUDENT_BETA = "https://beta-student-h5.thethinkacademy.com/";
    private static final String URL_STUDENT_PRE = "https://student-homework-pre.thethinkacademy.com/";
    private static final String URL_STUDENT_PROD = "https://student-h5.thethinkacademy.com/";
    public static final String URL_TEST_AUSTRALIA = "https://beta-touch-au.thethinkacademy.com";
    public static final String URL_TEST_CANADA = "https://beta-touch-ca.thethinkacademy.com";
    public static final String URL_TEST_HK = "https://beta-touch-hk.thethinkacademy.com";
    public static final String URL_TEST_MALAYSIA = "https://beta-touch-my.thethinkacademy.com";
    public static final String URL_TEST_MARS = "https://beta-touch-mars.thethinkacademy.com";
    public static final String URL_TEST_SGP = "https://beta-touch.thinkacademy.sg";
    public static final String URL_TEST_THINK_CHINESE = "http://beta-touch-chinese.thethinkacademy.com";
    public static final String URL_TEST_TMC = "https://beta-touch.globalmathclub.com";
    public static final String URL_TEST_UK = "https://beta-touch.thinkacademy.uk";
    public static final String URL_TEST_USA = "https://beta-touch.thethinkacademy.com";
    private static final Lazy studentHost$delegate = LazyKt.lazy(UrlUtils$studentHost$2.INSTANCE);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UrlUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.TEST.ordinal()] = 1;
            iArr[ENVIRONMENTAL.ALPHA.ordinal()] = 2;
            iArr[ENVIRONMENTAL.DEVELOP.ordinal()] = 3;
            iArr[ENVIRONMENTAL.PRE.ordinal()] = 4;
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UrlUtils() {
    }

    public final String getTouchAppV2Host() {
        int tryParseInt = ParseUtils.tryParseInt(ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), 0);
        String str = SchoolConstants.INSTANCE.getSchoolMallTouchUrlHost(tryParseInt) + "/app-v2";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(S…end(\"/app-v2\").toString()");
        return str;
    }

    public final String getTouchHost() {
        return SchoolConstants.INSTANCE.getSchoolMallTouchUrlHost(ParseUtils.tryParseInt(ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), 0));
    }

    public final String getStudentHost() {
        return (String) studentHost$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getStudentDomain() {
        String stringPlus;
        String stringPlus2;
        String stringPlus3;
        HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
        int i = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            if (hostUrls != null) {
                if (!(!TextUtils.isEmpty(hostUrls.getH5Domain()))) {
                    hostUrls = null;
                }
                if (!(hostUrls == null || (stringPlus = Intrinsics.stringPlus(hostUrls.getH5Domain(), "/")) == null)) {
                    return stringPlus;
                }
            }
            return URL_STUDENT_BETA;
        } else if (i == 4) {
            if (hostUrls != null) {
                if (!(!TextUtils.isEmpty(hostUrls.getH5Domain()))) {
                    hostUrls = null;
                }
                if (!(hostUrls == null || (stringPlus2 = Intrinsics.stringPlus(hostUrls.getH5Domain(), "/")) == null)) {
                    return stringPlus2;
                }
            }
            return URL_STUDENT_PRE;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else if (hostUrls == null) {
            return URL_STUDENT_PROD;
        } else {
            if (!(!TextUtils.isEmpty(hostUrls.getH5Domain()))) {
                hostUrls = null;
            }
            if (hostUrls == null || (stringPlus3 = Intrinsics.stringPlus(hostUrls.getH5Domain(), "/")) == null) {
                return URL_STUDENT_PROD;
            }
            return stringPlus3;
        }
    }
}
