package br.com.flashstudy.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Disciplina_Cronograma_Horario", catalog = "mapeamentohibernate")
public class EstudadoId implements Serializable {

	/*
	 * private int coddisc; private int codcrono; private int codhora; private
	 * String dia;
	 */

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "codigodisciplina", column = @Column(name = "codigodisciplina", nullable = false)),
			@AttributeOverride(name = "codigocronograma", column = @Column(name = "codigocronograma", nullable = false)),
			@AttributeOverride(name = "codigohorario", column = @Column(name = "codigohorario", nullable = false)),})
	private Id id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoDisciplina", nullable = false, insertable = false, updatable = false)
	private Disciplina disciplina;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoCronograma", nullable = false, insertable = false, updatable = false)
	private Cronograma cronograma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoHorario", nullable = false, insertable = false, updatable = false)
	private Horario horario;
	
	@Column(name = "dia", nullable = false)
	private String dia;

	// getters e setters omitidos

	// Id da associacao (chave composta no banco)
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "codigoDisciplina", nullable = false)
		private Long codigoDisciplina;

		@Column(name = "codigoCronograma", nullable = false)
		private Long codigoCronograma;
		
		@Column(name = "codigoHorario", nullable = false)
		private Long codigoHorario;

		public Long getCodigoDisciplina() {
			return codigoDisciplina;
		}

		public void setCodigoDisciplina(Long codigoDisciplina) {
			this.codigoDisciplina = codigoDisciplina;
		}

		public Long getCodigoCronograma() {
			return codigoCronograma;
		}

		public void setCodigoCronograma(Long codigoCronograma) {
			this.codigoCronograma = codigoCronograma;
		}

		public Long getCodigoHorario() {
			return codigoHorario;
		}

		public void setCodigoHorario(Long codigoHorario) {
			this.codigoHorario = codigoHorario;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (int) (prime * result + codigoDisciplina);
			result = (int) (prime * result + codigoCronograma);
			result = (int) (prime * result + codigoHorario);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (codigoDisciplina != other.codigoDisciplina)
				return false;
			if (codigoCronograma != other.codigoCronograma)
				return false;
			if (codigoHorario != other.codigoHorario)
				return false;
			return true;
		}
	}
}
