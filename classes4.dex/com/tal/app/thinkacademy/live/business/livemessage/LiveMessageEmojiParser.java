package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.VerticalImageSpan;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiveMessageEmojiParser {
    public static HashMap<String, Integer> map;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        map = hashMap;
        hashMap.put("[e]em_1[e]", Integer.valueOf(R.drawable.emoji_1f60a));
        map.put("[e]em_2[e]", Integer.valueOf(R.drawable.emoji_1f604));
        map.put("[e]em_3[e]", Integer.valueOf(R.drawable.emoji_1f633));
        map.put("[e]em_4[e]", Integer.valueOf(R.drawable.emoji_1f60c));
        map.put("[e]em_5[e]", Integer.valueOf(R.drawable.emoji_1f601));
        map.put("[e]em_6[e]", Integer.valueOf(R.drawable.emoji_1f61d));
        map.put("[e]em_7[e]", Integer.valueOf(R.drawable.emoji_1f625));
        map.put("[e]em_8[e]", Integer.valueOf(R.drawable.emoji_1f623));
        map.put("[e]em_9[e]", Integer.valueOf(R.drawable.emoji_1f628));
        map.put("[e]em_10[e]", Integer.valueOf(R.drawable.emoji_1f632));
        map.put("[e]em_11[e]", Integer.valueOf(R.drawable.emoji_1f62d));
        map.put("[e]em_12[e]", Integer.valueOf(R.drawable.emoji_1f602));
        map.put("[e]em_13[e]", Integer.valueOf(R.drawable.emoji_1f631));
        map.put("[e]em_14[e]", Integer.valueOf(R.drawable.emoji_1f47f));
        map.put("[e]em_15[e]", Integer.valueOf(R.drawable.emoji_1f44d));
        map.put("[e]em_16[e]", Integer.valueOf(R.drawable.emoji_1f44c));
        map.put("[e]em_17[e]", Integer.valueOf(R.drawable.emoji_270c));
        map.put("[e]em_18[e]", Integer.valueOf(R.drawable.emoji_heart));
        map.put("[e]em_19[e]", Integer.valueOf(R.drawable.emoji_sml));
        map.put("[e]em_20[e]", Integer.valueOf(R.drawable.emoji_get));
        map.put("[e]em_get[e]", Integer.valueOf(R.drawable.emoji_hff_list));
    }

    public static SpannableStringBuilder convertToHtml(String str, Context context, int i) {
        int i2;
        Pattern compile = Pattern.compile("\\[e\\]em(.*?)\\[e\\]");
        Resources resources = context.getResources();
        Matcher matcher = compile.matcher(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (matcher.find()) {
            try {
                int intValue = map.get(matcher.group()).intValue();
                if (intValue != 0) {
                    Drawable drawable = resources.getDrawable(intValue);
                    int i3 = 1;
                    if (drawable != null) {
                        if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
                            i3 = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
                            i2 = (int) (((double) i) * 1.2d);
                        } else {
                            i2 = i;
                        }
                        drawable.setBounds(0, 0, i3 * i2, i2);
                        spannableStringBuilder.setSpan(new VerticalImageSpan(drawable), matcher.start(), matcher.end(), 33);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return spannableStringBuilder;
    }
}
