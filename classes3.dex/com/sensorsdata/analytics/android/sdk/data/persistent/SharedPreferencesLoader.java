package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.util.SASpUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class SharedPreferencesLoader {
    private final Executor mExecutor = Executors.newSingleThreadExecutor();

    SharedPreferencesLoader() {
    }

    /* access modifiers changed from: package-private */
    public Future<SharedPreferences> loadPreferences(Context context, String str) {
        FutureTask futureTask = new FutureTask(new LoadSharedPreferences(context, str));
        this.mExecutor.execute(futureTask);
        return futureTask;
    }

    private static class LoadSharedPreferences implements Callable<SharedPreferences> {
        private final Context mContext;
        private final String mPrefsName;

        LoadSharedPreferences(Context context, String str) {
            this.mContext = context;
            this.mPrefsName = str;
        }

        public SharedPreferences call() {
            return SASpUtils.getSharedPreferences(this.mContext, this.mPrefsName, 0);
        }
    }
}
