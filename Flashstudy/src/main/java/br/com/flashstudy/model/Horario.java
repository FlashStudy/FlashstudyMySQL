package br.com.flashstudy.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "Horario", catalog = "mapeamentohibernate")
@Inheritance(strategy = InheritanceType.JOINED)
public class Horario implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@NotEmpty
	@Column
	private String inicio;

	@NotEmpty
	@Column
	private String fim;

	@NotEmpty
	@Column
	private int ordem;

	@NotEmpty
	@Column
	private Integer tempo;

	@ManyToOne
	private Usuario usuario;

	public Horario() {
		super();
	}

	public Horario(String inicio, String fim, int ordem, Integer tempo, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.ordem = ordem;
		this.tempo = tempo;
		this.usuario = usuario;
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

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Horario [codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", ordem=" + ordem + ", tempo="
				+ tempo + ", usuario=" + usuario + "]";
	}

}