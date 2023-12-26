package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tal.app.thinkacademy.lib.commui.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/StateImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ViewStateChange;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCustomState", "mCustomStateFour", "", "mCustomStateOne", "mCustomStateThree", "mCustomStateTwo", "stateAttrFour", "", "stateAttrOne", "stateAttrThree", "stateAttrTwo", "changeState", "", "state", "Lcom/tal/app/thinkcademy/lib/commui/widget/ViewState;", "value", "isState", "onCreateDrawableState", "extraSpace", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StateImageView.kt */
public final class StateImageView extends AppCompatImageView implements ViewStateChange {
    private int mCustomState;
    private boolean mCustomStateFour;
    private boolean mCustomStateOne;
    private boolean mCustomStateThree;
    private boolean mCustomStateTwo;
    private final int[] stateAttrFour;
    private final int[] stateAttrOne;
    private final int[] stateAttrThree;
    private final int[] stateAttrTwo;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StateImageView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewState.values().length];
            iArr[ViewState.ONE.ordinal()] = 1;
            iArr[ViewState.TWO.ordinal()] = 2;
            iArr[ViewState.THREE.ordinal()] = 3;
            iArr[ViewState.FOUR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StateImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stateAttrOne = new int[]{R.attr.custom_state_one};
        this.stateAttrTwo = new int[]{R.attr.custom_state_two};
        this.stateAttrThree = new int[]{R.attr.custom_state_three};
        this.stateAttrFour = new int[]{R.attr.custom_state_four};
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StateImageView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.StateImageView)");
            this.mCustomStateOne = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(R.styleable.StateImageView_custom_state_one), false);
            this.mCustomStateTwo = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(R.styleable.StateImageView_custom_state_two), false);
            this.mCustomStateThree = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(R.styleable.StateImageView_custom_state_three), false);
            this.mCustomStateFour = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(R.styleable.StateImageView_custom_state_four), false);
            obtainStyledAttributes.recycle();
            if (this.mCustomStateOne) {
                this.mCustomState = 1;
            } else if (this.mCustomStateTwo) {
                this.mCustomState = 2;
            } else if (this.mCustomStateThree) {
                this.mCustomState = 3;
            } else if (this.mCustomStateFour) {
                this.mCustomState = 4;
            }
            refreshDrawableState();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean isState(ViewState viewState) {
        boolean z;
        Intrinsics.checkNotNullParameter(viewState, "state");
        if (this.mCustomState == viewState.getValue()) {
            int i = WhenMappings.$EnumSwitchMapping$0[viewState.ordinal()];
            if (i == 1) {
                z = this.mCustomStateOne;
            } else if (i == 2) {
                z = this.mCustomStateTwo;
            } else if (i == 3) {
                z = this.mCustomStateThree;
            } else if (i == 4) {
                z = this.mCustomStateFour;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void changeState(ViewState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        changeState(viewState, true);
    }

    public void changeState(ViewState viewState, boolean z) {
        Intrinsics.checkNotNullParameter(viewState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[viewState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 && z != this.mCustomStateFour) {
                        this.mCustomState = viewState.getValue();
                        this.mCustomStateFour = z;
                        refreshDrawableState();
                    }
                } else if (z != this.mCustomStateThree) {
                    this.mCustomState = viewState.getValue();
                    this.mCustomStateThree = z;
                    refreshDrawableState();
                }
            } else if (z != this.mCustomStateTwo) {
                this.mCustomState = viewState.getValue();
                this.mCustomStateTwo = z;
                refreshDrawableState();
            }
        } else if (z != this.mCustomStateOne) {
            this.mCustomState = viewState.getValue();
            this.mCustomStateOne = z;
            refreshDrawableState();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.mCustomState <= 0 || (!this.mCustomStateOne && !this.mCustomStateTwo && !this.mCustomStateThree && !this.mCustomStateFour)) {
            int[] onCreateDrawableState = StateImageView.super.onCreateDrawableState(i);
            Intrinsics.checkNotNullExpressionValue(onCreateDrawableState, "super.onCreateDrawableState(extraSpace)");
            return onCreateDrawableState;
        }
        int[] onCreateDrawableState2 = StateImageView.super.onCreateDrawableState(i + 1);
        int i2 = this.mCustomState;
        if (i2 == ViewState.ONE.getValue()) {
            AppCompatImageView.mergeDrawableStates(onCreateDrawableState2, this.stateAttrOne);
        } else if (i2 == ViewState.TWO.getValue()) {
            AppCompatImageView.mergeDrawableStates(onCreateDrawableState2, this.stateAttrTwo);
        } else if (i2 == ViewState.THREE.getValue()) {
            AppCompatImageView.mergeDrawableStates(onCreateDrawableState2, this.stateAttrThree);
        } else if (i2 == ViewState.FOUR.getValue()) {
            AppCompatImageView.mergeDrawableStates(onCreateDrawableState2, this.stateAttrFour);
        }
        Intrinsics.checkNotNullExpressionValue(onCreateDrawableState2, "state");
        return onCreateDrawableState2;
    }
}
