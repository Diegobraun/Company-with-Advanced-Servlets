package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.ServletPattern;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
	
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

