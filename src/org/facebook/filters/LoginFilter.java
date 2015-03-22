package org.facebook.filters;


import org.facebook.models.User;
import org.facebook.services.RetrieveHandlerImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
@WebFilter(value="/*")
public class LoginFilter implements Filter {

    private RetrieveHandlerImpl retrieveHandler;

    public void init(FilterConfig filterConfig) throws ServletException {
        retrieveHandler = new RetrieveHandlerImpl();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();
        String path = ((HttpServletRequest) servletRequest).getRequestURI().substring(
                ((HttpServletRequest) servletRequest).getContextPath().length());

        if (path.contains("/views/resources")) {
            filterChain.doFilter(servletRequest, servletResponse); // Goes to default servlet.
        } else {
            if ((session == null || session.getAttribute("user") == null) && isLoggedInUserAccessiblePage(requestedUri)) {
                if (isCookieAvailable(servletRequest)) {
                    ((HttpServletResponse) servletResponse).sendRedirect("home");
                } else {
                    ((HttpServletResponse) servletResponse).sendRedirect("login");
                }
            } else if (session != null && session.getAttribute("user") != null && isNonLoggedInUserAccessiblePage(requestedUri)) {
                ((HttpServletResponse) servletResponse).sendRedirect("home");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    private boolean isLoggedInUserAccessiblePage(String requestedUri) {
        return (requestedUri.contains("home") || requestedUri.contains("logout"));
    }

    private boolean isNonLoggedInUserAccessiblePage(String requestedUri) {
        return (requestedUri.contains("login") || requestedUri.contains("register"));
    }

    private boolean isCookieAvailable(ServletRequest servletRequest) {
        String rememberMeCookieName = "userId";
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        boolean cookieFound = false;

        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals(rememberMeCookieName)) {
                    User currentUser = retrieveHandler.getSpecificUser(Integer.parseInt(cooky.getValue()));
                    HttpSession newSession = ((HttpServletRequest) servletRequest).getSession();
                    newSession.setAttribute("user", currentUser);
                    cookieFound = true;
                }
            }
        }

        return cookieFound;
    }

    public void destroy() {
        //ignore
    }
}
