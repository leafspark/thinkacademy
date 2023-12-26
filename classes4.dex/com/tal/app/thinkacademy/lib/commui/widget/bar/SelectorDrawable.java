package com.tal.app.thinkacademy.lib.commui.widget.bar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

public final class SelectorDrawable extends StateListDrawable {

    public static final class Builder {
        private Drawable mChecked;
        private Drawable mDefault;
        private Drawable mEnabled;
        private Drawable mFocused;
        private Drawable mHovered;
        private Drawable mPressed;
        private Drawable mSelected;

        public Builder setDefault(Drawable drawable) {
            this.mDefault = drawable;
            return this;
        }

        public Builder setFocused(Drawable drawable) {
            this.mFocused = drawable;
            return this;
        }

        public Builder setPressed(Drawable drawable) {
            this.mPressed = drawable;
            return this;
        }

        public Builder setChecked(Drawable drawable) {
            this.mChecked = drawable;
            return this;
        }

        public Builder setEnabled(Drawable drawable) {
            this.mEnabled = drawable;
            return this;
        }

        public Builder setSelected(Drawable drawable) {
            this.mSelected = drawable;
            return this;
        }

        public Builder setHovered(Drawable drawable) {
            this.mHovered = drawable;
            return this;
        }

        public SelectorDrawable build() {
            SelectorDrawable selectorDrawable = new SelectorDrawable();
            Drawable drawable = this.mPressed;
            if (drawable != null) {
                selectorDrawable.addState(new int[]{16842919}, drawable);
            }
            Drawable drawable2 = this.mFocused;
            if (drawable2 != null) {
                selectorDrawable.addState(new int[]{16842908}, drawable2);
            }
            Drawable drawable3 = this.mChecked;
            if (drawable3 != null) {
                selectorDrawable.addState(new int[]{16842912}, drawable3);
            }
            Drawable drawable4 = this.mEnabled;
            if (drawable4 != null) {
                selectorDrawable.addState(new int[]{16842910}, drawable4);
            }
            Drawable drawable5 = this.mSelected;
            if (drawable5 != null) {
                selectorDrawable.addState(new int[]{16842913}, drawable5);
            }
            if (this.mHovered != null && Build.VERSION.SDK_INT >= 14) {
                selectorDrawable.addState(new int[]{16843623}, this.mHovered);
            }
            Drawable drawable6 = this.mDefault;
            if (drawable6 != null) {
                selectorDrawable.addState(new int[0], drawable6);
            }
            return selectorDrawable;
        }
    }
}
