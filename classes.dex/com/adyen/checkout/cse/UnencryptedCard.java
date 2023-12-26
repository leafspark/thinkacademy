package com.adyen.checkout.cse;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class UnencryptedCard {
    private final String mCardHolderName;
    private final String mCvc;
    private final String mExpiryMonth;
    private final String mExpiryYear;
    private final Date mGenerationTime;
    private final String mNumber;

    public UnencryptedCard(String str, String str2, String str3, String str4, String str5, Date date) {
        this.mNumber = str;
        this.mExpiryMonth = str2;
        this.mExpiryYear = str3;
        this.mCvc = str4;
        this.mCardHolderName = str5;
        this.mGenerationTime = date;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public String getExpiryMonth() {
        return this.mExpiryMonth;
    }

    public String getExpiryYear() {
        return this.mExpiryYear;
    }

    public String getCvc() {
        return this.mCvc;
    }

    public String getCardHolderName() {
        return this.mCardHolderName;
    }

    public Date getGenerationTime() {
        return this.mGenerationTime;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mGenerationTime != null) {
                jSONObject.put("generationtime", CardEncrypter.GENERATION_DATE_FORMAT.format(this.mGenerationTime));
            }
            String str = this.mNumber;
            if (str != null) {
                jSONObject.put("number", str.substring(0, 3));
            }
            jSONObject.putOpt("holderName", this.mCardHolderName);
            return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException("UnencryptedCard toString() failed.", e);
        }
    }

    public static final class Builder {
        private String mCardHolderName;
        private String mCvc;
        private String mExpiryMonth;
        private String mExpiryYear;
        private Date mGenerationTime;
        private String mNumber;

        public Builder setNumber(String str) {
            this.mNumber = removeWhiteSpaces(str);
            return this;
        }

        public Builder setExpiryMonth(String str) {
            this.mExpiryMonth = removeWhiteSpaces(str);
            return this;
        }

        public Builder setExpiryYear(String str) {
            this.mExpiryYear = removeWhiteSpaces(str);
            return this;
        }

        public Builder setCvc(String str) {
            this.mCvc = removeWhiteSpaces(str);
            return this;
        }

        public Builder setHolderName(String str) {
            this.mCardHolderName = trimAndRemoveMultipleWhiteSpaces(str);
            return this;
        }

        public Builder setGenerationTime(Date date) {
            this.mGenerationTime = date;
            return this;
        }

        public UnencryptedCard build() throws NullPointerException, IllegalStateException {
            return new UnencryptedCard(this.mNumber, this.mExpiryMonth, this.mExpiryYear, this.mCvc, this.mCardHolderName, this.mGenerationTime);
        }

        private String removeWhiteSpaces(String str) {
            if (str != null) {
                return str.replaceAll("\\s", "");
            }
            return null;
        }

        private String trimAndRemoveMultipleWhiteSpaces(String str) {
            if (str != null) {
                return str.trim().replaceAll("\\s{2,}", " ");
            }
            return null;
        }
    }
}
