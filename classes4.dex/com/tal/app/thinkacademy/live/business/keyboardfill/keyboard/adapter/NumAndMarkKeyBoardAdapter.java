package com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\tH\u0016J\u001c\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0017J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/adapter/NumAndMarkKeyBoardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/adapter/NumAndMarkKeyBoardAdapter$ViewHolder;", "context", "Landroid/content/Context;", "keys", "", "", "imaKeys", "", "(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "[Ljava/lang/String;", "mOnItemClickBlock", "Lkotlin/Function1;", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "block", "ViewHolder", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NumAndMarkKeyBoardAdapter.kt */
public final class NumAndMarkKeyBoardAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final Integer[] imaKeys;
    private final String[] keys;
    private Function1<? super String, Unit> mOnItemClickBlock;

    public NumAndMarkKeyBoardAdapter(Context context2, String[] strArr, Integer[] numArr) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(strArr, "keys");
        Intrinsics.checkNotNullParameter(numArr, "imaKeys");
        this.context = context2;
        this.keys = strArr;
        this.imaKeys = numArr;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = XMLParseInstrumentation.inflate(this.context, R.layout.live_business_keyboard_item_mark, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        String str = this.keys[i];
        viewHolder.getIconImg().setOnClickListener(new NumAndMarkKeyBoardAdapter$$ExternalSyntheticLambda0(this, str));
        viewHolder.getIconImg().setOnTouchListener(new NumAndMarkKeyBoardAdapter$$ExternalSyntheticLambda1(this));
        viewHolder.getIconImg().setImageResource(this.imaKeys[i].intValue());
        if (Intrinsics.areEqual(str, "ac")) {
            viewHolder.getIconText().setText(R.string.clear);
        } else {
            viewHolder.getIconText().setText("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m320onBindViewHolder$lambda0(NumAndMarkKeyBoardAdapter numAndMarkKeyBoardAdapter, String str, View view) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyBoardAdapter, "this$0");
        Intrinsics.checkNotNullParameter(str, "$text");
        Function1<? super String, Unit> function1 = numAndMarkKeyBoardAdapter.mOnItemClickBlock;
        if (function1 != null) {
            function1.invoke(str);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final boolean m321onBindViewHolder$lambda1(NumAndMarkKeyBoardAdapter numAndMarkKeyBoardAdapter, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(numAndMarkKeyBoardAdapter, "this$0");
        if (motionEvent.getAction() == 0) {
            SoundPoolUtils.play(numAndMarkKeyBoardAdapter.context, R.raw.live_business_keyboard_press_key, 0);
        }
        return false;
    }

    public int getItemCount() {
        return this.keys.length;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/adapter/NumAndMarkKeyBoardAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tal/app/thinkacademy/live/business/keyboardfill/keyboard/adapter/NumAndMarkKeyBoardAdapter;Landroid/view/View;)V", "iconImg", "Landroid/widget/ImageView;", "getIconImg", "()Landroid/widget/ImageView;", "setIconImg", "(Landroid/widget/ImageView;)V", "iconText", "Landroid/widget/TextView;", "getIconText", "()Landroid/widget/TextView;", "setIconText", "(Landroid/widget/TextView;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NumAndMarkKeyBoardAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iconImg;
        private TextView iconText;
        final /* synthetic */ NumAndMarkKeyBoardAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(NumAndMarkKeyBoardAdapter numAndMarkKeyBoardAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(numAndMarkKeyBoardAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = numAndMarkKeyBoardAdapter;
            View findViewById = view.findViewById(R.id.tv_item_keyboard_mark);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_item_keyboard_mark)");
            this.iconText = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.iv_item_keyboard_mark);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_item_keyboard_mark)");
            this.iconImg = (ImageView) findViewById2;
        }

        public final TextView getIconText() {
            return this.iconText;
        }

        public final void setIconText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.iconText = textView;
        }

        public final ImageView getIconImg() {
            return this.iconImg;
        }

        public final void setIconImg(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.iconImg = imageView;
        }
    }

    public final void setOnItemClickListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mOnItemClickBlock = function1;
    }
}
