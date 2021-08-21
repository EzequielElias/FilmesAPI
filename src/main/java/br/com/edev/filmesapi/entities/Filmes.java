package br.com.edev.filmesapi.entities;


public class Filmes {

    private Integer id;
    private String nome;
    private String diretor;
    private String ano;
    private Integer nota;

    public Filmes(Integer id, String nome, String diretor, String ano, Integer nota) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}