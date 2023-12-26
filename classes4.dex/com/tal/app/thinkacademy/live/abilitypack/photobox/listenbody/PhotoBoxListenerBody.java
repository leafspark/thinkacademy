package com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody;

import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0000H\u0016J)\u0010\u0015\u001a\u00020\u00072!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u000bJ \u0010\u0017\u001a\u00020\u00072\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004J\u0014\u0010\u0018\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u001c\u0010\u0019\u001a\u00020\u00072\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00070\u000bJ\u0014\u0010\u001a\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "onBoxDetailResultBlock", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "", "", "onBoxListEmptyBlock", "Lkotlin/Function0;", "onBoxListResultBoxDetailResult", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;", "onBoxNewMessageBlock", "onCloseBoxBlock", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "Lkotlin/ParameterName;", "name", "sourceType", "dispatch", "listener", "onBoxClose", "block", "onBoxDetailResult", "onBoxListEmpty", "onBoxListResult", "onBoxNewMessage", "BoxDetailResult", "BoxListEmpty", "BoxListResult", "BoxNewMessage", "CloseBox", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxListenerBody.kt */
public class PhotoBoxListenerBody extends ListenerBody<PhotoBoxListenerBody> {
    private Function2<? super HomeworkEntity, ? super Boolean, Unit> onBoxDetailResultBlock;
    private Function0<Unit> onBoxListEmptyBlock;
    private Function1<? super PhotoBoxEntity, Unit> onBoxListResultBoxDetailResult;
    private Function0<Unit> onBoxNewMessageBlock;
    private Function1<? super DetailSource, Unit> onCloseBoxBlock;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody$BoxListEmpty;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListenerBody.kt */
    public static final class BoxListEmpty extends PhotoBoxListenerBody {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody$BoxNewMessage;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "()V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListenerBody.kt */
    public static final class BoxNewMessage extends PhotoBoxListenerBody {
    }

    public void dispatch(PhotoBoxListenerBody photoBoxListenerBody) {
        Function1<? super DetailSource, Unit> function1;
        Intrinsics.checkNotNullParameter(photoBoxListenerBody, "listener");
        if (photoBoxListenerBody instanceof BoxListResult) {
            Function1<? super PhotoBoxEntity, Unit> function12 = this.onBoxListResultBoxDetailResult;
            if (function12 != null) {
                function12.invoke(((BoxListResult) photoBoxListenerBody).getResult());
            }
        } else if (photoBoxListenerBody instanceof BoxDetailResult) {
            Function2<? super HomeworkEntity, ? super Boolean, Unit> function2 = this.onBoxDetailResultBlock;
            if (function2 != null) {
                BoxDetailResult boxDetailResult = (BoxDetailResult) photoBoxListenerBody;
                function2.invoke(boxDetailResult.getItem(), Boolean.valueOf(boxDetailResult.getCanCorrect()));
            }
        } else if (photoBoxListenerBody instanceof BoxNewMessage) {
            Function0<Unit> function0 = this.onBoxNewMessageBlock;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (photoBoxListenerBody instanceof BoxListEmpty) {
            Function0<Unit> function02 = this.onBoxListEmptyBlock;
            if (function02 != null) {
                function02.invoke();
            }
        } else if ((photoBoxListenerBody instanceof CloseBox) && (function1 = this.onCloseBoxBlock) != null) {
            function1.invoke(((CloseBox) photoBoxListenerBody).getSourceType());
        }
    }

    public final void onBoxListResult(Function1<? super PhotoBoxEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onBoxListResultBoxDetailResult = function1;
    }

    public final void onBoxDetailResult(Function2<? super HomeworkEntity, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.onBoxDetailResultBlock = function2;
    }

    public final void onBoxNewMessage(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onBoxNewMessageBlock = function0;
    }

    public final void onBoxListEmpty(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onBoxListEmptyBlock = function0;
    }

    public final void onBoxClose(Function1<? super DetailSource, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onCloseBoxBlock = function1;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody$BoxListResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "result", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;", "(Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;)V", "getResult", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListenerBody.kt */
    public static final class BoxListResult extends PhotoBoxListenerBody {
        private final PhotoBoxEntity result;

        public static /* synthetic */ BoxListResult copy$default(BoxListResult boxListResult, PhotoBoxEntity photoBoxEntity, int i, Object obj) {
            if ((i & 1) != 0) {
                photoBoxEntity = boxListResult.result;
            }
            return boxListResult.copy(photoBoxEntity);
        }

        public final PhotoBoxEntity component1() {
            return this.result;
        }

        public final BoxListResult copy(PhotoBoxEntity photoBoxEntity) {
            return new BoxListResult(photoBoxEntity);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BoxListResult) && Intrinsics.areEqual(this.result, ((BoxListResult) obj).result);
        }

        public int hashCode() {
            PhotoBoxEntity photoBoxEntity = this.result;
            if (photoBoxEntity == null) {
                return 0;
            }
            return photoBoxEntity.hashCode();
        }

        public String toString() {
            return "BoxListResult(result=" + this.result + ')';
        }

        public BoxListResult(PhotoBoxEntity photoBoxEntity) {
            this.result = photoBoxEntity;
        }

        public final PhotoBoxEntity getResult() {
            return this.result;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody$BoxDetailResult;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "item", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "canCorrect", "", "(Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;Z)V", "getCanCorrect", "()Z", "getItem", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListenerBody.kt */
    public static final class BoxDetailResult extends PhotoBoxListenerBody {
        private final boolean canCorrect;
        private final HomeworkEntity item;

        public static /* synthetic */ BoxDetailResult copy$default(BoxDetailResult boxDetailResult, HomeworkEntity homeworkEntity, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                homeworkEntity = boxDetailResult.item;
            }
            if ((i & 2) != 0) {
                z = boxDetailResult.canCorrect;
            }
            return boxDetailResult.copy(homeworkEntity, z);
        }

        public final HomeworkEntity component1() {
            return this.item;
        }

        public final boolean component2() {
            return this.canCorrect;
        }

        public final BoxDetailResult copy(HomeworkEntity homeworkEntity, boolean z) {
            Intrinsics.checkNotNullParameter(homeworkEntity, "item");
            return new BoxDetailResult(homeworkEntity, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BoxDetailResult)) {
                return false;
            }
            BoxDetailResult boxDetailResult = (BoxDetailResult) obj;
            return Intrinsics.areEqual(this.item, boxDetailResult.item) && this.canCorrect == boxDetailResult.canCorrect;
        }

        public int hashCode() {
            int hashCode = this.item.hashCode() * 31;
            boolean z = this.canCorrect;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "BoxDetailResult(item=" + this.item + ", canCorrect=" + this.canCorrect + ')';
        }

        public final boolean getCanCorrect() {
            return this.canCorrect;
        }

        public final HomeworkEntity getItem() {
            return this.item;
        }

        public BoxDetailResult(HomeworkEntity homeworkEntity, boolean z) {
            Intrinsics.checkNotNullParameter(homeworkEntity, "item");
            this.item = homeworkEntity;
            this.canCorrect = z;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody$CloseBox;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "sourceType", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "(Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;)V", "getSourceType", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxListenerBody.kt */
    public static final class CloseBox extends PhotoBoxListenerBody {
        private final DetailSource sourceType;

        public static /* synthetic */ CloseBox copy$default(CloseBox closeBox, DetailSource detailSource, int i, Object obj) {
            if ((i & 1) != 0) {
                detailSource = closeBox.sourceType;
            }
            return closeBox.copy(detailSource);
        }

        public final DetailSource component1() {
            return this.sourceType;
        }

        public final CloseBox copy(DetailSource detailSource) {
            Intrinsics.checkNotNullParameter(detailSource, "sourceType");
            return new CloseBox(detailSource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloseBox) && this.sourceType == ((CloseBox) obj).sourceType;
        }

        public int hashCode() {
            return this.sourceType.hashCode();
        }

        public String toString() {
            return "CloseBox(sourceType=" + this.sourceType + ')';
        }

        public CloseBox(DetailSource detailSource) {
            Intrinsics.checkNotNullParameter(detailSource, "sourceType");
            this.sourceType = detailSource;
        }

        public final DetailSource getSourceType() {
            return this.sourceType;
        }
    }
}
