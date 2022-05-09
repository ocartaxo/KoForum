/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Resposta
import br.com.alura.forum.domain.Topico
import br.com.alura.forum.dtos.RespostaTopicoResponse
import br.com.alura.forum.dtos.TopicoRequest
import br.com.alura.forum.dtos.TopicoResponse
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class TopicoMapper {
    @Autowired
    private lateinit var cursoService: CursoService

    @Autowired
    private lateinit var usuarioService: UsuarioService

    @Autowired
    private lateinit var cursoMapper: CursoMapper

    @Autowired
    private lateinit var usuarioMapper: UsuarioMapper

    abstract fun map(t: Topico): TopicoResponse

    abstract fun map(response: TopicoResponse): Topico

    abstract fun map(r: Resposta): RespostaTopicoResponse

    fun map(request: TopicoRequest): Topico {
        val c = cursoMapper.map(cursoService.buscarPorId(request.idCurso))
        val a = usuarioMapper.map(usuarioService.buscarPorId(request.idAutor))

        return Topico(
            titulo = request.titulo,
            mensagem = request.mensagem,
            autor = a,
            curso = c
        )
    }

}