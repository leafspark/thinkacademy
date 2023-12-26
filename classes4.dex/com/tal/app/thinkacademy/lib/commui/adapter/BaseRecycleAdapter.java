package com.tal.app.thinkacademy.lib.commui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.List;

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter {
    protected Context mContext;
    protected List<T> mList;
    protected OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int i);
    }

    /* access modifiers changed from: protected */
    public abstract void bindItemView(BaseRecycleAdapter<T>.BaseHolder baseHolder, T t, int i);

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract BaseRecycleAdapter<T>.BaseHolder getViewholder(View view);

    public BaseRecycleAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void addAll(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 == null) {
            this.mList = list;
        } else {
            list2.addAll(list);
        }
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int layoutId = getLayoutId(i);
        return getViewholder(!(from instanceof LayoutInflater) ? from.inflate(layoutId, viewGroup, false) : XMLParseInstrumentation.inflate(from, layoutId, viewGroup, false), i);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId(int i) {
        return getLayoutId();
    }

    /* access modifiers changed from: protected */
    public BaseRecycleAdapter<T>.BaseHolder getViewholder(View view, int i) {
        return getViewholder(view);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        BaseHolder baseHolder = (BaseHolder) viewHolder;
        initItemClickListener(baseHolder);
        bindItemView(baseHolder, this.mList.get(i), i);
    }

    public int getItemCount() {
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void resetData(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    private void initItemClickListener(final BaseRecycleAdapter<T>.BaseHolder baseHolder) {
        if (this.onRecyclerViewItemClickListener != null) {
            baseHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, BaseRecycleAdapter.class);
                    int layoutPosition = baseHolder.getLayoutPosition();
                    if (layoutPosition != -1) {
                        BaseRecycleAdapter.this.onRecyclerViewItemClickListener.onItemClick(view, layoutPosition);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener2) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener2;
    }

    public class BaseHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: package-private */
        public void createItemView(View view) {
        }

        public BaseHolder(View view) {
            super(view);
            createItemView(view);
        }
    }

    public List<T> getList() {
        return this.mList;
    }

    public void setList(List<T> list) {
        this.mList = list;
    }
}
