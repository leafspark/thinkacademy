package com.tal.app.thinkacademy.business.study.study.ready;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/LimitInputTextWatcher;", "Landroid/text/TextWatcher;", "et", "Landroid/widget/EditText;", "btn", "Landroid/widget/TextView;", "close", "Landroid/widget/ImageView;", "(Landroid/widget/EditText;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "regex", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "DEFAULT_REGEX", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "charSequence", "", "i", "", "i1", "i2", "clearLimitStr", "str", "onTextChanged", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LimitInputTextWatcher.kt */
public final class LimitInputTextWatcher implements TextWatcher {
    private final String DEFAULT_REGEX = "[^a-zA-Z0-9一-龥 ]";
    private TextView btn;
    private ImageView close;
    private EditText et;
    private String regex;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    public LimitInputTextWatcher(EditText editText, TextView textView, ImageView imageView) {
        this.et = editText;
        this.btn = textView;
        this.close = imageView;
        this.regex = "[^a-zA-Z0-9一-龥 ]";
    }

    public LimitInputTextWatcher(EditText editText, String str) {
        Intrinsics.checkNotNullParameter(str, "regex");
        this.et = editText;
        this.regex = str;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        String obj = editable.toString();
        if (StringsKt.trim(obj).toString().length() == 0) {
            TextView textView = this.btn;
            if (textView != null) {
                textView.setAlpha(0.5f);
            }
            TextView textView2 = this.btn;
            if (textView2 != null) {
                textView2.setEnabled(false);
            }
            ImageView imageView = this.close;
            if (imageView != null) {
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView3 = this.btn;
        if (textView3 != null) {
            textView3.setAlpha(1.0f);
        }
        TextView textView4 = this.btn;
        if (textView4 != null) {
            textView4.setEnabled(true);
        }
        ImageView imageView2 = this.close;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        String clearLimitStr = clearLimitStr(this.regex, obj);
        EditText editText = this.et;
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
        editable.replace(0, editable.length(), clearLimitStr);
        EditText editText2 = this.et;
        if (editText2 != null) {
            editText2.addTextChangedListener(this);
        }
    }

    private final String clearLimitStr(String str, String str2) {
        return new Regex(str).replace(str2, "");
    }
}
