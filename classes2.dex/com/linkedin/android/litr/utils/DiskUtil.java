package com.linkedin.android.litr.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

public class DiskUtil {
    public static final long FREE_DISK_SPACE_CHECK_FAILED = -1;
    private static final String TAG = "DiskUtil";

    public long getAvailableDiskSpaceInDataDirectory() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception unused) {
            Log.e(TAG, "Could not get Available Disk Space");
            return -1;
        }
    }
}
