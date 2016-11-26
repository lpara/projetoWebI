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

@WebServlet("/paginas/usuario/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String FORM = "/paginas/usuario/form.jsp";
	private static String LISTA = "/paginas/usuario/listUser.jsp";
	private static String HOME = "/projetoWeb/paginas/home.jsp";

	private String forward = "";
	private String acao = "";
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario user = new Usuario();

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward = "";
		acao = request.getParameter("acao");
		usuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");

		switch (acao.toLowerCase()) {
		case "remover":
			remover(request);
			break;
		case "atualizar":
			atualizar(request);
			break;
		case "listar":
			listar(request);
			break;
		case "voltar":
			voltar(response);
			break;
		default:
			cadastrar(request);
			break;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
		if (usuarios == null)
			usuarios = new ArrayList<Usuario>();

		popularUsuario(request);
		List<String> erros = user.validar();
		if (!erros.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}

		RequestDispatcher view = request.getRequestDispatcher(LISTA);
		salvarUsuario();

		request.getSession().setAttribute("listaUsuarios", usuarios);
		view.forward(request, response);
	}

	/**
	 * Operação de remover
	 * 
	 * @param request
	 */
	private void remover(HttpServletRequest request) {
		String login = (String) request.getParameter("login");
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equalsIgnoreCase(login))
				usuarios.remove(i);
		}
		request.getSession().setAttribute("listaUsuarios", usuarios);
		forward = LISTA;
	}

	/**
	 * Operação de atualizar
	 * 
	 * @param request
	 */
	private void atualizar(HttpServletRequest request) {
		user = null;
		String login = (String) request.getParameter("login");
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login))
				user = usuario;
		}
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("operacao", "Atualizar");
		forward = FORM;
	}

	/**
	 * Operação de listar
	 * 
	 * @param request
	 */
	private void listar(HttpServletRequest request) {
		request.getSession().setAttribute("listaUsuarios", usuarios);
		forward = LISTA;
	}

	/**
	 * Operação de cadastrar
	 * 
	 * @param request
	 */
	private void cadastrar(HttpServletRequest request) {
		request.getSession().setAttribute("user", new Usuario());
		request.getSession().setAttribute("operacao", "Cadastrar");
		forward = FORM;
	}
	
	/**
	 * Operação de voltar
	 * 
	 * @param response
	 * @throws IOException 
	 */
	private void voltar(HttpServletResponse response) throws IOException {
		response.sendRedirect(HOME);
	}

	/**
	 * Popular informações de usuário
	 * 
	 * @param request
	 */
	private void popularUsuario(HttpServletRequest request) {
		user = new Usuario();
		user.setNome(request.getParameter("nome"));
		user.setLogin(request.getParameter("login"));
		user.setSenha(request.getParameter("senha"));
		user.setConfirmaSenha(request.getParameter("confirmaSenha"));
	}

	/**
	 * Salvar informação do usuário
	 */
	private void salvarUsuario() {
		boolean update = false;

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equalsIgnoreCase(user.getLogin())) {
				usuarios.remove(i);
				usuarios.add(user);
				update = true;
			}

		}

		if (!update)
			usuarios.add(user);
	}
}