package lk.ijse.absd.channeling.configurations.filter;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@WebFilter(urlPatterns = "/*")
@Order(HIGHEST_PRECEDENCE)
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
        LOGGER.info("Path: " + httpServletRequest.getServletPath());

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
    }

}
