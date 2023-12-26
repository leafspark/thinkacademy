package com.tal.app.thinkacademy.lib.commui.baseview.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;

public abstract class BaseBindDialog<VB extends ViewBinding> extends BaseDialog {
    public VB binding;

    /* access modifiers changed from: protected */
    public abstract VB createViewBinding(LayoutInflater layoutInflater);

    public BaseBindDialog(Context context) {
        this(context, false);
    }

    public BaseBindDialog(Context context, boolean z) {
        this(context, 0, z);
    }

    public BaseBindDialog(Context context, int i, boolean z) {
        super(context, i, z);
        VB createViewBinding = createViewBinding(LayoutInflater.from(context));
        this.binding = createViewBinding;
        super.contentView(createViewBinding.getRoot());
    }

    @Deprecated
    public BaseDialog contentView(View view) {
        return super.contentView(view);
    }

    @Deprecated
    public BaseDialog contentView(int i) {
        return super.contentView(i);
    }

    @Deprecated
    public BaseDialog contentView(View view, ViewGroup.LayoutParams layoutParams) {
        return super.contentView(view, layoutParams);
    }
}
