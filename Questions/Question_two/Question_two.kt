fun main() {
    val number = 21
    val belongsToFibonacci = checkIfBelongsToFibonacci(number)
    if (belongsToFibonacci) {
        println("O número $number pertence à sequência de Fibonacci.")
    } else {
        println("O número $number NÃO pertence à sequência de Fibonacci.")
    }
}

fun checkIfBelongsToFibonacci(number: Int): Boolean {
    var previous = 0
    var current = 1
    while (current < number) {
        val next = previous + current
        previous = current
        current = next
    }
    return current == number || number == 0
}
