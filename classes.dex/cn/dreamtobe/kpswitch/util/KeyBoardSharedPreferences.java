package cn.dreamtobe.kpswitch.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

class KeyBoardSharedPreferences {
    private static final String FILE_NAME = "keyboard.common";
    private static final String KEY_KEYBOARD_HEIGHT = "sp.key.keyboard.height";
    private static volatile SharedPreferences SP;

    KeyBoardSharedPreferences() {
    }

    public static boolean save(Context context, int i) {
        int i2 = context.getResources().getConfiguration().orientation;
        SharedPreferences.Editor edit = with(context).edit();
        return edit.putInt("sp.key.keyboard.height-" + i2, i).commit();
    }

    private static SharedPreferences with(Context context) {
        if (SP == null) {
            synchronized (KeyBoardSharedPreferences.class) {
                if (SP == null) {
                    SP = !(context instanceof Context) ? context.getSharedPreferences(FILE_NAME, 0) : XMLParseInstrumentation.getSharedPreferences(context, FILE_NAME, 0);
                }
            }
        }
        return SP;
    }

    public static int get(Context context, int i) {
        int i2 = context.getResources().getConfiguration().orientation;
        with(context).getInt("sp.key.keyboard.height-2", i);
        with(context).getInt("sp.key.keyboard.height-1", i);
        SharedPreferences with = with(context);
        return with.getInt("sp.key.keyboard.height-" + i2, i);
    }
}
