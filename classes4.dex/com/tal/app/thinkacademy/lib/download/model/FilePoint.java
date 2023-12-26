package com.tal.app.thinkacademy.lib.download.model;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.operation.DownloadState;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilePoint implements Serializable {
    public static final int DEFAULT_PRIORITY = 1001;
    private long downloadDuration;
    private DownloadState downloadState = DownloadState.START;
    public HashMap<String, Object> expandData;
    protected String fileName;
    private String filePath;
    private long fileSize;
    private FilePoint fullFilePoint;
    private boolean isDeleteResAfterDownloadOverAndUnzip = true;
    private boolean isDiff;
    private boolean isFirst;
    private boolean isHighPriorityRes = false;
    private boolean isIgnoreSRAVerify = false;
    private boolean isSingleSlice;
    private String localVersion;
    private WeakReference<SimpleDownloadListener> mListener;
    private String md5;
    private int priority = 1001;
    private String realFileName;
    private String realUrl;
    private String resBusinessType;
    private int resType;
    private List<String> temp = new ArrayList();
    private long unZipFileSize;
    private String unZipPath;
    private String updateTime;
    private List<String> url;
    private String version;

    public void onFailed(int i, String str, String str2, String str3) {
    }

    public void onProgress(long j, long j2) {
    }

    public int getResType() {
        return this.resType;
    }

    public void setResType(int i) {
        this.resType = i;
    }

    public DownloadState getDownloadState() {
        return this.downloadState;
    }

    public void setDownloadState(DownloadState downloadState2) {
        this.downloadState = downloadState2;
    }

    public FilePoint getFullFilePoint() {
        return this.fullFilePoint;
    }

    public void setFullFilePoint(FilePoint filePoint) {
        this.fullFilePoint = filePoint;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getRealUrl() {
        List<String> list;
        if (TextUtils.isEmpty(this.realUrl) && (list = this.url) != null && list.size() > 0) {
            this.temp.addAll(this.url);
            this.realUrl = this.temp.get(0);
        }
        return this.realUrl;
    }

    public String getHttpRealUrl() {
        String realUrl2 = getRealUrl();
        if (realUrl2.startsWith("https")) {
            this.realUrl = realUrl2.replace("https", "http");
        }
        return this.realUrl;
    }

    public boolean hasNextUr() {
        List<String> list = this.temp;
        if (!(list == null || list.size() == 0)) {
            this.temp.remove(0);
        }
        List<String> list2 = this.temp;
        if (list2 == null || list2.size() == 0) {
            this.realUrl = "";
            getRealUrl();
            return false;
        }
        this.realUrl = this.temp.get(0);
        return true;
    }

    public void setRealUrl(String str) {
        this.realUrl = str;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public List<String> getUrl() {
        return this.url;
    }

    public void setUrl(List<String> list) {
        this.url = list;
    }

    public String getRealFileName() {
        if (TextUtils.isEmpty(this.realFileName)) {
            setRealFileName();
        }
        return this.realFileName;
    }

    public void setRealFileName(String str) {
        this.realFileName = str;
    }

    public String getFileNameByLocalVersion() {
        if (TextUtils.isEmpty(this.fileName)) {
            return null;
        }
        int lastIndexOf = this.fileName.lastIndexOf(".");
        StringBuffer stringBuffer = new StringBuffer();
        if (lastIndexOf != -1 && !TextUtils.isEmpty(getLocalVersion())) {
            stringBuffer.append(this.fileName.substring(0, lastIndexOf) + "_" + getLocalVersion());
            stringBuffer.append(this.fileName.substring(lastIndexOf));
        }
        return stringBuffer.toString();
    }

    public String getFilDirByLocalVersion() {
        if (TextUtils.isEmpty(this.fileName)) {
            return null;
        }
        int lastIndexOf = this.fileName.lastIndexOf(".");
        StringBuffer stringBuffer = new StringBuffer();
        if (lastIndexOf != -1 && !TextUtils.isEmpty(getLocalVersion())) {
            stringBuffer.append(this.fileName.substring(0, lastIndexOf) + "_" + getLocalVersion());
        }
        return stringBuffer.toString();
    }

    public boolean isDiff() {
        return this.isDiff;
    }

    public void setDiff(boolean z) {
        this.isDiff = z;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getDownloadDuration() {
        return this.downloadDuration;
    }

    public void setDownloadDuration(long j) {
        this.downloadDuration = j;
    }

    public String getUnZipPath() {
        return this.unZipPath;
    }

    public void setUnZipPath(String str) {
        this.unZipPath = str;
    }

    public SimpleDownloadListener getListener() {
        WeakReference<SimpleDownloadListener> weakReference = this.mListener;
        if (weakReference != null) {
            return (SimpleDownloadListener) weakReference.get();
        }
        return null;
    }

    public void setListener(SimpleDownloadListener simpleDownloadListener) {
        this.mListener = new WeakReference<>(simpleDownloadListener);
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public boolean isIgnoreSRAVerify() {
        return this.isIgnoreSRAVerify;
    }

    public void setIgnoreSRAVerify(boolean z) {
        this.isIgnoreSRAVerify = z;
    }

    public String getLocalVersion() {
        return this.localVersion;
    }

    public void setLocalVersion(String str) {
        this.localVersion = str;
    }

    private void setRealFileName() {
        if (!TextUtils.isEmpty(this.fileName)) {
            int lastIndexOf = this.fileName.lastIndexOf(".");
            if (lastIndexOf > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.fileName.substring(0, lastIndexOf));
                if (!TextUtils.isEmpty(this.version)) {
                    stringBuffer.append("_");
                    stringBuffer.append(this.version);
                }
                if (this.isDiff) {
                    stringBuffer.append("_diff");
                }
                stringBuffer.append(this.fileName.substring(lastIndexOf));
                this.realFileName = stringBuffer.toString();
                return;
            }
            this.realFileName = this.fileName;
        }
    }

    public long getUnZipFileSize() {
        return this.unZipFileSize;
    }

    public void setUnZipFileSize(long j) {
        this.unZipFileSize = j;
    }

    public boolean isDeleteResAfterDownloadOverAndUnzip() {
        return this.isDeleteResAfterDownloadOverAndUnzip;
    }

    public void setDeleteResAfterDownloadOverAndUnzip(boolean z) {
        this.isDeleteResAfterDownloadOverAndUnzip = z;
    }

    public boolean isHighPriorityRes() {
        return this.isHighPriorityRes;
    }

    public void setHighPriorityRes(boolean z) {
        this.isHighPriorityRes = z;
    }

    public String getResBusinessType() {
        return this.resBusinessType;
    }

    public void setResBusinessType(String str) {
        this.resBusinessType = str;
    }

    public HashMap<String, Object> getExpandData() {
        return this.expandData;
    }

    public void setExpandData(HashMap<String, Object> hashMap) {
        this.expandData = hashMap;
    }

    public boolean isSingleSlice() {
        return this.isSingleSlice;
    }

    public void setSingleSlice(boolean z) {
        this.isSingleSlice = z;
    }

    public String toString() {
        return "FilePoint{fileName='" + this.fileName + '\'' + ", realUrl='" + this.realUrl + '\'' + ", filePath='" + this.filePath + '\'' + ", unZipPath='" + this.unZipPath + '\'' + ", md5='" + this.md5 + '\'' + ", version='" + this.version + '\'' + ", localVersion='" + this.localVersion + '\'' + ", fileSize=" + this.fileSize + ", unZipFileSize=" + this.unZipFileSize + ", realFileName='" + this.realFileName + '\'' + ", url=" + this.url + ", isDiff=" + this.isDiff + ", priority=" + this.priority + ", isFirst=" + this.isFirst + ", downloadDuration=" + this.downloadDuration + ", isIgnoreSRAVerify=" + this.isIgnoreSRAVerify + ", isDeleteResAfterDownloadOverAndUnzip=" + this.isDeleteResAfterDownloadOverAndUnzip + ", isHighPriorityRes=" + this.isHighPriorityRes + ", fullFilePoint=" + this.fullFilePoint + ", resType=" + this.resType + ", resBusinessType=" + this.resBusinessType + '}';
    }

    public void onStart() {
        XesLog.it("FilePointDownload", "onStart:" + this.fileName);
    }

    public void onFinished() {
        XesLog.it("FilePointDownload", "onFinished:" + this.fileName);
    }
}
