package com.didi.hummer.component.loading;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.component.R;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;

@Component("Loading")
public class Loading extends HMBase<FrameLayout> {
    private ProgressBar progress;

    public Loading(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.progress = progressBar;
        progressBar.setIndeterminateDrawable(getContext().getResources().getDrawable(R.drawable.loading_anim));
        ((FrameLayout) getView()).addView(this.progress, new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public FrameLayout createViewInstance(Context context) {
        return new FrameLayout(context);
    }
}
