package com.tal.app.thinkacademy.lib.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.lang.reflect.Field;

public final class ToastUtils {
    public static final int COLOR_DEFAULT = -16777217;
    private static final String NULL = "null";
    /* access modifiers changed from: private */
    public static IToast iToast = null;
    private static int sBgColor = -16777217;
    private static int sBgResource = -1;
    private static Field sField_TN = null;
    private static Field sField_TN_Handler = null;
    /* access modifiers changed from: private */
    public static int sGravity = -1;
    /* access modifiers changed from: private */
    public static int sMsgColor = -16777217;
    /* access modifiers changed from: private */
    public static int sMsgTextSize = -1;
    /* access modifiers changed from: private */
    public static int sXOffset = -1;
    /* access modifiers changed from: private */
    public static int sYOffset = -1;

    interface IToast {
        void cancel();

        View getView();

        void setDuration(int i);

        void setGravity(int i, int i2, int i3);

        void setText(int i);

        void setText(CharSequence charSequence);

        void setView(View view);

        void show();
    }

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setGravity(int i, int i2, int i3) {
        sGravity = i;
        sXOffset = i2;
        sYOffset = i3;
    }

    public static void setBgColor(int i) {
        sBgColor = i;
    }

    public static void setBgResource(int i) {
        sBgResource = i;
    }

    public static void setMsgColor(int i) {
        sMsgColor = i;
    }

    public static void setMsgTextSize(int i) {
        sMsgTextSize = i;
    }

    public static void showShort(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = NULL;
        }
        show(charSequence, 0);
    }

    public static void showShort(int i) {
        show(i, 0);
    }

    public static void showShort(int i, Object... objArr) {
        show(i, 0, objArr);
    }

    public static void showShort(String str, Object... objArr) {
        show(str, 0, objArr);
    }

    public static void showLong(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = NULL;
        }
        show(charSequence, 1);
    }

    public static void showLong(int i) {
        show(i, 1);
    }

    public static void showLong(int i, Object... objArr) {
        show(i, 1, objArr);
    }

    public static void showLong(String str, Object... objArr) {
        show(str, 1, objArr);
    }

    public static View showCustomShort(int i) {
        return showCustomShort(getView(i));
    }

    public static View showCustomShort(View view) {
        show(view, 0);
        return view;
    }

    public static View showCustomLong(int i) {
        return showCustomLong(getView(i));
    }

    public static View showCustomLong(View view) {
        show(view, 1);
        return view;
    }

    public static void cancel() {
        IToast iToast2 = iToast;
        if (iToast2 != null) {
            iToast2.cancel();
        }
    }

    static void initField() {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            sField_TN = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = sField_TN.getType().getDeclaredField("mHandler");
            sField_TN_Handler = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static void hook(Toast toast) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT > 23 && Build.VERSION.SDK_INT < 26) {
                z = true;
            }
            if (z) {
                if (sField_TN == null) {
                    initField();
                }
                Field field = sField_TN;
                if (field != null) {
                    Object obj = field.get(toast);
                    sField_TN_Handler.set(obj, new SafelyHandlerWarpper((Handler) sField_TN_Handler.get(obj)));
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void show(int i, int i2) {
        show(i, i2, null);
    }

    private static void show(int i, int i2, Object... objArr) {
        try {
            CharSequence text = Utils.getApp().getResources().getText(i);
            if (objArr != null && objArr.length > 0) {
                text = String.format(text.toString(), objArr);
            }
            show(text, i2);
        } catch (Exception unused) {
            show((CharSequence) String.valueOf(i), i2);
        }
    }

    private static void show(String str, int i, Object... objArr) {
        if (str == null) {
            str = NULL;
        } else if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        show((CharSequence) str, i);
    }

    private static void show(final CharSequence charSequence, final int i) {
        UtilsBridge.runOnUiThread(new Runnable() {
            public void run() {
                ToastUtils.cancel();
                if (Build.VERSION.SDK_INT >= 30) {
                    Toast makeText = Toast.makeText(Utils.getApp(), charSequence, i);
                    if (makeText != null) {
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                        return;
                    }
                    return;
                }
                IToast unused = ToastUtils.iToast = ToastFactory.makeToast(Utils.getApp(), charSequence, i);
                View view = ToastUtils.iToast.getView();
                if (view != null) {
                    TextView textView = (TextView) view.findViewById(16908299);
                    if (ToastUtils.sMsgColor != -16777217) {
                        textView.setTextColor(ToastUtils.sMsgColor);
                    }
                    if (ToastUtils.sMsgTextSize != -1) {
                        textView.setTextSize((float) ToastUtils.sMsgTextSize);
                    }
                    if (!(ToastUtils.sGravity == -1 && ToastUtils.sXOffset == -1 && ToastUtils.sYOffset == -1)) {
                        ToastUtils.iToast.setGravity(ToastUtils.sGravity, ToastUtils.sXOffset, ToastUtils.sYOffset);
                    }
                    ToastUtils.setBg(textView);
                    ToastUtils.iToast.show();
                }
            }
        });
    }

    private static void show(final View view, final int i) {
        UtilsBridge.runOnUiThread(new Runnable() {
            public void run() {
                ToastUtils.cancel();
                IToast unused = ToastUtils.iToast = ToastFactory.newToast(Utils.getApp());
                ToastUtils.iToast.setView(view);
                ToastUtils.iToast.setDuration(i);
                if (!(ToastUtils.sGravity == -1 && ToastUtils.sXOffset == -1 && ToastUtils.sYOffset == -1)) {
                    ToastUtils.iToast.setGravity(ToastUtils.sGravity, ToastUtils.sXOffset, ToastUtils.sYOffset);
                }
                ToastUtils.setBg();
                ToastUtils.iToast.show();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void setBg() {
        if (sBgResource != -1) {
            iToast.getView().setBackgroundResource(sBgResource);
        } else if (sBgColor != -16777217) {
            View view = iToast.getView();
            Drawable background = view.getBackground();
            if (background != null) {
                background.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
            } else if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(new ColorDrawable(sBgColor));
            } else {
                view.setBackgroundDrawable(new ColorDrawable(sBgColor));
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setBg(TextView textView) {
        if (sBgResource != -1) {
            iToast.getView().setBackgroundResource(sBgResource);
            textView.setBackgroundColor(0);
        } else if (sBgColor != -16777217) {
            View view = iToast.getView();
            Drawable background = view.getBackground();
            Drawable background2 = textView.getBackground();
            if (background != null && background2 != null) {
                background.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
                textView.setBackgroundColor(0);
            } else if (background != null) {
                background.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
            } else if (background2 != null) {
                background2.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
            } else {
                view.setBackgroundColor(sBgColor);
            }
        }
    }

    private static View getView(int i) {
        LayoutInflater layoutInflater = (LayoutInflater) Utils.getApp().getSystemService("layout_inflater");
        return !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
    }

    static class ToastFactory {
        ToastFactory() {
        }

        static IToast makeToast(Context context, CharSequence charSequence, int i) {
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled() || Build.VERSION.SDK_INT < 23 || UtilsBridge.isGrantedDrawOverlays()) {
                return new ToastWithoutNotification(makeNormalToast(context, charSequence, i));
            }
            return new SystemToast(makeNormalToast(context, charSequence, i));
        }

        static IToast newToast(Context context) {
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled() || Build.VERSION.SDK_INT < 23 || UtilsBridge.isGrantedDrawOverlays()) {
                return new ToastWithoutNotification(new Toast(context));
            }
            return new SystemToast(new Toast(context));
        }

        private static Toast makeNormalToast(Context context, CharSequence charSequence, int i) {
            Toast makeText = Toast.makeText(context, "", i);
            makeText.setText(charSequence);
            return makeText;
        }
    }

    static class SystemToast extends AbsToast {
        SystemToast(Toast toast) {
            super(toast);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(toast);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new SafeHandler((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        public void show() {
            this.mToast.show();
        }

        public void cancel() {
            this.mToast.cancel();
        }

        static class SafeHandler extends Handler {
            private Handler impl;

            SafeHandler(Handler handler) {
                this.impl = handler;
            }

            public void handleMessage(Message message) {
                AsynchronousInstrumentation.handlerMessageBegin(this, message);
                this.impl.handleMessage(message);
                AsynchronousInstrumentation.handlerMessageEnd();
            }

            public void dispatchMessage(Message message) {
                try {
                    this.impl.dispatchMessage(message);
                } catch (Exception e) {
                    Log.e("ToastUtils", e.toString());
                }
            }
        }
    }

    public static class SafelyHandlerWarpper extends Handler {
        private Handler impl;

        public SafelyHandlerWarpper(Handler handler) {
            this.impl = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Log.d("XESToastUtils", "dispatchMessage", e);
            }
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            try {
                this.impl.handleMessage(message);
            } catch (Exception e) {
                Log.d("XESToastUtils", "handleMessage", e);
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    static class ToastWithoutNotification extends AbsToast {
        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        private View mView;
        private WindowManager mWM;

        ToastWithoutNotification(Toast toast) {
            super(toast);
        }

        public void show() {
            UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    ToastWithoutNotification.this.realShow();
                }
            }, 300);
        }

        /* access modifiers changed from: private */
        public void realShow() {
            if (this.mToast != null) {
                View view = this.mToast.getView();
                this.mView = view;
                if (view != null) {
                    Context context = this.mToast.getView().getContext();
                    if (Build.VERSION.SDK_INT < 25) {
                        this.mWM = (WindowManager) context.getSystemService("window");
                        this.mParams.type = 2005;
                    } else if (UtilsBridge.isGrantedDrawOverlays()) {
                        this.mWM = (WindowManager) context.getSystemService("window");
                        if (Build.VERSION.SDK_INT >= 26) {
                            this.mParams.type = 2038;
                        } else {
                            this.mParams.type = LiveMessageCode.TRANSMISSION_TYPE_MEDIA_CONTROLLER;
                        }
                    } else {
                        Context topActivityOrApp = UtilsBridge.getTopActivityOrApp();
                        if (!(topActivityOrApp instanceof Activity)) {
                            Log.w("ToastUtils", "Couldn't get top Activity.");
                            new SystemToast(this.mToast).show();
                            return;
                        }
                        Activity activity = (Activity) topActivityOrApp;
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            Log.w("ToastUtils", activity + " is useless");
                            new SystemToast(this.mToast).show();
                            return;
                        }
                        this.mWM = activity.getWindowManager();
                        this.mParams.type = 99;
                        UtilsBridge.addActivityLifecycleCallbacks(activity, getActivityLifecycleCallbacks());
                    }
                    setToastParams();
                    try {
                        WindowManager windowManager = this.mWM;
                        if (windowManager != null) {
                            windowManager.addView(this.mView, this.mParams);
                        }
                    } catch (Exception unused) {
                    }
                    UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            ToastWithoutNotification.this.cancel();
                        }
                    }, this.mToast.getDuration() == 0 ? 2000 : 3500);
                }
            }
        }

        private void setToastParams() {
            this.mParams.height = -2;
            this.mParams.width = -2;
            this.mParams.format = -3;
            this.mParams.windowAnimations = 16973828;
            this.mParams.setTitle("ToastWithoutNotification");
            this.mParams.flags = 152;
            this.mParams.packageName = Utils.getApp().getPackageName();
            this.mParams.gravity = this.mToast.getGravity();
            if ((this.mParams.gravity & 7) == 7) {
                this.mParams.horizontalWeight = 1.0f;
            }
            if ((this.mParams.gravity & 112) == 112) {
                this.mParams.verticalWeight = 1.0f;
            }
            this.mParams.x = this.mToast.getXOffset();
            this.mParams.y = this.mToast.getYOffset();
            this.mParams.horizontalMargin = this.mToast.getHorizontalMargin();
            this.mParams.verticalMargin = this.mToast.getVerticalMargin();
        }

        private Utils.ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
            return new Utils.ActivityLifecycleCallbacks() {
                public void onActivityDestroyed(Activity activity) {
                    if (ToastUtils.iToast != null) {
                        activity.getWindow().getDecorView().setVisibility(8);
                        ToastUtils.iToast.cancel();
                    }
                }
            };
        }

        public void cancel() {
            try {
                WindowManager windowManager = this.mWM;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.mView);
                }
            } catch (Exception unused) {
            }
            this.mView = null;
            this.mWM = null;
            this.mToast = null;
        }
    }

    static abstract class AbsToast implements IToast {
        Toast mToast;

        AbsToast(Toast toast) {
            this.mToast = toast;
        }

        public void setView(View view) {
            this.mToast.setView(view);
        }

        public View getView() {
            return this.mToast.getView();
        }

        public void setDuration(int i) {
            this.mToast.setDuration(i);
        }

        public void setGravity(int i, int i2, int i3) {
            this.mToast.setGravity(i, i2, i3);
        }

        public void setText(int i) {
            this.mToast.setText(i);
        }

        public void setText(CharSequence charSequence) {
            this.mToast.setText(charSequence);
        }
    }
}
