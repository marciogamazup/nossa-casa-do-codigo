package br.com.zup.autores

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@MicronautTest
internal class BuscaAutoresControllerTest {

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    lateinit var autor: Autor

    @BeforeEach
    internal fun setup() {

        val enderecoResponse = EnderecoResponse("Rua das Laranjeiras", "Rio de Janeiro", "RJ")
        val endereco = Endereco(enderecoResponse, "11222-333", "37")
        autor = Autor("Rafael Ponte", "rafael.ponte@zup.com.br", "Maraja dos legados", endereco)

        autorRepository.save(autor)
    }

    @AfterEach
    internal fun tearDown() {
        autorRepository.deleteAll()
    }

    @Test
    internal fun deveRetornarOsDetalhesDeUmAutor() {

        val enderecoResponse = EnderecoResponse("Rua das Laanjeiras", "Rio de Janeiro", "RJ")
        val endereco = Endereco(enderecoResponse, "11111-111", "28")
        val autor = Autor("Rafael Ponte", "rafael.ponte@zup.com.br", "Maraja dos Legados", endereco)

        val  response = client.toBlocking().exchange("/autores?email=${autor.email}",DetalhesDoAutorResponse::class.java)

        assertEquals(HttpStatus.OK, response.status )
        assertNotNull(response.body())
        assertEquals(autor.nome, response.body()!!.nome)  // colocamos !! para garantir que o Autor não será nulo
        assertEquals(autor.email, response.body()!!.email)  // colocamos !! para garantir que o Autor não será nulo
        assertEquals(autor.descricao, response.body()!!.descricao)  // colocamos !! para garantir que o Autor não será nulo

    }
}