package br.com.zup.cliente

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
class NovoClienteRequest (@field:NotNull @field:NotBlank val nome: String,
                          @field:NotNull @field:NotBlank @field:Email val email: String) {

    fun paraCliente(): Cliente {

        return Cliente(nome, email)
    }
}