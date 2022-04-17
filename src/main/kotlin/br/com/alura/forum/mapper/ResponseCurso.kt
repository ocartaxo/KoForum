package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Curso
import br.com.alura.forum.dtos.CursoResponse
import org.springframework.stereotype.Component

@Component
class ResponseCurso: IMapper<Curso, CursoResponse> {
    override fun map(e: Curso): CursoResponse {
        return CursoResponse(
            id = e.id,
            nome = e.nome,
            categoria = e.categoria
        )
    }

    companion object {
        fun map(cr: CursoResponse): Curso {
            return Curso(
                id = cr.id,
                nome = cr.nome,
                categoria = cr.categoria
            )
        }
    }

}