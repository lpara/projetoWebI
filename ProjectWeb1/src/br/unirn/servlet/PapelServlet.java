package br.unirn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gerenciarPapel")
public class PapelServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String codigo = req.getParameter("codigo");
		String descricao = req.getParameter("descricao");
		
		if (!codigo.isEmpty()) {
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>A .</font>");
			resp.sendRedirect("/projetoWeb/papel.jsp");
		} else {
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>Code is empty.</font>");
			resp.sendRedirect("/projetoWeb/login.jsp");
		}
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
