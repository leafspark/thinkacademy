package com.sensorsdata.analytics.android.sdk.remote;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

public class SensorsDataRemoteManager extends BaseSensorsDataSDKRemoteManager {
    private static final String SHARED_PREF_REQUEST_TIME = "sensorsdata.request.time";
    private static final String SHARED_PREF_REQUEST_TIME_RANDOM = "sensorsdata.request.time.random";
    private static final String TAG = "SA.SensorsDataRemoteManager";
    private CountDownTimer mPullSDKConfigCountDownTimer;
    private SharedPreferences mSharedPreferences;

    public SensorsDataRemoteManager(SensorsDataAPI sensorsDataAPI) {
        super(sensorsDataAPI);
        SALog.i(TAG, "Construct a SensorsDataRemoteManager");
    }

    private boolean isRequestValid() {
        try {
            long j = getSharedPreferences().getLong(SHARED_PREF_REQUEST_TIME, 0);
            int i = getSharedPreferences().getInt(SHARED_PREF_REQUEST_TIME_RANDOM, 0);
            if (j == 0 || i == 0) {
                return true;
            }
            float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - j);
            if (elapsedRealtime <= 0.0f || elapsedRealtime / 1000.0f >= ((float) (i * 3600))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return true;
        }
    }

    private void writeRemoteRequestRandomTime() {
        if (this.mSAConfigOptions != null) {
            int i = this.mSAConfigOptions.mMinRequestInterval;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mSAConfigOptions.mMaxRequestInterval > this.mSAConfigOptions.mMinRequestInterval) {
                i += new SecureRandom().nextInt((this.mSAConfigOptions.mMaxRequestInterval - this.mSAConfigOptions.mMinRequestInterval) + 1);
            }
            getSharedPreferences().edit().putLong(SHARED_PREF_REQUEST_TIME, elapsedRealtime).putInt(SHARED_PREF_REQUEST_TIME_RANDOM, i).apply();
        }
    }

    private void cleanRemoteRequestRandomTime() {
        getSharedPreferences().edit().putLong(SHARED_PREF_REQUEST_TIME, 0).putInt(SHARED_PREF_REQUEST_TIME_RANDOM, 0).apply();
    }

    public void pullSDKConfigFromServer() {
        if (this.mSAConfigOptions != null) {
            if (this.mSAConfigOptions.mDisableRandomTimeRequestRemoteConfig || this.mSAConfigOptions.mMinRequestInterval > this.mSAConfigOptions.mMaxRequestInterval) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean, true);
                SALog.i(TAG, "remote config: Request remote config because disableRandomTimeRequestRemoteConfig or minHourInterval greater than maxHourInterval");
            } else if (this.mSensorsDataEncrypt != null && this.mSensorsDataEncrypt.isPublicSecretKeyNull()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                SALog.i(TAG, "remote config: Request remote config because encrypt key is null");
            } else if (isRequestValid()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, true);
                SALog.i(TAG, "remote config: Request remote config because satisfy the random request condition");
            }
        }
    }

    public void requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z) {
        if (this.mSensorsDataAPI != null && !this.mSensorsDataAPI.isNetworkRequestEnable()) {
            SALog.i(TAG, "Close network request");
        } else if (this.mDisableDefaultRemoteConfig) {
            SALog.i(TAG, "disableDefaultRemoteConfig is true");
        } else {
            int i = AnonymousClass2.$SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType[randomTimeType.ordinal()];
            if (i == 1) {
                writeRemoteRequestRandomTime();
            } else if (i == 2) {
                cleanRemoteRequestRandomTime();
            }
            CountDownTimer countDownTimer = this.mPullSDKConfigCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mPullSDKConfigCountDownTimer = null;
            }
            final boolean z2 = z;
            AnonymousClass1 r0 = new CountDownTimer(90000, 30000) {
                public void onFinish() {
                }

                public void onTick(long j) {
                    SensorsDataRemoteManager.this.requestRemoteConfig(z2, (HttpCallback.StringCallback) new HttpCallback.StringCallback() {
                        public void onAfter() {
                        }

                        public void onFailure(int i, String str) {
                            if (i == 304 || i == 404) {
                                SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request failed,responseCode is " + i + ",errorMessage is " + str);
                        }

                        public void onResponse(String str) {
                            SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            if (!TextUtils.isEmpty(str)) {
                                SensorsDataSDKRemoteConfig sDKRemoteConfig = SensorsDataRemoteManager.this.toSDKRemoteConfig(str);
                                try {
                                    if (SensorsDataRemoteManager.this.mSensorsDataEncrypt != null) {
                                        SensorsDataRemoteManager.this.mSensorsDataEncrypt.saveSecretKey(sDKRemoteConfig.getSecretKey());
                                    }
                                } catch (Exception e) {
                                    SALog.printStackTrace(e);
                                }
                                SensorsDataRemoteManager.this.setSDKRemoteConfig(sDKRemoteConfig);
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request was successful,response data is " + str);
                        }
                    });
                }
            };
            this.mPullSDKConfigCountDownTimer = r0;
            r0.start();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType[] r0 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType = r0
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass2.<clinit>():void");
        }
    }

    public void resetPullSDKConfigTimer() {
        try {
            CountDownTimer countDownTimer = this.mPullSDKConfigCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        } catch (Throwable th) {
            this.mPullSDKConfigCountDownTimer = null;
            throw th;
        }
        this.mPullSDKConfigCountDownTimer = null;
    }

    /* access modifiers changed from: protected */
    public void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            String jSONObject2 = sensorsDataSDKRemoteConfig.toJson().toString();
            jSONObject.put("$app_remote_config", jSONObject2);
            SensorsDataAPI.sharedInstance().trackInternal("$AppRemoteConfigChanged", jSONObject);
            SensorsDataAPI.sharedInstance().flush();
            DbAdapter.getInstance().commitRemoteConfig(jSONObject2);
            SALog.i(TAG, "Save remote data");
            if (1 == sensorsDataSDKRemoteConfig.getEffectMode()) {
                applySDKConfigFromCache();
                SALog.i(TAG, "The remote configuration takes effect immediately");
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void applySDKConfigFromCache() {
        try {
            SensorsDataSDKRemoteConfig sDKRemoteConfig = toSDKRemoteConfig(DbAdapter.getInstance().getRemoteConfig());
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "Cache remote config is " + sDKRemoteConfig.toString());
            }
            if (this.mSensorsDataAPI != null) {
                if (sDKRemoteConfig.isDisableDebugMode()) {
                    this.mSensorsDataAPI.setDebugMode(SensorsDataAPI.DebugMode.DEBUG_OFF);
                    SALog.i(TAG, "Set DebugOff Mode");
                }
                if (sDKRemoteConfig.isDisableSDK()) {
                    try {
                        this.mSensorsDataAPI.flush();
                        SALog.i(TAG, "DisableSDK is true");
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            }
            mSDKRemoteConfig = sDKRemoteConfig;
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = SensorsDataUtils.getSharedPreferences(this.mContext);
        }
        return this.mSharedPreferences;
    }
}
