package com.tal.app.thinkacademy.business.login.view;

import android.text.Editable;
import android.widget.EditText;
import com.tal.app.thinkcademy.lib.commui.watcher.LimitLengthTextWatcher;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/AddStudentActivity$setViewValues$1", "Lcom/tal/app/thinkcademy/lib/commui/watcher/LimitLengthTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentActivity.kt */
public final class AddStudentActivity$setViewValues$1 extends LimitLengthTextWatcher {
    final /* synthetic */ AddStudentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddStudentActivity$setViewValues$1(AddStudentActivity addStudentActivity, int i, ClearEditText clearEditText) {
        super(i, (EditText) clearEditText);
        this.this$0 = addStudentActivity;
        Intrinsics.checkNotNullExpressionValue(clearEditText, "etNickname");
    }

    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
        boolean z = false;
        if (editable != null && editable.length() == 0) {
            z = true;
        }
        if (z) {
            this.this$0.setDisplayNameHint();
        }
    }
}
