package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Resposta
import br.com.alura.forum.dtos.TopicoResponse
import br.com.alura.forum.domain.Topico
import br.com.alura.forum.dtos.RespotaTopicoResponse
import org.springframework.stereotype.Component

@Component
class ResponseTopico : IMapper<Topico, TopicoResponse> {

    override fun map(e: Topico): TopicoResponse {
        return TopicoResponse(
            id = e.id,
            titulo = e.titulo,
            mensagem = e.mensagem,
            dataCriacao = e.dataCriacao,
            status = e.status
        )
    }

    fun map(r: Resposta): RespotaTopicoResponse {
        return RespotaTopicoResponse(
            id = r.id,
            mensagem = r.mensagem,
            dataCriacao = r.dataCriacao,
            idAutor = r.autor.id,
            solucao = r.solucao
        )
    }

}