package br.com.flashstudy.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "Disciplina", catalog = "mapeamentohibernate")
@Inheritance(strategy = InheritanceType.JOINED)
public class Disciplina implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@Column
	@NotEmpty
	private String nome;

	@OneToMany
	private List<Assunto> assunto;

	public Disciplina() {
	}

	public Disciplina(String nome, List<Assunto> assunto) {
		this.nome = nome;
		this.assunto = assunto;
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

	@SuppressWarnings("rawtypes")
	public List getAssunto() {
		return assunto;
	}

	public void setAssunto(List<Assunto> assunto) {
		this.assunto = assunto;
	}

	@Override
	public String toString() {
		return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", assunto=" + assunto + '}';
	}

}
