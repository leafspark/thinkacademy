package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager;

import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import java.util.List;
import java.util.Map;

public interface ExPressionEditDataInter {
    List<ExpressionAllInfoEntity> getExpressionAllList();

    Map<Integer, ExpressionAllInfoEntity> getExpressionAllMap();
}
