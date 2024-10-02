import java.util.Scanner;

class Node {
    char caractere; // Caractere do nó
    Node filhoEsquerdo; // Filho à esquerda (ponto)
    Node filhoDireito; // Filho à direita (traço)

    public Node() {
        this.caractere = '\0'; // Inicializa o caractere como vazio
        this.filhoEsquerdo = null; // Inicializa o filho esquerdo como nulo
        this.filhoDireito = null; // Inicializa o filho direito como nulo
    }
}

class ArvoreBinariaMorse {
    Node raiz; // Raiz da árvore

    // Método inicializar
    public void inicializar() {
        raiz = new Node(); // Inicializa a árvore com um novo node raiz
        // Insere os caracteres e seus códigos Morse
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    // Método inserir
    public void inserir(String codigoMorse, char caractere) {
        Node nodeAtual = raiz; // Começa na raiz
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (nodeAtual.filhoEsquerdo == null) {
                    nodeAtual.filhoEsquerdo = new Node();
                }
                nodeAtual = nodeAtual.filhoEsquerdo; // Move para o filho esquerdo
            } else if (simbolo == '-') {
                if (nodeAtual.filhoDireito == null) {
                    nodeAtual.filhoDireito = new Node();
                }
                nodeAtual = nodeAtual.filhoDireito; // Move para o filho direito
            }
        }
        nodeAtual.caractere = caractere; // Define o caractere no node apropriado
    }

    // Método buscar para retornar o código Morse de um caractere
    public String buscarCodigoMorse(char caractere) {
        return buscarCodigoMorseRecursivo(raiz, caractere, "");
    }

    private String buscarCodigoMorseRecursivo(Node node, char caractere, String codigo) {
        if (node == null) {
            return null; // Se o node não existe, retorna null
        }
        if (node.caractere == caractere) {
            return codigo; // Retorna o código Morse se encontrado
        }
        String codigoEsquerdo = buscarCodigoMorseRecursivo(node.filhoEsquerdo, caractere, codigo + ".");
        if (codigoEsquerdo != null) {
            return codigoEsquerdo; // Retorna o código da subárvore esquerda se encontrado
        }
        return buscarCodigoMorseRecursivo(node.filhoDireito, caractere, codigo + "-"); // Busca na subárvore direita
    }

    // Método para buscar o caractere a partir do código Morse
    public String buscarCaracterePorCodigoMorse(String codigoMorse) {
        StringBuilder palavra = new StringBuilder();
        String[] codigos = codigoMorse.trim().split(" "); // Divide o código Morse em palavras

        for (String codigo : codigos) {
            char caractere = buscarCaracterePorCodigoMorseRecursivo(raiz, codigo);
            if (caractere != '\0') {
                palavra.append(caractere); // Adiciona o caractere à palavra
            } else {
                palavra.append("?"); // Para códigos Morse não encontrados
            }
        }
        return palavra.toString();
    }

    private char buscarCaracterePorCodigoMorseRecursivo(Node node, String codigo) {
        if (node == null) {
            return '\0'; // Se o node não existe, retorna vazio
        }
        if (codigo.isEmpty()) {
            return node.caractere; // Retorna o caractere se encontrado
        }
        char simbolo = codigo.charAt(0);
        if (simbolo == '.') {
            return buscarCaracterePorCodigoMorseRecursivo(node.filhoEsquerdo, codigo.substring(1)); // Busca à esquerda
        } else if (simbolo == '-') {
            return buscarCaracterePorCodigoMorseRecursivo(node.filhoDireito, codigo.substring(1)); // Busca à direita
        }
        return '\0'; // Retorna vazio se o código não é válido
    }

// Método para exibir a árvore
public void exibir() {
    if (raiz != null) {
        // Exibe a raiz como ponto inicial
        System.out.println("Raiz");
        exibirRecursivo(raiz, "", true);
    } else {
        System.out.println("Árvore vazia.");
    }
}

// Método recursivo para exibir a árvore de forma visual
private void exibirRecursivo(Node node, String prefixo, boolean isUltimo) {
    if (node != null) {
        // Exibe o nó atual
        if (node.caractere != '\0') {  // Só exibe se o nó tiver um caractere válido
            System.out.println(prefixo + (isUltimo ? "└── " : "├── ") + node.caractere);
        }

        // Ajusta o prefixo para os filhos
        String novoPrefixo = prefixo + (isUltimo ? "    " : "│   ");

        // Verifica se há filhos para exibir
        if (node.filhoEsquerdo != null || node.filhoDireito != null) {
            // Exibe o filho esquerdo
            exibirRecursivo(node.filhoEsquerdo, novoPrefixo, node.filhoDireito == null);
            // Exibe o filho direito
            exibirRecursivo(node.filhoDireito, novoPrefixo, true);
        }
    }
}





    // Método principal para executar o programa
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar(); // Inicializa a árvore

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Menu
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Converter texto para código Morse");
            System.out.println("2. Converter código Morse para texto");
            System.out.println("3. Exibir árvore binária Morse");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    // Opção para conversão de texto para código Morse
                    System.out.print("Digite uma frase (apenas letras e números): ");
                    String frase = scanner.nextLine().toUpperCase();

                    StringBuilder codigoMorseFinal = new StringBuilder();

                    // Converte cada caractere da frase em código Morse
                    for (char caractere : frase.toCharArray()) {
                        if (caractere == ' ') {
                            codigoMorseFinal.append("   "); // Espaço entre palavras
                        } else {
                            String codigoMorse = arvore.buscarCodigoMorse(caractere);
                            if (codigoMorse != null) {
                                codigoMorseFinal.append(codigoMorse).append(" "); // Adiciona o código Morse correspondente
                            } else {
                                codigoMorseFinal.append("? "); // Para caracteres não encontrados
                            }
                        }
                    }

                    // Mostra o resultado da conversão de texto para código Morse
                    System.out.println("Código Morse: " + codigoMorseFinal.toString().trim());
                    break;

                case 2:
                    // Opção para conversão de código Morse para texto
                    System.out.print("Digite um código Morse (separado por espaços): ");
                    String codigoMorseEntrada = scanner.nextLine();
                    String palavraResultado = arvore.buscarCaracterePorCodigoMorse(codigoMorseEntrada);

                    // Mostra o resultado da conversão de código Morse para texto
                    System.out.println("Palavra correspondente: " + palavraResultado);
                    break;

                case 3:
                    // Opção para exibir a árvore binária Morse
                    System.out.println("Exibição da árvore binária Morse:");
                    arvore.exibir();
                    break;

                case 4:
                    System.out.println("Finalizando...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4); // Repete até que a opção de sair seja escolhida

        scanner.close();
    }
}
