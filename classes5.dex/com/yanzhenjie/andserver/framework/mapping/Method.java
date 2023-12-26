package com.yanzhenjie.andserver.framework.mapping;

import com.yanzhenjie.andserver.http.HttpMethod;
import java.util.LinkedList;
import java.util.List;

public class Method {
    private List<HttpMethod> mRuleList = new LinkedList();

    public List<HttpMethod> getRuleList() {
        return this.mRuleList;
    }

    public void addRule(String str) {
        this.mRuleList.add(HttpMethod.reverse(str));
    }
}
