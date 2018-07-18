package br.com.flashstudy.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "Assunto")
public class Assunto implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@Column(name = "tema", unique = true)
	@NotEmpty
	private String tema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disciplina_codigo")
	@JsonBackReference
	private Disciplina disciplina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	public Assunto() {
		super();
	}

	public Assunto(Long codigo, String tema, Disciplina disciplina, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.tema = tema;
		this.disciplina = disciplina;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Assunto))
			return false;
		return codigo != null && codigo.equals(((Assunto) o).codigo);
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
