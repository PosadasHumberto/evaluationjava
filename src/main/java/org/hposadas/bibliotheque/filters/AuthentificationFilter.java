package org.hposadas.bibliotheque.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hposadas.bibliotheque.services.LoginService;
import org.hposadas.bibliotheque.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter("/info-user")
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) servletRequest);
        if (username.isPresent()){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Desolé, vous n'avez pas d'autorisation pour acceder a cette page. Merci de bien vouloir vous identifier.");
        }
    }
}
