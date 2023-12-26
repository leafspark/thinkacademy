package com.tal.app.thinkacademy.live.business.studentvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeechStudentLayoutBinding;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.OtherMaxVolumeStudent;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0015j\b\u0012\u0004\u0012\u00020\u0012`\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/SpeechStudentView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessSpeechStudentLayoutBinding;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "KUpdateMic", "isOpen", "", "mHandler", "Landroid/os/Handler;", "mMaxStuCount", "maxVolumeStudentList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/OtherMaxVolumeStudent;", "Lkotlin/collections/ArrayList;", "sortVolume", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "getMaxStuNameStr", "", "limitTen", "name", "onDestroy", "", "setCollectiveSpeech", "updateOtherMic", "student", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeechStudentView.kt */
public final class SpeechStudentView extends BaseVBLivePluginView<LiveBusinessSpeechStudentLayoutBinding> {
    /* access modifiers changed from: private */
    public final int KUpdateMic;
    private boolean isOpen;
    private Handler mHandler;
    private final int mMaxStuCount;
    private final ArrayList<OtherMaxVolumeStudent> maxVolumeStudentList;
    private final Comparator<OtherMaxVolumeStudent> sortVolume;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SpeechStudentView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SpeechStudentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechStudentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.KUpdateMic = 1;
        this.maxVolumeStudentList = new ArrayList<>();
        this.sortVolume = new SpeechStudentView$special$$inlined$compareBy$1();
        this.mMaxStuCount = 2;
        setVisibility(8);
        this.mHandler = new SpeechStudentView$mHandler$1(this, Looper.getMainLooper());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechStudentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setCollectiveSpeech(boolean z) {
        this.isOpen = z;
    }

    /* access modifiers changed from: private */
    public final String getMaxStuNameStr() {
        String str;
        int i = 0;
        String str2 = "";
        for (Object next : this.maxVolumeStudentList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            OtherMaxVolumeStudent otherMaxVolumeStudent = (OtherMaxVolumeStudent) next;
            if (otherMaxVolumeStudent.getModifyTime() >= System.currentTimeMillis() - ((long) 1000)) {
                String userName = otherMaxVolumeStudent.getUserName();
                if (userName == null) {
                    userName = "";
                }
                String stringPlus = Intrinsics.stringPlus(str2, limitTen(userName));
                if (i != this.maxVolumeStudentList.size() - 1) {
                    str = this.mContext.getString(R.string.student_speak_comma);
                } else {
                    str = "";
                }
                str2 = Intrinsics.stringPlus(stringPlus, str);
            }
            XesLog.it("正在说话", "name = " + str2 + ",index = " + i);
            i = i2;
        }
        return str2;
    }

    private final String limitTen(String str) {
        if (str.length() <= 10) {
            return str;
        }
        String substring = str.substring(0, 10);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Intrinsics.stringPlus(substring, "...");
    }

    public final void updateOtherMic(OtherMaxVolumeStudent otherMaxVolumeStudent) {
        Handler handler;
        Intrinsics.checkNotNullParameter(otherMaxVolumeStudent, "student");
        ArrayList<OtherMaxVolumeStudent> arrayList = this.maxVolumeStudentList;
        Iterator<OtherMaxVolumeStudent> it = arrayList.iterator();
        while (it.hasNext()) {
            OtherMaxVolumeStudent next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next()");
            OtherMaxVolumeStudent otherMaxVolumeStudent2 = next;
            if (otherMaxVolumeStudent2.getUid() == otherMaxVolumeStudent.getUid() || otherMaxVolumeStudent2.getModifyTime() < System.currentTimeMillis() - ((long) 1000)) {
                it.remove();
            }
        }
        if (otherMaxVolumeStudent.getVolume() > 90) {
            arrayList.add(otherMaxVolumeStudent);
        }
        CollectionsKt.sortWith(arrayList, this.sortVolume);
        int size = arrayList.size();
        int i = this.mMaxStuCount;
        if (size > i) {
            arrayList.remove(i);
        }
        Handler handler2 = this.mHandler;
        boolean z = false;
        if (handler2 != null && !handler2.hasMessages(this.KUpdateMic)) {
            z = true;
        }
        if (z && (handler = this.mHandler) != null) {
            handler.sendEmptyMessageDelayed(this.KUpdateMic, 100);
        }
    }

    public final void onDestroy() {
        this.maxVolumeStudentList.clear();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public LiveBusinessSpeechStudentLayoutBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessSpeechStudentLayoutBinding inflate = LiveBusinessSpeechStudentLayoutBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
