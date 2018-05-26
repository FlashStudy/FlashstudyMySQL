package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cronograma implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fim;

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

    public Cronograma(Date inicio, Date fim, Usuario usuario, List disciplinas) {
        this.inicio = inicio;
        this.fim = fim;
        this.usuario = usuario;
        this.disciplinas = disciplinas;
    }

    public Cronograma(Integer codigo, Date inicio, Date fim, Usuario usuario, List disciplinas) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Cronograma{" + "codigo=" + codigo + ", inicio=" + inicio + ", fim=" + fim + ", usuario=" + usuario + ", disciplinas=" + disciplinas + '}';
    }

}
