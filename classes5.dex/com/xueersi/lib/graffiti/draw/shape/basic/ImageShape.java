package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.img.LoadImageManager;

public class ImageShape extends RectBoundShape {
    private LoadImageManager.Fetcher imageFetcher;

    public void setImageFetcher(LoadImageManager.Fetcher fetcher) {
        this.imageFetcher = fetcher;
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable;
        LoadImageManager.Fetcher fetcher = this.imageFetcher;
        if (fetcher != null && (drawable = fetcher.getDrawable()) != null) {
            try {
                drawable.setBounds(this.rect);
                drawable.draw(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ImageShape();
        }
    }
}
