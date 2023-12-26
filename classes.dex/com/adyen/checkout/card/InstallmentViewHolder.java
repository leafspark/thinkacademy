package com.adyen.checkout.card;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adyen/checkout/card/InstallmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "installmentTextView", "Landroid/widget/TextView;", "bindItem", "", "installmentModel", "Lcom/adyen/checkout/card/InstallmentModel;", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentListAdapter.kt */
public final class InstallmentViewHolder extends RecyclerView.ViewHolder {
    private final TextView installmentTextView;
    private final View rootView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstallmentViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.rootView = view;
        View findViewById = view.findViewById(R.id.textView_installmentOption);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.textView_installmentOption)");
        this.installmentTextView = (TextView) findViewById;
    }

    public final void bindItem(InstallmentModel installmentModel) {
        Intrinsics.checkNotNullParameter(installmentModel, "installmentModel");
        TextView textView = this.installmentTextView;
        InstallmentUtils installmentUtils = InstallmentUtils.INSTANCE;
        Context context = this.rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        textView.setText(installmentUtils.getTextForInstallmentOption(context, installmentModel));
    }
}
