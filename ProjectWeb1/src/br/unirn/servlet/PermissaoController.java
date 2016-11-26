package br.unirn.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.unirn.dominio.Papel;
import br.unirn.dominio.Usuario;


@WebServlet("/paginas/permissao/PermissaoController")
public class PermissaoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String FORM = "/paginas/papel/papel.jsp";
    private static String LISTA = "/paginas/papel/listPapel.jsp";
    private static String PERMISSAO = "/paginas/permissao/form.jsp";


    private String forward = "";
    private Usuario user = new Usuario();
    private String acao = "";
    private List<Papel> papeis = new ArrayList<Papel>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        forward = "";
        acao = request.getParameter("acaoPermissao");
        usuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");


        if (acao.equalsIgnoreCase("remover")) {
            remover(request);
        } else if (acao.equalsIgnoreCase("permissoes")) {
            permissoes(request);
        } else {
            adicionar(request);
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
    
    private void permissoes(HttpServletRequest request) {
        
        user = null;
        String login = (String) request.getParameter("login");
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equalsIgnoreCase(login))
                user = usuario;
        }
        
        if(user.getPapeis() == null || user.getPapeis().isEmpty()) {
            List<Papel> ps = new ArrayList<>();
            user.setPapeis(ps);
        }
        
        List<Papel> papeis = (List<Papel>) request.getSession().getAttribute("listaPapeis");
        List<Papel> papeisDisponiveis = new ArrayList<>();
        for (Papel papel : papeis){
            if(!user.getPapeis().contains(papel))
            	papeisDisponiveis.add(papel);
        }
        
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("operacao", "Permissoes");
        request.getSession().setAttribute("listaPapeisDisponiveis", papeisDisponiveis);
        forward = PERMISSAO;
        
    }
    
    public List<Papel> preProcessamentoPapeis(){
        
        List<Papel> papeisSistema = new ArrayList<Papel>();
        Papel p1 = new Papel();
        Papel p2 = new Papel();
        Papel p3 = new Papel();
        Papel p4 = new Papel();
        
        p1.setCodigo(1);
        p1.setDescricao("Concede acesso aos casos de uso de inserÃ§Ã£o e listagem de usuÃ¡rios.");
        p1.setNome("GESTOR_USUARIO");
        papeisSistema.add(p1);
        p2.setCodigo(2);
        p2.setDescricao("Concede acesso aos casos de uso de inserÃ§Ã£o e listagem de papeis.");
        p2.setNome("GESTOR_PAPEIS");
        papeisSistema.add(p2);
        p3.setCodigo(3);
        p3.setDescricao("Concede acesso aos casos de uso de listagem de papeis.");
        p3.setNome("CONSULTA_PAPEIS");
        papeisSistema.add(p3);
        p4.setCodigo(4);
        p4.setDescricao("Concede acesso aos casos de uso de listagem de usuÃ¡rios.");
        p4.setNome("CONSULTA_USUARIOS");
        papeisSistema.add(p4);
        
        return papeisSistema;
        
    }
    
    private void adicionar(HttpServletRequest request) {


        Integer idPapel = Integer.parseInt(request.getParameter("papel"));
        
        
        List<Papel> papeis = (List<Papel>) request.getSession().getAttribute("listaPapeis");
        
        for (Papel papel : papeis){
            if(papel.getCodigo() == idPapel){
                user.getPapeis().add(papel);
            }
        }
        
        List<Papel> papeisDisponiveis = new ArrayList<>();
        
        for (Papel papel : papeis){
            if(!user.getPapeis().contains(papel))
                papeisDisponiveis.add(papel);
        }
        
        request.getSession().setAttribute("listaPapeisDisponiveis", papeisDisponiveis);


        forward = PERMISSAO;
        
    }


    private void remover(HttpServletRequest request) {


        Integer idPapel = Integer.parseInt(request.getParameter("papel"));
                
        List<Papel> papeis = (List<Papel>) request.getSession().getAttribute("listaPapeis");




        for (Iterator<Papel> iterator = user.getPapeis().iterator(); iterator.hasNext();) {
            Papel papel = iterator.next();
            if (papel.getCodigo() == idPapel) {
                iterator.remove();
            }
        }
        
        List<Papel> papeisDisponiveis = new ArrayList<>();
        
        for (Papel papel : papeis){
            if(!user.getPapeis().contains(papel))
                papeisDisponiveis.add(papel);
        }
        
        request.getSession().setAttribute("listaPapeisDisponiveis", papeisDisponiveis);


        forward = PERMISSAO;
        
    }
    
    /**
     * Popular informaÃ§Ãµes de usuÃ¡rio
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
     * Salvar informaÃ§Ã£o do usuÃ¡rio
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






