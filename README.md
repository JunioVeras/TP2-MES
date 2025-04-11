# TP2-MES – Correção de Bugs com Modelos de Linguagem

## 🧠 Proposta do Trabalho

Este trabalho tem como objetivo avaliar a capacidade de modelos de linguagem natural (LLMs) em corrigir bugs simples em código-fonte. Para isso, utilizaremos um dataset com exemplos de bugs de uma linha (one-line bugs) e analisaremos a eficácia das correções propostas pela LLM, tanto quantitativamente (execução de testes) quanto qualitativamente (análise das mudanças).

## 👥 Membros

- Júnio Veras de Jesus Lima (SI)
- Ester Sara Assis (CC)
- Filipe (CC)
-

## 🔍 Metodologia

### 🤖 Modelo de Linguagem

A definir. A princípio, será utilizado um modelo LLM com suporte a entrada de código e compreensão semântica (ex: GPT-4, Claude, etc.).

### 🗂️ Dataset

Será utilizado o dataset [**QuixBugs**](https://github.com/jkoppel/QuixBugs), que contém 40 pequenos programas com bugs, implementados em Java e Python. Cada programa possui:

- Uma versão com bug (*buggy*).
- Uma versão corrigida (*corrected*).
- Um conjunto de testes automatizados para validação da correção.

O foco principal do dataset são bugs localizados em poucas linhas, o que facilita o uso com modelos de linguagem. Caso necessário, o conjunto poderá ser expandido via mutação ou geração de novos exemplos. 

### ✍️ Exemplos Preliminares de Prompts

Exemplo:

Corrija o seguinte código com um possível bug:

````
def get_factorial(n):
    if n == 0:
        return 0
    return n * get_factorial(n - 1)
````

### 📏 Avaliação Quantitativa

A avaliação quantitativa será feita a partir da **execução dos testes automatizados** incluídos no QuixBugs. Para cada código corrigido pela LLM, será verificada a proporção de correções que passaram todos os testes.

### 🧪 Avaliação Qualitativa

A avaliação qualitativa será realizada manualmente, inspecionando exemplos de correções:
- Que foram bem-sucedidas mas diferentes da correção original.
- Que passaram nos testes, mas possuem problemas de estilo ou boas práticas.

Essa análise ajudará a compreender as limitações e o comportamento do modelo frente a diferentes tipos de bugs.

---

## 📎 Referências

- [QuixBugs Dataset](https://github.com/jkoppel/QuixBugs)