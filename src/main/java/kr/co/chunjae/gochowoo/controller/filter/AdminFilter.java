package kr.co.chunjae.gochowoo.controller.filter;

import kr.co.chunjae.gochowoo.model.User.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (user.getNickName().equals("admin")) {
                chain.doFilter(request, response);
                return ;
            }
        }
        httpResponse.sendRedirect("/");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 로직 (선택 사항)
    }

    @Override
    public void destroy() {
        // 필터 종료 로직 (선택 사항)
    }
}
