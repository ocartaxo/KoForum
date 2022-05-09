/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

package br.com.alura.forum.repository

import br.com.alura.forum.domain.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta, Long> {
}