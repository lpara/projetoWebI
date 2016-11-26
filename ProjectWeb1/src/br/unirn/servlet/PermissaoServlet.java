package br.unirn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dominio.Papel;
import br.unirn.dominio.Usuario;

public class PermissaoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usuarioSelecionado = req.getParameter("comboUsuario");
		String papelSelecionado = req.getParameter("comboPapel");
		List<Papel> papeisSistema = preProcessamentoPapeis();
		//Buscar lista geral de usuários do sistema e para inserir os papeis.
		List<Usuario> usuariosSistema = (List<Usuario>) req.getSession().getAttribute("listaUsuarios");
		
		
		if (!usuarioSelecionado.isEmpty() && !papelSelecionado.isEmpty() && usuariosSistema != null && !usuariosSistema.isEmpty()) {
			Papel papelTemp = new Papel();
			for(Papel p:papeisSistema){
				if(p.getNome().equals(papelSelecionado)){
					papelTemp = p;
					break;
				}
			}
			for(int i = 0; i < usuariosSistema.size(); i++){
				if(usuariosSistema.get(i).getNome().equals(usuarioSelecionado)){
					usuariosSistema.get(i).getPapeis().add(papelTemp);
					break;
				}
			}
			req.getSession().setAttribute("listaUsuarios", usuariosSistema);
			resp.sendRedirect("/projetoWeb/paginas/home.jsp");
		} else {
			PrintWriter out= resp.getWriter();
			out.println("<font color=red>Campo obrigatório não preenchido.</font>");
			resp.sendRedirect("/projetoWeb/paginas/papel/form.jsp");
		}
			
	}
	
	private List<Papel> preProcessamentoPapeis(){
		
		List<Papel> papeisSistema = new ArrayList<Papel>();
		Papel p1 = new Papel();
		Papel p2 = new Papel();
		Papel p3 = new Papel();
		Papel p4 = new Papel();
		
		p1.setCodigo(1);
		p1.setDescricao("Concede acesso aos casos de uso de inserção e listagem de usuários.");
		p1.setNome("GESTOR_USUARIO");
		papeisSistema.add(p1);
		p2.setCodigo(2);
		p2.setDescricao("Concede acesso aos casos de uso de inserção e listagem de papeis.");
		p2.setNome("GESTOR_PAPEIS");
		papeisSistema.add(p2);
		p3.setCodigo(3);
		p3.setDescricao("Concede acesso aos casos de uso de listagem de papeis.");
		p3.setNome("CONSULTA_PAPEIS");
		papeisSistema.add(p3);
		p4.setCodigo(4);
		p4.setDescricao("Concede acesso aos casos de uso de listagem de usuários.");
		p4.setNome("CONSULTA_USUARIOS");
		papeisSistema.add(p4);
		
		return papeisSistema;
		
	}
}
