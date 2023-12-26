package com.tal.app.thinkacademy.live.business.topic.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoice implements IQuestion, CompoundButton.OnCheckedChangeListener {
    private List<String> answer = new ArrayList();
    private Context context;
    private ISelected listener;
    private List<List<String>> userAnswers = new ArrayList();

    public MultipleChoice(Context context2, ISelected iSelected) {
        this.context = context2;
        this.listener = iSelected;
    }

    public View getView(List<List<String>> list) {
        LayoutInflater from = LayoutInflater.from(this.context);
        int i = R.layout.live_business_include_topic_options_checkbox_layout;
        LinearLayout linearLayout = (LinearLayout) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null));
        int dp2px = SizeUtils.dp2px(list.size() <= 4 ? 10.0f : 5.0f);
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < list.get(i2).size(); i3++) {
                CheckBox checkBox = new CheckBox(this.context);
                checkBox.setButtonDrawable((Drawable) null);
                checkBox.setId(i2);
                checkBox.setText((CharSequence) list.get(i2).get(i3));
                checkBox.setGravity(17);
                checkBox.setTextSize(1, 18.0f);
                checkBox.setTextColor(this.context.getResources().getColorStateList(R.color.live_business_color_live_topic_option, (Resources.Theme) null));
                checkBox.setBackgroundResource(R.drawable.live_business_selector_bg_topic_options);
                checkBox.setOnCheckedChangeListener(this);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(SizeUtils.dp2px(72.0f), SizeUtils.dp2px(66.0f));
                layoutParams.setMargins(dp2px, 0, dp2px, 0);
                linearLayout.addView(checkBox, layoutParams);
            }
        }
        return linearLayout;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SoundPoolUtils.play(this.context, R.raw.live_business_choice_choice_choose, 0);
        if (z) {
            ArrayList arrayList = new ArrayList();
            this.answer = arrayList;
            arrayList.add(compoundButton.getText().toString());
            this.userAnswers.add(this.answer);
        } else {
            int i = -1;
            for (int i2 = 0; i2 < this.userAnswers.size(); i2++) {
                if (this.userAnswers.get(i2).contains(compoundButton.getText().toString().substring(0, 1))) {
                    i = i2;
                }
            }
            if (i != -1) {
                this.userAnswers.remove(i);
            }
        }
        this.listener.userAnswers(this.userAnswers);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }
}
