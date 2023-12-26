package io.github.ponnamkarthik.toast.fluttertoast;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/github/ponnamkarthik/toast/fluttertoast/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mToast", "Landroid/widget/Toast;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "fluttertoast_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MethodCallHandlerImpl.kt */
public final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private Context context;
    /* access modifiers changed from: private */
    public Toast mToast;

    public MethodCallHandlerImpl(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        int i;
        Toast toast;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, Constant.PARAM_RESULT);
        String str = methodCall.method;
        View view = null;
        if (Intrinsics.areEqual(str, "showToast")) {
            String valueOf = String.valueOf(methodCall.argument("msg"));
            String valueOf2 = String.valueOf(methodCall.argument("length"));
            String valueOf3 = String.valueOf(methodCall.argument("gravity"));
            Number number = (Number) methodCall.argument("bgcolor");
            Number number2 = (Number) methodCall.argument("textcolor");
            Number number3 = (Number) methodCall.argument("fontSize");
            if (Intrinsics.areEqual(valueOf3, "top")) {
                i = 48;
            } else {
                i = Intrinsics.areEqual(valueOf3, "center") ? 17 : 80;
            }
            boolean areEqual = Intrinsics.areEqual(valueOf2, "long");
            if (number == null || Build.VERSION.SDK_INT > 31) {
                this.mToast = Toast.makeText(this.context, valueOf, areEqual ? 1 : 0);
                if (Build.VERSION.SDK_INT <= 31) {
                    try {
                        Toast toast2 = this.mToast;
                        if (toast2 != null) {
                            view = toast2.getView();
                        }
                        Intrinsics.checkNotNull(view);
                        View findViewById = view.findViewById(16908299);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "mToast?.view!!.findViewById(android.R.id.message)");
                        TextView textView = (TextView) findViewById;
                        if (number3 != null) {
                            textView.setTextSize(number3.floatValue());
                        }
                        if (number2 != null) {
                            textView.setTextColor(number2.intValue());
                        }
                    } catch (Exception unused) {
                    }
                }
            } else {
                Object systemService = this.context.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                LayoutInflater layoutInflater = (LayoutInflater) systemService;
                int i2 = R.layout.toast_custom;
                View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i2, (ViewGroup) null);
                TextView textView2 = (TextView) inflate.findViewById(R.id.text);
                textView2.setText(valueOf);
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.context.getDrawable(R.drawable.corner);
                    Intrinsics.checkNotNull(drawable);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …)!!\n                    }");
                } else {
                    drawable = this.context.getResources().getDrawable(R.drawable.corner);
                    Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …er)\n                    }");
                }
                drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
                textView2.setBackground(drawable);
                if (number3 != null) {
                    textView2.setTextSize(number3.floatValue());
                }
                if (number2 != null) {
                    textView2.setTextColor(number2.intValue());
                }
                Toast toast3 = new Toast(this.context);
                this.mToast = toast3;
                toast3.setDuration(areEqual);
                Toast toast4 = this.mToast;
                if (toast4 != null) {
                    toast4.setView(inflate);
                }
            }
            if (Build.VERSION.SDK_INT <= 31) {
                if (i == 17) {
                    Toast toast5 = this.mToast;
                    if (toast5 != null) {
                        toast5.setGravity(i, 0, 0);
                    }
                } else if (i != 48) {
                    Toast toast6 = this.mToast;
                    if (toast6 != null) {
                        toast6.setGravity(i, 0, 100);
                    }
                } else {
                    Toast toast7 = this.mToast;
                    if (toast7 != null) {
                        toast7.setGravity(i, 0, 100);
                    }
                }
            }
            Context context2 = this.context;
            if (context2 instanceof Activity) {
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context2).runOnUiThread(new MethodCallHandlerImpl$$ExternalSyntheticLambda0(this));
            } else {
                Toast toast8 = this.mToast;
                if (toast8 != null) {
                    toast8.show();
                }
            }
            if (Build.VERSION.SDK_INT >= 30 && (toast = this.mToast) != null) {
                toast.addCallback(new MethodCallHandlerImpl$onMethodCall$2(this));
            }
            result.success(true);
        } else if (Intrinsics.areEqual(str, Constant.PARAM_CANCEL)) {
            Toast toast9 = this.mToast;
            if (toast9 != null) {
                if (toast9 != null) {
                    toast9.cancel();
                }
                this.mToast = null;
            }
            result.success(true);
        } else {
            result.notImplemented();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onMethodCall$lambda-0  reason: not valid java name */
    public static final void m2onMethodCall$lambda0(MethodCallHandlerImpl methodCallHandlerImpl) {
        Intrinsics.checkNotNullParameter(methodCallHandlerImpl, "this$0");
        Toast toast = methodCallHandlerImpl.mToast;
        if (toast != null) {
            toast.show();
        }
    }
}
