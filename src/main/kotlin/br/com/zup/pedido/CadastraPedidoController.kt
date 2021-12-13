package br.com.zup.pedido

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/pedidos")
class CadastraPedidoController {

    @Post
    fun cadastra (@Body @Valid request: NovoPedidoRequest) :MutableHttpResponse<Any>?{

        println("Requisição ==> ${request}")
//        val pedido = request.paraPedido()
        println("Requisicao ==> ${request}")

//        return HttpResponse.ok(pedido)
        return HttpResponse.ok()
    }
}