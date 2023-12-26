package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.ExpressionView;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util.Expressions;
import java.util.ArrayList;
import java.util.List;

public class ExpressionViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ExpressionAllInfoEntity> mExpressionAllInfoEntities;
    /* access modifiers changed from: private */
    public ExpressionView mExpressionView;
    private List<View> views;

    public void finishUpdate(View view) {
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(View view) {
    }

    public ExpressionViewPagerAdapter(Context context, List<View> list, List<ExpressionAllInfoEntity> list2, ExpressionView expressionView) {
        this.mContext = context;
        this.views = list;
        this.mExpressionAllInfoEntities = list2;
        this.mExpressionView = expressionView;
    }

    public int getCount() {
        List<View> list = this.views;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.views.get(i));
    }

    public int getPageIndex(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.mExpressionAllInfoEntities.size(); i3++) {
            i2 += this.mExpressionAllInfoEntities.get(i3).getPageNum();
            if (i < i2) {
                return i3;
            }
        }
        return 0;
    }

    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.views.get(i));
        GridView gridView = (GridView) this.views.get(i).findViewById(R.id.gv_chat_expression);
        ArrayList arrayList = new ArrayList();
        int i2 = getdotNumPositon(i, this.mExpressionAllInfoEntities);
        ExpressionAllInfoEntity expressionAllInfoEntity = this.mExpressionAllInfoEntities.get(getPageIndex(i));
        if (expressionAllInfoEntity.getCatogaryId() == Expressions.exPressionCatogary) {
            for (int expressionNum = expressionAllInfoEntity.getExpressionNum() * i2; expressionNum < Math.min((i2 + 1) * expressionAllInfoEntity.getExpressionNum(), expressionAllInfoEntity.getExpressionInfoList().size()); expressionNum++) {
                arrayList.add(expressionAllInfoEntity.getExpressionInfoList().get(expressionNum));
            }
        } else if (expressionAllInfoEntity.getCatogaryId() == Expressions.exGifCatogary) {
            for (int expressionNum2 = expressionAllInfoEntity.getExpressionNum() * i2; expressionNum2 < Math.min((i2 + 1) * expressionAllInfoEntity.getExpressionNum(), expressionAllInfoEntity.getExpressionInfoList().size()); expressionNum2++) {
                arrayList.add(expressionAllInfoEntity.getExpressionInfoList().get(expressionNum2));
            }
        }
        final ExpressionGridAdapter expressionGridAdapter = new ExpressionGridAdapter(this.mContext, arrayList, expressionAllInfoEntity);
        gridView.setAdapter(expressionGridAdapter);
        expressionGridAdapter.notifyDataSetChanged();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MethodInfo.onItemClickEnter(adapterView, i, ExpressionViewPagerAdapter.class);
                ExpressionViewPagerAdapter.this.track_click_emoticons();
                ExpressionInfoEntity expressionInfoEntity = expressionGridAdapter.getData().get(i);
                String expressionId = expressionInfoEntity.getExpressionId();
                int exPressionUrl = expressionInfoEntity.getExPressionUrl();
                String expressionUrlName = expressionInfoEntity.getExpressionUrlName();
                int expressionGifUrl = expressionInfoEntity.getExpressionGifUrl();
                int catogaryId = expressionGridAdapter.getDatas().getCatogaryId();
                int bottomImageId = expressionGridAdapter.getDatas().getBottomImageId();
                if (ExpressionViewPagerAdapter.this.mExpressionView != null) {
                    ExpressionViewPagerAdapter.this.mExpressionView.clickGridItem(i, catogaryId, expressionId, exPressionUrl, expressionUrlName, expressionGifUrl, bottomImageId);
                }
                SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
                MethodInfo.onItemClickEnd();
            }
        });
        return this.views.get(i);
    }

    public int getdotNumPositon(int i, List<ExpressionAllInfoEntity> list) {
        int pageIndexs = getPageIndexs(i, list);
        for (int i2 = 0; i2 < pageIndexs; i2++) {
            i -= list.get(i2).getPageNum();
        }
        return i;
    }

    public int getPageIndexs(int i, List<ExpressionAllInfoEntity> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += list.get(i3).getPageNum();
            if (i < i2) {
                return i3;
            }
        }
        return 0;
    }

    public void track_click_emoticons() {
        LeanplumUtil.commonTrack(LeanplumUtil.click_emoticons, LeanplumUtil.trackMap());
    }
}
