package br.com.zup.pedido

import br.com.zup.cliente.Cliente
import br.com.zup.cliente.NovoClienteRequest
import br.com.zup.item.ItemDePedido
import br.com.zup.item.NovoItemRequest
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.*

@Introspected
class NovoPedidoRequest (@field:NotNull @field:NotBlank val nomeCliente: String,
                         @field:NotNull @field:NotBlank @field:Email val emailCliente: String,
                         @field:NotNull val itens: List<NovoItemRequest>) {

    val itemDePedido: List<ItemDePedido> = mutableListOf()




//    fun paraPedido(): Pedido {
//
//        val  novoCliente :Cliente = Cliente(  )
//
//        return Pedido(novoCliente, total, itensPedido)
//    }

}