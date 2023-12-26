package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class PersistentIdentity<T> {
    private static final String TAG = "SA.PersistentIdentity";
    private T item;
    private final Future<SharedPreferences> loadStoredPreferences;
    private final String persistentKey;
    private final PersistentSerializer serializer;

    interface PersistentSerializer<T> {
        T create();

        T load(String str);

        String save(T t);
    }

    PersistentIdentity(Future<SharedPreferences> future, String str, PersistentSerializer<T> persistentSerializer) {
        this.loadStoredPreferences = future;
        this.serializer = persistentSerializer;
        this.persistentKey = str;
    }

    public T get() {
        if (this.item == null) {
            synchronized (this.loadStoredPreferences) {
                String str = null;
                try {
                    SharedPreferences sharedPreferences = this.loadStoredPreferences.get();
                    if (sharedPreferences != null) {
                        str = sharedPreferences.getString(this.persistentKey, (String) null);
                    }
                } catch (ExecutionException e) {
                    SALog.d(TAG, "Cannot read distinct ids from sharedPreferences.", e.getCause());
                } catch (InterruptedException e2) {
                    SALog.d(TAG, "Cannot read distinct ids from sharedPreferences.", e2);
                }
                if (str == null) {
                    T create = this.serializer.create();
                    this.item = create;
                    commit(create);
                } else {
                    this.item = this.serializer.load(str);
                }
            }
        }
        return this.item;
    }

    public void commit(T t) {
        if (!SensorsDataAPI.getConfigOptions().isDisableSDK()) {
            this.item = t;
            synchronized (this.loadStoredPreferences) {
                SharedPreferences sharedPreferences = null;
                try {
                    sharedPreferences = this.loadStoredPreferences.get();
                } catch (ExecutionException e) {
                    SALog.d(TAG, "Cannot read distinct ids from sharedPreferences.", e.getCause());
                } catch (InterruptedException e2) {
                    SALog.d(TAG, "Cannot read distinct ids from sharedPreferences.", e2);
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (this.item == null) {
                        this.item = this.serializer.create();
                    }
                    edit.putString(this.persistentKey, this.serializer.save(this.item));
                    edit.apply();
                }
            }
        }
    }
}
