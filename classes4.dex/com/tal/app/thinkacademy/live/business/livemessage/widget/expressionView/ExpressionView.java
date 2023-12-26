package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.adapter.ExpressionAdapter;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.adapter.ExpressionViewPagerAdapter;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager.ExPressionEditDataInter;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager.ExpressionManager;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util.Expressions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressionView {
    private int displayWidth;
    protected EditText etChatTextInput;
    private ArrayList<String> filterExpressionId;
    private LinearLayout llExpressionPageSelect;
    private Context mContext;
    private AbstractBusinessDataCallBack mDataCallBack;
    private Map<Integer, ExpressionAllInfoEntity> mExpressionAllMap;
    public ExpressionManager mExpressionManager;
    private ViewPager mExpressionViewPager;
    private List<ExpressionAllInfoEntity> mLstExpressionAll;
    private RecyclerView mRvCustomList;
    private PagerAdapter mViewPagerAdapter;
    private View vExPressionView;

    public ExpressionView(Context context, View view, EditText editText, ExPressionEditDataInter exPressionEditDataInter, AbstractBusinessDataCallBack abstractBusinessDataCallBack) {
        this(context, view, editText, exPressionEditDataInter);
        this.mDataCallBack = abstractBusinessDataCallBack;
    }

    public ExpressionView(Context context, View view, EditText editText, ExPressionEditDataInter exPressionEditDataInter) {
        this.filterExpressionId = new ArrayList<String>() {
            {
                add("10003");
                add("10009");
                add("10010");
                add("10012");
                add("10013");
                add("10015");
                add("10022");
                add("10023");
                add("10025");
            }
        };
        this.mContext = context;
        this.vExPressionView = view;
        this.etChatTextInput = editText;
        this.displayWidth = ScreenUtils.getScreenMetrics().x;
        initView(this.vExPressionView, this.mContext, exPressionEditDataInter);
    }

    private void initView(View view, Context context, ExPressionEditDataInter exPressionEditDataInter) {
        this.llExpressionPageSelect = (LinearLayout) view.findViewById(R.id.ll_chat_expression_page_select);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.llExpressionPageSelect.getChildCount(); i++) {
            arrayList.add(this.llExpressionPageSelect.getChildAt(i));
        }
        this.mExpressionViewPager = view.findViewById(R.id.vp_chat_expression_view);
        this.mRvCustomList = view.findViewById(R.id.rv_chat_expression_customList);
        this.mExpressionManager = new ExpressionManager(context, this.mRvCustomList, exPressionEditDataInter);
        initExpressionData(arrayList);
    }

    private void initExpressionData(List<View> list) {
        this.mExpressionManager.setPageDots(list);
        this.mExpressionManager.setInitExpressionData();
        this.mLstExpressionAll = this.mExpressionManager.getExpressionAllList();
        this.mExpressionAllMap = this.mExpressionManager.getExpressionAllMap();
    }

    public List<ExpressionAllInfoEntity> getExpressionAllInfoList() {
        return this.mLstExpressionAll;
    }

    public Map<Integer, ExpressionAllInfoEntity> getExPressionMap() {
        return this.mExpressionAllMap;
    }

    public void loadPagerData(ExpressionAdapter expressionAdapter) {
        ArrayList<ExpressionInfoEntity> arrayList = new ArrayList<>();
        if (this.mLstExpressionAll.size() > 1) {
            for (ExpressionInfoEntity next : this.mLstExpressionAll.get(1).getExpressionInfoList()) {
                if (this.filterExpressionId.contains(next.getExpressionId())) {
                    arrayList.add(next);
                }
            }
            for (ExpressionInfoEntity remove : arrayList) {
                this.mLstExpressionAll.get(1).getExpressionInfoList().remove(remove);
            }
        }
        ExpressionViewPagerAdapter expressionViewPagerAdapter = new ExpressionViewPagerAdapter(this.mContext, this.mExpressionManager.mViews(), this.mLstExpressionAll, this);
        this.mViewPagerAdapter = expressionViewPagerAdapter;
        this.mExpressionViewPager.setAdapter(expressionViewPagerAdapter);
        this.mExpressionViewPager.setCurrentItem(0);
        this.mViewPagerAdapter.notifyDataSetChanged();
        this.mRvCustomList.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.mRvCustomList.setAdapter(expressionAdapter);
        expressionAdapter.notifyDataSetChanged();
        this.etChatTextInput.setTag(0);
        this.mExpressionManager.traversalDotNum(this.mLstExpressionAll);
        this.mExpressionViewPager.setOnPageChangeListener(this.mExpressionManager.getPageLinster());
    }

    public void bootomImageClick(ImageView imageView, int i) {
        this.etChatTextInput.setTag(Integer.valueOf(i));
        this.mExpressionViewPager.setCurrentItem(getCardIndexPos(i));
    }

    public void clickGridItem(int i, int i2, String str, int i3, String str2, int i4, int i5) {
        AbstractBusinessDataCallBack abstractBusinessDataCallBack;
        if (i2 == Expressions.exPressionCatogary) {
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                return;
            }
            if (i == 6) {
                deleteChatTextInput();
                return;
            }
            Bitmap decodeResource = BitmapFactoryInstrumentation.decodeResource(context.getResources(), i3);
            Context context2 = this.mContext;
            int i6 = this.displayWidth;
            ImageSpan imageSpan = new ImageSpan(context2, Bitmap.createScaledBitmap(decodeResource, i6 / 16, i6 / 16, true));
            SpannableString spannableString = new SpannableString(str2.substring(1, str2.length() - 1));
            spannableString.setSpan(imageSpan, 0, str2.length() - 2, 33);
            this.etChatTextInput.getEditableText().insert(this.etChatTextInput.getSelectionStart(), spannableString);
        } else if (i2 == Expressions.exGifCatogary && (abstractBusinessDataCallBack = this.mDataCallBack) != null) {
            abstractBusinessDataCallBack.onDataSucess(str, Integer.valueOf(i5));
        }
    }

    /* access modifiers changed from: protected */
    public void deleteChatTextInput() {
        this.etChatTextInput.onKeyDown(67, new KeyEvent(0, 67));
    }

    public int getCardIndexPos(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.mLstExpressionAll.get(i3).getPageNum();
        }
        return i2;
    }

    public LinearLayout getPageSelected() {
        return this.llExpressionPageSelect;
    }

    public ViewPager getViewPager() {
        return this.mExpressionViewPager;
    }

    public PagerAdapter getExpressionViewPagerAdapter() {
        return this.mViewPagerAdapter;
    }

    public RecyclerView getmHlvCustomList() {
        return this.mRvCustomList;
    }

    public void show() {
        getPageSelected().setVisibility(0);
        getViewPager().setVisibility(0);
        getmHlvCustomList().setVisibility(0);
    }

    public void hide() {
        getPageSelected().setVisibility(8);
        getViewPager().setVisibility(8);
        getmHlvCustomList().setVisibility(8);
    }
}
