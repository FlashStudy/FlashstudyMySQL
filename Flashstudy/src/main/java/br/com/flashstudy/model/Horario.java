package br.com.flashstudy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Horario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Horario implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@Column(name = "dia", nullable = false, unique = true)
	private String dia;

	@Column(name = "horario", nullable = false, unique = true)
	private String horario;
	
	@OneToMany
	private Set<Disciplina> disciplinas = new HashSet<>();

	@ManyToOne
	private Usuario usuario;

	@OneToOne
	private Ciclo ciclo;

	public Horario() {
		super();
	}

	public Horario(String dia, Usuario usuario) {
		super();
		this.dia = dia;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	@Override
	public String toString() {
		return "Horario [codigo=" + codigo + ", dia=" + dia + ", disciplinas=" + disciplinas + ", usuario=" + usuario
				+ ", ciclo=" + ciclo + "]";
	}

}