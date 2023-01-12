package com.en.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @ClassName AuthorizedRequestFilter
 * @Description some description
 * @Author Jason
 * @Date 2023/1/12 14:59
 */
public class AuthorizedRequestFilter extends ZuulFilter {
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
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取当前请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 认证的原始信息
        String auth = "admin:root";
        // 进行一个加密的处理
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        requestContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
