package com.projeto.ml.service;

import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import weka.classifiers.lazy.IBk;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.DenseInstance;
import weka.core.converters.ArffLoader;
import java.io.InputStream;
import java.util.*;

@Service
public class DataScienceService {

    private final String nl = System.lineSeparator();

    // Método para o Gráfico (Novo Motor KNN)
    public Map<String, Object> preverUnico(double sl, double sw, double pl, double pw) throws Exception {
        Locale.setDefault(Locale.US);
        ClassPathResource res = new ClassPathResource("iris.arff");
        try (InputStream is = res.getInputStream()) {
            ArffLoader loader = new ArffLoader();
            loader.setSource(is);
            Instances data = loader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);

            IBk knn = new IBk(3); 
            knn.buildClassifier(data);

            double[] valores = new double[] {sl, sw, pl, pw, 0};
            DenseInstance novo = new DenseInstance(1.0, valores);
            novo.setDataset(data);

            double[] dist = knn.distributionForInstance(novo);
            String vencedora = data.classAttribute().value((int) knn.classifyInstance(novo));

            Map<String, Object> resultado = new HashMap<>();
            resultado.put("vencedora", vencedora);
            resultado.put("probabilidades", dist);
            return resultado;
        }
    }

    // Método para o Relatório (Consertando o erro de compilação)
    public String treinarEPrever() throws Exception {
        Locale.setDefault(Locale.US);
        ClassPathResource res = new ClassPathResource("iris.arff");
        try (InputStream is = res.getInputStream()) {
            ArffLoader loader = new ArffLoader();
            loader.setSource(is);
            Instances data = loader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);

            IBk knn = new IBk(3);
            knn.buildClassifier(data);

            Evaluation eval = new Evaluation(data);
            eval.evaluateModel(knn, data);

            return "--- RELATÓRIO TÉCNICO IA ---" + nl + 
                   eval.toSummaryString() + nl + 
                   eval.toMatrixString();
        }
    }
}
