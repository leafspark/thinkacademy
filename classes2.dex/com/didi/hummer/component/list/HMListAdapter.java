package com.didi.hummer.component.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.pool.ObjectPool;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerNode;

public class HMListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private JSCallback createCallback;
    private ObjectPool instanceManager;
    private int itemCount;
    /* access modifiers changed from: private */
    public Context mContext;
    private RecyclerView recyclerView;
    private JSCallback typeCallback;
    private JSCallback updateCallback;

    public HMListAdapter(Context context, ObjectPool objectPool) {
        this.mContext = context;
        this.instanceManager = objectPool;
    }

    public void destroy() {
        JSCallback jSCallback = this.typeCallback;
        if (jSCallback != null) {
            jSCallback.release();
        }
        JSCallback jSCallback2 = this.createCallback;
        if (jSCallback2 != null) {
            jSCallback2.release();
        }
        JSCallback jSCallback3 = this.updateCallback;
        if (jSCallback3 != null) {
            jSCallback3.release();
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        HMListAdapter.super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView2) {
        HMListAdapter.super.onDetachedFromRecyclerView(recyclerView2);
        this.recyclerView = null;
    }

    public int getItemViewType(int i) {
        JSCallback jSCallback = this.typeCallback;
        if (jSCallback == null) {
            return HMListAdapter.super.getItemViewType(i);
        }
        Object call = jSCallback.call(Integer.valueOf(i));
        if (call == null) {
            return HMListAdapter.super.getItemViewType(i);
        }
        return ((Number) call).intValue();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        JSCallback jSCallback = this.createCallback;
        if (jSCallback == null) {
            return new ViewHolder((HMBase) null);
        }
        Object call = jSCallback.call(Integer.valueOf(i));
        if (!(call instanceof JSValue)) {
            return new ViewHolder((HMBase) null);
        }
        JSValue jSValue = (JSValue) call;
        jSValue.protect();
        HMBase hMBase = (HMBase) this.instanceManager.get(jSValue.getLong("objID"));
        if (hMBase == null) {
            return new ViewHolder((HMBase) null);
        }
        return new ViewHolder(hMBase);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (this.updateCallback != null && viewHolder.getJSValue() != null) {
            this.updateCallback.call(Integer.valueOf(i), viewHolder.getJSValue());
        }
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setTypeCallback(JSCallback jSCallback) {
        this.typeCallback = jSCallback;
    }

    public void setCreateCallback(JSCallback jSCallback) {
        this.createCallback = jSCallback;
    }

    public void setUpdateCallback(JSCallback jSCallback) {
        this.updateCallback = jSCallback;
    }

    public void refresh(int i) {
        refresh(i, false);
    }

    public void refresh(int i, boolean z) {
        int i2 = this.itemCount;
        this.itemCount = i;
        if (!z || i <= i2) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(i2, i - i2);
        }
    }

    /* access modifiers changed from: private */
    public void setLayoutParams(View view) {
        view.setLayoutParams(ListUtil.isVertical(this.recyclerView.getLayoutManager()) ? new ViewGroup.LayoutParams(-1, -2) : new ViewGroup.LayoutParams(-2, -1));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private HMBase hmBase;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(HMBase hMBase) {
            super(hMBase == null ? new View(HMListAdapter.this.mContext) : hMBase.getView());
            HMListAdapter.this.setLayoutParams(this.itemView);
            this.hmBase = hMBase;
        }

        public JSValue getJSValue() {
            HMBase hMBase = this.hmBase;
            if (hMBase == null) {
                return null;
            }
            return hMBase.getJSValue();
        }

        public HummerNode getNode() {
            HMBase hMBase = this.hmBase;
            if (hMBase == null) {
                return null;
            }
            return hMBase.getNode();
        }
    }
}
