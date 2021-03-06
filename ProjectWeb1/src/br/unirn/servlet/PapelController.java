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

import br.unirn.dominio.Papel;
import br.unirn.dominio.Usuario;

@WebServlet("/paginas/papel/PapelController")
public class PapelController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String FORM = "/paginas/papel/form.jsp";
	private static String LISTA = "/paginas/papel/listPapel.jsp";
	private static String HOME = "/projetoWeb/paginas/home.jsp";

	private String forward = "";
	private String acao = "";
	private List<Papel> papeis = new ArrayList<Papel>();
	private Papel role = new Papel();

	public PapelController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward = "";
		acao = request.getParameter("acaoPapel");
		papeis = (List<Papel>) request.getSession().getAttribute("listaPapeis");

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

		papeis = (List<Papel>) request.getSession().getAttribute("listaPapeis");
		if (papeis == null)
			papeis = new ArrayList<Papel>();

		popularPapel(request);
		List<String> erros = role.validar();
		if (!erros.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}

		RequestDispatcher view = request.getRequestDispatcher(LISTA);
		salvarPapel();

		request.getSession().setAttribute("listaPapeis", papeis);
		view.forward(request, response);
	}
	
	/**
	 * Operação de remover
	 * 
	 * @param request
	 */
	private void remover(HttpServletRequest request) {
		String nome = (String) request.getParameter("nome");
		for (int i = 0; i < papeis.size(); i++) {
			if (papeis.get(i).getNome().equalsIgnoreCase(nome))
				papeis.remove(i);
		}
		request.getSession().setAttribute("listaPapeis", papeis);
		forward = LISTA;
	}
	
	/**
	 * Operação de atualizar
	 * 
	 * @param request
	 */
	private void atualizar(HttpServletRequest request) {
		role = null;
		String nome = (String) request.getParameter("nome");
		for (Papel papel : papeis) {
			if (papel.getNome().equalsIgnoreCase(nome))
				role = papel;
		}
		request.getSession().setAttribute("papel", role);
		request.getSession().setAttribute("operacao", "Atualizar");
		forward = FORM;
	}
	
	/**
	 * Operação de listar
	 * 
	 * @param request
	 */
	private void listar(HttpServletRequest request) {
		request.getSession().setAttribute("listaPapeis", papeis);
		forward = LISTA;
	}

	/**
	 * Operação de cadastrar
	 * 
	 * @param request
	 */
	private void cadastrar(HttpServletRequest request) {
		request.getSession().setAttribute("papel", new Papel());
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
	 * Popular informações de papel
	 * 
	 * @param request
	 */
	private void popularPapel(HttpServletRequest request) {
		role = new Papel();
		role.setNome(request.getParameter("nome"));
		role.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		role.setDescricao(request.getParameter("descricao"));
	}
	
	/**
	 * Salvar informação do papel
	 */
	private void salvarPapel() {
		boolean update = false;

		for (int i = 0; i < papeis.size(); i++) {
			if (papeis.get(i).getNome().equalsIgnoreCase(role.getNome())) {
				papeis.remove(i);
				papeis.add(role);
				update = true;
			}

		}

		if (!update)
			papeis.add(role);
	}

}
