Visão Geral
A classe ArvoreBinariaMorse implementa uma árvore binária que mapeia caracteres alfabéticos e numéricos para seus respectivos códigos Morse. Ela permite que os usuários convertam texto para código Morse e vice-versa, além de exibir a estrutura da árvore.

Estruturas de Dados
Node
Representa um nó na árvore binária. Cada nó contém:

caractere: o caractere armazenado no nó.
filhoEsquerdo: referência ao filho esquerdo (representa o ponto).
filhoDireito: referência ao filho direito (representa o traço).
Métodos Principais
inicializar()
Inicializa a árvore binária, inserindo os caracteres de A a Z e de 0 a 9 com seus respectivos códigos Morse.

inserir(String codigoMorse, char caractere)
Insere um novo caractere na árvore de acordo com seu código Morse.

buscarCodigoMorse(char caractere)
Retorna o código Morse correspondente ao caractere fornecido.

buscarCaracterePorCodigoMorse(String codigoMorse)
Retorna a palavra correspondente ao código Morse fornecido.

exibir()
Exibe a estrutura da árvore binária de forma hierárquica.

Métodos Internos
buscarCodigoMorseRecursivo(Node node, char caractere, String codigo)
Método auxiliar que busca recursivamente na árvore o código Morse de um caractere.

buscarCaracterePorCodigoMorseRecursivo(Node node, String codigo)
Método auxiliar que busca recursivamente na árvore o caractere correspondente a um código Morse.

Método Principal
main(String[] args)
Ponto de entrada do programa. Inicializa a árvore, exibe o menu de opções e gerencia a interação com o usuário. Permite:

Conversão de texto para código Morse.
Conversão de código Morse para texto.
Exibir a estrutura da árvore binária Morse.
Sair do programa.
Uso
Executar o Programa
Ao executar o programa, a árvore binária é inicializada e a estrutura é exibida.

Selecionar Opção
O usuário é apresentado a um menu onde pode escolher entre as opções disponíveis:

Converter texto para código Morse.
Converter código Morse para texto.
Exibir árvore binária Morse.
Sair do programa.
Interação
O programa lê a entrada do usuário, processa a conversão e exibe os resultados.

Exemplo de Uso
Para converter a frase "HELLO":

O usuário escolhe a opção 1 e insere "HELLO".
O programa exibe o código Morse correspondente.
Para converter o código Morse ".... . .-.. .-.. ---":

O usuário escolhe a opção 2 e insere ".... . .-.. .-.. ---".
O programa exibe a palavra correspondente, que é "HELLO".
Para exibir a árvore binária Morse:

O usuário escolhe a opção 3.
O programa exibe a estrutura da árvore de forma hierárquica.
