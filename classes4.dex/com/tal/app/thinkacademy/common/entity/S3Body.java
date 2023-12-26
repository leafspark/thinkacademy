package com.tal.app.thinkacademy.common.entity;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ,\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/S3Body;", "", "scene", "", "filePaths", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getFilePaths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/entity/S3Body;", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: S3Body.kt */
public final class S3Body {
    private final String[] filePaths;
    private final String scene;

    public static /* synthetic */ S3Body copy$default(S3Body s3Body, String str, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3Body.scene;
        }
        if ((i & 2) != 0) {
            strArr = s3Body.filePaths;
        }
        return s3Body.copy(str, strArr);
    }

    public final String component1() {
        return this.scene;
    }

    public final String[] component2() {
        return this.filePaths;
    }

    public final S3Body copy(String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "filePaths");
        return new S3Body(str, strArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S3Body)) {
            return false;
        }
        S3Body s3Body = (S3Body) obj;
        return Intrinsics.areEqual(this.scene, s3Body.scene) && Intrinsics.areEqual(this.filePaths, s3Body.filePaths);
    }

    public int hashCode() {
        String str = this.scene;
        return ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.filePaths);
    }

    public String toString() {
        return "S3Body(scene=" + this.scene + ", filePaths=" + Arrays.toString(this.filePaths) + ')';
    }

    public S3Body(String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "filePaths");
        this.scene = str;
        this.filePaths = strArr;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String[] getFilePaths() {
        return this.filePaths;
    }
}
