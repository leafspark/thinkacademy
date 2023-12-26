package atd.o0;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.adyen.threeds2.ProgressDialog;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public final class a implements ProgressDialog, DialogInterface.OnDismissListener {
    private AlertDialog a;
    private final DialogInterface.OnDismissListener b;

    public a(Activity activity, DialogInterface.OnDismissListener onDismissListener) {
        this.b = onDismissListener;
        LayoutInflater from = LayoutInflater.from(activity);
        int i = R.layout.a3ds2_widget_progress_dialog;
        AlertDialog create = new AlertDialog.Builder(activity, R.style.ThreeDS2Theme_ProgressDialog).setView(!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null)).setCancelable(false).create();
        this.a = create;
        create.setOnDismissListener(this);
    }

    public void hide() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (IllegalStateException unused) {
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a = null;
        this.b.onDismiss(dialogInterface);
    }

    public void show() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
