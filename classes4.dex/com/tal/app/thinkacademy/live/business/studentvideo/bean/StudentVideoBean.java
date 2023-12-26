package com.tal.app.thinkacademy.live.business.studentvideo.bean;

import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import java.util.List;

public class StudentVideoBean {
    public static final int STREAM_STATE_FORBID = 4;
    public static final int STREAM_STATE_START = 0;
    public static final int STREAM_STATE_STOP = 3;
    public static final int STREAM_STATE_STREAMING = 1;
    public static final int STREAM_STATE_SUCCESS = 2;
    private boolean isFull;
    private List<ListBean> list;

    public List<ListBean> getList() {
        return this.list;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public boolean isFull() {
        return this.isFull;
    }

    public void setFull(boolean z) {
        this.isFull = z;
    }

    public static class ListBean {
        private String avatar;
        private int cameraPerm = 0;
        private long ctime;
        private boolean isDisableTheVideo = false;
        private boolean isHerselfOff = false;
        private boolean isMySelfOff = false;
        private boolean isMyselfShowHeadBg = false;
        private boolean isOnStageAction = false;
        private boolean isOpenCamera = true;
        private boolean isOpenMic = true;
        private boolean isOtherShowHeadBg = false;
        private boolean isRaiseHandUp = false;
        private boolean isShowEmoji = false;
        private boolean isShowForbidUserView = false;
        private boolean isShowMicLight = false;
        private boolean isShowOpenCameraButton = true;
        private boolean isStudentOnline = false;
        private boolean isVideoMute = false;
        private int level;
        private EmojiBean mEmojiBean;
        private String nickName;
        private int pullStreamState;
        private String title;
        private long userId;

        public boolean isShowOpenCameraButton() {
            return this.isShowOpenCameraButton;
        }

        public void setShowOpenCameraButton(boolean z) {
            this.isShowOpenCameraButton = z;
        }

        public long getUserId() {
            return this.userId;
        }

        public void setUserId(long j) {
            this.userId = j;
        }

        public String getNickName() {
            return this.nickName;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public int getCameraPerm() {
            return this.cameraPerm;
        }

        public void setCameraPerm(int i) {
            this.cameraPerm = i;
        }

        public long getCtime() {
            return this.ctime;
        }

        public void setCtime(long j) {
            this.ctime = j;
        }

        public int getLevel() {
            return this.level;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public boolean isHerselfOff() {
            return this.isHerselfOff;
        }

        public void setHerselfOff(boolean z) {
            this.isHerselfOff = z;
        }

        public boolean isOtherShowHeadBg() {
            return this.isOtherShowHeadBg;
        }

        public void setOtherShowHeadBg(boolean z) {
            this.isOtherShowHeadBg = z;
        }

        public boolean isMyselfShowHeadBg() {
            return this.isMyselfShowHeadBg;
        }

        public void setMyselfShowHeadBg(boolean z) {
            this.isMyselfShowHeadBg = z;
        }

        public boolean isMySelfOff() {
            return this.isMySelfOff;
        }

        public void setMySelfOff(boolean z) {
            this.isMySelfOff = z;
        }

        public boolean isStudentOnline() {
            return this.isStudentOnline;
        }

        public void setStudentOnline(boolean z) {
            this.isStudentOnline = z;
        }

        public boolean isDisableTheVideo() {
            return this.isDisableTheVideo;
        }

        public void setDisableTheVideo(boolean z) {
            this.isDisableTheVideo = z;
        }

        public boolean isOpenMic() {
            return this.isOpenMic;
        }

        public void setOpenMic(boolean z) {
            this.isOpenMic = z;
        }

        public boolean isOpenCamera() {
            return this.isOpenCamera;
        }

        public void setOpenCamera(boolean z) {
            this.isOpenCamera = z;
        }

        public boolean isShowMicLight() {
            return this.isShowMicLight;
        }

        public void setShowMicLight(boolean z) {
            this.isShowMicLight = z;
        }

        public int hashCode() {
            return (int) this.userId;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ListBean) && this.userId == ((ListBean) obj).userId) {
                return true;
            }
            return false;
        }

        public int getPullStreamState() {
            return this.pullStreamState;
        }

        public void setPullStreamState(int i) {
            if (this.pullStreamState != 4) {
                this.pullStreamState = i;
            }
        }

        public void setPullStreamStateForce(int i) {
            this.pullStreamState = i;
        }

        public boolean isRaiseHandUp() {
            return this.isRaiseHandUp;
        }

        public void setRaiseHandUp(boolean z) {
            this.isRaiseHandUp = z;
        }

        public boolean isShowEmoji() {
            return this.isShowEmoji;
        }

        public void setShowEmoji(boolean z) {
            this.isShowEmoji = z;
        }

        public boolean isOnStageAction() {
            return this.isOnStageAction;
        }

        public void setOnStageAction(boolean z) {
            this.isOnStageAction = z;
        }

        public EmojiBean getEmojiBean() {
            return this.mEmojiBean;
        }

        public void setEmojiBean(EmojiBean emojiBean) {
            this.mEmojiBean = emojiBean;
        }

        public boolean isShowForbidUserView() {
            return this.isShowForbidUserView;
        }

        public void setShowForbidUserView(boolean z) {
            this.isShowForbidUserView = z;
        }

        public boolean isVideoMute() {
            return this.isVideoMute;
        }

        public void setVideoMute(boolean z) {
            this.isVideoMute = z;
        }
    }
}
