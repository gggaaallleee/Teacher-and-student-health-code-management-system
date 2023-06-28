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
        HttpSession session = req.getSession();
        if(session.getAttribute("isLogin")==null){
            session.setAttribute("isLogin",false);
        }
        boolean isLogin = (boolean) session.getAttribute("isLogin");
        if(isLogin) {
            chain.doFilter(request, response);
            System.out.println(2);
            return;
        }
        // 如果是登录页面或者注册页面,放行
        if (url.endsWith("user_login.jsp") || url.endsWith("manage_login.jsp")|| url.endsWith("Servlet_login_user")|| url.endsWith("Servlet_login_management")||
                url.endsWith(".css")||
                url.endsWith(".js")||
                url.endsWith(".jpg")||
                url.endsWith(".png")||
                url.endsWith(".ico")||
                url.endsWith(".gif")||
                url.endsWith(".woff")||
                url.endsWith(".less")||
                url.endsWith(".ttf")||
                url.endsWith(".eot")||
                url.endsWith(".svg")||
                url.endsWith(".otf")
        ) {
            chain.doFilter(request, response);
            System.out.println(1);
            return;
        }
        // 从session中获取登录标记

        // 如果未登录,并且访问的不是登录页面,跳转到登录页面
        if (!isLogin && !url.endsWith("user_login.jsp")) {
            System.out.println(2);
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }
        // 其他请求放行
        chain.doFilter(request, response);
    }
}
