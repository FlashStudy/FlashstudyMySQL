package model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Cronograma implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String inicio;
    private String fim;

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

    public Cronograma(Integer codigo, String inicio, String fim, Usuario usuario, List<Disciplina> disciplinas) {
        this.codigo = codigo;
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
        return "Cronograma{" + "codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario + ", disciplinas=" + disciplinas + '}';
    }

}
