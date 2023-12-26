package com.tal.app.thinkacademy.common.imconfig;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import com.tal.app.thinkacademy.live.business.chatbox.bean.TeacherControlChatBean;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b@\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\b]^_`abcdB\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e\u0012\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010`\u000e\u0012\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016`\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\u0010\u001cJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010I\u001a\u00020\u0018HÆ\u0003J\t\u0010J\u001a\u00020\u0018HÆ\u0003J%\u0010K\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ%\u0010P\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J%\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010`\u000eHÆ\u0003J%\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u000eHÆ\u0003J\t\u0010S\u001a\u00020\u0014HÆ\u0003J%\u0010T\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016`\u000eHÆ\u0003Jº\u0002\u0010U\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010`\u000e2$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142$\b\u0002\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016`\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182$\b\u0002\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00182\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J\b\u0010Z\u001a\u00020[H\u0016J\t\u0010\\\u001a\u00020\rHÖ\u0001R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R6\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R6\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010'\"\u0004\b@\u0010)R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR6\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010'\"\u0004\bG\u0010)¨\u0006e"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo;", "Ljava/io/Serializable;", "international", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "courseWarePackages", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CourseWares;", "h5BridgePackages", "campusRoute", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "h5MallUrl", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "schoolsV2", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolV2;", "teacherV2", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "teacher", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;", "currency", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "review", "", "shopAvailable", "timezoneV2", "timeZoneSwitchSchool", "([Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;Ljava/util/List;Ljava/util/List;[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;Ljava/util/HashMap;ZZLjava/util/HashMap;[Ljava/lang/String;)V", "getCampusRoute", "()[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "setCampusRoute", "([Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;)V", "[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "getCourseWarePackages", "()Ljava/util/List;", "setCourseWarePackages", "(Ljava/util/List;)V", "getCurrency", "()Ljava/util/HashMap;", "setCurrency", "(Ljava/util/HashMap;)V", "getH5BridgePackages", "setH5BridgePackages", "getH5MallUrl", "setH5MallUrl", "getInternational", "()[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "setInternational", "([Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;)V", "[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "getReview", "()Z", "setReview", "(Z)V", "getSchoolsV2", "setSchoolsV2", "getShopAvailable", "setShopAvailable", "getTeacher", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;", "setTeacher", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;)V", "getTeacherV2", "setTeacherV2", "getTimeZoneSwitchSchool", "()[Ljava/lang/String;", "setTimeZoneSwitchSchool", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getTimezoneV2", "setTimezoneV2", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "([Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;Ljava/util/List;Ljava/util/List;[Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;Ljava/util/HashMap;ZZLjava/util/HashMap;[Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo;", "equals", "other", "", "hashCode", "", "toString", "Country", "CourseWares", "Currencies", "CurrencyDesc", "SchoolRule", "SchoolV2", "Teacher", "TeacherName", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigInfo.kt */
public final class ConfigInfo implements Serializable {
    private SchoolRule[] campusRoute;
    private List<CourseWares> courseWarePackages;
    private HashMap<String, CurrencyDesc> currency;
    private List<CourseWares> h5BridgePackages;
    private HashMap<String, String> h5MallUrl;
    private Country[] international;
    private boolean review;
    private HashMap<String, SchoolV2> schoolsV2;
    private boolean shopAvailable;
    private Teacher teacher;
    private HashMap<String, TeacherName> teacherV2;
    private String[] timeZoneSwitchSchool;
    private HashMap<String, String> timezoneV2;

    public static /* synthetic */ ConfigInfo copy$default(ConfigInfo configInfo, Country[] countryArr, List list, List list2, SchoolRule[] schoolRuleArr, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, Teacher teacher2, HashMap hashMap4, boolean z, boolean z2, HashMap hashMap5, String[] strArr, int i, Object obj) {
        ConfigInfo configInfo2 = configInfo;
        int i2 = i;
        return configInfo.copy((i2 & 1) != 0 ? configInfo2.international : countryArr, (i2 & 2) != 0 ? configInfo2.courseWarePackages : list, (i2 & 4) != 0 ? configInfo2.h5BridgePackages : list2, (i2 & 8) != 0 ? configInfo2.campusRoute : schoolRuleArr, (i2 & 16) != 0 ? configInfo2.h5MallUrl : hashMap, (i2 & 32) != 0 ? configInfo2.schoolsV2 : hashMap2, (i2 & 64) != 0 ? configInfo2.teacherV2 : hashMap3, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? configInfo2.teacher : teacher2, (i2 & 256) != 0 ? configInfo2.currency : hashMap4, (i2 & 512) != 0 ? configInfo2.review : z, (i2 & 1024) != 0 ? configInfo2.shopAvailable : z2, (i2 & 2048) != 0 ? configInfo2.timezoneV2 : hashMap5, (i2 & 4096) != 0 ? configInfo2.timeZoneSwitchSchool : strArr);
    }

    public final Country[] component1() {
        return this.international;
    }

    public final boolean component10() {
        return this.review;
    }

    public final boolean component11() {
        return this.shopAvailable;
    }

    public final HashMap<String, String> component12() {
        return this.timezoneV2;
    }

    public final String[] component13() {
        return this.timeZoneSwitchSchool;
    }

    public final List<CourseWares> component2() {
        return this.courseWarePackages;
    }

    public final List<CourseWares> component3() {
        return this.h5BridgePackages;
    }

    public final SchoolRule[] component4() {
        return this.campusRoute;
    }

    public final HashMap<String, String> component5() {
        return this.h5MallUrl;
    }

    public final HashMap<String, SchoolV2> component6() {
        return this.schoolsV2;
    }

    public final HashMap<String, TeacherName> component7() {
        return this.teacherV2;
    }

    public final Teacher component8() {
        return this.teacher;
    }

    public final HashMap<String, CurrencyDesc> component9() {
        return this.currency;
    }

    public final ConfigInfo copy(Country[] countryArr, List<CourseWares> list, List<CourseWares> list2, SchoolRule[] schoolRuleArr, HashMap<String, String> hashMap, HashMap<String, SchoolV2> hashMap2, HashMap<String, TeacherName> hashMap3, Teacher teacher2, HashMap<String, CurrencyDesc> hashMap4, boolean z, boolean z2, HashMap<String, String> hashMap5, String[] strArr) {
        Country[] countryArr2 = countryArr;
        Intrinsics.checkNotNullParameter(countryArr2, "international");
        List<CourseWares> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "courseWarePackages");
        List<CourseWares> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "h5BridgePackages");
        SchoolRule[] schoolRuleArr2 = schoolRuleArr;
        Intrinsics.checkNotNullParameter(schoolRuleArr2, "campusRoute");
        HashMap<String, String> hashMap6 = hashMap;
        Intrinsics.checkNotNullParameter(hashMap6, "h5MallUrl");
        HashMap<String, SchoolV2> hashMap7 = hashMap2;
        Intrinsics.checkNotNullParameter(hashMap7, "schoolsV2");
        HashMap<String, TeacherName> hashMap8 = hashMap3;
        Intrinsics.checkNotNullParameter(hashMap8, "teacherV2");
        Teacher teacher3 = teacher2;
        Intrinsics.checkNotNullParameter(teacher3, TeacherControlChatBean.STATUS_TEACHER);
        HashMap<String, CurrencyDesc> hashMap9 = hashMap4;
        Intrinsics.checkNotNullParameter(hashMap9, "currency");
        HashMap<String, String> hashMap10 = hashMap5;
        Intrinsics.checkNotNullParameter(hashMap10, "timezoneV2");
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(strArr2, "timeZoneSwitchSchool");
        return new ConfigInfo(countryArr2, list3, list4, schoolRuleArr2, hashMap6, hashMap7, hashMap8, teacher3, hashMap9, z, z2, hashMap10, strArr2);
    }

    public String toString() {
        return "ConfigInfo(international=" + Arrays.toString(this.international) + ", courseWarePackages=" + this.courseWarePackages + ", h5BridgePackages=" + this.h5BridgePackages + ", campusRoute=" + Arrays.toString(this.campusRoute) + ", h5MallUrl=" + this.h5MallUrl + ", schoolsV2=" + this.schoolsV2 + ", teacherV2=" + this.teacherV2 + ", teacher=" + this.teacher + ", currency=" + this.currency + ", review=" + this.review + ", shopAvailable=" + this.shopAvailable + ", timezoneV2=" + this.timezoneV2 + ", timeZoneSwitchSchool=" + Arrays.toString(this.timeZoneSwitchSchool) + ')';
    }

    public ConfigInfo(Country[] countryArr, List<CourseWares> list, List<CourseWares> list2, SchoolRule[] schoolRuleArr, HashMap<String, String> hashMap, HashMap<String, SchoolV2> hashMap2, HashMap<String, TeacherName> hashMap3, Teacher teacher2, HashMap<String, CurrencyDesc> hashMap4, boolean z, boolean z2, HashMap<String, String> hashMap5, String[] strArr) {
        Intrinsics.checkNotNullParameter(countryArr, "international");
        Intrinsics.checkNotNullParameter(list, "courseWarePackages");
        Intrinsics.checkNotNullParameter(list2, "h5BridgePackages");
        Intrinsics.checkNotNullParameter(schoolRuleArr, "campusRoute");
        Intrinsics.checkNotNullParameter(hashMap, "h5MallUrl");
        Intrinsics.checkNotNullParameter(hashMap2, "schoolsV2");
        Intrinsics.checkNotNullParameter(hashMap3, "teacherV2");
        Intrinsics.checkNotNullParameter(teacher2, TeacherControlChatBean.STATUS_TEACHER);
        Intrinsics.checkNotNullParameter(hashMap4, "currency");
        Intrinsics.checkNotNullParameter(hashMap5, "timezoneV2");
        Intrinsics.checkNotNullParameter(strArr, "timeZoneSwitchSchool");
        this.international = countryArr;
        this.courseWarePackages = list;
        this.h5BridgePackages = list2;
        this.campusRoute = schoolRuleArr;
        this.h5MallUrl = hashMap;
        this.schoolsV2 = hashMap2;
        this.teacherV2 = hashMap3;
        this.teacher = teacher2;
        this.currency = hashMap4;
        this.review = z;
        this.shopAvailable = z2;
        this.timezoneV2 = hashMap5;
        this.timeZoneSwitchSchool = strArr;
    }

    public final Country[] getInternational() {
        return this.international;
    }

    public final void setInternational(Country[] countryArr) {
        Intrinsics.checkNotNullParameter(countryArr, "<set-?>");
        this.international = countryArr;
    }

    public final List<CourseWares> getCourseWarePackages() {
        return this.courseWarePackages;
    }

    public final void setCourseWarePackages(List<CourseWares> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.courseWarePackages = list;
    }

    public final List<CourseWares> getH5BridgePackages() {
        return this.h5BridgePackages;
    }

    public final void setH5BridgePackages(List<CourseWares> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.h5BridgePackages = list;
    }

    public final SchoolRule[] getCampusRoute() {
        return this.campusRoute;
    }

    public final void setCampusRoute(SchoolRule[] schoolRuleArr) {
        Intrinsics.checkNotNullParameter(schoolRuleArr, "<set-?>");
        this.campusRoute = schoolRuleArr;
    }

    public final HashMap<String, String> getH5MallUrl() {
        return this.h5MallUrl;
    }

    public final void setH5MallUrl(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.h5MallUrl = hashMap;
    }

    public final HashMap<String, SchoolV2> getSchoolsV2() {
        return this.schoolsV2;
    }

    public final void setSchoolsV2(HashMap<String, SchoolV2> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.schoolsV2 = hashMap;
    }

    public final HashMap<String, TeacherName> getTeacherV2() {
        return this.teacherV2;
    }

    public final void setTeacherV2(HashMap<String, TeacherName> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.teacherV2 = hashMap;
    }

    public final Teacher getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(Teacher teacher2) {
        Intrinsics.checkNotNullParameter(teacher2, "<set-?>");
        this.teacher = teacher2;
    }

    public final HashMap<String, CurrencyDesc> getCurrency() {
        return this.currency;
    }

    public final void setCurrency(HashMap<String, CurrencyDesc> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.currency = hashMap;
    }

    public final boolean getReview() {
        return this.review;
    }

    public final void setReview(boolean z) {
        this.review = z;
    }

    public final boolean getShopAvailable() {
        return this.shopAvailable;
    }

    public final void setShopAvailable(boolean z) {
        this.shopAvailable = z;
    }

    public final HashMap<String, String> getTimezoneV2() {
        return this.timezoneV2;
    }

    public final void setTimezoneV2(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.timezoneV2 = hashMap;
    }

    public final String[] getTimeZoneSwitchSchool() {
        return this.timeZoneSwitchSchool;
    }

    public final void setTimeZoneSwitchSchool(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.timeZoneSwitchSchool = strArr;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolV2;", "", "shortName", "", "schoolCode", "countryId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCountryId", "()I", "setCountryId", "(I)V", "getSchoolCode", "()Ljava/lang/String;", "setSchoolCode", "(Ljava/lang/String;)V", "getShortName", "setShortName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class SchoolV2 {
        private int countryId;
        private String schoolCode;
        private String shortName;

        public static /* synthetic */ SchoolV2 copy$default(SchoolV2 schoolV2, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = schoolV2.shortName;
            }
            if ((i2 & 2) != 0) {
                str2 = schoolV2.schoolCode;
            }
            if ((i2 & 4) != 0) {
                i = schoolV2.countryId;
            }
            return schoolV2.copy(str, str2, i);
        }

        public final String component1() {
            return this.shortName;
        }

        public final String component2() {
            return this.schoolCode;
        }

        public final int component3() {
            return this.countryId;
        }

        public final SchoolV2 copy(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "shortName");
            Intrinsics.checkNotNullParameter(str2, "schoolCode");
            return new SchoolV2(str, str2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchoolV2)) {
                return false;
            }
            SchoolV2 schoolV2 = (SchoolV2) obj;
            return Intrinsics.areEqual(this.shortName, schoolV2.shortName) && Intrinsics.areEqual(this.schoolCode, schoolV2.schoolCode) && this.countryId == schoolV2.countryId;
        }

        public int hashCode() {
            return (((this.shortName.hashCode() * 31) + this.schoolCode.hashCode()) * 31) + this.countryId;
        }

        public String toString() {
            return "SchoolV2(shortName=" + this.shortName + ", schoolCode=" + this.schoolCode + ", countryId=" + this.countryId + ')';
        }

        public SchoolV2(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "shortName");
            Intrinsics.checkNotNullParameter(str2, "schoolCode");
            this.shortName = str;
            this.schoolCode = str2;
            this.countryId = i;
        }

        public final String getShortName() {
            return this.shortName;
        }

        public final void setShortName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.shortName = str;
        }

        public final String getSchoolCode() {
            return this.schoolCode;
        }

        public final void setSchoolCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.schoolCode = str;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        public final void setCountryId(int i) {
            this.countryId = i;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$SchoolRule;", "", "schoolCode", "", "geoRule", "", "manualRule", "(Ljava/lang/String;ZZ)V", "getGeoRule", "()Z", "setGeoRule", "(Z)V", "getManualRule", "setManualRule", "getSchoolCode", "()Ljava/lang/String;", "setSchoolCode", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class SchoolRule {
        private boolean geoRule;
        private boolean manualRule;
        private String schoolCode;

        public static /* synthetic */ SchoolRule copy$default(SchoolRule schoolRule, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = schoolRule.schoolCode;
            }
            if ((i & 2) != 0) {
                z = schoolRule.geoRule;
            }
            if ((i & 4) != 0) {
                z2 = schoolRule.manualRule;
            }
            return schoolRule.copy(str, z, z2);
        }

        public final String component1() {
            return this.schoolCode;
        }

        public final boolean component2() {
            return this.geoRule;
        }

        public final boolean component3() {
            return this.manualRule;
        }

        public final SchoolRule copy(String str, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "schoolCode");
            return new SchoolRule(str, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchoolRule)) {
                return false;
            }
            SchoolRule schoolRule = (SchoolRule) obj;
            return Intrinsics.areEqual(this.schoolCode, schoolRule.schoolCode) && this.geoRule == schoolRule.geoRule && this.manualRule == schoolRule.manualRule;
        }

        public int hashCode() {
            int hashCode = this.schoolCode.hashCode() * 31;
            boolean z = this.geoRule;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.manualRule;
            if (!z3) {
                z2 = z3;
            }
            return i + (z2 ? 1 : 0);
        }

        public String toString() {
            return "SchoolRule(schoolCode=" + this.schoolCode + ", geoRule=" + this.geoRule + ", manualRule=" + this.manualRule + ')';
        }

        public SchoolRule(String str, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "schoolCode");
            this.schoolCode = str;
            this.geoRule = z;
            this.manualRule = z2;
        }

        public final String getSchoolCode() {
            return this.schoolCode;
        }

        public final void setSchoolCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.schoolCode = str;
        }

        public final boolean getGeoRule() {
            return this.geoRule;
        }

        public final void setGeoRule(boolean z) {
            this.geoRule = z;
        }

        public final boolean getManualRule() {
            return this.manualRule;
        }

        public final void setManualRule(boolean z) {
            this.manualRule = z;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "Ljava/io/Serializable;", "countryName", "", "countryCallingCode", "phoneMaxLength", "", "phoneMinLength", "(Ljava/lang/String;Ljava/lang/String;II)V", "getCountryCallingCode", "()Ljava/lang/String;", "setCountryCallingCode", "(Ljava/lang/String;)V", "getCountryName", "setCountryName", "getPhoneMaxLength", "()I", "setPhoneMaxLength", "(I)V", "getPhoneMinLength", "setPhoneMinLength", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class Country implements Serializable {
        private String countryCallingCode;
        private String countryName;
        private int phoneMaxLength;
        private int phoneMinLength;

        public static /* synthetic */ Country copy$default(Country country, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = country.countryName;
            }
            if ((i3 & 2) != 0) {
                str2 = country.countryCallingCode;
            }
            if ((i3 & 4) != 0) {
                i = country.phoneMaxLength;
            }
            if ((i3 & 8) != 0) {
                i2 = country.phoneMinLength;
            }
            return country.copy(str, str2, i, i2);
        }

        public final String component1() {
            return this.countryName;
        }

        public final String component2() {
            return this.countryCallingCode;
        }

        public final int component3() {
            return this.phoneMaxLength;
        }

        public final int component4() {
            return this.phoneMinLength;
        }

        public final Country copy(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "countryName");
            Intrinsics.checkNotNullParameter(str2, "countryCallingCode");
            return new Country(str, str2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Country)) {
                return false;
            }
            Country country = (Country) obj;
            return Intrinsics.areEqual(this.countryName, country.countryName) && Intrinsics.areEqual(this.countryCallingCode, country.countryCallingCode) && this.phoneMaxLength == country.phoneMaxLength && this.phoneMinLength == country.phoneMinLength;
        }

        public int hashCode() {
            return (((((this.countryName.hashCode() * 31) + this.countryCallingCode.hashCode()) * 31) + this.phoneMaxLength) * 31) + this.phoneMinLength;
        }

        public String toString() {
            return "Country(countryName=" + this.countryName + ", countryCallingCode=" + this.countryCallingCode + ", phoneMaxLength=" + this.phoneMaxLength + ", phoneMinLength=" + this.phoneMinLength + ')';
        }

        public Country(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "countryName");
            Intrinsics.checkNotNullParameter(str2, "countryCallingCode");
            this.countryName = str;
            this.countryCallingCode = str2;
            this.phoneMaxLength = i;
            this.phoneMinLength = i2;
        }

        public final String getCountryName() {
            return this.countryName;
        }

        public final void setCountryName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.countryName = str;
        }

        public final String getCountryCallingCode() {
            return this.countryCallingCode;
        }

        public final void setCountryCallingCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.countryCallingCode = str;
        }

        public final int getPhoneMaxLength() {
            return this.phoneMaxLength;
        }

        public final void setPhoneMaxLength(int i) {
            this.phoneMaxLength = i;
        }

        public final int getPhoneMinLength() {
            return this.phoneMinLength;
        }

        public final void setPhoneMinLength(int i) {
            this.phoneMinLength = i;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003J}\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0005HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006B"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CourseWares;", "Ljava/io/Serializable;", "id", "", "type", "", "url", "onlineUrl", "version", "deleted", "createTime", "", "modifyTime", "urlSpareList", "", "zipMd5", "zipSize", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/util/List;Ljava/lang/String;J)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getDeleted", "()I", "setDeleted", "(I)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getModifyTime", "setModifyTime", "getOnlineUrl", "setOnlineUrl", "getType", "setType", "getUrl", "setUrl", "getUrlSpareList", "()Ljava/util/List;", "setUrlSpareList", "(Ljava/util/List;)V", "getVersion", "setVersion", "getZipMd5", "setZipMd5", "getZipSize", "setZipSize", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class CourseWares implements Serializable {
        private long createTime;
        private int deleted;
        private String id;
        private long modifyTime;
        private String onlineUrl;
        private int type;
        private String url;
        private List<String> urlSpareList;
        private String version;
        private String zipMd5;
        private long zipSize;

        public static /* synthetic */ CourseWares copy$default(CourseWares courseWares, String str, int i, String str2, String str3, String str4, int i2, long j, long j2, List list, String str5, long j3, int i3, Object obj) {
            CourseWares courseWares2 = courseWares;
            int i4 = i3;
            return courseWares.copy((i4 & 1) != 0 ? courseWares2.id : str, (i4 & 2) != 0 ? courseWares2.type : i, (i4 & 4) != 0 ? courseWares2.url : str2, (i4 & 8) != 0 ? courseWares2.onlineUrl : str3, (i4 & 16) != 0 ? courseWares2.version : str4, (i4 & 32) != 0 ? courseWares2.deleted : i2, (i4 & 64) != 0 ? courseWares2.createTime : j, (i4 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? courseWares2.modifyTime : j2, (i4 & 256) != 0 ? courseWares2.urlSpareList : list, (i4 & 512) != 0 ? courseWares2.zipMd5 : str5, (i4 & 1024) != 0 ? courseWares2.zipSize : j3);
        }

        public final String component1() {
            return this.id;
        }

        public final String component10() {
            return this.zipMd5;
        }

        public final long component11() {
            return this.zipSize;
        }

        public final int component2() {
            return this.type;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.onlineUrl;
        }

        public final String component5() {
            return this.version;
        }

        public final int component6() {
            return this.deleted;
        }

        public final long component7() {
            return this.createTime;
        }

        public final long component8() {
            return this.modifyTime;
        }

        public final List<String> component9() {
            return this.urlSpareList;
        }

        public final CourseWares copy(String str, int i, String str2, String str3, String str4, int i2, long j, long j2, List<String> list, String str5, long j3) {
            String str6 = str;
            Intrinsics.checkNotNullParameter(str6, "id");
            String str7 = str2;
            Intrinsics.checkNotNullParameter(str7, "url");
            String str8 = str3;
            Intrinsics.checkNotNullParameter(str8, "onlineUrl");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "version");
            List<String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "urlSpareList");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, "zipMd5");
            return new CourseWares(str6, i, str7, str8, str9, i2, j, j2, list2, str10, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourseWares)) {
                return false;
            }
            CourseWares courseWares = (CourseWares) obj;
            return Intrinsics.areEqual(this.id, courseWares.id) && this.type == courseWares.type && Intrinsics.areEqual(this.url, courseWares.url) && Intrinsics.areEqual(this.onlineUrl, courseWares.onlineUrl) && Intrinsics.areEqual(this.version, courseWares.version) && this.deleted == courseWares.deleted && this.createTime == courseWares.createTime && this.modifyTime == courseWares.modifyTime && Intrinsics.areEqual(this.urlSpareList, courseWares.urlSpareList) && Intrinsics.areEqual(this.zipMd5, courseWares.zipMd5) && this.zipSize == courseWares.zipSize;
        }

        public int hashCode() {
            return (((((((((((((((((((this.id.hashCode() * 31) + this.type) * 31) + this.url.hashCode()) * 31) + this.onlineUrl.hashCode()) * 31) + this.version.hashCode()) * 31) + this.deleted) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.createTime)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.modifyTime)) * 31) + this.urlSpareList.hashCode()) * 31) + this.zipMd5.hashCode()) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.zipSize);
        }

        public String toString() {
            return "CourseWares(id=" + this.id + ", type=" + this.type + ", url=" + this.url + ", onlineUrl=" + this.onlineUrl + ", version=" + this.version + ", deleted=" + this.deleted + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ", urlSpareList=" + this.urlSpareList + ", zipMd5=" + this.zipMd5 + ", zipSize=" + this.zipSize + ')';
        }

        public CourseWares(String str, int i, String str2, String str3, String str4, int i2, long j, long j2, List<String> list, String str5, long j3) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "url");
            Intrinsics.checkNotNullParameter(str3, "onlineUrl");
            Intrinsics.checkNotNullParameter(str4, "version");
            Intrinsics.checkNotNullParameter(list, "urlSpareList");
            Intrinsics.checkNotNullParameter(str5, "zipMd5");
            this.id = str;
            this.type = i;
            this.url = str2;
            this.onlineUrl = str3;
            this.version = str4;
            this.deleted = i2;
            this.createTime = j;
            this.modifyTime = j2;
            this.urlSpareList = list;
            this.zipMd5 = str5;
            this.zipSize = j3;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getOnlineUrl() {
            return this.onlineUrl;
        }

        public final void setOnlineUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.onlineUrl = str;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }

        public final int getDeleted() {
            return this.deleted;
        }

        public final void setDeleted(int i) {
            this.deleted = i;
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        public final void setCreateTime(long j) {
            this.createTime = j;
        }

        public final long getModifyTime() {
            return this.modifyTime;
        }

        public final void setModifyTime(long j) {
            this.modifyTime = j;
        }

        public final List<String> getUrlSpareList() {
            return this.urlSpareList;
        }

        public final void setUrlSpareList(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.urlSpareList = list;
        }

        public final String getZipMd5() {
            return this.zipMd5;
        }

        public final void setZipMd5(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.zipMd5 = str;
        }

        public final long getZipSize() {
            return this.zipSize;
        }

        public final void setZipSize(long j) {
            this.zipSize = j;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Teacher;", "Ljava/io/Serializable;", "us", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "uk", "sg", "cn", "hk", "tmc", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;)V", "getCn", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "setCn", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;)V", "getHk", "setHk", "getSg", "setSg", "getTmc", "setTmc", "getUk", "setUk", "getUs", "setUs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class Teacher implements Serializable {
        private TeacherName cn;
        private TeacherName hk;
        private TeacherName sg;
        private TeacherName tmc;
        private TeacherName uk;
        private TeacherName us;

        public static /* synthetic */ Teacher copy$default(Teacher teacher, TeacherName teacherName, TeacherName teacherName2, TeacherName teacherName3, TeacherName teacherName4, TeacherName teacherName5, TeacherName teacherName6, int i, Object obj) {
            if ((i & 1) != 0) {
                teacherName = teacher.us;
            }
            if ((i & 2) != 0) {
                teacherName2 = teacher.uk;
            }
            TeacherName teacherName7 = teacherName2;
            if ((i & 4) != 0) {
                teacherName3 = teacher.sg;
            }
            TeacherName teacherName8 = teacherName3;
            if ((i & 8) != 0) {
                teacherName4 = teacher.cn;
            }
            TeacherName teacherName9 = teacherName4;
            if ((i & 16) != 0) {
                teacherName5 = teacher.hk;
            }
            TeacherName teacherName10 = teacherName5;
            if ((i & 32) != 0) {
                teacherName6 = teacher.tmc;
            }
            return teacher.copy(teacherName, teacherName7, teacherName8, teacherName9, teacherName10, teacherName6);
        }

        public final TeacherName component1() {
            return this.us;
        }

        public final TeacherName component2() {
            return this.uk;
        }

        public final TeacherName component3() {
            return this.sg;
        }

        public final TeacherName component4() {
            return this.cn;
        }

        public final TeacherName component5() {
            return this.hk;
        }

        public final TeacherName component6() {
            return this.tmc;
        }

        public final Teacher copy(TeacherName teacherName, TeacherName teacherName2, TeacherName teacherName3, TeacherName teacherName4, TeacherName teacherName5, TeacherName teacherName6) {
            Intrinsics.checkNotNullParameter(teacherName, "us");
            Intrinsics.checkNotNullParameter(teacherName2, "uk");
            Intrinsics.checkNotNullParameter(teacherName3, "sg");
            Intrinsics.checkNotNullParameter(teacherName4, "cn");
            Intrinsics.checkNotNullParameter(teacherName5, "hk");
            Intrinsics.checkNotNullParameter(teacherName6, "tmc");
            return new Teacher(teacherName, teacherName2, teacherName3, teacherName4, teacherName5, teacherName6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Teacher)) {
                return false;
            }
            Teacher teacher = (Teacher) obj;
            return Intrinsics.areEqual(this.us, teacher.us) && Intrinsics.areEqual(this.uk, teacher.uk) && Intrinsics.areEqual(this.sg, teacher.sg) && Intrinsics.areEqual(this.cn, teacher.cn) && Intrinsics.areEqual(this.hk, teacher.hk) && Intrinsics.areEqual(this.tmc, teacher.tmc);
        }

        public int hashCode() {
            return (((((((((this.us.hashCode() * 31) + this.uk.hashCode()) * 31) + this.sg.hashCode()) * 31) + this.cn.hashCode()) * 31) + this.hk.hashCode()) * 31) + this.tmc.hashCode();
        }

        public String toString() {
            return "Teacher(us=" + this.us + ", uk=" + this.uk + ", sg=" + this.sg + ", cn=" + this.cn + ", hk=" + this.hk + ", tmc=" + this.tmc + ')';
        }

        public Teacher(TeacherName teacherName, TeacherName teacherName2, TeacherName teacherName3, TeacherName teacherName4, TeacherName teacherName5, TeacherName teacherName6) {
            Intrinsics.checkNotNullParameter(teacherName, "us");
            Intrinsics.checkNotNullParameter(teacherName2, "uk");
            Intrinsics.checkNotNullParameter(teacherName3, "sg");
            Intrinsics.checkNotNullParameter(teacherName4, "cn");
            Intrinsics.checkNotNullParameter(teacherName5, "hk");
            Intrinsics.checkNotNullParameter(teacherName6, "tmc");
            this.us = teacherName;
            this.uk = teacherName2;
            this.sg = teacherName3;
            this.cn = teacherName4;
            this.hk = teacherName5;
            this.tmc = teacherName6;
        }

        public final TeacherName getUs() {
            return this.us;
        }

        public final void setUs(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.us = teacherName;
        }

        public final TeacherName getUk() {
            return this.uk;
        }

        public final void setUk(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.uk = teacherName;
        }

        public final TeacherName getSg() {
            return this.sg;
        }

        public final void setSg(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.sg = teacherName;
        }

        public final TeacherName getCn() {
            return this.cn;
        }

        public final void setCn(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.cn = teacherName;
        }

        public final TeacherName getHk() {
            return this.hk;
        }

        public final void setHk(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.hk = teacherName;
        }

        public final TeacherName getTmc() {
            return this.tmc;
        }

        public final void setTmc(TeacherName teacherName) {
            Intrinsics.checkNotNullParameter(teacherName, "<set-?>");
            this.tmc = teacherName;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$TeacherName;", "Ljava/io/Serializable;", "lecturerTitle", "", "assistantTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "getAssistantTitle", "()Ljava/lang/String;", "setAssistantTitle", "(Ljava/lang/String;)V", "getLecturerTitle", "setLecturerTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class TeacherName implements Serializable {
        private String assistantTitle;
        private String lecturerTitle;

        public static /* synthetic */ TeacherName copy$default(TeacherName teacherName, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = teacherName.lecturerTitle;
            }
            if ((i & 2) != 0) {
                str2 = teacherName.assistantTitle;
            }
            return teacherName.copy(str, str2);
        }

        public final String component1() {
            return this.lecturerTitle;
        }

        public final String component2() {
            return this.assistantTitle;
        }

        public final TeacherName copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "lecturerTitle");
            Intrinsics.checkNotNullParameter(str2, "assistantTitle");
            return new TeacherName(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TeacherName)) {
                return false;
            }
            TeacherName teacherName = (TeacherName) obj;
            return Intrinsics.areEqual(this.lecturerTitle, teacherName.lecturerTitle) && Intrinsics.areEqual(this.assistantTitle, teacherName.assistantTitle);
        }

        public int hashCode() {
            return (this.lecturerTitle.hashCode() * 31) + this.assistantTitle.hashCode();
        }

        public String toString() {
            return "TeacherName(lecturerTitle=" + this.lecturerTitle + ", assistantTitle=" + this.assistantTitle + ')';
        }

        public TeacherName(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "lecturerTitle");
            Intrinsics.checkNotNullParameter(str2, "assistantTitle");
            this.lecturerTitle = str;
            this.assistantTitle = str2;
        }

        public final String getLecturerTitle() {
            return this.lecturerTitle;
        }

        public final void setLecturerTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lecturerTitle = str;
        }

        public final String getAssistantTitle() {
            return this.assistantTitle;
        }

        public final void setAssistantTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.assistantTitle = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Currencies;", "Ljava/io/Serializable;", "us", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "uk", "sg", "cn", "hk", "tmc", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;)V", "getCn", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "setCn", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;)V", "getHk", "setHk", "getSg", "setSg", "getTmc", "setTmc", "getUk", "setUk", "getUs", "setUs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class Currencies implements Serializable {
        private CurrencyDesc cn;
        private CurrencyDesc hk;
        private CurrencyDesc sg;
        private CurrencyDesc tmc;
        private CurrencyDesc uk;
        private CurrencyDesc us;

        public static /* synthetic */ Currencies copy$default(Currencies currencies, CurrencyDesc currencyDesc, CurrencyDesc currencyDesc2, CurrencyDesc currencyDesc3, CurrencyDesc currencyDesc4, CurrencyDesc currencyDesc5, CurrencyDesc currencyDesc6, int i, Object obj) {
            if ((i & 1) != 0) {
                currencyDesc = currencies.us;
            }
            if ((i & 2) != 0) {
                currencyDesc2 = currencies.uk;
            }
            CurrencyDesc currencyDesc7 = currencyDesc2;
            if ((i & 4) != 0) {
                currencyDesc3 = currencies.sg;
            }
            CurrencyDesc currencyDesc8 = currencyDesc3;
            if ((i & 8) != 0) {
                currencyDesc4 = currencies.cn;
            }
            CurrencyDesc currencyDesc9 = currencyDesc4;
            if ((i & 16) != 0) {
                currencyDesc5 = currencies.hk;
            }
            CurrencyDesc currencyDesc10 = currencyDesc5;
            if ((i & 32) != 0) {
                currencyDesc6 = currencies.tmc;
            }
            return currencies.copy(currencyDesc, currencyDesc7, currencyDesc8, currencyDesc9, currencyDesc10, currencyDesc6);
        }

        public final CurrencyDesc component1() {
            return this.us;
        }

        public final CurrencyDesc component2() {
            return this.uk;
        }

        public final CurrencyDesc component3() {
            return this.sg;
        }

        public final CurrencyDesc component4() {
            return this.cn;
        }

        public final CurrencyDesc component5() {
            return this.hk;
        }

        public final CurrencyDesc component6() {
            return this.tmc;
        }

        public final Currencies copy(CurrencyDesc currencyDesc, CurrencyDesc currencyDesc2, CurrencyDesc currencyDesc3, CurrencyDesc currencyDesc4, CurrencyDesc currencyDesc5, CurrencyDesc currencyDesc6) {
            Intrinsics.checkNotNullParameter(currencyDesc, "us");
            Intrinsics.checkNotNullParameter(currencyDesc2, "uk");
            Intrinsics.checkNotNullParameter(currencyDesc3, "sg");
            Intrinsics.checkNotNullParameter(currencyDesc4, "cn");
            Intrinsics.checkNotNullParameter(currencyDesc5, "hk");
            Intrinsics.checkNotNullParameter(currencyDesc6, "tmc");
            return new Currencies(currencyDesc, currencyDesc2, currencyDesc3, currencyDesc4, currencyDesc5, currencyDesc6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Currencies)) {
                return false;
            }
            Currencies currencies = (Currencies) obj;
            return Intrinsics.areEqual(this.us, currencies.us) && Intrinsics.areEqual(this.uk, currencies.uk) && Intrinsics.areEqual(this.sg, currencies.sg) && Intrinsics.areEqual(this.cn, currencies.cn) && Intrinsics.areEqual(this.hk, currencies.hk) && Intrinsics.areEqual(this.tmc, currencies.tmc);
        }

        public int hashCode() {
            return (((((((((this.us.hashCode() * 31) + this.uk.hashCode()) * 31) + this.sg.hashCode()) * 31) + this.cn.hashCode()) * 31) + this.hk.hashCode()) * 31) + this.tmc.hashCode();
        }

        public String toString() {
            return "Currencies(us=" + this.us + ", uk=" + this.uk + ", sg=" + this.sg + ", cn=" + this.cn + ", hk=" + this.hk + ", tmc=" + this.tmc + ')';
        }

        public Currencies(CurrencyDesc currencyDesc, CurrencyDesc currencyDesc2, CurrencyDesc currencyDesc3, CurrencyDesc currencyDesc4, CurrencyDesc currencyDesc5, CurrencyDesc currencyDesc6) {
            Intrinsics.checkNotNullParameter(currencyDesc, "us");
            Intrinsics.checkNotNullParameter(currencyDesc2, "uk");
            Intrinsics.checkNotNullParameter(currencyDesc3, "sg");
            Intrinsics.checkNotNullParameter(currencyDesc4, "cn");
            Intrinsics.checkNotNullParameter(currencyDesc5, "hk");
            Intrinsics.checkNotNullParameter(currencyDesc6, "tmc");
            this.us = currencyDesc;
            this.uk = currencyDesc2;
            this.sg = currencyDesc3;
            this.cn = currencyDesc4;
            this.hk = currencyDesc5;
            this.tmc = currencyDesc6;
        }

        public final CurrencyDesc getUs() {
            return this.us;
        }

        public final void setUs(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.us = currencyDesc;
        }

        public final CurrencyDesc getUk() {
            return this.uk;
        }

        public final void setUk(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.uk = currencyDesc;
        }

        public final CurrencyDesc getSg() {
            return this.sg;
        }

        public final void setSg(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.sg = currencyDesc;
        }

        public final CurrencyDesc getCn() {
            return this.cn;
        }

        public final void setCn(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.cn = currencyDesc;
        }

        public final CurrencyDesc getHk() {
            return this.hk;
        }

        public final void setHk(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.hk = currencyDesc;
        }

        public final CurrencyDesc getTmc() {
            return this.tmc;
        }

        public final void setTmc(CurrencyDesc currencyDesc) {
            Intrinsics.checkNotNullParameter(currencyDesc, "<set-?>");
            this.tmc = currencyDesc;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "Ljava/io/Serializable;", "symbol", "", "minorUnit", "", "(Ljava/lang/String;I)V", "getMinorUnit", "()I", "setMinorUnit", "(I)V", "getSymbol", "()Ljava/lang/String;", "setSymbol", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigInfo.kt */
    public static final class CurrencyDesc implements Serializable {
        private int minorUnit;
        private String symbol;

        public static /* synthetic */ CurrencyDesc copy$default(CurrencyDesc currencyDesc, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = currencyDesc.symbol;
            }
            if ((i2 & 2) != 0) {
                i = currencyDesc.minorUnit;
            }
            return currencyDesc.copy(str, i);
        }

        public final String component1() {
            return this.symbol;
        }

        public final int component2() {
            return this.minorUnit;
        }

        public final CurrencyDesc copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "symbol");
            return new CurrencyDesc(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurrencyDesc)) {
                return false;
            }
            CurrencyDesc currencyDesc = (CurrencyDesc) obj;
            return Intrinsics.areEqual(this.symbol, currencyDesc.symbol) && this.minorUnit == currencyDesc.minorUnit;
        }

        public int hashCode() {
            return (this.symbol.hashCode() * 31) + this.minorUnit;
        }

        public String toString() {
            return "CurrencyDesc(symbol=" + this.symbol + ", minorUnit=" + this.minorUnit + ')';
        }

        public CurrencyDesc(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "symbol");
            this.symbol = str;
            this.minorUnit = i;
        }

        public final String getSymbol() {
            return this.symbol;
        }

        public final void setSymbol(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.symbol = str;
        }

        public final int getMinorUnit() {
            return this.minorUnit;
        }

        public final void setMinorUnit(int i) {
            this.minorUnit = i;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.common.imconfig.ConfigInfo");
        return Arrays.equals(this.international, ((ConfigInfo) obj).international);
    }

    public int hashCode() {
        return Arrays.hashCode(this.international);
    }
}
