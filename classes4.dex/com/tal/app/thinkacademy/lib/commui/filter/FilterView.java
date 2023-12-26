package com.tal.app.thinkacademy.lib.commui.filter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.adapter.CommonAdapter;
import com.tal.app.thinkacademy.lib.commui.adapter.ViewHolder;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkcademy.lib.commui.widget.TriangleUtilKt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FilterView extends LinearLayout {
    /* access modifiers changed from: private */
    public CommonAdapter<? extends IFilterItem> commonAdapter;
    /* access modifiers changed from: private */
    public String curExpandTitle;
    public List<FilterEntity> data;
    private OnSelectListener listener;
    private LinearLayout llTitles;
    private Map<String, FilterItem> mapData;
    private RecyclerView rvItems;
    private Set<String> setIgnore;
    private View vPannel;

    public interface OnSelectListener<E extends IFilterItem> {
        void onSelect(String str, E e);
    }

    public FilterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FilterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mapData = new HashMap();
        initView();
    }

    public void hidePannel() {
        this.vPannel.setVisibility(8);
        if (!TextUtils.isEmpty(this.curExpandTitle)) {
            setTriangle(this.mapData.get(this.curExpandTitle).getTvTitle(), this.mapData.get(this.curExpandTitle).getSelectedItem() != null && !this.setIgnore.contains(this.mapData.get(this.curExpandTitle).getSelectedItem().getName()), false);
        }
        this.curExpandTitle = "";
    }

    public void setData(List<FilterEntity> list) {
        if (list != null && list.size() != 0) {
            this.setIgnore = new HashSet();
            this.data = list;
            for (int i = 1; i < this.llTitles.getChildCount(); i++) {
                this.llTitles.removeViewAt(i);
            }
            this.mapData.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).getItems().size() != 0) {
                    FilterItem filterItem = new FilterItem();
                    filterItem.setItems(list.get(i2).getItems());
                    this.setIgnore.add(((IFilterItem) list.get(i2).getItems().get(0)).getName());
                    TextView titleView = getTitleView(list.get(i2).getTitle());
                    filterItem.setTvTitle(titleView);
                    this.mapData.put(list.get(i2).getTitle(), filterItem);
                    this.llTitles.addView(titleView);
                }
            }
            OnSelectListener onSelectListener = this.listener;
            this.listener = null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                onSelect(list.get(i3).getTitle(), (IFilterItem) list.get(i3).getItems().get(0));
            }
            this.listener = onSelectListener;
        }
    }

    public void setListener(OnSelectListener onSelectListener) {
        this.listener = onSelectListener;
    }

    /* access modifiers changed from: private */
    public void showPannel(String str) {
        String str2 = this.curExpandTitle;
        hidePannel();
        if (!str.equals(str2)) {
            this.curExpandTitle = str;
            this.commonAdapter.setData(this.mapData.get(str).getItems());
            this.commonAdapter.notifyDataSetChanged();
            setTriangle(this.mapData.get(str).getTvTitle(), this.mapData.get(str).getSelectedItem() != null && !this.setIgnore.contains(this.mapData.get(str).getSelectedItem().getName()), true);
            this.vPannel.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void onSelect(String str, IFilterItem iFilterItem) {
        if (this.mapData.get(str).getSelectedItem() == null || !TextUtils.equals(this.mapData.get(str).getSelectedItem().getName(), iFilterItem.getName())) {
            iFilterItem.isSelect = true;
            OnSelectListener onSelectListener = this.listener;
            if (onSelectListener != null) {
                onSelectListener.onSelect(str, iFilterItem);
            }
            this.mapData.get(str).setSelectedItem(iFilterItem);
            this.mapData.get(str).getTvTitle().setText(iFilterItem.getName());
            if (!this.setIgnore.contains(iFilterItem.getName())) {
                this.mapData.get(str).getTvTitle().setTextColor(-22006);
            } else {
                this.mapData.get(str).getTvTitle().setText(str);
                this.mapData.get(str).getTvTitle().setTextColor(-13421773);
            }
            CommonAdapter<? extends IFilterItem> commonAdapter2 = this.commonAdapter;
            if (commonAdapter2 != null) {
                commonAdapter2.notifyDataSetChanged();
            }
        }
        hidePannel();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < this.llTitles.getChildCount(); i++) {
            this.llTitles.getChildAt(i).setEnabled(z);
        }
    }

    private void initView() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.layout_filter_view;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i, this, true);
        } else {
            XMLParseInstrumentation.inflate(from, i, this, true);
        }
        this.vPannel = findViewById(R.id.ll_filter_pannel);
        this.rvItems = findViewById(R.id.rv_filter_items);
        this.llTitles = (LinearLayout) findViewById(R.id.ll_filter_titles);
        this.vPannel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, FilterView.class);
                FilterView.this.hidePannel();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.rvItems.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.commonAdapter = new CommonAdapter<IFilterItem>(getContext(), R.layout.item_filter_view, (List) null) {
            /* access modifiers changed from: protected */
            public void convert(ViewHolder viewHolder, final IFilterItem iFilterItem, int i) {
                ((TextView) viewHolder.getConvertView()).setText(iFilterItem.getName());
                viewHolder.getConvertView().setBackgroundResource(iFilterItem.isSelect ? R.drawable.shape_corners_20_ffaa0a : R.drawable.shape_corners_20_f9f9f9);
                ((TextView) viewHolder.getConvertView()).setTextColor(iFilterItem.isSelect ? FilterView.this.getResources().getColor(R.color.white) : Color.parseColor("#333333"));
                viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MethodInfo.onClickEventEnter(view, FilterView.class);
                        for (IFilterItem iFilterItem : FilterView.this.commonAdapter.getData()) {
                            if (!TextUtils.equals(iFilterItem.getName(), iFilterItem.getName())) {
                                iFilterItem.isSelect = false;
                            }
                        }
                        FilterView.this.onSelect(FilterView.this.curExpandTitle, iFilterItem);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        MethodInfo.onClickEventEnd();
                    }
                });
            }
        };
        this.rvItems.addItemDecoration(new Devider());
        this.rvItems.setAdapter(this.commonAdapter);
    }

    private List<FilterEntity> getData() {
        return this.data;
    }

    private TextView getTitleView(final String str) {
        TextView textView = new TextView(getContext());
        textView.setTextColor(-13421773);
        textView.setTextSize(1, 14.0f);
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, FilterView.class);
                FilterView.this.showPannel(str);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        setTriangle(textView, false, false);
        textView.setPadding(0, 0, SizeUtils.dp2px(6.0f), 0);
        return textView;
    }

    private class Devider extends RecyclerView.ItemDecoration {
        private Devider() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int i;
            recyclerView.getChildAdapterPosition(view);
            if (recyclerView.getAdapter() != null) {
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (itemCount >= 3) {
                    i = ((((recyclerView.getMeasuredWidth() - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) - (SizeUtils.dp2px(106.0f) * itemCount)) / (itemCount - 1)) / 2;
                } else {
                    i = SizeUtils.dp2px(16.0f);
                }
                rect.left = i;
                rect.right = i;
            }
        }
    }

    private void setTriangle(TextView textView, boolean z, boolean z2) {
        int parseColor = Color.parseColor(z ? "#ffaa0a" : "#333333");
        int dp2px = SizeUtils.dp2px(6.0f);
        int dp2px2 = SizeUtils.dp2px(4.0f);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(TriangleUtilKt.getTriangle(dp2px, dp2px2, parseColor, !z2));
        Rect rect = new Rect();
        rect.left = SizeUtils.dp2px(5.0f);
        rect.right = rect.left + dp2px;
        rect.top = SizeUtils.dp2px(1.0f);
        rect.bottom = rect.top + dp2px2;
        bitmapDrawable.setBounds(rect);
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, bitmapDrawable, (Drawable) null);
    }
}
