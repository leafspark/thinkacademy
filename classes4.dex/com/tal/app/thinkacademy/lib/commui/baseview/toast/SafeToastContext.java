package com.tal.app.thinkacademy.lib.commui.baseview.toast;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

final class SafeToastContext extends ContextWrapper {
    /* access modifiers changed from: private */
    public BadTokenListener badTokenListener;
    /* access modifiers changed from: private */
    public Toast toast;

    SafeToastContext(Context context, Toast toast2) {
        super(context);
        this.toast = toast2;
    }

    public Context getApplicationContext() {
        return new ApplicationContextWrapper(getBaseContext().getApplicationContext());
    }

    public void setBadTokenListener(BadTokenListener badTokenListener2) {
        this.badTokenListener = badTokenListener2;
    }

    private final class ApplicationContextWrapper extends ContextWrapper {
        private ApplicationContextWrapper(Context context) {
            super(context);
        }

        public Object getSystemService(String str) {
            if ("window".equals(str)) {
                return new WindowManagerWrapper((WindowManager) getBaseContext().getSystemService(str));
            }
            return super.getSystemService(str);
        }
    }

    private final class WindowManagerWrapper implements WindowManager {
        private static final String TAG = "WindowManagerWrapper";
        private final WindowManager base;

        private WindowManagerWrapper(WindowManager windowManager) {
            this.base = windowManager;
        }

        public Display getDefaultDisplay() {
            return this.base.getDefaultDisplay();
        }

        public void removeViewImmediate(View view) {
            this.base.removeViewImmediate(view);
        }

        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                this.base.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException unused) {
                if (SafeToastContext.this.badTokenListener != null) {
                    SafeToastContext.this.badTokenListener.onBadTokenCaught(SafeToastContext.this.toast);
                }
            } catch (Throwable unused2) {
            }
        }

        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.base.updateViewLayout(view, layoutParams);
        }

        public void removeView(View view) {
            this.base.removeView(view);
        }
    }
}
