package br.com.domingosligiane.springtestesautomatizados.service

import br.com.domingosligiane.springtestesautomatizados.model.Curso
import br.com.domingosligiane.springtestesautomatizados.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }


}
