package com.projeto.ml.service;

import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import java.io.InputStream;

@Service
public class DataScienceService {

    private final String nl = System.lineSeparator();

    public String treinarEPrever() throws Exception {
        ClassPathResource res = new ClassPathResource("iris.arff");
        try (InputStream is = res.getInputStream()) {
            ArffLoader loader = new ArffLoader();
            loader.setSource(is);
            Instances data = loader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);

            // Treino
            J48 tree = new J48();
            tree.buildClassifier(data);

            // Estatísticas (Evaluation)
            Evaluation eval = new Evaluation(data);
            eval.evaluateModel(tree, data);

            StringBuilder sb = new StringBuilder();
            sb.append("==========================================").append(nl);
            sb.append("   RELATÓRIO DE CIÊNCIA DE DADOS (IA)    ").append(nl);
            sb.append("==========================================").append(nl).append(nl);
            sb.append("ESTRUTURA DO MODELO:").append(nl);
            sb.append(tree.toString()).append(nl);
            sb.append("ESTATÍSTICAS DE PERFORMANCE:").append(nl);
            sb.append(eval.toSummaryString("Resumo:", false)).append(nl);
            sb.append("MATRIZ DE CONFUSÃO:").append(nl);
            sb.append(eval.toMatrixString()).append(nl);
            sb.append("==========================================");
            
            return sb.toString();
        }
    }

    public String preverUnico(double sl, double sw, double pl, double pw) throws Exception {
        ClassPathResource res = new ClassPathResource("iris.arff");
        try (InputStream is = res.getInputStream()) {
            ArffLoader loader = new ArffLoader();
            loader.setSource(is);
            Instances data = loader.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);

            J48 tree = new J48();
            tree.buildClassifier(data);

            weka.core.Instance novo = new weka.core.DenseInstance(5);
            novo.setDataset(data);
            novo.setValue(0, sl);
            novo.setValue(1, sw);
            novo.setValue(2, pl);
            novo.setValue(3, pw);

            double resClass = tree.classifyInstance(novo);
            String especie = data.classAttribute().value((int) resClass);

            return String.format(
                "{%s  \"status\": \"sucesso\",%s  \"ia_output\": \"%s\",%s  \"model\": \"J48 Decision Tree\"%s}",
                nl, nl, especie, nl, nl
            );
        }
    }
}
