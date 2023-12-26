package com.tal.app.thinkacademy.live.business.homework.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkListBinding;
import com.tal.app.thinkacademy.live.business.homework.adapter.HomeworkAdapter;
import com.tal.app.thinkacademy.live.business.homework.driver.IPhotoBoxPlugin;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\r2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxListView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessHomeworkListBinding;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;)V", "mCanCorrect", "", "mHomeworkAdapter", "Lcom/tal/app/thinkacademy/live/business/homework/adapter/HomeworkAdapter;", "close", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "initViews", "refreshLayout", "height", "", "showHomeworkList", "list", "", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "canCorrect", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxListView.kt */
public final class PhotoBoxListView extends BaseVBLivePluginView<LiveBusinessHomeworkListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "列表";
    private static final Tag TAG = Tag.PHOTO_BOX;
    private final IPhotoBoxPlugin driver;
    private boolean mCanCorrect;
    private HomeworkAdapter mHomeworkAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoBoxListView(Context context, IPhotoBoxPlugin iPhotoBoxPlugin) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iPhotoBoxPlugin, "driver");
        this.driver = iPhotoBoxPlugin;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxListView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void initViews() {
        PhotoBoxListView.super.initViews();
        close();
    }

    /* access modifiers changed from: protected */
    public LiveBusinessHomeworkListBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessHomeworkListBinding inflate = LiveBusinessHomeworkListBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public final void showHomeworkList(List<? extends HomeworkEntity> list, boolean z) {
        Unit unit;
        XesLog.i(TAG, SUB_TAG, "展示作业列表");
        if (PadUtils.isPad(getContext())) {
            this.mBinding.viewLiveBusinessHomeworkWindow.setVisibility(0);
        } else {
            this.mBinding.viewLiveBusinessHomeworkWindowPhone.setVisibility(0);
        }
        this.mBinding.getRoot().setVisibility(0);
        this.mBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.homework_pop_show_anim));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        FrameLayout frameLayout = this.mBinding.layoutLiveBusinessHomeworkWindow;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.layoutLiveBusinessHomeworkWindow");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, frameLayout, 0, new PhotoBoxListView$showHomeworkList$1(this), 1, (Object) null);
        this.mCanCorrect = z;
        HomeworkAdapter homeworkAdapter = this.mHomeworkAdapter;
        if (homeworkAdapter == null) {
            unit = null;
        } else {
            if (homeworkAdapter != null) {
                homeworkAdapter.setList(list);
            }
            this.mBinding.rvLiveBusinessHomeworkWindow.scrollToPosition(0);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PhotoBoxListView photoBoxListView = this;
            HomeworkAdapter homeworkAdapter2 = new HomeworkAdapter(list, PadUtils.isPad(this.mContext) ? R.layout.live_business_homework_item_pad : R.layout.live_business_homework_item_phone);
            this.mHomeworkAdapter = homeworkAdapter2;
            homeworkAdapter2.setCanCorrect(z);
            this.mBinding.rvLiveBusinessHomeworkWindow.setLayoutManager(new LinearLayoutManager(getContext()));
            this.mBinding.rvLiveBusinessHomeworkWindow.setAdapter(this.mHomeworkAdapter);
            HomeworkAdapter homeworkAdapter3 = this.mHomeworkAdapter;
            if (homeworkAdapter3 != null) {
                homeworkAdapter3.addChildClickViewIds(new int[]{R.id.iv_live_business_homework_resubmit});
            }
            HomeworkAdapter homeworkAdapter4 = this.mHomeworkAdapter;
            if (homeworkAdapter4 != null) {
                homeworkAdapter4.setOnItemChildClickListener(new PhotoBoxListView$$ExternalSyntheticLambda0(this));
            }
            HomeworkAdapter homeworkAdapter5 = this.mHomeworkAdapter;
            if (homeworkAdapter5 != null) {
                homeworkAdapter5.setOnItemClickListener(new PhotoBoxListView$$ExternalSyntheticLambda1(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showHomeworkList$lambda-4$lambda-1  reason: not valid java name */
    public static final void m274showHomeworkList$lambda4$lambda1(PhotoBoxListView photoBoxListView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(photoBoxListView, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Object item = baseQuickAdapter.getItem(i);
        Objects.requireNonNull(item, "null cannot be cast to non-null type com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity");
        HomeworkEntity homeworkEntity = (HomeworkEntity) item;
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("重新提交作业 ", homeworkEntity.getTagType()));
        if (Intrinsics.areEqual("graffiti", homeworkEntity.getTagType())) {
            photoBoxListView.driver.resubmitDraw(homeworkEntity);
        } else {
            photoBoxListView.driver.resubmitPhoto(homeworkEntity);
        }
        photoBoxListView.close();
    }

    /* access modifiers changed from: private */
    /* renamed from: showHomeworkList$lambda-4$lambda-3  reason: not valid java name */
    public static final void m275showHomeworkList$lambda4$lambda3(PhotoBoxListView photoBoxListView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(photoBoxListView, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        HomeworkAdapter homeworkAdapter = photoBoxListView.mHomeworkAdapter;
        HomeworkEntity homeworkEntity = homeworkAdapter == null ? null : (HomeworkEntity) homeworkAdapter.getItem(i);
        photoBoxListView.close();
        if (homeworkEntity != null) {
            photoBoxListView.driver.showHomeworkDetail(DetailSource.LIST, homeworkEntity, photoBoxListView.mCanCorrect);
        }
    }

    public final void refreshLayout(int i) {
        int dp2px = SizeUtils.dp2px(400.0f);
        float f = (((float) i) * 1.0f) / ((float) dp2px);
        ViewScaleUtil.scale(this.mBinding.rvLiveBusinessHomeworkWindow, f, 0, 0);
        XesLog.i(TAG, SUB_TAG, "屏幕高 = " + i + " , 设计稿高 = " + dp2px + " , 缩放" + f + 20493);
    }

    public final void close() {
        if (this.mBinding.getRoot().getVisibility() != 8) {
            XesLog.i(TAG, SUB_TAG, "关闭作业列表");
            this.mBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.homework_pop_hide_anim));
            this.mBinding.getRoot().setVisibility(8);
        }
    }
}
