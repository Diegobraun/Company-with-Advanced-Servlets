package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EditarEmpresa implements ServletPattern{
	
	public String executa(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String data = req.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(dataAbertura);
		int index = 0;
		for (int i = 0;i < banco.getEmpresas().size();i++) {
			if (banco.getEmpresas().get(i).getId() == id) {
				index = i;
			}
		}
		
		banco.getEmpresas().set(index, empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
