package com.adyen.checkout.components.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public abstract class ClickableListRecyclerAdapter<ViewHolderT extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolderT> {
    static final String TAG = LogUtil.getTag();
    OnItemCLickedListener mOnItemCLickedListener;

    public interface OnItemCLickedListener {
        void onItemClicked(int i);
    }

    public void onBindViewHolder(final ViewHolderT viewholdert, int i) {
        viewholdert.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, ClickableListRecyclerAdapter.class);
                Logger.d(ClickableListRecyclerAdapter.TAG, "click");
                if (ClickableListRecyclerAdapter.this.mOnItemCLickedListener != null) {
                    ClickableListRecyclerAdapter.this.mOnItemCLickedListener.onItemClicked(viewholdert.getAdapterPosition());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setItemCLickListener(OnItemCLickedListener onItemCLickedListener) {
        this.mOnItemCLickedListener = onItemCLickedListener;
    }
}
