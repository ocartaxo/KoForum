package br.com.alura.forum.service

import br.com.alura.forum.dtos.UsuarioResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.UsuarioMapper
import br.com.alura.forum.repository.UsuarioRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val notFoundMessage: String = "Usuário não encontrado!"
) {

    private val mapper = Mappers.getMapper(UsuarioMapper::class.java)

    fun listar(): List<UsuarioResponse> {
        return repository.findAll().stream().map { u ->
            mapper.map(u)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): UsuarioResponse {
        val u = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return mapper.map(u)
    }

}
