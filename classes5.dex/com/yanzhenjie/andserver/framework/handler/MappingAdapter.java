package com.yanzhenjie.andserver.framework.handler;

import com.yanzhenjie.andserver.error.ContentNotAcceptableException;
import com.yanzhenjie.andserver.error.ContentNotSupportedException;
import com.yanzhenjie.andserver.error.HeaderValidateException;
import com.yanzhenjie.andserver.error.MethodNotSupportException;
import com.yanzhenjie.andserver.error.ParamValidateException;
import com.yanzhenjie.andserver.framework.mapping.Mapping;
import com.yanzhenjie.andserver.framework.mapping.Mime;
import com.yanzhenjie.andserver.framework.mapping.Pair;
import com.yanzhenjie.andserver.framework.mapping.Path;
import com.yanzhenjie.andserver.http.HttpContext;
import com.yanzhenjie.andserver.http.HttpMethod;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class MappingAdapter implements HandlerAdapter, Patterns {
    /* access modifiers changed from: protected */
    public abstract Object getHost();

    /* access modifiers changed from: protected */
    public abstract Map<Mapping, RequestHandler> getMappingMap();

    public boolean intercept(HttpRequest httpRequest) {
        List<Path.Segment> pathToList = Path.pathToList(httpRequest.getPath());
        List<Mapping> exactMappings = getExactMappings(pathToList);
        if (exactMappings.isEmpty()) {
            exactMappings = getBlurredMappings(pathToList);
        }
        if (exactMappings.isEmpty()) {
            return false;
        }
        Mapping mapping = null;
        HttpMethod method = httpRequest.getMethod();
        Iterator<Mapping> it = exactMappings.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Mapping next = it.next();
            if (next.getMethod().getRuleList().contains(method)) {
                mapping = next;
                break;
            }
        }
        if (mapping != null) {
            Pair param = mapping.getParam();
            if (param != null) {
                validateParams(param, httpRequest);
            }
            Pair header = mapping.getHeader();
            if (header != null) {
                validateHeaders(header, httpRequest);
            }
            Mime consume = mapping.getConsume();
            if (consume != null) {
                validateConsume(consume, httpRequest);
            }
            Mime produce = mapping.getProduce();
            if (produce == null) {
                return true;
            }
            validateProduce(produce, httpRequest);
            return true;
        }
        throw new MethodNotSupportException(method);
    }

    public RequestHandler getHandler(HttpRequest httpRequest) {
        Mime.Rule rule;
        Mapping mapping;
        List<Path.Segment> pathToList = Path.pathToList(httpRequest.getPath());
        List<Mapping> exactMappings = getExactMappings(pathToList);
        if (exactMappings.isEmpty()) {
            exactMappings = getBlurredMappings(pathToList);
        }
        HttpMethod method = httpRequest.getMethod();
        Iterator<Mapping> it = exactMappings.iterator();
        while (true) {
            rule = null;
            if (!it.hasNext()) {
                mapping = null;
                break;
            }
            mapping = it.next();
            if (mapping.getMethod().getRuleList().contains(method)) {
                break;
            }
        }
        if (mapping == null) {
            return null;
        }
        Mime produce = mapping.getProduce();
        if (produce != null) {
            Iterator<Mime.Rule> it2 = produce.getRuleList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Mime.Rule next = it2.next();
                if (!next.toString().startsWith("!")) {
                    rule = next;
                    break;
                }
            }
            httpRequest.setAttribute(HttpContext.RESPONSE_PRODUCE_TYPE, rule);
        }
        return getMappingMap().get(mapping);
    }

    private List<Mapping> getExactMappings(List<Path.Segment> list) {
        ArrayList arrayList = new ArrayList();
        for (Mapping next : getMappingMap().keySet()) {
            for (Path.Rule segments : next.getPath().getRuleList()) {
                if (matchExactPath(segments.getSegments(), list)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private boolean matchExactPath(List<Path.Segment> list, List<Path.Segment> list2) {
        if (list2.size() == list.size() && Path.listToPath(list).equals(Path.listToPath(list2))) {
            return true;
        }
        return false;
    }

    private List<Mapping> getBlurredMappings(List<Path.Segment> list) {
        ArrayList arrayList = new ArrayList();
        for (Mapping next : getMappingMap().keySet()) {
            for (Path.Rule segments : next.getPath().getRuleList()) {
                if (matchBlurredPath(segments.getSegments(), list)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private boolean matchBlurredPath(List<Path.Segment> list, List<Path.Segment> list2) {
        if (list2.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Path.Segment segment = list.get(i);
            if (!segment.equals(list2.get(i)) && !segment.isBlurred()) {
                return false;
            }
        }
        return true;
    }

    private void validateParams(Pair pair, HttpRequest httpRequest) {
        for (Pair.Rule next : pair.getRuleList()) {
            String key = next.getKey();
            List<String> parameterNames = httpRequest.getParameterNames();
            String value = next.getValue();
            List<String> parameters = httpRequest.getParameters(key);
            if (next.isNoKey()) {
                if (parameterNames.contains(key)) {
                    throw new ParamValidateException(String.format("The parameter [%s] is not allowed.", new Object[]{key}));
                }
            } else if (next.isNoValue()) {
                if (parameters.contains(value)) {
                    throw new ParamValidateException(String.format("The value of parameter %s cannot be %s.", new Object[]{key, value}));
                }
            } else if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
                if (!StringUtils.isEmpty(key) && StringUtils.isEmpty(value) && !parameterNames.contains(key)) {
                    throw new ParamValidateException(String.format("The parameter %s is missing.", new Object[]{key}));
                }
            } else if (!parameterNames.contains(key) || !parameters.contains(value)) {
                throw new ParamValidateException(String.format("The value of parameter %s is missing or wrong.", new Object[]{key}));
            }
        }
    }

    private void validateHeaders(Pair pair, HttpRequest httpRequest) {
        for (Pair.Rule next : pair.getRuleList()) {
            String key = next.getKey();
            List<String> headerNames = httpRequest.getHeaderNames();
            String value = next.getValue();
            List<String> headers = httpRequest.getHeaders(key);
            if (next.isNoKey()) {
                if (headerNames.contains(key)) {
                    throw new HeaderValidateException(String.format("The header [%s] is not allowed.", new Object[]{key}));
                }
            } else if (next.isNoValue()) {
                if (headers.contains(value)) {
                    throw new HeaderValidateException(String.format("The value of header %s cannot be %s.", new Object[]{key, value}));
                }
            } else if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value) && (!headerNames.contains(key) || !headers.contains(value))) {
                throw new HeaderValidateException(String.format("The value of header %s is missing or wrong.", new Object[]{key}));
            } else if (!StringUtils.isEmpty(key) && StringUtils.isEmpty(value) && !headerNames.contains(key)) {
                throw new HeaderValidateException(String.format("The header %s is missing.", new Object[]{key}));
            }
        }
    }

    private void validateConsume(Mime mime, HttpRequest httpRequest) {
        List<Mime.Rule> ruleList = mime.getRuleList();
        MediaType contentType = httpRequest.getContentType();
        ArrayList arrayList = new ArrayList();
        Iterator<Mime.Rule> it = ruleList.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                Mime.Rule next = it.next();
                String type = next.getType();
                boolean startsWith = type.startsWith("!");
                if (startsWith) {
                    type = type.substring(1);
                }
                MediaType mediaType = new MediaType(type, next.getSubtype());
                if (!startsWith) {
                    arrayList.add(mediaType);
                } else if (mediaType.equalsExcludeParameter(contentType)) {
                    throw new ContentNotSupportedException(contentType);
                }
            } else {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((MediaType) it2.next()).includes(contentType)) {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    throw new ContentNotSupportedException(contentType);
                }
                return;
            }
        }
    }

    private void validateProduce(Mime mime, HttpRequest httpRequest) {
        List<Mime.Rule> ruleList = mime.getRuleList();
        List<MediaType> accepts = httpRequest.getAccepts();
        for (Mime.Rule next : ruleList) {
            String type = next.getType();
            boolean startsWith = type.startsWith("!");
            if (startsWith) {
                type = type.substring(1);
            }
            MediaType mediaType = new MediaType(type, next.getSubtype());
            boolean z = false;
            for (MediaType includes : accepts) {
                if (includes.includes(mediaType)) {
                    z = true;
                }
            }
            if (startsWith && z) {
                throw new ContentNotAcceptableException();
            } else if (!startsWith && !z) {
                throw new ContentNotAcceptableException();
            }
        }
    }
}
