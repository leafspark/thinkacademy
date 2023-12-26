package com.yanzhenjie.andserver.framework.view;

import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.error.ServerInternalException;
import com.yanzhenjie.andserver.framework.MessageConverter;
import com.yanzhenjie.andserver.framework.body.StringBody;
import com.yanzhenjie.andserver.http.HttpContext;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.http.RequestDispatcher;
import com.yanzhenjie.andserver.http.ResponseBody;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StatusCode;
import com.yanzhenjie.andserver.util.StringUtils;

public class ViewResolver implements Patterns, StatusCode, HttpHeaders {
    private MessageConverter mConverter;

    public ViewResolver() {
    }

    public ViewResolver(MessageConverter messageConverter) {
        this.mConverter = messageConverter;
    }

    public void resolve(View view, HttpRequest httpRequest, HttpResponse httpResponse) {
        if (view != null) {
            Object output = view.output();
            if (view.rest()) {
                resolveRest(output, httpRequest, httpResponse);
            } else {
                resolvePath(output, httpRequest, httpResponse);
            }
        }
    }

    private void resolveRest(Object obj, HttpRequest httpRequest, HttpResponse httpResponse) {
        if (obj instanceof ResponseBody) {
            httpResponse.setBody((ResponseBody) obj);
            return;
        }
        MessageConverter messageConverter = this.mConverter;
        if (messageConverter != null) {
            httpResponse.setBody(messageConverter.convert(obj, obtainProduce(httpRequest)));
        } else if (obj == null) {
            httpResponse.setBody(new StringBody(""));
        } else if (obj instanceof String) {
            httpResponse.setBody(new StringBody(obj.toString(), obtainProduce(httpRequest)));
        } else {
            httpResponse.setBody(new StringBody(obj.toString()));
        }
    }

    private MediaType obtainProduce(HttpRequest httpRequest) {
        Object attribute = httpRequest.getAttribute(HttpContext.RESPONSE_PRODUCE_TYPE);
        if (attribute instanceof MediaType) {
            return (MediaType) attribute;
        }
        return null;
    }

    private void resolvePath(Object obj, HttpRequest httpRequest, HttpResponse httpResponse) {
        if (obj instanceof CharSequence) {
            String obj2 = obj.toString();
            if (!StringUtils.isEmpty(obj2)) {
                if (obj2.matches(Patterns.REDIRECT)) {
                    httpResponse.setStatus(302);
                    if (obj2.length() >= 9) {
                        httpResponse.setHeader(HttpHeaders.LOCATION, obj2.substring(9));
                    }
                } else if (obj2.matches(Patterns.FORWARD)) {
                    String substring = obj2.substring(8);
                    RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(substring);
                    if (requestDispatcher != null) {
                        requestDispatcher.forward(httpRequest, httpResponse);
                        return;
                    }
                    throw new NotFoundException(substring);
                } else if (obj2.matches(PATH)) {
                    String str = obj2 + ".html";
                    RequestDispatcher requestDispatcher2 = httpRequest.getRequestDispatcher(str);
                    if (requestDispatcher2 != null) {
                        requestDispatcher2.forward(httpRequest, httpResponse);
                        return;
                    }
                    throw new NotFoundException(str);
                } else {
                    throw new NotFoundException(obj2);
                }
            }
        } else {
            throw new ServerInternalException(String.format("The return value of [%s] is not supported", new Object[]{obj}));
        }
    }
}
