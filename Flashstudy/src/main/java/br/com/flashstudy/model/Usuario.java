package br.com.flashstudy.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", unique = true, nullable = false)
	private Long codigo;

	@Column(name = "nome")
	@NotEmpty
	private String nome;

	@Column(name = "email", unique = true)
	@NotEmpty
	private String email;

	@Column(name = "senha")
	@NotEmpty
	private String senha;

	@Column(name = "foto")
	private String foto;

	public Usuario(String nome, String email, String senha, String foto) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {
		super();
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

	@JsonIgnore
	public String getEmail() {
		return email;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto="
				+ foto + "]";
	}

}
