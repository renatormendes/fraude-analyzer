package com.projeto.ml;

import com.projeto.ml.service.DataScienceService;
import com.projeto.ml.dto.IrisRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class FraudeAnalyzerApplication {

    private final DataScienceService dsService;

    public FraudeAnalyzerApplication(DataScienceService dsService) {
        this.dsService = dsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FraudeAnalyzerApplication.class, args);
    }

    @GetMapping(value = "/analisar", produces = MediaType.TEXT_PLAIN_VALUE)
    public String rodarAnalise() throws Exception {
        return dsService.treinarEPrever();
    }

    @PostMapping(value = "/prever", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object prever(@RequestBody IrisRequest request) throws Exception {
        return dsService.preverUnico(
            request.getSepallength(), request.getSepalwidth(), 
            request.getPetallength(), request.getPetalwidth()
        );
    }
}
