package com.projeto.ml;

import com.projeto.ml.service.DataScienceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc // Habilita o teste de API (MockMvc)
class DataScienceServiceTest {

    @Autowired
    private DataScienceService dsService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("1. Teste de Integridade: Verificar se o dataset ARFF existe")
    void deveVerificarExistenciaDoDataset() {
        ClassPathResource res = new ClassPathResource("iris.arff");
        assertTrue(res.exists(), "O arquivo iris.arff deve estar na pasta resources!");
    }

    @Test
    @DisplayName("2. Teste de Resiliência: Valores extremos (Boundary Test)")
    void deveLidarComValoresExtremos() throws Exception {
        // Testando com valores absurdamente altos
        Map<String, Object> resultado = dsService.preverUnico(99.9, 99.9, 99.9, 99.9);
        
        assertNotNull(resultado);
        assertTrue(resultado.containsKey("vencedora"));
        // Garante que o KNN retornou uma das 3 classes mesmo com dados estranhos
        String v = (String) resultado.get("vencedora");
        assertTrue(v.contains("Iris-"), "A IA deve retornar uma classe válida mesmo com extremos");
    }

    @Test
    @DisplayName("3. Teste de API: Validar endpoint /prever via JSON")
    void deveValidarEndpointPrever() throws Exception {
        String jsonRequest = "{\"sepallength\":5.1,\"sepalwidth\":3.5,\"petallength\":1.4,\"petalwidth\":0.2}";

        mockMvc.perform(post("/prever")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vencedora").value("Iris-setosa"))
                .andExpect(jsonPath("$.probabilidades").isArray());
    }

    @Test
    @DisplayName("4. Teste de Predição: Validar lógica da IA")
    void devePreverSetosaCorretamente() throws Exception {
        Map<String, Object> resultado = dsService.preverUnico(5.1, 3.5, 1.4, 0.2);
        assertEquals("Iris-setosa", resultado.get("vencedora"));
    }
}