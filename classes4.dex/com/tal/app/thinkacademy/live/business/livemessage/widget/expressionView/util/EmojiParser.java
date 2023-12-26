package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.EmojiEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class EmojiParser {
    private static EmojiParser mParser;
    private HashMap<List<Integer>, String> convertMap = new HashMap<>();

    private EmojiParser(Context context) {
        readMap(context);
    }

    public static EmojiParser getInstance(Context context) {
        if (mParser == null) {
            mParser = new EmojiParser(context);
        }
        return mParser;
    }

    public void readMap(Context context) {
        HashMap<List<Integer>, String> hashMap = this.convertMap;
        if (hashMap == null || hashMap.size() == 0) {
            this.convertMap = new HashMap<>();
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(context.getAssets().open("emoji.xml"), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2) {
                        if (newPullParser.getName().equals("e")) {
                            String nextText = newPullParser.nextText();
                            ArrayList arrayList = new ArrayList();
                            if (nextText.length() > 6) {
                                for (String parseInt : nextText.split("\\_")) {
                                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt, 16)));
                                }
                            } else {
                                arrayList.add(Integer.valueOf(Integer.parseInt(nextText, 16)));
                            }
                            this.convertMap.put(arrayList, nextText);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public EmojiEntity parseEmoji(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        EmojiEntity emojiEntity = new EmojiEntity();
        StringBuilder sb = new StringBuilder();
        int[] codePointArray = toCodePointArray(str);
        int i = 0;
        while (i < codePointArray.length) {
            ArrayList arrayList = new ArrayList();
            int i2 = i + 1;
            if (i2 < codePointArray.length) {
                arrayList.add(Integer.valueOf(codePointArray[i]));
                arrayList.add(Integer.valueOf(codePointArray[i2]));
                if (this.convertMap.containsKey(arrayList)) {
                    String str2 = this.convertMap.get(arrayList);
                    if (str2 != null) {
                        sb.append("[e]" + str2 + "[/e]");
                        emojiEntity.setEmojiCount(emojiEntity.getEmojiCount() + 1);
                    }
                    i = i2;
                    i++;
                }
            }
            arrayList.clear();
            arrayList.add(Integer.valueOf(codePointArray[i]));
            if (this.convertMap.containsKey(arrayList)) {
                String str3 = this.convertMap.get(arrayList);
                if (str3 != null) {
                    sb.append("[e]" + str3 + "[/e]");
                    emojiEntity.setEmojiCount(emojiEntity.getEmojiCount() + 1);
                }
            } else {
                sb.append(Character.toChars(codePointArray[i]));
            }
            i++;
        }
        emojiEntity.setEmojiText(sb.toString());
        return emojiEntity;
    }

    private int[] toCodePointArray(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        int[] iArr = new int[Character.codePointCount(charArray, 0, length)];
        int i2 = 0;
        while (i < length) {
            int codePointAt = Character.codePointAt(charArray, i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    public boolean judgeEmoji(String str) {
        if (str != null && str.length() > 0) {
            int[] codePointArray = toCodePointArray(str);
            int i = 0;
            while (i < codePointArray.length) {
                ArrayList arrayList = new ArrayList();
                int i2 = i + 1;
                if (i2 < codePointArray.length) {
                    arrayList.add(Integer.valueOf(codePointArray[i]));
                    arrayList.add(Integer.valueOf(codePointArray[i2]));
                    if (this.convertMap.containsKey(arrayList)) {
                        if (this.convertMap.get(arrayList) != null) {
                            return true;
                        }
                        i = i2;
                        i++;
                    }
                }
                arrayList.clear();
                arrayList.add(Integer.valueOf(codePointArray[i]));
                if (this.convertMap.containsKey(arrayList) && this.convertMap.get(arrayList) != null) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static SpannableStringBuilder convertToHtml(String str, Context context, int i) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder();
        }
        Pattern compile = Pattern.compile("\\[e\\](.*?)\\[/e\\]");
        Resources resources = context.getResources();
        EmojiEntity parseEmoji = getInstance(context).parseEmoji(str);
        Matcher matcher = compile.matcher(parseEmoji.getEmojiText());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parseEmoji.getEmojiText());
        while (matcher.find()) {
            String group = matcher.group();
            try {
                int identifier = resources.getIdentifier("emoji_" + group.substring(group.indexOf("]") + 1, group.lastIndexOf("[")), "drawable", AppUtils.getAppPackageName());
                if (identifier != 0) {
                    Drawable drawable = resources.getDrawable(identifier);
                    drawable.setBounds(0, 0, i, i);
                    spannableStringBuilder.setSpan(new ImageSpan(drawable), matcher.start(), matcher.end(), 33);
                }
            } catch (Exception unused) {
            }
        }
        return spannableStringBuilder;
    }

    public static String getExpressionStringText(Context context, CharSequence charSequence, String str) {
        return charSequence == null ? "" : charSequence.toString().replaceAll(str, "[表情]");
    }

    public static String getExpressionStringText(Context context, CharSequence charSequence, String str, String str2) {
        return charSequence == null ? "" : charSequence.toString().replaceAll(str, str2);
    }
}
