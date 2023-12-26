package com.tal.app.thinkacademy.business.bus_hummer.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.didi.hummer.HummerRender;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.render.style.HummerLayout;
import com.tal.app.thinkacademy.business.bus_hummer.R;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;

public class HwBaseHummerActivity extends XesBaseActivity {
    protected HummerLayout hmContainer;
    protected HummerRender hmRender;
    protected TitleBar mTitleBar;
    protected NavPage page;

    /* access modifiers changed from: protected */
    public DevToolsConfig getDevToolsConfig() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getNamespace() {
        return "_HUMMER_SDK_NAMESPACE_DEFAULT_";
    }

    /* access modifiers changed from: protected */
    public void initHummerRegister(HummerContext hummerContext) {
    }

    /* access modifiers changed from: protected */
    public void onPageRenderFailed(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void onPageRenderSucceed(HummerContext hummerContext, JSValue jSValue) {
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.tal.app.thinkacademy.business.bus_hummer.base.HwBaseHummerActivity, com.tal.app.thinkacademy.common.base.XesBaseActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        HwBaseHummerActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar(this, true, -1, false);
        initData();
        initView();
        if (this.page != null) {
            initHummer();
            renderHummer();
            return;
        }
        onPageRenderFailed(new RuntimeException("page is null"));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        HwBaseHummerActivity.super.onResume();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        HwBaseHummerActivity.super.onPause();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        HwBaseHummerActivity.super.onDestroy();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onDestroy();
        }
    }

    public void onBackPressed() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender == null || !hummerRender.onBack()) {
            HwBaseHummerActivity.super.onBackPressed();
        }
    }

    public void finish() {
        setPageResult();
        HwBaseHummerActivity.super.finish();
    }

    /* access modifiers changed from: protected */
    public void setPageResult() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            setResult(-1, hummerRender.getJsPageResultIntent());
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, com.tal.app.thinkacademy.business.bus_hummer.base.HwBaseHummerActivity, com.tal.app.thinkacademy.common.base.XesBaseActivity] */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            FocusUtil.clearFocus(this);
        }
        return HwBaseHummerActivity.super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        NavPage pageInfo = getPageInfo();
        this.page = pageInfo;
        if (pageInfo == null) {
            this.page = new NavPage();
        }
    }

    /* access modifiers changed from: protected */
    public NavPage getPageInfo() {
        try {
            return getIntent().getSerializableExtra("PAGE_MODEL");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        setContentView(R.layout.activity_hw_base_hummer);
        this.hmContainer = findViewById(R.id.hummer_container);
        TitleBar findViewById = findViewById(R.id.nativeTopBar);
        this.mTitleBar = findViewById;
        findViewById.setLineVisible(false);
        this.mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            public void onLeftClick(View view) {
                HwBaseHummerActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initHummer() {
        HummerRender hummerRender = new HummerRender(this.hmContainer, getNamespace(), getDevToolsConfig());
        this.hmRender = hummerRender;
        initHummerRegister(hummerRender.getHummerContext());
        this.hmRender.setJsPageInfo(this.page);
        this.hmRender.setRenderCallback(new HummerRender.HummerRenderCallback() {
            public void onSucceed(HummerContext hummerContext, JSValue jSValue) {
                HwBaseHummerActivity.this.onPageRenderSucceed(hummerContext, jSValue);
            }

            public void onFailed(Exception exc) {
                HwBaseHummerActivity.this.onPageRenderFailed(exc);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void renderHummer() {
        NavPage navPage = this.page;
        if (navPage != null && !TextUtils.isEmpty(navPage.url)) {
            if (this.page.isHttpUrl()) {
                this.hmRender.renderWithUrl(this.page.url);
            } else if (this.page.url.startsWith("/")) {
                this.hmRender.renderWithFile(this.page.url);
            } else {
                this.hmRender.renderWithAssets(this.page.url);
            }
        }
    }
}
