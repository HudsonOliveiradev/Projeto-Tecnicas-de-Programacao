package org.example;

import org.example.csv.model.CsvDados;
import org.example.csv.model.FiltroDeDados;
import org.example.csv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LeitorDeArquivoAplication {
    @Autowired
    private CsvService csvService;
    public static void main(String[] args) {
        SpringApplication.run(LeitorDeArquivoAplication.class, args);
    }

    @Bean
    public CommandLineRunner informarDadosParaConsulta () {
        return args -> {
            try {
                Scanner scanner = new Scanner(System.in);
                List<FiltroDeDados> filtro = new ArrayList<>();
                System.out.println("Digite o nome da coluna que deseja consultar:");
                String nomeColuna = scanner.nextLine();

                System.out.println("Nome da coluna" + nomeColuna);

                System.out.println("Digite o valor da coluna que deseja consultar:");
                String valorColuna = scanner.nextLine();

                System.out.println("Valor da coluna" + valorColuna);


                filtro.add(new FiltroDeDados(nomeColuna, valorColuna));

                System.out.println("Filtrando Valor.");

                List<CsvDados> dadosFiltrados = csvService.filtrarDados(csvService.lerDados(), filtro);

                if (dadosFiltrados.isEmpty()){
                    System.out.println("Nenhum registro correspondente!");
                } else {
                    System.out.println("Registros filtrados!");
                    dadosFiltrados.forEach(dado -> System.out.println(dado));
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        };

    }
}