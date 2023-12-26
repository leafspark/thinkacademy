package com.luck.picture.lib.animators;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAnimationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean isFirstOnly = true;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private int mDuration = 250;
    private Interpolator mInterpolator = new LinearInterpolator();
    private int mLastPosition = -1;

    /* access modifiers changed from: protected */
    public abstract Animator[] getAnimators(View view);

    public BaseAnimationAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mAdapter = adapter;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.mAdapter.onCreateViewHolder(viewGroup, i);
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        BaseAnimationAdapter.super.registerAdapterDataObserver(adapterDataObserver);
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        BaseAnimationAdapter.super.unregisterAdapterDataObserver(adapterDataObserver);
        this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        BaseAnimationAdapter.super.onAttachedToRecyclerView(recyclerView);
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        BaseAnimationAdapter.super.onDetachedFromRecyclerView(recyclerView);
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        BaseAnimationAdapter.super.onViewAttachedToWindow(viewHolder);
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        BaseAnimationAdapter.super.onViewDetachedFromWindow(viewHolder);
        this.mAdapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        this.mAdapter.onBindViewHolder(viewHolder, i);
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!this.isFirstOnly || adapterPosition > this.mLastPosition) {
            for (Animator animator : getAnimators(viewHolder.itemView)) {
                animator.setDuration((long) this.mDuration).start();
                animator.setInterpolator(this.mInterpolator);
            }
            this.mLastPosition = adapterPosition;
            return;
        }
        ViewHelper.clear(viewHolder.itemView);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewRecycled(viewHolder);
        BaseAnimationAdapter.super.onViewRecycled(viewHolder);
    }

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setStartPosition(int i) {
        this.mLastPosition = i;
    }

    public void setFirstOnly(boolean z) {
        this.isFirstOnly = z;
    }

    public int getItemViewType(int i) {
        return this.mAdapter.getItemViewType(i);
    }

    public RecyclerView.Adapter<RecyclerView.ViewHolder> getWrappedAdapter() {
        return this.mAdapter;
    }

    public long getItemId(int i) {
        return this.mAdapter.getItemId(i);
    }
}
