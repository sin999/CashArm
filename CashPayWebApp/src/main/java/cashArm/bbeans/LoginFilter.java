package cashArm.bbeans;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 26.03.14.
 */
@WebFilter(filterName="loginFilter", urlPatterns="/")
public class LoginFilter implements Filter {




        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest req = (HttpServletRequest) request;
            AuthBean auth = (AuthBean) req.getSession().getAttribute("authBean");

            if (auth != null && auth.isLoginGood()) {
                // User is logged in, so just continue request.
                chain.doFilter(request, response);
            } else {
                // User is not logged in, so redirect to index.
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "login.xhtml");
            }
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    // You need to override init() and destroy() as well, but they can be kept empty.
}
