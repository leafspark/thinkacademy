package com.tal.app.thinkacademy.common.util;

import android.content.Context;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/HwLanguageUtil;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "mCurrentHwLanguageInfo", "Lcom/tal/app/thinkacademy/common/util/HwLanguageUtil$HwLanguageInfo;", "mLanguageList", "", "mLanguageMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "changeLanguage", "", "context", "Landroid/content/Context;", "hwLanguageInfo", "getCnCountry", "country", "", "getCurrentLanguage", "getCurrentLanguageIndex", "getEnCountry", "getHwLanguageInfo", "language", "getSupportLanguageIndex", "getSupportLanguageList", "getTranslateLanguage", "initAppLanguage", "initLanguageList", "updateConfig", "HwLanguageInfo", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwLanguageUtil.kt */
public final class HwLanguageUtil {
    public static final HwLanguageUtil INSTANCE = new HwLanguageUtil();
    private static final Tag TAG = Tag.LANGUAGE;
    private static HwLanguageInfo mCurrentHwLanguageInfo = HwLanguageInfo.ENGLISH;
    private static final List<HwLanguageInfo> mLanguageList = new ArrayList();
    private static HashMap<HwLanguageInfo, Integer> mLanguageMap = new HashMap<>();

    private HwLanguageUtil() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/HwLanguageUtil$HwLanguageInfo;", "", "nameDesc", "", "language", "country", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getLanguage", "getNameDesc", "ENGLISH", "CHINESE", "CHINESE_HK", "ENGLISH_UK", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwLanguageUtil.kt */
    public enum HwLanguageInfo {
        ENGLISH("English", LanguageUtil.EN, LanguageUtil.COUNTRY_USA),
        CHINESE("简体中文", LanguageUtil.ZH, LanguageUtil.COUNTRY_CN),
        CHINESE_HK("繁體中文", LanguageUtil.ZH, LanguageUtil.COUNTRY_HK),
        ENGLISH_UK("English (United Kingdom)", LanguageUtil.EN, LanguageUtil.COUNTRY_UK);
        
        private final String country;
        private final String language;
        private final String nameDesc;

        private HwLanguageInfo(String str, String str2, String str3) {
            this.nameDesc = str;
            this.language = str2;
            this.country = str3;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getNameDesc() {
            return this.nameDesc;
        }
    }

    public final void initAppLanguage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initLanguageList();
        updateConfig(context);
    }

    public final void updateConfig(Context context) {
        HwLanguageInfo hwLanguageInfo;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = ShareDataManager.getInstance().getBoolean(ShareDataKey.IS_USER_HAS_SELECT_LANGUAGE, false, ShareDataManager.SHAREDATA_NOT_CLEAR);
        HwLanguageInfo hwLanguageInfo2 = HwLanguageInfo.ENGLISH;
        if (z) {
            String string = ShareDataManager.getInstance().getString(ShareDataKey.LOCALE_LANGUAGE, LanguageUtil.EN, ShareDataManager.SHAREDATA_NOT_CLEAR);
            String string2 = ShareDataManager.getInstance().getString(ShareDataKey.LOCALE_COUNTRY, LanguageUtil.COUNTRY_USA, ShareDataManager.SHAREDATA_NOT_CLEAR);
            String translateLanguage = getTranslateLanguage(string);
            hwLanguageInfo = getHwLanguageInfo(translateLanguage, string2);
            XesLog.s(TAG, "用户已经手动选择过语言，最终选择：语言=" + translateLanguage + ",国家码=" + hwLanguageInfo.getCountry());
        } else {
            Locale appLocale = LanguageUtil.getAppLocale(context);
            if (appLocale == null) {
                unit = null;
            } else {
                XesLog.i(TAG, "跟随系统，系统语言=" + appLocale.getLanguage() + ",国家码=" + appLocale.getCountry());
                HwLanguageUtil hwLanguageUtil = INSTANCE;
                hwLanguageInfo2 = hwLanguageUtil.getHwLanguageInfo(hwLanguageUtil.getTranslateLanguage(appLocale.getLanguage()), appLocale.getCountry());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                HwLanguageUtil hwLanguageUtil2 = this;
                XesLog.i(TAG, "跟随系统，获取系统语言出错");
                hwLanguageInfo = HwLanguageInfo.ENGLISH;
            } else {
                hwLanguageInfo = hwLanguageInfo2;
            }
            XesLog.i(TAG, "跟随系统语言，最终选择：语言=" + hwLanguageInfo.getLanguage() + ",国家码=" + hwLanguageInfo.getCountry());
        }
        mCurrentHwLanguageInfo = hwLanguageInfo;
        LanguageUtil.saveLanguageSetting(hwLanguageInfo.getLanguage(), hwLanguageInfo.getCountry());
    }

    private final void initLanguageList() {
        HwLanguageInfo[] values = HwLanguageInfo.values();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            HwLanguageInfo hwLanguageInfo = values[i];
            mLanguageList.add(hwLanguageInfo);
            mLanguageMap.put(hwLanguageInfo, Integer.valueOf(i2));
            i++;
            i2++;
        }
    }

    public final List<HwLanguageInfo> getSupportLanguageList() {
        return mLanguageList;
    }

    private final int getSupportLanguageIndex(HwLanguageInfo hwLanguageInfo) {
        Integer num = mLanguageMap.get(hwLanguageInfo);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getCurrentLanguageIndex() {
        return getSupportLanguageIndex(mCurrentHwLanguageInfo);
    }

    public final HwLanguageInfo getCurrentLanguage() {
        return mCurrentHwLanguageInfo;
    }

    private final String getTranslateLanguage(String str) {
        return (!Intrinsics.areEqual(str, LanguageUtil.EN) && Intrinsics.areEqual(str, LanguageUtil.ZH)) ? LanguageUtil.ZH : LanguageUtil.EN;
    }

    private final HwLanguageInfo getHwLanguageInfo(String str, String str2) {
        if (Intrinsics.areEqual(str, LanguageUtil.ZH)) {
            return getCnCountry(str2);
        }
        return getEnCountry(str2);
    }

    private final HwLanguageInfo getCnCountry(String str) {
        int hashCode;
        if (str == null || ((hashCode = str.hashCode()) == 2307 ? !str.equals(LanguageUtil.COUNTRY_HK) : !(hashCode == 2466 ? str.equals(LanguageUtil.COUNTRY_MO) : hashCode == 2691 && str.equals(LanguageUtil.COUNTRY_TW)))) {
            return HwLanguageInfo.CHINESE;
        }
        return HwLanguageInfo.CHINESE_HK;
    }

    private final HwLanguageInfo getEnCountry(String str) {
        CharSequence charSequence = str;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            return HwLanguageInfo.ENGLISH;
        }
        if (!Intrinsics.areEqual(str, LanguageUtil.COUNTRY_UK)) {
            z = Intrinsics.areEqual(str, LanguageUtil.COUNTRY_SINGAPORE);
        }
        if (z) {
            return HwLanguageInfo.ENGLISH_UK;
        }
        return HwLanguageInfo.ENGLISH;
    }

    public final void changeLanguage(Context context, HwLanguageInfo hwLanguageInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hwLanguageInfo, "hwLanguageInfo");
        mCurrentHwLanguageInfo = hwLanguageInfo;
        XesLog.i(TAG, "开始切换语言，当前语言为=" + hwLanguageInfo.getLanguage() + ",国家=" + hwLanguageInfo.getCountry());
        ShareDataManager.getInstance().put(ShareDataKey.IS_USER_HAS_SELECT_LANGUAGE, true, ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().put(ShareDataKey.LOCALE_LANGUAGE, mCurrentHwLanguageInfo.getLanguage(), ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().put(ShareDataKey.LOCALE_COUNTRY, mCurrentHwLanguageInfo.getCountry(), ShareDataManager.SHAREDATA_NOT_CLEAR);
        LanguageUtil.changeLanguage(context, hwLanguageInfo.getLanguage(), hwLanguageInfo.getCountry());
    }
}
