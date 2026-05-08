# 🌿 Java ML Analyzer - Predictive Dashboard 3.0

Este projeto é uma aplicação de **Ciência de Dados Full-Stack** que integra um motor de Inteligência Artificial desenvolvido em **Java** com um dashboard interativo em **JavaScript**. O sistema utiliza o algoritmo **IBk (K-Nearest Neighbors)** para realizar a classificação taxonômica de espécies de plantas em tempo real.

## 🚀 Diferenciais do Projeto
- **Motor de IA Dinâmico:** Implementação do algoritmo **KNN (k=3)** via biblioteca Weka, permitindo distribuições de probabilidade realistas.
- **Frontend Reativo:** Interface que traduz cálculos matemáticos complexos em barras de progresso animadas.
- **Resiliência:** Execução 100% offline com dataset embutido nos recursos do JAR.
- **Arquitetura Profissional:** Separação de responsabilidades (Controller, Service, DTO, Datalayer).
- **Operação Linux:** Automação total via scripts Bash para ambientes de baixo consumo (Linux Lite).

## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17 + Spring Boot 3.2.0
- **Machine Learning:** Weka Engine (IBk/KNN Algorithm)
- **Frontend:** HTML5, CSS3 Moderno e JavaScript Vanilla
- **Operação:** Maven, Bash Script e Git

## 📋 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com
    cd ml-analyzer
    ```

2.  **Inicie o Sistema de Build Automático:**
    O script `build.sh` preparará o ambiente, compilará o Java e iniciará o servidor:
    ```bash
    chmod +x build.sh
    ./build.sh
    ```

3.  **Acesse o Dashboard:**
    Abra seu navegador e acesse: `http://localhost:8080`

---

## 📈 Como Usar e Testar

### 1. Inserção de Dados via Interface (Dashboard)
Preencha os campos numéricos no painel lateral e clique em **ANALISAR AGORA**. As barras de probabilidade mostrarão o nível de "certeza" da IA:

- **Teste Setosa (Forte):** `5.1 | 3.5 | 1.4 | 0.2` (Barra Verde 100%)
- **Teste Versicolor (Forte):** `6.4 | 3.2 | 4.5 | 1.5` (Barra Amarela 100%)
- **Teste Transição (Incerteza):** `5.5 | 2.5 | 3.8 | 1.1` (Distribuição entre barras)

### 2. Inserção de Novos Conhecimentos (Dataset)
Para ensinar novos padrões à IA, você pode expandir a base de dados local:

1.  Abra o arquivo `src/main/resources/iris.arff` no seu editor.
2.  Localize a seção abaixo de `@DATA`.
3.  Insira uma nova linha seguindo o padrão: `SépalaComp, SépalaLarg, PétalaComp, PétalaLarg, Classe`.
    *Exemplo:* `4.8,3.1,1.6,0.2,Iris-setosa`
4.  **Importante:** Após alterar o arquivo, você deve rodar o `./build.sh` novamente para que a IA aprenda os novos dados.

### 3. Relatório Técnico (Backstage)
Para visualizar as estatísticas detalhadas de performance da IA (Matriz de Confusão e Precisão):
- Acesse: `http://localhost:8080/analisar`

---

## 🔧 Estrutura de Pastas
- `src/main/java`: Código fonte Java (Spring/ML).
- `src/main/resources/static`: Frontend (HTML/CSS/JS).
- `src/main/resources/iris.arff`: Base de conhecimento da IA.
- `build.sh`: Automação de infraestrutura local.
- `github-deploy.sh`: Pipeline de deploy para o GitHub.

---
**Desenvolvido por Renato Mendes**
*Focado em Engenharia de Software e Data Science aplicado.*
