package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Usuario
import br.com.alura.forum.dtos.UsuarioResponse
import org.springframework.stereotype.Component

@Component
class ResponseUsuario: IMapper<Usuario, UsuarioResponse> {
    override fun map(e: Usuario): UsuarioResponse {
        return UsuarioResponse(
            id = e.id,
            nome = e.nome,
            email = e.email
        )
    }

    companion object {
        fun map(ur: UsuarioResponse): Usuario {
            return Usuario(
                id = ur.id,
                nome = ur.nome,
                email = ur.email
            )
        }
    }

}
