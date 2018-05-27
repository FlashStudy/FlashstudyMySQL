package model;

import java.time.*;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cronograma implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private LocalDate inicio;
    private LocalDate fim;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "usuario_cria_cronograma", joinColumns
            = {
                @JoinColumn(name = "cronograma_codigo")}, inverseJoinColumns
            = {
                @JoinColumn(name = "disciplina_codigo")})
    private List<Disciplina> disciplinas;

    public Cronograma() {
    }

    public Cronograma(LocalDate inicio, LocalDate fim, Usuario usuario, List<Disciplina> disciplinas) {
        this.inicio = inicio;
        this.fim = fim;
        this.usuario = usuario;
        this.disciplinas = disciplinas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
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
        return "Cronograma{" + "codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario + ", disciplinas=" + disciplinas + '}';
    }

}
