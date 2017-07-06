package com.brianway.learning.java.spring_boot_test.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lengbing on 2017/7/5.
 */
@Primary
@Configuration
public class RestfulRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    /**
     * Look up the best-matching handler method for the current request.
     * If multiple matches are found, the best match is selected.
     *
     * @param lookupPath mapping lookup path within the current servlet mapping
     * @param request    the current request
     * @return the best-matching handler method, or {@code null} if no match
     * @see #handleMatch(Object, String, HttpServletRequest)
     * @see #handleNoMatch(Set, String, HttpServletRequest)
     */
    protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
        //自己的查找逻辑，如果找不到，再执行原有的逻辑，以免出现错误情况
        HandlerMethod handlerMethod = lookupHandlerMethodHere(lookupPath, request);
        if (handlerMethod == null)
            handlerMethod = super.lookupHandlerMethod(lookupPath, request);
        return handlerMethod;
    }

    //自己的查找逻辑，根据从请求头中获取服务名servicename，进行匹配查找
    private HandlerMethod lookupHandlerMethodHere(String lookupPath, HttpServletRequest request) {
        String servicename = request.getHeader("servicename");
        if (!StringUtils.isEmpty(servicename)) {
            List<HandlerMethod> methodList = this.getHandlerMethodsForMappingName(servicename);
            if (methodList.size() > 0){
                HandlerMethod handlerMethod = methodList.get(0);
                RequestMappingInfo requestMappingInfo = mappingLookup.get(handlerMethod);
                handleMatch(requestMappingInfo, lookupPath, request);
                return handlerMethod;
            }
        }
        return null;
    }


    //映射map
    private final Map<HandlerMethod, RequestMappingInfo> mappingLookup = new LinkedHashMap<>();

    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
        HandlerMethod handlerMethod = createHandlerMethod(handler, method);
        mappingLookup.put(handlerMethod, mapping);
        super.registerHandlerMethod(handler, method, mapping);
    }

}
