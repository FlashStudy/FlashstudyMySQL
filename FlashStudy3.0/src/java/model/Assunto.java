package model;

import javax.persistence.*;

@Entity
public class Assunto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String tema;

    @ManyToOne
    private Disciplina disciplina;

    public Assunto() {
    }

    public Assunto(String tema, Disciplina disciplina) {
        this.tema = tema;
        this.disciplina = disciplina;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    @Override
    public String toString() {
        return "Assunto{" + "codigo=" + codigo + ", tema=" + tema + ", disciplina=" + disciplina + '}';
    }

}
