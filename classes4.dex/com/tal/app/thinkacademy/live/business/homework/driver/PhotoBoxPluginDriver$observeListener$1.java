package com.tal.app.thinkacademy.live.business.homework.driver;

import android.content.Context;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEmpty;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity;
import com.tal.app.thinkacademy.live.business.homework.view.PhotoBoxDetailView;
import com.tal.app.thinkacademy.live.business.homework.view.PhotoBoxListView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxPluginDriver.kt */
final class PhotoBoxPluginDriver$observeListener$1 extends Lambda implements Function1<PhotoBoxListenerBody, Unit> {
    final /* synthetic */ PhotoBoxPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhotoBoxPluginDriver$observeListener$1(PhotoBoxPluginDriver photoBoxPluginDriver) {
        super(1);
        this.this$0 = photoBoxPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PhotoBoxListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PhotoBoxListenerBody photoBoxListenerBody) {
        Intrinsics.checkNotNullParameter(photoBoxListenerBody, "$this$observeListener");
        final PhotoBoxPluginDriver photoBoxPluginDriver = this.this$0;
        photoBoxListenerBody.onBoxListEmpty(new Function0<Unit>() {
            public final void invoke() {
                HomeworkEmpty mHomeworkEmpty;
                XesLog.i(PhotoBoxPluginDriver.TAG, "无作业数据，即将显示空view");
                PhotoBoxViewModel access$getMViewModel$p = photoBoxPluginDriver.mViewModel;
                if (access$getMViewModel$p != null && (mHomeworkEmpty = access$getMViewModel$p.getMHomeworkEmpty()) != null) {
                    photoBoxPluginDriver.showNoHomework(mHomeworkEmpty);
                }
            }
        });
        final PhotoBoxPluginDriver photoBoxPluginDriver2 = this.this$0;
        photoBoxListenerBody.onBoxListResult(new Function1<PhotoBoxEntity, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PhotoBoxEntity) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PhotoBoxEntity photoBoxEntity) {
                List<HomeworkEntity> list;
                boolean z = true;
                XesLog.i(PhotoBoxPluginDriver.TAG, "作业盒子列表有数据，即将显示列表view");
                if (photoBoxPluginDriver2.mPhotoBoxListView == null && photoBoxPluginDriver2.mContext != null) {
                    PhotoBoxPluginDriver photoBoxPluginDriver = photoBoxPluginDriver2;
                    Context access$getMContext$p = photoBoxPluginDriver2.mContext;
                    Intrinsics.checkNotNull(access$getMContext$p);
                    photoBoxPluginDriver.mPhotoBoxListView = new PhotoBoxListView(access$getMContext$p, photoBoxPluginDriver2);
                    FrameLayout.LayoutParams newLp = LiveAreaContext.get().getScreenLp().newLp();
                    ILiveRoomProvider r2 = photoBoxPluginDriver2.mLiveRoomProvider;
                    BaseLivePluginDriver baseLivePluginDriver = photoBoxPluginDriver2;
                    r2.addView(baseLivePluginDriver, baseLivePluginDriver.mPhotoBoxListView, PhotoBoxPluginDriverKt.PHOTO_BOX_KEY_LIST_VIEW, newLp);
                }
                PhotoBoxListView access$getMPhotoBoxListView$p = photoBoxPluginDriver2.mPhotoBoxListView;
                if (access$getMPhotoBoxListView$p != null) {
                    if (photoBoxEntity == null) {
                        list = null;
                    } else {
                        list = photoBoxEntity.list;
                    }
                    if (photoBoxEntity == null || !photoBoxEntity.canCorrect) {
                        z = false;
                    }
                    access$getMPhotoBoxListView$p.showHomeworkList(list, z);
                }
            }
        });
        final PhotoBoxPluginDriver photoBoxPluginDriver3 = this.this$0;
        photoBoxListenerBody.onBoxDetailResult(new Function2<HomeworkEntity, Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((HomeworkEntity) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(HomeworkEntity homeworkEntity, boolean z) {
                Intrinsics.checkNotNullParameter(homeworkEntity, "item");
                XesLog.i(PhotoBoxPluginDriver.TAG, "作业盒子详情有数据，即将显示详情view");
                PhotoBoxListView access$getMPhotoBoxListView$p = photoBoxPluginDriver3.mPhotoBoxListView;
                if (access$getMPhotoBoxListView$p != null) {
                    access$getMPhotoBoxListView$p.close();
                }
                photoBoxPluginDriver3.showHomeworkDetail(DetailSource.IRC, homeworkEntity, z);
            }
        });
        photoBoxListenerBody.onBoxNewMessage(AnonymousClass4.INSTANCE);
        final PhotoBoxPluginDriver photoBoxPluginDriver4 = this.this$0;
        photoBoxListenerBody.onBoxClose(new Function1<DetailSource, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DetailSource) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DetailSource detailSource) {
                Intrinsics.checkNotNullParameter(detailSource, "it");
                XesLog.i(PhotoBoxPluginDriver.TAG, Intrinsics.stringPlus("关闭作业盒子 类型：", detailSource));
                PhotoBoxDetailView access$getMPhotoBoxDetailView$p = photoBoxPluginDriver4.mPhotoBoxDetailView;
                if ((access$getMPhotoBoxDetailView$p == null ? null : access$getMPhotoBoxDetailView$p.getMSource()) == detailSource) {
                    PhotoBoxDetailView access$getMPhotoBoxDetailView$p2 = photoBoxPluginDriver4.mPhotoBoxDetailView;
                    if (access$getMPhotoBoxDetailView$p2 != null) {
                        access$getMPhotoBoxDetailView$p2.close("结束互动");
                    }
                } else {
                    PhotoBoxDetailView access$getMPhotoBoxDetailView$p3 = photoBoxPluginDriver4.mPhotoBoxDetailView;
                    if (access$getMPhotoBoxDetailView$p3 != null) {
                        access$getMPhotoBoxDetailView$p3.uncorrectability();
                    }
                }
                PhotoBoxListView access$getMPhotoBoxListView$p = photoBoxPluginDriver4.mPhotoBoxListView;
                if (access$getMPhotoBoxListView$p != null) {
                    access$getMPhotoBoxListView$p.close();
                }
            }
        });
    }
}
