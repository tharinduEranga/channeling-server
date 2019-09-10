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
        String httpMethod = httpServletRequest.getMethod();
        LOGGER.info("\nPath: " + servletPath + "\ntoken: " + authorization + "\nmethod: " + httpMethod);

        if (httpMethod.equalsIgnoreCase("OPTIONS")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        boolean hasToIgnore = ignorePaths(httpServletRequest, httpServletResponse, filterChain, servletPath,
                "/admins/login", "/index.html");
        if (hasToIgnore) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        try {
            Claims claims = JWTAuthenticator.decodeJWT(authorization);
        } catch (Exception e) {

            e.printStackTrace();
            httpServletResponse.setStatus(401);
            httpServletResponse.sendError(401, "Invalid token!");

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {
    }

    /**
     * @param httpServletRequest:  The container generated servlet request object which sends from client
     * @param httpServletResponse: The response that will be generated from the server
     * @param filterChain:         the filterChain of the request
     * @param servletPath:         the servlet rest controller path of the request
     * @param ignorePaths:         the paths which needs to be ignored for token authorization
     * @return whether the path is equals to be ignored or not
     * @throws IOException
     * @throws ServletException
     */
    private boolean ignorePaths(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                FilterChain filterChain, String servletPath, String... ignorePaths) throws IOException, ServletException {
        String[] ignorePathsArray = ignorePaths.clone();
        for (String ignorePath : ignorePathsArray) {
            if (ignorePath.equalsIgnoreCase(servletPath)) {
                return true;
            }
        }
        return false;
    }

}
