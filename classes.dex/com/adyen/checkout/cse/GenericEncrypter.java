package com.adyen.checkout.cse;

import com.adyen.checkout.cse.exception.EncryptionException;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0014\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/adyen/checkout/cse/GenericEncrypter;", "", "()V", "ENCRYPTION_FAILED_MESSAGE", "", "GENERATION_DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "KCP_PASSWORD_KEY", "assureGenerationTime", "Ljava/util/Date;", "generationTime", "encryptField", "encryptionKey", "fieldToEncrypt", "publicKey", "makeGenerationTime", "cse_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GenericEncrypter.kt */
public final class GenericEncrypter {
    private static final String ENCRYPTION_FAILED_MESSAGE = "Encryption failed.";
    private static final SimpleDateFormat GENERATION_DATE_FORMAT;
    public static final GenericEncrypter INSTANCE = new GenericEncrypter();
    public static final String KCP_PASSWORD_KEY = "password";

    private GenericEncrypter() {
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        GENERATION_DATE_FORMAT = simpleDateFormat;
    }

    @JvmStatic
    public static final String encryptField(String str, Object obj, String str2) {
        Intrinsics.checkNotNullParameter(str, "encryptionKey");
        Intrinsics.checkNotNullParameter(obj, "fieldToEncrypt");
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        ClientSideEncrypter clientSideEncrypter = new ClientSideEncrypter(str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, obj);
            jSONObject.put("generationtime", makeGenerationTime$default((Date) null, 1, (Object) null));
            String encrypt = clientSideEncrypter.encrypt(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            Intrinsics.checkNotNullExpressionValue(encrypt, "{\n            val jsonToEncrypt = JSONObject()\n            jsonToEncrypt.put(encryptionKey, fieldToEncrypt)\n            jsonToEncrypt.put(CardEncrypter.GENERATION_TIME_KEY, makeGenerationTime())\n            encrypter.encrypt(jsonToEncrypt.toString())\n        }");
            return encrypt;
        } catch (JSONException e) {
            throw new EncryptionException(ENCRYPTION_FAILED_MESSAGE, e);
        }
    }

    public static /* synthetic */ String makeGenerationTime$default(Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            date = null;
        }
        return makeGenerationTime(date);
    }

    @JvmStatic
    public static final String makeGenerationTime(Date date) {
        String format = GENERATION_DATE_FORMAT.format(INSTANCE.assureGenerationTime(date));
        Intrinsics.checkNotNullExpressionValue(format, "GENERATION_DATE_FORMAT.format(assureGenerationTime(generationTime))");
        return format;
    }

    private final Date assureGenerationTime(Date date) {
        return date == null ? new Date() : date;
    }
}
