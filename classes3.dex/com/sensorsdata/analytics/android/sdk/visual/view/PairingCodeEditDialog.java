package com.sensorsdata.analytics.android.sdk.visual.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface;
import com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper;

public class PairingCodeEditDialog extends Dialog {
    private static final String TAG = "SA.PairingCodeEditDialog";
    /* access modifiers changed from: private */
    public Context mContext;

    public PairingCodeEditDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sensors_analytics_verification_code);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = dip2px(getContext(), 350.0f);
            window.setAttributes(attributes);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius((float) dip2px(getContext(), 7.0f));
            window.setBackgroundDrawable(gradientDrawable);
            window.setSoftInputMode(4);
        }
        final PairingCodeEditText pairingCodeEditText = (PairingCodeEditText) findViewById(R.id.sensors_analytics_pairing_code);
        pairingCodeEditText.setOnPairingCodeChangedListener(new IPairingCodeInterface.OnPairingCodeChangedListener() {
            public void onPairingCodeChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onInputCompleted(CharSequence charSequence) {
                if (TextUtils.isEmpty(charSequence)) {
                    SALog.i(PairingCodeEditDialog.TAG, "onCreate | dialog input content is null and return");
                } else {
                    new PairingCodeRequestHelper().verifyPairingCodeRequest(PairingCodeEditDialog.this.mContext, charSequence.toString(), new PairingCodeRequestHelper.IApiCallback() {
                        public void onSuccess() {
                            pairingCodeEditText.postDelayed(new Runnable() {
                                public void run() {
                                    pairingCodeEditText.hiddenKeyBord();
                                    PairingCodeEditDialog.this.dismiss();
                                }
                            }, 300);
                        }

                        public void onFailure(String str) {
                            pairingCodeEditText.clearText();
                            if (!TextUtils.isEmpty(str)) {
                                Toast.makeText(PairingCodeEditDialog.this.mContext, str, 1).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void show() {
        if (!isLiving()) {
            SALog.i(TAG, "Activity is finish");
            return;
        }
        SALog.i(TAG, "show:" + this.mContext);
        super.show();
    }

    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Context context = this.mContext;
            if ((context instanceof Activity) && isActivityFinishingOrDestroyed(context)) {
                SALog.i(TAG, "Activity is finish");
                return;
            }
        }
        if (isShowing()) {
            try {
                SALog.i(TAG, "isShowing() == true, dismiss");
                super.dismiss();
            } catch (IllegalArgumentException e) {
                SALog.printStackTrace(e);
            }
        }
    }

    private boolean isLiving() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity) || !isActivityFinishingOrDestroyed(context)) {
            return true;
        }
        return false;
    }

    private boolean isActivityFinishingOrDestroyed(Context context) {
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            SALog.i(TAG, "Activity is finish,name=" + activity.getClass().getName());
            return true;
        } else if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        } else {
            return false;
        }
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
