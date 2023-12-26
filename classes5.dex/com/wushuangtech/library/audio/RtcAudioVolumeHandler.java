package com.wushuangtech.library.audio;

import android.util.LongSparseArray;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.MyMathUtils;
import java.util.HashMap;
import java.util.Map;

public class RtcAudioVolumeHandler {
    private HashMap<String, LongSparseArray<AudioVolumeInfo>> mAudioLevels = new HashMap<>();
    private final AudioVolumeInfo mAudioMixVolumeInfo = new AudioVolumeInfo();
    private final Object mLock = new Object();
    private final OnAudioVolumeHandlerCallBack mOnAudioVolumeHandlerCallBack;

    public interface OnAudioVolumeHandlerCallBack {
        void reportAudioVolumeEvent(AudioVolumeInfo[] audioVolumeInfoArr, int i);
    }

    public RtcAudioVolumeHandler(OnAudioVolumeHandlerCallBack onAudioVolumeHandlerCallBack) {
        this.mOnAudioVolumeHandlerCallBack = onAudioVolumeHandlerCallBack;
    }

    public void handleAudioVolumeLevel(String str, long j, long j2, int i, int i2, int i3) {
        int transAudioLevelFullRange = MyMathUtils.transAudioLevelFullRange(i2);
        updateUserAudioLevel(str, j2, transAudioLevelFullRange, i2);
        if (j == j2) {
            dispatchHandleAudioLocalVolumeLevel(str, j2, transAudioLevelFullRange, i3);
        } else if (this.mAudioMixVolumeInfo.mUid == j2) {
            dispatchHandleAudioMixVolumeLevel(i3);
        } else {
            dispatchHandleRemoteAudioVolumeLevel(str, j2, transAudioLevelFullRange, i3);
        }
    }

    private void updateUserAudioLevel(String str, long j, int i, int i2) {
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null) {
            userManager.updateAudioLevel(j, i);
            userManager.updateAudioFullRangeLevel(j, i2);
        }
    }

    public void handleAudioMixVolumeLevel(String str, long j, int i, int i2) {
        this.mAudioMixVolumeInfo.mChannelId = str;
        this.mAudioMixVolumeInfo.mUid = j;
        this.mAudioMixVolumeInfo.mVolume = i;
    }

    private void dispatchHandleAudioLocalVolumeLevel(String str, long j, int i, int i2) {
        AudioVolumeInfo audioVolumeInfo = new AudioVolumeInfo();
        audioVolumeInfo.mChannelId = str;
        audioVolumeInfo.mUid = 0;
        audioVolumeInfo.mVolume = i;
        audioVolumeInfo.mVad = i2;
        this.mOnAudioVolumeHandlerCallBack.reportAudioVolumeEvent(new AudioVolumeInfo[]{audioVolumeInfo}, i);
    }

    private void dispatchHandleAudioMixVolumeLevel(int i) {
        AudioVolumeInfo audioVolumeInfo = new AudioVolumeInfo();
        audioVolumeInfo.mChannelId = this.mAudioMixVolumeInfo.mChannelId;
        audioVolumeInfo.mUid = this.mAudioMixVolumeInfo.mUid;
        audioVolumeInfo.mVolume = this.mAudioMixVolumeInfo.mVolume;
        audioVolumeInfo.mVad = i;
        this.mOnAudioVolumeHandlerCallBack.reportAudioVolumeEvent(new AudioVolumeInfo[]{audioVolumeInfo}, this.mAudioMixVolumeInfo.mVolume);
    }

    private void dispatchHandleRemoteAudioVolumeLevel(String str, long j, int i, int i2) {
        boolean z;
        synchronized (this.mLock) {
            HashMap<String, LongSparseArray<AudioVolumeInfo>> hashMap = this.mAudioLevels;
            if (hashMap != null) {
                LongSparseArray longSparseArray = hashMap.get(str);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.mAudioLevels.put(str, longSparseArray);
                }
                int size = longSparseArray.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = false;
                        break;
                    } else if (longSparseArray.keyAt(i3) == j) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    AudioVolumeInfo[] audioVolumeInfoArr = new AudioVolumeInfo[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        audioVolumeInfoArr[i4] = (AudioVolumeInfo) longSparseArray.valueAt(i4);
                    }
                    this.mOnAudioVolumeHandlerCallBack.reportAudioVolumeEvent(audioVolumeInfoArr, 0);
                    longSparseArray.clear();
                }
                AudioVolumeInfo audioVolumeInfo = new AudioVolumeInfo();
                audioVolumeInfo.mChannelId = str;
                audioVolumeInfo.mUid = j;
                audioVolumeInfo.mVolume = i;
                audioVolumeInfo.mVad = i2;
                longSparseArray.append(j, audioVolumeInfo);
            }
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            HashMap<String, LongSparseArray<AudioVolumeInfo>> hashMap = this.mAudioLevels;
            if (hashMap != null) {
                clearCollection(hashMap);
                this.mAudioLevels = null;
            }
        }
    }

    private <T> void clearCollection(HashMap<String, LongSparseArray<T>> hashMap) {
        for (Map.Entry<String, LongSparseArray<T>> value : hashMap.entrySet()) {
            ((LongSparseArray) value.getValue()).clear();
        }
        hashMap.clear();
    }
}
