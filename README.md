# Morse-Code

## Descrição

Projeto Java que implementa um conversor de código Morse utilizando uma Árvore Binária de Busca. O algoritmo segue a heurística padrão do código morse onde pontos (.) são representados à esquerda e traços (-) à direita na árvore.

## Funcionalidades

- **Inserção de caracteres**: Insere caracteres na árvore seguindo a heurística do código morse (ponto à esquerda, traço à direita)
- **Codificação**: Converte texto para código Morse (Texto → Morse)
- **Decodificação**: Converte código Morse para texto (Morse → Texto)
- **Visualização da árvore**: Exibe a estrutura completa da árvore binária de busca no console e na interface gráfica
- **Interface gráfica**: Aplicação JavaFX com interface amigável para conversão

## Estrutura do Projeto

```
├── 📁 java
│   ├── 📁 com
│   │   └── 📁 morsecode
│   │       └── 📁 morsecode
│   │           ├── 📁 controller
│   │           │   ├── ☕ HelloController.java
│   │           │   └── ☕ IncriptionController.java
│   │           ├── 📁 model
│   │           │   ├── ☕ MorseTree.java
│   │           │   ├── ☕ MorseTreeBuilder.java
│   │           │   └── ☕ Node.java
│   │           ├── 📁 template
│   │           │   └── ☕ ApplicationTemplate.java
│   │           ├── 📁 view
│   │           │   ├── ☕ HelloApplication.java
│   │           │   └── ☕ IncriptionView.java
│   │           └── ☕ Launcher.java
│   └── ☕ module-info.java
└── 📁 resources
    ├── 📁 com
    │   └── 📁 morsecode
    │       └── 📁 morsecode
    │           ├── 📄 hello-view.fxml
    │           └── 📄 incription.fxml
    └── 📁 styles
        ├── 🎨 hello-view.css
        ├── 🎨 incription.css
        └── 🎨 style.css
```

## Como usar

### Via Interface Gráfica

1. Execute a aplicação através da classe `Launcher`
2. Digite o texto ou código Morse no campo de entrada
3. Clique em "Criptografar" para converter texto para Morse
4. Clique em "Descriptografar" para converter Morse para texto
5. Clique em "Visualizar Árvore Binária" para ver a estrutura da árvore

### Funcionalidades da Interface

- **Criptografar (Texto → Morse)**: Converte texto comum para código Morse
- **Descriptografar (Morse → Texto)**: Converte código Morse para texto comum
- **Visualizar Árvore Binária**: Exibe a estrutura completa da árvore em um diálogo
- **Decodificar via Input**: Permite decodificar código Morse através de um diálogo de input
- **Limpar Campos**: Limpa os campos de entrada e saída

## Caracteres Suportados

- Letras do alfabeto (A-Z)
- Números (0-9)
- Espaços (representados como '/' no código Morse)

## Tecnologias

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=javafx&logoColor=white)
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
