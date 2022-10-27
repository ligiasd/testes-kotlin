package br.com.domingosligiane.springtestesautomatizados.service

import br.com.domingosligiane.springtestesautomatizados.model.Usuario
import br.com.domingosligiane.springtestesautomatizados.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UsuarioService (
    private val repository: UsuarioRepository
) : UserDetailsService {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }
}
