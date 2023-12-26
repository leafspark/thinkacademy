package io.agora.rtc.models;

public class ContentInspectConfig {
    public static final int CONTENT_INSPECT_TYPE_INVALID = 0;
    public static final int CONTENT_INSPECT_TYPE_MODERATION = 1;
    public static final int CONTENT_INSPECT_TYPE_SUPERVISE = 2;
    public static final int MAX_CONTENT_INSPECT_MODULE_COUNT = 32;
    public String extraInfo;
    public int moduleCount;
    public ContentInspectModule[] modules = new ContentInspectModule[32];

    public static class ContentInspectModule {
        public int frequency = 0;
        public int type = 0;
    }

    public ContentInspectConfig() {
        for (int i = 0; i < 32; i++) {
            this.modules[i] = new ContentInspectModule();
        }
        this.moduleCount = 0;
    }
}
