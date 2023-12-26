package com.tal.user.global.trade.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class TalTradeViewHolder extends RecyclerView.ViewHolder {
    private View convertView;
    private SparseArray<View> views = new SparseArray<>();

    public TalTradeViewHolder(View view) {
        super(view);
        this.convertView = view;
    }

    public <T extends View> T getView(int i) {
        T t = (View) this.views.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.convertView.findViewById(i);
        this.views.put(i, findViewById);
        return findViewById;
    }

    public TalTradeViewHolder setText(int i, String str) {
        ((TextView) getView(i)).setText(str);
        return this;
    }

    public View getConvertView() {
        return this.convertView;
    }
}
