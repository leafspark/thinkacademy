package com.tal.app.thinkacademy.lib.commui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.List;

public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    /* access modifiers changed from: protected */
    public abstract void convert(ViewHolder viewHolder, T t, int i);

    public CommonAdapter(Context context, final int i, List<T> list) {
        super(context, list);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = i;
        this.mDatas = list;
        addItemViewDelegate(new ItemViewDelegate<T>() {
            public boolean isForViewType(T t, int i) {
                return true;
            }

            public int getItemViewLayoutId() {
                return i;
            }

            public void convert(ViewHolder viewHolder, T t, int i) {
                CommonAdapter.this.convert(viewHolder, t, i);
            }
        });
    }
}
