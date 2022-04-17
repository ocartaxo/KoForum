package br.com.alura.forum.controller

import br.com.alura.forum.dtos.CursoResponse
import br.com.alura.forum.service.CursoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos")
class CursoController(val service: CursoService) {

    @GetMapping
    fun listar(): List<CursoResponse> {
        return service.listar()
    }

    @GetMapping("/{idCurso}")
    fun buscarPorId(
        @PathVariable idCurso: Long
    ): CursoResponse {
        return service.buscarPorId(idCurso)
    }
}