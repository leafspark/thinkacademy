package com.tal.app.thinkacademy.common.constants;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.SchoolContactInfo;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.CourseStorePurchaseGuide;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.imconfig.SchoolListInfo;
import com.tal.app.thinkacademy.common.location.CustomLocationManagerKt;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.common.track.CommonTrack;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J\b\u0010$\u001a\u0004\u0018\u00010\u0019J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0004J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0010J\u0010\u0010*\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\u0004J\u0010\u0010*\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001cJ\u000e\u0010,\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u0010J\u0010\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\"\u001a\u00020\u0010J\u0006\u00106\u001a\u00020\u0010J\u0006\u00107\u001a\u00020\u001eJ\u000e\u00108\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0010J\u0010\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0019`\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/tal/app/thinkacademy/common/constants/SchoolConstants;", "", "()V", "SCHOOL_AUSTRALIA", "", "SCHOOL_CANADA", "SCHOOL_HONG_KONG", "SCHOOL_MALAYSIA", "SCHOOL_MARS", "SCHOOL_SINGAPORE", "SCHOOL_TAL", "SCHOOL_THINK_CHINESE", "SCHOOL_THINK_MATH_CLUB", "SCHOOL_UK", "SCHOOL_USA", "TAG", "", "mSchoolListInfo", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "getMSchoolListInfo", "()Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "setMSchoolListInfo", "(Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;)V", "mSchoolListMap", "Ljava/util/HashMap;", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolDataInfo;", "Lkotlin/collections/HashMap;", "mSchoolListNew", "", "checkSchoolInfoError", "", "info", "getBuySteps", "Lcom/tal/app/thinkacademy/common/imconfig/CourseStorePurchaseGuide;", "schoolCode", "getCurrentSchoolCode", "getCurrentSchoolInfo", "getIsAutoSelectSchool", "getSchoolContactInfo", "Lcom/tal/app/thinkacademy/common/entity/SchoolContactInfo;", "getSchoolCurrency", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "getSchoolInfo", "getSchoolList", "getSchoolMallTouchUrlHost", "getSchoolNameShort", "code", "getSchoolPrice", "currencyDesc", "price", "getSchoolTeacherName", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "getSchoolV2", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolV2;", "getStudyDataPath", "hasChildPrivacyAgreement", "isSchoolShowGoldMallGuide", "isSelectSchool", "isShowGstOrVat", "isShowStudyData", "schoolInfoInitNew", "", "schoolListInfo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolConstants.kt */
public final class SchoolConstants {
    public static final SchoolConstants INSTANCE = new SchoolConstants();
    public static final int SCHOOL_AUSTRALIA = 6101;
    public static final int SCHOOL_CANADA = 103;
    public static final int SCHOOL_HONG_KONG = 85201;
    public static final int SCHOOL_MALAYSIA = 6001;
    public static final int SCHOOL_MARS = 8601;
    public static final int SCHOOL_SINGAPORE = 6501;
    public static final int SCHOOL_TAL = 10086;
    public static final int SCHOOL_THINK_CHINESE = 104;
    public static final int SCHOOL_THINK_MATH_CLUB = 6502;
    public static final int SCHOOL_UK = 4401;
    public static final int SCHOOL_USA = 415;
    public static final String TAG = "SchoolConstants分校信息";
    private static SchoolListInfo mSchoolListInfo;
    private static final HashMap<String, SchoolDataInfo> mSchoolListMap = new HashMap<>();
    private static List<SchoolDataInfo> mSchoolListNew;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchoolConstants.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 1;
            iArr[ENVIRONMENTAL.TEST.ordinal()] = 2;
            iArr[ENVIRONMENTAL.DEVELOP.ordinal()] = 3;
            iArr[ENVIRONMENTAL.ALPHA.ordinal()] = 4;
            iArr[ENVIRONMENTAL.PRE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SchoolConstants() {
    }

    public final String schoolCode() {
        String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…EDATA_NOT_CLEAR\n        )");
        return string;
    }

    public final SchoolListInfo getMSchoolListInfo() {
        return mSchoolListInfo;
    }

    public final void setMSchoolListInfo(SchoolListInfo schoolListInfo) {
        mSchoolListInfo = schoolListInfo;
    }

    public final void schoolInfoInitNew(SchoolListInfo schoolListInfo) {
        List<SchoolDataInfo> list;
        List<SchoolDataInfo> list2;
        mSchoolListInfo = schoolListInfo;
        List<SchoolDataInfo> list3 = mSchoolListNew;
        if (list3 != null) {
            list3.clear();
        }
        if (mSchoolListNew == null) {
            mSchoolListNew = new ArrayList();
        }
        Object[] objArr = new Object[1];
        Integer num = null;
        if (!(schoolListInfo == null || (list2 = schoolListInfo.getList()) == null)) {
            num = Integer.valueOf(list2.size());
        }
        objArr[0] = Intrinsics.stringPlus("分校列表初始化，size = ", num);
        XesLog.dt(TAG, objArr);
        if (schoolListInfo != null && (list = schoolListInfo.getList()) != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SchoolDataInfo schoolDataInfo = (SchoolDataInfo) next;
                XesLog.dt(TAG, "分校" + schoolDataInfo.getSchoolName() + "，分校当前线上h5域名=" + schoolDataInfo.getSchoolWebSourceDomainOnline());
                Map map = mSchoolListMap;
                String schoolCode = schoolDataInfo.getSchoolCode();
                if (schoolCode == null) {
                    schoolCode = "";
                }
                map.put(schoolCode, schoolDataInfo);
                if (schoolDataInfo.getSchoolForCustomerEnabled()) {
                    XesLog.dt(TAG, "分校" + schoolDataInfo.getSchoolName() + ",添加到分校列表");
                    List<SchoolDataInfo> list4 = mSchoolListNew;
                    if (list4 != null) {
                        list4.add(schoolDataInfo);
                    }
                } else {
                    XesLog.dt(TAG, "分校" + schoolDataInfo.getSchoolName() + "数据不可见");
                }
                i = i2;
            }
        }
    }

    public final List<SchoolDataInfo> getSchoolList() {
        return mSchoolListNew;
    }

    public final SchoolDataInfo getSchoolInfo(int i) {
        SchoolDataInfo schoolDataInfo = mSchoolListMap.get(String.valueOf(i));
        if (schoolDataInfo == null) {
            XesLog.dt(TAG, Intrinsics.stringPlus("获取分校信息为空,分校code=", Integer.valueOf(i)));
        } else {
            XesLog.dt(TAG, Intrinsics.stringPlus("获取分校信息有值,分校code=", Integer.valueOf(i)));
        }
        return schoolDataInfo;
    }

    public final SchoolDataInfo getSchoolInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        SchoolDataInfo schoolDataInfo = mSchoolListMap.get(str);
        if (schoolDataInfo == null) {
            XesLog.dt(TAG, Intrinsics.stringPlus("..获取分校信息为空,分校code=", str));
        } else {
            XesLog.dt(TAG, Intrinsics.stringPlus("..获取分校信息有值,分校code=", str));
        }
        return schoolDataInfo;
    }

    public final SchoolDataInfo getCurrentSchoolInfo() {
        return mSchoolListMap.get(getCurrentSchoolCode());
    }

    public final String getCurrentSchoolCode() {
        String string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
        return string;
    }

    public final String getSchoolNameShort(int i) {
        String str;
        if (i == 415) {
            return "us";
        }
        if (i == 4401) {
            return "uk";
        }
        if (i == 6501) {
            return "sg";
        }
        if (i == 8601) {
            return "mars";
        }
        if (i == 85201) {
            return "hk";
        }
        SchoolDataInfo schoolInfo = getSchoolInfo(i);
        if (schoolInfo == null) {
            str = null;
        } else {
            str = schoolInfo.getSchoolName();
        }
        if (str != null) {
            return str;
        }
        SchoolConstants schoolConstants = this;
        return CustomLocationManagerKt.KUnKnown;
    }

    public final ConfigInfo.SchoolV2 getSchoolV2(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        HashMap<String, ConfigInfo.SchoolV2> schoolMap = ImConfig.INSTANCE.getSchoolMap();
        if (schoolMap == null) {
            return null;
        }
        return schoolMap.get(str);
    }

    public final ConfigInfo.TeacherName getSchoolTeacherName(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        HashMap<String, ConfigInfo.TeacherName> teacherV2Map = ImConfig.INSTANCE.getTeacherV2Map();
        ConfigInfo.TeacherName teacherName = teacherV2Map == null ? null : teacherV2Map.get(str);
        if (teacherName != null) {
            return teacherName;
        }
        switch (str.hashCode()) {
            case 48628:
                if (str.equals("103")) {
                    return new ConfigInfo.TeacherName("Teacher", "Teacher");
                }
                break;
            case 51544:
                if (str.equals("415")) {
                    return new ConfigInfo.TeacherName("Content Teacher", "VIP Teacher");
                }
                break;
            case 1600641:
                if (str.equals("4401")) {
                    return new ConfigInfo.TeacherName("Tutor", "Tutor Assistant");
                }
                break;
            case 1656379:
                if (str.equals("6001")) {
                    return new ConfigInfo.TeacherName("Teacher", "Teacher");
                }
                break;
            case 1657340:
                if (str.equals("6101")) {
                    return new ConfigInfo.TeacherName("Teacher", "Teacher");
                }
                break;
            case 1661184:
                if (str.equals("6501")) {
                    return new ConfigInfo.TeacherName("Teacher", "Assistant Teacher");
                }
                break;
            case 1661185:
                if (str.equals("6502")) {
                    return new ConfigInfo.TeacherName("Teacher", "Assistant Teacher");
                }
                break;
            case 1721727:
                if (str.equals("8601")) {
                    return new ConfigInfo.TeacherName("主讲", "辅导");
                }
                break;
            case 53345686:
                if (str.equals("85201")) {
                    return new ConfigInfo.TeacherName("授課教師", "班主任");
                }
                break;
        }
        return new ConfigInfo.TeacherName("Content Teacher", "VIP Teacher");
    }

    public final SchoolContactInfo getSchoolContactInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        SchoolDataInfo schoolInfo = getSchoolInfo(str);
        boolean z = false;
        if (schoolInfo == null) {
            switch (str.hashCode()) {
                case 48628:
                    if (str.equals("103")) {
                        return new SchoolContactInfo("TALcanada@tal.com", false);
                    }
                    break;
                case 51544:
                    if (str.equals("415")) {
                        return new SchoolContactInfo("+1 (844) 844-6587", true);
                    }
                    break;
                case 1600641:
                    if (str.equals("4401")) {
                        return new SchoolContactInfo("infouk@tal.com", false);
                    }
                    break;
                case 1656379:
                    if (str.equals("6001")) {
                        return new SchoolContactInfo("Malaysia@tal.com", false);
                    }
                    break;
                case 1657340:
                    if (str.equals("6101")) {
                        return new SchoolContactInfo("australia@tal.com", false);
                    }
                    break;
                case 1661184:
                    if (str.equals("6501")) {
                        return new SchoolContactInfo("+65-91055348", true);
                    }
                    break;
                case 1661185:
                    if (str.equals("6502")) {
                        return new SchoolContactInfo("pleasecontactus@globalmathclub.com", false);
                    }
                    break;
                case 1721727:
                    if (str.equals("8601")) {
                        return new SchoolContactInfo("+1 (844) 844-6587", true);
                    }
                    break;
                case 53345686:
                    if (str.equals("85201")) {
                        return new SchoolContactInfo("+852 3556 3900", true);
                    }
                    break;
            }
            return new SchoolContactInfo("+1 (844) 844-6587", true);
        }
        String schoolContact = schoolInfo.getSchoolContact();
        if (schoolContact != null) {
            z = !StringsKt.contains$default(schoolContact, "@", false, 2, (Object) null);
        }
        return new SchoolContactInfo(schoolInfo.getSchoolContact(), z);
    }

    public final ConfigInfo.CurrencyDesc getSchoolCurrency(String str) {
        HashMap<String, ConfigInfo.CurrencyDesc> currencyDesc;
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        ConfigInfo.SchoolV2 schoolV2 = getSchoolV2(str);
        ConfigInfo.CurrencyDesc currencyDesc2 = null;
        String shortName = schoolV2 == null ? null : schoolV2.getShortName();
        CharSequence charSequence = shortName;
        if (!(charSequence == null || charSequence.length() == 0) && (currencyDesc = ImConfig.INSTANCE.getCurrencyDesc()) != null) {
            currencyDesc2 = currencyDesc.get(shortName);
        }
        if (currencyDesc2 != null) {
            return currencyDesc2;
        }
        switch (str.hashCode()) {
            case 48628:
                if (str.equals("103")) {
                    return new ConfigInfo.CurrencyDesc("C$", 100);
                }
                break;
            case 51544:
                if (str.equals("415")) {
                    return new ConfigInfo.CurrencyDesc("$", 100);
                }
                break;
            case 1600641:
                if (str.equals("4401")) {
                    return new ConfigInfo.CurrencyDesc("£", 100);
                }
                break;
            case 1656379:
                if (str.equals("6001")) {
                    return new ConfigInfo.CurrencyDesc("RM", 100);
                }
                break;
            case 1657340:
                if (str.equals("6101")) {
                    return new ConfigInfo.CurrencyDesc("A$", 100);
                }
                break;
            case 1661184:
                if (str.equals("6501")) {
                    return new ConfigInfo.CurrencyDesc("S$", 100);
                }
                break;
            case 1661185:
                if (str.equals("6502")) {
                    return new ConfigInfo.CurrencyDesc("S$", 100);
                }
                break;
            case 1721727:
                if (str.equals("8601")) {
                    return new ConfigInfo.CurrencyDesc("S$", 100);
                }
                break;
            case 53345686:
                if (str.equals("85201")) {
                    return new ConfigInfo.CurrencyDesc("HK$", 100);
                }
                break;
        }
        return new ConfigInfo.CurrencyDesc("$", 100);
    }

    public final boolean isSchoolShowGoldMallGuide(int i) {
        SchoolDataInfo schoolInfo = getSchoolInfo(i);
        if (schoolInfo == null) {
            return false;
        }
        return schoolInfo.getCoinStoreGuideAndroidEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getStudyDataUrlPath();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getStudyDataPath() {
        /*
            r2 = this;
            com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo r0 = r2.getCurrentSchoolInfo()
            java.lang.String r1 = "/app-v2/resources"
            if (r0 != 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.String r0 = r0.getStudyDataUrlPath()
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.constants.SchoolConstants.getStudyDataPath():java.lang.String");
    }

    public final boolean isShowStudyData(int i) {
        SchoolDataInfo schoolInfo = getSchoolInfo(i);
        if (schoolInfo == null) {
            return false;
        }
        return schoolInfo.getStudyDataAndroidEnabled();
    }

    public final boolean isShowGstOrVat(int i) {
        SchoolDataInfo schoolInfo = getSchoolInfo(i);
        if (schoolInfo == null) {
            return false;
        }
        return schoolInfo.getTaxCostUIEnabled();
    }

    public final String getSchoolMallTouchUrlHost(int i) {
        int i2 = i;
        int i3 = WhenMappings.$EnumSwitchMapping$0[BaseUrlEx.Companion.getEnvironment().ordinal()];
        String str = null;
        if (i3 == 1) {
            SchoolDataInfo schoolInfo = getSchoolInfo(i);
            if (schoolInfo != null) {
                str = schoolInfo.getSchoolWebSourceDomainOnline();
            }
            String str2 = str;
            XesLog.dt(TAG, "当前环境为:" + BaseUrlEx.Companion.getEnvironment() + ",分校code=" + i2 + ",url=" + str2);
            CharSequence charSequence = str2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                return str2;
            }
            XesLog.et(TAG, "h5url为空!!!,走本地默认");
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            if (i2 == 103) {
                return UrlUtils.URL_PROD_CANADA;
            }
            if (i2 == 104) {
                return UrlUtils.URL_PROD_THINK_CHINESE;
            }
            if (i2 == 415) {
                return UrlUtils.URL_PROD_USA;
            }
            if (i2 == 4401) {
                return UrlUtils.URL_PROD_UK;
            }
            if (i2 == 6001) {
                return UrlUtils.URL_PROD_MALAYSIA;
            }
            if (i2 == 6101) {
                return UrlUtils.URL_PROD_AUSTRALIA;
            }
            if (i2 == 8601) {
                return UrlUtils.URL_PROD_MARS;
            }
            if (i2 == 85201) {
                return UrlUtils.URL_PROD_HK;
            }
            if (i2 != 6501) {
                return i2 != 6502 ? UrlUtils.URL_PROD_USA : UrlUtils.URL_PROD_TMC;
            }
            return UrlUtils.URL_PROD_SGP;
        } else if (i3 == 2) {
            SchoolDataInfo schoolInfo2 = getSchoolInfo(i);
            if (schoolInfo2 != null) {
                str = schoolInfo2.getSchoolWebSourceDomainBeta();
            }
            String str3 = str;
            XesLog.dt(TAG, "当前环境为:" + BaseUrlEx.Companion.getEnvironment() + ",分校code=" + i2 + ",url=" + str3);
            CharSequence charSequence2 = str3;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                return str3;
            }
            XesLog.et(TAG, "h5url为空!!!,走本地默认");
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            if (i2 == 103) {
                return UrlUtils.URL_TEST_CANADA;
            }
            if (i2 == 104) {
                return UrlUtils.URL_TEST_THINK_CHINESE;
            }
            if (i2 == 415) {
                return UrlUtils.URL_TEST_USA;
            }
            if (i2 == 4401) {
                return UrlUtils.URL_TEST_UK;
            }
            if (i2 == 6001) {
                return UrlUtils.URL_TEST_MALAYSIA;
            }
            if (i2 == 6101) {
                return UrlUtils.URL_TEST_AUSTRALIA;
            }
            if (i2 == 8601) {
                return UrlUtils.URL_TEST_MARS;
            }
            if (i2 == 85201) {
                return UrlUtils.URL_TEST_HK;
            }
            if (i2 != 6501) {
                return i2 != 6502 ? UrlUtils.URL_TEST_USA : UrlUtils.URL_TEST_TMC;
            }
            return UrlUtils.URL_TEST_SGP;
        } else if (i3 == 3) {
            SchoolDataInfo schoolInfo3 = getSchoolInfo(i);
            if (schoolInfo3 != null) {
                str = schoolInfo3.getSchoolWebSourceDomainDev();
            }
            String str4 = str;
            XesLog.dt(TAG, "当前环境为:" + BaseUrlEx.Companion.getEnvironment() + ",分校code=" + i2 + ",url=" + str4);
            CharSequence charSequence3 = str4;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                return str4;
            }
            XesLog.et(TAG, "h5url为空!!!,走本地默认");
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            if (i2 == 103) {
                return UrlUtils.URL_DEV_CANADA;
            }
            if (i2 == 104) {
                return UrlUtils.URL_DEV_THINK_CHINESE;
            }
            if (i2 == 415) {
                return UrlUtils.URL_DEV_USA;
            }
            if (i2 == 4401) {
                return UrlUtils.URL_DEV_UK;
            }
            if (i2 == 6001) {
                return UrlUtils.URL_DEV_MALAYSIA;
            }
            if (i2 == 6101) {
                return UrlUtils.URL_DEV_AUSTRALIA;
            }
            if (i2 == 8601) {
                return UrlUtils.URL_DEV_MARS;
            }
            if (i2 == 85201) {
                return UrlUtils.URL_DEV_HK;
            }
            if (i2 != 6501) {
                return i2 != 6502 ? UrlUtils.URL_DEV_USA : UrlUtils.URL_DEV_TMC;
            }
            return UrlUtils.URL_DEV_SGP;
        } else if (i3 == 4) {
            SchoolDataInfo schoolInfo4 = getSchoolInfo(i);
            if (schoolInfo4 != null) {
                str = schoolInfo4.getSchoolWebSourceDomainAlpha();
            }
            String str5 = str;
            XesLog.dt(TAG, "当前环境为:" + BaseUrlEx.Companion.getEnvironment() + ",分校code=" + i2 + ",url=" + str5);
            CharSequence charSequence4 = str5;
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                return str5;
            }
            XesLog.et(TAG, "h5url为空!!!,走本地默认");
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            if (i2 == 103) {
                return UrlUtils.URL_ALPHA_CANADA;
            }
            if (i2 == 104) {
                return UrlUtils.URL_ALPHA_THINK_CHINESE;
            }
            if (i2 == 415) {
                return UrlUtils.URL_ALPHA_USA;
            }
            if (i2 == 4401) {
                return UrlUtils.URL_ALPHA_UK;
            }
            if (i2 == 6001) {
                return UrlUtils.URL_ALPHA_MALAYSIA;
            }
            if (i2 == 6101) {
                return UrlUtils.URL_ALPHA_AUSTRALIA;
            }
            if (i2 == 8601) {
                return UrlUtils.URL_ALPHA_MARS;
            }
            if (i2 == 85201) {
                return UrlUtils.URL_ALPHA_HK;
            }
            if (i2 != 6501) {
                return i2 != 6502 ? UrlUtils.URL_ALPHA_USA : UrlUtils.URL_ALPHA_TMC;
            }
            return UrlUtils.URL_ALPHA_SGP;
        } else if (i3 == 5) {
            SchoolDataInfo schoolInfo5 = getSchoolInfo(i);
            if (schoolInfo5 != null) {
                str = schoolInfo5.getSchoolWebSourceDomainPre();
            }
            String str6 = str;
            XesLog.dt(TAG, "当前环境为:" + BaseUrlEx.Companion.getEnvironment() + ",分校code=" + i2 + ",url=" + str6);
            CharSequence charSequence5 = str6;
            if (!(charSequence5 == null || charSequence5.length() == 0)) {
                return str6;
            }
            XesLog.et(TAG, "h5url为空!!!,走本地默认");
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            if (i2 == 103) {
                return UrlUtils.URL_PRE_CANADA;
            }
            if (i2 == 104) {
                return UrlUtils.URL_PRE_THINK_CHINESE;
            }
            if (i2 == 415) {
                return UrlUtils.URL_PRE_USA;
            }
            if (i2 == 4401) {
                return UrlUtils.URL_PRE_UK;
            }
            if (i2 == 6001) {
                return UrlUtils.URL_PRE_MALAYSIA;
            }
            if (i2 == 6101) {
                return UrlUtils.URL_PRE_AUSTRALIA;
            }
            if (i2 == 8601) {
                return UrlUtils.URL_PRE_MARS;
            }
            if (i2 == 85201) {
                return UrlUtils.URL_PRE_HK;
            }
            if (i2 != 6501) {
                return i2 != 6502 ? UrlUtils.URL_PRE_USA : UrlUtils.URL_PRE_TMC;
            }
            return UrlUtils.URL_PRE_SGP;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean getIsAutoSelectSchool(int i) {
        return getSchoolInfo(i) != null;
    }

    public final String getSchoolPrice(ConfigInfo.CurrencyDesc currencyDesc, int i) {
        Intrinsics.checkNotNullParameter(currencyDesc, "currencyDesc");
        if (i % currencyDesc.getMinorUnit() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Integer.valueOf(i / currencyDesc.getMinorUnit())), Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Float.valueOf((((float) i) * 1.0f) / ((float) currencyDesc.getMinorUnit()))), Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    public final CourseStorePurchaseGuide getBuySteps(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        SchoolDataInfo schoolInfo = getSchoolInfo(str);
        if (schoolInfo == null) {
            return null;
        }
        return schoolInfo.getCourseStorePurchaseGuide();
    }

    public final boolean isSelectSchool() {
        CharSequence string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        return !(string == null || string.length() == 0);
    }

    public final boolean checkSchoolInfoError(SchoolListInfo schoolListInfo) {
        List<SchoolDataInfo> list;
        if (schoolListInfo == null || (list = schoolListInfo.getList()) == null) {
            return false;
        }
        String currentSchoolCode = INSTANCE.getCurrentSchoolCode();
        CharSequence charSequence = currentSchoolCode;
        if (charSequence.length() > 0) {
            XesLog.dt(TAG, "checkSchoolInfo,已经选择过分校=" + currentSchoolCode + "，开始查找，分校列表中是否由此分校");
        } else {
            XesLog.dt(TAG, "checkSchoolInfo,还未选择过分校=" + currentSchoolCode + "，！！！");
        }
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SchoolDataInfo schoolDataInfo = (SchoolDataInfo) next;
            XesLog.dt(TAG, "checkSchoolInfo,打印各个分校的: schoolCode=" + schoolDataInfo.getSchoolCode() + ",h5Url=" + schoolDataInfo.getSchoolWebSourceDomainOnline());
            if ((charSequence.length() > 0) && Intrinsics.areEqual(currentSchoolCode, schoolDataInfo.getSchoolCode())) {
                XesLog.dt(TAG, "checkSchoolInfo,已经找到 schoolCode=" + schoolDataInfo.getSchoolCode() + ",h5Url=" + schoolDataInfo.getSchoolWebSourceDomainOnline());
                z = true;
            }
            CharSequence schoolCode = schoolDataInfo.getSchoolCode();
            if (!(schoolCode == null || schoolCode.length() == 0)) {
                CharSequence schoolWebSourceDomainOnline = schoolDataInfo.getSchoolWebSourceDomainOnline();
                if (!(schoolWebSourceDomainOnline == null || schoolWebSourceDomainOnline.length() == 0)) {
                    i = i2;
                }
            }
            XesLog.dt(TAG, "checkSchoolInfo 发现了分校信息异常！！！schoolCode=" + schoolDataInfo.getSchoolCode() + ",h5url=" + schoolDataInfo.getSchoolWebSourceDomainOnline());
            CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoError);
            z2 = true;
            i = i2;
        }
        if (list.size() > 0) {
            if ((charSequence.length() > 0) && !z) {
                XesLog.et(TAG, "checkSchoolInfo 分校信息正常，但是本地选择的分校不在分校列表中，直接清空选择的分校，让用户重新选择");
                ShareDataManager.getInstance().put("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
                CommonTrack.INSTANCE.hw_school_info_get_error_track(CommonTrack.SchoolInfoErrorType.SchoolInfoNotFound);
            }
        }
        return z2;
    }

    public final boolean hasChildPrivacyAgreement() {
        return ArraysKt.contains(new Integer[]{Integer.valueOf(SCHOOL_HONG_KONG), Integer.valueOf(SCHOOL_THINK_MATH_CLUB), Integer.valueOf(SCHOOL_MARS)}, StringsKt.toIntOrNull(schoolCode()));
    }
}
