fun main() {  
    println("Digite a string que você deseja inverter:")  
    val originalString = readLine() ?: ""  
    val reversedString = reverseString(originalString)  
    println("String original: $originalString")  
    println("String invertida: $reversedString")  
}  

fun reverseString(input: String): String {  
    val stringBuilder = StringBuilder()  
    
    for (i in input.length - 1 downTo 0) {  
        stringBuilder.append(input[i])  
    }  
    
    return stringBuilder.toString()  
}  
