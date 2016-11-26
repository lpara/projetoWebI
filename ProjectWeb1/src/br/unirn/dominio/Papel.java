package br.unirn.dominio;


import java.util.ArrayList;
import java.util.List;


public class Papel {


    private int codigo;
    
    private String nome;
    
    private String descricao;
    


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<String> validar() {
        List<String> erros = new ArrayList<>();
        if (nome.isEmpty())
            erros.add("Nome nÃ£o informado.<br/>");
        if (codigo == 0)
            erros.add("CÃ³digo nÃ£o informado.<br/>");
        if (descricao == null || descricao.isEmpty())
            erros.add("DescriÃ§Ã£o nÃ£o informado.<br/>");
        return erros;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Papel other = (Papel) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }


    
    


}






