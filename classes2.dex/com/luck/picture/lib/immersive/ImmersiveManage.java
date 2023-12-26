package com.luck.picture.lib.immersive;

import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.request.target.Target;

public class ImmersiveManage {
    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            immersiveAboveAPI23(appCompatActivity, false, false, i, i2, z);
        }
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z, boolean z2, int i, int i2, boolean z3) {
        try {
            Window window = appCompatActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                window.setFlags(67108864, 67108864);
            } else if (Build.VERSION.SDK_INT >= 21) {
                boolean z4 = false;
                boolean z5 = true;
                if (z && z2) {
                    window.clearFlags(201326592);
                    if (i == 0) {
                        z4 = true;
                    }
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, true, true, z4, z3);
                    window.addFlags(Target.SIZE_ORIGINAL);
                } else if (!z && !z2) {
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    if (i != 0) {
                        z5 = false;
                    }
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, false, z5, z3);
                    window.addFlags(Target.SIZE_ORIGINAL);
                } else if (!z) {
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, true, i == 0, z3);
                    window.addFlags(Target.SIZE_ORIGINAL);
                } else {
                    return;
                }
                window.setStatusBarColor(i);
                window.setNavigationBarColor(i2);
            }
        } catch (Exception unused) {
        }
    }
}
