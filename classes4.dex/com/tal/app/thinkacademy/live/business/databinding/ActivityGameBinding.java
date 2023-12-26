package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView;

public final class ActivityGameBinding implements ViewBinding {
    public final GamePluginView gamePluginView;
    private final ConstraintLayout rootView;

    private ActivityGameBinding(ConstraintLayout constraintLayout, GamePluginView gamePluginView2) {
        this.rootView = constraintLayout;
        this.gamePluginView = gamePluginView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_game;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityGameBinding bind(View view) {
        int i = R.id.gamePluginView;
        GamePluginView gamePluginView2 = (GamePluginView) ViewBindings.findChildViewById(view, i);
        if (gamePluginView2 != null) {
            return new ActivityGameBinding((ConstraintLayout) view, gamePluginView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
