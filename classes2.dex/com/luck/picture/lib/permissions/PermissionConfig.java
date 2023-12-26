package com.luck.picture.lib.permissions;

import android.content.Context;
import com.luck.picture.lib.tools.SdkVersionUtils;

public class PermissionConfig {
    public static final String[] CAMERA = {"android.permission.CAMERA"};
    public static String[] CURRENT_REQUEST_PERMISSION = new String[0];
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    public static final String READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static String[] getReadPermissionArray(Context context) {
        if (SdkVersionUtils.isTIRAMISU()) {
            return context.getApplicationInfo().targetSdkVersion >= 33 ? new String[]{READ_MEDIA_IMAGES, READ_MEDIA_VIDEO} : new String[]{READ_EXTERNAL_STORAGE};
        }
        return new String[]{READ_EXTERNAL_STORAGE};
    }

    public static String[] getReadWritePermissionArray(Context context) {
        if (SdkVersionUtils.isTIRAMISU()) {
            return context.getApplicationInfo().targetSdkVersion >= 33 ? new String[]{READ_MEDIA_IMAGES, READ_MEDIA_VIDEO} : new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};
        }
        return new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};
    }

    public static String[] getWritePermissionArray(Context context) {
        if (SdkVersionUtils.isTIRAMISU()) {
            return context.getApplicationInfo().targetSdkVersion >= 33 ? new String[]{READ_MEDIA_IMAGES, READ_MEDIA_VIDEO} : new String[]{WRITE_EXTERNAL_STORAGE};
        }
        return new String[]{WRITE_EXTERNAL_STORAGE};
    }
}
