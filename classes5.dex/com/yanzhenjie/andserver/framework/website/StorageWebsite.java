package com.yanzhenjie.andserver.framework.website;

import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.framework.body.FileBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.DigestUtils;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.File;
import java.io.IOException;

public class StorageWebsite extends BasicWebsite implements Patterns {
    private final String mRootPath;

    public StorageWebsite(String str) {
        this(str, BasicWebsite.DEFAULT_INDEX);
    }

    public StorageWebsite(String str, String str2) {
        super(str2);
        Assert.isTrue(!StringUtils.isEmpty(str), "The rootPath cannot be empty.");
        Assert.isTrue(str.matches(PATH), "The format of [%s] is wrong, it should be like [/root/project].");
        this.mRootPath = str;
    }

    public boolean intercept(HttpRequest httpRequest) {
        return findPathResource(httpRequest.getPath()) != null;
    }

    private File findPathResource(String str) {
        if ("/".equals(str)) {
            File file = new File(this.mRootPath, getIndexFileName());
            if (!file.exists() || !file.isFile()) {
                return null;
            }
            return file;
        }
        File file2 = new File(this.mRootPath, str);
        if (!file2.exists()) {
            return null;
        }
        if (file2.isFile()) {
            return file2;
        }
        File file3 = new File(file2, getIndexFileName());
        if (!file3.exists() || !file3.isFile()) {
            return null;
        }
        return file3;
    }

    public String getETag(HttpRequest httpRequest) throws Throwable {
        File findPathResource = findPathResource(httpRequest.getPath());
        if (findPathResource == null) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(findPathResource.getAbsolutePath() + findPathResource.lastModified());
    }

    public long getLastModified(HttpRequest httpRequest) throws Throwable {
        File findPathResource = findPathResource(httpRequest.getPath());
        if (findPathResource != null) {
            return findPathResource.lastModified();
        }
        return -1;
    }

    public ResponseBody getBody(HttpRequest httpRequest) throws IOException {
        String path = httpRequest.getPath();
        File findPathResource = findPathResource(path);
        if (findPathResource != null) {
            return new FileBody(findPathResource);
        }
        throw new NotFoundException(path);
    }
}
