package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

public final class EasyGlideApp {
    private EasyGlideApp() {
    }

    public static File getPhotoCacheDir(Context context) {
        return Glide.getPhotoCacheDir(context);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        return Glide.getPhotoCacheDir(context, str);
    }

    public static Glide get(Context context) {
        return Glide.get(context);
    }

    @Deprecated
    public static void init(Glide glide) {
        Glide.init(glide);
    }

    public static void init(Context context, GlideBuilder glideBuilder) {
        Glide.init(context, glideBuilder);
    }

    public static void enableHardwareBitmaps() {
        Glide.enableHardwareBitmaps();
    }

    public static void tearDown() {
        Glide.tearDown();
    }

    public static GlideRequests with(Context context) {
        return Glide.with(context);
    }

    public static GlideRequests with(Activity activity) {
        return Glide.with(activity);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity) {
        return Glide.with(fragmentActivity);
    }

    public static GlideRequests with(Fragment fragment) {
        return Glide.with(fragment);
    }

    @Deprecated
    public static GlideRequests with(android.app.Fragment fragment) {
        return Glide.with(fragment);
    }

    public static GlideRequests with(View view) {
        return Glide.with(view);
    }
}
