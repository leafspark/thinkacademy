package com.tal.app.thinkacademy.lib.commui.refresh;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegate;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;
import com.tal.app.thinkacademy.lib.commui.R;

public class RefreshLayoutManager {
    public static void confRefreshLayout() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            public void initialize(Context context, RefreshLayout refreshLayout) {
                refreshLayout.setEnableAutoLoadMore(true);
                refreshLayout.setEnableOverScrollDrag(false);
                refreshLayout.setEnableOverScrollBounce(true);
                refreshLayout.setEnableLoadMoreWhenContentNotFull(true);
                refreshLayout.setEnableScrollContentWhenRefreshed(true);
                refreshLayout.setPrimaryColorsId(new int[]{R.color.colorPrimary, 17170443});
                refreshLayout.setFooterMaxDragRate(4.0f);
                refreshLayout.setFooterHeight(45.0f);
            }
        });
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout refreshLayout) {
                refreshLayout.setEnableHeaderTranslationContent(true);
                return new DefaultHeader(XMLParseInstrumentation.inflate(context, R.layout.layout_default_refresh_header, (ViewGroup) null));
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout refreshLayout) {
                return new DefaultFooter(XMLParseInstrumentation.inflate(context, R.layout.layout_default_refresh_footer, (ViewGroup) null));
            }
        });
    }
}
