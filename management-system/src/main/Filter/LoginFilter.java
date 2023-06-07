package main.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 获取请求的URL
        String url = req.getRequestURI();

        // 如果是登录页面或者注册页面,放行
        if (url.endsWith("login.jsp") || url.endsWith("register.jsp")) {
            chain.doFilter(request, response);
            return;
        }

        // 从session中获取登录标记
        HttpSession session = req.getSession();
        boolean isLogin = (boolean) session.getAttribute("isLogin");

        // 如果未登录,并且访问的不是登录页面,跳转到登录页面
        if (!isLogin && !url.endsWith("login.jsp")) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // 其他请求放行
        chain.doFilter(request, response);
    }
}
