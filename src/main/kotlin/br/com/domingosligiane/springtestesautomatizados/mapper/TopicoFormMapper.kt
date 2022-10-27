package br.com.domingosligiane.springtestesautomatizados.mapper

import br.com.domingosligiane.springtestesautomatizados.dto.NovoTopicoForm
import br.com.domingosligiane.springtestesautomatizados.model.Topico
import br.com.domingosligiane.springtestesautomatizados.service.CursoService
import br.com.domingosligiane.springtestesautomatizados.service.UsuarioService
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
            dataAlteracao = LocalDate.now()
        )
    }

}