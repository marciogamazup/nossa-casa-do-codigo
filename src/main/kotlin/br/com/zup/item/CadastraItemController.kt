package br.com.zup.item

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/itens")
class CadastraItemController {

    @Post
    fun cadastra(@Body @Valid request: NovoItemRequest) : MutableHttpResponse<Any>?  {

        println(request)
        return HttpResponse.ok(request)
    }
}