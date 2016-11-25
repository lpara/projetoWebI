package br.unirn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unirn.dominio.Usuario;

@WebServlet("/paginas/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/paginas/user.jsp";
    private static String LIST_USER = "/paginas/listUser.jsp";

    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        List<Usuario> usuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");

        if (action.equalsIgnoreCase("delete")){
            String login = (String) request.getParameter("login");
            for (int i = 0; i < usuarios.size(); i++) {
            	if(usuarios.get(i).getLogin().equalsIgnoreCase(login))
            		usuarios.remove(i);
			}
            forward = LIST_USER;
            request.getSession().setAttribute("listaUsuarios", usuarios);    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            Usuario user = null;
            String login =  (String) request.getParameter("login");
            for (Usuario usuario : usuarios) {
            	if(usuario.getLogin().equalsIgnoreCase(login))
            		user = usuario;
			}
            request.getSession().setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.getSession().setAttribute("listaUsuarios", usuarios);
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Usuario> usuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
    	boolean update = false;
    	if(usuarios == null)
    		usuarios = new ArrayList<Usuario>();
    	Usuario user = new Usuario();
        user.setNome(request.getParameter("nome"));
        user.setLogin(request.getParameter("login"));
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        for (int i = 0; i < usuarios.size(); i++) {
        	if(usuarios.get(i).getLogin().equalsIgnoreCase(user.getLogin())){
        		usuarios.remove(i);
        		usuarios.add(user);
        		update = true;
        	}
			
		}
        if(!update)
        	usuarios.add(user);
        request.getSession().setAttribute("listaUsuarios", usuarios);
        view.forward(request, response);
    }
}