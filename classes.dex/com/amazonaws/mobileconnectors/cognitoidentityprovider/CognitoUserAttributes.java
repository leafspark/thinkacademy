package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CognitoUserAttributes {
    private Map<String, String> userAttributes;

    public CognitoUserAttributes() {
        this((List<AttributeType>) null);
    }

    protected CognitoUserAttributes(List<AttributeType> list) {
        this.userAttributes = new HashMap();
        if (list != null) {
            for (AttributeType next : list) {
                this.userAttributes.put(next.getName(), next.getValue());
            }
        }
    }

    public void addAttribute(String str, String str2) {
        this.userAttributes.put(str, str2);
    }

    public Map<String, String> getAttributes() {
        return this.userAttributes;
    }

    /* access modifiers changed from: protected */
    public List<AttributeType> getAttributesList() {
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = this.userAttributes;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                AttributeType attributeType = new AttributeType();
                attributeType.setName((String) next.getKey());
                attributeType.setValue((String) next.getValue());
                arrayList.add(attributeType);
            }
        }
        return arrayList;
    }
}
