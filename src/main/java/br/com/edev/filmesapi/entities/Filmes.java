package br.com.edev.filmesapi.entities;

public class Filmes {

private String nomeFilme;
private Integer idFilme;
private String nomeDiretor;
private String dataLancamento;
private Integer notaFilme;

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Filmes(String nomeFilme, Integer idFilme, String nomeDiretor, String dataLancamento, Integer notaFilme) {
        this.nomeFilme = nomeFilme;
        this.idFilme = idFilme;
        this.nomeDiretor = nomeDiretor;
        this.dataLancamento = dataLancamento;
        this.notaFilme = notaFilme;
    }

    public Integer getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(Integer notaFilme) {
        this.notaFilme = notaFilme;
    }

}
