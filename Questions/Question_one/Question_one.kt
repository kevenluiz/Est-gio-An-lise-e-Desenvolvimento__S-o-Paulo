//Observe o trecho de código abaixo: 
//int INDICE = 13, SOMA = 0, K = 0; 
//Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; } Imprimir(SOMA); 
//Ao final do processamento, qual será o valor da variável SOMA?

fun main() {
    // Definindo o valor do índice
    val indice = 12

    // Chamando a função para calcular a soma e armazenando o resultado
    val resultado = calcularSomaIndice(indice)

    // Imprimindo o resultado final
    println("O valor final da SOMA é: $resultado")
}

// Função que calcula a soma de valores de 1 até o valor do índice
fun calcularSomaIndice(indice: Int): Int {
    // Inicialização das variáveis
    var soma = 0
    var k = 1

    // Loop enquanto k for menor que indice
    while (k < indice) {
        // Incrementa k em 1
        k += 1

        // Adiciona o valor de k à soma
        soma += k
    }

    // Retorna o valor final de soma
    return soma
}