package com.didi.hummer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.didi.hummer.HummerRender;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.render.style.HummerLayout;

public class HummerActivity extends AppCompatActivity {
    protected HummerLayout hmContainer;
    protected HummerRender hmRender;
    protected NavPage page;

    /* access modifiers changed from: protected */
    public DevToolsConfig getDevToolsConfig() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getNamespace() {
        return HummerSDK.NAMESPACE_DEFAULT;
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

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        HummerActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        HummerActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        HummerActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        HummerActivity.super.onCreate(bundle);
        HummerSDK.init(getApplicationContext());
        initData();
        initView();
        if (this.page != null) {
            initHummer();
            renderHummer();
        } else {
            onPageRenderFailed(new RuntimeException("page is null"));
        }
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        HummerActivity.super.onResume();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onResume();
        }
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        HummerActivity.super.onPause();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onPause();
        }
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        HummerActivity.super.onDestroy();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onDestroy();
        }
    }

    public void onBackPressed() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender == null || !hummerRender.onBack()) {
            HummerActivity.super.onBackPressed();
        }
    }

    public void finish() {
        ActivityInfo.finishActivity(getClass().getName());
        setPageResult();
        HummerActivity.super.finish();
    }

    /* access modifiers changed from: protected */
    public void setPageResult() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            setResult(-1, hummerRender.getJsPageResultIntent());
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, com.didi.hummer.HummerActivity, androidx.appcompat.app.AppCompatActivity] */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            FocusUtil.clearFocus((Context) this);
        }
        return HummerActivity.super.onTouchEvent(motionEvent);
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
            return (NavPage) getIntent().getSerializableExtra(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        setContentView(R.layout.activity_hummer);
        this.hmContainer = (HummerLayout) findViewById(R.id.hummer_container);
    }

    /* access modifiers changed from: protected */
    public void initHummer() {
        HummerRender hummerRender = new HummerRender(this.hmContainer, getNamespace(), getDevToolsConfig());
        this.hmRender = hummerRender;
        initHummerRegister(hummerRender.getHummerContext());
        this.hmRender.setJsPageInfo(this.page);
        this.hmRender.setRenderCallback(new HummerRender.HummerRenderCallback() {
            public void onSucceed(HummerContext hummerContext, JSValue jSValue) {
                HummerActivity.this.onPageRenderSucceed(hummerContext, jSValue);
            }

            public void onFailed(Exception exc) {
                HummerActivity.this.onPageRenderFailed(exc);
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
