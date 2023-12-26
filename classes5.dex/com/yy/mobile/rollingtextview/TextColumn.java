package com.yy.mobile.rollingtextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.yalantis.ucrop.view.CropImageView;
import com.yy.mobile.rollingtextview.strategy.Direction;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\b\u00105\u001a\u000202H\u0002J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u001e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001fJ\u001c\u0010\u000e\u001a\u0002022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010>\u001a\u00020\nR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u000e\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u0013R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/yy/mobile/rollingtextview/TextColumn;", "", "manager", "Lcom/yy/mobile/rollingtextview/TextManager;", "textPaint", "Landroid/graphics/Paint;", "changeCharList", "", "", "direction", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "(Lcom/yy/mobile/rollingtextview/TextManager;Landroid/graphics/Paint;Ljava/util/List;Lcom/yy/mobile/rollingtextview/strategy/Direction;)V", "getChangeCharList", "()Ljava/util/List;", "setChangeCharList", "(Ljava/util/List;)V", "<set-?>", "currentChar", "getCurrentChar", "()C", "currentWidth", "", "getCurrentWidth", "()F", "setCurrentWidth", "(F)V", "getDirection", "()Lcom/yy/mobile/rollingtextview/strategy/Direction;", "setDirection", "(Lcom/yy/mobile/rollingtextview/strategy/Direction;)V", "edgeDelta", "", "firstCharWidth", "firstNotEmptyChar", "index", "", "getIndex", "()I", "setIndex", "(I)V", "lastCharWidth", "lastNotEmptyChar", "previousEdgeDelta", "sourceChar", "getSourceChar", "sourceWidth", "targetChar", "getTargetChar", "targetWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "initChangeCharList", "measure", "onAnimationEnd", "onAnimationUpdate", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "currentIndex", "offsetPercentage", "progress", "charList", "dir", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TextColumn.kt */
public final class TextColumn {
    private List<Character> changeCharList;
    private char currentChar;
    private float currentWidth;
    private Direction direction;
    private double edgeDelta;
    private float firstCharWidth;
    private char firstNotEmptyChar;
    private int index;
    private float lastCharWidth;
    private char lastNotEmptyChar;
    private final TextManager manager;
    private double previousEdgeDelta;
    private float sourceWidth;
    private float targetWidth;
    private final Paint textPaint;

    public TextColumn(TextManager textManager, Paint paint, List<Character> list, Direction direction2) {
        Intrinsics.checkNotNullParameter(textManager, "manager");
        Intrinsics.checkNotNullParameter(paint, "textPaint");
        Intrinsics.checkNotNullParameter(list, "changeCharList");
        Intrinsics.checkNotNullParameter(direction2, "direction");
        this.manager = textManager;
        this.textPaint = paint;
        this.changeCharList = list;
        this.direction = direction2;
        initChangeCharList();
    }

    public final List<Character> getChangeCharList() {
        return this.changeCharList;
    }

    public final void setChangeCharList(List<Character> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.changeCharList = list;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction2) {
        Intrinsics.checkNotNullParameter(direction2, "<set-?>");
        this.direction = direction2;
    }

    public final float getCurrentWidth() {
        return this.currentWidth;
    }

    public final void setCurrentWidth(float f) {
        this.currentWidth = f;
    }

    public final char getCurrentChar() {
        return this.currentChar;
    }

    public final char getSourceChar() {
        if (this.changeCharList.size() < 2) {
            return 0;
        }
        return ((Character) CollectionsKt.first(this.changeCharList)).charValue();
    }

    public final char getTargetChar() {
        if (this.changeCharList.isEmpty()) {
            return 0;
        }
        return ((Character) CollectionsKt.last(this.changeCharList)).charValue();
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void measure() {
        this.sourceWidth = this.manager.charWidth(getSourceChar(), this.textPaint);
        this.targetWidth = this.manager.charWidth(getTargetChar(), this.textPaint);
        this.currentWidth = Math.max(this.sourceWidth, this.firstCharWidth);
    }

    public final void setChangeCharList(List<Character> list, Direction direction2) {
        Intrinsics.checkNotNullParameter(list, "charList");
        Intrinsics.checkNotNullParameter(direction2, "dir");
        this.changeCharList = list;
        this.direction = direction2;
        initChangeCharList();
        this.index = 0;
        this.previousEdgeDelta = this.edgeDelta;
        this.edgeDelta = 0.0d;
    }

    private final void initChangeCharList() {
        Character ch;
        char c;
        Object obj;
        boolean z;
        boolean z2;
        if (this.changeCharList.size() < 2) {
            this.currentChar = getTargetChar();
        }
        Iterator it = this.changeCharList.iterator();
        while (true) {
            ch = null;
            c = 0;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Character) obj).charValue() != 0) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        Character ch2 = (Character) obj;
        char charValue = ch2 == null ? 0 : ch2.charValue();
        this.firstNotEmptyChar = charValue;
        this.firstCharWidth = this.manager.charWidth(charValue, this.textPaint);
        List<Character> list = this.changeCharList;
        ListIterator<Character> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Character previous = listIterator.previous();
            if (previous.charValue() != 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                ch = previous;
                break;
            }
        }
        Character ch3 = ch;
        if (ch3 != null) {
            c = ch3.charValue();
        }
        this.lastNotEmptyChar = c;
        this.lastCharWidth = this.manager.charWidth(c, this.textPaint);
        measure();
    }

    public final PreviousProgress onAnimationUpdate(int i, double d, double d2) {
        int i2;
        double d3;
        float f;
        this.index = i;
        this.currentChar = this.changeCharList.get(i).charValue();
        double d4 = this.previousEdgeDelta * (1.0d - d2);
        if (this.direction.getOrientation() == 0) {
            d3 = ((double) this.currentWidth) * d;
            i2 = this.direction.getValue();
        } else {
            d3 = ((double) this.manager.getTextHeight()) * d;
            i2 = this.direction.getValue();
        }
        this.edgeDelta = (d3 * ((double) i2)) + d4;
        char c = this.currentChar;
        if (c > 0) {
            float f2 = this.lastCharWidth;
            float f3 = this.firstCharWidth;
            f = ((f2 - f3) * ((float) d2)) + f3;
        } else {
            f = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float f4 = f;
        this.currentWidth = f4;
        return new PreviousProgress(this.index, d, d2, c, f4);
    }

    public final void onAnimationEnd() {
        this.currentChar = getTargetChar();
        this.edgeDelta = 0.0d;
        this.previousEdgeDelta = 0.0d;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        canvas.clipRect(0, clipBounds.top, (int) this.currentWidth, clipBounds.bottom);
        if (this.direction.getOrientation() == 0) {
            draw$drawText$default(this, canvas, this.index + 1, ((float) this.edgeDelta) - (this.currentWidth * ((float) this.direction.getValue())), CropImageView.DEFAULT_ASPECT_RATIO, 16, (Object) null);
            draw$drawText$default(this, canvas, this.index, (float) this.edgeDelta, CropImageView.DEFAULT_ASPECT_RATIO, 16, (Object) null);
            draw$drawText$default(this, canvas, this.index - 1, ((float) this.edgeDelta) + (this.currentWidth * ((float) this.direction.getValue())), CropImageView.DEFAULT_ASPECT_RATIO, 16, (Object) null);
        } else {
            draw$drawText$default(this, canvas, this.index + 1, CropImageView.DEFAULT_ASPECT_RATIO, ((float) this.edgeDelta) - (this.manager.getTextHeight() * ((float) this.direction.getValue())), 8, (Object) null);
            draw$drawText$default(this, canvas, this.index, CropImageView.DEFAULT_ASPECT_RATIO, (float) this.edgeDelta, 8, (Object) null);
            draw$drawText$default(this, canvas, this.index - 1, CropImageView.DEFAULT_ASPECT_RATIO, ((float) this.edgeDelta) + (this.manager.getTextHeight() * ((float) this.direction.getValue())), 8, (Object) null);
        }
        canvas.restoreToCount(save);
    }

    static /* synthetic */ void draw$drawText$default(TextColumn textColumn, Canvas canvas, int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f = 0.0f;
        }
        if ((i2 & 16) != 0) {
            f2 = 0.0f;
        }
        draw$drawText(textColumn, canvas, i, f, f2);
    }

    private static final char[] draw$drawText$charAt(TextColumn textColumn, int i) {
        char[] cArr = new char[1];
        for (int i2 = 0; i2 < 1; i2++) {
            cArr[i2] = textColumn.changeCharList.get(i).charValue();
        }
        return cArr;
    }

    private static final void draw$drawText(TextColumn textColumn, Canvas canvas, int i, float f, float f2) {
        if (i >= 0 && i < textColumn.changeCharList.size() && textColumn.changeCharList.get(i).charValue() != 0) {
            canvas.drawText(draw$drawText$charAt(textColumn, i), 0, 1, f, f2, textColumn.textPaint);
        }
    }
}
