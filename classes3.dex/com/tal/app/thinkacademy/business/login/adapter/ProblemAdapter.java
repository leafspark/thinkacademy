package com.tal.app.thinkacademy.business.login.adapter;

import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundTextView;
import com.flyco.roundview.RoundViewDelegate;
import com.tal.app.thinkacademy.business.login.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/ProblemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "mSelectPosition", "", "convert", "", "holder", "item", "setSelectPosition", "position", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProblemAdapter.kt */
public final class ProblemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int mSelectPosition = -1;

    public ProblemAdapter(List<String> list) {
        super(R.layout.layout_item_problem, list);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        RoundTextView view = baseViewHolder.getView(R.id.item_tv_descriptor);
        view.setText(str);
        RoundViewDelegate delegate = view.getDelegate();
        if (this.mSelectPosition == baseViewHolder.getLayoutPosition()) {
            delegate.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_fff9ec));
            view.setSelected(true);
            return;
        }
        view.setSelected(false);
        delegate.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_f8f8f9));
    }

    public final void setSelectPosition(int i) {
        this.mSelectPosition = i;
    }
}
