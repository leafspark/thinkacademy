package com.xueersi.tborad.extensions.rule;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import com.xueersi.lib.graffiti.utils.Utils;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.tborad.extensions.compasses.CompassesProtoBean;
import com.yalantis.ucrop.view.CropImageView;

public class CompassesDrawable extends BaseDrawable<CompassesProtoBean.CompassesConfig> {
    private static final String TAG = "CompassesDrawable";
    private float abDistance = CropImageView.DEFAULT_ASPECT_RATIO;
    private float angle;
    private float ax;
    private float ay;
    private final BitmapFactory.Options bitmapOption;
    private float bx;
    private float by;
    private final ColorBitmapData colorBitmapData = new ColorBitmapData();
    private Context context;
    private float cx;
    private float cy;
    private float halfHeadIconWidth = CropImageView.DEFAULT_ASPECT_RATIO;
    private float headIconHeight = CropImageView.DEFAULT_ASPECT_RATIO;
    private final boolean isDebug = false;
    private float leftIconWidth = CropImageView.DEFAULT_ASPECT_RATIO;
    private float midAxleIconRadius = CropImageView.DEFAULT_ASPECT_RATIO;
    private final Paint paint;
    private String penPointerColor = "#000000";
    private final RectF rect = new RectF();
    private float rightIconWidth = CropImageView.DEFAULT_ASPECT_RATIO;
    private float rotate;
    private float sax;
    private float say;
    private float sbx;
    private float sby;
    private float scx;
    private float scy;

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public CompassesDrawable() {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.bitmapOption = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public void draw(Canvas canvas) {
        if (initDrawData()) {
            canvas.save();
            this.context = this.context.getApplicationContext();
            float f = this.rotate;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                canvas.rotate((float) Math.toDegrees((double) f), this.ax, this.ay);
            }
            drawLeftLeg(canvas);
            drawRightLeg(canvas);
            drawTopPic(canvas);
            canvas.restore();
            Log.d(TAG, "draw: 正常绘制");
            return;
        }
        Log.d(TAG, "draw: 无法绘制");
        XesLog.i("圆规无法正常绘制");
    }

    private void drawTest(Canvas canvas) {
        canvas.save();
        float f = this.rotate;
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            canvas.rotate((float) Math.toDegrees((double) f), this.ax, this.ay);
        }
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(Color.parseColor(this.penPointerColor));
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setTextSize(16.0f);
        Path path = new Path();
        path.moveTo(this.ax, this.ay);
        path.lineTo(this.bx, this.by);
        path.lineTo(this.cx, this.cy);
        canvas.drawText("A", this.ax, this.ay, paint2);
        canvas.drawText("C", this.cx, this.cy, paint2);
        path.close();
        canvas.drawPath(path, paint2);
        canvas.restore();
    }

    private void drawTopPic(Canvas canvas) {
        Bitmap resBitmap = Utils.getResBitmap(this.context, "handler", this.bitmapOption);
        this.rect.bottom = (this.by - this.midAxleIconRadius) + (this.headIconHeight / 3.0f);
        RectF rectF = this.rect;
        rectF.top = rectF.bottom - this.headIconHeight;
        this.rect.left = this.bx - this.halfHeadIconWidth;
        this.rect.right = this.bx + this.halfHeadIconWidth;
        if (resBitmap != null) {
            canvas.drawBitmap(resBitmap, (Rect) null, this.rect, this.paint);
        }
        Bitmap resBitmap2 = Utils.getResBitmap(this.context, "middle_axle", this.bitmapOption);
        this.rect.top = this.by - this.midAxleIconRadius;
        this.rect.bottom = this.by + this.midAxleIconRadius;
        this.rect.left = this.bx - this.midAxleIconRadius;
        this.rect.right = this.bx + this.midAxleIconRadius;
        if (resBitmap2 != null) {
            canvas.drawBitmap(resBitmap2, (Rect) null, this.rect, this.paint);
        }
    }

    private void drawRightLeg(Canvas canvas) {
        canvas.save();
        canvas.rotate(-((float) Math.toDegrees((double) (this.angle / 2.0f))), this.cx, this.cy);
        Bitmap bitmap = this.colorBitmapData.getBitmap(this.context, this.penPointerColor, this.bitmapOption);
        this.rect.top = this.ay - this.abDistance;
        this.rect.bottom = this.ay;
        RectF rectF = this.rect;
        float f = this.ax;
        rectF.left = f + Utils.getAccurancyDistance(f, this.ay, this.cx, this.cy);
        RectF rectF2 = this.rect;
        rectF2.right = rectF2.left + this.rightIconWidth;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.rect, this.paint);
        }
        canvas.restore();
    }

    private void drawLeftLeg(Canvas canvas) {
        canvas.save();
        canvas.rotate((float) Math.toDegrees((double) (this.angle / 2.0f)), this.ax, this.ay);
        Bitmap resBitmap = Utils.getResBitmap(this.context, "fix_foot", this.bitmapOption);
        this.rect.top = this.ay - this.abDistance;
        this.rect.bottom = this.ay;
        this.rect.left = this.ax - this.leftIconWidth;
        this.rect.right = this.ax;
        if (resBitmap != null) {
            canvas.drawBitmap(resBitmap, (Rect) null, this.rect, this.paint);
        }
        canvas.restore();
    }

    private boolean initDrawData() {
        Log.d(TAG, "initDrawData" + getBounds().width());
        if (this.context == null || getBounds().width() == 0) {
            return false;
        }
        this.ax = getX(this.sax);
        this.ay = getY(this.say);
        this.bx = getX(this.sbx);
        this.by = getY(this.sby);
        this.cx = getX(this.scx);
        this.cy = getY(this.scy);
        this.abDistance = Utils.getAccurancyDistance(this.ax, this.ay, this.bx, this.by);
        float f = CompassesExtension.CENTER_WIDTH;
        float f2 = this.abDistance;
        this.midAxleIconRadius = (f * f2) / 2.0f;
        this.leftIconWidth = f2 * CompassesExtension.LEFT_LEG_WIDTH;
        this.rightIconWidth = this.abDistance * CompassesExtension.RIGHT_LEG_WIDTH;
        float f3 = this.abDistance * CompassesExtension.CENTER_HANDLER_HEIGHT;
        this.headIconHeight = f3;
        this.halfHeadIconWidth = f3 / 6.9f;
        return true;
    }

    public void updateConfig(CompassesProtoBean.CompassesConfig compassesConfig, Context context2) {
        super.updateConfig(compassesConfig);
        this.context = context2;
        CompassesProtoBean.CompassesPosition compassPos = compassesConfig.getCompassPos();
        CompassesProtoBean.CompassesPosition compassPos1 = compassesConfig.getCompassPos1();
        CompassesProtoBean.CompassesPosition compassPos2 = compassesConfig.getCompassPos2();
        this.sax = compassPos.getX();
        this.say = compassPos.getY();
        this.sbx = compassPos1.getX();
        this.sby = compassPos1.getY();
        this.scx = compassPos2.getX();
        this.scy = compassPos2.getY();
        this.penPointerColor = Utils.getRGBbyRGBA(compassesConfig.getPenPointerColor());
        this.rotate = compassesConfig.getRotate();
        this.angle = compassesConfig.getAngle();
    }

    static class ColorBitmapData {
        private Bitmap bitmap;
        private String color;

        ColorBitmapData() {
        }

        public Bitmap getBitmap(Context context, String str, BitmapFactory.Options options) {
            Bitmap resBitmap = Utils.getResBitmap(context, "move_foot", options);
            if (TextUtils.isEmpty(str)) {
                return resBitmap;
            }
            if (TextUtils.equals(str, this.color)) {
                return this.bitmap;
            }
            this.color = str;
            Bitmap createTargetColorIcon = createTargetColorIcon(str, resBitmap, Utils.getResBitmap(context, "move_foot_color", options), context);
            this.bitmap = createTargetColorIcon;
            return createTargetColorIcon;
        }

        private Bitmap createTargetColorIcon(String str, Bitmap bitmap2, Bitmap bitmap3, Context context) {
            Bitmap copy = bitmap3.copy(Bitmap.Config.ARGB_4444, true);
            Canvas canvas = new Canvas(copy);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 2));
            canvas.drawColor(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new BitmapDrawable(context.getResources(), bitmap2), new BitmapDrawable(context.getResources(), copy)});
            Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(createBitmap);
            canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 2));
            layerDrawable.setBounds(new Rect(0, 0, canvas2.getWidth(), canvas2.getHeight()));
            layerDrawable.draw(canvas2);
            return createBitmap;
        }
    }
}
