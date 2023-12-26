package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

public class BadgeRule {
    private BadgeAnchor mAnchor;
    private int mOffset;

    public BadgeRule(BadgeAnchor badgeAnchor, int i) {
        this.mAnchor = badgeAnchor;
        this.mOffset = i;
    }

    public BadgeAnchor getAnchor() {
        return this.mAnchor;
    }

    public void setAnchor(BadgeAnchor badgeAnchor) {
        this.mAnchor = badgeAnchor;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public void setOffset(int i) {
        this.mOffset = i;
    }
}
