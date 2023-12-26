package com.aliyun.sls.android.producer;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.aliyun.sls.android.producer.utils.TimeUtils;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogProducerHttpTool {
    private static final String TAG = "LogProducerHttpTool";

    public static int android_http_post(String str, String[] strArr, byte[] bArr) {
        return android_http_post(str, ShareTarget.METHOD_POST, strArr, bArr);
    }

    public static int android_http_post(String str, String str2, String[] strArr, byte[] bArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setRequestProperty("User-agent", HttpConfigProxy.getUserAgent());
            if (strArr != null) {
                int length = strArr.length / 2;
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    httpURLConnection.setRequestProperty(strArr[i2], strArr[i2 + 1]);
                }
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            String headerField = httpURLConnection.getHeaderField("x-log-time");
            if (headerField != null && !"".equals(headerField)) {
                long j = toLong(headerField);
                if (j > 1500000000 && j < 4294967294L) {
                    TimeUtils.updateServerTime(j);
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode / 100 == 2) {
                return responseCode;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    Log.w(TAG, "code: " + responseCode + ", response: " + sb.toString());
                    return responseCode;
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "exception: " + e.getLocalizedMessage());
            return -1;
        }
    }

    private static long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
