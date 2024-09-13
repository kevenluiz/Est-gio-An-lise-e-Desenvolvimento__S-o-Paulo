fun main() {  
    val revenueByState = mapOf(  
        "SP" to 67836.43,  
        "RJ" to 36678.66,  
        "MG" to 29229.88,  
        "ES" to 27165.48,  
        "Outros" to 19849.53  
    )     
    val totalRevenue = revenueByState.values.sum()    
    println("Faturamento total: R$%.2f".format(totalRevenue))  
    println("Percentual de representação por estado:")  
    for ((state, revenue) in revenueByState) {  
        val percentage = (revenue / totalRevenue) * 100  
        println("$state: %.2f%%".format(percentage))  
    }  
}  
