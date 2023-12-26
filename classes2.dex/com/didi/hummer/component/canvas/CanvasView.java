package com.didi.hummer.component.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.utility.YogaResUtils;
import com.didi.hummer.utils.JsSourceUtil;

@Component("CanvasView")
public class CanvasView extends HMBase<CanvasDrawHelperView> {
    private HummerContext context;

    public CanvasView(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
        this.context = hummerContext;
    }

    /* access modifiers changed from: protected */
    public CanvasDrawHelperView createViewInstance(Context context2) {
        return new CanvasDrawHelperView(context2);
    }

    @JsMethod("getCanvasContext")
    public CanvasContext getCanvasContext() {
        return ((CanvasDrawHelperView) getView()).getCanvasContext();
    }

    @JsMethod("drawImage")
    public void drawImage(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6 = obj;
        if (obj6 instanceof Bitmap) {
            ((CanvasDrawHelperView) getView()).drawImage((Bitmap) obj6, obj2, obj3, obj4, obj5);
        } else if (obj6 instanceof String) {
            String str = (String) obj6;
            if (isRemoteImage(str)) {
                if (!TextUtils.isEmpty(str) && str.startsWith("//")) {
                    str = "https:" + str;
                }
                loadImageWithGlide(str, obj2, obj3, obj4, obj5);
            } else if (isLocalAbsoluteImage(str)) {
                loadImageWithGlide(str, obj2, obj3, obj4, obj5);
            } else if (isLocalRelativeImage(str)) {
                int jsSourceType = JsSourceUtil.getJsSourceType(this.context.getJsSourcePath());
                String realResourcePath = JsSourceUtil.getRealResourcePath(str, this.context.getJsSourcePath());
                if (jsSourceType == 1) {
                    loadImageWithGlide("file:///android_asset/" + realResourcePath, obj2, obj3, obj4, obj5);
                } else if (jsSourceType == 2) {
                    loadImageWithGlide(realResourcePath, obj2, obj3, obj4, obj5);
                }
            } else {
                ((CanvasDrawHelperView) getView()).drawImage(BitmapFactoryInstrumentation.decodeResource(((CanvasDrawHelperView) getView()).getContext().getResources(), YogaResUtils.getResourceId(str, "drawable", (String) null)), obj2, obj3, obj4, obj5);
            }
        }
    }

    private void loadImageWithGlide(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        final Object obj5 = obj;
        final Object obj6 = obj2;
        final Object obj7 = obj3;
        final Object obj8 = obj4;
        Glide.with(getContext()).asBitmap().load(str).into(new SimpleTarget<Bitmap>() {
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                ((CanvasDrawHelperView) CanvasView.this.getView()).drawImage(bitmap, obj5, obj6, obj7, obj8);
            }
        });
    }

    @JsMethod("fillRect")
    public void fillRect(Object obj, Object obj2, Object obj3, Object obj4) {
        ((CanvasDrawHelperView) getView()).fillRect(obj, obj2, obj3, obj4);
    }

    @JsMethod("strokeRect")
    public void strokeRect(Object obj, Object obj2, Object obj3, Object obj4) {
        ((CanvasDrawHelperView) getView()).strokeRect(obj, obj2, obj3, obj4);
    }

    @JsMethod("fillCircle")
    public void fillCircle(Object obj, Object obj2, Object obj3) {
        ((CanvasDrawHelperView) getView()).fillCircle(obj, obj2, obj3);
    }

    @JsMethod("strokeCircle")
    public void strokeCircle(Object obj, Object obj2, Object obj3) {
        ((CanvasDrawHelperView) getView()).strokeCircle(obj, obj2, obj3);
    }

    @JsMethod("fontSize")
    public void fontSize(float f) {
        ((CanvasDrawHelperView) getView()).fontSize(f);
    }

    @JsMethod("fillText")
    public void fillText(String str, Object obj, Object obj2, Object obj3) {
        ((CanvasDrawHelperView) getView()).fillText(str, obj, obj2, obj3);
    }

    @JsMethod("arc")
    public void arc(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        ((CanvasDrawHelperView) getView()).arc(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @JsMethod("drawLine")
    public void drawLine(Object obj, Object obj2, Object obj3, Object obj4) {
        ((CanvasDrawHelperView) getView()).drawLine(obj, obj2, obj3, obj4);
    }

    @JsMethod("drawLines")
    public void drawLines(Object[] objArr) {
        ((CanvasDrawHelperView) getView()).drawLines(objArr);
    }

    @JsMethod("strokeEllipse")
    public void ellipse(Object obj, Object obj2, Object obj3, Object obj4) {
        ((CanvasDrawHelperView) getView()).strokeEllipse(obj, obj2, obj3, obj4);
    }

    @JsMethod("fillEllipse")
    public void fillEllipse(Object obj, Object obj2, Object obj3, Object obj4) {
        ((CanvasDrawHelperView) getView()).fillEllipse(obj, obj2, obj3, obj4);
    }

    @JsMethod("lineWidth")
    public void lineWidth(float f) {
        ((CanvasDrawHelperView) getView()).lineWidth(f);
    }

    @JsMethod("lineColor")
    public void lineColor(String str) {
        ((CanvasDrawHelperView) getView()).lineColor(str);
    }

    @JsMethod("lineJoin")
    public void lineJoin(int i) {
        ((CanvasDrawHelperView) getView()).lineJoin(i);
    }

    @JsMethod("fillColor")
    public void fillColor(String str) {
        ((CanvasDrawHelperView) getView()).getCanvasContext().getLinePaint().setStyle(Paint.Style.FILL);
        ((CanvasDrawHelperView) getView()).fillColor(str);
    }

    @JsMethod("textColor")
    public void textColor(String str) {
        ((CanvasDrawHelperView) getView()).textColor(str);
    }

    @JsMethod("lineCap")
    public void lineCap(int i) {
        ((CanvasDrawHelperView) getView()).lineCap(i);
    }

    private static boolean isRemoteImage(String str) {
        return str != null && (str.startsWith("//") || str.toLowerCase().startsWith("http"));
    }

    private static boolean isLocalAbsoluteImage(String str) {
        return str != null && str.startsWith("/");
    }

    private static boolean isLocalRelativeImage(String str) {
        return str != null && str.startsWith("./");
    }
}
