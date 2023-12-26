package com.didi.hummer.delegate;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.hummer.HummerRender;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.render.style.HummerLayout;

public abstract class AbsHummerDelegate implements IHummerDelegagte {
    protected Context context;
    protected HummerRender hmRender;
    protected NavPage page;

    /* access modifiers changed from: protected */
    public abstract DevToolsConfig getDevToolsConfig();

    /* access modifiers changed from: protected */
    public abstract HummerLayout getHummerLayout();

    /* access modifiers changed from: protected */
    public abstract String getNamespace();

    /* access modifiers changed from: protected */
    public abstract void initHummerRegister(HummerContext hummerContext);

    /* access modifiers changed from: protected */
    public abstract View initView();

    /* access modifiers changed from: protected */
    public abstract void onPageRenderFailed(Exception exc);

    /* access modifiers changed from: protected */
    public abstract void onPageRenderSucceed(HummerContext hummerContext, JSValue jSValue);

    public AbsHummerDelegate(FragmentActivity fragmentActivity, NavPage navPage) {
        if (fragmentActivity != null) {
            fragmentActivity.getLifecycle().addObserver(this);
            init(fragmentActivity, navPage);
            return;
        }
        throw new RuntimeException("activity must not be null!");
    }

    public AbsHummerDelegate(Fragment fragment, NavPage navPage) {
        if (fragment != null) {
            fragment.getLifecycle().addObserver(this);
            init(fragment.getContext(), navPage);
            return;
        }
        throw new RuntimeException("fragment must not be null!");
    }

    private void init(Context context2, NavPage navPage) {
        if (context2 != null) {
            this.context = context2;
            initData(navPage);
            return;
        }
        throw new RuntimeException("context must not be null!");
    }

    public final void initSDK() {
        HummerSDK.init(this.context);
    }

    public final View initViewAndRender() {
        View initView = initView();
        NavPage navPage = this.page;
        if (navPage == null || TextUtils.isEmpty(navPage.url)) {
            onPageRenderFailed(new RuntimeException("page url is empty"));
            Toast.makeText(this.context, "page url is empty", 0).show();
        } else {
            initHummer();
            renderHummer();
        }
        return initView;
    }

    /* access modifiers changed from: protected */
    public void initData(NavPage navPage) {
        this.page = navPage;
    }

    /* access modifiers changed from: protected */
    public void initHummer() {
        HummerRender hummerRender = new HummerRender(getHummerLayout(), getNamespace(), getDevToolsConfig());
        this.hmRender = hummerRender;
        initHummerRegister(hummerRender.getHummerContext());
        this.hmRender.setJsPageInfo(this.page);
        this.hmRender.setRenderCallback(new HummerRender.HummerRenderCallback() {
            public void onSucceed(HummerContext hummerContext, JSValue jSValue) {
                AbsHummerDelegate.this.onPageRenderSucceed(hummerContext, jSValue);
            }

            public void onFailed(Exception exc) {
                AbsHummerDelegate.this.onPageRenderFailed(exc);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void renderHummer() {
        if (this.page.isHttpUrl()) {
            this.hmRender.renderWithUrl(this.page.url);
        } else if (this.page.url.startsWith("/")) {
            this.hmRender.renderWithFile(this.page.url);
        } else {
            this.hmRender.renderWithAssets(this.page.url);
        }
    }

    public boolean onBackPressed() {
        HummerRender hummerRender = this.hmRender;
        return hummerRender != null && hummerRender.onBack();
    }

    public Intent getJsPageResultIntent() {
        return this.hmRender.getJsPageResultIntent();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onResume();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onPause();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onDestroy();
        }
        this.hmRender = null;
    }
}
