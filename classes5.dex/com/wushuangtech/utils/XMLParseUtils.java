package com.wushuangtech.utils;

import android.text.TextUtils;
import android.util.Xml;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.UserDeviceConfig;
import java.io.StringReader;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;

public class XMLParseUtils {
    private static final String TAG = "XMLParseUtils";

    public static boolean parseDeviceDualStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.w(TAG, "parseDeviceDualStatus -> XML content is null!");
            return false;
        }
        try {
            if (DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str))).getDocumentElement().getElementsByTagName("dual_video").getLength() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            String str2 = TAG;
            OmniLog.w(str2, "parseDeviceDualStatus -> Exception happend! msg : " + e.getLocalizedMessage());
        }
    }

    public static boolean parseUserDeviceInfos(long j, String str, List<UserDeviceConfig> list) {
        if (list == null) {
            return false;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new StringReader(str));
            String str2 = "";
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2) {
                    if ("xml".equals(name)) {
                        int attributeCount = newPullParser.getAttributeCount();
                        int i = 0;
                        while (true) {
                            if (i >= attributeCount) {
                                continue;
                                break;
                            } else if ("defaultid".equals(newPullParser.getAttributeName(i))) {
                                str2 = newPullParser.getAttributeValue(i);
                                if ("novideo".equals(str2)) {
                                    return true;
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    OmniLog.pdwe(TAG, "Parsing the user's info of device failed... Don't get the default device");
                                }
                            } else {
                                i++;
                            }
                        }
                    } else if ("video".equals(name)) {
                        UserDeviceConfig parseDeviceInfo = parseDeviceInfo(newPullParser, j, str2);
                        if (parseDeviceInfo != null) {
                            list.add(parseDeviceInfo);
                        }
                    } else if ("dual_video".equals(name)) {
                        parseDualDeviceInfo(newPullParser, list);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            OmniLog.pdwe(TAG, "Parsing the user's info of device exception... " + e.getLocalizedMessage());
            return false;
        }
    }

    private static void parseDualDeviceInfo(XmlPullParser xmlPullParser, List<UserDeviceConfig> list) {
        int attributeCount = xmlPullParser.getAttributeCount();
        String str = "";
        boolean z = false;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("id".equals(attributeName)) {
                str = xmlPullParser.getAttributeValue(i);
            } else if ("inuse".equals(attributeName)) {
                z = "1".equals(xmlPullParser.getAttributeValue(i));
            }
        }
        if (TextUtils.isEmpty(str)) {
            OmniLog.pdwe(TAG, "Pasing dual device info failed... id is null!");
            return;
        }
        for (UserDeviceConfig next : list) {
            next.setDualDeviceId(str);
            next.setIsUse(z);
            next.setVideoSteamType(GlobalConfig.mDualDefStream);
        }
    }

    private static UserDeviceConfig parseDeviceInfo(XmlPullParser xmlPullParser, long j, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        String str2 = "";
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser.getAttributeName(i4);
            if ("id".equals(attributeName)) {
                str2 = xmlPullParser.getAttributeValue(i4);
            } else if ("w".equals(attributeName)) {
                try {
                    i = Integer.parseInt(xmlPullParser.getAttributeValue(i4));
                } catch (Exception unused) {
                }
            } else if ("h".equals(attributeName)) {
                i2 = Integer.parseInt(xmlPullParser.getAttributeValue(i4));
            } else if ("videotype".equals(attributeName)) {
                i3 = Integer.parseInt(xmlPullParser.getAttributeValue(i4));
            } else if ("inuse".equals(attributeName)) {
                z = "1".equals(xmlPullParser.getAttributeValue(i4));
            }
        }
        if (TextUtils.isEmpty(str2)) {
            OmniLog.pdwe(TAG, "Pasing device info failed... id is null!");
            return null;
        }
        UserDeviceConfig userDeviceConfig = new UserDeviceConfig(j, str2, z, str.equals(str2));
        userDeviceConfig.setWidth(i);
        userDeviceConfig.setHeight(i2);
        userDeviceConfig.setVideoType(i3);
        userDeviceConfig.setDeviceOpenTimestamp(System.currentTimeMillis());
        return userDeviceConfig;
    }

    public static String getDefaultDeviceId(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2 && "xml".equals(name)) {
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        if ("defaultid".equals(newPullParser.getAttributeName(i))) {
                            return newPullParser.getAttributeValue(i);
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            String str2 = TAG;
            OmniLog.pdwe(str2, "getDefaultDeviceId - Parse device info xml Exception -> " + e.getLocalizedMessage());
            return null;
        }
    }

    public static void parseDeviceDualInfos(List<UserDeviceConfig> list, String str) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.w(TAG, "[DUAL_WATCH], parseDeviceDualStatus -> XML content is null!");
        } else if (list == null || list.size() <= 0) {
            OmniLog.e(TAG, "[DUAL_WATCH], parseDeviceDualStatus -> udcs is null! parse dual failed!");
        } else {
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str))).getDocumentElement().getElementsByTagName("dual_video");
                if (elementsByTagName != null) {
                    if (elementsByTagName.getLength() > 0) {
                        Node item = elementsByTagName.item(0);
                        if (item == null) {
                            OmniLog.w(TAG, "[DUAL_WATCH], parseDeviceDualStatus -> Node(dual_video) is null!");
                            return;
                        }
                        NamedNodeMap attributes = item.getAttributes();
                        if (attributes != null) {
                            if (attributes.getLength() > 0) {
                                String nodeValue = attributes.getNamedItem("id").getNodeValue();
                                String localName = attributes.getNamedItem("inuse").getLocalName();
                                for (int i = 0; i < list.size(); i++) {
                                    UserDeviceConfig userDeviceConfig = list.get(i);
                                    userDeviceConfig.setDualDeviceId(nodeValue);
                                    userDeviceConfig.setDualUse("1".equals(localName));
                                    userDeviceConfig.setVideoSteamType(GlobalConfig.mDualDefStream);
                                }
                                return;
                            }
                        }
                        OmniLog.w(TAG, "[DUAL_WATCH], parseDeviceDualStatus -> attributes is null!");
                        return;
                    }
                }
                OmniLog.w(TAG, "[DUAL_WATCH], parseDeviceDualStatus -> NodeList(dual_video) is null!");
            } catch (Exception e) {
                String str2 = TAG;
                OmniLog.w(str2, "[DUAL_WATCH], parseDeviceDualStatus -> Exception happend! msg : " + e.getLocalizedMessage());
            }
        }
    }
}
