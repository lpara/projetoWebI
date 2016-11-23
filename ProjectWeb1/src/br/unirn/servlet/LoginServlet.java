package br.unirn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dominio.Usuario;

@WebServlet("/logar")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		if (login.equals("admin") && senha.equals("admin")) {
			Usuario u = new Usuario();
			u.setNome("Admin");
			req.getSession().setAttribute("usuario", u);
			resp.sendRedirect("/LoginServlet/paginas/conteudo.jsp");
		} else {
			resp.sendRedirect("/LoginServlet/paginas/login.jsp");
		}
			
	}
}
