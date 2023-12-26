package com.eaydu.omni.log;

import com.amazonaws.services.s3.util.Mimetypes;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.MultipartBody;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.utils.HttpUtils;
import com.eaydu.omni.utils.RateLimitingRequestBody;
import java.io.File;
import java.net.URLConnection;

public class AliosUploadFile {
    private static final int MAX_RATE = 204800;

    private static String guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? Mimetypes.MIMETYPE_OCTET_STREAM : contentTypeFor;
    }

    public static void aliosUploadFile(UploadParam uploadParam, Callback callback) {
        File file = new File(uploadParam.filePath);
        MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("OSSAccessKeyId", uploadParam.ossAccessKeyId).addFormDataPart("policy", uploadParam.policy).addFormDataPart("Signature", uploadParam.signature).addFormDataPart("success_action_status", uploadParam.successActionStatus).addFormDataPart("key", uploadParam.key).addFormDataPart("callback", uploadParam.callback).addFormDataPart("file", uploadParam.fileName, (RateLimitingRequestBody) RateLimitingRequestBody.createRequestBody(MediaType.parse(guessMimeType(uploadParam.filePath)), file, MAX_RATE)).build();
        if (!uploadParam.host.startsWith("http://")) {
            uploadParam.host = "http://" + uploadParam.host;
        }
        HttpUtils.getHttpClient().newCall(new Request.Builder().url(uploadParam.host).post(build).build()).enqueue(callback);
    }
}
