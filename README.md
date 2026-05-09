# 🌿 Java ML Analyzer - Predictive Dashboard 3.0 (Tested Edition)

Este projeto é uma aplicação de **Ciência de Dados Full-Stack** que integra um motor de Inteligência Artificial desenvolvido em **Java (Spring Boot)** com um dashboard interativo em **JavaScript**. O sistema utiliza o algoritmo **IBk (K-Nearest Neighbors)** para realizar a classificação taxonômica de espécies de plantas em tempo real, com cobertura total de **testes automatizados**.

## 🚀 Diferenciais Técnicos
- **Motor de IA Dinâmico:** KNN (k=3) via Weka Engine para distribuições de probabilidade realistas e precisas.
- **Frontend Reativo:** Interface que traduz cálculos matemáticos complexos em barras de progresso animadas.
- **Resiliência:** Dataset embutido e proteção contra falhas em valores extremos (Boundary Testing).
- **QA & Testing:** Suíte de testes automatizados com **JUnit 5** e **MockMvc**.
- **Operação Linux:** Automação total via scripts Bash para ambientes leves (**Linux Lite**).

## 🧪 Estrutura de Qualidade (Testes)
O projeto conta com uma camada de testes rigorosa para garantir que a IA e a API nunca falhem:
1.  **Integridade de Dados:** Valida a presença e o formato do dataset `iris.arff`.
2.  **Resiliência (Boundary Test):** Garante que a IA processe corretamente valores extremos sem travar o sistema.
3.  **Precisão da IA:** Valida se a predição matemática está correta para casos conhecidos.
4.  **Teste de API (MockMvc):** Simula requisições JSON reais para validar o contrato dos endpoints REST.

## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17 + Spring Boot 3.2.0
- **Testes:** JUnit 5, AssertJ e MockMvc
- **Machine Learning:** Weka Engine (IBk/KNN Algorithm)
- **Frontend:** HTML5, CSS3 Moderno e JavaScript Vanilla
- **Operação:** Maven e Bash Script

## 📋 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com
    cd ml-analyzer
    ```

2.  **Inicie o Sistema de Build e QA Automático:**
    O script `build.sh` preparará o ambiente, compilará o Java e executará os testes. A aplicação só inicia se todos os testes passarem:
    ```bash
    chmod +x build.sh
    ./build.sh
    ```

3.  **Acesse o Dashboard:**
    Abra seu navegador em: `http://localhost:8080`

---

## 📈 Como Usar e Testar

### 1. Inserção de Dados via Interface
Preencha os campos no painel e clique em **ANALISAR AGORA**. As barras mostrarão a confiança da IA:
- **Setosa (Forte):** `5.1 | 3.5 | 1.4 | 0.2`
- **Versicolor (Forte):** `6.4 | 3.2 | 4.5 | 1.5`
- **Transição (Incerteza):** `5.5 | 2.5 | 3.8 | 1.1`

### 2. Inserção de Novos Conhecimentos (Dataset)
Para expandir a inteligência da IA:
1.  Abra o arquivo `src/main/resources/iris.arff`.
2.  Abaixo de `@DATA`, insira novos exemplos: `SépalaComp, SépalaLarg, PétalaComp, PétalaLarg, Classe`.
3.  **Reinicie o Build:** Execute `./build.sh` para que a IA processe os novos dados e os testes validem a nova estrutura.

### 3. Relatório Técnico (Backstage)
Visualize as estatísticas de performance (Matriz de Confusão) em:
`http://localhost:8080/analisar`

---
**Desenvolvido por Renato Mendes**
*Focado em Engenharia de Software, QA e Data Science aplicado.*
