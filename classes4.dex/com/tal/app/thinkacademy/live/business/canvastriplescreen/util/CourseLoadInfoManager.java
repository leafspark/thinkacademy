package com.tal.app.thinkacademy.live.business.canvastriplescreen.util;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.utils.AppGlobals;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.CourseLoadInfoEntity;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request.CoursePreloadRequest;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

public class CourseLoadInfoManager {
    private static CourseLoadInfoManager instance;
    /* access modifiers changed from: private */
    public volatile List<CourseLoadInfoEntity> infoEntityList = new ArrayList();

    private CourseLoadInfoManager() {
    }

    public static CourseLoadInfoManager getInstance() {
        if (instance == null) {
            synchronized (CourseLoadInfoManager.class) {
                if (instance == null) {
                    instance = new CourseLoadInfoManager();
                }
            }
        }
        return instance;
    }

    public synchronized void preLoadInfo(String str, String str2) {
        AppGlobals.INSTANCE.get();
        this.infoEntityList.clear();
        Call<HiResponse<JSONObject>> coursePreload = ((CanvasApi) Api.create(CanvasApi.class)).getCoursePreload(CanvasApi.preloadUrl, new CoursePreloadRequest(Integer.parseInt(str), Integer.parseInt(str2)));
        AnonymousClass2 r5 = new OmyCallback<HiResponse<JSONObject>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<JSONObject> hiResponse) {
                try {
                    JSONObject jSONObject = null;
                    JSONArray jSONArray = hiResponse.getData().getJSONArray("lists");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        jSONObject = jSONArray.getJSONObject(i);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("ipadResources");
                    int length2 = optJSONArray != null ? optJSONArray.length() : 0;
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("thumbnailPath");
                            String optString2 = optJSONObject.optString("pageId");
                            String optString3 = optJSONObject.optString("packageId");
                            CourseLoadInfoEntity courseLoadInfoEntity = new CourseLoadInfoEntity();
                            courseLoadInfoEntity.packageId = optString3;
                            courseLoadInfoEntity.pageId = optString2;
                            courseLoadInfoEntity.thumbnailPath = optString;
                            CourseLoadInfoManager.this.infoEntityList.add(courseLoadInfoEntity);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        if (!(coursePreload instanceof Call)) {
            coursePreload.enqueue(r5);
        } else {
            Retrofit2Instrumentation.enqueue((Call) coursePreload, r5);
        }
    }

    public synchronized List<CourseLoadInfoEntity> getInClassIpadPicList() {
        return this.infoEntityList;
    }
}
