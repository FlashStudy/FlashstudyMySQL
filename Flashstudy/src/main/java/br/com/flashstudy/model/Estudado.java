package br.com.flashstudy.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table
public class Estudado implements Serializable {

	@Id
	@OneToOne
	private EstudadoId id;

	@ManyToOne
	private Cronograma cronograma;

	@ManyToOne
	private Disciplina disciplina;

	@ManyToMany
	private Horario horario;

	public Estudado() {
	}

	public Estudado(EstudadoId id, Cronograma cronograma, Disciplina disciplina, Horario horario) {
		this.id = id;
		this.cronograma = cronograma;
		this.disciplina = disciplina;
		this.horario = horario;
	}

	public EstudadoId getId() {
		return this.id;
	}

	public void setId(EstudadoId id) {
		this.id = id;
	}

	public Cronograma getCronograma() {
		return this.cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}
