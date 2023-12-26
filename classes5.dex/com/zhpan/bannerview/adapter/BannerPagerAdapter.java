package com.zhpan.bannerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.zhpan.bannerview.holder.HolderCreator;
import com.zhpan.bannerview.holder.ViewHolder;
import com.zhpan.bannerview.utils.BannerUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BannerPagerAdapter<T, VH extends ViewHolder> extends PagerAdapter {
    public static final int MAX_VALUE = 500;
    private HolderCreator holderCreator;
    private boolean isCanLoop;
    private List<T> mList;
    /* access modifiers changed from: private */
    public PageClickListener mPageClickListener;

    public interface PageClickListener {
        void onPageClick(int i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public BannerPagerAdapter(List<T> list, HolderCreator<VH> holderCreator2) {
        ArrayList arrayList = new ArrayList();
        this.mList = arrayList;
        arrayList.addAll(list);
        this.holderCreator = holderCreator2;
    }

    public int getCount() {
        if (!this.isCanLoop || this.mList.size() <= 1) {
            return this.mList.size();
        }
        return 500;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = getView(viewGroup, BannerUtils.getRealPosition(this.isCanLoop, i, this.mList.size()));
        viewGroup.addView(view);
        return view;
    }

    private View getView(ViewGroup viewGroup, int i) {
        ViewHolder createViewHolder = this.holderCreator.createViewHolder();
        Objects.requireNonNull(createViewHolder, "Can not return a null holder");
        return createView(createViewHolder, i, viewGroup);
    }

    private View createView(ViewHolder<T> viewHolder, int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int layoutId = viewHolder.getLayoutId();
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(layoutId, viewGroup, false) : XMLParseInstrumentation.inflate(from, layoutId, viewGroup, false);
        List<T> list = this.mList;
        if (list != null && list.size() > 0) {
            setViewListener(inflate, i);
            viewHolder.onBind(inflate, this.mList.get(i), i, this.mList.size());
        }
        return inflate;
    }

    private void setViewListener(View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, BannerPagerAdapter.class);
                    if (BannerPagerAdapter.this.mPageClickListener != null) {
                        BannerPagerAdapter.this.mPageClickListener.onPageClick(i);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        BannerPagerAdapter.super.finishUpdate(viewGroup);
    }

    public void setPageClickListener(PageClickListener pageClickListener) {
        this.mPageClickListener = pageClickListener;
    }

    public void setCanLoop(boolean z) {
        this.isCanLoop = z;
    }

    public List<T> getList() {
        return this.mList;
    }

    public int getListSize() {
        return this.mList.size();
    }
}
