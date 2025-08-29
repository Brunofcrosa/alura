package com.example.controller.form;

import com.example.modelo.Curso;
import com.example.modelo.Topico;
import com.example.repository.CursoRepository;
import jakarta.validation.constraints.NotEmpty;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

public class TopicoForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String titulo;

	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;

	@NotNull @NotEmpty
	private String nomeCurso;

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
