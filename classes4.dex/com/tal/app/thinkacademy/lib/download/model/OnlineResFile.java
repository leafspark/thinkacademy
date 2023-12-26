package com.tal.app.thinkacademy.lib.download.model;

import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import java.util.HashMap;
import java.util.List;

public class OnlineResFile {
    private List<ResourceData> defaultPriorityRes;
    private List<ResourceData> highPriorityRes;

    public static class ResourceData {
        public HashMap<String, Object> expandData;
        public String fileName;
        public String filePath;
        public long fileSize;
        public boolean isDiff;
        public boolean isHighPriorityRes = false;
        public boolean isIgnoreSRAVerify = false;
        public SimpleDownloadListener listener;
        public String localVersion;
        public String md5;
        public String realFileName;
        public String resBusinessType;
        public long unZipFileSize;
        public String unZipPath;
        public List<String> url;
        public String version;
    }

    public List<ResourceData> getHighPriorityRes() {
        return this.highPriorityRes;
    }

    public void setHighPriorityRes(List<ResourceData> list) {
        this.highPriorityRes = list;
    }

    public List<ResourceData> getDefaultPriorityRes() {
        return this.defaultPriorityRes;
    }

    public void setDefaultPriorityRes(List<ResourceData> list) {
        this.defaultPriorityRes = list;
    }
}
