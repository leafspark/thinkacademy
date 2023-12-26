package com.kwai.koom.javaoom.monitor;

import android.content.SharedPreferences;
import com.kwai.koom.base.MonitorBuildConfig;
import com.kwai.koom.base.Monitor_SharedPreferencesKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u000f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\rJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMPreferenceManager;", "", "()V", "PREFERENCE_NAME", "", "mPreferences", "Landroid/content/SharedPreferences;", "getMPreferences", "()Landroid/content/SharedPreferences;", "mPreferences$delegate", "Lkotlin/Lazy;", "mPrefix", "mSharedPreferencesInvoker", "Lkotlin/Function1;", "clearUnusedPreference", "", "preferences", "editor", "Landroid/content/SharedPreferences$Editor;", "getAnalysisTimes", "", "getFirstLaunchTime", "", "increaseAnalysisTimes", "init", "sharedPreferencesInvoker", "setFirstLaunchTime", "time", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMPreferenceManager.kt */
public final class OOMPreferenceManager {
    public static final OOMPreferenceManager INSTANCE = new OOMPreferenceManager();
    private static final String PREFERENCE_NAME = "koom_hprof_analysis";
    private static final Lazy mPreferences$delegate = LazyKt.lazy(OOMPreferenceManager$mPreferences$2.INSTANCE);
    private static String mPrefix;
    /* access modifiers changed from: private */
    public static Function1<? super String, ? extends SharedPreferences> mSharedPreferencesInvoker;

    private OOMPreferenceManager() {
    }

    private final SharedPreferences getMPreferences() {
        return (SharedPreferences) mPreferences$delegate.getValue();
    }

    public final void init(Function1<? super String, ? extends SharedPreferences> function1) {
        Intrinsics.checkNotNullParameter(function1, "sharedPreferencesInvoker");
        mSharedPreferencesInvoker = function1;
        mPrefix = Intrinsics.stringPlus(MonitorBuildConfig.getVERSION_NAME(), "_");
    }

    public final int getAnalysisTimes() {
        SharedPreferences mPreferences = getMPreferences();
        String str = mPrefix;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        return mPreferences.getInt(Intrinsics.stringPlus(str, "times"), 0);
    }

    public final void increaseAnalysisTimes() {
        SharedPreferences.Editor edit = getMPreferences().edit();
        OOMPreferenceManager oOMPreferenceManager = INSTANCE;
        SharedPreferences mPreferences = oOMPreferenceManager.getMPreferences();
        Intrinsics.checkNotNullExpressionValue(edit, "it");
        oOMPreferenceManager.clearUnusedPreference(mPreferences, edit);
        String str = mPrefix;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        String stringPlus = Intrinsics.stringPlus(str, "times");
        SharedPreferences mPreferences2 = getMPreferences();
        String str3 = mPrefix;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
        } else {
            str2 = str3;
        }
        edit.putInt(stringPlus, mPreferences2.getInt(Intrinsics.stringPlus(str2, "times"), 0) + 1).apply();
    }

    public final long getFirstLaunchTime() {
        SharedPreferences mPreferences = getMPreferences();
        String str = mPrefix;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        long j = mPreferences.getLong(Intrinsics.stringPlus(str, "first_analysis_time"), 0);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        setFirstLaunchTime(currentTimeMillis);
        return currentTimeMillis;
    }

    public final void setFirstLaunchTime(long j) {
        SharedPreferences mPreferences = getMPreferences();
        String str = mPrefix;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        if (!mPreferences.contains(Intrinsics.stringPlus(str, "first_analysis_time"))) {
            SharedPreferences.Editor edit = getMPreferences().edit();
            String str3 = mPrefix;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            } else {
                str2 = str3;
            }
            edit.putLong(Intrinsics.stringPlus(str2, "first_analysis_time"), j).apply();
        }
    }

    private final void clearUnusedPreference(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        for (String next : Monitor_SharedPreferencesKt.getAllKeys(sharedPreferences)) {
            String str = mPrefix;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
                str = null;
            }
            if (!StringsKt.startsWith$default(next, str, false, 2, (Object) null)) {
                editor.remove(next);
            }
        }
    }
}
