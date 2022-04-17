package br.com.alura.forum.mapper

import br.com.alura.forum.dtos.TopicoRequest
import br.com.alura.forum.domain.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RequestTopico(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): IMapper<TopicoRequest, Topico> {

    override fun map(e: TopicoRequest): Topico {
        val curso = ResponseCurso.map(cursoService.buscarPorId(e.idCurso))
        val autor = ResponseUsuario.map(usuarioService.buscarPorId(e.idAutor))
        return Topico(
            titulo = e.titulo,
            mensagem = e.mensagem,
            curso = curso,
            autor = autor
        )
    }
}