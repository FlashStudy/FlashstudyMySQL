package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Horario implements java.io.Serializable {

    private Integer codigo;
    private String inicio;
    private String fim;
    private int ordem;
    private Integer tempo;
    
    private Executado executado;
    private Usuario usuario;

    public Horario() {
    }

    public Horario(String inicio, String fim, int ordem, Integer tempo, Executado executado, Usuario usuario) {
        this.inicio = inicio;
        this.fim = fim;
        this.ordem = ordem;
        this.tempo = tempo;
        this.executado = executado;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }
    
    @ManyToOne
    public Executado getExecutado() {
        return executado;
    }

    public void setExecutado(Executado executado) {
        this.executado = executado;
    }

    @ManyToOne
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
