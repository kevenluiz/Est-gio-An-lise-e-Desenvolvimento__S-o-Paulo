fun main() {
    val index = 12 
    val result = calculateSumByIndex(index)  
    println("O valor final da SOMA é: $result")
}

fun calculateSumByIndex(index: Int): Int {
    var sum = 0
    var k = 1
    while (k < index) {
        k += 1 
        sum += k
    }
    return sum
}
