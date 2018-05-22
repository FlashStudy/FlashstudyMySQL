package model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Executado implements java.io.Serializable {

    private ExecutadoId id;
    private Cronograma cronograma;
    private Disciplina disciplina;
    private Horario horario;

    public Executado() {
    }

    public Executado(ExecutadoId id, Cronograma cronograma, Disciplina disciplina, Horario horario) {
        this.id = id;
        this.cronograma = cronograma;
        this.disciplina = disciplina;
        this.horario = horario;
    }
    
    @OneToOne
    public ExecutadoId getId() {
        return this.id;
    }

    public void setId(ExecutadoId id) {
        this.id = id;
    }
    
    @ManyToOne
    public Cronograma getCronograma() {
        return this.cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }
    
    @ManyToOne
    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    @ManyToMany
    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
