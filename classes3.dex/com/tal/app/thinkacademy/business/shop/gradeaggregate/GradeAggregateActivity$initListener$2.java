package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateActivity.kt */
final class GradeAggregateActivity$initListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GradeAggregateActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateActivity$initListener$2(GradeAggregateActivity gradeAggregateActivity) {
        super(0);
        this.this$0 = gradeAggregateActivity;
    }

    public final void invoke() {
        List data;
        Integer type;
        if (!this.this$0.havaClassItem) {
            return;
        }
        if (this.this$0.classIndex > -1) {
            LinearLayoutManager access$getMLinearLayoutManager$p = this.this$0.mLinearLayoutManager;
            if (access$getMLinearLayoutManager$p != null) {
                access$getMLinearLayoutManager$p.scrollToPositionWithOffset(this.this$0.classIndex, 0);
                return;
            }
            return;
        }
        GradeAggregateActivity gradeAggregateActivity = this.this$0;
        GradeAggregateAdapter access$getMGradeAggregateAdapter$p = gradeAggregateActivity.mGradeAggregateAdapter;
        if (access$getMGradeAggregateAdapter$p != null && (data = access$getMGradeAggregateAdapter$p.getData()) != null) {
            int i = 0;
            for (Object next : data) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GradeAggregateTitleNode gradeAggregateTitleNode = (BaseNode) next;
                if (!(gradeAggregateTitleNode instanceof GradeAggregateTitleNode) || (type = gradeAggregateTitleNode.getType()) == null || type.intValue() != 11) {
                    i = i2;
                } else {
                    if (gradeAggregateActivity.mVideoView != null) {
                        i = i2;
                    }
                    gradeAggregateActivity.classIndex = i;
                    LinearLayoutManager access$getMLinearLayoutManager$p2 = gradeAggregateActivity.mLinearLayoutManager;
                    if (access$getMLinearLayoutManager$p2 != null) {
                        access$getMLinearLayoutManager$p2.scrollToPositionWithOffset(gradeAggregateActivity.classIndex, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
