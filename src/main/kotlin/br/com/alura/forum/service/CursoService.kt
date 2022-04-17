package br.com.alura.forum.service

import br.com.alura.forum.domain.Curso
import br.com.alura.forum.dtos.CursoResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.ResponseCurso
import br.com.alura.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class CursoService(
    private val repository: CursoRepository,
    private val responseCurso: ResponseCurso,
    private val notFoundMessage: String = "Curso não encontrado!"
) {

    fun listar(): List<CursoResponse> {
        return repository.findAll().stream().map{ c ->
            responseCurso.map(c)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): CursoResponse {
        val c = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return responseCurso.map(c)
    }


}
