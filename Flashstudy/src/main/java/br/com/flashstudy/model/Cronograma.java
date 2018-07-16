package br.com.flashstudy.model;

import java.util.List;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cronograma")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cronograma implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@Column
	@NotEmpty
	private String inicio;

	@Column
	@NotEmpty
	private String fim;

	@ManyToOne
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "cronograma_possui_disciplinas", joinColumns = {
			@JoinColumn(name = "cronograma_codigo") }, inverseJoinColumns = { @JoinColumn(name = "disciplina_codigo") })
	private List<Disciplina> disciplinas;

	public Cronograma() {
	}

	public Cronograma(String inicio, String fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}

	public Cronograma(String inicio, String fim, Usuario usuario) {
		this.inicio = inicio;
		this.fim = fim;
		this.usuario = usuario;
	}

	public Cronograma(String inicio, String fim, Usuario usuario, List<Disciplina> disciplinas) {
		this.inicio = inicio;
		this.fim = fim;
		this.usuario = usuario;
		this.disciplinas = disciplinas;
	}

	public Cronograma(Long codigo, String inicio, String fim, Usuario usuario, List<Disciplina> disciplinas) {
		this.codigo = codigo;
		this.inicio = inicio;
		this.fim = fim;
		this.usuario = usuario;
		this.disciplinas = disciplinas;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Cronograma{" + "codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario
				+ ", disciplinas=" + disciplinas + '}';
	}

}