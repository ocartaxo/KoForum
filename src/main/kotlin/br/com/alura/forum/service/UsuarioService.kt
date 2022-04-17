package br.com.alura.forum.service

import br.com.alura.forum.dtos.UsuarioResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.ResponseUsuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val responseUsuario: ResponseUsuario,
    private val notFoundMessage: String = "Usuário não encontrado!"
) {


    fun listar(): List<UsuarioResponse> {
        return repository.findAll().stream().map { u ->
            responseUsuario.map(u)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): UsuarioResponse {
        val u = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return responseUsuario.map(u)
    }

}
