package com.tal.app.thinkacademy.live.business.topic;

import com.tal.app.thinkacademy.live.business.topic.bean.InteractBean;
import java.util.List;

public interface IActionListenter {
    void removePlugin(int i);

    void requestTopicStatus(InteractBean interactBean);

    void submitAnswer(List<List<String>> list, int i, boolean z);
}
