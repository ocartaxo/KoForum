package br.com.alura.forum.dtos

import java.time.LocalDateTime

data class ErrorResponse(
    val timeStamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
