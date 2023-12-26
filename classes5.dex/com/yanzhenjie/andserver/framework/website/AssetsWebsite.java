package com.yanzhenjie.andserver.framework.website;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.framework.body.StreamBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.DigestUtils;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetsWebsite extends BasicWebsite implements Patterns {
    private boolean isScanned;
    private final PackageInfo mPackageInfo;
    private final Map<String, String> mPatternMap;
    private final AssetsReader mReader;
    private final String mRootPath;

    public AssetsWebsite(Context context, String str) {
        this(context, str, BasicWebsite.DEFAULT_INDEX);
    }

    public AssetsWebsite(Context context, String str, String str2) {
        super(str2);
        Assert.isTrue(!StringUtils.isEmpty(str), "The rootPath cannot be empty.");
        Assert.isTrue(!StringUtils.isEmpty(str2), "The indexFileName cannot be empty.");
        if (str.matches(PATH)) {
            this.mReader = new AssetsReader(context.getAssets());
            this.mRootPath = trimStartSlash(str);
            this.mPatternMap = new HashMap();
            try {
                this.mPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException(String.format("The format of [%s] is wrong, it should be like [/root/project].", new Object[]{str}));
        }
    }

    public boolean intercept(HttpRequest httpRequest) {
        tryScanFile();
        return this.mPatternMap.containsKey(httpRequest.getPath());
    }

    private void tryScanFile() {
        if (!this.isScanned) {
            synchronized (AssetsWebsite.class) {
                if (!this.isScanned) {
                    for (String next : this.mReader.scanFile(this.mRootPath)) {
                        String addStartSlash = addStartSlash(next.substring(this.mRootPath.length()));
                        this.mPatternMap.put(addStartSlash, next);
                        String indexFileName = getIndexFileName();
                        if (addStartSlash.endsWith(indexFileName)) {
                            String addStartSlash2 = addStartSlash(addStartSlash.substring(0, addStartSlash.indexOf(indexFileName) - 1));
                            this.mPatternMap.put(addStartSlash2, next);
                            this.mPatternMap.put(addEndSlash(addStartSlash2), next);
                        }
                    }
                    this.isScanned = true;
                }
            }
        }
    }

    public String getETag(HttpRequest httpRequest) throws Throwable {
        String path = httpRequest.getPath();
        InputStream inputStream = this.mReader.getInputStream(this.mPatternMap.get(path));
        if (inputStream != null) {
            return DigestUtils.md5DigestAsHex(inputStream);
        }
        throw new NotFoundException(path);
    }

    public long getLastModified(HttpRequest httpRequest) throws Throwable {
        if (this.mReader.isFile(this.mPatternMap.get(httpRequest.getPath()))) {
            return this.mPackageInfo.lastUpdateTime;
        }
        return -1;
    }

    public ResponseBody getBody(HttpRequest httpRequest) throws IOException {
        String path = httpRequest.getPath();
        String str = this.mPatternMap.get(path);
        InputStream inputStream = this.mReader.getInputStream(str);
        if (inputStream != null) {
            return new StreamBody(inputStream, (long) inputStream.available(), MediaType.getFileMediaType(str));
        }
        throw new NotFoundException(path);
    }

    public static class AssetsReader {
        private AssetManager mAssetManager;

        public AssetsReader(AssetManager assetManager) {
            this.mAssetManager = assetManager;
        }

        public InputStream getInputStream(String str) {
            try {
                return this.mAssetManager.open(str);
            } catch (Throwable unused) {
                return null;
            }
        }

        public boolean isFile(String str) {
            return getInputStream(str) != null;
        }

        public List<String> list(String str) {
            ArrayList arrayList = new ArrayList();
            try {
                Collections.addAll(arrayList, this.mAssetManager.list(str));
            } catch (Throwable unused) {
            }
            return arrayList;
        }

        public List<String> scanFile(String str) {
            Assert.isTrue(!StringUtils.isEmpty(str), "The path cannot be empty.");
            ArrayList arrayList = new ArrayList();
            if (isFile(str)) {
                arrayList.add(str);
            } else {
                for (String str2 : list(str)) {
                    String str3 = str + File.separator + str2;
                    if (isFile(str3)) {
                        arrayList.add(str3);
                    } else {
                        List<String> scanFile = scanFile(str3);
                        if (scanFile.size() > 0) {
                            arrayList.addAll(scanFile);
                        }
                    }
                }
            }
            return arrayList;
        }
    }
}
