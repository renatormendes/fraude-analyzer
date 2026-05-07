package com.projeto.ml;

import com.projeto.ml.service.DataScienceService;
import com.projeto.ml.dto.IrisRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@SpringBootApplication
@RestController
public class FraudeAnalyzerApplication {

    private final DataScienceService dsService;

    public FraudeAnalyzerApplication(DataScienceService dsService) {
        this.dsService = dsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FraudeAnalyzerApplication.class, args);
    }

    // Endpoint para ver a árvore e estatísticas (Linha por linha)
    @GetMapping(value = "/analisar", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public String rodarAnalise() throws Exception {
        return dsService.treinarEPrever();
    }

    // Endpoint para predição via JSON (Para o comando curl)
    @PostMapping(value = "/prever", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String prever(@RequestBody IrisRequest request) throws Exception {
        return dsService.preverUnico(
            request.sepallength(), request.sepalwidth(), 
            request.petallength(), request.petalwidth()
        );
    }
}
