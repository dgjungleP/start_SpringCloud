package com.jungle.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.apache.juli.logging.Log;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class SimpleBlackListFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        boolean sendZuulResponse = context.sendZuulResponse();
        if (!sendZuulResponse) {
            return false;
        }
        HttpServletRequest request = context.getRequest();
        return request.getRequestURI().startsWith("/uaa-provider");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        if (request.getRequestURI().endsWith("yes")) {
            log.warn("The request:[ {} ] is in black list", request.getRequestURI());
            context.setSendZuulResponse(false);
            HttpServletResponse response = context.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            try {
                response.getWriter().write("Sorry you are in the black list");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        return null;
    }
}
