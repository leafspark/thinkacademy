package com.didi.hummer.component.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;

public class HummerFooter extends SimpleComponent implements RefreshFooter {
    private OnLoadListener mOnLoadListener;

    public interface OnLoadListener {
        void onLoadFinished();

        void onLoadStarted();

        void onLoading();
    }

    public HummerFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    public HummerFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HummerFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void addFooterView(HMBase hMBase) {
        HummerLayout hummerLayout = new HummerLayout(hMBase.getContext());
        hummerLayout.addView(hMBase);
        addView(hummerLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.mOnLoadListener = onLoadListener;
    }

    /* renamed from: com.didi.hummer.component.refresh.HummerFooter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadFinish     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.refresh.HummerFooter.AnonymousClass1.<clinit>():void");
        }
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        OnLoadListener onLoadListener;
        int i = AnonymousClass1.$SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1) {
            OnLoadListener onLoadListener2 = this.mOnLoadListener;
            if (onLoadListener2 != null) {
                onLoadListener2.onLoadStarted();
            }
        } else if (i == 4) {
            OnLoadListener onLoadListener3 = this.mOnLoadListener;
            if (onLoadListener3 != null) {
                onLoadListener3.onLoading();
            }
        } else if (i == 5 && (onLoadListener = this.mOnLoadListener) != null) {
            onLoadListener.onLoadFinished();
        }
    }
}
