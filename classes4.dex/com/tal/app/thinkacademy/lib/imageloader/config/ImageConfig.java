package com.tal.app.thinkacademy.lib.imageloader.config;

import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/config/ImageConfig;", "", "()V", "<set-?>", "", "drawableId", "getDrawableId", "()I", "setDrawableId", "(I)V", "errorPic", "getErrorPic", "setErrorPic", "Landroid/widget/ImageView;", "imageView", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "placeholder", "getPlaceholder", "setPlaceholder", "", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageConfig.kt */
public class ImageConfig {
    private int drawableId;
    private int errorPic;
    private ImageView imageView;
    private int placeholder;
    private String url;

    public final String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getDrawableId() {
        return this.drawableId;
    }

    /* access modifiers changed from: protected */
    public final void setDrawableId(int i) {
        this.drawableId = i;
    }

    public final ImageView getImageView() {
        return this.imageView;
    }

    /* access modifiers changed from: protected */
    public final void setImageView(ImageView imageView2) {
        this.imageView = imageView2;
    }

    public final int getPlaceholder() {
        return this.placeholder;
    }

    /* access modifiers changed from: protected */
    public final void setPlaceholder(int i) {
        this.placeholder = i;
    }

    public final int getErrorPic() {
        return this.errorPic;
    }

    /* access modifiers changed from: protected */
    public final void setErrorPic(int i) {
        this.errorPic = i;
    }
}
