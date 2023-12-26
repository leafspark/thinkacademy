package com.sensorsdata.analytics.android.sdk;

enum EventType {
    TRACK("track", true, false),
    TRACK_SIGNUP("track_signup", true, false),
    PROFILE_SET("profile_set", false, true),
    PROFILE_SET_ONCE("profile_set_once", false, true),
    PROFILE_UNSET("profile_unset", false, true),
    PROFILE_INCREMENT("profile_increment", false, true),
    PROFILE_APPEND("profile_append", false, true),
    PROFILE_DELETE("profile_delete", false, true),
    REGISTER_SUPER_PROPERTIES("register_super_properties", false, false),
    ITEM_SET("item_set", false, false),
    ITEM_DELETE("item_delete", false, false);
    
    private String eventType;
    private boolean profile;
    private boolean track;

    private EventType(String str, boolean z, boolean z2) {
        this.eventType = str;
        this.track = z;
        this.profile = z2;
    }

    public String getEventType() {
        return this.eventType;
    }

    public boolean isTrack() {
        return this.track;
    }

    public boolean isProfile() {
        return this.profile;
    }
}
