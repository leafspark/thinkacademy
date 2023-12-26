package com.tal.app.thinkacademy.live.business.topic.view;

import android.content.Context;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;

public class QuestionFactory {
    public static IQuestion createQuestionView(Context context, String str, ISelected iSelected) {
        if ("1".equals(str)) {
            return new SingleChoice(context, iSelected);
        }
        if ("2".equals(str)) {
            return new MultipleChoice(context, iSelected);
        }
        if (TopicConfig.OPTIONS_TRUEFALSE_TYPE.equals(str)) {
            return new TrueOrFalseQuestion(context, iSelected);
        }
        return null;
    }
}
