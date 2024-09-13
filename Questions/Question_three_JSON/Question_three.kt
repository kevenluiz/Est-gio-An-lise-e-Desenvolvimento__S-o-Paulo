import com.google.gson.Gson  
import com.google.gson.JsonObject  
import com.google.gson.reflect.TypeToken  
import java.io.File  

// Data class para representar o faturamento de um único dia  
data class FaturamentoDia(val dia: Int, val valor: Double)  

// Função que lê o conteúdo JSON e retorna uma lista de FaturamentoDia  
fun carregarFaturamento(jsonFile: String): List<FaturamentoDia> {  
    // Lê o arquivo JSON  
    val jsonContent = File(jsonFile).readText()  
    
    // Cria uma instância do Gson para deserialização  
    val gson = Gson()  
    
    // Deserializa o conteúdo JSON em um JsonObject  
    val jsonObject = gson.fromJson(jsonContent, JsonObject::class.java)  
    
    // Obtém a lista de faturamento dentro do objeto  
    val tipo = object : TypeToken<List<FaturamentoDia>>() {}.type  
    return gson.fromJson(jsonObject["faturamento"], tipo)  
}  

// Função principal  
fun main() {  
    try {  
        // Chama a função para carregar o faturamento a partir do arquivo JSON  
        val faturamentos = carregarFaturamento("faturamento.json")  

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
        
    } catch (e: Exception) {  
        // Tratamento de erro caso algo ocorra durante o carregamento ou processamento  
        println("Erro ao processar o arquivo: ${e.message}")  
    }  
}