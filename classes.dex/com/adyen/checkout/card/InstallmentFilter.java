package com.adyen.checkout.card;

import android.content.Context;
import android.widget.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0014J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/adyen/checkout/card/InstallmentFilter;", "Landroid/widget/Filter;", "context", "Landroid/content/Context;", "installmentOptions", "", "Lcom/adyen/checkout/card/InstallmentModel;", "(Landroid/content/Context;Ljava/util/List;)V", "convertResultToString", "", "resultValue", "", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "publishResults", "", "results", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentListAdapter.kt */
public final class InstallmentFilter extends Filter {
    private final Context context;
    private final List<InstallmentModel> installmentOptions;

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
    }

    public InstallmentFilter(Context context2, List<InstallmentModel> list) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "installmentOptions");
        this.context = context2;
        this.installmentOptions = list;
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = this.installmentOptions;
        filterResults.count = this.installmentOptions.size();
        return filterResults;
    }

    public CharSequence convertResultToString(Object obj) {
        String str = null;
        InstallmentModel installmentModel = obj instanceof InstallmentModel ? (InstallmentModel) obj : null;
        if (installmentModel != null) {
            str = InstallmentUtils.INSTANCE.getTextForInstallmentOption(this.context, installmentModel);
        }
        if (str == null) {
            str = "";
        }
        return str;
    }
}
