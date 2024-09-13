//Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
//• SP – R$67.836,43
//• RJ – R$36.678,66
//• MG – R$29.229,88
//• ES – R$27.165,48
//• Outros – R$19.849,53

//Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.



fun main() {  
    // Faturamento mensal por estado em formato de Map  
    val faturamentoPorEstado = mapOf(  
        "SP" to 67836.43,  
        "RJ" to 36678.66,  
        "MG" to 29229.88,  
        "ES" to 27165.48,  
        "Outros" to 19849.53  
    )  

    // Cálculo do faturamento total  
    val faturamentoTotal = faturamentoPorEstado.values.sum()  

    // Exibindo o faturamento total  
    println("Faturamento total: R$%.2f".format(faturamentoTotal))  

    // Calculando e exibindo o percentual de representação de cada estado  
    println("Percentual de representação por estado:")  
    for ((estado, faturamento) in faturamentoPorEstado) {  
        val percentual = (faturamento / faturamentoTotal) * 100  
        println("$estado: %.2f%%".format(percentual))  
    }  
} 