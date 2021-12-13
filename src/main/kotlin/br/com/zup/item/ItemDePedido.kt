package br.com.zup.item

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ItemDePedido(
    val codigo: String,
    val preco: BigDecimal,
    val quantidade: Int){

    @Id
    @GeneratedValue
    var id:Long?=null

    fun achaTotal(itens: List<ItemDePedido>):BigDecimal{

        val listaPreco:List<BigDecimal> = itens.map { a -> a.preco }

        val soma = listaPreco.fold(BigDecimal.ZERO, BigDecimal::add);
        return soma;
    }
}
