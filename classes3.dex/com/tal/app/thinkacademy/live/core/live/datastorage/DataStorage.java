package com.tal.app.thinkacademy.live.core.live.datastorage;

import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.LiveStatus;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UrlConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import java.util.List;

public class DataStorage {
    private EmojiDetailEntity entity;
    private EnterEntity mEnterEntity;
    private MetaDataEntity mMetadataEntity;
    private PlaybackUrlEntity mPlaybackEntity;
    private RoomData mRoomData;

    public void setEnterResp(EnterEntity enterEntity, boolean z) {
        this.mEnterEntity = enterEntity;
        if (this.mRoomData == null) {
            this.mRoomData = new RoomData(z);
        }
        this.mRoomData.updateWithEnter(enterEntity, enterEntity.getRequestDuration());
    }

    public UserInfoProxy getUserInfo() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return new UserInfoProxy(enterEntity.stuInfo);
    }

    public PlanInfoProxy getPlanInfo() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return new PlanInfoProxy(enterEntity.getPlanInfo());
    }

    public CounselorInfoProxy getCounselorInfo() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return new CounselorInfoProxy(enterEntity.getCounselorInfo());
    }

    public TeacherInfo getTeacherInfo() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return enterEntity.getTeacherInfo();
    }

    public EnterConfigProxy getEnterConfig() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return new EnterConfigProxy(enterEntity.getConfigs());
    }

    public EmojiDetailEntity getEmojiDetailEntity() {
        return this.entity;
    }

    public void setEmojiDetailEntity(EmojiDetailEntity emojiDetailEntity) {
        this.entity = emojiDetailEntity;
    }

    public UrlConfig getUrls() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return enterEntity.getUrlConfig();
    }

    public LiveStatus getLiveStatus() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return enterEntity.getLiveStatus();
    }

    public CourseInfoProxy getCourseInfo() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return new CourseInfoProxy(enterEntity.getCourseInfo());
    }

    public List<Long> getStuList() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return enterEntity.stuList;
    }

    public List<StuGraffitiPage> getPageKeyList() {
        EnterEntity enterEntity = this.mEnterEntity;
        if (enterEntity == null) {
            return null;
        }
        return enterEntity.pageKeyList;
    }

    public void setRoomData(RoomData roomData) {
        this.mRoomData = roomData;
    }

    public RoomData getRoomData() {
        return this.mRoomData;
    }

    public void setMetaDataResp(MetaDataEntity metaDataEntity) {
        this.mMetadataEntity = metaDataEntity;
    }

    public MetaDataEntity getMetadataResp() {
        return this.mMetadataEntity;
    }

    public void setPlaybackUrlResp(PlaybackUrlEntity playbackUrlEntity) {
        this.mPlaybackEntity = playbackUrlEntity;
    }

    public PlaybackUrlEntity getPlaybackUrlResp() {
        return this.mPlaybackEntity;
    }

    public void clean() {
        this.mEnterEntity = null;
        this.mMetadataEntity = null;
        this.mPlaybackEntity = null;
        this.mRoomData = null;
    }
}
