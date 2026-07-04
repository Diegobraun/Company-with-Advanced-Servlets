package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.ServletPattern;

//@WebFilter("/ControladorFilter")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		String paramAcao = servletRequest.getParameter("acao");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String nome = null;
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao;
		@SuppressWarnings("rawtypes")
		Class classe = null;
		ServletPattern object = null;
		
		try {
			classe = Class.forName(nomeDaClasse);
			object = (ServletPattern) classe.newInstance();
			nome = object.executa(request,response);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		@SuppressWarnings("null")
		String [] tipoEEndereco = nome.split(":");
		
		if (tipoEEndereco[0].contains("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
	}
}
