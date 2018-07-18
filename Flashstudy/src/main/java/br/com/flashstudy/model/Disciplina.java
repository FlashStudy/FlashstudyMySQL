package br.com.flashstudy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "Disciplina")
@Inheritance(strategy = InheritanceType.JOINED)
public class Disciplina implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@Column
	@NotEmpty
	private String nome;

	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Assunto> assuntos = new ArrayList<>();

	@ManyToOne
	private Usuario usuario;

	public Disciplina() {
		super();
	}

	public Disciplina(Long codigo, String nome, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.usuario = usuario;
	}

	public Disciplina(Long codigo, String nome, List<Assunto> assuntos, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.assuntos = assuntos;
		this.usuario = usuario;
	}

	public Disciplina(String nome, List<Assunto> assuntos, Usuario usuario) {
		super();
		this.nome = nome;
		this.assuntos = assuntos;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addAssunto(Assunto assunto) {
		assuntos.add(assunto);
		assunto.setDisciplina(this);
	}

	public void removeAssunto(Assunto assunto) {
		assuntos.remove(assunto);
		assunto.setDisciplina(null);
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", assunto=" + assuntos + ", usuario=" + usuario
				+ "]";
	}

}
