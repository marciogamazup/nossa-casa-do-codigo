package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/cep/")
interface EnderecoClient {

    @Get     // http://localhost:8081/cep/busca?cep=11111-111
    fun consulta(@QueryValue cep: String) : HttpResponse<EnderecoResponse>
}