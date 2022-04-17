package br.com.alura.forum.service

import br.com.alura.forum.dtos.TopicoRequest
import br.com.alura.forum.dtos.TopicoResponse
import br.com.alura.forum.dtos.TopicoUpdate
import br.com.alura.forum.mapper.RequestTopico
import br.com.alura.forum.mapper.ResponseTopico
import br.com.alura.forum.domain.Topico
import br.com.alura.forum.dtos.RespotaTopicoResponse
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val responseTopico: ResponseTopico,
    private val requestTopico: RequestTopico,
    private val notFoundMessage: String = "Tópico não encontrado!"
) {

    fun listar(): List<TopicoResponse> {

        return repository.findAll().stream().map { t ->
            responseTopico.map(t)
        }.collect(Collectors.toList())
    }

    fun buscaPorId(id: Long): TopicoResponse {
        val t = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return responseTopico.map(t)
    }

    fun cadastrar(t: TopicoRequest): TopicoResponse {
        val topico: Topico = requestTopico.map(t)
        repository.save(topico)
        return responseTopico.map(topico)
    }

    fun atualizar(t: TopicoUpdate): TopicoResponse {
        val topico = repository.findById(t.id).orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = t.titulo
        topico.mensagem = t.mensagem

        return responseTopico.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun buscaRespostas(id: Long): List<RespotaTopicoResponse> {
        val rps = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }.respostas
        return rps.map { r -> responseTopico.map(r) }
    }


}