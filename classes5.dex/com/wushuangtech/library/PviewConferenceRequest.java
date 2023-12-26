package com.wushuangtech.library;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.InterCorrectionManager;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.InterCorrectionEnum;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.thread.EngineCallbackThread;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.XMLParseUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PviewConferenceRequest {
    private static final String TAG = "PviewConferenceRequest";

    public void onRemoteVideoMuted(String str, long j, boolean z) {
    }

    public void OnConfMemberEnter(String str, long j, String str2, int i, int i2, boolean z, boolean z2) {
        String str3 = str;
        long j2 = j;
        boolean z3 = z2;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str3);
        if (userManager == null) {
            String str4 = TAG;
            OmniLog.e("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str4, "Handle user join channel failed... Not found user Manager by channel's id... " + str3);
            return;
        }
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str3);
        if (deviceManager == null) {
            String str5 = TAG;
            OmniLog.e("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str5, "Handle user join channel failed... ot found user device Manager by channel's id... " + str3 + " | " + j2 + " | " + str2);
            return;
        }
        User user = new User(j2, i);
        user.setTimestampTrusted(z);
        user.setCrossRoomUser(z3);
        userManager.putOrUpdateUser(user);
        String str6 = TAG;
        OmniLog.i("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str6, "Add a new user... " + user.toString());
        initUserDevices("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", deviceManager, str, j, str2);
        UserDeviceConfig videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(j2);
        StringBuilder sb = new StringBuilder();
        sb.append("The new default video device : ");
        sb.append(videoDeviceForDefault == null ? "null" : videoDeviceForDefault.toString());
        OmniLog.i("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str6, sb.toString());
        if (str3.equals(GlobalConfig.mLocalRoomName)) {
            updateUserDeviceOpenStatus("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", videoDeviceForDefault, str, j);
            GlobalHolder.getInstance().sendRtcEngineEvent(7, Long.valueOf(j), Integer.valueOf(i));
        }
        if (GlobalConfig.mVideoEnabled) {
            updateIJKPlayerSeiContent(userManager);
        } else {
            if (z3) {
                EnterConfApiImpl.getInstance().mixGuestAudio(j2, true, "");
            }
        }
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        if (interCorrectionManager != null) {
            InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(str3, j2);
            interCorrectUserBean.mAction = InterCorrectionEnum.INTER_SETUP_REMOTE_VIDEO;
            interCorrectionManager.recoveryInter(interCorrectUserBean, false, true);
        }
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            globalVideoConfig.updateUserStatus(str3, j2, true);
        }
    }

    public void OnConfMemberExitCallback(String str, long j) {
        String str2;
        String str3 = str;
        long j2 = j;
        GlobalHolder instance = GlobalHolder.getInstance();
        RtcUserManager userManager = instance.getUserManager(str3);
        if (userManager == null) {
            OmniLog.e("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", TAG, "Handle user leave channel failed... Not found user Manager by channel's id... " + str3);
            return;
        }
        RtcDeviceManager deviceManager = instance.getDeviceManager(str3);
        if (deviceManager == null) {
            OmniLog.e("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", TAG, "Handle user leave channel failed... ot found user device Manager by channel's id... " + str3 + " | " + j2);
            return;
        }
        EnterConfApiImpl instance2 = EnterConfApiImpl.getInstance();
        String str4 = null;
        if (GlobalConfig.mVideoEnabled) {
            instance2.updateVideoDefaultDevice(j2, false);
            UserDeviceConfig userDefaultDevice = instance.getUserDefaultDevice(str3, j2);
            String deviceId = userDefaultDevice != null ? userDefaultDevice.getDeviceId() : null;
            if (!TextUtils.isEmpty(deviceId)) {
                EnterConfApi.getInstance().controlUserVideoDevice(str, j, deviceId, false);
            }
            User user = userManager.getUser(j2);
            if (user != null) {
                str4 = user.getDeviceIdWithOpened();
            }
            str2 = str4;
            str4 = deviceId;
        } else {
            str2 = null;
        }
        if (!GlobalConfig.mVideoEnabled) {
            User user2 = userManager.getUser(j2);
            if (user2 == null) {
                OmniLog.d(OmniLog.CROSS_WATCH, "CROSS_WATCH -> Del cross user from mix audio stream failed!, User is null!" + j2);
            } else if (user2.isCrossRoomUser()) {
                instance2.mixGuestAudio(j2, false, "");
            }
        }
        userManager.delUser(j2);
        deviceManager.clearUserDevice(j2);
        if (GlobalConfig.mVideoEnabled && !TextUtils.isEmpty(str4)) {
            ExternalVideoModule instance3 = ExternalVideoModule.getInstance();
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
            }
            instance3.stopPlay(str3, str4);
        }
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            globalVideoConfig.updateUserStatus(str3, j2, false);
        }
    }

    public void OnUpdateVideoDev(String str, long j, String str2) {
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (deviceManager == null) {
            String str3 = TAG;
            OmniLog.e("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str3, "Init user video device list failed.. RtcDeviceManager is null... " + str + " | " + j + " | " + str2);
            return;
        }
        List<UserDeviceConfig> initUserDevices = initUserDevices("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", deviceManager, str, j, str2);
        UserDeviceConfig videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(j);
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("The new default video device : ");
        sb.append(videoDeviceForDefault == null ? "null" : videoDeviceForDefault.toString());
        OmniLog.d("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str4, sb.toString());
        if (str.equals(GlobalConfig.mLocalRoomName)) {
            updateUserDeviceOpenStatus("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", videoDeviceForDefault, str, j);
        }
        reportUserDevices("USER_WATCH|DEVICE_WATCH|DUAL_WATCH", str, j, initUserDevices);
    }

    public void OnReportMediaAddr(String str, int i, String str2, String str3, int i2, String str4) {
        GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
        if (globalChannelConfig != null) {
            globalChannelConfig.setAVServerMediaInfo(str, i, str3, i2);
        }
        List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
        if (rtcHeartbeatReporterForAll != null) {
            for (RtcHeartbeatReporter next : rtcHeartbeatReporterForAll) {
                next.setAudioMediaInfo(str, i, str2);
                next.setVideoMediaInfo(str3, i2, str4);
            }
        }
    }

    public void OnUpdateMediaChannelState(int i, int i2, String str, int i3, int i4) {
        GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
        if (globalChannelConfig != null) {
            if (i == 0) {
                if (!str.equals(globalChannelConfig.getAudioLinkedIp()) || i3 != globalChannelConfig.getAudioLinkedPort()) {
                    return;
                }
            } else if (!str.equals(globalChannelConfig.getVideoLinkedIp()) || i3 != globalChannelConfig.getVideoLinkedPort()) {
                return;
            }
            setMediaAVState(i, i2);
            if (i4 == 1) {
                if (i == 0 && i2 == 2) {
                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_CONNECT_STATE_CHANGED, 3, 15);
                }
                if (i == 1 && i2 == 2) {
                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_CONNECT_STATE_CHANGED, 3, 16);
                }
            }
        }
    }

    private List<UserDeviceConfig> initUserDevices(String str, RtcDeviceManager rtcDeviceManager, String str2, long j, String str3) {
        UserDeviceConfig userDeviceConfig;
        String str4 = TAG;
        OmniLog.d(str, str4, "Xml content .. " + str3);
        ArrayList arrayList = new ArrayList();
        if (!XMLParseUtils.parseUserDeviceInfos(j, str3, arrayList)) {
            return null;
        }
        if (arrayList.size() <= 0) {
            OmniLog.e(str, str4, "Device not acquired... " + str2 + " | " + j + " | " + str3);
            return rtcDeviceManager.clearUserDeviceAvailableStatus(j);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                userDeviceConfig = null;
                break;
            }
            userDeviceConfig = (UserDeviceConfig) it.next();
            if (userDeviceConfig.isDefaultDevice()) {
                break;
            }
        }
        if (userDeviceConfig == null) {
            return null;
        }
        updateDefaultDevice(rtcDeviceManager.getVideoDeviceForDefault(j), userDeviceConfig);
        List<UserDeviceConfig> updateUserDevice = rtcDeviceManager.updateUserDevice(j, arrayList);
        boolean z = !TextUtils.isEmpty(userDeviceConfig.getDualDeviceId());
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str2);
        if (userManager == null) {
            OmniLog.e(str, TAG, "Update user's dual steam failed... RtcUserManager is null!");
            return updateUserDevice;
        } else if (userManager.getUser(j) == null) {
            OmniLog.e(str, TAG, "Update user's dual steam failed... User is null... " + str2 + " | " + j);
            return updateUserDevice;
        } else {
            userManager.updateDeviceForDual(j, z);
            return updateUserDevice;
        }
    }

    private void updateDefaultDevice(UserDeviceConfig userDeviceConfig, UserDeviceConfig userDeviceConfig2) {
        String str;
        String str2;
        String str3 = "";
        if (userDeviceConfig != null) {
            str2 = userDeviceConfig.getDeviceId();
            str = userDeviceConfig.getDualDeviceId();
        } else {
            str = str3;
            str2 = str;
        }
        if (str2 == null) {
            str2 = str3;
        }
        if (str != null) {
            str3 = str;
        }
        String deviceId = userDeviceConfig2.getDeviceId();
        String dualDeviceId = userDeviceConfig2.getDualDeviceId();
        if (!str2.equals(deviceId)) {
            if (!TextUtils.isEmpty(str2)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(str2, false);
            }
            if (!TextUtils.isEmpty(deviceId)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(deviceId, true);
            }
        }
        if (!str3.equals(dualDeviceId)) {
            if (!TextUtils.isEmpty(str3)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(str3, false);
            }
            if (!TextUtils.isEmpty(dualDeviceId)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(dualDeviceId, true);
            }
        }
    }

    private void updateUserDeviceOpenStatus(String str, UserDeviceConfig userDeviceConfig, String str2, long j) {
        InterCorrectionManager interCorrectionManager;
        if (userDeviceConfig == null) {
            OmniLog.e(str, TAG, "Open user's device failed... UserDeviceConfig is null!");
            return;
        }
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str2);
        if (userManager == null) {
            OmniLog.e(str, TAG, "Open user's device failed... RtcUserManager is null!");
            return;
        }
        User user = userManager.getUser(j);
        if (user == null) {
            OmniLog.e(str, TAG, "Open user's device failed... User is null!");
            return;
        }
        if ((user.getIdentity() != 2 && userDeviceConfig.isUse() && GlobalConfig.mVideoEnabled) && (interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager()) != null) {
            InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(LocalSDKConstants.ENGINE_CHANNEL_ID, j);
            interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_VIDEO;
            InterCorrectUserBean interCorrectUserBean2 = (InterCorrectUserBean) interCorrectionManager.recoveryInterWithNoNotify(interCorrectUserBean);
            if (interCorrectUserBean2 != null) {
                boolean booleanValue = ((Boolean) interCorrectUserBean2.mInfo).booleanValue();
                String str3 = TAG;
                OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str3, "User has joined room, restore the user's video streaming status, muted: " + booleanValue);
                if (!booleanValue) {
                    EnterConfApi.getInstance().controlUserVideoDevice(str2, j, userDeviceConfig.getDeviceId(), true);
                }
            } else if (GlobalConfig.mDefaultMuteAllRemoteVideoStreams) {
                OmniLog.i(OmniLog.INTER_CORRECT_WATCH, TAG, "User has joined room, but doesn't pull the video stream by default.");
            } else {
                EnterConfApi.getInstance().controlUserVideoDevice(str2, j, userDeviceConfig.getDeviceId(), true);
            }
        }
    }

    private void reportUserDevices(String str, String str2, long j, List<UserDeviceConfig> list) {
        char c;
        char c2;
        String str3 = str;
        String str4 = str2;
        List<UserDeviceConfig> list2 = list;
        if (list2 != null) {
            RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str4);
            if (userManager == null) {
                OmniLog.e(str3, TAG, "Report user's device failed... RtcUserManager is null!");
            } else if (userManager.getUser(j) == null) {
                OmniLog.e(str3, TAG, "Report user's device failed... User is null!");
            } else {
                EngineCallbackThread workerThread = GlobalHolder.getInstance().getWorkerThread();
                char c3 = 0;
                int i = 0;
                while (i < list.size()) {
                    UserDeviceConfig userDeviceConfig = list2.get(i);
                    if (userDeviceConfig == null) {
                        c = c3;
                    } else {
                        OmniLog.d(str3, TAG, "Reprot device info: " + userDeviceConfig.toString());
                        long uid = userDeviceConfig.getUid();
                        boolean isUse = userDeviceConfig.isUse();
                        int i2 = isUse ? 4 : 3;
                        if (userDeviceConfig.isDefaultDevice()) {
                            GlobalHolder instance = GlobalHolder.getInstance();
                            RtcGlobalServerMessage rtcGlobalServerMessage = RtcGlobalServerMessage.VIDEO_REMOTE_STATE_CHANGED;
                            Object[] objArr = new Object[5];
                            objArr[c3] = str4;
                            objArr[1] = Long.valueOf(uid);
                            objArr[2] = Integer.valueOf(isUse ? 1 : 0);
                            objArr[3] = Integer.valueOf(i2);
                            c = 0;
                            objArr[4] = 0;
                            instance.sendSyncGlobalServerMessage(rtcGlobalServerMessage, objArr);
                            c2 = 1;
                            workerThread.sendMessage(15, new Object[]{Long.valueOf(uid), Boolean.valueOf(userDeviceConfig.isUse())});
                        } else {
                            c = c3;
                            c2 = 1;
                        }
                        Object[] objArr2 = new Object[3];
                        objArr2[c] = Long.valueOf(j);
                        objArr2[c2] = userDeviceConfig.getDeviceId();
                        objArr2[2] = Boolean.valueOf(userDeviceConfig.isUse());
                        workerThread.sendMessage(59, objArr2);
                        Object[] objArr3 = new Object[4];
                        objArr3[c] = Long.valueOf(j);
                        objArr3[c2] = userDeviceConfig.getDeviceId();
                        objArr3[2] = Integer.valueOf(userDeviceConfig.getVideoType());
                        objArr3[3] = Boolean.valueOf(userDeviceConfig.isUse());
                        workerThread.sendMessage(69, objArr3);
                    }
                    i++;
                    c3 = c;
                }
            }
        }
    }

    private void updateIJKPlayerSeiContent(RtcUserManager rtcUserManager) {
        boolean z;
        LongSparseArray<User> users = rtcUserManager.getUsers();
        if (users != null) {
            int i = GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_NEW ? 1 : 3;
            int i2 = 0;
            for (int i3 = 0; i3 < users.size(); i3++) {
                User user = users.get((long) i3);
                if (user != null && user.getIdentity() == i) {
                    i2++;
                }
            }
            if (i2 > 0) {
                OmniLog.d("insertH264Content watcher : new user coming , stop insert.......... ");
                z = false;
            } else {
                OmniLog.d("insertH264Content watcher : Only one broadcast left.......... ");
                z = true;
            }
            GlobalHolder.getInstance().sendSyncGlobalMessage(2, Boolean.valueOf(z));
        }
    }

    private void setMediaAVState(int i, int i2) {
        List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
        if (rtcHeartbeatReporterForAll != null) {
            for (RtcHeartbeatReporter next : rtcHeartbeatReporterForAll) {
                if (i == 0) {
                    next.setAudioMediaState(i2);
                } else if (i == 1) {
                    next.setVideoMediaState(i2);
                }
            }
        }
    }

    public void setLogReportConfig(boolean z, boolean z2, int i) {
        GlobalConfig.mLogReportInterval = i;
    }

    public void setMediaReconnectInfo(int i, String str) {
        List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
        if (rtcHeartbeatReporterForAll != null) {
            for (RtcHeartbeatReporter mediaReconnectInfo : rtcHeartbeatReporterForAll) {
                mediaReconnectInfo.setMediaReconnectInfo(i, str);
            }
        }
    }
}
