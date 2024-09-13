//Escreva um programa que inverta os caracteres de um string.

//IMPORTANTE:
//a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
//b) Evite usar funções prontas, como, por exemplo, reverse.




fun main() {  
    // Solicita ao usuário que insira uma string  
    println("Digite a string que você deseja inverter:")  

    // Lê a string digitada pelo usuário  
    val originalString = readLine() ?: ""  

    // Chama a função para inverter a string e armazena o resultado  
    val invertedString = reverseString(originalString)  

    // Exibe a string original e a invertida no console  
    println("String original: $originalString")  
    println("String invertida: $invertedString")  
}  

// Função para inverter os caracteres de uma string  
fun reverseString(input: String): String {  
    // Cria um StringBuilder para armazenar os caracteres invertidos  
    val stringBuilder = StringBuilder()  

    // Percorre a string de trás para frente  
    for (i in input.length - 1 downTo 0) {  
        // Adiciona cada caractere ao StringBuilder  
        stringBuilder.append(input[i])  
    }  

    // Converte o StringBuilder de volta para uma String e retorna  
    return stringBuilder.toString()  
}  