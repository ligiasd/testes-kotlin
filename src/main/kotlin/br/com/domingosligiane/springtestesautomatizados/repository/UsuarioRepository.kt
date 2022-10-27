package br.com.domingosligiane.springtestesautomatizados.repository

import br.com.domingosligiane.springtestesautomatizados.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByEmail(username: String?): Usuario?
}