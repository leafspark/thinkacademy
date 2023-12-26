package com.adyen.threeds2.internal.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final class ToolbarView extends LinearLayout implements View.OnClickListener {
    private final TextView a;
    private final Button b;
    private a c;

    public interface a {
        void a();
    }

    public ToolbarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ToolbarView.class);
        if (this.c != null && view.equals(this.b)) {
            this.c.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void setBackgroundColor(int i) {
        getChildAt(0).setBackgroundColor(i);
    }

    public void setCancelButtonBackgroundColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public void setCancelButtonText(String str) {
        this.b.setText(str);
    }

    public void setCancelButtonTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setCancelButtonTextTypeface(Typeface typeface) {
        this.b.setTypeface(typeface);
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }

    public void setTitleFontSize(Integer num) {
        this.a.setTextSize((float) num.intValue());
    }

    public void setTitleTextColor(int i) {
        this.a.setTextColor(i);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
    }

    public void setToolbarListener(a aVar) {
        this.c = aVar;
    }

    public ToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToolbarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LinearLayout.inflate(context, R.layout.a3ds2_widget_toolbar, this);
        CharSequence loadLabel = getContext().getApplicationInfo().loadLabel(getContext().getPackageManager());
        TextView textView = (TextView) findViewById(R.id.textView_title);
        this.a = textView;
        textView.setText(loadLabel);
        Button button = (Button) findViewById(R.id.button_cancel);
        this.b = button;
        button.setOnClickListener(this);
    }
}
