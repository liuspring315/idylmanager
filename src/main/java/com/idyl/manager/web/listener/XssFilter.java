package com.idyl.manager.web.listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created on 12-12-24
 * <p>描述:   对每个post请求的参数过滤一些关键字，替换成安全的，例如：< > ' " \ /  # &</p>
 * <p>版权所有： 首都信息发展有限责任公司</p>
 *
 * @version 0.1
 * @liuzhaochun
 */

public class XssFilter implements Filter {
    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssHttpServletRequestWrapper(
                (HttpServletRequest) request), response);
    }
}
