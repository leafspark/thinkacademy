package com.tal.app.thinkacademy.live.business.emoji.data;

import android.text.TextUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiLocalImageResourceBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmojiData {
    private static LinkedHashMap<String, EmojiBean> EMOJI_MAP;

    static {
        LinkedHashMap<String, EmojiBean> linkedHashMap = new LinkedHashMap<>();
        EMOJI_MAP = linkedHashMap;
        linkedHashMap.put("[smile]", new EmojiBean("[smile]", 1, new EmojiLocalImageResourceBean(R.drawable.e_smile)));
        EMOJI_MAP.put("[XD]", new EmojiBean("[XD]", 1, new EmojiLocalImageResourceBean(R.drawable.e_xd)));
        EMOJI_MAP.put("[LOL]", new EmojiBean("[LOL]", 1, new EmojiLocalImageResourceBean(R.drawable.e_lol)));
        EMOJI_MAP.put("[party]", new EmojiBean("[party]", 1, new EmojiLocalImageResourceBean(R.drawable.e_party)));
        EMOJI_MAP.put("[the_rock]", new EmojiBean("[the_rock]", 1, new EmojiLocalImageResourceBean(R.drawable.e_the_rock)));
        EMOJI_MAP.put("[thinking]", new EmojiBean("[thinking]", 1, new EmojiLocalImageResourceBean(R.drawable.e_thinking)));
        EMOJI_MAP.put("[quiet]", new EmojiBean("[quiet]", 1, new EmojiLocalImageResourceBean(R.drawable.e_quiet)));
        EMOJI_MAP.put("[pleading]", new EmojiBean("[pleading]", 1, new EmojiLocalImageResourceBean(R.drawable.e_pleading)));
        EMOJI_MAP.put("[sad]", new EmojiBean("[sad]", 1, new EmojiLocalImageResourceBean(R.drawable.e_sad)));
        EMOJI_MAP.put("[shame]", new EmojiBean("[shame]", 1, new EmojiLocalImageResourceBean(R.drawable.e_shame)));
        EMOJI_MAP.put("[scream]", new EmojiBean("[scream]", 1, new EmojiLocalImageResourceBean(R.drawable.e_scream)));
        EMOJI_MAP.put("[cry]", new EmojiBean("[cry]", 1, new EmojiLocalImageResourceBean(R.drawable.e_cry)));
        EMOJI_MAP.put("[yeah]", new EmojiBean("[yeah]", 1, new EmojiLocalImageResourceBean(R.drawable.e_yeah)));
        EMOJI_MAP.put("[like]", new EmojiBean("[like]", 1, new EmojiLocalImageResourceBean(R.drawable.e_like)));
        EMOJI_MAP.put("[hands_up]", new EmojiBean("[hands_up]", 1, new EmojiLocalImageResourceBean(R.drawable.e_hands_up)));
        EMOJI_MAP.put("[clap]", new EmojiBean("[clap]", 1, new EmojiLocalImageResourceBean(R.drawable.e_clap)));
        EMOJI_MAP.put("[A]", new EmojiBean("[A]", 1, new EmojiLocalImageResourceBean(R.drawable.e_a)));
        EMOJI_MAP.put("[B]", new EmojiBean("[B]", 1, new EmojiLocalImageResourceBean(R.drawable.e_b)));
        EMOJI_MAP.put("[true]", new EmojiBean("[true]", 1, new EmojiLocalImageResourceBean(R.drawable.e_true)));
        EMOJI_MAP.put("[false]", new EmojiBean("[false]", 1, new EmojiLocalImageResourceBean(R.drawable.e_false)));
        EMOJI_MAP.put("[surprise]", new EmojiBean("[surprise]", 1, new EmojiLocalImageResourceBean(R.drawable.e_surprise)));
        EMOJI_MAP.put("[heart]", new EmojiBean("[heart]", 1, new EmojiLocalImageResourceBean(R.drawable.e_heart)));
        EMOJI_MAP.put("[unicorn]", new EmojiBean("[unicorn]", 1, new EmojiLocalImageResourceBean(R.drawable.e_unicorn)));
        EMOJI_MAP.put("[ghost]", new EmojiBean("[ghost]", 1, new EmojiLocalImageResourceBean(R.drawable.e_ghost)));
    }

    public static EmojiBean getEmojiByName(String str) {
        LinkedHashMap<String, EmojiBean> linkedHashMap;
        if (!TextUtils.isEmpty(str) && (linkedHashMap = EMOJI_MAP) != null && linkedHashMap.size() > 0) {
            return EMOJI_MAP.get(str);
        }
        return null;
    }

    public static List<EmojiBean> getEmojis() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, EmojiBean> linkedHashMap = EMOJI_MAP;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (Map.Entry<String, EmojiBean> value : EMOJI_MAP.entrySet()) {
                arrayList.add((EmojiBean) value.getValue());
            }
        }
        return arrayList;
    }
}
