package br.com.flashstudy.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table
public class Horario implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}