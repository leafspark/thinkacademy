package com.eaydu.omni.jwt;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.eaydu.omni.gson.Gson;
import com.eaydu.omni.gson.GsonBuilder;
import com.eaydu.omni.gson.reflect.TypeToken;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JWT implements Parcelable {
    public static final Parcelable.Creator<JWT> CREATOR = new Parcelable.Creator<JWT>() {
        public JWT createFromParcel(Parcel parcel) {
            return new JWT(parcel.readString());
        }

        public JWT[] newArray(int i) {
            return new JWT[i];
        }
    };
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String TAG = "JWT";
    private Map<String, String> header;
    private JWTPayload payload;
    private String signature;
    private final String token;

    public int describeContents() {
        return 0;
    }

    public JWT(String str) {
        decode(str);
        this.token = str;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getIssuer() {
        return this.payload.iss;
    }

    public String getSubject() {
        return this.payload.sub;
    }

    public List<String> getAudience() {
        return this.payload.aud;
    }

    public Date getExpiresAt() {
        return this.payload.exp;
    }

    public Date getNotBefore() {
        return this.payload.nbf;
    }

    public Date getIssuedAt() {
        return this.payload.iat;
    }

    public String getId() {
        return this.payload.jti;
    }

    public Claim getClaim(String str) {
        return this.payload.claimForName(str);
    }

    public Map<String, Claim> getClaims() {
        return this.payload.tree;
    }

    public boolean isExpired(long j) {
        if (j >= 0) {
            long floor = (long) (Math.floor((double) (new Date().getTime() / 1000)) * 1000.0d);
            long j2 = j * 1000;
            Date date = new Date(floor + j2);
            boolean z = this.payload.exp == null || !new Date(floor - j2).after(this.payload.exp);
            boolean z2 = this.payload.iat == null || !date.before(this.payload.iat);
            if (!z || !z2) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The leeway must be a positive value.");
    }

    public String toString() {
        return this.token;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
    }

    private void decode(String str) {
        String[] splitToken = splitToken(str);
        this.header = (Map) parseJson(base64Decode(splitToken[0]), new TypeToken<Map<String, String>>() {
        }.getType());
        this.payload = (JWTPayload) parseJson(base64Decode(splitToken[1]), JWTPayload.class);
        this.signature = splitToken[2];
    }

    private String[] splitToken(String str) {
        String[] split = str.split("\\.");
        if (split.length == 2 && str.endsWith(".")) {
            split = new String[]{split[0], split[1], ""};
        }
        if (split.length == 3) {
            return split;
        }
        throw new DecodeException(String.format("The token was expected to have 3 parts, but got %s.", new Object[]{Integer.valueOf(split.length)}));
    }

    private String base64Decode(String str) {
        try {
            return new String(Base64.decode(str, 11), "UTF-8");
        } catch (IllegalArgumentException e) {
            throw new DecodeException("Received bytes didn't correspond to a valid Base64 encoded string.", e);
        } catch (UnsupportedEncodingException e2) {
            throw new DecodeException("Device doesn't support UTF-8 charset encoding.", e2);
        }
    }

    private <T> T parseJson(String str, Type type) {
        try {
            return getGson().fromJson(str, type);
        } catch (Exception e) {
            throw new DecodeException("The token's payload had an invalid JSON format.", e);
        }
    }

    static Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(JWTPayload.class, new JWTDeserializer()).create();
    }
}
