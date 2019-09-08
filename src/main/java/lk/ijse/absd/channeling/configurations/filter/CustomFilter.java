package lk.ijse.absd.channeling.configurations.filter;

import io.jsonwebtoken.Claims;
import lk.ijse.absd.channeling.configurations.security.JWTAuthenticator;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CustomFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String authorization = httpServletRequest.getHeader("authorization");
        String servletPath = httpServletRequest.getServletPath();
        LOGGER.info("\nPath: " + servletPath + "\ntoken: " + authorization);

        try {
            Claims claims = JWTAuthenticator.decodeJWT(authorization);
        } catch (Exception e) {
            if (servletPath.equalsIgnoreCase("/admins/login")) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
            e.printStackTrace();
            httpServletResponse.setStatus(401);
            httpServletResponse.sendError(401, "Invalid token!");

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {
    }

}
