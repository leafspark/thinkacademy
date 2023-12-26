package com.tal.app.thinkacademy.lib.commui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.List;

public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected List<T> mDatas;
    protected ItemViewDelegateManager mItemViewDelegateManager = new ItemViewDelegateManager();
    protected OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i);
    }

    /* access modifiers changed from: protected */
    public boolean isEnabled(int i) {
        return true;
    }

    public void onViewHolderCreated(ViewHolder viewHolder, View view) {
    }

    public MultiItemTypeAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mDatas = list;
    }

    public int getItemViewType(int i) {
        if (!useItemViewDelegateManager()) {
            return MultiItemTypeAdapter.super.getItemViewType(i);
        }
        return this.mItemViewDelegateManager.getItemViewType(this.mDatas.get(i), i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder createViewHolder = ViewHolder.createViewHolder(this.mContext, viewGroup, this.mItemViewDelegateManager.getItemViewDelegate(i).getItemViewLayoutId());
        onViewHolderCreated(createViewHolder, createViewHolder.getConvertView());
        setListener(viewGroup, createViewHolder, i);
        return createViewHolder;
    }

    public void convert(ViewHolder viewHolder, T t) {
        this.mItemViewDelegateManager.convert(viewHolder, t, viewHolder.getAdapterPosition());
    }

    /* access modifiers changed from: protected */
    public void setListener(ViewGroup viewGroup, final ViewHolder viewHolder, int i) {
        if (isEnabled(i)) {
            viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, MultiItemTypeAdapter.class);
                    if (MultiItemTypeAdapter.this.mOnItemClickListener != null) {
                        MultiItemTypeAdapter.this.mOnItemClickListener.onItemClick(view, viewHolder, viewHolder.getAdapterPosition());
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
            viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (MultiItemTypeAdapter.this.mOnItemClickListener == null) {
                        return false;
                    }
                    return MultiItemTypeAdapter.this.mOnItemClickListener.onItemLongClick(view, viewHolder, viewHolder.getAdapterPosition());
                }
            });
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        convert(viewHolder, this.mDatas.get(i));
    }

    public int getItemCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> getData() {
        return this.mDatas;
    }

    public void setData(List<T> list) {
        this.mDatas = list;
    }

    public void updateData(List<T> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public MultiItemTypeAdapter addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        this.mItemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public MultiItemTypeAdapter addItemViewDelegate(int i, ItemViewDelegate<T> itemViewDelegate) {
        this.mItemViewDelegateManager.addDelegate(i, itemViewDelegate);
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean useItemViewDelegateManager() {
        return this.mItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
