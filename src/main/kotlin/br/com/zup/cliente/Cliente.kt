package br.com.zup.cliente

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Cliente (
    val nome: String,
    val email: String){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id :Long? = null
}