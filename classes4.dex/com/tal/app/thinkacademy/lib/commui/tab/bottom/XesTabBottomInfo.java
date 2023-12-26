package com.tal.app.thinkacademy.lib.commui.tab.bottom;

import android.graphics.Bitmap;
import androidx.fragment.app.Fragment;

public class XesTabBottomInfo<Color> {
    public Bitmap defaultBitmap;
    public int defaultBitmapRes;
    public Color defaultColor;
    public String defaultIconName;
    public Fragment fragment;
    public String iconFont;
    public Bitmap selectedBitmap;
    public int selectedBitmapRes;
    public String selectedIconName;
    public int tabNameStringId;
    public String tabTag;
    public TabType tabType;
    public Color tintColor;

    public enum TabType {
        BITMAP,
        ICON,
        RESINT
    }

    public XesTabBottomInfo(int i, Bitmap bitmap, Bitmap bitmap2, String str) {
        this.tabNameStringId = i;
        this.defaultBitmap = bitmap;
        this.selectedBitmap = bitmap2;
        this.tabType = TabType.BITMAP;
        this.tabTag = str;
    }

    public XesTabBottomInfo(int i, int i2, int i3, Color color, Color color2, String str) {
        this.tabNameStringId = i;
        this.selectedBitmapRes = i2;
        this.defaultBitmapRes = i3;
        this.defaultColor = color;
        this.tintColor = color2;
        this.tabType = TabType.RESINT;
        this.tabTag = str;
    }

    public XesTabBottomInfo(int i, String str, String str2, String str3, Color color, Color color2, String str4) {
        this.tabNameStringId = i;
        this.iconFont = str;
        this.defaultIconName = str2;
        this.selectedIconName = str3;
        this.defaultColor = color;
        this.tintColor = color2;
        this.tabType = TabType.ICON;
        this.tabTag = str4;
    }
}
