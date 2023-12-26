package com.tal.app.thinkacademy.common.aws;

import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.live.business.GoldSource;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J/\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ;\u0010\u0010\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/UploadFileTrackUtil;", "", "()V", "getFileSize", "", "fileSize", "", "getUploadFileScene", "", "uploadFileScene", "trackFailEvent", "", "uploadFileType", "Lcom/tal/app/thinkacademy/common/aws/UploadFileType;", "errorMsg", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/common/aws/UploadFileType;Ljava/lang/Long;Ljava/lang/String;)V", "trackSuccessEvent", "duration", "url", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/common/aws/UploadFileType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UploadFileTrackUtil.kt */
public final class UploadFileTrackUtil {
    public static final UploadFileTrackUtil INSTANCE = new UploadFileTrackUtil();

    private UploadFileTrackUtil() {
    }

    public final void trackSuccessEvent(String str, UploadFileType uploadFileType, Long l, Long l2, String str2) {
        Intrinsics.checkNotNullParameter(uploadFileType, "uploadFileType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "success");
            jSONObject.put("use_scene", getUploadFileScene(str));
            jSONObject.put("type", uploadFileType.getValue());
            if (l != null) {
                jSONObject.put("file_size", INSTANCE.getFileSize(l.longValue()));
            }
            if (l2 != null) {
                jSONObject.put("duration", l2.longValue());
            }
            if (str2 != null) {
                jSONObject.put("url", str2);
            }
            HwTrackUtil.INSTANCE.track("hw_upload_file", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trackFailEvent(String str, UploadFileType uploadFileType, Long l, String str2) {
        Intrinsics.checkNotNullParameter(str, "uploadFileScene");
        Intrinsics.checkNotNullParameter(uploadFileType, "uploadFileType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "fail");
            jSONObject.put("use_scene", getUploadFileScene(str));
            jSONObject.put("type", uploadFileType.getValue());
            if (l != null) {
                jSONObject.put("file_size", INSTANCE.getFileSize(l.longValue()));
            }
            if (str2 != null) {
                jSONObject.put("error_msg", str2);
            }
            HwTrackUtil.INSTANCE.track("hw_upload_file", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final double getFileSize(long j) {
        try {
            BigDecimal divide = BigDecimal.valueOf(j).divide(BigDecimal.valueOf(1048576), 3, 4);
            if (divide.doubleValue() <= 0.0d) {
                divide = BigDecimal.ZERO;
            }
            return divide.doubleValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0d;
        }
    }

    private final String getUploadFileScene(String str) {
        String str2;
        if (str == null) {
            return "未知";
        }
        switch (str.hashCode()) {
            case -1636853907:
                if (str.equals(AwsS3Util.scene_interaction)) {
                    str2 = "互动作答";
                    break;
                } else {
                    return "未知";
                }
            case -1405959847:
                if (str.equals(AwsS3Util.scene_avatar)) {
                    str2 = "头像";
                    break;
                } else {
                    return "未知";
                }
            case -1272531992:
                if (str.equals(AwsS3Util.scene_picture_wall)) {
                    str2 = GoldSource.PHOTOS_ON_THE_WALL_GOLD;
                    break;
                } else {
                    return "未知";
                }
            case -485149584:
                if (str.equals(AwsS3Util.scene_homework)) {
                    str2 = "作业";
                    break;
                } else {
                    return "未知";
                }
            case -191501435:
                if (str.equals(AwsS3Util.scene_feedback)) {
                    str2 = "问题反馈";
                    break;
                } else {
                    return "未知";
                }
            case 342105100:
                if (str.equals(AwsS3Util.scene_logan)) {
                    str2 = "日志上传";
                    break;
                } else {
                    return "未知";
                }
            case 913375517:
                if (str.equals(AwsS3Util.scene_class_feedback)) {
                    str2 = "课中反馈";
                    break;
                } else {
                    return "未知";
                }
            case 2083609127:
                if (str.equals(AwsS3Util.scene_agoralog)) {
                    str2 = "声网日志";
                    break;
                } else {
                    return "未知";
                }
            default:
                return "未知";
        }
        return str2;
    }
}
