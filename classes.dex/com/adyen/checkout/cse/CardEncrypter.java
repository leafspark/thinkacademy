package com.adyen.checkout.cse;

import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.cse.exception.EncryptionException;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardEncrypter {
    private static final String BIN_KEY = "binValue";
    private static final String CARD_NUMBER_KEY = "number";
    private static final String CVC_KEY = "cvc";
    private static final String EXPIRY_MONTH_KEY = "expiryMonth";
    private static final String EXPIRY_YEAR_KEY = "expiryYear";
    static final SimpleDateFormat GENERATION_DATE_FORMAT;
    static final String GENERATION_TIME_KEY = "generationtime";
    private static final String HOLDER_NAME_KEY = "holderName";

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        GENERATION_DATE_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private CardEncrypter() {
        throw new NoConstructorException();
    }

    public static EncryptedCard encryptFields(UnencryptedCard unencryptedCard, String str) throws EncryptionException {
        String str2;
        String str3;
        try {
            String str4 = null;
            String encryptField = unencryptedCard.getNumber() != null ? GenericEncrypter.encryptField(CARD_NUMBER_KEY, unencryptedCard.getNumber(), str) : null;
            if (unencryptedCard.getExpiryMonth() != null && unencryptedCard.getExpiryYear() != null) {
                str3 = GenericEncrypter.encryptField(EXPIRY_MONTH_KEY, unencryptedCard.getExpiryMonth(), str);
                str2 = GenericEncrypter.encryptField(EXPIRY_YEAR_KEY, unencryptedCard.getExpiryYear(), str);
            } else if (unencryptedCard.getExpiryMonth() == null && unencryptedCard.getExpiryYear() == null) {
                str3 = null;
                str2 = null;
            } else {
                throw new EncryptionException("Both expiryMonth and expiryYear need to be set for encryption.", (Throwable) null);
            }
            if (unencryptedCard.getCvc() != null) {
                str4 = GenericEncrypter.encryptField(CVC_KEY, unencryptedCard.getCvc(), str);
            }
            return new EncryptedCard(encryptField, str3, str2, str4);
        } catch (EncryptionException | IllegalStateException e) {
            throw new EncryptionException(e.getMessage() == null ? "No message." : e.getMessage(), e);
        }
    }

    public static String encrypt(UnencryptedCard unencryptedCard, String str) throws EncryptionException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CARD_NUMBER_KEY, unencryptedCard.getNumber());
            jSONObject.put(EXPIRY_MONTH_KEY, unencryptedCard.getExpiryMonth());
            jSONObject.put(EXPIRY_YEAR_KEY, unencryptedCard.getExpiryYear());
            jSONObject.put(CVC_KEY, unencryptedCard.getCvc());
            jSONObject.put(HOLDER_NAME_KEY, unencryptedCard.getCardHolderName());
            jSONObject.put(GENERATION_TIME_KEY, GenericEncrypter.makeGenerationTime(unencryptedCard.getGenerationTime()));
            return new ClientSideEncrypter(str).encrypt(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        } catch (JSONException e) {
            throw new EncryptionException("Failed to created encrypted JSON data.", e);
        }
    }

    public static String encryptBin(String str, String str2) throws EncryptionException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BIN_KEY, str);
            jSONObject.put(GENERATION_TIME_KEY, GenericEncrypter.makeGenerationTime(new Date()));
            return new ClientSideEncrypter(str2).encrypt(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        } catch (JSONException e) {
            throw new EncryptionException("Failed to created encrypted JSON data.", e);
        }
    }
}
