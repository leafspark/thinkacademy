package com.tal.user.global.trade.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public abstract class TalTradeBaseAdapter<T> extends RecyclerView.Adapter<TalTradeViewHolder> {
    private List<T> data = new ArrayList();
    private int layoutId;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(TalTradeViewHolder talTradeViewHolder, int i);
    }

    /* access modifiers changed from: protected */
    public abstract void convert(TalTradeViewHolder talTradeViewHolder, T t, int i) throws MalformedURLException;

    public TalTradeBaseAdapter(List<T> list, int i) {
        this.data = list;
        this.layoutId = i;
    }

    public TalTradeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = this.layoutId;
        TalTradeViewHolder talTradeViewHolder = new TalTradeViewHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
        setListener(talTradeViewHolder);
        return talTradeViewHolder;
    }

    public void onBindViewHolder(TalTradeViewHolder talTradeViewHolder, int i) {
        try {
            convert(talTradeViewHolder, this.data.get(i), i);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setListener(final TalTradeViewHolder talTradeViewHolder) {
        talTradeViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TalTradeBaseAdapter.class);
                if (TalTradeBaseAdapter.this.onItemClickListener != null) {
                    OnItemClickListener access$000 = TalTradeBaseAdapter.this.onItemClickListener;
                    TalTradeViewHolder talTradeViewHolder = talTradeViewHolder;
                    access$000.onItemClick(talTradeViewHolder, talTradeViewHolder.getAdapterPosition());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public int getItemCount() {
        return this.data.size();
    }

    public void updateData(List<T> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }
}
