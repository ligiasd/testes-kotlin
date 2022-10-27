package br.com.domingosligiane.springtestesautomatizados.service

import br.com.domingosligiane.springtestesautomatizados.model.Usuario
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

class UserDetail(
    private val usuario: Usuario
): UserDetails {

    override fun getAuthorities() = usuario.role

    override fun getPassword() = usuario.password

    override fun getUsername() = usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}