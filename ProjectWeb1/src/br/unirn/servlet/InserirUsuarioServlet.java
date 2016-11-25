package br.unirn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dominio.Usuario;

@WebServlet("/add")
public class InserirUsuarioServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String nome = req.getParameter("nome");
		
		if(login == null || senha == null || nome == null){
			resp.sendRedirect("/InserirUsuarioServlet/formUsuario.jsp");
		}
		//Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
	}
}
