package br.com.alura.forum.service

import br.com.alura.forum.dtos.CursoResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.CursoMapper
import br.com.alura.forum.repository.CursoRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CursoService(
    private val repository: CursoRepository,
    private val notFoundMessage: String = "Curso não encontrado!"
) {

    private val mapper = Mappers.getMapper(CursoMapper::class.java)

    fun listar(): List<CursoResponse> {
        return repository.findAll().stream().map{ c ->
            mapper.map(c)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): CursoResponse {
        val c = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return mapper.map(c)
    }


}
