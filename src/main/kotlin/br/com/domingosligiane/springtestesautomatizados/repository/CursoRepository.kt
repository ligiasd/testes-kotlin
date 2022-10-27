package br.com.domingosligiane.springtestesautomatizados.repository

import br.com.domingosligiane.springtestesautomatizados.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}