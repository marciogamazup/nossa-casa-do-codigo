package br.com.zup.autores

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Autor (
    @Column(nullable = false) val nome: String,
    @Column(nullable = false) val email: String,
    @Column(nullable = false) var descricao: String,
    @field:Embedded val endereco: Endereco) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null

    val criadoEm: LocalDateTime = LocalDateTime.now()

}