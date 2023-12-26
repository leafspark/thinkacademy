package com.eaydu.omni.listener;

import com.eaydu.omni.log.bean.LogAudioLocalStatistics;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogMemoryStatistics;
import com.eaydu.omni.log.bean.LogVideoLocalStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;

public interface LogEventListener {
    void LogStartPublish(int i);

    void LogStaticLocalAudioIn(int i);

    void LogStaticLocalAudioStats(LogAudioLocalStatistics logAudioLocalStatistics);

    void LogStaticLocalVideoIn(int i, int i2, int i3);

    void LogStaticLocalVideoStats(LogVideoLocalStatistics logVideoLocalStatistics);

    void LogStaticNetworkQuality(long j, int i, int i2);

    void LogStaticRemoteAudioIn(long j, int i);

    void LogStaticRemoteAudioStats(LogAudioRemoteStatistics logAudioRemoteStatistics);

    @Deprecated
    void LogStaticRemoteAudioTransportStats(LogAudioRemoteStatistics logAudioRemoteStatistics);

    void LogStaticRemoteVideoIn(long j, int i);

    void LogStaticRemoteVideoStats(LogVideoRemoteStatistics logVideoRemoteStatistics);

    @Deprecated
    void LogStaticRemoteVideoTransportStats(LogVideoRemoteStatistics logVideoRemoteStatistics);

    void LogStaticUserAudioVolume(long j, int i);

    void LogStatistics(int i);

    void LogStatisticsMemoryStats(LogMemoryStatistics logMemoryStatistics);

    void LogStopPlay(long j, int i);

    void LogStopPublish(long j, int i);

    void deleteUser(long j);
}
