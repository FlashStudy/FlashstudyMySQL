package br.com.flashstudy.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Ciclo")
@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ciclo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Horario> horarios = new HashSet<>();

	@ManyToOne
	private Usuario usuario;

	public Ciclo() {
		super();
	}

	public Ciclo(Set<Horario> horarios, Usuario usuario) {
		super();
		this.horarios = horarios;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Set<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addHorario(Horario horario) {
		horarios.add(horario);
		horario.setCiclo(this);
	}

	@Override
	public String toString() {
		return "Ciclo [codigo=" + codigo + ", horarios=" + horarios + ", usuario=" + usuario + "]";
	}

}