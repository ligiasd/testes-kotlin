package br.com.domingosligiane.springtestesautomatizados.service

import br.com.domingosligiane.springtestesautomatizados.dto.AtualizacaoTopicoForm
import br.com.domingosligiane.springtestesautomatizados.dto.NovoTopicoForm
import br.com.domingosligiane.springtestesautomatizados.dto.TopicoPorCategoriaDto
import br.com.domingosligiane.springtestesautomatizados.dto.TopicoView
import br.com.domingosligiane.springtestesautomatizados.exception.NotFoundException
import br.com.domingosligiane.springtestesautomatizados.mapper.TopicoFormMapper
import br.com.domingosligiane.springtestesautomatizados.mapper.TopicoViewMapper
import br.com.domingosligiane.springtestesautomatizados.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import javax.persistence.EntityManager


@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado!",
    private val em: EntityManager
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        print(em)
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }

}