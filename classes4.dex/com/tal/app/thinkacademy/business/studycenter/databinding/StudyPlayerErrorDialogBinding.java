package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class StudyPlayerErrorDialogBinding implements ViewBinding {
    public final RoundTextView playerExit;
    public final RoundTextView playerRetry;
    private final LinearLayout rootView;

    private StudyPlayerErrorDialogBinding(LinearLayout linearLayout, RoundTextView roundTextView, RoundTextView roundTextView2) {
        this.rootView = linearLayout;
        this.playerExit = roundTextView;
        this.playerRetry = roundTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StudyPlayerErrorDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyPlayerErrorDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_player_error_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.player_retry;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.StudyPlayerErrorDialogBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.player_exit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.flyco.roundview.RoundTextView r1 = (com.flyco.roundview.RoundTextView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.player_retry
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.flyco.roundview.RoundTextView r2 = (com.flyco.roundview.RoundTextView) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.studycenter.databinding.StudyPlayerErrorDialogBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.StudyPlayerErrorDialogBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001c:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.StudyPlayerErrorDialogBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.StudyPlayerErrorDialogBinding");
    }
}
