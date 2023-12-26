package com.sameer.flutterstatusbarcolor.flutterstatusbarcolor;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sameer/flutterstatusbarcolor/flutterstatusbarcolor/FlutterStatusbarcolorPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroid/app/Activity;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToActivity", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "flutter_statusbarcolor_ns_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FlutterStatusbarcolorPlugin.kt */
public final class FlutterStatusbarcolorPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    private Activity activity;
    private MethodChannel channel;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.sameer.com/statusbar");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.activity == null) {
            result.success((Object) null);
            return;
        }
        String str = methodCall.method;
        if (str != null) {
            int i = 0;
            switch (str.hashCode()) {
                case -2014534886:
                    if (str.equals("getnavigationbarcolor")) {
                        if (Build.VERSION.SDK_INT >= 21 && (activity2 = this.activity) != null) {
                            i = activity2.getWindow().getNavigationBarColor();
                        }
                        result.success(Integer.valueOf(i));
                        return;
                    }
                    break;
                case -1238995452:
                    if (str.equals("setstatusbarcolor")) {
                        Object argument = methodCall.argument("color");
                        Intrinsics.checkNotNull(argument);
                        int intValue = ((Number) argument).intValue();
                        Object argument2 = methodCall.argument("animate");
                        Intrinsics.checkNotNull(argument2);
                        boolean booleanValue = ((Boolean) argument2).booleanValue();
                        if (Build.VERSION.SDK_INT >= 21) {
                            if (booleanValue) {
                                Activity activity6 = this.activity;
                                if (activity6 != null) {
                                    ValueAnimator ofArgb = ValueAnimator.ofArgb(new int[]{activity6.getWindow().getStatusBarColor(), intValue});
                                    ofArgb.addUpdateListener(new FlutterStatusbarcolorPlugin$$ExternalSyntheticLambda0(this));
                                    ofArgb.setDuration(300);
                                    ofArgb.start();
                                }
                            } else {
                                Activity activity7 = this.activity;
                                if (activity7 != null) {
                                    activity7.getWindow().setStatusBarColor(intValue);
                                }
                            }
                        }
                        result.success((Object) null);
                        return;
                    }
                    break;
                case -298842632:
                    if (str.equals("getstatusbarcolor")) {
                        if (Build.VERSION.SDK_INT >= 21 && (activity3 = this.activity) != null) {
                            i = activity3.getWindow().getStatusBarColor();
                        }
                        result.success(Integer.valueOf(i));
                        return;
                    }
                    break;
                case 521676070:
                    if (str.equals("setnavigationbarcolor")) {
                        Object argument3 = methodCall.argument("color");
                        Intrinsics.checkNotNull(argument3);
                        int intValue2 = ((Number) argument3).intValue();
                        Object argument4 = methodCall.argument("animate");
                        Intrinsics.checkNotNull(argument4);
                        boolean booleanValue2 = ((Boolean) argument4).booleanValue();
                        if (Build.VERSION.SDK_INT >= 21) {
                            if (booleanValue2) {
                                Activity activity8 = this.activity;
                                if (activity8 != null) {
                                    ValueAnimator ofArgb2 = ValueAnimator.ofArgb(new int[]{activity8.getWindow().getNavigationBarColor(), intValue2});
                                    ofArgb2.addUpdateListener(new FlutterStatusbarcolorPlugin$$ExternalSyntheticLambda1(this));
                                    ofArgb2.setDuration(300);
                                    ofArgb2.start();
                                }
                            } else {
                                Activity activity9 = this.activity;
                                if (activity9 != null) {
                                    activity9.getWindow().setNavigationBarColor(intValue2);
                                }
                            }
                        }
                        result.success((Object) null);
                        return;
                    }
                    break;
                case 1653519407:
                    if (str.equals("setnavigationbarwhiteforeground")) {
                        Boolean bool = (Boolean) methodCall.argument("whiteForeground");
                        if (bool != null) {
                            i = bool.booleanValue();
                        }
                        if (Build.VERSION.SDK_INT >= 26 && (activity4 = this.activity) != null) {
                            if (i != 0) {
                                activity4.getWindow().getDecorView().setSystemUiVisibility(activity4.getWindow().getDecorView().getSystemUiVisibility() & -17);
                            } else {
                                activity4.getWindow().getDecorView().setSystemUiVisibility(activity4.getWindow().getDecorView().getSystemUiVisibility() | 16);
                            }
                        }
                        result.success((Object) null);
                        return;
                    }
                    break;
                case 1890975629:
                    if (str.equals("setstatusbarwhiteforeground")) {
                        Object argument5 = methodCall.argument("whiteForeground");
                        Intrinsics.checkNotNull(argument5);
                        boolean booleanValue3 = ((Boolean) argument5).booleanValue();
                        if (Build.VERSION.SDK_INT >= 23 && (activity5 = this.activity) != null) {
                            if (booleanValue3) {
                                activity5.getWindow().getDecorView().setSystemUiVisibility(activity5.getWindow().getDecorView().getSystemUiVisibility() & -8193);
                            } else {
                                activity5.getWindow().getDecorView().setSystemUiVisibility(activity5.getWindow().getDecorView().getSystemUiVisibility() | 8192);
                            }
                        }
                        result.success((Object) null);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    /* access modifiers changed from: private */
    /* renamed from: onMethodCall$lambda-3$lambda-2  reason: not valid java name */
    public static final void m26onMethodCall$lambda3$lambda2(FlutterStatusbarcolorPlugin flutterStatusbarcolorPlugin, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(flutterStatusbarcolorPlugin, "this$0");
        Activity activity2 = flutterStatusbarcolorPlugin.activity;
        if (activity2 != null) {
            Window window = activity2.getWindow();
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            window.setStatusBarColor(((Integer) animatedValue).intValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onMethodCall$lambda-9$lambda-8  reason: not valid java name */
    public static final void m27onMethodCall$lambda9$lambda8(FlutterStatusbarcolorPlugin flutterStatusbarcolorPlugin, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(flutterStatusbarcolorPlugin, "this$0");
        Activity activity2 = flutterStatusbarcolorPlugin.activity;
        if (activity2 != null) {
            Window window = activity2.getWindow();
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            window.setNavigationBarColor(((Integer) animatedValue).intValue());
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.activity = activityPluginBinding.getActivity();
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.activity = activityPluginBinding.getActivity();
    }

    public void onDetachedFromActivity() {
        this.activity = null;
    }
}
