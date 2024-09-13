import org.w3c.dom.Document  
import java.io.File  
import javax.xml.parsers.DocumentBuilderFactory  

data class FaturamentoDia(val valor: Double)  

fun main() {  
    // Lê o arquivo XML  
    val xmlFile = File("faturamento.xml")  
    val xmlDoc = loadXML(xmlFile)  

    // Extrai os dias de faturamento  
    val faturamentos = mutableListOf<FaturamentoDia>()  
    val nodeList = xmlDoc.getElementsByTagName("dia")  

    // Adiciona os dias ao faturamento  
    for (i in 0 until nodeList.length) {  
        val valor = nodeList.item(i).textContent.toDouble()  
        faturamentos.add(FaturamentoDia(valor))  
    }  

    // Filtra os valores válidos (ignora dias sem faturamento)  
    val faturamentosFiltrados = faturamentos.map { it.valor }.filter { it > 0 }  

    // Calcula o menor e o maior faturamento  
    val menorFaturamento = faturamentosFiltrados.minOrNull() ?: 0.0  
    val maiorFaturamento = faturamentosFiltrados.maxOrNull() ?: 0.0  

    // Calcula a média, ignorando os dias com faturamento 0  
    val mediaFaturamento = if (faturamentosFiltrados.isNotEmpty()) {  
        faturamentosFiltrados.average()  
    } else {  
        0.0  
    }  

    // Conta os dias que tiveram faturamento acima da média  
    val diasAcimaDaMedia = faturamentosFiltrados.count { it > mediaFaturamento }  

    // Exibe os resultados  
    println("Menor faturamento: R$ $menorFaturamento")  
    println("Maior faturamento: R$ $maiorFaturamento")  
    println("Número de dias com faturamento acima da média mensal: $diasAcimaDaMedia")  
}  

fun loadXML(file: File): Document {  
    val factory = DocumentBuilderFactory.newInstance()  
    val builder = factory.newDocumentBuilder()  
    return builder.parse(file)  
} 