package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.event;

public class ExpressionEvent {

    public static class SendExpressionEvent extends ExpressionEvent {
        public int bottomId;
        public String expressionId;

        public SendExpressionEvent(String str, int i) {
            this.expressionId = str;
            this.bottomId = i;
        }
    }
}
