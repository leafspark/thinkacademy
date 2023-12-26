package com.yanzhenjie.andserver.framework.website;

import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.framework.body.FileBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.DigestUtils;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.ObjectUtils;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.Charsets;

public class FileBrowser extends BasicWebsite implements Patterns {
    private static final String FOLDER_HTML_PREFIX = "<!DOCTYPE html><html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\"><metaname=\"format-detection\" content=\"telephone=no\"/> <title>%1$s</title><style>.center_horizontal{margin:0 auto;text-align:center;} *,*::after,*::before {box-sizing: border-box;margin: 0;padding: 0;}a:-webkit-any-link {color: -webkit-link;cursor: auto;text-decoration: underline;}ul {list-style: none;display: block;list-style-type: none;-webkit-margin-before: 1em;-webkit-margin-after: 1em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;-webkit-padding-start: 40px;}li {display: list-item;text-align: -webkit-match-parent;margin-bottom: 5px;}</style></head><body><h1 class=\"center_horizontal\">%2$s</h1><ul>";
    private static final String FOLDER_HTML_SUFFIX = "</ul></body></html>";
    private static final String FOLDER_ITEM = "<li><a href=\"%1$s\">%2$s</a></li>";
    private final String mRootPath;

    public FileBrowser(String str) {
        Assert.isTrue(!StringUtils.isEmpty(str), "The rootPath cannot be empty.");
        Assert.isTrue(str.matches(PATH), "The format of [%s] is wrong, it should be like [/root/project].");
        this.mRootPath = str;
    }

    public boolean intercept(HttpRequest httpRequest) {
        return findPathResource(httpRequest.getPath()) != null;
    }

    private File findPathResource(String str) {
        if ("/".equals(str)) {
            File file = new File(this.mRootPath);
            if (file.exists()) {
                return file;
            }
            return null;
        }
        File file2 = new File(this.mRootPath, str);
        if (file2.exists()) {
            return file2;
        }
        return null;
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
        if (findPathResource == null) {
            throw new NotFoundException(path);
        } else if (!findPathResource.isDirectory()) {
            return new FileBody(findPathResource);
        } else {
            File createTempFile = File.createTempFile("file_browser", ".html");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            String name = findPathResource.getName();
            fileOutputStream.write(String.format(FOLDER_HTML_PREFIX, new Object[]{name, name}).getBytes("utf-8"));
            File[] listFiles = findPathResource.listFiles();
            if (!ObjectUtils.isEmpty((Object[]) listFiles)) {
                for (File file : listFiles) {
                    String absolutePath = file.getAbsolutePath();
                    fileOutputStream.write(String.format(FOLDER_ITEM, new Object[]{addStartSlash(absolutePath.substring(absolutePath.indexOf(this.mRootPath) + this.mRootPath.length())), file.getName()}).getBytes("utf-8"));
                }
            }
            fileOutputStream.write(FOLDER_HTML_SUFFIX.getBytes("utf-8"));
            return new FileBody(createTempFile) {
                public MediaType contentType() {
                    MediaType contentType = super.contentType();
                    return contentType != null ? new MediaType(contentType.getType(), contentType.getSubtype(), Charsets.UTF_8) : contentType;
                }
            };
        }
    }
}
