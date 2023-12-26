package com.adyen.checkout.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\fH\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/adyen/checkout/card/InstallmentListAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "installmentFilter", "Lcom/adyen/checkout/card/InstallmentFilter;", "installmentOptions", "", "Lcom/adyen/checkout/card/InstallmentModel;", "getCount", "", "getFilter", "Landroid/widget/Filter;", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setItems", "", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallmentListAdapter.kt */
public final class InstallmentListAdapter extends BaseAdapter implements Filterable {
    private final Context context;
    private final InstallmentFilter installmentFilter;
    private final List<InstallmentModel> installmentOptions;

    public long getItemId(int i) {
        return (long) i;
    }

    public InstallmentListAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        List<InstallmentModel> arrayList = new ArrayList<>();
        this.installmentOptions = arrayList;
        this.installmentFilter = new InstallmentFilter(context2, arrayList);
    }

    public final void setItems(List<InstallmentModel> list) {
        Intrinsics.checkNotNullParameter(list, "installmentOptions");
        this.installmentOptions.clear();
        this.installmentOptions.addAll(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.installmentOptions.size();
    }

    public InstallmentModel getItem(int i) {
        return this.installmentOptions.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        InstallmentViewHolder installmentViewHolder;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.context);
            int i2 = R.layout.installment_view;
            view = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "from(context).inflate(R.layout.installment_view, parent, false)");
            installmentViewHolder = new InstallmentViewHolder(view);
            view.setTag(installmentViewHolder);
        } else {
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.adyen.checkout.card.InstallmentViewHolder");
            installmentViewHolder = (InstallmentViewHolder) tag;
        }
        installmentViewHolder.bindItem(getItem(i));
        return view;
    }

    public Filter getFilter() {
        return this.installmentFilter;
    }
}
