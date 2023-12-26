package com.tal.app.thinkacademy.common.business.browser.server;

import android.text.TextUtils;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PartialContentInterceptor implements HandlerInterceptor {
    public boolean onIntercept(HttpRequest httpRequest, HttpResponse httpResponse, RequestHandler requestHandler) throws IOException {
        HttpResponse httpResponse2 = httpResponse;
        String header = httpRequest.getHeader("Range");
        if (TextUtils.isEmpty(header)) {
            return false;
        }
        CoreService.getRootPath();
        httpRequest.getURI();
        File file = new File(CoreService.getRootPath() + httpRequest.getURI());
        long length = file.length() - 1;
        long j = 0;
        if (header != null && header.contains("bytes=") && header.contains("-")) {
            String trim = header.substring(header.lastIndexOf("=") + 1).trim();
            String[] split = trim.split("-");
            try {
                if (split.length == 1) {
                    if (trim.startsWith("-")) {
                        length = Long.parseLong(split[0]);
                    } else if (trim.endsWith("-")) {
                        j = Long.parseLong(split[0]);
                    }
                } else if (split.length == 2) {
                    long parseLong = Long.parseLong(split[0]);
                    length = Long.parseLong(split[1]);
                    j = parseLong;
                }
            } catch (NumberFormatException unused) {
                length = file.length() - 1;
            }
        }
        file.getName();
        MediaType fileMediaType = MediaType.getFileMediaType(file.getName());
        httpResponse2.setHeader("Accept-Ranges", "bytes");
        httpResponse2.setStatus(206);
        httpResponse2.setHeader("Content-Range", "bytes " + j + "-" + length + "/" + file.length());
        httpResponse2.setBody(new RandomFileBody(Long.valueOf(j), Long.valueOf(length), new RandomAccessFile(file, "r"), Long.valueOf((length - j) + 1), fileMediaType));
        return true;
    }
}
