package com.tal.app.thinkcademy.lib.commui.watcher;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J*\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/watcher/LimitLengthTextWatcher;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "mMaxLength", "", "mEditText", "Landroid/widget/EditText;", "(ILandroid/widget/EditText;)V", "mContext", "Landroid/content/Context;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LimitLengthTextWatcher.kt */
public class LimitLengthTextWatcher implements ClearEditText.CustomTextWatcher {
    private final Context mContext;
    private final EditText mEditText;
    private final int mMaxLength;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public LimitLengthTextWatcher(int i, EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "mEditText");
        this.mMaxLength = i;
        this.mEditText = editText;
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mEditText.context");
        this.mContext = context;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNull(editable);
        if (editable.length() >= this.mMaxLength) {
            int selectionEnd = this.mEditText.getSelectionEnd();
            int i = this.mMaxLength;
            if (selectionEnd > i) {
                editable.delete(i, selectionEnd);
                ToastUtils.showShort(this.mContext.getString(R.string.max_letters, new Object[]{Integer.valueOf(this.mMaxLength)}), new Object[0]);
                return;
            }
            return;
        }
        this.mEditText.setEnabled(true);
    }
}
