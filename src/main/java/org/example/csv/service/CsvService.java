package org.example.csv.service;

import com.opencsv.CSVReaderHeaderAware;
import org.example.csv.model.CsvDados;
import org.example.csv.model.FiltroDeDados;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CsvService {
    private final String CSV_PATH = "/C:/Users/55849/Documents/teste.csv";

    public List<CsvDados> lerDados(){
        List<CsvDados> dados = new ArrayList<>();

        try {
            CSVReaderHeaderAware leitura = new CSVReaderHeaderAware(new FileReader(CSV_PATH));
            Map<String, String> valorMap;
            while ((valorMap = leitura.readMap()) != null) {
                dados.add(new CsvDados(valorMap));

            }
            return dados;

        }catch(Exception e){
            throw new RuntimeException("Falha ao processar o arquivo!", e);

        }
    }
    public List<CsvDados> filtrarDados(List<CsvDados> dados, List<FiltroDeDados> filtroCampo ){
        for (FiltroDeDados filtro : filtroCampo){
            dados.removeIf(dado -> !dadosMatchesFilter(dado, filtro));

        }
        return dados;

    }
    private boolean dadosMatchesFilter(CsvDados dado, FiltroDeDados filtro){
        String valorAtual = dado.get(filtro.getNomeDaColuna());
        return valorAtual != null && valorAtual.equals(filtro.getValorDaColuna());

    }

}
