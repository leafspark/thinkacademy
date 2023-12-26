package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import com.amazonaws.services.cognitoidentityprovider.model.MFAOptionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CognitoUserSettings {
    private Map<String, String> userSettings;

    public CognitoUserSettings() {
        this((List<MFAOptionType>) null);
    }

    protected CognitoUserSettings(List<MFAOptionType> list) {
        this.userSettings = new HashMap();
        if (list != null) {
            for (MFAOptionType next : list) {
                this.userSettings.put(next.getAttributeName().toString(), next.getDeliveryMedium().toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<MFAOptionType> getSettingsList() {
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = this.userSettings;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                MFAOptionType mFAOptionType = new MFAOptionType();
                mFAOptionType.setAttributeName((String) next.getKey());
                mFAOptionType.setDeliveryMedium((String) next.getValue());
                arrayList.add(mFAOptionType);
            }
        }
        return arrayList;
    }

    public Map<String, String> getSettings() {
        return this.userSettings;
    }

    public void setSettings(String str, String str2) {
        this.userSettings.put(str, str2);
    }
}
