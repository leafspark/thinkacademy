package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import com.amazonaws.services.s3.internal.Constants;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OSSAuthCredentialsProvider extends OSSFederationCredentialProvider {
    private String mAuthServerUrl;
    private AuthDecoder mDecoder;

    public interface AuthDecoder {
        String decode(String str);
    }

    public OSSAuthCredentialsProvider(String str) {
        this.mAuthServerUrl = str;
    }

    public void setAuthServerUrl(String str) {
        this.mAuthServerUrl = str;
    }

    public void setDecoder(AuthDecoder authDecoder) {
        this.mDecoder = authDecoder;
    }

    public OSSFederationToken getFederationToken() throws ClientException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(this.mAuthServerUrl).openConnection());
            httpURLConnection.setConnectTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
            String readStreamAsString = IOUtils.readStreamAsString(httpURLConnection.getInputStream(), "utf-8");
            AuthDecoder authDecoder = this.mDecoder;
            if (authDecoder != null) {
                readStreamAsString = authDecoder.decode(readStreamAsString);
            }
            JSONObject jSONObject = new JSONObject(readStreamAsString);
            if (jSONObject.getInt("StatusCode") == 200) {
                return new OSSFederationToken(jSONObject.getString("AccessKeyId"), jSONObject.getString("AccessKeySecret"), jSONObject.getString("SecurityToken"), jSONObject.getString("Expiration"));
            }
            String string = jSONObject.getString("ErrorCode");
            String string2 = jSONObject.getString("ErrorMessage");
            throw new ClientException("ErrorCode: " + string + "| ErrorMessage: " + string2);
        } catch (Exception e) {
            throw new ClientException((Throwable) e);
        }
    }
}
