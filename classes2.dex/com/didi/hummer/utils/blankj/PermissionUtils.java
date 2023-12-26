package com.didi.hummer.utils.blankj;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import com.didi.hummer.utils.blankj.Utils;
import com.didi.hummer.utils.blankj.UtilsTransActivity;
import com.google.protobuf.CodedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class PermissionUtils {
    /* access modifiers changed from: private */
    public static PermissionUtils sInstance;
    /* access modifiers changed from: private */
    public static SimpleCallback sSimpleCallback4DrawOverlays;
    /* access modifiers changed from: private */
    public static SimpleCallback sSimpleCallback4WriteSettings;
    private FullCallback mFullCallback;
    private OnRationaleListener mOnRationaleListener;
    private Set<String> mPermissions;
    /* access modifiers changed from: private */
    public List<String> mPermissionsDenied;
    /* access modifiers changed from: private */
    public List<String> mPermissionsDeniedForever;
    private List<String> mPermissionsGranted;
    private String[] mPermissionsParam;
    /* access modifiers changed from: private */
    public List<String> mPermissionsRequest;
    private SimpleCallback mSimpleCallback;
    /* access modifiers changed from: private */
    public ThemeCallback mThemeCallback;

    public interface FullCallback {
        void onDenied(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    public interface OnRationaleListener {

        public interface ShouldRequest {
            void again(boolean z);
        }

        void rationale(UtilsTransActivity utilsTransActivity, ShouldRequest shouldRequest);
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    public interface ThemeCallback {
        void onActivityCreate(Activity activity);
    }

    public static List<String> getPermissions() {
        return getPermissions(Utils.getApp().getPackageName());
    }

    public static List<String> getPermissions(String str) {
        try {
            String[] strArr = Utils.getApp().getPackageManager().getPackageInfo(str, CodedOutputStream.DEFAULT_BUFFER_SIZE).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static boolean isGranted(String... strArr) {
        for (String isGranted : strArr) {
            if (!isGranted(isGranted)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGranted(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(Utils.getApp(), str) == 0;
    }

    public static boolean isGrantedWriteSettings() {
        return Settings.System.canWrite(Utils.getApp());
    }

    public static void requestWriteSettings(SimpleCallback simpleCallback) {
        if (!isGrantedWriteSettings()) {
            sSimpleCallback4WriteSettings = simpleCallback;
            PermissionActivityImpl.start(2);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    /* access modifiers changed from: private */
    public static void startWriteSettingsActivity(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!IntentUtils.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static boolean isGrantedDrawOverlays() {
        return Settings.canDrawOverlays(Utils.getApp());
    }

    public static void requestDrawOverlays(SimpleCallback simpleCallback) {
        if (!isGrantedDrawOverlays()) {
            sSimpleCallback4DrawOverlays = simpleCallback;
            PermissionActivityImpl.start(3);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    /* access modifiers changed from: private */
    public static void startOverlayPermissionActivity(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!IntentUtils.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void launchAppDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (IntentUtils.isIntentAvailable(intent)) {
            Utils.getApp().startActivity(intent.addFlags(268435456));
        }
    }

    public static PermissionUtils permission(String... strArr) {
        return new PermissionUtils(strArr);
    }

    private PermissionUtils(String... strArr) {
        this.mPermissionsParam = strArr;
        sInstance = this;
    }

    public PermissionUtils rationale(OnRationaleListener onRationaleListener) {
        this.mOnRationaleListener = onRationaleListener;
        return this;
    }

    public PermissionUtils callback(SimpleCallback simpleCallback) {
        this.mSimpleCallback = simpleCallback;
        return this;
    }

    public PermissionUtils callback(FullCallback fullCallback) {
        this.mFullCallback = fullCallback;
        return this;
    }

    public PermissionUtils theme(ThemeCallback themeCallback) {
        this.mThemeCallback = themeCallback;
        return this;
    }

    public void request() {
        String[] strArr = this.mPermissionsParam;
        if (strArr == null || strArr.length <= 0) {
            Log.e("PermissionUtils", "No permissions to request.");
            return;
        }
        this.mPermissions = new LinkedHashSet();
        this.mPermissionsRequest = new ArrayList();
        this.mPermissionsGranted = new ArrayList();
        this.mPermissionsDenied = new ArrayList();
        this.mPermissionsDeniedForever = new ArrayList();
        List<String> permissions = getPermissions();
        for (String str : this.mPermissionsParam) {
            boolean z = false;
            for (String str2 : PermissionConstants.getPermissions(str)) {
                if (permissions.contains(str2)) {
                    this.mPermissions.add(str2);
                    z = true;
                }
            }
            if (!z) {
                this.mPermissionsDenied.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            this.mPermissionsGranted.addAll(this.mPermissions);
            requestCallback();
            return;
        }
        for (String next : this.mPermissions) {
            if (isGranted(next)) {
                this.mPermissionsGranted.add(next);
            } else {
                this.mPermissionsRequest.add(next);
            }
        }
        if (this.mPermissionsRequest.isEmpty()) {
            requestCallback();
        } else {
            startPermissionActivity();
        }
    }

    private void startPermissionActivity() {
        PermissionActivityImpl.start(1);
    }

    /* access modifiers changed from: private */
    public boolean shouldRationale(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z = false;
        if (this.mOnRationaleListener != null) {
            Iterator<String> it = this.mPermissionsRequest.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (utilsTransActivity.shouldShowRequestPermissionRationale(it.next())) {
                        rationalInner(utilsTransActivity, runnable);
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mOnRationaleListener = null;
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.app.Activity, com.didi.hummer.utils.blankj.UtilsTransActivity] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rationalInner(final com.didi.hummer.utils.blankj.UtilsTransActivity r3, final java.lang.Runnable r4) {
        /*
            r2 = this;
            r2.getPermissionsStatus(r3)
            com.didi.hummer.utils.blankj.PermissionUtils$OnRationaleListener r0 = r2.mOnRationaleListener
            com.didi.hummer.utils.blankj.PermissionUtils$1 r1 = new com.didi.hummer.utils.blankj.PermissionUtils$1
            r1.<init>(r4, r3)
            r0.rationale(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.utils.blankj.PermissionUtils.rationalInner(com.didi.hummer.utils.blankj.UtilsTransActivity, java.lang.Runnable):void");
    }

    private void getPermissionsStatus(Activity activity) {
        for (String next : this.mPermissionsRequest) {
            if (isGranted(next)) {
                this.mPermissionsGranted.add(next);
            } else {
                this.mPermissionsDenied.add(next);
                if (!activity.shouldShowRequestPermissionRationale(next)) {
                    this.mPermissionsDeniedForever.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void requestCallback() {
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onGranted();
            } else {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissionsGranted.size() > 0) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            }
            if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDeniedForever, this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
        this.mOnRationaleListener = null;
        this.mThemeCallback = null;
    }

    /* access modifiers changed from: private */
    public void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus(activity);
        requestCallback();
    }

    static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        PermissionActivityImpl() {
        }

        public static void start(final int i) {
            UtilsTransActivity.start((Utils.Consumer<Intent>) new Utils.Consumer<Intent>() {
                public void accept(Intent intent) {
                    intent.putExtra(PermissionActivityImpl.TYPE, i);
                }
            }, (UtilsTransActivity.TransActivityDelegate) INSTANCE);
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.app.Activity, com.didi.hummer.utils.blankj.UtilsTransActivity] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCreated(final com.didi.hummer.utils.blankj.UtilsTransActivity r3, android.os.Bundle r4) {
            /*
                r2 = this;
                android.view.Window r4 = r3.getWindow()
                r0 = 262160(0x40010, float:3.67364E-40)
                r4.addFlags(r0)
                r4 = -1
                android.content.Intent r0 = r3.getIntent()     // Catch:{ Exception -> 0x0016 }
                java.lang.String r1 = "TYPE"
                int r4 = r0.getIntExtra(r1, r4)     // Catch:{ Exception -> 0x0016 }
                goto L_0x001a
            L_0x0016:
                r0 = move-exception
                r0.printStackTrace()
            L_0x001a:
                r0 = 1
                java.lang.String r1 = "PermissionUtils"
                if (r4 != r0) goto L_0x0057
                com.didi.hummer.utils.blankj.PermissionUtils r4 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                if (r4 != 0) goto L_0x002e
                java.lang.String r4 = "request permissions failed"
                android.util.Log.e(r1, r4)
                r3.finish()
                return
            L_0x002e:
                com.didi.hummer.utils.blankj.PermissionUtils r4 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                com.didi.hummer.utils.blankj.PermissionUtils$ThemeCallback r4 = r4.mThemeCallback
                if (r4 == 0) goto L_0x0043
                com.didi.hummer.utils.blankj.PermissionUtils r4 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                com.didi.hummer.utils.blankj.PermissionUtils$ThemeCallback r4 = r4.mThemeCallback
                r4.onActivityCreate(r3)
            L_0x0043:
                com.didi.hummer.utils.blankj.PermissionUtils r4 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                com.didi.hummer.utils.blankj.PermissionUtils$PermissionActivityImpl$2 r0 = new com.didi.hummer.utils.blankj.PermissionUtils$PermissionActivityImpl$2
                r0.<init>(r3)
                boolean r4 = r4.shouldRationale(r3, r0)
                if (r4 == 0) goto L_0x0053
                return
            L_0x0053:
                r2.requestPermissions(r3)
                goto L_0x0071
            L_0x0057:
                r0 = 2
                if (r4 != r0) goto L_0x0060
                currentRequestCode = r0
                com.didi.hummer.utils.blankj.PermissionUtils.startWriteSettingsActivity(r3, r0)
                goto L_0x0071
            L_0x0060:
                r0 = 3
                if (r4 != r0) goto L_0x0069
                currentRequestCode = r0
                com.didi.hummer.utils.blankj.PermissionUtils.startOverlayPermissionActivity(r3, r0)
                goto L_0x0071
            L_0x0069:
                r3.finish()
                java.lang.String r3 = "type is wrong."
                android.util.Log.e(r1, r3)
            L_0x0071:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.utils.blankj.PermissionUtils.PermissionActivityImpl.onCreated(com.didi.hummer.utils.blankj.UtilsTransActivity, android.os.Bundle):void");
        }

        /* access modifiers changed from: private */
        public void requestPermissions(Activity activity) {
            if (PermissionUtils.sInstance.mPermissionsRequest != null) {
                int size = PermissionUtils.sInstance.mPermissionsRequest.size();
                if (size <= 0) {
                    activity.finish();
                } else {
                    activity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[size]), 1);
                }
            }
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [android.app.Activity, com.didi.hummer.utils.blankj.UtilsTransActivity] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onRequestPermissionsResult(com.didi.hummer.utils.blankj.UtilsTransActivity r1, int r2, java.lang.String[] r3, int[] r4) {
            /*
                r0 = this;
                r1.finish()
                com.didi.hummer.utils.blankj.PermissionUtils r2 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                if (r2 == 0) goto L_0x001a
                com.didi.hummer.utils.blankj.PermissionUtils r2 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                java.util.List r2 = r2.mPermissionsRequest
                if (r2 == 0) goto L_0x001a
                com.didi.hummer.utils.blankj.PermissionUtils r2 = com.didi.hummer.utils.blankj.PermissionUtils.sInstance
                r2.onRequestPermissionsResult(r1)
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.utils.blankj.PermissionUtils.PermissionActivityImpl.onRequestPermissionsResult(com.didi.hummer.utils.blankj.UtilsTransActivity, int, java.lang.String[], int[]):void");
        }

        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            utilsTransActivity.finish();
        }

        private void checkRequestCallback(int i) {
            if (i == 2) {
                if (PermissionUtils.sSimpleCallback4WriteSettings != null) {
                    if (PermissionUtils.isGrantedWriteSettings()) {
                        PermissionUtils.sSimpleCallback4WriteSettings.onGranted();
                    } else {
                        PermissionUtils.sSimpleCallback4WriteSettings.onDenied();
                    }
                    SimpleCallback unused = PermissionUtils.sSimpleCallback4WriteSettings = null;
                }
            } else if (i == 3 && PermissionUtils.sSimpleCallback4DrawOverlays != null) {
                if (PermissionUtils.isGrantedDrawOverlays()) {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onGranted();
                } else {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onDenied();
                }
                SimpleCallback unused2 = PermissionUtils.sSimpleCallback4DrawOverlays = null;
            }
        }
    }
}
