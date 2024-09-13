import org.w3c.dom.Document  
import java.io.File  
import javax.xml.parsers.DocumentBuilderFactory  

data class FaturamentoDia(val valor: Double)  

fun main() {  
      
    val xmlFile = File("faturamento.xml")  
    val xmlDoc = loadXML(xmlFile)  

     
    val faturamentos = mutableListOf<FaturamentoDia>()  
    val nodeList = xmlDoc.getElementsByTagName("dia")  

     
    for (i in 0 until nodeList.length) {  
        val valor = nodeList.item(i).textContent.toDouble()  
        faturamentos.add(FaturamentoDia(valor))  
    }  

     
    val faturamentosFiltrados = faturamentos.map { it.valor }.filter { it > 0 }  

     
    val menorFaturamento = faturamentosFiltrados.minOrNull() ?: 0.0  
    val maiorFaturamento = faturamentosFiltrados.maxOrNull() ?: 0.0  

      
    val mediaFaturamento = if (faturamentosFiltrados.isNotEmpty()) {  
        faturamentosFiltrados.average()  
    } else {  
        0.0  
    }  

     
    val diasAcimaDaMedia = faturamentosFiltrados.count { it > mediaFaturamento }  

      
    println("Menor faturamento: R$ $menorFaturamento")  
    println("Maior faturamento: R$ $maiorFaturamento")  
    println("Número de dias com faturamento acima da média mensal: $diasAcimaDaMedia")  
}  

fun loadXML(file: File): Document {  
    val factory = DocumentBuilderFactory.newInstance()  
    val builder = factory.newDocumentBuilder()  
    return builder.parse(file)  
} 