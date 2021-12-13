package br.com.zup.item

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
class NovoItemRequest (@field:NotNull @field:NotBlank val codigo: String,
                       @field:NotNull @field:Positive val preco: BigDecimal,
                       @field:NotNull @field:Positive val quantidade: Int) {

    fun paraNovoItem(): ItemDePedido {
        return ItemDePedido(codigo, preco, quantidade)
    }
}