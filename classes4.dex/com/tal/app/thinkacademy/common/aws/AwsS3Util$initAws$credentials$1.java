package com.tal.app.thinkacademy.common.aws;

import com.amazonaws.auth.AWSSessionCredentials;
import com.tal.app.thinkacademy.common.entity.STSToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/aws/AwsS3Util$initAws$credentials$1", "Lcom/amazonaws/auth/AWSSessionCredentials;", "getAWSAccessKeyId", "", "getAWSSecretKey", "getSessionToken", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AwsS3Util.kt */
public final class AwsS3Util$initAws$credentials$1 implements AWSSessionCredentials {
    final /* synthetic */ STSToken $info;

    AwsS3Util$initAws$credentials$1(STSToken sTSToken) {
        this.$info = sTSToken;
    }

    public String getSessionToken() {
        STSToken sTSToken = this.$info;
        String sessionToken = sTSToken == null ? null : sTSToken.getSessionToken();
        Intrinsics.checkNotNull(sessionToken);
        return sessionToken;
    }

    public String getAWSAccessKeyId() {
        STSToken sTSToken = this.$info;
        String accessKey = sTSToken == null ? null : sTSToken.getAccessKey();
        Intrinsics.checkNotNull(accessKey);
        return accessKey;
    }

    public String getAWSSecretKey() {
        STSToken sTSToken = this.$info;
        String accessSecret = sTSToken == null ? null : sTSToken.getAccessSecret();
        Intrinsics.checkNotNull(accessSecret);
        return accessSecret;
    }
}
