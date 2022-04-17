package br.com.alura.forum.dtos

import br.com.alura.forum.domain.StatusTopico
import java.time.LocalDateTime

data class TopicoResponse(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)

data class RespotaTopicoResponse(
    val id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val idAutor: Long?,
    val solucao: Boolean
)