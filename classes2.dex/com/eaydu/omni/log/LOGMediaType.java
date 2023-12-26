package com.eaydu.omni.log;

public enum LOGMediaType {
    LOG_MEDIA_AUDIO(1),
    LOG_MEDIA_VIDEO(2),
    LOG_MEDIA_ALL(3);
    
    public final int value;

    private LOGMediaType(int i) {
        this.value = i;
    }
}
