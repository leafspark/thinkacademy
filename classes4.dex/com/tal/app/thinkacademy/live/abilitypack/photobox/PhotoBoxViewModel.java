package com.tal.app.thinkacademy.live.abilitypack.photobox;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEmpty;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0015H\u0014J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/PhotoBoxViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mClassId", "", "Ljava/lang/Integer;", "mHomeworkEmpty", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEmpty;", "getMHomeworkEmpty", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEmpty;", "setMHomeworkEmpty", "(Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEmpty;)V", "mListenerData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/listenbody/PhotoBoxListenerBody;", "getMListenerData", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mPlanId", "closeBox", "", "source", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "onReceiveMessage", "message", "", "onVmDestroy", "openBoxList", "syncCoins", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxViewModel.kt */
public final class PhotoBoxViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PHOTO_BOX;
    private Integer mClassId;
    private HomeworkEmpty mHomeworkEmpty;
    private final ListenerData<PhotoBoxListenerBody> mListenerData = new ListenerData<>();
    /* access modifiers changed from: private */
    public Integer mPlanId;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    public final void syncCoins() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        r0 = r0.getCourseInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhotoBoxViewModel(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3) {
        /*
            r2 = this;
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>(r3)
            com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData r0 = new com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData
            r0.<init>()
            r2.mListenerData = r0
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r3.getDataStorage()
            r1 = 0
            if (r0 != 0) goto L_0x0018
        L_0x0016:
            r0 = r1
            goto L_0x0027
        L_0x0018:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r0 = r0.getCourseInfo()
            if (r0 != 0) goto L_0x001f
            goto L_0x0016
        L_0x001f:
            int r0 = r0.getPlanId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0027:
            r2.mPlanId = r0
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x0030
            goto L_0x003f
        L_0x0030:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r3 = r3.getCourseInfo()
            if (r3 != 0) goto L_0x0037
            goto L_0x003f
        L_0x0037:
            int r3 = r3.getClassId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
        L_0x003f:
            r2.mClassId = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider):void");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/photobox/PhotoBoxViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ListenerData<PhotoBoxListenerBody> getMListenerData() {
        return this.mListenerData;
    }

    public final HomeworkEmpty getMHomeworkEmpty() {
        return this.mHomeworkEmpty;
    }

    public final void setMHomeworkEmpty(HomeworkEmpty homeworkEmpty) {
        this.mHomeworkEmpty = homeworkEmpty;
    }

    public final void openBoxList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PhotoBoxViewModel$openBoxList$1()), (CoroutineStart) null, new PhotoBoxViewModel$openBoxList$2(new FunctionRepository(), this, (Continuation<? super PhotoBoxViewModel$openBoxList$2>) null), 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00dd, code lost:
        if (r3 != false) goto L_0x00df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ec A[Catch:{ Exception -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0159 A[Catch:{ Exception -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0199 A[Catch:{ Exception -> 0x01a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceiveMessage(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "interact_correct_count_"
            java.lang.String r1 = ""
            java.lang.String r2 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            com.tal.app.thinkacademy.live.Tag r2 = TAG     // Catch:{ Exception -> 0x01a7 }
            r3 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3     // Catch:{ Exception -> 0x01a7 }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r6 = "收到信令"
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r3, r5)     // Catch:{ Exception -> 0x01a7 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a7 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = "homework_box_check"
            org.json.JSONObject r9 = r3.optJSONObject(r9)     // Catch:{ Exception -> 0x01a7 }
            if (r9 != 0) goto L_0x0028
            r9 = 0
            goto L_0x002e
        L_0x0028:
            java.lang.String r3 = "content"
            java.lang.String r9 = r9.optString(r3)     // Catch:{ Exception -> 0x01a7 }
        L_0x002e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a7 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = "parameter"
            java.lang.String r9 = r3.optString(r9)     // Catch:{ Exception -> 0x01a7 }
            r5 = r9
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01a7 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r6 = "correct_picrure_t"
            if (r5 != 0) goto L_0x0053
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a7 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = r3.optString(r6)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "{\n                val pa…picrure_t\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x0067
        L_0x0053:
            java.lang.String r9 = "msg"
            java.lang.String r9 = r3.optString(r9)     // Catch:{ Exception -> 0x01a7 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a7 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = r3.optString(r6)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "{\n                val ms…picrure_t\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)     // Catch:{ Exception -> 0x01a7 }
        L_0x0067:
            com.tal.app.thinkacademy.lib.util.GsonUtil r3 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.Class<com.tal.app.thinkacademy.live.business.homework.entity.HomeworkDetailMsg> r5 = com.tal.app.thinkacademy.live.business.homework.entity.HomeworkDetailMsg.class
            java.lang.Object r9 = r3.fromJson((java.lang.String) r9, r5)     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.business.homework.entity.HomeworkDetailMsg r9 = (com.tal.app.thinkacademy.live.business.homework.entity.HomeworkDetailMsg) r9     // Catch:{ Exception -> 0x01a7 }
            if (r9 != 0) goto L_0x0081
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r0 = "作业盒子接口detail为空"
            r9[r7] = r0     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r9)     // Catch:{ Exception -> 0x01a7 }
            return
        L_0x0081:
            int r2 = r9.getNewCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            if (r2 <= 0) goto L_0x008e
            int r2 = r9.getNewCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            r9.setCorrectStatus(r2)     // Catch:{ Exception -> 0x01a7 }
        L_0x008e:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "current_interact_id"
            int r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = r2.getString(r3, r1, r5)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "graffiti"
            java.lang.String r5 = r9.getTagType()     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)     // Catch:{ Exception -> 0x01a7 }
            if (r3 == 0) goto L_0x00c3
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = "is_take_draw"
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.getBoolean(r5, r7, r6)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = r9.getInteractId()     // Catch:{ Exception -> 0x01a7 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01a7 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01a7 }
            boolean r2 = android.text.TextUtils.equals(r5, r2)     // Catch:{ Exception -> 0x01a7 }
            if (r2 == 0) goto L_0x00e1
            if (r3 == 0) goto L_0x00e1
            goto L_0x00df
        L_0x00c3:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = "is_take_photo"
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.getBoolean(r5, r7, r6)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = r9.getInteractId()     // Catch:{ Exception -> 0x01a7 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01a7 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01a7 }
            boolean r2 = android.text.TextUtils.equals(r5, r2)     // Catch:{ Exception -> 0x01a7 }
            if (r2 == 0) goto L_0x00e1
            if (r3 == 0) goto L_0x00e1
        L_0x00df:
            r2 = r4
            goto L_0x00e2
        L_0x00e1:
            r2 = r7
        L_0x00e2:
            java.util.List r3 = r9.getPictureUrl()     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x01a7 }
            if (r3 != 0) goto L_0x00f6
            java.util.List r1 = r9.getPictureUrl()     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x01a7 }
        L_0x00f6:
            r3 = r1
            int r1 = r9.getCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r5 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.RIGHT     // Catch:{ Exception -> 0x01a7 }
            int r5 = r5.getValue()     // Catch:{ Exception -> 0x01a7 }
            if (r1 == r5) goto L_0x011b
            int r1 = r9.getCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r5 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.WRONG     // Catch:{ Exception -> 0x01a7 }
            int r5 = r5.getValue()     // Catch:{ Exception -> 0x01a7 }
            if (r1 == r5) goto L_0x011b
            int r1 = r9.getCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r5 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.HALF_CORRECT     // Catch:{ Exception -> 0x01a7 }
            int r5 = r5.getValue()     // Catch:{ Exception -> 0x01a7 }
            if (r1 != r5) goto L_0x0157
        L_0x011b:
            java.lang.String r1 = "interact"
            java.lang.String r5 = r9.getTagType()     // Catch:{ Exception -> 0x01a7 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)     // Catch:{ Exception -> 0x01a7 }
            if (r1 != 0) goto L_0x0133
            java.lang.String r1 = "question"
            java.lang.String r5 = r9.getTagType()     // Catch:{ Exception -> 0x01a7 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)     // Catch:{ Exception -> 0x01a7 }
            if (r1 == 0) goto L_0x0157
        L_0x0133:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = r9.getInteractId()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)     // Catch:{ Exception -> 0x01a7 }
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER     // Catch:{ Exception -> 0x01a7 }
            int r1 = r1.getInt(r5, r7, r6)     // Catch:{ Exception -> 0x01a7 }
            int r1 = r1 + r4
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = r9.getInteractId()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)     // Catch:{ Exception -> 0x01a7 }
            int r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER     // Catch:{ Exception -> 0x01a7 }
            r4.put((java.lang.String) r0, (int) r1, (int) r5)     // Catch:{ Exception -> 0x01a7 }
        L_0x0157:
            if (r2 == 0) goto L_0x0199
            com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity r6 = new com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity     // Catch:{ Exception -> 0x01a7 }
            r1 = 0
            java.lang.String r4 = r9.getInteractId()     // Catch:{ Exception -> 0x01a7 }
            int r5 = r9.getCorrectStatus()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = r9.getTagType()     // Catch:{ Exception -> 0x01a7 }
            r0 = r6
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x01a7 }
            int r0 = r9.getRewardType()     // Catch:{ Exception -> 0x01a7 }
            r6.setRewardType(r0)     // Catch:{ Exception -> 0x01a7 }
            int r9 = r9.getRightCoin()     // Catch:{ Exception -> 0x01a7 }
            r6.setRightCoin(r9)     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData<com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody> r9 = r8.mListenerData     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody$BoxDetailResult r0 = new com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody$BoxDetailResult     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r8.getMLiveRoomProvider()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r1 = r1.getEnterConfig()     // Catch:{ Exception -> 0x01a7 }
            boolean r1 = r1.isWallCanCorrect()     // Catch:{ Exception -> 0x01a7 }
            r0.<init>(r6, r1)     // Catch:{ Exception -> 0x01a7 }
            r9.setStickyData(r0)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01ab
        L_0x0199:
            r8.syncCoins()     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData<com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody> r9 = r8.mListenerData     // Catch:{ Exception -> 0x01a7 }
            com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody$BoxNewMessage r0 = new com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody$BoxNewMessage     // Catch:{ Exception -> 0x01a7 }
            r0.<init>()     // Catch:{ Exception -> 0x01a7 }
            r9.setStickyData(r0)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01ab
        L_0x01a7:
            r9 = move-exception
            r9.printStackTrace()
        L_0x01ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel.onReceiveMessage(java.lang.String):void");
    }

    public final void closeBox(DetailSource detailSource) {
        Intrinsics.checkNotNullParameter(detailSource, "source");
        this.mListenerData.setStickyData(new PhotoBoxListenerBody.CloseBox(detailSource));
    }
}
