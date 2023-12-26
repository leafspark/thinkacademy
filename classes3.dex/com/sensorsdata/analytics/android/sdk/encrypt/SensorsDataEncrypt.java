package com.sensorsdata.analytics.android.sdk.encrypt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataEncrypt {
    private static final int KEY_VERSION_DEFAULT = 0;
    private static final String SP_SECRET_KEY = "secret_key";
    private static final String TAG = "SensorsDataEncrypt";
    private Context mContext;
    private SAEncryptListener mEncryptListener;
    private List<SAEncryptListener> mListeners;
    private IPersistentSecretKey mPersistentSecretKey;
    private SecreteKey mSecreteKey;

    public SensorsDataEncrypt(Context context, IPersistentSecretKey iPersistentSecretKey, List<SAEncryptListener> list) {
        this.mPersistentSecretKey = iPersistentSecretKey;
        this.mContext = context;
        this.mListeners = list;
        list.add(new SARSAEncrypt());
        if (isECEncrypt()) {
            this.mListeners.add(new SAECEncrypt());
        }
    }

    public static boolean isECEncrypt() {
        try {
            Class.forName("org.spongycastle.jce.provider.BouncyCastleProvider");
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    public JSONObject encryptTrackData(JSONObject jSONObject) {
        try {
            if (isSecretKeyNull(this.mSecreteKey)) {
                SecreteKey loadSecretKey = loadSecretKey();
                this.mSecreteKey = loadSecretKey;
                if (isSecretKeyNull(loadSecretKey)) {
                    return jSONObject;
                }
            }
            if (!isMatchEncryptType(this.mEncryptListener, this.mSecreteKey)) {
                this.mEncryptListener = getEncryptListener(this.mSecreteKey);
            }
            if (this.mEncryptListener == null) {
                return jSONObject;
            }
            String str = this.mSecreteKey.key;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(":") + 1);
            }
            String encryptSymmetricKeyWithPublicKey = this.mEncryptListener.encryptSymmetricKeyWithPublicKey(str);
            if (TextUtils.isEmpty(encryptSymmetricKeyWithPublicKey)) {
                return jSONObject;
            }
            String encryptEvent = this.mEncryptListener.encryptEvent(gzipEventData(jSONObject.toString()));
            if (TextUtils.isEmpty(encryptEvent)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ekey", encryptSymmetricKeyWithPublicKey);
            jSONObject2.put("pkv", this.mSecreteKey.version);
            jSONObject2.put("payloads", encryptEvent);
            return jSONObject2;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return jSONObject;
        }
    }

    public void saveSecretKey(SecreteKey secreteKey) {
        try {
            SALog.i(TAG, "[saveSecretKey] publicKey = " + secreteKey.toString());
            if (getEncryptListener(secreteKey) != null) {
                IPersistentSecretKey iPersistentSecretKey = this.mPersistentSecretKey;
                if (iPersistentSecretKey != null) {
                    iPersistentSecretKey.saveSecretKey(secreteKey);
                    saveLocalSecretKey("");
                    return;
                }
                saveLocalSecretKey(secreteKey.toString());
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public boolean isPublicSecretKeyNull() {
        try {
            return TextUtils.isEmpty(loadSecretKey().key);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isMatchEncryptType(SAEncryptListener sAEncryptListener, SecreteKey secreteKey) {
        return sAEncryptListener != null && !isSecretKeyNull(secreteKey) && !isEncryptorTypeNull(sAEncryptListener) && sAEncryptListener.asymmetricEncryptType().equals(secreteKey.asymmetricEncryptType) && sAEncryptListener.symmetricEncryptType().equals(secreteKey.symmetricEncryptType);
    }

    public String checkPublicSecretKey(String str, String str2, String str3, String str4) {
        try {
            SecreteKey loadSecretKey = loadSecretKey();
            if (loadSecretKey == null) {
                return "密钥验证不通过，App 端密钥为空";
            }
            if (TextUtils.isEmpty(loadSecretKey.key)) {
                return "密钥验证不通过，App 端密钥为空";
            }
            if (!str.equals(loadSecretKey.version + "") || !disposeECPublicKey(str2).equals(disposeECPublicKey(loadSecretKey.key))) {
                return "密钥验证不通过，所选密钥与 App 端密钥不相同。所选密钥版本:" + str + "，App 端密钥版本:" + loadSecretKey.version;
            } else if (str3 == null || str4 == null) {
                return "密钥验证通过，所选密钥与 App 端密钥相同";
            } else {
                if (str3.equals(loadSecretKey.symmetricEncryptType) && str4.equals(loadSecretKey.asymmetricEncryptType)) {
                    return "密钥验证通过，所选密钥与 App 端密钥相同";
                }
                return "密钥验证不通过，所选密钥类型与 App 端密钥类型不相同。所选密钥对称算法类型:" + str3 + "，非对称算法类型:" + str4 + "，App 端密钥对称算法类型:" + loadSecretKey.symmetricEncryptType + "，非对称算法类型:" + loadSecretKey.asymmetricEncryptType;
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public String disposeECPublicKey(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith("EC:")) ? str : str.substring(str.indexOf(":") + 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[SYNTHETIC, Splitter:B:17:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a A[SYNTHETIC, Splitter:B:25:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] gzipEventData(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            r1.<init>()     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0022 }
            r2.write(r4)     // Catch:{ Exception -> 0x0022 }
            r2.finish()     // Catch:{ Exception -> 0x0022 }
            byte[] r4 = r1.toByteArray()     // Catch:{ Exception -> 0x0022 }
            r2.close()     // Catch:{ Exception -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0021:
            return r4
        L_0x0022:
            r4 = move-exception
            goto L_0x0028
        L_0x0024:
            r4 = move-exception
            goto L_0x0038
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0035
            r2.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x0035:
            return r0
        L_0x0036:
            r4 = move-exception
            r0 = r2
        L_0x0038:
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt.gzipEventData(java.lang.String):byte[]");
    }

    private void saveLocalSecretKey(String str) {
        SharedPreferences.Editor edit = SensorsDataUtils.getSharedPreferences(this.mContext).edit();
        edit.putString(SP_SECRET_KEY, str);
        edit.apply();
    }

    private SecreteKey loadSecretKey() throws JSONException {
        if (this.mPersistentSecretKey != null) {
            return readAppKey();
        }
        return readLocalKey();
    }

    private SecreteKey readAppKey() {
        String str;
        int i;
        String str2;
        SecreteKey loadSecretKey = this.mPersistentSecretKey.loadSecretKey();
        String str3 = null;
        if (loadSecretKey != null) {
            str3 = loadSecretKey.key;
            i = loadSecretKey.version;
            str = loadSecretKey.symmetricEncryptType;
            str2 = loadSecretKey.asymmetricEncryptType;
        } else {
            i = 0;
            str2 = null;
            str = null;
        }
        SALog.i(TAG, "readAppKey [key = " + str3 + " ,v = " + i + " ,symmetricEncryptType = " + str + " ,asymmetricEncryptType = " + str2 + "]");
        return new SecreteKey(str3, i, str, str2);
    }

    private SecreteKey readLocalKey() throws JSONException {
        String str;
        String str2;
        String string = SensorsDataUtils.getSharedPreferences(this.mContext).getString(SP_SECRET_KEY, "");
        int i = 0;
        String str3 = null;
        if (!TextUtils.isEmpty(string)) {
            JSONObject jSONObject = new JSONObject(string);
            str3 = jSONObject.optString("key", "");
            i = jSONObject.optInt("version", 0);
            str2 = jSONObject.optString("symmetricEncryptType", "");
            str = jSONObject.optString("asymmetricEncryptType", "");
        } else {
            str2 = null;
            str = null;
        }
        SALog.i(TAG, "readLocalKey [key = " + str3 + " ,v = " + i + " ,symmetricEncryptType = " + str2 + " ,asymmetricEncryptType = " + str + "]");
        return new SecreteKey(str3, i, str2, str);
    }

    private boolean isSecretKeyNull(SecreteKey secreteKey) {
        return secreteKey == null || TextUtils.isEmpty(secreteKey.key) || secreteKey.version == 0;
    }

    private boolean isEncryptorTypeNull(SAEncryptListener sAEncryptListener) {
        return TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) || TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType());
    }

    /* access modifiers changed from: package-private */
    public SAEncryptListener getEncryptListener(SecreteKey secreteKey) {
        if (isSecretKeyNull(secreteKey)) {
            return null;
        }
        for (SAEncryptListener next : this.mListeners) {
            if (next != null && isMatchEncryptType(next, secreteKey)) {
                return next;
            }
        }
        return null;
    }
}
