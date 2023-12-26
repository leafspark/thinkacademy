package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ComonPackageInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/imconfig/ImConfig$getConfigInfo$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo;", "onSuccess", "", "response", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImConfig.kt */
public final class ImConfig$getConfigInfo$1 extends OmyCallback<HiResponse<ConfigInfo>> {
    ImConfig$getConfigInfo$1(ImConfig$getConfigInfo$2 imConfig$getConfigInfo$2) {
        super(imConfig$getConfigInfo$2);
    }

    public void onSuccess(HiResponse<ConfigInfo> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        if (hiResponse.getData() != null) {
            ShareDataManager instance = ShareDataManager.getInstance();
            ConfigInfo data = hiResponse.getData();
            Intrinsics.checkNotNull(data);
            instance.saveCacheGsonEntity(data.getInternational(), ShareDataKey.CONFIG_INFO, ShareDataManager.SHAREDATA_NOT_CLEAR);
            ShareDataManager instance2 = ShareDataManager.getInstance();
            ConfigInfo data2 = hiResponse.getData();
            Intrinsics.checkNotNull(data2);
            instance2.saveCacheGsonEntity(data2.getCampusRoute(), ShareDataKey.CAMPUS_ROUTE, ShareDataManager.SHAREDATA_NOT_CLEAR);
            ConfigInfo data3 = hiResponse.getData();
            if (data3 != null) {
                UserInfoBll.Companion.getInstance().setShoppingMallReviewed(data3.getShopAvailable());
            }
            ConfigInfo data4 = hiResponse.getData();
            Intrinsics.checkNotNull(data4);
            Collection courseWarePackages = data4.getCourseWarePackages();
            if (!(courseWarePackages == null || courseWarePackages.isEmpty())) {
                ConfigInfo data5 = hiResponse.getData();
                Intrinsics.checkNotNull(data5);
                int size = data5.getCourseWarePackages().size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    int i2 = i + 1;
                    ConfigInfo data6 = hiResponse.getData();
                    Intrinsics.checkNotNull(data6);
                    if (data6.getCourseWarePackages().get(i).getType() == 2) {
                        ShareDataManager instance3 = ShareDataManager.getInstance();
                        ConfigInfo data7 = hiResponse.getData();
                        Intrinsics.checkNotNull(data7);
                        instance3.saveCacheGsonEntity(data7.getCourseWarePackages().get(i), ShareDataKey.COMMON_COURSE_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
                        ShareDataManager instance4 = ShareDataManager.getInstance();
                        ConfigInfo data8 = hiResponse.getData();
                        Intrinsics.checkNotNull(data8);
                        instance4.saveCacheGsonEntity(data8.getH5BridgePackages().get(0), ShareDataKey.COMMON_DIST_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
                        ConfigInfo data9 = hiResponse.getData();
                        Intrinsics.checkNotNull(data9);
                        String url = data9.getCourseWarePackages().get(i).getUrl();
                        ConfigInfo data10 = hiResponse.getData();
                        Intrinsics.checkNotNull(data10);
                        String zipMd5 = data10.getCourseWarePackages().get(i).getZipMd5();
                        ConfigInfo data11 = hiResponse.getData();
                        Intrinsics.checkNotNull(data11);
                        String url2 = data11.getH5BridgePackages().get(0).getUrl();
                        ConfigInfo data12 = hiResponse.getData();
                        Intrinsics.checkNotNull(data12);
                        ShareDataManager.getInstance().saveCacheGsonEntity(new ComonPackageInfo.CommonInfo(url, zipMd5, url2, data12.getH5BridgePackages().get(0).getZipMd5()), ShareDataKey.COMMON_INFO_PACKAGE, ShareDataManager.SHAREDATA_NOT_CLEAR);
                        ImConfig imConfig = ImConfig.INSTANCE;
                        ConfigInfo data13 = hiResponse.getData();
                        Intrinsics.checkNotNull(data13);
                        String url3 = data13.getCourseWarePackages().get(i).getUrl();
                        ConfigInfo data14 = hiResponse.getData();
                        Intrinsics.checkNotNull(data14);
                        String zipMd52 = data14.getCourseWarePackages().get(i).getZipMd5();
                        ConfigInfo data15 = hiResponse.getData();
                        Intrinsics.checkNotNull(data15);
                        imConfig.commonPackage(url3, zipMd52, data15.getCourseWarePackages().get(i).getUrlSpareList());
                        List arrayList = new ArrayList();
                        ConfigInfo data16 = hiResponse.getData();
                        Intrinsics.checkNotNull(data16);
                        arrayList.add(data16.getH5BridgePackages().get(0).getUrl());
                        ImConfig imConfig2 = ImConfig.INSTANCE;
                        ConfigInfo data17 = hiResponse.getData();
                        Intrinsics.checkNotNull(data17);
                        String url4 = data17.getH5BridgePackages().get(0).getUrl();
                        ConfigInfo data18 = hiResponse.getData();
                        Intrinsics.checkNotNull(data18);
                        imConfig2.commonPackage(url4, data18.getH5BridgePackages().get(0).getZipMd5(), arrayList);
                        break;
                    }
                    i = i2;
                }
            }
            ShareDataManager instance5 = ShareDataManager.getInstance();
            ConfigInfo data19 = hiResponse.getData();
            Intrinsics.checkNotNull(data19);
            instance5.saveCacheGsonEntity(data19.getTeacher(), ShareDataKey.CONFIG_TEACHER_DESC, ShareDataManager.SHAREDATA_NOT_CLEAR);
            ImConfig imConfig3 = ImConfig.INSTANCE;
            ConfigInfo data20 = hiResponse.getData();
            Intrinsics.checkNotNull(data20);
            imConfig3.setCurrencyDescMap(data20.getCurrency());
            ImConfig imConfig4 = ImConfig.INSTANCE;
            ConfigInfo data21 = hiResponse.getData();
            Intrinsics.checkNotNull(data21);
            imConfig4.setH5MallHost(data21.getH5MallUrl());
            ImConfig imConfig5 = ImConfig.INSTANCE;
            ConfigInfo data22 = hiResponse.getData();
            Intrinsics.checkNotNull(data22);
            imConfig5.setSchoolMap(data22.getSchoolsV2());
            ImConfig imConfig6 = ImConfig.INSTANCE;
            ConfigInfo data23 = hiResponse.getData();
            Intrinsics.checkNotNull(data23);
            imConfig6.setTeacherV2Map(data23.getTeacherV2());
            ImConfig imConfig7 = ImConfig.INSTANCE;
            ConfigInfo data24 = hiResponse.getData();
            Intrinsics.checkNotNull(data24);
            imConfig7.setTimeZoneV2Map(data24.getTimezoneV2());
            ImConfig imConfig8 = ImConfig.INSTANCE;
            ConfigInfo data25 = hiResponse.getData();
            Intrinsics.checkNotNull(data25);
            imConfig8.setTimeZoneSwitchSchool(data25.getTimeZoneSwitchSchool());
        }
    }
}
