package com.tal.app.thinkacademy.live.business.homework.driver;

import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0019\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;", "", "closeHomeworkDetail", "", "resubmitDraw", "item", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "resubmitPhoto", "showHomeworkDetail", "source", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "canCorrect", "", "syncCoins", "addCoins", "", "(Ljava/lang/Integer;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPhotoBoxPlugin.kt */
public interface IPhotoBoxPlugin {
    void closeHomeworkDetail();

    void resubmitDraw(HomeworkEntity homeworkEntity);

    void resubmitPhoto(HomeworkEntity homeworkEntity);

    void showHomeworkDetail(DetailSource detailSource, HomeworkEntity homeworkEntity, boolean z);

    void syncCoins(Integer num);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IPhotoBoxPlugin.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void syncCoins$default(IPhotoBoxPlugin iPhotoBoxPlugin, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = null;
                }
                iPhotoBoxPlugin.syncCoins(num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncCoins");
        }
    }
}
