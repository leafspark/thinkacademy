package com.tal.app.thinkacademy.lib.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.utils.TextUtils;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class ProxyFragment extends Fragment {
    public static final String TAG = "ProxyFragment";
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private ResultCallback mCallBack;
    private Intent mIntent;
    /* access modifiers changed from: private */
    public Postcard mPostcard;
    /* access modifiers changed from: private */
    public int mRequestCode = -1;
    /* access modifiers changed from: private */
    public NavigationCallback navigationCallback = new NavigationCallback() {
        public void onArrival(Postcard postcard) {
        }

        public void onFound(Postcard postcard) {
        }

        public void onInterrupt(Postcard postcard) {
        }

        public void onLost(Postcard postcard) {
            throw new XesRouteException("未跳转目标页面?" + ProxyFragment.this.mPostcard.getDestination());
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return ProxyFragment.super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        ProxyFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        ProxyFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        ProxyFragment.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        ProxyFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        ProxyFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        ProxyFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public static ProxyFragment newInstance(Postcard postcard, int i, ResultCallback resultCallback) {
        ProxyFragment proxyFragment = new ProxyFragment();
        proxyFragment.mPostcard = postcard;
        proxyFragment.mRequestCode = i;
        proxyFragment.mCallBack = resultCallback;
        return proxyFragment;
    }

    public static ProxyFragment newInstance(Intent intent, int i, ResultCallback resultCallback) {
        ProxyFragment proxyFragment = new ProxyFragment();
        proxyFragment.mIntent = intent;
        proxyFragment.mRequestCode = i;
        proxyFragment.mCallBack = resultCallback;
        return proxyFragment;
    }

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        ProxyFragment.super.onCreate(bundle);
        int i = this.mRequestCode;
        if (i == -1) {
            XesRouteException xesRouteException = new XesRouteException("请添加请求码 值在 0 -- 255 之间");
            ActivityInfo.endCreateFragment(getActivity(), this);
            throw xesRouteException;
        } else if (this.mCallBack != null) {
            Intent intent = this.mIntent;
            if (intent != null) {
                startActivityForResult(intent, i, this.mPostcard.getOptionsBundle());
            } else if (this.mPostcard != null) {
                navigation(getActivity());
            } else {
                XesRouteException xesRouteException2 = new XesRouteException("请添加请求体  Postcard 具体使用方式 请查阅 ARouter");
                ActivityInfo.endCreateFragment(getActivity(), this);
                throw xesRouteException2;
            }
            ActivityInfo.endCreateFragment(getActivity(), this);
        } else {
            XesRouteException xesRouteException3 = new XesRouteException("请添加请求回调  ResultCallback");
            ActivityInfo.endCreateFragment(getActivity(), this);
            throw xesRouteException3;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ResultCallback resultCallback;
        ProxyFragment.super.onActivityResult(i, i2, intent);
        if (this.mRequestCode == i && (resultCallback = this.mCallBack) != null) {
            resultCallback.next(i2, intent);
        }
        destroy();
    }

    private void navigation(final Context context) {
        LogisticsCenter.completion(this.mPostcard);
        if (this.mPostcard.getType() == RouteType.ACTIVITY) {
            final Intent intent = new Intent(context, this.mPostcard.getDestination());
            intent.putExtras(this.mPostcard.getExtras());
            int flags = this.mPostcard.getFlags();
            if (-1 != flags) {
                intent.setFlags(flags);
            }
            String action = this.mPostcard.getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                Handler handler = sHandler;
                AnonymousClass1 r1 = new Runnable() {
                    public void run() {
                        ProxyFragment proxyFragment = ProxyFragment.this;
                        proxyFragment.startActivity(proxyFragment.mRequestCode, context, intent, ProxyFragment.this.mPostcard, ProxyFragment.this.navigationCallback);
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r1);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r1);
                }
            } else {
                startActivity(this.mRequestCode, context, intent, this.mPostcard, this.navigationCallback);
            }
        } else {
            throw new XesRouteException("确定跳转目标是活动页面?" + this.mPostcard.getDestination());
        }
    }

    /* access modifiers changed from: private */
    public void startActivity(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback2) {
        if (i >= 0) {
            startActivityForResult(intent, i, postcard.getOptionsBundle());
        } else {
            startActivity(intent, postcard.getOptionsBundle());
        }
        if (!(-1 == postcard.getEnterAnim() || -1 == postcard.getExitAnim() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback2 != null) {
            navigationCallback2.onArrival(postcard);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }
}
