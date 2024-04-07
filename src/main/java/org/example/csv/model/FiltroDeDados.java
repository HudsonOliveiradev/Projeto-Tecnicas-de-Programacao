package org.example.csv.model;

import java.util.Date;

public class FiltroDeDados {
    private String nomeDaColuna;
    private String valorDaColuna;

    public FiltroDeDados(String nomeColuna, String valorColuna) {
        this.nomeDaColuna = nomeColuna;
        this.valorDaColuna = valorColuna;
    }

    public String getNomeDaColuna() {
        return nomeDaColuna;
    }

    public void setNomeDaColuna(String nomeDaColuna) {
        this.nomeDaColuna = nomeDaColuna;
    }

    public String getValorDaColuna() {
        return valorDaColuna;
    }

    public void setValorDaColuna(String valorDaColuna) {
        this.valorDaColuna = valorDaColuna;
    }

}
