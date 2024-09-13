import org.w3c.dom.Document  
import java.io.File  
import javax.xml.parsers.DocumentBuilderFactory  

data class BillingDay(val value: Double)  

fun main() {  
    val xmlFile = File("faturamento.xml")  
    val xmlDoc = loadXML(xmlFile)  
    val billings = mutableListOf<BillingDay>()  
    val nodeList = xmlDoc.getElementsByTagName("dia")  

    for (i in 0 until nodeList.length) {  
        val value = nodeList.item(i).textContent.toDouble()  
        billings.add(BillingDay(value))  
    }  

    val filteredBillings = billings.map { it.value }.filter { it > 0 }  
    val minBilling = filteredBillings.minOrNull() ?: 0.0  
    val maxBilling = filteredBillings.maxOrNull() ?: 0.0      
    val averageBilling = if (filteredBillings.isNotEmpty()) {  
        filteredBillings.average()  
    } else {  
        0.0  
    }  

    val daysAboveAverage = filteredBillings.count { it > averageBilling }    
    println("Menor faturamento: R$ $minBilling")  
    println("Maior faturamento: R$ $maxBilling")  
    println("Número de dias com faturamento acima da média mensal: $daysAboveAverage")  
}  

fun loadXML(file: File): Document {  
    val factory = DocumentBuilderFactory.newInstance()  
    val builder = factory.newDocumentBuilder()  
    return builder.parse(file)  
}
