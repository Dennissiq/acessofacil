package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;

import model.Colaborador;

@WebFilter(urlPatterns="/view/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		if(usuario == "<deslogado>") {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/acessofacil");
		} else {
			System.out.println("Usuario " + usuario + " acessando URI " + uri);
			chain.doFilter(request, response);
		}
	}

	private String getUsuario(HttpServletRequest req) {
		Colaborador colaborador = (Colaborador) req.getSession().getAttribute("usuarioLogado");
		if(colaborador == null) return "<deslogado>";
		return colaborador.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
