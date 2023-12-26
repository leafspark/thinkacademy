package com.tal.app.thinkacademy.common.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.ChosenSchoolBean;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.ActivityUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/ChooseSchoolUtil;", "", "()V", "changeSchool", "", "schoolCode", "", "context", "Landroid/content/Context;", "finishAllActivitiesToMain", "getChosenSchoolBean", "Lcom/tal/app/thinkacademy/common/entity/ChosenSchoolBean;", "getChosenSchoolCountry", "", "code", "getChosenSchoolLanguage", "updateSchoolInfo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseSchoolUtil.kt */
public final class ChooseSchoolUtil {
    public static final ChooseSchoolUtil INSTANCE = new ChooseSchoolUtil();

    private ChooseSchoolUtil() {
    }

    public final ChosenSchoolBean getChosenSchoolBean(int i) {
        Unit unit;
        Object cacheEntity = ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, ShareDataKey.CURRENT_SCHOOL_INFO, ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (cacheEntity == null) {
            cacheEntity = new ChosenSchoolBean();
        }
        SchoolDataInfo schoolInfo = SchoolConstants.INSTANCE.getSchoolInfo(i);
        if (schoolInfo == null) {
            unit = null;
        } else {
            ChosenSchoolBean chosenSchoolBean = (ChosenSchoolBean) cacheEntity;
            chosenSchoolBean.schoolCode = ParseUtils.tryParseInt(schoolInfo.getSchoolCode(), 0);
            chosenSchoolBean.countryName = schoolInfo.getSchoolName();
            chosenSchoolBean.countryCallingCode = schoolInfo.getSchoolCountryCode();
            chosenSchoolBean.phoneMaxLength = 99;
            chosenSchoolBean.phoneMinLength = 1;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ChooseSchoolUtil chooseSchoolUtil = this;
            ChosenSchoolBean chosenSchoolBean2 = (ChosenSchoolBean) cacheEntity;
            chosenSchoolBean2.schoolCode = SchoolConstants.SCHOOL_MARS;
            chosenSchoolBean2.countryName = "Mars";
            chosenSchoolBean2.countryCallingCode = "86";
            chosenSchoolBean2.phoneMaxLength = 11;
            chosenSchoolBean2.phoneMinLength = 11;
        }
        return (ChosenSchoolBean) cacheEntity;
    }

    public final String getChosenSchoolCountry(int i) {
        String schoolISOStandardlanguageCode;
        SchoolDataInfo schoolInfo = SchoolConstants.INSTANCE.getSchoolInfo(i);
        if (schoolInfo == null || (schoolISOStandardlanguageCode = schoolInfo.getSchoolISOStandardlanguageCode()) == null) {
            ChooseSchoolUtil chooseSchoolUtil = this;
            return LanguageUtil.COUNTRY_UK;
        } else if (StringsKt.contains$default(schoolISOStandardlanguageCode, "-", false, 2, (Object) null)) {
            return StringsKt.substringAfter$default(schoolISOStandardlanguageCode, "-", (String) null, 2, (Object) null);
        } else {
            return LanguageUtil.COUNTRY_UK;
        }
    }

    public final String getChosenSchoolLanguage(int i) {
        String schoolISOStandardlanguageCode;
        SchoolDataInfo schoolInfo = SchoolConstants.INSTANCE.getSchoolInfo(i);
        if (schoolInfo == null || (schoolISOStandardlanguageCode = schoolInfo.getSchoolISOStandardlanguageCode()) == null) {
            ChooseSchoolUtil chooseSchoolUtil = this;
            return LanguageUtil.EN;
        } else if (StringsKt.contains$default(schoolISOStandardlanguageCode, "-", false, 2, (Object) null)) {
            return StringsKt.substringBefore$default(schoolISOStandardlanguageCode, "-", (String) null, 2, (Object) null);
        } else {
            return LanguageUtil.EN;
        }
    }

    public final void finishAllActivitiesToMain() {
        XesActivityManager.Companion.getInstance().clearFrontBackCallback();
        ActivityUtils.finishAllActivities();
        new Handler(Looper.getMainLooper()).postDelayed(ChooseSchoolUtil$$ExternalSyntheticLambda0.INSTANCE, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: finishAllActivitiesToMain$lambda-6  reason: not valid java name */
    public static final void m59finishAllActivitiesToMain$lambda6() {
        XesRoute.getInstance().navigation(RouteMap.ROUTE_MAIN_ACTIVITY);
    }

    public final void updateSchoolInfo(int i) {
        ShareDataManager.getInstance().put("school_code", String.valueOf(i), ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().saveCacheGsonEntity(getChosenSchoolBean(i), ShareDataKey.CURRENT_SCHOOL_INFO, ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    public final void changeSchool(int i, Context context) {
        finishAllActivitiesToMain();
    }
}
