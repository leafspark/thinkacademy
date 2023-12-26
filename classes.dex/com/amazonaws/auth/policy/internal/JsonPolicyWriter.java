package com.amazonaws.auth.policy.internal;

import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonPolicyWriter {
    private static final Log log = LogFactory.getLog("com.amazonaws.auth.policy");
    private AwsJsonWriter jsonWriter = null;
    private final Writer writer;

    private boolean isNotNull(Object obj) {
        return obj != null;
    }

    public JsonPolicyWriter() {
        StringWriter stringWriter = new StringWriter();
        this.writer = stringWriter;
        this.jsonWriter = JsonUtils.getJsonWriter(stringWriter);
    }

    public String writePolicyToString(Policy policy) {
        if (isNotNull(policy)) {
            try {
                String jsonStringOf = jsonStringOf(policy);
                try {
                    this.writer.close();
                } catch (Exception unused) {
                }
                return jsonStringOf;
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to serialize policy to JSON string: " + e.getMessage(), e);
            } catch (Throwable th) {
                try {
                    this.writer.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Policy cannot be null");
        }
    }

    private String jsonStringOf(Policy policy) throws IOException {
        this.jsonWriter.beginObject();
        writeJsonKeyValue(JsonDocumentFields.VERSION, policy.getVersion());
        if (isNotNull(policy.getId())) {
            writeJsonKeyValue(JsonDocumentFields.POLICY_ID, policy.getId());
        }
        writeJsonArrayStart(JsonDocumentFields.STATEMENT);
        for (Statement next : policy.getStatements()) {
            this.jsonWriter.beginObject();
            if (isNotNull(next.getId())) {
                writeJsonKeyValue(JsonDocumentFields.STATEMENT_ID, next.getId());
            }
            writeJsonKeyValue(JsonDocumentFields.STATEMENT_EFFECT, next.getEffect().toString());
            List<Principal> principals = next.getPrincipals();
            if (isNotNull(principals) && !principals.isEmpty()) {
                writePrincipals(principals);
            }
            List<Action> actions = next.getActions();
            if (isNotNull(actions) && !actions.isEmpty()) {
                writeActions(actions);
            }
            List<Resource> resources = next.getResources();
            if (isNotNull(resources) && !resources.isEmpty()) {
                writeResources(resources);
            }
            List<Condition> conditions = next.getConditions();
            if (isNotNull(conditions) && !conditions.isEmpty()) {
                writeConditions(conditions);
            }
            this.jsonWriter.endObject();
        }
        writeJsonArrayEnd();
        this.jsonWriter.endObject();
        this.jsonWriter.flush();
        return this.writer.toString();
    }

    private void writeConditions(List<Condition> list) throws IOException {
        Map<String, ConditionsByKey> groupConditionsByTypeAndKey = groupConditionsByTypeAndKey(list);
        writeJsonObjectStart(JsonDocumentFields.CONDITION);
        for (Map.Entry next : groupConditionsByTypeAndKey.entrySet()) {
            ConditionsByKey conditionsByKey = groupConditionsByTypeAndKey.get(next.getKey());
            writeJsonObjectStart((String) next.getKey());
            for (String next2 : conditionsByKey.keySet()) {
                writeJsonArray(next2, conditionsByKey.getConditionsByKey(next2));
            }
            writeJsonObjectEnd();
        }
        writeJsonObjectEnd();
    }

    private void writeResources(List<Resource> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (Resource id : list) {
            arrayList.add(id.getId());
        }
        writeJsonArray(JsonDocumentFields.RESOURCE, arrayList);
    }

    private void writeActions(List<Action> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (Action actionName : list) {
            arrayList.add(actionName.getActionName());
        }
        writeJsonArray(JsonDocumentFields.ACTION, arrayList);
    }

    private void writePrincipals(List<Principal> list) throws IOException {
        if (list.size() != 1 || !list.get(0).equals(Principal.All)) {
            writeJsonObjectStart(JsonDocumentFields.PRINCIPAL);
            Map<String, List<String>> groupPrincipalByScheme = groupPrincipalByScheme(list);
            for (Map.Entry next : groupPrincipalByScheme.entrySet()) {
                List list2 = groupPrincipalByScheme.get(next.getKey());
                if (list2.size() == 1) {
                    writeJsonKeyValue((String) next.getKey(), (String) list2.get(0));
                } else {
                    writeJsonArray((String) next.getKey(), list2);
                }
            }
            writeJsonObjectEnd();
            return;
        }
        writeJsonKeyValue(JsonDocumentFields.PRINCIPAL, Principal.All.getId());
    }

    private Map<String, List<String>> groupPrincipalByScheme(List<Principal> list) {
        HashMap hashMap = new HashMap();
        for (Principal next : list) {
            String provider = next.getProvider();
            if (!hashMap.containsKey(provider)) {
                hashMap.put(provider, new ArrayList());
            }
            ((List) hashMap.get(provider)).add(next.getId());
        }
        return hashMap;
    }

    static class ConditionsByKey {
        private Map<String, List<String>> conditionsByKey = new HashMap();

        public Map<String, List<String>> getConditionsByKey() {
            return this.conditionsByKey;
        }

        public void setConditionsByKey(Map<String, List<String>> map) {
            this.conditionsByKey = map;
        }

        public boolean containsKey(String str) {
            return this.conditionsByKey.containsKey(str);
        }

        public List<String> getConditionsByKey(String str) {
            return this.conditionsByKey.get(str);
        }

        public Set<String> keySet() {
            return this.conditionsByKey.keySet();
        }

        public void addValuesToKey(String str, List<String> list) {
            List<String> conditionsByKey2 = getConditionsByKey(str);
            if (conditionsByKey2 == null) {
                this.conditionsByKey.put(str, new ArrayList(list));
            } else {
                conditionsByKey2.addAll(list);
            }
        }
    }

    private Map<String, ConditionsByKey> groupConditionsByTypeAndKey(List<Condition> list) {
        HashMap hashMap = new HashMap();
        for (Condition next : list) {
            String type = next.getType();
            String conditionKey = next.getConditionKey();
            if (!hashMap.containsKey(type)) {
                hashMap.put(type, new ConditionsByKey());
            }
            ((ConditionsByKey) hashMap.get(type)).addValuesToKey(conditionKey, next.getValues());
        }
        return hashMap;
    }

    private void writeJsonArray(String str, List<String> list) throws IOException {
        writeJsonArrayStart(str);
        for (String value : list) {
            this.jsonWriter.value(value);
        }
        writeJsonArrayEnd();
    }

    private void writeJsonObjectStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginObject();
    }

    private void writeJsonObjectEnd() throws IOException {
        this.jsonWriter.endObject();
    }

    private void writeJsonArrayStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginArray();
    }

    private void writeJsonArrayEnd() throws IOException {
        this.jsonWriter.endArray();
    }

    private void writeJsonKeyValue(String str, String str2) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.value(str2);
    }
}
