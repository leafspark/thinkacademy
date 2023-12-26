package com.tal.app.thinkacademy.common.widget;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPagImage;", "Lorg/libpag/PAGImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMediaPlayer", "Landroid/media/MediaPlayer;", "initView", "", "pause", "playSound", "path", "", "pagFile", "Lorg/libpag/PAGFile;", "playWithSound", "ByteBufferDataSource", "PagAnimatorListener", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwPagImage.kt */
public final class HwPagImage extends PAGImageView {
    private MediaPlayer mMediaPlayer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPagImage$PagAnimatorListener;", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGImageView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwPagImage.kt */
    public interface PagAnimatorListener extends PAGImageView.PAGImageViewListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: HwPagImage.kt */
        public static final class DefaultImpls {
            public static void onAnimationCancel(PagAnimatorListener pagAnimatorListener, PAGImageView pAGImageView) {
                Intrinsics.checkNotNullParameter(pagAnimatorListener, "this");
            }

            public static void onAnimationEnd(PagAnimatorListener pagAnimatorListener, PAGImageView pAGImageView) {
                Intrinsics.checkNotNullParameter(pagAnimatorListener, "this");
            }

            public static void onAnimationRepeat(PagAnimatorListener pagAnimatorListener, PAGImageView pAGImageView) {
                Intrinsics.checkNotNullParameter(pagAnimatorListener, "this");
            }

            public static void onAnimationStart(PagAnimatorListener pagAnimatorListener, PAGImageView pAGImageView) {
                Intrinsics.checkNotNullParameter(pagAnimatorListener, "this");
            }

            public static void onAnimationUpdate(PagAnimatorListener pagAnimatorListener, PAGImageView pAGImageView) {
                Intrinsics.checkNotNullParameter(pagAnimatorListener, "this");
            }
        }

        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    private final void initView() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwPagImage(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwPagImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwPagImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        initView();
    }

    public final void playWithSound(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        PAGComposition Load = PAGFile.Load(getContext().getAssets(), str);
        setComposition(Load);
        play();
        Intrinsics.checkNotNullExpressionValue(Load, "pagFile");
        playSound((PAGFile) Load);
    }

    public final void playSound(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        PAGFile Load = PAGFile.Load(getContext().getAssets(), str);
        Intrinsics.checkNotNullExpressionValue(Load, "pagFile");
        playSound(Load);
    }

    private final void playSound(PAGFile pAGFile) {
        ByteBuffer audioBytes = pAGFile.audioBytes();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        try {
            Intrinsics.checkNotNullExpressionValue(audioBytes, "audioBuffer");
            ByteBufferDataSource byteBufferDataSource = new ByteBufferDataSource(this, audioBytes);
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setDataSource(byteBufferDataSource);
            }
            MediaPlayer mediaPlayer3 = this.mMediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.prepare();
            }
            MediaPlayer mediaPlayer4 = this.mMediaPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.start();
            }
        } catch (IOException e) {
            Log.e("PAG", "音频播放失败", e);
        }
    }

    public void pause() {
        HwPagImage.super.pause();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPagImage$ByteBufferDataSource;", "Landroid/media/MediaDataSource;", "buffer", "Ljava/nio/ByteBuffer;", "(Lcom/tal/app/thinkacademy/common/widget/HwPagImage;Ljava/nio/ByteBuffer;)V", "close", "", "getSize", "", "readAt", "", "position", "", "offset", "size", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwPagImage.kt */
    private final class ByteBufferDataSource extends MediaDataSource {
        private final ByteBuffer buffer;
        final /* synthetic */ HwPagImage this$0;

        public void close() throws IOException {
        }

        public ByteBufferDataSource(HwPagImage hwPagImage, ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(hwPagImage, "this$0");
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
            this.this$0 = hwPagImage;
            this.buffer = byteBuffer;
        }

        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            this.buffer.position((int) j);
            int min = Math.min(this.buffer.remaining(), i2);
            if (min > 0) {
                this.buffer.get(bArr, i, min);
            }
            return min;
        }

        public long getSize() throws IOException {
            return (long) this.buffer.capacity();
        }
    }
}
