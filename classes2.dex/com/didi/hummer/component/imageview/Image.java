package com.didi.hummer.component.imageview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.facebook.yoga.YogaUnit;
import java.io.Serializable;
import java.util.Map;

@Component("Image")
public class Image extends HMBase<RoundedImageView> {
    @Deprecated
    @JsProperty("gifRepeatCount")
    private int gifRepeatCount;
    @Deprecated
    @JsProperty("gifSrc")
    private String gifSrc;
    @Deprecated
    @JsProperty("src")
    private String src;

    private class ImageStyle implements Serializable {
        public String failedImage;
        public int gifRepeatCount;
        public String gifSrc;
        public String placeholder;
        public String src;

        private ImageStyle() {
        }
    }

    public Image(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    /* access modifiers changed from: protected */
    public RoundedImageView createViewInstance(Context context) {
        return new RoundedImageView(context);
    }

    public void onCreate() {
        super.onCreate();
        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundedImageView) getView()).setFocusable(true);
    }

    private void requestLayout() {
        getYogaNode().dirty();
        ((RoundedImageView) getView()).requestLayout();
    }

    /* access modifiers changed from: private */
    public void adjustWidthAndHeight(int i, int i2) {
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO && getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            setWidthAndHeight((float) i, (float) i2);
        } else if (getYogaNode().getWidth().unit == YogaUnit.AUTO || getYogaNode().getHeight().unit != YogaUnit.AUTO) {
            if (getYogaNode().getWidth().unit == YogaUnit.AUTO && getYogaNode().getHeight().unit != YogaUnit.AUTO) {
                if (getYogaNode().getHeight().unit == YogaUnit.PERCENT) {
                    ((RoundedImageView) getView()).post(new Image$$ExternalSyntheticLambda2(this, i2, i));
                    return;
                }
                float f = getYogaNode().getHeight().value;
                setWidthAndHeight((f / ((float) i2)) * ((float) i), f);
            }
        } else if (getYogaNode().getWidth().unit == YogaUnit.PERCENT) {
            ((RoundedImageView) getView()).post(new Image$$ExternalSyntheticLambda1(this, i, i2));
        } else {
            float f2 = getYogaNode().getWidth().value;
            setWidthAndHeight(f2, (f2 / ((float) i)) * ((float) i2));
        }
    }

    public /* synthetic */ void lambda$adjustWidthAndHeight$0$Image(int i, int i2) {
        float width = (float) ((RoundedImageView) getView()).getWidth();
        setWidthAndHeight(width, (width / ((float) i)) * ((float) i2));
    }

    public /* synthetic */ void lambda$adjustWidthAndHeight$1$Image(int i, int i2) {
        float height = (float) ((RoundedImageView) getView()).getHeight();
        setWidthAndHeight((height / ((float) i)) * ((float) i2), height);
    }

    private void setWidthAndHeight(float f, float f2) {
        getYogaNode().setWidth(f);
        getYogaNode().setHeight(f2);
        requestLayout();
    }

    @Deprecated
    public void setSrc(String str) {
        this.src = str;
        loadImage(str);
    }

    @Deprecated
    public void setGifSrc(String str) {
        this.gifSrc = str;
        loadGif(str, this.gifRepeatCount);
    }

    @Deprecated
    public void setGifRepeatCount(int i) {
        this.gifRepeatCount = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @com.didi.hummer.annotation.JsAttribute({"resize"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setContentMode(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case -1881872635: goto L_0x0028;
                case -1008619738: goto L_0x001e;
                case 94852023: goto L_0x0014;
                case 951526612: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0032
        L_0x000a:
            java.lang.String r0 = "contain"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = r2
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "cover"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = r1
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "origin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 0
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "stretch"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 3
            goto L_0x0033
        L_0x0032:
            r4 = -1
        L_0x0033:
            if (r4 == 0) goto L_0x005d
            if (r4 == r2) goto L_0x0051
            if (r4 == r1) goto L_0x0045
            android.view.View r4 = r3.getView()
            com.didi.hummer.component.imageview.RoundedImageView r4 = (com.didi.hummer.component.imageview.RoundedImageView) r4
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_XY
            r4.setScaleType(r0)
            goto L_0x0068
        L_0x0045:
            android.view.View r4 = r3.getView()
            com.didi.hummer.component.imageview.RoundedImageView r4 = (com.didi.hummer.component.imageview.RoundedImageView) r4
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER_CROP
            r4.setScaleType(r0)
            goto L_0x0068
        L_0x0051:
            android.view.View r4 = r3.getView()
            com.didi.hummer.component.imageview.RoundedImageView r4 = (com.didi.hummer.component.imageview.RoundedImageView) r4
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_CENTER
            r4.setScaleType(r0)
            goto L_0x0068
        L_0x005d:
            android.view.View r4 = r3.getView()
            com.didi.hummer.component.imageview.RoundedImageView r4 = (com.didi.hummer.component.imageview.RoundedImageView) r4
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER
            r4.setScaleType(r0)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.imageview.Image.setContentMode(java.lang.String):void");
    }

    @JsMethod("load")
    public void load(Object obj, JSCallback jSCallback) {
        ImageStyle imageStyle;
        if (obj instanceof String) {
            loadImage((String) obj, jSCallback);
        } else if ((obj instanceof Map) && (imageStyle = (ImageStyle) HMGsonUtil.fromJson(HMGsonUtil.toJson(obj), ImageStyle.class)) != null) {
            if (!TextUtils.isEmpty(imageStyle.gifSrc)) {
                loadGif(imageStyle.gifSrc, imageStyle.placeholder, imageStyle.failedImage, imageStyle.gifRepeatCount, jSCallback);
            } else if (!TextUtils.isEmpty(imageStyle.src)) {
                loadImage(imageStyle.src, imageStyle.placeholder, imageStyle.failedImage, jSCallback);
            }
        }
    }

    private void loadImage(String str) {
        loadImage(str, (String) null, (String) null, (JSCallback) null);
    }

    private void loadImage(String str, JSCallback jSCallback) {
        loadImage(str, (String) null, (String) null, jSCallback);
    }

    private void loadImage(String str, String str2, String str3, JSCallback jSCallback) {
        Image$$ExternalSyntheticLambda0 image$$ExternalSyntheticLambda0;
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO || getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            image$$ExternalSyntheticLambda0 = new Image$$ExternalSyntheticLambda0(this);
        } else {
            image$$ExternalSyntheticLambda0 = null;
        }
        ImageRenderUtil.renderImage((HummerContext) getContext(), (ImageView) getView(), str, str2, str3, image$$ExternalSyntheticLambda0, jSCallback);
        getNode().setContent(str);
    }

    private void loadGif(String str, int i) {
        loadGif(str, (String) null, (String) null, i, (JSCallback) null);
    }

    private void loadGif(String str, String str2, String str3, int i, JSCallback jSCallback) {
        Image$$ExternalSyntheticLambda0 image$$ExternalSyntheticLambda0;
        if (getYogaNode().getWidth().unit == YogaUnit.AUTO || getYogaNode().getHeight().unit == YogaUnit.AUTO) {
            image$$ExternalSyntheticLambda0 = new Image$$ExternalSyntheticLambda0(this);
        } else {
            image$$ExternalSyntheticLambda0 = null;
        }
        ImageRenderUtil.renderGif((HummerContext) getContext(), (ImageView) getView(), str, str2, str3, i, image$$ExternalSyntheticLambda0, jSCallback);
        getNode().setContent(str);
    }

    public void setBorderWidth(float f) {
        ((RoundedImageView) getView()).setBorderWidth(f);
    }

    public void setBorderColor(int i) {
        ((RoundedImageView) getView()).setBorderColor(i);
    }

    public void setBorderStyle(String str) {
        ((RoundedImageView) getView()).setBorderStyle(str);
    }

    public void setBorderRadius(Object obj) {
        super.setBorderRadius(obj);
        if (HummerStyleUtils.isPercentValue(obj)) {
            ((RoundedImageView) getView()).setBorderRadiusPercent(HummerStyleUtils.toPercent(obj) / 100.0f);
        } else if (obj instanceof Float) {
            ((RoundedImageView) getView()).setBorderRadius(((Float) obj).floatValue());
        }
    }

    public void setBorderTopLeftRadius(Object obj) {
        super.setBorderTopLeftRadius(obj);
        ((RoundedImageView) getView()).setCornerRadii(this.backgroundHelper.getBorderRadii());
    }

    public void setBorderTopRightRadius(Object obj) {
        super.setBorderTopRightRadius(obj);
        ((RoundedImageView) getView()).setCornerRadii(this.backgroundHelper.getBorderRadii());
    }

    public void setBorderBottomRightRadius(Object obj) {
        super.setBorderBottomRightRadius(obj);
        ((RoundedImageView) getView()).setCornerRadii(this.backgroundHelper.getBorderRadii());
    }

    public void setBorderBottomLeftRadius(Object obj) {
        super.setBorderBottomLeftRadius(obj);
        ((RoundedImageView) getView()).setCornerRadii(this.backgroundHelper.getBorderRadii());
    }

    public void resetStyle() {
        super.resetStyle();
        setContentMode("origin");
        setBorderWidth(0.0f);
        setBorderColor(0);
        setBorderRadius(0);
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -934437708:
                if (str.equals(HummerStyleUtils.Hummer.RESIZE)) {
                    c = 0;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = 1;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c = 2;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c = 3;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setContentMode(String.valueOf(obj));
                break;
            case 1:
                setBorderColor(((Integer) obj).intValue());
                break;
            case 2:
                setBorderStyle((String) obj);
                break;
            case 3:
                setBorderWidth(((Float) obj).floatValue());
                break;
            case 4:
                setBorderRadius(obj);
                break;
            default:
                return false;
        }
        return true;
    }
}
