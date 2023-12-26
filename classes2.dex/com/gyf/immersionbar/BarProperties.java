package com.gyf.immersionbar;

public class BarProperties {
    private int actionBarHeight;
    private boolean hasNavigationBar;
    private boolean landscapeLeft;
    private boolean landscapeRight;
    private int navigationBarHeight;
    private int navigationBarWidth;
    private int notchHeight;
    private boolean notchScreen;
    private boolean portrait;
    private int statusBarHeight;

    public boolean isPortrait() {
        return this.portrait;
    }

    /* access modifiers changed from: package-private */
    public void setPortrait(boolean z) {
        this.portrait = z;
    }

    public boolean isLandscapeLeft() {
        return this.landscapeLeft;
    }

    /* access modifiers changed from: package-private */
    public void setLandscapeLeft(boolean z) {
        this.landscapeLeft = z;
    }

    public boolean isLandscapeRight() {
        return this.landscapeRight;
    }

    /* access modifiers changed from: package-private */
    public void setLandscapeRight(boolean z) {
        this.landscapeRight = z;
    }

    public boolean isNotchScreen() {
        return this.notchScreen;
    }

    /* access modifiers changed from: package-private */
    public void setNotchScreen(boolean z) {
        this.notchScreen = z;
    }

    public boolean hasNavigationBar() {
        return this.hasNavigationBar;
    }

    /* access modifiers changed from: package-private */
    public void setNavigationBar(boolean z) {
        this.hasNavigationBar = z;
    }

    public int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    /* access modifiers changed from: package-private */
    public void setStatusBarHeight(int i) {
        this.statusBarHeight = i;
    }

    public int getNavigationBarHeight() {
        return this.navigationBarHeight;
    }

    /* access modifiers changed from: package-private */
    public void setNavigationBarHeight(int i) {
        this.navigationBarHeight = i;
    }

    public int getNavigationBarWidth() {
        return this.navigationBarWidth;
    }

    /* access modifiers changed from: package-private */
    public void setNavigationBarWidth(int i) {
        this.navigationBarWidth = i;
    }

    public int getNotchHeight() {
        return this.notchHeight;
    }

    /* access modifiers changed from: package-private */
    public void setNotchHeight(int i) {
        this.notchHeight = i;
    }

    public int getActionBarHeight() {
        return this.actionBarHeight;
    }

    /* access modifiers changed from: package-private */
    public void setActionBarHeight(int i) {
        this.actionBarHeight = i;
    }
}
