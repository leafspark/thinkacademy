package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateP.kt */
final class GradeAggregateP$footViewShow$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GradeAggregateActivity $activity;
    final /* synthetic */ TextView $dayPrompt;
    final /* synthetic */ TextView $emailPrompt;
    final /* synthetic */ TextView $groupPrompt;
    final /* synthetic */ Ref.ObjectRef<ImageView> $ivSeleted;
    final /* synthetic */ TextView $namePrompt;
    final /* synthetic */ TextView $timePrompt;
    final /* synthetic */ GradeAggregateP this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateP$footViewShow$1$4(GradeAggregateP gradeAggregateP, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, GradeAggregateActivity gradeAggregateActivity, Ref.ObjectRef<ImageView> objectRef) {
        super(0);
        this.this$0 = gradeAggregateP;
        this.$groupPrompt = textView;
        this.$dayPrompt = textView2;
        this.$timePrompt = textView3;
        this.$emailPrompt = textView4;
        this.$namePrompt = textView5;
        this.$activity = gradeAggregateActivity;
        this.$ivSeleted = objectRef;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r10 = this;
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r0 = r10.this$0
            r0.clearFocus()
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r0 = r10.this$0
            android.widget.TextView r0 = r0.mTvGroup
            r1 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r3 = r1
            goto L_0x001c
        L_0x0010:
            java.lang.CharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            java.lang.String r0 = r0.toString()
            r3 = r0
        L_0x001c:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = 1
            r4 = 0
            if (r0 == 0) goto L_0x002c
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r0 = r4
            goto L_0x002d
        L_0x002c:
            r0 = r2
        L_0x002d:
            r5 = 8
            if (r0 == 0) goto L_0x003b
            android.widget.TextView r0 = r10.$groupPrompt
            if (r0 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            r0.setVisibility(r4)
        L_0x0039:
            r0 = r4
            goto L_0x0044
        L_0x003b:
            android.widget.TextView r0 = r10.$groupPrompt
            if (r0 != 0) goto L_0x0040
            goto L_0x0043
        L_0x0040:
            r0.setVisibility(r5)
        L_0x0043:
            r0 = r2
        L_0x0044:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r6 = r10.this$0
            android.widget.TextView r6 = r6.mTvDay
            if (r6 != 0) goto L_0x004e
        L_0x004c:
            r6 = r1
            goto L_0x0059
        L_0x004e:
            java.lang.CharSequence r6 = r6.getText()
            if (r6 != 0) goto L_0x0055
            goto L_0x004c
        L_0x0055:
            java.lang.String r6 = r6.toString()
        L_0x0059:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0067
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r7 = r4
            goto L_0x0068
        L_0x0067:
            r7 = r2
        L_0x0068:
            if (r7 == 0) goto L_0x0074
            android.widget.TextView r0 = r10.$dayPrompt
            if (r0 != 0) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            r0.setVisibility(r4)
        L_0x0072:
            r0 = r4
            goto L_0x007c
        L_0x0074:
            android.widget.TextView r7 = r10.$dayPrompt
            if (r7 != 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r7.setVisibility(r5)
        L_0x007c:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r7 = r10.this$0
            android.widget.TextView r7 = r7.mTvTime
            if (r7 != 0) goto L_0x0086
        L_0x0084:
            r7 = r1
            goto L_0x0091
        L_0x0086:
            java.lang.CharSequence r7 = r7.getText()
            if (r7 != 0) goto L_0x008d
            goto L_0x0084
        L_0x008d:
            java.lang.String r7 = r7.toString()
        L_0x0091:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x009f
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            if (r8 == 0) goto L_0x009d
            goto L_0x009f
        L_0x009d:
            r8 = r4
            goto L_0x00a0
        L_0x009f:
            r8 = r2
        L_0x00a0:
            if (r8 == 0) goto L_0x00ac
            android.widget.TextView r0 = r10.$timePrompt
            if (r0 != 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            r0.setVisibility(r4)
        L_0x00aa:
            r0 = r4
            goto L_0x00b4
        L_0x00ac:
            android.widget.TextView r8 = r10.$timePrompt
            if (r8 != 0) goto L_0x00b1
            goto L_0x00b4
        L_0x00b1:
            r8.setVisibility(r5)
        L_0x00b4:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r8 = r10.this$0
            android.widget.EditText r8 = r8.mEditEmail
            if (r8 != 0) goto L_0x00be
        L_0x00bc:
            r8 = r1
            goto L_0x00c9
        L_0x00be:
            android.text.Editable r8 = r8.getText()
            if (r8 != 0) goto L_0x00c5
            goto L_0x00bc
        L_0x00c5:
            java.lang.String r8 = r8.toString()
        L_0x00c9:
            com.tal.app.thinkacademy.business.login.widget.PatternUtil r9 = com.tal.app.thinkacademy.business.login.widget.PatternUtil.INSTANCE
            boolean r9 = r9.emailIsCompliance(r8)
            if (r9 != 0) goto L_0x00db
            android.widget.TextView r0 = r10.$emailPrompt
            if (r0 != 0) goto L_0x00d6
            goto L_0x00d9
        L_0x00d6:
            r0.setVisibility(r4)
        L_0x00d9:
            r0 = r4
            goto L_0x00e3
        L_0x00db:
            android.widget.TextView r9 = r10.$emailPrompt
            if (r9 != 0) goto L_0x00e0
            goto L_0x00e3
        L_0x00e0:
            r9.setVisibility(r5)
        L_0x00e3:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r9 = r10.this$0
            android.widget.EditText r9 = r9.mEditName
            if (r9 != 0) goto L_0x00ec
            goto L_0x00f7
        L_0x00ec:
            android.text.Editable r9 = r9.getText()
            if (r9 != 0) goto L_0x00f3
            goto L_0x00f7
        L_0x00f3:
            java.lang.String r1 = r9.toString()
        L_0x00f7:
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0104
            boolean r9 = kotlin.text.StringsKt.isBlank(r9)
            if (r9 == 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r2 = r4
        L_0x0104:
            if (r2 == 0) goto L_0x010f
            android.widget.TextView r0 = r10.$namePrompt
            if (r0 != 0) goto L_0x010b
            goto L_0x0118
        L_0x010b:
            r0.setVisibility(r4)
            goto L_0x0118
        L_0x010f:
            android.widget.TextView r2 = r10.$namePrompt
            if (r2 != 0) goto L_0x0114
            goto L_0x0117
        L_0x0114:
            r2.setVisibility(r5)
        L_0x0117:
            r4 = r0
        L_0x0118:
            if (r4 == 0) goto L_0x013e
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r0 = r10.$activity
            r0.showLoading()
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r0 = r10.this$0
            com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm r2 = r0.getMViewModel()
            if (r2 != 0) goto L_0x0128
            goto L_0x013e
        L_0x0128:
            kotlin.jvm.internal.Ref$ObjectRef<android.widget.ImageView> r0 = r10.$ivSeleted
            T r0 = r0.element
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = r0.isSelected()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r1
            r8 = r0
            r2.submitIntention(r3, r4, r5, r6, r7, r8)
        L_0x013e:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r0 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP r1 = r10.this$0
            int r1 = r1.mPageId
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.hw_shop_aggregate_collect_click(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateP$footViewShow$1$4.invoke():void");
    }
}
