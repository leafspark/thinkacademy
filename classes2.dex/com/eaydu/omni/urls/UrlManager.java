package com.eaydu.omni.urls;

public class UrlManager {
    private static final String URL_CORE_SERVER_LOG_OMNI_DEFAULT = "";
    private static final String URL_CORE_SLB_BACKUP_OMNI_DEFAULT = "";
    private static final String URL_CORE_SLB_OMNI_DEFAULT = "";
    public static final String URL_FULL_LOG_DEFAULT = "http://mobilelog.xesv5.com/log/dispatch";
    public static final String URL_FULL_LOG_KEY = "fullLog";
    private static final String URL_INSPECT_DEFAULT = "https://api2.xueersi.com/live-auth/api/authV2";
    public static final String URL_INSPECT_KEY = "inspect";
    private static final String URL_KIBANA_DEFAULT = "http://adapter-logs.zhiboyun.eaydu.com/stream.gif";
    public static final String URL_KIBANA_KEY = "kibana";
    public static final String URL_OMNI_CORE_SERVER_LOG_KEY = "coreServerLog";
    public static final String URL_OMNI_CORE_SLB_BACKUP_KEY = "coreSlbBackup";
    public static final String URL_OMNI_CORE_SLB_KEY = "coreSlb";
    private static final String URL_UPLOAD_LOG_DEFAULT = "https://api2.xueersi.com/live-auth/api/logauth";
    public static final String URL_UPLOAD_LOG_KEY = "logUpload";
    private String urlCoreServerLogOMNI;
    private String urlCoreSlbBackupOMNI;
    private String urlCoreSlbOMNI;
    private String urlFullLog;
    private String urlInspect;
    private String urlKibana;
    private String urlUploadLog;

    private UrlManager() {
        this.urlFullLog = URL_FULL_LOG_DEFAULT;
        this.urlUploadLog = URL_UPLOAD_LOG_DEFAULT;
        this.urlKibana = URL_KIBANA_DEFAULT;
        this.urlInspect = URL_INSPECT_DEFAULT;
        this.urlCoreSlbOMNI = "";
        this.urlCoreSlbBackupOMNI = "";
        this.urlCoreServerLogOMNI = "";
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final UrlManager INSTANCE = new UrlManager();

        private InstanceHolder() {
        }
    }

    public static UrlManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void onDestroy() {
        try {
            setUrlFullLog(URL_FULL_LOG_DEFAULT);
            setUrlUploadLog(URL_UPLOAD_LOG_DEFAULT);
            setUrlKibana(URL_KIBANA_DEFAULT);
            setUrlInspect(URL_INSPECT_DEFAULT);
            setUrlCoreSlbOMNI("");
            setUrlCoreSlbBackupOMNI("");
            setUrlCoreServerLogOMNI("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrlFullLog() {
        return this.urlFullLog;
    }

    public void setUrlFullLog(String str) {
        this.urlFullLog = str;
    }

    public String getUrlUploadLog() {
        return this.urlUploadLog;
    }

    public void setUrlUploadLog(String str) {
        this.urlUploadLog = str;
    }

    public String getUrlKibana() {
        return this.urlKibana;
    }

    public void setUrlKibana(String str) {
        this.urlKibana = str;
    }

    public String getUrlInspect() {
        return this.urlInspect;
    }

    public void setUrlInspect(String str) {
        this.urlInspect = str;
    }

    public String getUrlCoreSlbOMNI() {
        return this.urlCoreSlbOMNI;
    }

    public void setUrlCoreSlbOMNI(String str) {
        this.urlCoreSlbOMNI = str;
    }

    public String getUrlCoreSlbBackupOMNI() {
        return this.urlCoreSlbBackupOMNI;
    }

    public void setUrlCoreSlbBackupOMNI(String str) {
        this.urlCoreSlbBackupOMNI = str;
    }

    public String getUrlCoreServerLogOMNI() {
        return this.urlCoreServerLogOMNI;
    }

    public void setUrlCoreServerLogOMNI(String str) {
        this.urlCoreServerLogOMNI = str;
    }
}
