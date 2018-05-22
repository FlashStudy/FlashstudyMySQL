package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Assunto implements java.io.Serializable {

    private Integer codigo;
    private String tema;

    private Disciplina disciplina;
    private Flashcard flashcard;

    public Assunto() {
    }

    public Assunto(Disciplina disciplina, Flashcard flashcard, String tema) {
        this.disciplina = disciplina;
        this.flashcard = flashcard;
        this.tema = tema;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @ManyToMany
    public Flashcard getFlashcard() {
        return this.flashcard;
    }

    public void setFlashcard(Flashcard flashcard) {
        this.flashcard = flashcard;
    }

    public String getTema() {
        return this.tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
