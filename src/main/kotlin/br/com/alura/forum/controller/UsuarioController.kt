package br.com.alura.forum.controller

import br.com.alura.forum.domain.Usuario
import br.com.alura.forum.dtos.UsuarioResponse
import br.com.alura.forum.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val service: UsuarioService) {

    @GetMapping
    fun listar(): List<UsuarioResponse> {
        return service.listar()
    }

    @GetMapping("/{idUsuario}")
    fun buscarPorId(idUsuario: Long): UsuarioResponse{
        return service.buscarPorId(idUsuario)
    }

}