package br.com.zup.pedido

import br.com.zup.cliente.Cliente
import br.com.zup.item.ItemDePedido
import java.math.BigDecimal
import javax.persistence.*

@Entity
class Pedido (
    @ManyToOne
    val cliente: Cliente,
    val total: BigDecimal,
    @OneToMany
    val itens: List<ItemDePedido>
    ) {
    @Id
    @GeneratedValue
    var id:Long?=null

    fun achaTotal(itens: List<ItemDePedido>):BigDecimal{

        val listaPreco:List<BigDecimal> = itens.map { a -> a.preco }

        val soma = listaPreco.fold(BigDecimal.ZERO, BigDecimal::add);
        return soma;
    }
}