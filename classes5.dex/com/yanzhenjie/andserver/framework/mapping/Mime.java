package com.yanzhenjie.andserver.framework.mapping;

import com.yanzhenjie.andserver.util.MediaType;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Mime {
    private List<Rule> mRuleList = new LinkedList();

    public List<Rule> getRuleList() {
        return this.mRuleList;
    }

    public void addRule(String str) {
        MediaType valueOf = MediaType.valueOf(str);
        this.mRuleList.add(new Rule(valueOf.getType(), valueOf.getSubtype(), valueOf.getParameters()));
    }

    public static class Rule extends MediaType {
        public Rule(String str, String str2, Map<String, String> map) {
            super(str, str2, map);
        }
    }
}
