package com.yy.mobile.rollingtextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.yalantis.ucrop.view.CropImageView;
import com.yy.mobile.rollingtextview.strategy.Direction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020(J\f\u00102\u001a\u000203*\u00020\u000fH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u0019X\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/yy/mobile/rollingtextview/TextManager;", "", "textPaint", "Landroid/graphics/Paint;", "charOrderManager", "Lcom/yy/mobile/rollingtextview/CharOrderManager;", "(Landroid/graphics/Paint;Lcom/yy/mobile/rollingtextview/CharOrderManager;)V", "charListColumns", "", "", "currentText", "", "getCurrentText", "()[C", "currentTextWidth", "", "getCurrentTextWidth", "()F", "letterSpacingExtra", "", "getLetterSpacingExtra", "()I", "setLetterSpacingExtra", "(I)V", "map", "", "value", "textBaseline", "getTextBaseline", "setTextBaseline", "(F)V", "textColumns", "", "Lcom/yy/mobile/rollingtextview/TextColumn;", "<set-?>", "textHeight", "getTextHeight", "charWidth", "c", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onAnimationEnd", "setText", "targetText", "", "updateAnimation", "progress", "updateFontMatrics", "isZero", "", "Companion", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TextManager.kt */
public final class TextManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final char EMPTY = '\u0000';
    public static final float FLT_EPSILON = 1.1920929E-7f;
    private List<? extends List<Character>> charListColumns;
    private final CharOrderManager charOrderManager;
    private int letterSpacingExtra;
    private final Map<Character, Float> map = new LinkedHashMap(36);
    private float textBaseline;
    private final List<TextColumn> textColumns = new ArrayList();
    private float textHeight;
    private final Paint textPaint;

    private final boolean isZero(float f) {
        return f < 1.1920929E-7f && f > -1.1920929E-7f;
    }

    public TextManager(Paint paint, CharOrderManager charOrderManager2) {
        Intrinsics.checkNotNullParameter(paint, "textPaint");
        Intrinsics.checkNotNullParameter(charOrderManager2, "charOrderManager");
        this.textPaint = paint;
        this.charOrderManager = charOrderManager2;
        List<? extends List<Character>> emptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
        this.charListColumns = emptyList;
        updateFontMatrics();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/rollingtextview/TextManager$Companion;", "", "()V", "EMPTY", "", "FLT_EPSILON", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TextManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getLetterSpacingExtra() {
        return this.letterSpacingExtra;
    }

    public final void setLetterSpacingExtra(int i) {
        this.letterSpacingExtra = i;
    }

    public final float charWidth(char c, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "textPaint");
        if (c == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        Float f = this.map.get(Character.valueOf(c));
        if (f != null) {
            return f.floatValue();
        }
        float measureText = paint.measureText(String.valueOf(c));
        this.map.put(Character.valueOf(c), Float.valueOf(measureText));
        return measureText;
    }

    public final void updateFontMatrics() {
        this.map.clear();
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = fontMetrics.bottom - fontMetrics.top;
        setTextBaseline(-fontMetrics.top);
        for (TextColumn measure : this.textColumns) {
            measure.measure();
        }
    }

    public final void updateAnimation(float f) {
        PreviousProgress previousProgress = new PreviousProgress(0, 0.0d, (double) f, 0, CropImageView.DEFAULT_ASPECT_RATIO, 24, (DefaultConstructorMarker) null);
        List<TextColumn> list = this.textColumns;
        if (!list.isEmpty()) {
            ListIterator<TextColumn> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                int previousIndex = listIterator.previousIndex();
                TextColumn previous = listIterator.previous();
                NextProgress progress = this.charOrderManager.getProgress(previousProgress, previousIndex, this.charListColumns, previous.getIndex());
                previousProgress = previous.onAnimationUpdate(progress.getCurrentIndex(), progress.getOffsetPercentage(), progress.getProgress());
            }
        }
    }

    public final void onAnimationEnd() {
        for (TextColumn onAnimationEnd : this.textColumns) {
            onAnimationEnd.onAnimationEnd();
        }
        this.charOrderManager.afterCharOrder();
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (TextColumn textColumn : this.textColumns) {
            textColumn.draw(canvas);
            canvas.translate(textColumn.getCurrentWidth() + ((float) getLetterSpacingExtra()), CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    public final float getCurrentTextWidth() {
        int max = this.letterSpacingExtra * Math.max(0, this.textColumns.size() - 1);
        Iterable<TextColumn> iterable = this.textColumns;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TextColumn currentWidth : iterable) {
            arrayList.add(Float.valueOf(currentWidth.getCurrentWidth()));
        }
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        for (Number floatValue : (List) arrayList) {
            f += floatValue.floatValue();
        }
        return f + ((float) max);
    }

    public final void setText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "targetText");
        String str = new String(getCurrentText());
        int max = Math.max(str.length(), charSequence.length());
        CharSequence charSequence2 = str;
        this.charOrderManager.beforeCharOrder(charSequence2, charSequence);
        if (max > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Pair<List<Character>, Direction> findCharOrder = this.charOrderManager.findCharOrder(charSequence2, charSequence, i);
                List component1 = findCharOrder.component1();
                Direction component2 = findCharOrder.component2();
                if (i >= max - str.length()) {
                    this.textColumns.get(i).setChangeCharList(component1, component2);
                } else {
                    this.textColumns.add(i, new TextColumn(this, this.textPaint, component1, component2));
                }
                if (i2 >= max) {
                    break;
                }
                i = i2;
            }
        }
        Iterable<TextColumn> iterable = this.textColumns;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TextColumn changeCharList : iterable) {
            arrayList.add(changeCharList.getChangeCharList());
        }
        this.charListColumns = (List) arrayList;
    }

    public final char[] getCurrentText() {
        int size = this.textColumns.size();
        char[] cArr = new char[size];
        for (int i = 0; i < size; i++) {
            cArr[i] = this.textColumns.get(i).getCurrentChar();
        }
        return cArr;
    }

    public final float getTextHeight() {
        return this.textHeight;
    }

    public final float getTextBaseline() {
        return this.textBaseline;
    }

    private final void setTextBaseline(float f) {
        this.textBaseline = f;
    }
}
