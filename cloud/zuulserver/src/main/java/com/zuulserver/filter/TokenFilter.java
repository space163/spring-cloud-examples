package com.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by space163 on 2019/4/10.
 */
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //路由请求之前
    }

    @Override
    public int filterOrder() {
        return 0; //优先级，数字越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否执行过滤器
    }

    @Override
    public Object run() throws ZuulException { //拦截处理，可以结合shiro等进行鉴权等操作
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token == null || "".equals(token)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        }
        return null;
    }
}
