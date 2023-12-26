package com.tal.app.thinkacademy.live.core.plugin;

import com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver;
import com.tal.app.thinkacademy.live.business.audition.AuditionDriver;
import com.tal.app.thinkacademy.live.business.bulletscreen.BulletScreenDriver;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenBackPluginDriver;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenLivePluginDriver;
import com.tal.app.thinkacademy.live.business.chatbox.ChatBoxPluginDriver;
import com.tal.app.thinkacademy.live.business.coin.CoinCenterDriver;
import com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechLivePluginDriver;
import com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechPlayBackPluginDriver;
import com.tal.app.thinkacademy.live.business.common.CommonFunctionDriver;
import com.tal.app.thinkacademy.live.business.countdown.driver.CountdownPluginDriver;
import com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver;
import com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver;
import com.tal.app.thinkacademy.live.business.exam.driver.ExamPluginDriver;
import com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver;
import com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver;
import com.tal.app.thinkacademy.live.business.gift.driver.GiftLivePluginDriver;
import com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver;
import com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatBackDriver;
import com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatDriver;
import com.tal.app.thinkacademy.live.business.homework.driver.HomeworkPluginDriver;
import com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver;
import com.tal.app.thinkacademy.live.business.interactivegames.driver.GameActivityPluginDriver;
import com.tal.app.thinkacademy.live.business.interactivegames.driver.GameBackPluginDriver;
import com.tal.app.thinkacademy.live.business.keyboardfill.KeyboardFillDriver;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPluginDriver;
import com.tal.app.thinkacademy.live.business.livemessage.PlayBackMsgPluginDriver;
import com.tal.app.thinkacademy.live.business.liveplay.LivePlayPluginDriver;
import com.tal.app.thinkacademy.live.business.liveplayback.LivePlayBackPluginDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackDriver;
import com.tal.app.thinkacademy.live.business.nps.NpsPluginDriver;
import com.tal.app.thinkacademy.live.business.pageindex.PageIndexPluginDriver;
import com.tal.app.thinkacademy.live.business.parentaudit.ParentAuditDriver;
import com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallLivePlugin;
import com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallPlayBackPlugin;
import com.tal.app.thinkacademy.live.business.praise.PraisePluginDriver;
import com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver;
import com.tal.app.thinkacademy.live.business.randomcall.driver.RandomCallPluginDriver;
import com.tal.app.thinkacademy.live.business.randomcallnew.RandomCallNewPluginDriver;
import com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver;
import com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketLivePluginDriver;
import com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketPlayBackPluginDriver;
import com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver;
import com.tal.app.thinkacademy.live.business.roomdata.RoomDataDriver;
import com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotPlugDriver;
import com.tal.app.thinkacademy.live.business.sign.SignInPluginDriver;
import com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver;
import com.tal.app.thinkacademy.live.business.star.StarPluginDriver;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginPlayBackDriver;
import com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver;
import com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver;
import com.tal.app.thinkacademy.live.business.voice.VoicePluginDriver;
import com.tal.app.thinkacademy.live.business.vote.VotePluginDriver;
import java.util.ArrayList;

public class PluginClassWarehouse implements IPluginLoader {
    public void init() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(VotePluginDriver.class);
        arrayList.add(ScreenShotPlugDriver.class);
        arrayList.add(AuditionDriver.class);
        arrayList.add(RedPacketLivePluginDriver.class);
        arrayList.add(RedPacketPlayBackPluginDriver.class);
        arrayList.add(CountdownPluginDriver.class);
        arrayList.add(PraisePluginDriver.class);
        arrayList.add(RandomCallPluginDriver.class);
        arrayList.add(TutorVideoCallDriver.class);
        arrayList.add(VideoCallDriver.class);
        arrayList.add(TopicPluginPlayBackDriver.class);
        arrayList.add(TopicPluginLiveDriver.class);
        arrayList.add(LivePlayPluginDriver.class);
        arrayList.add(GiftLivePluginDriver.class);
        arrayList.add(UserHeartbeatDriver.class);
        arrayList.add(UserHeartbeatBackDriver.class);
        arrayList.add(LiveMsgPluginDriver.class);
        arrayList.add(StarPluginDriver.class);
        arrayList.add(VoicePluginDriver.class);
        arrayList.add(HomeworkPluginDriver.class);
        arrayList.add(MediaControlPlaybackDriver.class);
        arrayList.add(MediaControlLiveDriver.class);
        arrayList.add(CanvasTripleScreenBackPluginDriver.class);
        arrayList.add(CanvasTripleScreenLivePluginDriver.class);
        arrayList.add(ExamPluginDriver.class);
        arrayList.add(LivePlayBackPluginDriver.class);
        arrayList.add(StudentVideoPluginDriver.class);
        arrayList.add(SmallClassPluginDriver.class);
        arrayList.add(ChatBoxPluginDriver.class);
        arrayList.add(RoomDataDriver.class);
        arrayList.add(SignInPluginDriver.class);
        arrayList.add(PraiseListPluginDriver.class);
        arrayList.add(DrawPluginDriver.class);
        arrayList.add(RankingPluginDriver.class);
        arrayList.add(AllOnStagePluginDriver.class);
        arrayList.add(SpeechPlayBackPluginDriver.class);
        arrayList.add(SpeechLivePluginDriver.class);
        arrayList.add(ParentAuditDriver.class);
        arrayList.add(KeyboardFillDriver.class);
        arrayList.add(PhotosOnTheWallLivePlugin.class);
        arrayList.add(PhotosOnTheWallPlayBackPlugin.class);
        arrayList.add(RedPackageRainPluginDriver.class);
        arrayList.add(FunctionPluginDriver.class);
        arrayList.add(NpsPluginDriver.class);
        arrayList.add(PlayBackMsgPluginDriver.class);
        arrayList.add(RandomCallNewPluginDriver.class);
        arrayList.add(GroupVideoCallPluginDriver.class);
        arrayList.add(CommonFunctionDriver.class);
        arrayList.add(CoinCenterDriver.class);
        arrayList.add(TeacherCameUpPluginDriver.class);
        arrayList.add(ExercisePluginDriver.class);
        arrayList.add(ExerciseBackPluginDriver.class);
        arrayList.add(PhotoBoxPluginDriver.class);
        arrayList.add(BulletScreenDriver.class);
        arrayList.add(PageIndexPluginDriver.class);
        arrayList.add(DirectionGoldNewPluginDriver.class);
        arrayList.add(SpeedyHandPluginDriver.class);
        arrayList.add(SchulteTablePluginDriver.class);
        arrayList.add(GameBackPluginDriver.class);
        arrayList.add(GameActivityPluginDriver.class);
        PluginLoadHelper.setPluginClass(arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0363, code lost:
        if (r0.equals("com.tal.app.thinkacademy.live.business.nps.NpsPluginDriver") == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver loadPlugin(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r6, com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = r7.getClassName()
            java.lang.String r1 = "."
            int r1 = r0.lastIndexOf(r1)
            r2 = 0
            r0.substring(r2, r1)
            r3 = 1
            int r1 = r1 + r3
            r0.substring(r1)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            if (r8 == 0) goto L_0x0025
            int r4 = r8.length()
            if (r4 <= 0) goto L_0x0025
            java.lang.String r4 = "initModuleData"
            r1.putString(r4, r8)
        L_0x0025:
            if (r7 == 0) goto L_0x002c
            java.lang.String r8 = "pluginConfData"
            r1.putSerializable(r8, r7)
        L_0x002c:
            r0.hashCode()
            r7 = -1
            int r8 = r0.hashCode()
            switch(r8) {
                case -2135048648: goto L_0x035d;
                case -1997493387: goto L_0x0351;
                case -1914980841: goto L_0x0345;
                case -1812226840: goto L_0x0339;
                case -1793628662: goto L_0x032d;
                case -1790063082: goto L_0x0321;
                case -1750920521: goto L_0x0315;
                case -1691142190: goto L_0x0309;
                case -1676395098: goto L_0x02fb;
                case -1675637870: goto L_0x02ed;
                case -1576112996: goto L_0x02df;
                case -1530067862: goto L_0x02d1;
                case -1488082241: goto L_0x02c3;
                case -1390169238: goto L_0x02b5;
                case -1360161313: goto L_0x02a7;
                case -1327638510: goto L_0x0299;
                case -1304247566: goto L_0x028b;
                case -1214268206: goto L_0x027d;
                case -1139063303: goto L_0x026f;
                case -987447170: goto L_0x0261;
                case -930758094: goto L_0x0253;
                case -838663438: goto L_0x0245;
                case -767553718: goto L_0x0237;
                case -622921683: goto L_0x0229;
                case -501596754: goto L_0x021b;
                case -472278468: goto L_0x020d;
                case -361456994: goto L_0x01ff;
                case -354777779: goto L_0x01f1;
                case -304328986: goto L_0x01e3;
                case -277097289: goto L_0x01d5;
                case -190877676: goto L_0x01c7;
                case -143402934: goto L_0x01b9;
                case -97324039: goto L_0x01ab;
                case -53136537: goto L_0x019d;
                case 317476933: goto L_0x018f;
                case 344100435: goto L_0x0181;
                case 360874306: goto L_0x0173;
                case 496644890: goto L_0x0165;
                case 530563839: goto L_0x0157;
                case 653916186: goto L_0x0149;
                case 914313020: goto L_0x013b;
                case 997659762: goto L_0x012d;
                case 1036748840: goto L_0x011f;
                case 1045599792: goto L_0x0111;
                case 1096135307: goto L_0x0103;
                case 1162488386: goto L_0x00f5;
                case 1174548940: goto L_0x00e7;
                case 1336388994: goto L_0x00d9;
                case 1401342583: goto L_0x00cb;
                case 1449927474: goto L_0x00bd;
                case 1460161778: goto L_0x00af;
                case 1532213751: goto L_0x00a2;
                case 1542162874: goto L_0x0095;
                case 1615882299: goto L_0x0088;
                case 1748562534: goto L_0x007b;
                case 1840103109: goto L_0x006e;
                case 1854290622: goto L_0x0061;
                case 1894859903: goto L_0x0054;
                case 1937759796: goto L_0x0047;
                case 1941827468: goto L_0x003a;
                default: goto L_0x0037;
            }
        L_0x0037:
            r2 = r7
            goto L_0x0367
        L_0x003a:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0043
            goto L_0x0037
        L_0x0043:
            r2 = 59
            goto L_0x0367
        L_0x0047:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.coin.CoinCenterDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0050
            goto L_0x0037
        L_0x0050:
            r2 = 58
            goto L_0x0367
        L_0x0054:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.keyboardfill.KeyboardFillDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x005d
            goto L_0x0037
        L_0x005d:
            r2 = 57
            goto L_0x0367
        L_0x0061:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallLivePlugin"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x006a
            goto L_0x0037
        L_0x006a:
            r2 = 56
            goto L_0x0367
        L_0x006e:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.parentaudit.ParentAuditDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0077
            goto L_0x0037
        L_0x0077:
            r2 = 55
            goto L_0x0367
        L_0x007b:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0084
            goto L_0x0037
        L_0x0084:
            r2 = 54
            goto L_0x0367
        L_0x0088:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0091
            goto L_0x0037
        L_0x0091:
            r2 = 53
            goto L_0x0367
        L_0x0095:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.voice.VoicePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x009e
            goto L_0x0037
        L_0x009e:
            r2 = 52
            goto L_0x0367
        L_0x00a2:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatBackDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00ab
            goto L_0x0037
        L_0x00ab:
            r2 = 51
            goto L_0x0367
        L_0x00af:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00b9
            goto L_0x0037
        L_0x00b9:
            r2 = 50
            goto L_0x0367
        L_0x00bd:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.star.StarPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00c7
            goto L_0x0037
        L_0x00c7:
            r2 = 49
            goto L_0x0367
        L_0x00cb:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechPlayBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00d5
            goto L_0x0037
        L_0x00d5:
            r2 = 48
            goto L_0x0367
        L_0x00d9:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00e3
            goto L_0x0037
        L_0x00e3:
            r2 = 47
            goto L_0x0367
        L_0x00e7:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.randomcall.driver.RandomCallPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00f1
            goto L_0x0037
        L_0x00f1:
            r2 = 46
            goto L_0x0367
        L_0x00f5:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00ff
            goto L_0x0037
        L_0x00ff:
            r2 = 45
            goto L_0x0367
        L_0x0103:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketPlayBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x010d
            goto L_0x0037
        L_0x010d:
            r2 = 44
            goto L_0x0367
        L_0x0111:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x011b
            goto L_0x0037
        L_0x011b:
            r2 = 43
            goto L_0x0367
        L_0x011f:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechLivePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0129
            goto L_0x0037
        L_0x0129:
            r2 = 42
            goto L_0x0367
        L_0x012d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.praise.PraisePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0137
            goto L_0x0037
        L_0x0137:
            r2 = 41
            goto L_0x0367
        L_0x013b:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.pageindex.PageIndexPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0145
            goto L_0x0037
        L_0x0145:
            r2 = 40
            goto L_0x0367
        L_0x0149:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.countdown.driver.CountdownPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0153
            goto L_0x0037
        L_0x0153:
            r2 = 39
            goto L_0x0367
        L_0x0157:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.bulletscreen.BulletScreenDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0161
            goto L_0x0037
        L_0x0161:
            r2 = 38
            goto L_0x0367
        L_0x0165:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x016f
            goto L_0x0037
        L_0x016f:
            r2 = 37
            goto L_0x0367
        L_0x0173:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.interactivegames.driver.GameBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x017d
            goto L_0x0037
        L_0x017d:
            r2 = 36
            goto L_0x0367
        L_0x0181:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x018b
            goto L_0x0037
        L_0x018b:
            r2 = 35
            goto L_0x0367
        L_0x018f:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0199
            goto L_0x0037
        L_0x0199:
            r2 = 34
            goto L_0x0367
        L_0x019d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01a7
            goto L_0x0037
        L_0x01a7:
            r2 = 33
            goto L_0x0367
        L_0x01ab:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01b5
            goto L_0x0037
        L_0x01b5:
            r2 = 32
            goto L_0x0367
        L_0x01b9:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01c3
            goto L_0x0037
        L_0x01c3:
            r2 = 31
            goto L_0x0367
        L_0x01c7:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.randomcallnew.RandomCallNewPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01d1
            goto L_0x0037
        L_0x01d1:
            r2 = 30
            goto L_0x0367
        L_0x01d5:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.common.CommonFunctionDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01df
            goto L_0x0037
        L_0x01df:
            r2 = 29
            goto L_0x0367
        L_0x01e3:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01ed
            goto L_0x0037
        L_0x01ed:
            r2 = 28
            goto L_0x0367
        L_0x01f1:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallPlayBackPlugin"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01fb
            goto L_0x0037
        L_0x01fb:
            r2 = 27
            goto L_0x0367
        L_0x01ff:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0209
            goto L_0x0037
        L_0x0209:
            r2 = 26
            goto L_0x0367
        L_0x020d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketLivePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0217
            goto L_0x0037
        L_0x0217:
            r2 = 25
            goto L_0x0367
        L_0x021b:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0225
            goto L_0x0037
        L_0x0225:
            r2 = 24
            goto L_0x0367
        L_0x0229:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.screenshot.ScreenShotPlugDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0233
            goto L_0x0037
        L_0x0233:
            r2 = 23
            goto L_0x0367
        L_0x0237:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0241
            goto L_0x0037
        L_0x0241:
            r2 = 22
            goto L_0x0367
        L_0x0245:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x024f
            goto L_0x0037
        L_0x024f:
            r2 = 21
            goto L_0x0367
        L_0x0253:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.vote.VotePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x025d
            goto L_0x0037
        L_0x025d:
            r2 = 20
            goto L_0x0367
        L_0x0261:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenLivePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x026b
            goto L_0x0037
        L_0x026b:
            r2 = 19
            goto L_0x0367
        L_0x026f:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0279
            goto L_0x0037
        L_0x0279:
            r2 = 18
            goto L_0x0367
        L_0x027d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0287
            goto L_0x0037
        L_0x0287:
            r2 = 17
            goto L_0x0367
        L_0x028b:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0295
            goto L_0x0037
        L_0x0295:
            r2 = 16
            goto L_0x0367
        L_0x0299:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.liveplay.LivePlayPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02a3
            goto L_0x0037
        L_0x02a3:
            r2 = 15
            goto L_0x0367
        L_0x02a7:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.roomdata.RoomDataDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02b1
            goto L_0x0037
        L_0x02b1:
            r2 = 14
            goto L_0x0367
        L_0x02b5:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.interactivegames.driver.GameActivityPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02bf
            goto L_0x0037
        L_0x02bf:
            r2 = 13
            goto L_0x0367
        L_0x02c3:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.audition.AuditionDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02cd
            goto L_0x0037
        L_0x02cd:
            r2 = 12
            goto L_0x0367
        L_0x02d1:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02db
            goto L_0x0037
        L_0x02db:
            r2 = 11
            goto L_0x0367
        L_0x02df:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.chatbox.ChatBoxPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02e9
            goto L_0x0037
        L_0x02e9:
            r2 = 10
            goto L_0x0367
        L_0x02ed:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.liveplayback.LivePlayBackPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02f7
            goto L_0x0037
        L_0x02f7:
            r2 = 9
            goto L_0x0367
        L_0x02fb:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0305
            goto L_0x0037
        L_0x0305:
            r2 = 8
            goto L_0x0367
        L_0x0309:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0313
            goto L_0x0037
        L_0x0313:
            r2 = 7
            goto L_0x0367
        L_0x0315:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.livemessage.PlayBackMsgPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x031f
            goto L_0x0037
        L_0x031f:
            r2 = 6
            goto L_0x0367
        L_0x0321:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.gift.driver.GiftLivePluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x032b
            goto L_0x0037
        L_0x032b:
            r2 = 5
            goto L_0x0367
        L_0x032d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.homework.driver.HomeworkPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0337
            goto L_0x0037
        L_0x0337:
            r2 = 4
            goto L_0x0367
        L_0x0339:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.exam.driver.ExamPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0343
            goto L_0x0037
        L_0x0343:
            r2 = 3
            goto L_0x0367
        L_0x0345:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.sign.SignInPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x034f
            goto L_0x0037
        L_0x034f:
            r2 = 2
            goto L_0x0367
        L_0x0351:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginPlayBackDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x035b
            goto L_0x0037
        L_0x035b:
            r2 = r3
            goto L_0x0367
        L_0x035d:
            java.lang.String r8 = "com.tal.app.thinkacademy.live.business.nps.NpsPluginDriver"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0367
            goto L_0x0037
        L_0x0367:
            switch(r2) {
                case 0: goto L_0x04e9;
                case 1: goto L_0x04e3;
                case 2: goto L_0x04dd;
                case 3: goto L_0x04d7;
                case 4: goto L_0x04d1;
                case 5: goto L_0x04cb;
                case 6: goto L_0x04c5;
                case 7: goto L_0x04bf;
                case 8: goto L_0x04b9;
                case 9: goto L_0x04b3;
                case 10: goto L_0x04ad;
                case 11: goto L_0x04a7;
                case 12: goto L_0x04a1;
                case 13: goto L_0x049b;
                case 14: goto L_0x0495;
                case 15: goto L_0x048f;
                case 16: goto L_0x0489;
                case 17: goto L_0x0483;
                case 18: goto L_0x047d;
                case 19: goto L_0x0477;
                case 20: goto L_0x046f;
                case 21: goto L_0x0469;
                case 22: goto L_0x0463;
                case 23: goto L_0x045d;
                case 24: goto L_0x0457;
                case 25: goto L_0x0451;
                case 26: goto L_0x044b;
                case 27: goto L_0x0445;
                case 28: goto L_0x043f;
                case 29: goto L_0x0439;
                case 30: goto L_0x0433;
                case 31: goto L_0x042d;
                case 32: goto L_0x0427;
                case 33: goto L_0x0421;
                case 34: goto L_0x041b;
                case 35: goto L_0x0415;
                case 36: goto L_0x040e;
                case 37: goto L_0x0407;
                case 38: goto L_0x0400;
                case 39: goto L_0x03f9;
                case 40: goto L_0x03f2;
                case 41: goto L_0x03eb;
                case 42: goto L_0x03e4;
                case 43: goto L_0x03dd;
                case 44: goto L_0x03d6;
                case 45: goto L_0x03cf;
                case 46: goto L_0x03c8;
                case 47: goto L_0x03c1;
                case 48: goto L_0x03ba;
                case 49: goto L_0x03b3;
                case 50: goto L_0x03ac;
                case 51: goto L_0x03a5;
                case 52: goto L_0x039e;
                case 53: goto L_0x0397;
                case 54: goto L_0x0390;
                case 55: goto L_0x0389;
                case 56: goto L_0x0382;
                case 57: goto L_0x037b;
                case 58: goto L_0x0374;
                case 59: goto L_0x036d;
                default: goto L_0x036a;
            }
        L_0x036a:
            r6 = 0
            goto L_0x04ef
        L_0x036d:
            com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver r7 = new com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0374:
            com.tal.app.thinkacademy.live.business.coin.CoinCenterDriver r7 = new com.tal.app.thinkacademy.live.business.coin.CoinCenterDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x037b:
            com.tal.app.thinkacademy.live.business.keyboardfill.KeyboardFillDriver r7 = new com.tal.app.thinkacademy.live.business.keyboardfill.KeyboardFillDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0382:
            com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallLivePlugin r7 = new com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallLivePlugin
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0389:
            com.tal.app.thinkacademy.live.business.parentaudit.ParentAuditDriver r7 = new com.tal.app.thinkacademy.live.business.parentaudit.ParentAuditDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0390:
            com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver r7 = new com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0397:
            com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver r7 = new com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x039e:
            com.tal.app.thinkacademy.live.business.voice.VoicePluginDriver r7 = new com.tal.app.thinkacademy.live.business.voice.VoicePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03a5:
            com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatBackDriver r7 = new com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatBackDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03ac:
            com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver r7 = new com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03b3:
            com.tal.app.thinkacademy.live.business.star.StarPluginDriver r7 = new com.tal.app.thinkacademy.live.business.star.StarPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03ba:
            com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechPlayBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechPlayBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03c1:
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver r7 = new com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03c8:
            com.tal.app.thinkacademy.live.business.randomcall.driver.RandomCallPluginDriver r7 = new com.tal.app.thinkacademy.live.business.randomcall.driver.RandomCallPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03cf:
            com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver r7 = new com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03d6:
            com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketPlayBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketPlayBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03dd:
            com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatDriver r7 = new com.tal.app.thinkacademy.live.business.heartbeat.UserHeartbeatDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03e4:
            com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechLivePluginDriver r7 = new com.tal.app.thinkacademy.live.business.collectivespeech.driver.SpeechLivePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03eb:
            com.tal.app.thinkacademy.live.business.praise.PraisePluginDriver r7 = new com.tal.app.thinkacademy.live.business.praise.PraisePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03f2:
            com.tal.app.thinkacademy.live.business.pageindex.PageIndexPluginDriver r7 = new com.tal.app.thinkacademy.live.business.pageindex.PageIndexPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x03f9:
            com.tal.app.thinkacademy.live.business.countdown.driver.CountdownPluginDriver r7 = new com.tal.app.thinkacademy.live.business.countdown.driver.CountdownPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0400:
            com.tal.app.thinkacademy.live.business.bulletscreen.BulletScreenDriver r7 = new com.tal.app.thinkacademy.live.business.bulletscreen.BulletScreenDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0407:
            com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver r7 = new com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x040e:
            com.tal.app.thinkacademy.live.business.interactivegames.driver.GameBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.interactivegames.driver.GameBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0415:
            com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver r7 = new com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x041b:
            com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver r7 = new com.tal.app.thinkacademy.live.business.videocall.driver.TutorVideoCallDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0421:
            com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver r7 = new com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0427:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x042d:
            com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver r7 = new com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0433:
            com.tal.app.thinkacademy.live.business.randomcallnew.RandomCallNewPluginDriver r7 = new com.tal.app.thinkacademy.live.business.randomcallnew.RandomCallNewPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0439:
            com.tal.app.thinkacademy.live.business.common.CommonFunctionDriver r7 = new com.tal.app.thinkacademy.live.business.common.CommonFunctionDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x043f:
            com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPluginDriver r7 = new com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0445:
            com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallPlayBackPlugin r7 = new com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosOnTheWallPlayBackPlugin
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x044b:
            com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver r7 = new com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0451:
            com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketLivePluginDriver r7 = new com.tal.app.thinkacademy.live.business.redpackage.driver.RedPacketLivePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0457:
            com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver r7 = new com.tal.app.thinkacademy.live.business.schulte.SchulteTablePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x045d:
            com.tal.app.thinkacademy.live.business.screenshot.ScreenShotPlugDriver r7 = new com.tal.app.thinkacademy.live.business.screenshot.ScreenShotPlugDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0463:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackDriver r7 = new com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0469:
            com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver r7 = new com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x046f:
            com.tal.app.thinkacademy.live.business.vote.VotePluginDriver r7 = new com.tal.app.thinkacademy.live.business.vote.VotePluginDriver
            r7.<init>(r6, r1)
        L_0x0474:
            r6 = r7
            goto L_0x04ef
        L_0x0477:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenLivePluginDriver r7 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.CanvasTripleScreenLivePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x047d:
            com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.exercise.ExerciseBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0483:
            com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver r7 = new com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0489:
            com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver r7 = new com.tal.app.thinkacademy.live.business.exercise.ExercisePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x048f:
            com.tal.app.thinkacademy.live.business.liveplay.LivePlayPluginDriver r7 = new com.tal.app.thinkacademy.live.business.liveplay.LivePlayPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x0495:
            com.tal.app.thinkacademy.live.business.roomdata.RoomDataDriver r7 = new com.tal.app.thinkacademy.live.business.roomdata.RoomDataDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x049b:
            com.tal.app.thinkacademy.live.business.interactivegames.driver.GameActivityPluginDriver r7 = new com.tal.app.thinkacademy.live.business.interactivegames.driver.GameActivityPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04a1:
            com.tal.app.thinkacademy.live.business.audition.AuditionDriver r7 = new com.tal.app.thinkacademy.live.business.audition.AuditionDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04a7:
            com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver r7 = new com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlLiveDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04ad:
            com.tal.app.thinkacademy.live.business.chatbox.ChatBoxPluginDriver r7 = new com.tal.app.thinkacademy.live.business.chatbox.ChatBoxPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04b3:
            com.tal.app.thinkacademy.live.business.liveplayback.LivePlayBackPluginDriver r7 = new com.tal.app.thinkacademy.live.business.liveplayback.LivePlayBackPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04b9:
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r7 = new com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04bf:
            com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver r7 = new com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04c5:
            com.tal.app.thinkacademy.live.business.livemessage.PlayBackMsgPluginDriver r7 = new com.tal.app.thinkacademy.live.business.livemessage.PlayBackMsgPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04cb:
            com.tal.app.thinkacademy.live.business.gift.driver.GiftLivePluginDriver r7 = new com.tal.app.thinkacademy.live.business.gift.driver.GiftLivePluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04d1:
            com.tal.app.thinkacademy.live.business.homework.driver.HomeworkPluginDriver r7 = new com.tal.app.thinkacademy.live.business.homework.driver.HomeworkPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04d7:
            com.tal.app.thinkacademy.live.business.exam.driver.ExamPluginDriver r7 = new com.tal.app.thinkacademy.live.business.exam.driver.ExamPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04dd:
            com.tal.app.thinkacademy.live.business.sign.SignInPluginDriver r7 = new com.tal.app.thinkacademy.live.business.sign.SignInPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04e3:
            com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginPlayBackDriver r7 = new com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginPlayBackDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04e9:
            com.tal.app.thinkacademy.live.business.nps.NpsPluginDriver r7 = new com.tal.app.thinkacademy.live.business.nps.NpsPluginDriver
            r7.<init>(r6, r1)
            goto L_0x0474
        L_0x04ef:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.core.plugin.PluginClassWarehouse.loadPlugin(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData, java.lang.String):com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver");
    }
}
