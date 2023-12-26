package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutChatGifGridviewBinding implements ViewBinding {
    public final GridView gvChatExpression;
    private final LinearLayout rootView;

    private LayoutChatGifGridviewBinding(LinearLayout linearLayout, GridView gridView) {
        this.rootView = linearLayout;
        this.gvChatExpression = gridView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutChatGifGridviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutChatGifGridviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_chat_gif_gridview;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutChatGifGridviewBinding bind(View view) {
        int i = R.id.gv_chat_expression;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            return new LayoutChatGifGridviewBinding((LinearLayout) view, gridView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
