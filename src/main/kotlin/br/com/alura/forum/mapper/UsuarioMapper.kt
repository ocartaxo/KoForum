/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Usuario
import br.com.alura.forum.dtos.UsuarioResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
interface UsuarioMapper {
    fun map(u: Usuario) : UsuarioResponse
    fun map(ur: UsuarioResponse) : Usuario
}