package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LayoutChatExpressionBinding implements ViewBinding {
    public final GridView gvChatExpression;
    private final GridView rootView;

    private LayoutChatExpressionBinding(GridView gridView, GridView gridView2) {
        this.rootView = gridView;
        this.gvChatExpression = gridView2;
    }

    public GridView getRoot() {
        return this.rootView;
    }

    public static LayoutChatExpressionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutChatExpressionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_chat_expression;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutChatExpressionBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        GridView gridView = (GridView) view;
        return new LayoutChatExpressionBinding(gridView, gridView);
    }
}
