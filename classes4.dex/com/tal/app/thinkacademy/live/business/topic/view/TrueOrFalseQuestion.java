package com.tal.app.thinkacademy.live.business.topic.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import java.util.ArrayList;
import java.util.List;

public class TrueOrFalseQuestion implements IQuestion, RadioGroup.OnCheckedChangeListener {
    private List<String> answer = new ArrayList();
    private Context context;
    private ISelected listener;
    private List<List<String>> userAnswers = new ArrayList();

    public TrueOrFalseQuestion(Context context2, ISelected iSelected) {
        this.context = context2;
        this.listener = iSelected;
    }

    public View getView(List<List<String>> list) {
        LayoutInflater from = LayoutInflater.from(this.context);
        int i = R.layout.live_business_include_topic_options_radiobutton_layout;
        RadioGroup radioGroup = (RadioGroup) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null));
        int dp2px = SizeUtils.dp2px(10.0f);
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (int i3 = 0; i3 < list.get(i2).size(); i3++) {
                RadioButton radioButton = new RadioButton(this.context);
                radioButton.setButtonDrawable((Drawable) null);
                radioButton.setText((CharSequence) list.get(i2).get(i3));
                radioButton.setGravity(17);
                radioButton.setTextSize(1, 18.0f);
                radioButton.setTextColor(this.context.getResources().getColorStateList(R.color.live_business_color_live_topic_option, (Resources.Theme) null));
                radioButton.setBackgroundResource(R.drawable.live_business_selector_bg_topic_options);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(SizeUtils.dp2px(240.0f), SizeUtils.dp2px(66.0f));
                layoutParams.setMargins(dp2px, 0, dp2px, 0);
                radioGroup.addView(radioButton, layoutParams);
            }
        }
        radioGroup.setOnCheckedChangeListener(this);
        return radioGroup;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        SoundPoolUtils.play(this.context, R.raw.live_business_choice_choice_choose, 0);
        this.answer.clear();
        this.userAnswers.clear();
        String charSequence = ((RadioButton) radioGroup.findViewById(i)).getText().toString();
        if (TextUtils.equals(charSequence, this.context.getString(R.string.text_true))) {
            charSequence = "T";
        } else if (TextUtils.equals(charSequence, this.context.getString(R.string.text_false))) {
            charSequence = "F";
        }
        this.answer.add(charSequence);
        this.userAnswers.add(this.answer);
        this.listener.userAnswers(this.userAnswers);
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i);
    }
}
