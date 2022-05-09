package br.com.alura.forum.service

import br.com.alura.forum.dtos.TopicoRequest
import br.com.alura.forum.dtos.TopicoResponse
import br.com.alura.forum.dtos.TopicoUpdate
import br.com.alura.forum.domain.Topico
import br.com.alura.forum.dtos.RespostaTopicoResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoMapper
import br.com.alura.forum.repository.TopicoRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val notFoundMessage: String = "Tópico não encontrado!"
) {

    private val mapper = Mappers.getMapper(TopicoMapper::class.java)

    fun listar(): List<TopicoResponse> {

        return repository.findAll().stream().map { t ->
            mapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscaPorId(id: Long): TopicoResponse {
        val t = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return mapper.map(t)
    }

    fun cadastrar(t: TopicoRequest): TopicoResponse {
        val topico: Topico = mapper.map(t)
        repository.save(topico)
        return mapper.map(topico)
    }

    fun atualizar(t: TopicoUpdate): TopicoResponse {
        val topico = repository.findById(t.id).orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = t.titulo
        topico.mensagem = t.mensagem

        return mapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun buscaRespostas(id: Long): List<RespostaTopicoResponse> {
        val respostas = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }.respostas
        return respostas.map { r -> mapper.map(r) }
    }


}