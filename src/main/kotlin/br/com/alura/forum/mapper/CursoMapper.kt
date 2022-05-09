/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Curso
import br.com.alura.forum.dtos.CursoResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
interface CursoMapper {
    fun map(c: Curso): CursoResponse
    fun map(cr: CursoResponse): Curso
}