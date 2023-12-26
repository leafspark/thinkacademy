package com.tal.app.thinkacademy.business.home.main.dialog;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.business.home.databinding.DialogStoreLowWarnBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/dialog/StoreLowWarnDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/home/databinding/DialogStoreLowWarnBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "makeLinkClickable", "", "strBuilder", "Landroid/text/SpannableStringBuilder;", "span", "Landroid/text/style/URLSpan;", "setTextViewHTML", "text", "Landroid/widget/TextView;", "html", "", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StoreLowWarnDialog.kt */
public final class StoreLowWarnDialog extends BaseBindDialog<DialogStoreLowWarnBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoreLowWarnDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding.btnGoIt.setOnClickListener(new StoreLowWarnDialog$$ExternalSyntheticLambda0(this));
        String string = context.getString(R.string.hint_low_storage_space);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.hint_low_storage_space)");
        TextView textView = this.binding.tvDialogContent;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDialogContent");
        setTextViewHTML(textView, string);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m40_init_$lambda0(StoreLowWarnDialog storeLowWarnDialog, View view) {
        Intrinsics.checkNotNullParameter(storeLowWarnDialog, "this$0");
        storeLowWarnDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public DialogStoreLowWarnBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogStoreLowWarnBinding inflate = DialogStoreLowWarnBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    private final void makeLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new StoreLowWarnDialog$makeLinkClickable$clickable$1(this), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    private final void setTextViewHTML(TextView textView, String str) {
        Spanned fromHtml = Html.fromHtml(str);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(html)");
        CharSequence charSequence = fromHtml;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(uRLSpanArr, "urls");
        int length = uRLSpanArr.length;
        while (i < length) {
            URLSpan uRLSpan = uRLSpanArr[i];
            i++;
            makeLinkClickable(spannableStringBuilder, uRLSpan);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
