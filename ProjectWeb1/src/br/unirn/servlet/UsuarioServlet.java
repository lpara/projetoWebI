package br.unirn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dominio.Usuario;

@WebServlet("/gerenciarUsuario")
public class UsuarioServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String confirmaSenha = req.getParameter("confirmaSenha");
		
		if (senha.equalsIgnoreCase(confirmaSenha)) {
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>A .</font>");
			resp.sendRedirect("/projetoWeb/login.jsp");
		} else {
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			resp.sendRedirect("/projetoWeb/login.jsp");
		}
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
