package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa implements ServletPattern{
	

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa e = null;
		
		for (Empresa empresa  : banco.getEmpresas()) {
			if (empresa.getId() == id) {
				e = empresa;
			}
		}
		banco.getEmpresas().remove(e);
		System.out.println(id);
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
