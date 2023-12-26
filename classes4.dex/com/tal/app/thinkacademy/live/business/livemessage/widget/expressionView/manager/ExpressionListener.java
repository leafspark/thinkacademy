package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager;

import android.graphics.Color;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import java.util.List;

public class ExpressionListener implements ViewPager.OnPageChangeListener {
    private int currentItem;
    private List<View> dots;
    private View mCurrentGif;
    private List<ExpressionAllInfoEntity> mExpressionAllList;
    private View mOldCurrentGif;
    private RecyclerView mRvCustomList;
    private int oldPage = 0;
    private int oldPosition = 0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public ExpressionListener(int i, List<ExpressionAllInfoEntity> list, List<View> list2, RecyclerView recyclerView) {
        this.currentItem = i;
        this.mExpressionAllList = list;
        this.dots = list2;
        this.mRvCustomList = recyclerView;
        int pageNum = list.get(0).getPageNum();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            if (i2 < pageNum) {
                list2.get(i2).setVisibility(0);
            } else {
                list2.get(i2).setVisibility(8);
            }
        }
    }

    public void onPageSelected(int i) {
        this.currentItem = i;
        int pageIndex = getPageIndex(i, this.mExpressionAllList);
        int pageNum = this.mExpressionAllList.get(pageIndex).getPageNum();
        for (int i2 = 0; i2 < this.dots.size(); i2++) {
            if (i2 < pageNum) {
                this.dots.get(i2).setVisibility(0);
            } else {
                this.dots.get(i2).setVisibility(8);
            }
        }
        if (this.oldPage != pageIndex) {
            this.mCurrentGif = this.mRvCustomList.getChildAt(pageIndex);
            this.mOldCurrentGif = this.mRvCustomList.getChildAt(this.oldPage);
            this.mCurrentGif.setBackgroundColor(Color.parseColor("#ffffff"));
            this.mOldCurrentGif.setBackgroundColor(0);
        }
        this.dots.get(this.oldPosition).setBackgroundResource(R.drawable.ic_page_unfocused);
        try {
            this.dots.get(getdotNumPositon(i, this.mExpressionAllList)).setBackgroundResource(R.drawable.shape_oval_black);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oldPosition = getdotNumPositon(i, this.mExpressionAllList);
        this.oldPage = pageIndex;
    }

    public int getPageIndex(int i, List<ExpressionAllInfoEntity> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += list.get(i3).getPageNum();
            if (i < i2) {
                return i3;
            }
        }
        return 0;
    }

    public int getdotNumPositon(int i, List<ExpressionAllInfoEntity> list) {
        int pageIndex = getPageIndex(i, list);
        for (int i2 = 0; i2 < pageIndex; i2++) {
            i -= this.mExpressionAllList.get(i2).getPageNum();
        }
        return i;
    }
}
