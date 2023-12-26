package com.tal.app.thinkacademy.live.business.ranking;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/LevelState;", "", "code", "", "levelBadge", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;)V", "getCode", "()I", "getLevelBadge", "()Landroid/graphics/drawable/Drawable;", "LevelZero", "LevelOne", "LevelTwo", "LevelThree", "LevelFour", "LevelFive", "LevelSix", "LevelSeven", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingAdapter.kt */
public enum LevelState {
    LevelZero(0, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level0)),
    LevelOne(1, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level1_iron_miduem)),
    LevelTwo(2, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level2_bronze_miduem)),
    LevelThree(3, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level3_sliver_miduem)),
    LevelFour(4, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level4_gold_miduem)),
    LevelFive(5, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level5_platinum_miduem)),
    LevelSix(6, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level6_diamond_miduem)),
    LevelSeven(7, ContextCompat.getDrawable(Utils.getApp(), R.drawable.icon_level7_crown_miduem));
    
    private final int code;
    private final Drawable levelBadge;

    private LevelState(int i, Drawable drawable) {
        this.code = i;
        this.levelBadge = drawable;
    }

    public final int getCode() {
        return this.code;
    }

    public final Drawable getLevelBadge() {
        return this.levelBadge;
    }
}
