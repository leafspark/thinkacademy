package com.tal.app.thinkacademy.lib.commui.filter;

import android.widget.TextView;
import com.tal.app.thinkacademy.lib.commui.filter.IFilterItem;
import java.util.List;

public class FilterItem<T extends IFilterItem> {
    private List<T> items;
    private T selectedItem;
    private TextView tvTitle;

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> list) {
        this.items = list;
    }

    public T getSelectedItem() {
        return this.selectedItem;
    }

    public void setSelectedItem(T t) {
        this.selectedItem = t;
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }

    public void setTvTitle(TextView textView) {
        this.tvTitle = textView;
    }
}
