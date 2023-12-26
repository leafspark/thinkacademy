package com.tal.app.thinkacademy.business.shop.widget.dialog;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterDialog.kt */
final class ClassFilterDialog$bindTabWithPager$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ClassFilterDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassFilterDialog$bindTabWithPager$2(ClassFilterDialog classFilterDialog) {
        super(1);
        this.this$0 = classFilterDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ViewPager viewPager = this.this$0.binding.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }
}
