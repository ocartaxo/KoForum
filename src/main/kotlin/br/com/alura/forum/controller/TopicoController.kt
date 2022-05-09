package br.com.alura.forum.controller

import br.com.alura.forum.dtos.RespostaTopicoResponse
import br.com.alura.forum.dtos.TopicoRequest
import br.com.alura.forum.dtos.TopicoResponse
import br.com.alura.forum.dtos.TopicoUpdate
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoResponse> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaPorId(
        @PathVariable id: Long
    ): TopicoResponse {
        return service.buscaPorId(id)
    }

    @GetMapping("/{id}/respostas")
    fun buscaRespostas(
        @PathVariable id: Long
    ): List<RespostaTopicoResponse> {
        return service.buscaRespostas(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid topico: TopicoRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoResponse> {
        val topicoResponse = service.cadastrar(topico)
        val uri = uriBuilder.path("http/topicos/${topicoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoResponse)
    }

    @PutMapping
    @Transactional
    fun atualizar(
        @RequestBody @Valid topico: TopicoUpdate
    ): ResponseEntity<TopicoResponse> {
        val topicoResponse = service.atualizar(topico)
        return ResponseEntity.ok(topicoResponse)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun excluir(
        @PathVariable id: Long
    ) {
        service.deletar(id)
    }

}