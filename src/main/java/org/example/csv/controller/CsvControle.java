package org.example.csv.controller;

import org.example.csv.model.CsvDados;
import org.example.csv.model.FiltroDeDados;
import org.example.csv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CsvControle {

    @Autowired
    private CsvService csvService;

    @PostMapping("/filtro-csv")
    public ResponseEntity<List<CsvDados>> filtrarCsv(@RequestBody List<FiltroDeDados> filtros) {
        try {
            List<CsvDados> dados = csvService.lerDados();
            List<CsvDados> dadosFiltrados = csvService.filtrarDados(dados, filtros);
            return new ResponseEntity<>(dadosFiltrados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
