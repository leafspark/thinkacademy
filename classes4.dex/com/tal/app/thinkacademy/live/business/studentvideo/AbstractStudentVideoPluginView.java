package com.tal.app.thinkacademy.live.business.studentvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J$\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000fH\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\u001c\u0010(\u001a\u00020\u00172\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001c0*H\u0016J\u001e\u0010+\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u000fH\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u000fH\u0016J\u0018\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u000fH\u0016J\u0012\u00108\u001a\u00020\u00172\b\u00109\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010C\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0018\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\bH\u0016J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001c\u0010G\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001c\u0010H\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010I\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\u0016\u0010J\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\u0018\u0010K\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\bH\u0016J\u0010\u0010M\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000fH\u0016R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/AbstractStudentVideoPluginView;", "T", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "classType", "", "driver", "Ljava/lang/Object;", "isEnableSwitch", "", "mUid", "", "Ljava/lang/Long;", "renderViewWithPermission", "state", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;", "addRenderView", "", "surfaceView", "Landroid/view/SurfaceView;", "index", "bean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "addSmallClassVideo", "list", "", "changeSmallClassVideo", "position", "changeTurnState", "open", "hideVoiceLottieView", "size", "isSmallStudentVisible", "onDestroy", "putAllStudentInfo", "map", "", "removeSmallClassVideo", "rootViewIsShow", "isShow", "setALLRemoteVideoDisable", "isDisable", "setAllOnStage", "on", "setCollectiveSpeech", "isCollectiveSpeech", "setSwitchEnable", "enable", "setTurnState1", "turnState1", "setUserCoins", "coins", "showEmoji", "uid", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "", "showExamMask", "normal", "showLevelIcon", "level", "showNoPermissionView", "showRaiseHand", "showStudentInfo", "listBean", "showVoiceLottieView", "studentOffline", "studentOnline", "updateSmallClassVideo", "updateSmallClassVideoList", "updateSmallMic", "mic", "videoChatToggle", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbstractStudentVideoPluginView.kt */
public abstract class AbstractStudentVideoPluginView<T> extends BaseLivePluginView {
    public String classType;
    public T driver;
    public boolean isEnableSwitch;
    public Long mUid;
    public boolean renderViewWithPermission;
    public EnableState state;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbstractStudentVideoPluginView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbstractStudentVideoPluginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    public void addRenderView(SurfaceView surfaceView, int i) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
    }

    public void addRenderView(SurfaceView surfaceView, int i, StudentVideoBean.ListBean listBean) {
    }

    public void addSmallClassVideo(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void changeSmallClassVideo(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void changeTurnState(boolean z) {
    }

    public void hideVoiceLottieView(int i) {
    }

    public boolean isSmallStudentVisible(int i) {
        return false;
    }

    public void onDestroy() {
    }

    public void putAllStudentInfo(Map<Long, ? extends StudentVideoBean.ListBean> map) {
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public void removeSmallClassVideo(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void rootViewIsShow(boolean z) {
    }

    public void setALLRemoteVideoDisable(boolean z) {
    }

    public void setAllOnStage(boolean z) {
    }

    public void setCollectiveSpeech(boolean z) {
    }

    public void setTurnState1(boolean z) {
    }

    public void setUserCoins(String str) {
    }

    public void showEmoji(long j, EmojiBean<Object> emojiBean, boolean z) {
        Intrinsics.checkNotNullParameter(emojiBean, "bean");
    }

    public void showExamMask(boolean z, int i) {
    }

    public void showLevelIcon(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "level");
    }

    public void showNoPermissionView(int i) {
    }

    public void showRaiseHand(long j, boolean z) {
    }

    public void showStudentInfo(StudentVideoBean.ListBean listBean, int i) {
        Intrinsics.checkNotNullParameter(listBean, "listBean");
    }

    public void showVoiceLottieView(int i) {
    }

    public void studentOffline(int i) {
    }

    public void studentOffline(int i, StudentVideoBean.ListBean listBean) {
    }

    public void studentOnline(int i) {
    }

    public void studentOnline(int i, StudentVideoBean.ListBean listBean) {
    }

    public void updateSmallClassVideo(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void updateSmallClassVideoList(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void updateSmallMic(long j, int i) {
    }

    public void videoChatToggle(boolean z) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractStudentVideoPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.mUid = -1L;
        this.isEnableSwitch = true;
        this.state = EnableState.ANIMATION;
        this.classType = EnterRoomMuteData.STATUS_UN_MUTE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractStudentVideoPluginView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void studentOnline$default(AbstractStudentVideoPluginView abstractStudentVideoPluginView, int i, StudentVideoBean.ListBean listBean, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                listBean = null;
            }
            abstractStudentVideoPluginView.studentOnline(i, listBean);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: studentOnline");
    }

    public static /* synthetic */ void studentOffline$default(AbstractStudentVideoPluginView abstractStudentVideoPluginView, int i, StudentVideoBean.ListBean listBean, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                listBean = null;
            }
            abstractStudentVideoPluginView.studentOffline(i, listBean);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: studentOffline");
    }

    public void setSwitchEnable(boolean z, EnableState enableState) {
        Intrinsics.checkNotNullParameter(enableState, "state");
        this.isEnableSwitch = z;
        this.state = enableState;
    }
}
