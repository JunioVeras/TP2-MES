# TP2-MES – Análise de Correção de Bugs com Modelos de Linguagem

## 🧠 Proposta do Trabalho

Este trabalho tem como objetivo avaliar a capacidade de modelos de linguagem natural (LLMs) em corrigir bugs simples em código-fonte. Para isso, utilizaremos um dataset com exemplos de bugs de uma linha (one-line bugs) e analisaremos a eficácia das correções propostas pela LLM, tanto quantitativamente (execução de testes) quanto qualitativamente (análise das mudanças).

## 👥 Membros

- Júnio Veras de Jesus Lima (SI)
- Ester Sara Assis (CC)
- Filipe Pirola (CC)
- Igor Eduardo Braga (CC)

## 🔍 Metodologia

### 🤖 Modelo de Linguagem

Neste projeto, utilizaremos dois modelos de linguagem open source: LLaMA e DeepSeek, ambos amplamente adotados na comunidade de inteligência artificial e disponíveis na plataforma Hugging Face. A Hugging Face é uma plataforma amplamente usada na área de inteligência artificial para disponibilizar e compartilhar modelos de machine learning de forma acessível e padronizada.

### 🗂️ Dataset

Será utilizado o dataset [**QuixBugs**](https://github.com/jkoppel/QuixBugs), que contém 40 pequenos programas com bugs, implementados em Java e Python. Cada programa possui:

- Uma versão com bug (*buggy*).
- Uma versão corrigida (*corrected*).
- Um conjunto de testes automatizados para validação da correção.

O foco principal do dataset são bugs localizados em poucas linhas, o que facilita o uso com modelos de linguagem. Caso necessário, o conjunto poderá ser expandido via mutação ou geração de novos exemplos. 

### ✍️ Exemplos Preliminares de Prompts

Exemplo de primeiro prompt ingênuo, definido no padrão comum de LLMs com modelos disponíveis no HuggingFace. Pode ter seu formato alterado se o modelo requerir. 

````
[
  {
    "role": "system",
    "content": "You are a helpful AI programming assistant. When the user sends you a piece of code that contains a bug, your job is to return the corrected version of the code. "
  },
  {
    "role": "user",
    "content": "def add_numbers(a, b):\n    return a + b\n\nprint(add_numbers(2))"
  }
]
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
- [HuggingFace](https://huggingface.co/)
