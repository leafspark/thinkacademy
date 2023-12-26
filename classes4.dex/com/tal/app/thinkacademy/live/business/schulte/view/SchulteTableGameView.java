package com.tal.app.thinkacademy.live.business.schulte.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.adapter.SchulteTableAdapter;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u0001:\u0001KBR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0002\u0010\u0012J\u001a\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010<\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010%H\u0002J\b\u0010=\u001a\u00020\u0011H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0018\u0010@\u001a\u00020\u00112\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0011H\u0002J\u001c\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010\"2\b\u0010F\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010G\u001a\u00020\u00112\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010BH\u0016J\b\u0010H\u001a\u00020\u0011H\u0002J\b\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020\u0011H\u0002R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u000707X\u0004¢\u0006\u0004\n\u0002\u00108¨\u0006L"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGameView;", "Lcom/tal/app/thinkacademy/live/business/schulte/api/ISceneChange;", "mContext", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "mLevel", "", "category", "", "isRandom", "", "complete", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "score", "", "(Landroid/content/Context;Landroid/view/ViewGroup;ILjava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "mAdapter", "Lcom/tal/app/thinkacademy/live/business/schulte/adapter/SchulteTableAdapter;", "mBgSoundId", "Ljava/lang/Integer;", "mClickDuration", "mCurrent", "mDataList", "", "mHandler", "Landroid/os/Handler;", "mLayoutGuide", "Landroid/widget/FrameLayout;", "mLottieClick", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieCompositionRight", "Lcom/airbnb/lottie/LottieComposition;", "mLottieCompositionWrong", "mRightBoard", "Landroid/view/View;", "mRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMRootView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mSourceList", "mStartTime", "", "mStartTimeClick", "mTableView", "Lcom/google/android/flexbox/FlexboxLayout;", "mTvChronometer", "Landroid/widget/TextView;", "mTvCurrent", "mTvGameIntro", "Lcom/flyco/roundview/RoundTextView;", "mTvMode", "primzahlen", "", "[Ljava/lang/Integer;", "checkRight", "num", "view", "checkWrong", "destroy", "findNext", "curNum", "hide", "end", "Lkotlin/Function0;", "initLottie", "playAnimationAnswer", "lottieComposition", "boxView", "show", "showGuide", "startChronometer", "stopChronometer", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableGameView.kt */
public final class SchulteTableGameView implements ISceneChange {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "游戏中";
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.SCHULTE_TABLE;
    private final Function1<String, Unit> complete;
    private final boolean isRandom;
    /* access modifiers changed from: private */
    public SchulteTableAdapter mAdapter;
    private Integer mBgSoundId;
    /* access modifiers changed from: private */
    public int mClickDuration;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public String mCurrent;
    /* access modifiers changed from: private */
    public final List<String> mDataList;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public final FrameLayout mLayoutGuide;
    private final int mLevel;
    /* access modifiers changed from: private */
    public final LottieAnimationView mLottieClick;
    private LottieComposition mLottieCompositionRight;
    private LottieComposition mLottieCompositionWrong;
    private final View mRightBoard;
    private final ConstraintLayout mRootView;
    private final List<String> mSourceList;
    /* access modifiers changed from: private */
    public long mStartTime;
    /* access modifiers changed from: private */
    public long mStartTimeClick;
    private final FlexboxLayout mTableView;
    /* access modifiers changed from: private */
    public final TextView mTvChronometer;
    private final TextView mTvCurrent;
    /* access modifiers changed from: private */
    public final RoundTextView mTvGameIntro;
    private final TextView mTvMode;
    private final Integer[] primzahlen;

    public SchulteTableGameView(Context context, ViewGroup viewGroup, int i, String str, boolean z, Function1<? super String, Unit> function1) {
        String str2;
        Context context2 = context;
        ViewGroup viewGroup2 = viewGroup;
        int i2 = i;
        Function1<? super String, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(context2, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup2, "rootView");
        Intrinsics.checkNotNullParameter(function12, "complete");
        this.mContext = context2;
        this.mLevel = i2;
        this.isRandom = z;
        this.complete = function12;
        Integer[] numArr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        this.primzahlen = numArr;
        LayoutInflater from = LayoutInflater.from(context);
        int i3 = R.layout.layout_schulte_table_game;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i3, viewGroup2, false) : XMLParseInstrumentation.inflate(from, i3, viewGroup2, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mRootView = constraintLayout;
        this.mSourceList = new ArrayList();
        this.mDataList = new ArrayList();
        this.mCurrent = "1";
        XesLog.i(TAG, SUB_TAG, "初始化");
        View findViewById = constraintLayout.findViewById(R.id.layout_game_right_board);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R….layout_game_right_board)");
        this.mRightBoard = findViewById;
        RoundTextView findViewById2 = constraintLayout.findViewById(R.id.tv_game_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.tv_game_title)");
        this.mTvGameIntro = findViewById2;
        View findViewById3 = constraintLayout.findViewById(R.id.tv_schulte_mode);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.tv_schulte_mode)");
        this.mTvMode = (TextView) findViewById3;
        FlexboxLayout findViewById4 = constraintLayout.findViewById(R.id.flex_box);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.flex_box)");
        this.mTableView = findViewById4;
        View findViewById5 = constraintLayout.findViewById(R.id.tv_game_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.tv_game_progress)");
        this.mTvCurrent = (TextView) findViewById5;
        View findViewById6 = constraintLayout.findViewById(R.id.layout_guide);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.layout_guide)");
        this.mLayoutGuide = (FrameLayout) findViewById6;
        LottieAnimationView findViewById7 = constraintLayout.findViewById(R.id.lottie_answer);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.lottie_answer)");
        this.mLottieClick = findViewById7;
        View findViewById8 = constraintLayout.findViewById(R.id.tv_chronometer);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.tv_chronometer)");
        this.mTvChronometer = (TextView) findViewById8;
        initLottie();
        if (Intrinsics.areEqual(str, "2")) {
            int i4 = i2 * i2;
            int length = numArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = i6 + 1;
                int intValue = numArr[i5].intValue();
                if (i6 < i4) {
                    this.mSourceList.add(String.valueOf(intValue));
                    this.mDataList.add(String.valueOf(intValue));
                }
                i5++;
                i6 = i7;
            }
            str2 = this.mContext.getString(R.string.schulte_table_number_prime);
        } else {
            int i8 = i2 * i2;
            int i9 = 0;
            while (i9 < i8) {
                i9++;
                String valueOf = String.valueOf(i9);
                this.mSourceList.add(valueOf);
                this.mDataList.add(valueOf);
            }
            str2 = this.mContext.getString(R.string.schulte_table_number_natural);
        }
        Intrinsics.checkNotNullExpressionValue(str2, "if (category == \"2\") {\n …umber_natural)\n\n        }");
        if (this.isRandom) {
            this.mTvMode.setText(this.mContext.getString(R.string.schulte_table_mode_random));
            this.mTvMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_schulte_table_mode_shuffle, 0, 0, 0);
        } else {
            this.mTvMode.setText(this.mContext.getString(R.string.schulte_table_mode_normall));
            this.mTvMode.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_schulte_table_mode_normal, 0, 0, 0);
        }
        if (this.mSourceList.size() > 0) {
            this.mCurrent = this.mSourceList.get(0);
            this.mTvGameIntro.setText(this.mContext.getString(R.string.schulte_table_play_way, new Object[]{CollectionsKt.first(this.mSourceList), CollectionsKt.last(this.mSourceList), str2}));
        }
        this.mTvCurrent.setText(this.mCurrent);
        Collections.shuffle(this.mDataList);
        SchulteTableAdapter schulteTableAdapter = new SchulteTableAdapter(this.mContext, this.mDataList);
        this.mAdapter = schulteTableAdapter;
        schulteTableAdapter.setOnItemChildClickListener(new Function2<String, BoxView, Unit>(this) {
            final /* synthetic */ SchulteTableGameView this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (BoxView) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, BoxView boxView) {
                Intrinsics.checkNotNullParameter(str, "num");
                Intrinsics.checkNotNullParameter(boxView, "view");
                XesLog.i(SchulteTableGameView.TAG, "left = " + boxView.getLeft() + "，top = " + boxView.getTop() + "，right = " + boxView.getRight() + "，bottom = " + boxView.getBottom() + "，size = " + boxView.getWidth());
                if (SystemClock.elapsedRealtime() - this.this$0.mStartTimeClick >= ((long) this.this$0.mClickDuration)) {
                    this.this$0.mStartTimeClick = SystemClock.elapsedRealtime();
                    if (Intrinsics.areEqual(this.this$0.mCurrent, str)) {
                        this.this$0.checkRight(str, boxView);
                    } else {
                        this.this$0.checkWrong(str, boxView);
                    }
                }
            }
        });
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("初始化完成，当前进度是：", this.mCurrent));
    }

    public final ConstraintLayout getMRootView() {
        return this.mRootView;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGameView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableGameView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void initLottie() {
        LottieCompositionFactory.fromAsset(this.mContext, "schulte/zhengquezha.json").addListener(new SchulteTableGameView$$ExternalSyntheticLambda0(this));
        LottieCompositionFactory.fromAsset(this.mContext, "schulte/zhadan.json").addListener(new SchulteTableGameView$$ExternalSyntheticLambda1(this));
        this.mLottieClick.addAnimatorListener(new SchulteTableGameView$initLottie$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initLottie$lambda-2  reason: not valid java name */
    public static final void m427initLottie$lambda2(SchulteTableGameView schulteTableGameView, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(schulteTableGameView, "this$0");
        schulteTableGameView.mLottieCompositionRight = lottieComposition;
    }

    /* access modifiers changed from: private */
    /* renamed from: initLottie$lambda-3  reason: not valid java name */
    public static final void m428initLottie$lambda3(SchulteTableGameView schulteTableGameView, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(schulteTableGameView, "this$0");
        schulteTableGameView.mLottieCompositionWrong = lottieComposition;
    }

    public void show(Function0<Unit> function0) {
        XesLog.i(TAG, SUB_TAG, "显示");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRightBoard, View.TRANSLATION_Y, new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400);
        animatorSet.play(ofFloat).with(ofFloat2);
        startChronometer();
        animatorSet.addListener(new SchulteTableGameView$show$$inlined$addListener$default$1(this));
        animatorSet.start();
        SchulteTableAdapter schulteTableAdapter = this.mAdapter;
        if (schulteTableAdapter != null) {
            schulteTableAdapter.attach(this.mTableView, this.mLevel);
        }
    }

    /* access modifiers changed from: private */
    public final void checkRight(String str, View view) {
        Unit unit;
        this.mClickDuration = 0;
        playAnimationAnswer(this.mLottieCompositionRight, view);
        SoundPoolUtils.play(this.mContext, R.raw.live_business_schulte_box_click, 0);
        String findNext = findNext(str);
        if (findNext == null) {
            unit = null;
        } else {
            XesLog.i(TAG, SUB_TAG, "点击了箱子，正确：点击了 " + str + " , 应该是" + this.mCurrent);
            this.mCurrent = findNext;
            this.mTvCurrent.setText(findNext);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.2f, 1.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.2f, 1.0f});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTvCurrent, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(mTvCurrent, scaleX, scaleY)");
            ofPropertyValuesHolder.setDuration(240).start();
            if (this.isRandom) {
                Collections.shuffle(this.mDataList);
                SchulteTableAdapter schulteTableAdapter = this.mAdapter;
                if (schulteTableAdapter != null) {
                    schulteTableAdapter.notifyDataChange();
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SchulteTableGameView schulteTableGameView = this;
            this.mClickDuration = Integer.MAX_VALUE;
            XesLog.i(TAG, SUB_TAG, "点击了箱子，正确，通关：点击了 " + str + " , 应该是" + this.mCurrent);
            stopChronometer();
            this.complete.invoke(StringsKt.replace$default(this.mTvChronometer.getText().toString(), "s", "", false, 4, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public final void checkWrong(String str, View view) {
        this.mClickDuration = 600;
        XesLog.i(TAG, SUB_TAG, "点击了箱子，错误：点击了 " + str + " , 应该是" + this.mCurrent);
        SoundPoolUtils.play(this.mContext, R.raw.live_business_schulte_bomb, 0);
        playAnimationAnswer(this.mLottieCompositionWrong, view);
        SchulteTableAdapter schulteTableAdapter = this.mAdapter;
        if (schulteTableAdapter != null) {
            schulteTableAdapter.playShake();
        }
    }

    private final void playAnimationAnswer(LottieComposition lottieComposition, View view) {
        if (view != null) {
            int width = (view.getWidth() - this.mLottieClick.getWidth()) / 2;
            int left = view.getLeft() + width;
            int top = width + view.getTop();
            ViewGroup.LayoutParams layoutParams = this.mLottieClick.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = left;
            marginLayoutParams.topMargin = top;
            this.mLottieClick.setLayoutParams(marginLayoutParams);
        }
        this.mLottieClick.setVisibility(0);
        if (lottieComposition != null) {
            this.mLottieClick.setComposition(lottieComposition);
            this.mLottieClick.playAnimation();
        }
    }

    /* access modifiers changed from: private */
    public final void showGuide() {
        if (!ShareDataManager.getInstance().getBoolean(ShareDataKey.SCHULTE_TABLE_SHOW_GUIDE, false, ShareDataManager.SHAREDATA_NOT_CLEAR)) {
            XesLog.i(TAG, SUB_TAG, "显示引导");
            ShareDataManager.getInstance().put(ShareDataKey.SCHULTE_TABLE_SHOW_GUIDE, true, ShareDataManager.SHAREDATA_NOT_CLEAR);
            SchulteTableGuideView schulteTableGuideView = new SchulteTableGuideView(this.mContext, this.mLevel, this.mDataList.indexOf(this.mCurrent), this.mCurrent);
            this.mLayoutGuide.addView(schulteTableGuideView, new ConstraintLayout.LayoutParams(-1, -1));
            schulteTableGuideView.setClickCallback(new SchulteTableGameView$showGuide$1(this));
            this.mLayoutGuide.animate().alpha(1.0f).setDuration(400).start();
            this.mTvGameIntro.getDelegate().setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.COLOR_FFFFFF));
        }
    }

    private final String findNext(String str) {
        int indexOf = this.mSourceList.indexOf(str) + 1;
        if (indexOf < this.mSourceList.size()) {
            return this.mSourceList.get(indexOf);
        }
        return null;
    }

    private final void startChronometer() {
        XesLog.i(TAG, SUB_TAG, "开始计时");
        stopChronometer();
        this.mStartTime = SystemClock.elapsedRealtime();
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        SchulteTableGameView$startChronometer$runnable$1 schulteTableGameView$startChronometer$runnable$1 = new SchulteTableGameView$startChronometer$runnable$1(this);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(schulteTableGameView$startChronometer$runnable$1, 400);
        }
    }

    private final void stopChronometer() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }

    public void hide(Function0<Unit> function0) {
        XesLog.i(TAG, SUB_TAG, "隐藏");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRightBoard, View.TRANSLATION_Y, new float[]{0.0f, -((float) this.mRightBoard.getHeight())});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400);
        if (function0 != null) {
            animatorSet.addListener(new SchulteTableGameView$hide$1$1(function0));
        }
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public void destroy() {
        XesLog.i(TAG, SUB_TAG, "销毁");
        stopChronometer();
        Integer num = this.mBgSoundId;
        if (num != null) {
            SoundPoolUtils.stopSameTime(num.intValue());
        }
    }
}
