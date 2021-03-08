package br.com.devplus.forum.controller.form;

import br.com.devplus.forum.modelo.Topico;
import br.com.devplus.forum.repository.TopicoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class AtualizaTopicoForm {
    @NotBlank
    @Length(min = 5)
    private String titulo;
    @NotBlank @Length(min = 10)
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
