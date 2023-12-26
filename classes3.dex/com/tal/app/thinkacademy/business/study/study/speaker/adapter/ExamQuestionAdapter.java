package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundViewDelegate;
import com.tal.app.thinkacademy.business.study.study.entity.Question;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ExamQuestionAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/Question;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "mShowBottom", "", "convert", "", "holder", "item", "setShowBottom", "show", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExamQuestionAdapter.kt */
public final class ExamQuestionAdapter extends BaseQuickAdapter<Question, BaseViewHolder> {
    private boolean mShowBottom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExamQuestionAdapter(List<Question> list) {
        super(R.layout.item_exam_question, list);
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public final void setShowBottom(boolean z) {
        this.mShowBottom = z;
        notifyItemChanged(getData().size());
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Question question) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(question, "item");
        baseViewHolder.setText(R.id.tv_item_question_type, question.getType());
        baseViewHolder.setText(R.id.tv_item_question_count, Intrinsics.stringPlus("× ", question.getCount()));
        RoundViewDelegate delegate = baseViewHolder.getView(R.id.llContent).getDelegate();
        if (baseViewHolder.getLayoutPosition() == getData().size()) {
            delegate.setCornerRadius_BL(SizeUtils.dp2px(10.0f));
            delegate.setCornerRadius_BR(SizeUtils.dp2px(10.0f));
        } else {
            delegate.setCornerRadius_BL(0);
            delegate.setCornerRadius_BR(0);
        }
        if (baseViewHolder.getLayoutPosition() != getData().size() || !this.mShowBottom) {
            baseViewHolder.setGone(R.id.space_item_bottom, true);
        } else {
            baseViewHolder.setGone(R.id.space_item_bottom, false);
        }
    }
}
