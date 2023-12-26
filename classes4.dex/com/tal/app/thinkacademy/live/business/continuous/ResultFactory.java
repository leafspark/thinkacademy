package com.tal.app.thinkacademy.live.business.continuous;

import android.content.Context;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.IWindowManager;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/continuous/ResultFactory;", "", "()V", "createWindow", "Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "state", "", "context", "Landroid/content/Context;", "answerBean", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "manager", "Lcom/tal/app/thinkacademy/live/business/continuous/window/IWindowManager;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResultFactory.kt */
public final class ResultFactory {
    public static final ResultFactory INSTANCE = new ResultFactory();

    private ResultFactory() {
    }

    @JvmStatic
    public static final SubmitResultView createWindow(int i, Context context, AnswerBean answerBean, IWindowManager iWindowManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(answerBean, "answerBean");
        Intrinsics.checkNotNullParameter(iWindowManager, "manager");
        if (i == 1) {
            SubmitResultParams submitResultParams = new SubmitResultParams(AwardType.RIGHT, answerBean.getUserLatestCoin(), answerBean.getRightCoin(), answerBean.getLevel(), false, 16, (DefaultConstructorMarker) null);
            SubmitResultView submitResultView = new SubmitResultView(context);
            submitResultView.setParams(submitResultParams);
            return submitResultView;
        } else if (i != 2) {
            return null;
        } else {
            SubmitResultParams submitResultParams2 = new SubmitResultParams(AwardType.WRONG, answerBean.getUserLatestCoin(), answerBean.getRightCoin(), answerBean.getLevel(), false, 16, (DefaultConstructorMarker) null);
            SubmitResultView submitResultView2 = new SubmitResultView(context);
            submitResultView2.setParams(submitResultParams2);
            return submitResultView2;
        }
    }
}
