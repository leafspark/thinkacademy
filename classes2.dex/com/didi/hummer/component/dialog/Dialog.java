package com.didi.hummer.component.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.R;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerLayout;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaJustify;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

@Component("Dialog")
public class Dialog {
    @JsProperty("cancelable")
    public boolean cancelable = true;
    private Context context;
    private HummerLayout customContainer;
    private HMBase customView;
    private AlertDialog dialog;
    @JsProperty("lowLayer")
    public boolean lowLayer = false;

    public Dialog(Context context2) {
        this.context = context2;
    }

    private void setDialogLayer(AlertDialog alertDialog, boolean z) {
        if (z && alertDialog != null && alertDialog.getWindow() != null) {
            alertDialog.getWindow().setType(1);
        }
    }

    @JsMethod("alert")
    public void alert(String str, String str2, JSCallback jSCallback) {
        if (TextUtils.isEmpty(str2)) {
            str2 = this.context.getString(17039370);
        }
        AlertDialog create = new AlertDialog.Builder(this.context).setCancelable(this.cancelable).setMessage(str).setPositiveButton(str2, new Dialog$$ExternalSyntheticLambda0(jSCallback)).create();
        this.dialog = create;
        setDialogLayer(create, this.lowLayer);
        this.dialog.show();
        this.dialog.getButton(-1).setTextColor(-16777216);
    }

    static /* synthetic */ void lambda$alert$0(JSCallback jSCallback, DialogInterface dialogInterface, int i) {
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    @JsMethod("confirm")
    public void confirm(String str, String str2, String str3, String str4, JSCallback jSCallback, JSCallback jSCallback2) {
        if (TextUtils.isEmpty(str3)) {
            str3 = this.context.getString(17039370);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = this.context.getString(17039360);
        }
        AlertDialog create = new AlertDialog.Builder(this.context).setCancelable(this.cancelable).setTitle(str).setMessage(str2).setPositiveButton(str3, new Dialog$$ExternalSyntheticLambda1(jSCallback)).setNegativeButton(str4, new Dialog$$ExternalSyntheticLambda2(jSCallback2)).create();
        this.dialog = create;
        setDialogLayer(create, this.lowLayer);
        this.dialog.show();
        this.dialog.getButton(-1).setTextColor(-16777216);
        this.dialog.getButton(-2).setTextColor(-7829368);
    }

    static /* synthetic */ void lambda$confirm$1(JSCallback jSCallback, DialogInterface dialogInterface, int i) {
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    static /* synthetic */ void lambda$confirm$2(JSCallback jSCallback, DialogInterface dialogInterface, int i) {
        if (jSCallback != null) {
            jSCallback.call(new Object[0]);
        }
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
    }

    @JsMethod("loading")
    public void loading(String str) {
        View inflate = XMLParseInstrumentation.inflate(this.context, R.layout.loading_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(str);
        AlertDialog create = new AlertDialog.Builder(this.context, R.style.TransparentDialog).setCancelable(this.cancelable).setView(inflate).create();
        this.dialog = create;
        setDialogLayer(create, this.lowLayer);
        this.dialog.show();
    }

    @JsMethod("custom")
    public void custom(HMBase hMBase) {
        hMBase.getJSValue().protect();
        this.customView = hMBase;
        HummerLayout hummerLayout = this.customContainer;
        if (hummerLayout == null) {
            HummerLayout hummerLayout2 = new HummerLayout(this.context);
            this.customContainer = hummerLayout2;
            hummerLayout2.getYogaNode().setJustifyContent(YogaJustify.CENTER);
            this.customContainer.getYogaNode().setAlignItems(YogaAlign.CENTER);
        } else {
            hummerLayout.removeAllViews();
        }
        this.customContainer.addView(hMBase.getView());
        if (this.dialog == null) {
            AlertDialog create = new AlertDialog.Builder(this.context, R.style.TransparentDialog).setCancelable(this.cancelable).setView(this.customContainer).create();
            this.dialog = create;
            setDialogLayer(create, this.lowLayer);
        }
        this.dialog.show();
        if (this.dialog.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            this.dialog.getWindow().setAttributes(attributes);
        }
    }

    @JsMethod("dismiss")
    public void dismiss() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        HMBase hMBase = this.customView;
        if (hMBase != null) {
            hMBase.getJSValue().unprotect();
            this.customView = null;
        }
    }
}
