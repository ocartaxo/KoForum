/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

package br.com.alura.forum.mapper

import br.com.alura.forum.domain.Resposta
import br.com.alura.forum.dtos.RespostaTopicoResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface RespostaMapper {

    fun map(r: Resposta): RespostaTopicoResponse
    fun map(r: RespostaTopicoResponse): Resposta

}