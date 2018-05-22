package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cronograma implements java.io.Serializable {

    private Integer codigo;
    private Date inicio;
    private Date fim;

    private Usuario usuario;
    private Disciplina disciplina;
    
    public Cronograma() {
    }

    public Cronograma(Date inicio, Date fim, Usuario usuario, Disciplina disciplina) {
        this.inicio = inicio;
        this.fim = fim;
        this.usuario = usuario;
        this.disciplina = disciplina;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    @ManyToOne
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToMany
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Cronograma{" + "codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario + ", disciplina=" + disciplina + '}';
    }
    
}
