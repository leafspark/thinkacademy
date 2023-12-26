package com.tal.app.thinkacademy.live.business.keyboardfill.keyboard;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.adapter.NumAndMarkKeyBoardAdapter;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.animator.KeyboardAnimator;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002LMB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020'H\u0002J\u0006\u00101\u001a\u00020'J\b\u00102\u001a\u00020'H\u0002J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020'J\b\u00106\u001a\u00020'H\u0003J\b\u00107\u001a\u00020'H\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u00020'H\u0002J\b\u0010@\u001a\u00020'H\u0002J\u000e\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u000204J\u0010\u0010C\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u001f\u0010D\u001a\u00020'2\u0017\u0010E\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020'0F¢\u0006\u0002\bGJ\u0006\u0010H\u001a\u00020'J\u0010\u0010I\u001a\u00020'2\u0006\u0010H\u001a\u00020\nH\u0002J\u000e\u0010J\u001a\u00020'2\u0006\u0010/\u001a\u00020\nJ\u0012\u0010K\u001a\u00020'2\b\b\u0002\u0010H\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDenominatorClearAll", "", "isNumeratorClearAll", "isShowModel", "mBgTopBook", "Landroid/view/View;", "mBtnSubmit", "Landroid/widget/TextView;", "mBtnToggleShow", "Landroid/widget/ImageView;", "mEtInputDenominator", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/FillInEditText;", "mEtInputNumerator", "mEtInputText", "mFocusFlag", "mGroupAnswer", "mKeyboard", "Landroidx/recyclerview/widget/RecyclerView;", "mKeyboardAdapter", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/adapter/NumAndMarkKeyBoardAdapter;", "mKeyboardAnimators", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/animator/KeyboardAnimator;", "mKeyboardListener", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard$OnKeyboardListener;", "mLayoutFraction", "mLayoutInput", "mOldFocusFlag", "mToggleShow", "mTvInputHint", "autoAdaptInputContent", "", "changeFocusFlag", "flag", "changeFractionViewOnShowModel", "changeFractionViewSize", "changeShowModelUI", "clearFlagFocus", "clearInputMenu", "enable", "controlInputHint", "destroy", "disableShowInput", "getAllEditTextContent", "", "hide", "initListener", "initView", "inputKeyboardText", "s", "inputTextChanged", "isFractionShown", "isMaxCharacterNumber", "numberCheck", "text", "processCleEditText", "processDelEditText", "recoveryData", "data", "requestFlagFocus", "setOnKeyboardListener", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "show", "showFraction", "showModel", "toggleShowKeyboard", "Companion", "OnKeyboardListener", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NumAndMarkKeyboard.kt */
public final class NumAndMarkKeyboard extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Integer[] IM_KEYS = {Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_1), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_2), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_3), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_4), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_5), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_fraction), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_plus), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_reduce), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_ride), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_except), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_delete), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_6), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_7), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_8), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_9), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_0), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_point), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_less), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_more), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_percent), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_equal), Integer.valueOf(R.drawable.ic_live_business_keyboard_menu_clear)};
    private static final String[] KEYS = {"1", "2", "3", "4", TopicConfig.OPTIONS_TRUEFALSE_TYPE, "/", "+", "-", "×", "÷", "del", "6", "7", "8", "9", EnterRoomMuteData.STATUS_UN_MUTE, ".", "<", ">", "%", "=", "ac"};
    private static final int MAX_NUMBER = 20;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.KEYBOARD_FILL;
    private static final String TAG_DIV = "\\div";
    private static final String TAG_FRACTION = "\\frac";
    private static final String TAG_TIMES = "\\times";
    private boolean isDenominatorClearAll;
    private boolean isNumeratorClearAll;
    private boolean isShowModel;
    private View mBgTopBook;
    private TextView mBtnSubmit;
    private ImageView mBtnToggleShow;
    /* access modifiers changed from: private */
    public FillInEditText mEtInputDenominator;
    private FillInEditText mEtInputNumerator;
    /* access modifiers changed from: private */
    public FillInEditText mEtInputText;
    /* access modifiers changed from: private */
    public int mFocusFlag;
    private View mGroupAnswer;
    private RecyclerView mKeyboard;
    private NumAndMarkKeyBoardAdapter mKeyboardAdapter;
    private KeyboardAnimator mKeyboardAnimators;
    /* access modifiers changed from: private */
    public OnKeyboardListener mKeyboardListener;
    private View mLayoutFraction;
    private ConstraintLayout mLayoutInput;
    private int mOldFocusFlag;
    private boolean mToggleShow;
    private TextView mTvInputHint;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NumAndMarkKeyboard(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NumAndMarkKeyboard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NumAndMarkKeyboard(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NumAndMarkKeyboard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOldFocusFlag = -1;
        this.mFocusFlag = -1;
        this.mToggleShow = true;
        initView();
        initListener();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard$Companion;", "", "()V", "IM_KEYS", "", "", "[Ljava/lang/Integer;", "KEYS", "", "[Ljava/lang/String;", "MAX_NUMBER", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TAG_DIV", "TAG_FRACTION", "TAG_TIMES", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NumAndMarkKeyboard.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void initView() {
        ConstraintLayout.inflate(getContext(), R.layout.layout_keyboard_num_mark, (ViewGroup) this);
        View findViewById = findViewById(R.id.btn_toggle_show);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.btn_toggle_show)");
        this.mBtnToggleShow = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.btn_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.btn_submit)");
        this.mBtnSubmit = (TextView) findViewById2;
        ConstraintLayout findViewById3 = findViewById(R.id.layout_input);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_input)");
        this.mLayoutInput = findViewById3;
        View findViewById4 = findViewById(R.id.tv_input_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_input_hint)");
        this.mTvInputHint = (TextView) findViewById4;
        RecyclerView findViewById5 = findViewById(R.id.recycler_keyboard);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.recycler_keyboard)");
        this.mKeyboard = findViewById5;
        View findViewById6 = findViewById(R.id.et_input_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.et_input_text)");
        this.mEtInputText = (FillInEditText) findViewById6;
        View findViewById7 = findViewById(R.id.et_input_numerator);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.et_input_numerator)");
        this.mEtInputNumerator = (FillInEditText) findViewById7;
        View findViewById8 = findViewById(R.id.et_input_denominator);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.et_input_denominator)");
        this.mEtInputDenominator = (FillInEditText) findViewById8;
        View findViewById9 = findViewById(R.id.ll_input_fraction);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.ll_input_fraction)");
        this.mLayoutFraction = findViewById9;
        View findViewById10 = findViewById(R.id.group_answer);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.group_answer)");
        this.mGroupAnswer = findViewById10;
        View findViewById11 = findViewById(R.id.iv_top_bg_book);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.iv_top_bg_book)");
        this.mBgTopBook = findViewById11;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mKeyboardAdapter = new NumAndMarkKeyBoardAdapter(context, KEYS, IM_KEYS);
        RecyclerView recyclerView = this.mKeyboard;
        RecyclerView.Adapter adapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mKeyboard");
            recyclerView = null;
        }
        RecyclerView.Adapter adapter2 = this.mKeyboardAdapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mKeyboardAdapter");
        } else {
            adapter = adapter2;
        }
        recyclerView.setAdapter(adapter);
        disableShowInput();
        this.mKeyboardAnimators = new KeyboardAnimator();
        setVisibility(4);
    }

    private final void initListener() {
        ImageView imageView = this.mBtnToggleShow;
        NumAndMarkKeyBoardAdapter numAndMarkKeyBoardAdapter = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnToggleShow");
            imageView = null;
        }
        imageView.setOnClickListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda0(this));
        ImageView imageView2 = this.mBtnToggleShow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnToggleShow");
            imageView2 = null;
        }
        imageView2.setOnTouchListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda10(this));
        TextView textView = this.mBtnSubmit;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            textView = null;
        }
        textView.setOnClickListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda3(this));
        TextView textView2 = this.mBtnSubmit;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            textView2 = null;
        }
        textView2.setOnTouchListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda9(this));
        ConstraintLayout constraintLayout = this.mLayoutInput;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutInput");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda2(this));
        FillInEditText fillInEditText = this.mEtInputText;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        fillInEditText.setLongClickable(false);
        FillInEditText fillInEditText2 = this.mEtInputNumerator;
        if (fillInEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText2 = null;
        }
        fillInEditText2.setLongClickable(false);
        FillInEditText fillInEditText3 = this.mEtInputDenominator;
        if (fillInEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText3 = null;
        }
        fillInEditText3.setLongClickable(false);
        FillInEditText fillInEditText4 = this.mEtInputText;
        if (fillInEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText4 = null;
        }
        ((TextView) fillInEditText4).addTextChangedListener(new NumAndMarkKeyboard$initListener$$inlined$addTextChangedListener$default$1(this));
        FillInEditText fillInEditText5 = this.mEtInputNumerator;
        if (fillInEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText5 = null;
        }
        ((TextView) fillInEditText5).addTextChangedListener(new NumAndMarkKeyboard$initListener$$inlined$addTextChangedListener$default$2(this));
        FillInEditText fillInEditText6 = this.mEtInputDenominator;
        if (fillInEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText6 = null;
        }
        ((TextView) fillInEditText6).addTextChangedListener(new NumAndMarkKeyboard$initListener$$inlined$addTextChangedListener$default$3(this));
        FillInEditText fillInEditText7 = this.mEtInputText;
        if (fillInEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText7 = null;
        }
        fillInEditText7.setOnFocusChangeListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda6(this));
        FillInEditText fillInEditText8 = this.mEtInputNumerator;
        if (fillInEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText8 = null;
        }
        fillInEditText8.setOnFocusChangeListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda4(this));
        FillInEditText fillInEditText9 = this.mEtInputDenominator;
        if (fillInEditText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText9 = null;
        }
        fillInEditText9.setOnFocusChangeListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda5(this));
        FillInEditText fillInEditText10 = this.mEtInputText;
        if (fillInEditText10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText10 = null;
        }
        fillInEditText10.setOnTouchListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda1(this));
        FillInEditText fillInEditText11 = this.mEtInputNumerator;
        if (fillInEditText11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText11 = null;
        }
        fillInEditText11.setOnTouchListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda7(this));
        FillInEditText fillInEditText12 = this.mEtInputDenominator;
        if (fillInEditText12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText12 = null;
        }
        fillInEditText12.setOnTouchListener(new NumAndMarkKeyboard$$ExternalSyntheticLambda8(this));
        NumAndMarkKeyBoardAdapter numAndMarkKeyBoardAdapter2 = this.mKeyboardAdapter;
        if (numAndMarkKeyBoardAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mKeyboardAdapter");
        } else {
            numAndMarkKeyBoardAdapter = numAndMarkKeyBoardAdapter2;
        }
        numAndMarkKeyBoardAdapter.setOnItemClickListener(new NumAndMarkKeyboard$initListener$15(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-0  reason: not valid java name */
    public static final void m309initListener$lambda0(NumAndMarkKeyboard numAndMarkKeyboard, View view) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        boolean z = !numAndMarkKeyboard.mToggleShow;
        if (z) {
            numAndMarkKeyboard.requestFlagFocus(numAndMarkKeyboard.mOldFocusFlag);
        } else {
            numAndMarkKeyboard.clearFlagFocus();
        }
        numAndMarkKeyboard.toggleShowKeyboard(z);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-1  reason: not valid java name */
    public static final boolean m310initListener$lambda1(NumAndMarkKeyboard numAndMarkKeyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (motionEvent.getAction() == 0) {
            SoundPoolUtils.play(numAndMarkKeyboard.getContext(), R.raw.live_business_keyboard_press_key, 0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-2  reason: not valid java name */
    public static final void m315initListener$lambda2(NumAndMarkKeyboard numAndMarkKeyboard, View view) {
        Function1<String, Unit> submitClickBlock$bus_livebusiness_release;
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        OnKeyboardListener onKeyboardListener = numAndMarkKeyboard.mKeyboardListener;
        if (!(onKeyboardListener == null || (submitClickBlock$bus_livebusiness_release = onKeyboardListener.getSubmitClickBlock$bus_livebusiness_release()) == null)) {
            submitClickBlock$bus_livebusiness_release.invoke(numAndMarkKeyboard.getAllEditTextContent());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-3  reason: not valid java name */
    public static final boolean m316initListener$lambda3(NumAndMarkKeyboard numAndMarkKeyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (motionEvent.getAction() == 0) {
            SoundPoolUtils.play(numAndMarkKeyboard.getContext(), R.raw.live_business_keyboard_press_key, 0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-4  reason: not valid java name */
    public static final void m317initListener$lambda4(NumAndMarkKeyboard numAndMarkKeyboard, View view) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (numAndMarkKeyboard.mFocusFlag != 1) {
            FillInEditText fillInEditText = numAndMarkKeyboard.mEtInputText;
            if (fillInEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText = null;
            }
            fillInEditText.requestFocus();
        }
        toggleShowKeyboard$default(numAndMarkKeyboard, false, 1, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-8  reason: not valid java name */
    public static final void m318initListener$lambda8(NumAndMarkKeyboard numAndMarkKeyboard, View view, boolean z) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (z) {
            numAndMarkKeyboard.changeFocusFlag(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-9  reason: not valid java name */
    public static final void m319initListener$lambda9(NumAndMarkKeyboard numAndMarkKeyboard, View view, boolean z) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (z) {
            numAndMarkKeyboard.changeFocusFlag(2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-10  reason: not valid java name */
    public static final void m311initListener$lambda10(NumAndMarkKeyboard numAndMarkKeyboard, View view, boolean z) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (z) {
            numAndMarkKeyboard.changeFocusFlag(3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-11  reason: not valid java name */
    public static final boolean m312initListener$lambda11(NumAndMarkKeyboard numAndMarkKeyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (motionEvent.getAction() == 1) {
            numAndMarkKeyboard.requestFlagFocus(1);
            toggleShowKeyboard$default(numAndMarkKeyboard, false, 1, (Object) null);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-12  reason: not valid java name */
    public static final boolean m313initListener$lambda12(NumAndMarkKeyboard numAndMarkKeyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (motionEvent.getAction() == 1) {
            numAndMarkKeyboard.requestFlagFocus(2);
            toggleShowKeyboard$default(numAndMarkKeyboard, false, 1, (Object) null);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-13  reason: not valid java name */
    public static final boolean m314initListener$lambda13(NumAndMarkKeyboard numAndMarkKeyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyboard, "this$0");
        if (motionEvent.getAction() == 1) {
            numAndMarkKeyboard.requestFlagFocus(3);
            toggleShowKeyboard$default(numAndMarkKeyboard, false, 1, (Object) null);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void showFraction(boolean z) {
        View view = this.mLayoutFraction;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutFraction");
            view = null;
        }
        view.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final boolean isFractionShown() {
        View view = this.mLayoutFraction;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutFraction");
            view = null;
        }
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public final void inputTextChanged() {
        FillInEditText fillInEditText = this.mEtInputText;
        TextView textView = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        if (TextUtils.isEmpty(fillInEditText.getText())) {
            FillInEditText fillInEditText2 = this.mEtInputNumerator;
            if (fillInEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText2 = null;
            }
            if (TextUtils.isEmpty(fillInEditText2.getText())) {
                FillInEditText fillInEditText3 = this.mEtInputDenominator;
                if (fillInEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                    fillInEditText3 = null;
                }
                if (TextUtils.isEmpty(fillInEditText3.getText())) {
                    TextView textView2 = this.mBtnSubmit;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
                        textView2 = null;
                    }
                    textView2.setClickable(false);
                    TextView textView3 = this.mBtnSubmit;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
                        textView3 = null;
                    }
                    textView3.setFocusable(false);
                    TextView textView4 = this.mBtnSubmit;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
                    } else {
                        textView = textView4;
                    }
                    textView.setBackgroundResource(R.drawable.ic_live_business_keyboard_submit_gray);
                    controlInputHint();
                }
            }
        }
        TextView textView5 = this.mBtnSubmit;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            textView5 = null;
        }
        textView5.setClickable(true);
        TextView textView6 = this.mBtnSubmit;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            textView6 = null;
        }
        textView6.setFocusable(true);
        TextView textView7 = this.mBtnSubmit;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
        } else {
            textView = textView7;
        }
        textView.setBackgroundResource(R.drawable.ic_live_business_keyboard_submit);
        controlInputHint();
    }

    private final void controlInputHint() {
        TextView textView = null;
        if (this.mFocusFlag != 1) {
            FillInEditText fillInEditText = this.mEtInputText;
            if (fillInEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText = null;
            }
            if (TextUtils.isEmpty(fillInEditText.getText())) {
                View view = this.mLayoutFraction;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLayoutFraction");
                    view = null;
                }
                if (view.getVisibility() == 8) {
                    TextView textView2 = this.mTvInputHint;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvInputHint");
                    } else {
                        textView = textView2;
                    }
                    textView.setVisibility(0);
                    return;
                }
            }
        }
        TextView textView3 = this.mTvInputHint;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvInputHint");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void autoAdaptInputContent() {
        FillInEditText fillInEditText = this.mEtInputText;
        FillInEditText fillInEditText2 = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        if (TextUtils.isEmpty(fillInEditText.getText())) {
            FillInEditText fillInEditText3 = this.mEtInputText;
            if (fillInEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText3 = null;
            }
            Editable text = fillInEditText3.getText();
            int length = text == null ? 0 : text.length();
            if (isFractionShown()) {
                XesLog.i(TAG, Intrinsics.stringPlus("processEditTextContentChange len ", Integer.valueOf(length)));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SizeUtils.dp2px(18.0f), SizeUtils.dp2px(84.0f));
                FillInEditText fillInEditText4 = this.mEtInputText;
                if (fillInEditText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                    fillInEditText4 = null;
                }
                fillInEditText4.setLayoutParams(layoutParams);
                FillInEditText fillInEditText5 = this.mEtInputText;
                if (fillInEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                } else {
                    fillInEditText2 = fillInEditText5;
                }
                fillInEditText2.setGravity(8388629);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(SizeUtils.dp2px(48.0f), SizeUtils.dp2px(84.0f));
            FillInEditText fillInEditText6 = this.mEtInputText;
            if (fillInEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText6 = null;
            }
            fillInEditText6.setLayoutParams(layoutParams2);
            FillInEditText fillInEditText7 = this.mEtInputText;
            if (fillInEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            } else {
                fillInEditText2 = fillInEditText7;
            }
            fillInEditText2.setGravity(17);
        } else if (isFractionShown()) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, SizeUtils.dp2px(84.0f));
            FillInEditText fillInEditText8 = this.mEtInputText;
            if (fillInEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText8 = null;
            }
            fillInEditText8.setLayoutParams(layoutParams3);
            FillInEditText fillInEditText9 = this.mEtInputText;
            if (fillInEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            } else {
                fillInEditText2 = fillInEditText9;
            }
            fillInEditText2.setGravity(8388629);
        } else {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SizeUtils.dp2px(84.0f));
            FillInEditText fillInEditText10 = this.mEtInputText;
            if (fillInEditText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText10 = null;
            }
            fillInEditText10.setLayoutParams(layoutParams4);
            FillInEditText fillInEditText11 = this.mEtInputText;
            if (fillInEditText11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            } else {
                fillInEditText2 = fillInEditText11;
            }
            fillInEditText2.setGravity(17);
        }
    }

    /* access modifiers changed from: private */
    public final void inputKeyboardText(String str) {
        Tag tag = TAG;
        XesLog.i(tag, "inputKeyboardText focusFlag " + this.mFocusFlag + ", text: " + str);
        if (!isMaxCharacterNumber()) {
            int i = this.mFocusFlag;
            FillInEditText fillInEditText = null;
            if (i == 1) {
                FillInEditText fillInEditText2 = this.mEtInputText;
                if (fillInEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                    fillInEditText2 = null;
                }
                Editable text = fillInEditText2.getText();
                if (text != null) {
                    FillInEditText fillInEditText3 = this.mEtInputText;
                    if (fillInEditText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                    } else {
                        fillInEditText = fillInEditText3;
                    }
                    text.insert(fillInEditText.getSelectionStart(), str);
                }
            } else if (i != 2) {
                if (i == 3) {
                    if (numberCheck(str)) {
                        FillInEditText fillInEditText4 = this.mEtInputDenominator;
                        if (fillInEditText4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                            fillInEditText4 = null;
                        }
                        Editable text2 = fillInEditText4.getText();
                        if (text2 != null) {
                            FillInEditText fillInEditText5 = this.mEtInputDenominator;
                            if (fillInEditText5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                            } else {
                                fillInEditText = fillInEditText5;
                            }
                            text2.insert(fillInEditText.getSelectionStart(), str);
                            return;
                        }
                        return;
                    }
                    XesLog.i(tag, "inputKeyboardText 分式禁止输入非数字");
                }
            } else if (numberCheck(str)) {
                FillInEditText fillInEditText6 = this.mEtInputNumerator;
                if (fillInEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    fillInEditText6 = null;
                }
                Editable text3 = fillInEditText6.getText();
                if (text3 != null) {
                    FillInEditText fillInEditText7 = this.mEtInputNumerator;
                    if (fillInEditText7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    } else {
                        fillInEditText = fillInEditText7;
                    }
                    text3.insert(fillInEditText.getSelectionStart(), str);
                }
            } else {
                XesLog.i(tag, "inputKeyboardText 分式禁止输入非数字");
            }
        }
    }

    static /* synthetic */ void toggleShowKeyboard$default(NumAndMarkKeyboard numAndMarkKeyboard, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        numAndMarkKeyboard.toggleShowKeyboard(z);
    }

    private final void toggleShowKeyboard(boolean z) {
        int i;
        Function1<Boolean, Unit> toggleKeyboardBlock$bus_livebusiness_release;
        if (!this.isShowModel && this.mToggleShow != z) {
            KeyboardAnimator keyboardAnimator = this.mKeyboardAnimators;
            if (!(keyboardAnimator != null && keyboardAnimator.isOpenRunning())) {
                XesLog.i(TAG, Intrinsics.stringPlus("showKeyboard : ", Boolean.valueOf(z)));
                this.mToggleShow = z;
                OnKeyboardListener onKeyboardListener = this.mKeyboardListener;
                if (!(onKeyboardListener == null || (toggleKeyboardBlock$bus_livebusiness_release = onKeyboardListener.getToggleKeyboardBlock$bus_livebusiness_release()) == null)) {
                    toggleKeyboardBlock$bus_livebusiness_release.invoke(Boolean.valueOf(z));
                }
                ImageView imageView = this.mBtnToggleShow;
                RecyclerView recyclerView = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBtnToggleShow");
                    imageView = null;
                }
                if (z) {
                    i = R.drawable.ic_live_business_keyboard_down;
                } else {
                    i = R.drawable.ic_live_business_keyboard_up;
                }
                imageView.setImageResource(i);
                KeyboardAnimator keyboardAnimator2 = this.mKeyboardAnimators;
                if (keyboardAnimator2 != null) {
                    View view = (View) this;
                    RecyclerView recyclerView2 = this.mKeyboard;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mKeyboard");
                    } else {
                        recyclerView = recyclerView2;
                    }
                    keyboardAnimator2.makeOpenAnimator(z, view, ((float) recyclerView.getHeight()) * 1.0f, NumAndMarkKeyboard$toggleShowKeyboard$1.INSTANCE);
                }
            }
        }
    }

    private final void changeFocusFlag(int i) {
        this.mOldFocusFlag = this.mFocusFlag;
        this.mFocusFlag = i;
        changeFractionViewSize();
        controlInputHint();
    }

    private final void clearFlagFocus() {
        int i = this.mFocusFlag;
        FillInEditText fillInEditText = null;
        if (i == 1) {
            FillInEditText fillInEditText2 = this.mEtInputText;
            if (fillInEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            } else {
                fillInEditText = fillInEditText2;
            }
            fillInEditText.clearFocus();
        } else if (i == 2) {
            FillInEditText fillInEditText3 = this.mEtInputNumerator;
            if (fillInEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            } else {
                fillInEditText = fillInEditText3;
            }
            fillInEditText.clearFocus();
        } else if (i == 3) {
            FillInEditText fillInEditText4 = this.mEtInputDenominator;
            if (fillInEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            } else {
                fillInEditText = fillInEditText4;
            }
            fillInEditText.clearFocus();
        }
        changeFocusFlag(-1);
    }

    /* access modifiers changed from: private */
    public final void requestFlagFocus(int i) {
        changeFocusFlag(i);
        int i2 = this.mFocusFlag;
        FillInEditText fillInEditText = null;
        if (i2 == 1) {
            FillInEditText fillInEditText2 = this.mEtInputText;
            if (fillInEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            } else {
                fillInEditText = fillInEditText2;
            }
            fillInEditText.requestFocus();
        } else if (i2 == 2) {
            FillInEditText fillInEditText3 = this.mEtInputNumerator;
            if (fillInEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            } else {
                fillInEditText = fillInEditText3;
            }
            fillInEditText.requestFocus();
        } else if (i2 == 3) {
            FillInEditText fillInEditText4 = this.mEtInputDenominator;
            if (fillInEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            } else {
                fillInEditText = fillInEditText4;
            }
            fillInEditText.requestFocus();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void changeFractionViewSize() {
        /*
            r12 = this;
            boolean r0 = r12.isFractionShown()
            if (r0 == 0) goto L_0x0116
            boolean r0 = r12.isShowModel
            r1 = 0
            java.lang.String r2 = "mEtInputDenominator"
            java.lang.String r3 = "mEtInputNumerator"
            r4 = 0
            if (r0 == 0) goto L_0x0042
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputNumerator
            if (r0 != 0) goto L_0x0018
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x0018:
            android.view.View r0 = (android.view.View) r0
            r0.setPadding(r1, r1, r1, r1)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputDenominator
            if (r0 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r4
        L_0x0025:
            android.view.View r0 = (android.view.View) r0
            r0.setPadding(r1, r1, r1, r1)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputNumerator
            if (r0 != 0) goto L_0x0032
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x0032:
            r0.setMinWidth(r1)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputDenominator
            if (r0 != 0) goto L_0x003d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x003e
        L_0x003d:
            r4 = r0
        L_0x003e:
            r4.setMinWidth(r1)
            return
        L_0x0042:
            r0 = 1099956224(0x41900000, float:18.0)
            int r0 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r0)
            r5 = 1065353216(0x3f800000, float:1.0)
            int r5 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r5)
            r6 = 1090519040(0x41000000, float:8.0)
            int r6 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            int r7 = r12.mFocusFlag
            r8 = 2
            r9 = 1098907648(0x41800000, float:16.0)
            r10 = 1
            r11 = 1108606976(0x42140000, float:37.0)
            if (r7 == r8) goto L_0x009e
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r7 = r12.mEtInputNumerator
            if (r7 != 0) goto L_0x0066
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r7 = r4
        L_0x0066:
            android.text.Editable r7 = r7.getText()
            if (r7 != 0) goto L_0x006e
            r7 = r4
            goto L_0x0072
        L_0x006e:
            java.lang.String r7 = r7.toString()
        L_0x0072:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x007f
            int r7 = r7.length()
            if (r7 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r7 = r1
            goto L_0x0080
        L_0x007f:
            r7 = r10
        L_0x0080:
            if (r7 != 0) goto L_0x0083
            goto L_0x009e
        L_0x0083:
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r7 = r12.mEtInputNumerator
            if (r7 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r7 = r4
        L_0x008b:
            r7.setPadding(r6, r5, r6, r5)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r7 = r12.mEtInputNumerator
            if (r7 != 0) goto L_0x0096
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r7 = r4
        L_0x0096:
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r9)
            r7.setMinWidth(r3)
            goto L_0x00b8
        L_0x009e:
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r7 = r12.mEtInputNumerator
            if (r7 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r7 = r4
        L_0x00a6:
            r7.setPadding(r0, r5, r0, r5)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r7 = r12.mEtInputNumerator
            if (r7 != 0) goto L_0x00b1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r7 = r4
        L_0x00b1:
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r11)
            r7.setMinWidth(r3)
        L_0x00b8:
            int r3 = r12.mFocusFlag
            r7 = 3
            if (r3 == r7) goto L_0x00fb
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r3 = r12.mEtInputDenominator
            if (r3 != 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r4
        L_0x00c5:
            android.text.Editable r3 = r3.getText()
            if (r3 != 0) goto L_0x00cd
            r3 = r4
            goto L_0x00d1
        L_0x00cd:
            java.lang.String r3 = r3.toString()
        L_0x00d1:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00db
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00dc
        L_0x00db:
            r1 = r10
        L_0x00dc:
            if (r1 != 0) goto L_0x00df
            goto L_0x00fb
        L_0x00df:
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputDenominator
            if (r0 != 0) goto L_0x00e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r4
        L_0x00e7:
            r0.setPadding(r6, r5, r6, r5)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputDenominator
            if (r0 != 0) goto L_0x00f2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00f3
        L_0x00f2:
            r4 = r0
        L_0x00f3:
            int r0 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r9)
            r4.setMinWidth(r0)
            goto L_0x0116
        L_0x00fb:
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r1 = r12.mEtInputDenominator
            if (r1 != 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x0103:
            r1.setPadding(r0, r5, r0, r5)
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r0 = r12.mEtInputDenominator
            if (r0 != 0) goto L_0x010e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x010f
        L_0x010e:
            r4 = r0
        L_0x010f:
            int r0 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r11)
            r4.setMinWidth(r0)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.NumAndMarkKeyboard.changeFractionViewSize():void");
    }

    private final void changeFractionViewOnShowModel() {
        if (isFractionShown()) {
            FillInEditText fillInEditText = null;
            if (this.isShowModel) {
                FillInEditText fillInEditText2 = this.mEtInputNumerator;
                if (fillInEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    fillInEditText2 = null;
                }
                fillInEditText2.setBackgroundColor(0);
                FillInEditText fillInEditText3 = this.mEtInputDenominator;
                if (fillInEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                } else {
                    fillInEditText = fillInEditText3;
                }
                fillInEditText.setBackgroundColor(0);
                return;
            }
            FillInEditText fillInEditText4 = this.mEtInputNumerator;
            if (fillInEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText4 = null;
            }
            fillInEditText4.setBackgroundResource(R.drawable.selector_live_business_keyboard_edit_box);
            FillInEditText fillInEditText5 = this.mEtInputDenominator;
            if (fillInEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            } else {
                fillInEditText = fillInEditText5;
            }
            fillInEditText.setBackgroundResource(R.drawable.selector_live_business_keyboard_edit_box);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isMaxCharacterNumber() {
        int i;
        FillInEditText fillInEditText = this.mEtInputText;
        FillInEditText fillInEditText2 = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        Editable text = fillInEditText.getText();
        int length = text == null ? 0 : text.length();
        FillInEditText fillInEditText3 = this.mEtInputDenominator;
        if (fillInEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText3 = null;
        }
        Editable text2 = fillInEditText3.getText();
        int length2 = text2 == null ? 0 : text2.length();
        FillInEditText fillInEditText4 = this.mEtInputNumerator;
        if (fillInEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
        } else {
            fillInEditText2 = fillInEditText4;
        }
        Editable text3 = fillInEditText2.getText();
        int length3 = text3 == null ? 0 : text3.length();
        int i2 = this.mFocusFlag;
        if (i2 != 2) {
            if (i2 != 3 && length2 <= length3) {
                length2 = length3;
            }
            i = length + length2;
        } else {
            i = length + length3;
        }
        if (i >= 20) {
            return true;
        }
        return false;
    }

    private final boolean numberCheck(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private final void clearInputMenu(boolean z) {
        FillInEditText fillInEditText = this.mEtInputText;
        ConstraintLayout constraintLayout = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        fillInEditText.setClickable(z);
        FillInEditText fillInEditText2 = this.mEtInputNumerator;
        if (fillInEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText2 = null;
        }
        fillInEditText2.setClickable(z);
        FillInEditText fillInEditText3 = this.mEtInputDenominator;
        if (fillInEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
            fillInEditText3 = null;
        }
        fillInEditText3.setClickable(z);
        ConstraintLayout constraintLayout2 = this.mLayoutInput;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutInput");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.setClickable(z);
    }

    /* access modifiers changed from: private */
    public final void processDelEditText() {
        FillInEditText fillInEditText;
        FillInEditText fillInEditText2;
        FillInEditText fillInEditText3;
        FillInEditText fillInEditText4;
        FillInEditText fillInEditText5;
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("processDelEditText focusFlag ", Integer.valueOf(this.mFocusFlag)));
        int i = this.mFocusFlag;
        if (i == 1) {
            FillInEditText fillInEditText6 = this.mEtInputText;
            if (fillInEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText6 = null;
            }
            Editable text = fillInEditText6.getText();
            FillInEditText fillInEditText7 = this.mEtInputText;
            if (fillInEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText = null;
            } else {
                fillInEditText = fillInEditText7;
            }
            int selectionStart = fillInEditText.getSelectionStart();
            if (TextUtils.isEmpty(text)) {
                XesLog.i(tag, "processDelEditText editable is null return ");
            } else if (selectionStart == 0) {
                XesLog.i(tag, "processDelEditText index is 0 return ");
            } else if (text != null) {
                text.delete(selectionStart - 1, selectionStart);
            }
        } else if (i == 2) {
            FillInEditText fillInEditText8 = this.mEtInputNumerator;
            if (fillInEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText8 = null;
            }
            Editable text2 = fillInEditText8.getText();
            FillInEditText fillInEditText9 = this.mEtInputNumerator;
            if (fillInEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText9 = null;
            }
            int selectionStart2 = fillInEditText9.getSelectionStart();
            XesLog.i(tag, "processDelEditText isNumeratorClearAll is " + this.isNumeratorClearAll + " editable is " + text2 + " index " + selectionStart2);
            CharSequence charSequence = text2;
            if (TextUtils.isEmpty(charSequence) && selectionStart2 == 0) {
                this.isNumeratorClearAll = true;
            }
            if (this.isNumeratorClearAll) {
                FillInEditText fillInEditText10 = this.mEtInputDenominator;
                if (fillInEditText10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                    fillInEditText10 = null;
                }
                Editable text3 = fillInEditText10.getText();
                CharSequence obj = text3 == null ? null : text3.toString();
                if (obj == null || obj.length() == 0) {
                    FillInEditText fillInEditText11 = this.mEtInputText;
                    if (fillInEditText11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText11 = null;
                    }
                    FillInEditText fillInEditText12 = this.mEtInputText;
                    if (fillInEditText12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText12 = null;
                    }
                    Editable text4 = fillInEditText12.getText();
                    fillInEditText11.setSelection(text4 == null ? 0 : text4.length());
                    FillInEditText fillInEditText13 = this.mEtInputText;
                    if (fillInEditText13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText3 = null;
                    } else {
                        fillInEditText3 = fillInEditText13;
                    }
                    fillInEditText3.requestFocus();
                } else {
                    FillInEditText fillInEditText14 = this.mEtInputNumerator;
                    if (fillInEditText14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                        fillInEditText14 = null;
                    }
                    fillInEditText14.clearFocus();
                    FillInEditText fillInEditText15 = this.mEtInputDenominator;
                    if (fillInEditText15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                        fillInEditText15 = null;
                    }
                    fillInEditText15.setText("");
                    FillInEditText fillInEditText16 = this.mEtInputText;
                    if (fillInEditText16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText16 = null;
                    }
                    Editable text5 = fillInEditText16.getText();
                    int length = text5 == null ? 0 : text5.length();
                    FillInEditText fillInEditText17 = this.mEtInputText;
                    if (fillInEditText17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText17 = null;
                    }
                    fillInEditText17.requestFocus();
                    FillInEditText fillInEditText18 = this.mEtInputText;
                    if (fillInEditText18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText2 = null;
                    } else {
                        fillInEditText2 = fillInEditText18;
                    }
                    fillInEditText2.setSelection(length);
                }
                showFraction(false);
                autoAdaptInputContent();
                this.isNumeratorClearAll = false;
                XesLog.i(tag, "processDelEditText isNumeratorClearAll is true ");
            } else if (TextUtils.isEmpty(charSequence)) {
                XesLog.i(tag, "processDelEditText editable is null return ");
                this.isNumeratorClearAll = true;
            } else if (selectionStart2 == 0) {
                XesLog.i(tag, "processDelEditText index is 0 return ");
            } else if (text2 != null) {
                text2.delete(selectionStart2 - 1, selectionStart2);
            }
        } else if (i == 3) {
            FillInEditText fillInEditText19 = this.mEtInputDenominator;
            if (fillInEditText19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText19 = null;
            }
            Editable text6 = fillInEditText19.getText();
            FillInEditText fillInEditText20 = this.mEtInputDenominator;
            if (fillInEditText20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText20 = null;
            }
            int selectionStart3 = fillInEditText20.getSelectionStart();
            XesLog.i(tag, "processDelEditText isDenominatorClearAll is " + this.isDenominatorClearAll + " editable is " + text6 + " index " + selectionStart3);
            CharSequence charSequence2 = text6;
            if (TextUtils.isEmpty(charSequence2) && selectionStart3 == 0) {
                this.isDenominatorClearAll = true;
            }
            if (this.isDenominatorClearAll) {
                FillInEditText fillInEditText21 = this.mEtInputNumerator;
                if (fillInEditText21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    fillInEditText21 = null;
                }
                Editable text7 = fillInEditText21.getText();
                CharSequence obj2 = text7 == null ? null : text7.toString();
                if (obj2 == null || obj2.length() == 0) {
                    FillInEditText fillInEditText22 = this.mEtInputText;
                    if (fillInEditText22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText22 = null;
                    }
                    FillInEditText fillInEditText23 = this.mEtInputText;
                    if (fillInEditText23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText23 = null;
                    }
                    Editable text8 = fillInEditText23.getText();
                    fillInEditText22.setSelection(text8 == null ? 0 : text8.length());
                    FillInEditText fillInEditText24 = this.mEtInputText;
                    if (fillInEditText24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText5 = null;
                    } else {
                        fillInEditText5 = fillInEditText24;
                    }
                    fillInEditText5.requestFocus();
                } else {
                    FillInEditText fillInEditText25 = this.mEtInputDenominator;
                    if (fillInEditText25 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                        fillInEditText25 = null;
                    }
                    fillInEditText25.clearFocus();
                    FillInEditText fillInEditText26 = this.mEtInputNumerator;
                    if (fillInEditText26 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                        fillInEditText26 = null;
                    }
                    fillInEditText26.setText("");
                    FillInEditText fillInEditText27 = this.mEtInputText;
                    if (fillInEditText27 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText27 = null;
                    }
                    FillInEditText fillInEditText28 = this.mEtInputText;
                    if (fillInEditText28 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText28 = null;
                    }
                    Editable text9 = fillInEditText28.getText();
                    fillInEditText27.setSelection(text9 == null ? 0 : text9.length());
                    FillInEditText fillInEditText29 = this.mEtInputText;
                    if (fillInEditText29 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                        fillInEditText4 = null;
                    } else {
                        fillInEditText4 = fillInEditText29;
                    }
                    fillInEditText4.requestFocus();
                }
                showFraction(false);
                autoAdaptInputContent();
                this.isDenominatorClearAll = false;
                XesLog.i(tag, "processDelEditText isDenominatorClearAll is true ");
            } else if (TextUtils.isEmpty(charSequence2)) {
                XesLog.i(tag, "processDelEditText editable is null return ");
                this.isDenominatorClearAll = true;
            } else if (selectionStart3 == 0) {
                XesLog.i(tag, "processDelEditText index is 0 return ");
            } else if (text6 != null) {
                text6.delete(selectionStart3 - 1, selectionStart3);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void processCleEditText() {
        XesLog.i(TAG, Intrinsics.stringPlus("processCleEditText focusFlag ", Integer.valueOf(this.mFocusFlag)));
        FillInEditText fillInEditText = this.mEtInputText;
        FillInEditText fillInEditText2 = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        fillInEditText.setText("");
        if (isFractionShown()) {
            showFraction(false);
            FillInEditText fillInEditText3 = this.mEtInputNumerator;
            if (fillInEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText3 = null;
            }
            fillInEditText3.setText("");
            FillInEditText fillInEditText4 = this.mEtInputDenominator;
            if (fillInEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText4 = null;
            }
            fillInEditText4.setText("");
            FillInEditText fillInEditText5 = this.mEtInputNumerator;
            if (fillInEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText5 = null;
            }
            fillInEditText5.clearFocus();
            FillInEditText fillInEditText6 = this.mEtInputDenominator;
            if (fillInEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText6 = null;
            }
            fillInEditText6.clearFocus();
        }
        FillInEditText fillInEditText7 = this.mEtInputText;
        if (fillInEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
        } else {
            fillInEditText2 = fillInEditText7;
        }
        fillInEditText2.requestFocus();
        this.mFocusFlag = 1;
        autoAdaptInputContent();
    }

    private final void disableShowInput() {
        FillInEditText fillInEditText = this.mEtInputText;
        FillInEditText fillInEditText2 = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        fillInEditText.setShowSoftInputOnFocus(false);
        FillInEditText fillInEditText3 = this.mEtInputNumerator;
        if (fillInEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText3 = null;
        }
        fillInEditText3.setShowSoftInputOnFocus(false);
        FillInEditText fillInEditText4 = this.mEtInputDenominator;
        if (fillInEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
        } else {
            fillInEditText2 = fillInEditText4;
        }
        fillInEditText2.setShowSoftInputOnFocus(false);
    }

    private final void changeShowModelUI() {
        TextView textView = null;
        if (this.isShowModel) {
            ConstraintLayout constraintLayout = this.mLayoutInput;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutInput");
                constraintLayout = null;
            }
            View view = (View) constraintLayout;
            ConstraintLayout.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
            layoutParams3.width = SizeUtils.dp2px(474.0f);
            layoutParams3.setMarginStart(SizeUtils.dp2px(110.0f));
            view.setLayoutParams(layoutParams2);
            View view2 = this.mGroupAnswer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGroupAnswer");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.mBgTopBook;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgTopBook");
                view3 = null;
            }
            view3.setVisibility(8);
            RecyclerView recyclerView = this.mKeyboard;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mKeyboard");
                recyclerView = null;
            }
            recyclerView.setVisibility(8);
            ImageView imageView = this.mBtnToggleShow;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnToggleShow");
                imageView = null;
            }
            imageView.setVisibility(8);
            TextView textView2 = this.mBtnSubmit;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.mLayoutInput;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutInput");
            constraintLayout2 = null;
        }
        View view4 = (View) constraintLayout2;
        ConstraintLayout.LayoutParams layoutParams4 = view4.getLayoutParams();
        Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams5 = (ViewGroup.LayoutParams) layoutParams4;
        ConstraintLayout.LayoutParams layoutParams6 = layoutParams5;
        layoutParams6.width = SizeUtils.dp2px(459.0f);
        layoutParams6.setMarginStart(0);
        view4.setLayoutParams(layoutParams5);
        View view5 = this.mGroupAnswer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGroupAnswer");
            view5 = null;
        }
        view5.setVisibility(8);
        View view6 = this.mBgTopBook;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBgTopBook");
            view6 = null;
        }
        view6.setVisibility(0);
        RecyclerView recyclerView2 = this.mKeyboard;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mKeyboard");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        ImageView imageView2 = this.mBtnToggleShow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnToggleShow");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        TextView textView3 = this.mBtnSubmit;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSubmit");
        } else {
            textView = textView3;
        }
        textView.setVisibility(0);
    }

    public final String getAllEditTextContent() {
        StringBuilder sb = new StringBuilder();
        FillInEditText fillInEditText = this.mEtInputText;
        FillInEditText fillInEditText2 = null;
        if (fillInEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
            fillInEditText = null;
        }
        Editable text = fillInEditText.getText();
        CharSequence charSequence = text;
        if (!(charSequence == null || charSequence.length() == 0)) {
            sb.append(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text.toString(), "%", "\\%", false, 4, (Object) null), "×", TAG_TIMES, false, 4, (Object) null), "÷", TAG_DIV, false, 4, (Object) null));
        }
        FillInEditText fillInEditText3 = this.mEtInputNumerator;
        if (fillInEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
            fillInEditText3 = null;
        }
        if (!TextUtils.isEmpty(fillInEditText3.getText())) {
            sb.append(TAG_FRACTION);
            sb.append("{");
            FillInEditText fillInEditText4 = this.mEtInputNumerator;
            if (fillInEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                fillInEditText4 = null;
            }
            sb.append(fillInEditText4.getText());
            sb.append("}");
            FillInEditText fillInEditText5 = this.mEtInputDenominator;
            if (fillInEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText5 = null;
            }
            if (!TextUtils.isEmpty(fillInEditText5.getText())) {
                sb.append("{");
                FillInEditText fillInEditText6 = this.mEtInputDenominator;
                if (fillInEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                } else {
                    fillInEditText2 = fillInEditText6;
                }
                sb.append(fillInEditText2.getText());
                sb.append("}");
            } else {
                sb.append("{}");
            }
        } else {
            FillInEditText fillInEditText7 = this.mEtInputDenominator;
            if (fillInEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                fillInEditText7 = null;
            }
            if (!TextUtils.isEmpty(fillInEditText7.getText())) {
                sb.append(TAG_FRACTION);
                sb.append("{}");
                sb.append("{");
                FillInEditText fillInEditText8 = this.mEtInputDenominator;
                if (fillInEditText8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                } else {
                    fillInEditText2 = fillInEditText8;
                }
                sb.append(fillInEditText2.getText());
                sb.append("}");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final void recoveryData(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "data");
        CharSequence charSequence = str2;
        if (!(charSequence.length() == 0)) {
            List split$default = StringsKt.split$default(charSequence, new String[]{TAG_FRACTION}, false, 0, 6, (Object) null);
            FillInEditText fillInEditText = this.mEtInputText;
            FillInEditText fillInEditText2 = null;
            if (fillInEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInputText");
                fillInEditText = null;
            }
            fillInEditText.setText(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) split$default.get(0), TAG_TIMES, "×", false, 4, (Object) null), TAG_DIV, "÷", false, 4, (Object) null), "\\", "", false, 4, (Object) null));
            if (split$default.size() > 1) {
                String str3 = (String) split$default.get(1);
                CharSequence charSequence2 = str3;
                String substring = str3.substring(StringsKt.indexOf$default(charSequence2, "{", 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default(charSequence2, "}", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str3.substring(StringsKt.lastIndexOf$default(charSequence2, "{", 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default(charSequence2, "}", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                showFraction(true);
                FillInEditText fillInEditText3 = this.mEtInputNumerator;
                if (fillInEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    fillInEditText3 = null;
                }
                fillInEditText3.setText(substring);
                FillInEditText fillInEditText4 = this.mEtInputDenominator;
                if (fillInEditText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                } else {
                    fillInEditText2 = fillInEditText4;
                }
                fillInEditText2.setText(substring2);
                changeFractionViewSize();
            } else {
                showFraction(false);
                FillInEditText fillInEditText5 = this.mEtInputNumerator;
                if (fillInEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputNumerator");
                    fillInEditText5 = null;
                }
                fillInEditText5.setText("");
                FillInEditText fillInEditText6 = this.mEtInputDenominator;
                if (fillInEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInputDenominator");
                } else {
                    fillInEditText2 = fillInEditText6;
                }
                fillInEditText2.setText("");
            }
            autoAdaptInputContent();
        }
    }

    public final void setOnKeyboardListener(Function1<? super OnKeyboardListener, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (this.mKeyboardListener == null) {
            NumAndMarkKeyboard numAndMarkKeyboard = this;
            this.mKeyboardListener = new OnKeyboardListener();
        }
        OnKeyboardListener onKeyboardListener = this.mKeyboardListener;
        if (onKeyboardListener != null) {
            function1.invoke(onKeyboardListener);
        }
    }

    public final void show() {
        setVisibility(0);
        KeyboardAnimator keyboardAnimator = this.mKeyboardAnimators;
        if (keyboardAnimator != null) {
            keyboardAnimator.makeShowAnimator(true, (View) this, this.isShowModel ? 200 : 400, new NumAndMarkKeyboard$show$1(this));
        }
    }

    public final void hide() {
        KeyboardAnimator keyboardAnimator;
        if (getVisibility() == 0 && (keyboardAnimator = this.mKeyboardAnimators) != null) {
            keyboardAnimator.makeShowAnimator(false, (View) this, this.isShowModel ? 200 : 400, new NumAndMarkKeyboard$hide$1(this));
        }
    }

    public final void destroy() {
        KeyboardAnimator keyboardAnimator = this.mKeyboardAnimators;
        if (keyboardAnimator != null) {
            keyboardAnimator.destroy();
        }
        this.mKeyboardAnimators = null;
    }

    public final void showModel(boolean z) {
        this.isShowModel = z;
        clearInputMenu(!z);
        if (z) {
            clearFlagFocus();
        } else {
            requestFlagFocus(this.mOldFocusFlag);
        }
        changeFractionViewOnShowModel();
        changeShowModelUI();
        autoAdaptInputContent();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001f\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010!\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J)\u0010\"\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u000eJ\u001a\u0010#\u001a\u00020\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eJ)\u0010$\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00050\u000eR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R7\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/NumAndMarkKeyboard$OnKeyboardListener;", "", "()V", "clearClickBlock", "Lkotlin/Function0;", "", "getClearClickBlock$bus_livebusiness_release", "()Lkotlin/jvm/functions/Function0;", "setClearClickBlock$bus_livebusiness_release", "(Lkotlin/jvm/functions/Function0;)V", "delClickBlock", "getDelClickBlock$bus_livebusiness_release", "setDelClickBlock$bus_livebusiness_release", "numberClickBlock", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", "getNumberClickBlock$bus_livebusiness_release", "()Lkotlin/jvm/functions/Function1;", "setNumberClickBlock$bus_livebusiness_release", "(Lkotlin/jvm/functions/Function1;)V", "submitClickBlock", "getSubmitClickBlock$bus_livebusiness_release", "setSubmitClickBlock$bus_livebusiness_release", "toggleKeyboardBlock", "", "show", "getToggleKeyboardBlock$bus_livebusiness_release", "setToggleKeyboardBlock$bus_livebusiness_release", "onClearClick", "block", "onDelClick", "onNumberClick", "onSubmitClick", "onToggleKeyboard", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NumAndMarkKeyboard.kt */
    public static final class OnKeyboardListener {
        private Function0<Unit> clearClickBlock;
        private Function0<Unit> delClickBlock;
        private Function1<? super String, Unit> numberClickBlock;
        private Function1<? super String, Unit> submitClickBlock;
        private Function1<? super Boolean, Unit> toggleKeyboardBlock;

        public final Function1<String, Unit> getNumberClickBlock$bus_livebusiness_release() {
            return this.numberClickBlock;
        }

        public final void setNumberClickBlock$bus_livebusiness_release(Function1<? super String, Unit> function1) {
            this.numberClickBlock = function1;
        }

        public final Function0<Unit> getDelClickBlock$bus_livebusiness_release() {
            return this.delClickBlock;
        }

        public final void setDelClickBlock$bus_livebusiness_release(Function0<Unit> function0) {
            this.delClickBlock = function0;
        }

        public final Function0<Unit> getClearClickBlock$bus_livebusiness_release() {
            return this.clearClickBlock;
        }

        public final void setClearClickBlock$bus_livebusiness_release(Function0<Unit> function0) {
            this.clearClickBlock = function0;
        }

        public final Function1<String, Unit> getSubmitClickBlock$bus_livebusiness_release() {
            return this.submitClickBlock;
        }

        public final void setSubmitClickBlock$bus_livebusiness_release(Function1<? super String, Unit> function1) {
            this.submitClickBlock = function1;
        }

        public final Function1<Boolean, Unit> getToggleKeyboardBlock$bus_livebusiness_release() {
            return this.toggleKeyboardBlock;
        }

        public final void setToggleKeyboardBlock$bus_livebusiness_release(Function1<? super Boolean, Unit> function1) {
            this.toggleKeyboardBlock = function1;
        }

        public final void onNumberClick(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.numberClickBlock = function1;
        }

        public final void onDelClick(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            this.delClickBlock = function0;
        }

        public final void onClearClick(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            this.clearClickBlock = function0;
        }

        public final void onSubmitClick(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.submitClickBlock = function1;
        }

        public final void onToggleKeyboard(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.toggleKeyboardBlock = function1;
        }
    }
}
