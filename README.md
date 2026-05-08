# 🌿 Java ML Analyzer - Predictive Service

[![Documentação](https://shields.io)](https://github.io)

Este projeto demonstra a implementação de uma API de Ciência de Dados de nível profissional utilizando o ecossistema **Java** e **Spring Boot**. O serviço utiliza o algoritmo de Machine Learning **J48 (Árvore de Decisão)** da biblioteca Weka para realizar predições em tempo real.

## 🚀 Diferenciais Técnicos
- **Resiliência:** Dataset embutido nos recursos do JAR, permitindo execução offline e segura.
- **Arquitetura:** Separação clara entre camadas de serviço, DTO e Controller.
- **Operação Linux:** Script de automação (`build.sh`) que gerencia dependências, limpa portas de rede e executa a aplicação.
- **Performance:** Otimizado para rodar em ambientes de baixo consumo de recursos (Linux Lite).

## 🛠️ Tecnologias
- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3.2.0
- **Engine de ML:** Weka (Waikato Environment for Knowledge Analysis)
- **Gerenciador de Dependências:** Maven

## 📋 Como Executar (Ambiente Linux)

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com
    cd ml-analyzer
    ```

2.  **Execute o Script de Build Automático:**
    O script irá instalar o Maven (se necessário), baixar as libs, limpar a porta 8080 e iniciar o JAR.
    ```bash
    chmod +x build.sh
    ./build.sh
    ```

---

## 🧪 Como Testar a IA

Após a aplicação iniciar (`Started FraudeAnalyzerApplication`), você pode interagir com o modelo preditivo das seguintes formas:

### 1. Visualizar a Inteligência do Modelo
Acesse no seu navegador ou via GET para ver a árvore de decisão e as estatísticas de acerto (Matriz de Confusão):
- **URL:** `http://localhost:8080/analisar`

### 2. Realizar Predição em Tempo Real (via Terminal)
Abra um novo terminal e envie dados via JSON para a IA classificar a espécie de flor instantaneamente.

**Comando de Teste:**
```bash
curl -X POST http://localhost:8080/prever \
-H "Content-Type: application/json" \
-d '{
  "sepallength": 5.1, 
  "sepalwidth": 3.5, 
  "petallength": 1.4, 
  "petalwidth": 0.2
}'
```

**Resposta esperada:**
```json
{
  "status": "sucesso",
  "ia_output": "Iris-setosa",
  "model": "J48 Decision Tree"
}
```

---
Desenvolvido por **Renato Mendes** para fins de portfólio em Engenharia de Dados e Backend Java.
