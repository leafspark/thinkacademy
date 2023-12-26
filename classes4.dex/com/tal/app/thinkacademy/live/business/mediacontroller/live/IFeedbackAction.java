package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import org.json.JSONObject;

public interface IFeedbackAction {
    void dismissPopup();

    void feedbackScreenshot();

    void sendFeedbackInfo(JSONObject jSONObject);
}
