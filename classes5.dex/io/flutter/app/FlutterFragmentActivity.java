package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import io.flutter.app.FlutterActivityDelegate;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

@Deprecated
public class FlutterFragmentActivity extends FragmentActivity implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory {
    private final FlutterActivityDelegate delegate;
    private final FlutterActivityEvents eventDelegate;
    private final PluginRegistry pluginRegistry;
    private final FlutterView.Provider viewProvider;

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public void finish() {
        FlutterFragmentActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        FlutterFragmentActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        FlutterFragmentActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.flutter.app.FlutterFragmentActivity, io.flutter.app.FlutterActivityDelegate$ViewFactory, android.app.Activity] */
    public FlutterFragmentActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.delegate = flutterActivityDelegate;
        this.eventDelegate = flutterActivityDelegate;
        this.viewProvider = flutterActivityDelegate;
        this.pluginRegistry = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.viewProvider.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.pluginRegistry.hasPlugin(str);
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.pluginRegistry.valuePublishedByPlugin(str);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.pluginRegistry.registrarFor(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        FlutterFragmentActivity.super.onCreate(bundle);
        this.eventDelegate.onCreate(bundle);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.eventDelegate.onDestroy();
        FlutterFragmentActivity.super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.eventDelegate.onBackPressed()) {
            FlutterFragmentActivity.super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        FlutterFragmentActivity.super.onStart();
        this.eventDelegate.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ActivityInfo.stopActivity();
        this.eventDelegate.onStop();
        FlutterFragmentActivity.super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        FlutterFragmentActivity.super.onPause();
        this.eventDelegate.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        FlutterFragmentActivity.super.onPostResume();
        this.eventDelegate.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        FlutterFragmentActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        this.eventDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.eventDelegate.onActivityResult(i, i2, intent)) {
            FlutterFragmentActivity.super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        FlutterFragmentActivity.super.onNewIntent(intent);
        this.eventDelegate.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.eventDelegate.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        FlutterFragmentActivity.super.onTrimMemory(i);
        this.eventDelegate.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.eventDelegate.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        FlutterFragmentActivity.super.onConfigurationChanged(configuration);
        this.eventDelegate.onConfigurationChanged(configuration);
    }
}
