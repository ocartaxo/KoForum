package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class TopicoRequest(
    @field:NotEmpty(message = "Título não pode estar em branco!")
    @Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres!")
    val titulo: String,
    @field:NotEmpty(message = "Mensagem não pode estar em branco!")
    val mensagem: String,
    @field:NotNull(message = "idCurso não pode ser nulo!")
    val idCurso: Long,
    @field:NotNull(message = "idAutor não pode ser nulo!")
    val idAutor: Long
)