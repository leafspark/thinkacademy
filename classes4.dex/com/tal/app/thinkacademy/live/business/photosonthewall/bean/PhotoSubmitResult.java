package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosUploadResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "", "userLatestCoin", "", "rightCoin", "isCorrection", "", "photoSubmissionResult", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;", "(IILjava/lang/Boolean;Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;)V", "()Ljava/lang/Boolean;", "setCorrection", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPhotoSubmissionResult", "()Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;", "setPhotoSubmissionResult", "(Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;)V", "getRightCoin", "()I", "getUserLatestCoin", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Boolean;Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;)Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "equals", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoSubmitResult.kt */
public final class PhotoSubmitResult {
    private Boolean isCorrection;
    private PhotosUploadResult photoSubmissionResult;
    private final int rightCoin;
    private final int userLatestCoin;

    public static /* synthetic */ PhotoSubmitResult copy$default(PhotoSubmitResult photoSubmitResult, int i, int i2, Boolean bool, PhotosUploadResult photosUploadResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = photoSubmitResult.userLatestCoin;
        }
        if ((i3 & 2) != 0) {
            i2 = photoSubmitResult.rightCoin;
        }
        if ((i3 & 4) != 0) {
            bool = photoSubmitResult.isCorrection;
        }
        if ((i3 & 8) != 0) {
            photosUploadResult = photoSubmitResult.photoSubmissionResult;
        }
        return photoSubmitResult.copy(i, i2, bool, photosUploadResult);
    }

    public final int component1() {
        return this.userLatestCoin;
    }

    public final int component2() {
        return this.rightCoin;
    }

    public final Boolean component3() {
        return this.isCorrection;
    }

    public final PhotosUploadResult component4() {
        return this.photoSubmissionResult;
    }

    public final PhotoSubmitResult copy(int i, int i2, Boolean bool, PhotosUploadResult photosUploadResult) {
        return new PhotoSubmitResult(i, i2, bool, photosUploadResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoSubmitResult)) {
            return false;
        }
        PhotoSubmitResult photoSubmitResult = (PhotoSubmitResult) obj;
        return this.userLatestCoin == photoSubmitResult.userLatestCoin && this.rightCoin == photoSubmitResult.rightCoin && Intrinsics.areEqual(this.isCorrection, photoSubmitResult.isCorrection) && this.photoSubmissionResult == photoSubmitResult.photoSubmissionResult;
    }

    public int hashCode() {
        int i = ((this.userLatestCoin * 31) + this.rightCoin) * 31;
        Boolean bool = this.isCorrection;
        int i2 = 0;
        int hashCode = (i + (bool == null ? 0 : bool.hashCode())) * 31;
        PhotosUploadResult photosUploadResult = this.photoSubmissionResult;
        if (photosUploadResult != null) {
            i2 = photosUploadResult.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "PhotoSubmitResult(userLatestCoin=" + this.userLatestCoin + ", rightCoin=" + this.rightCoin + ", isCorrection=" + this.isCorrection + ", photoSubmissionResult=" + this.photoSubmissionResult + ')';
    }

    public PhotoSubmitResult(int i, int i2, Boolean bool, PhotosUploadResult photosUploadResult) {
        this.userLatestCoin = i;
        this.rightCoin = i2;
        this.isCorrection = bool;
        this.photoSubmissionResult = photosUploadResult;
    }

    public final int getUserLatestCoin() {
        return this.userLatestCoin;
    }

    public final int getRightCoin() {
        return this.rightCoin;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoSubmitResult(int i, int i2, Boolean bool, PhotosUploadResult photosUploadResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : bool, photosUploadResult);
    }

    public final Boolean isCorrection() {
        return this.isCorrection;
    }

    public final void setCorrection(Boolean bool) {
        this.isCorrection = bool;
    }

    public final PhotosUploadResult getPhotoSubmissionResult() {
        return this.photoSubmissionResult;
    }

    public final void setPhotoSubmissionResult(PhotosUploadResult photosUploadResult) {
        this.photoSubmissionResult = photosUploadResult;
    }
}
