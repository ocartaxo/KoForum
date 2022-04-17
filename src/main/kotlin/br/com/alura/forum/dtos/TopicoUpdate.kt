package br.com.alura.forum.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicoUpdate(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min=5, max=100)
    val titulo: String,
    @field:NotEmpty
    val mensagem: String
)