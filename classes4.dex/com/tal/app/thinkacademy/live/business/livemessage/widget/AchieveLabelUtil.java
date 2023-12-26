package com.tal.app.thinkacademy.live.business.livemessage.widget;

import com.tal.app.thinkacademy.live.business.R;

public class AchieveLabelUtil {
    public static int getRightLabel(int i) {
        if (i == 2) {
            return R.drawable.icon_live_business_contiright_2;
        }
        if (i == 3) {
            return R.drawable.icon_live_business_contiright_3;
        }
        if (i == 4) {
            return R.drawable.icon_live_business_contiright_4;
        }
        if (i == 5) {
            return R.drawable.icon_live_business_contiright_5;
        }
        if (i == 6) {
            return R.drawable.icon_live_business_contiright_6;
        }
        if (i == 7) {
            return R.drawable.icon_live_business_contiright_7;
        }
        if (i == 8) {
            return R.drawable.icon_live_business_contiright_8;
        }
        if (i == 9) {
            return R.drawable.icon_live_business_contiright_king;
        }
        if (i >= 10) {
            return R.drawable.icon_live_business_contiright_top;
        }
        return 0;
    }
}
