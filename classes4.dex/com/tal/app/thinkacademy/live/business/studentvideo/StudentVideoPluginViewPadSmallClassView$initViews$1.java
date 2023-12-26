package com.tal.app.thinkacademy.live.business.studentvideo;

import android.widget.TextView;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentVideoPluginViewPadSmallClassView.kt */
final class StudentVideoPluginViewPadSmallClassView$initViews$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StudentVideoPluginViewPadSmallClassView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentVideoPluginViewPadSmallClassView$initViews$1(StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView) {
        super(0);
        this.this$0 = studentVideoPluginViewPadSmallClassView;
    }

    public final void invoke() {
        StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView = this.this$0;
        studentVideoPluginViewPadSmallClassView.mCurrentPage = studentVideoPluginViewPadSmallClassView.mCurrentPage - 1;
        if (this.this$0.mCurrentPage < 1) {
            this.this$0.mCurrentPage = 1;
            return;
        }
        TextView access$getTvVideoPage$p = this.this$0.tvVideoPage;
        if (access$getTvVideoPage$p != null) {
            access$getTvVideoPage$p.setText(this.this$0.mCurrentPage + " / " + this.this$0.mMaxPage);
        }
        StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) this.this$0.driver;
        if (studentVideoPluginDriver != null) {
            studentVideoPluginDriver.setCurrentPage(this.this$0.mCurrentPage, this.this$0.mMaxPage);
        }
    }
}
