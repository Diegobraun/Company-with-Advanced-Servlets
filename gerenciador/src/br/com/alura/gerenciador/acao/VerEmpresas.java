package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class VerEmpresas
 */
@WebServlet("/verEmpresas")
public class VerEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("filtro");
		Banco banco = new Banco();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (int i = 0; i < banco.getEmpresas().size();i++) {
			Empresa empresa = banco.getEmpresas().get(i);
			if (empresa.getNome().contains(parametro))
				out.println("<p>Empresa = " + banco.getEmpresas().get(i).getNome()+ "</p><br>");
			else
				out.println("<p>Empresa com nome não semelhante</p>");
		}
		out.println("</body></html>");
	}

}
