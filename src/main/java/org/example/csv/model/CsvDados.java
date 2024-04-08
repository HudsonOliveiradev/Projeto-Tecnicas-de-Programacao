package org.example.csv.model;

import java.util.Map;

public class CsvDados {

    private Map<String, String> valor;

    public CsvDados(Map<String, String> valor) {
        this.valor = valor;
    }

    public String get(String colunaNome) {
        return valor.get(colunaNome);
    }

    @Override
    public String toString() {
        return valor.toString();
    }

}

