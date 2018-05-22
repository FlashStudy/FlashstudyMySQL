package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Flashcard implements java.io.Serializable {

    private int codigo;
    private String pergunta;
    private String resposta;
    private String nivel;
    private String titulo;
    private String publico;

    private Usuario usuario;
    private Assunto assunto;
    
    public Flashcard() {

    }

    public Flashcard(String pergunta, String resposta, String nivel, String titulo, String publico, Usuario usuario, Assunto assunto) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.nivel = nivel;
        this.titulo = titulo;
        this.publico = publico;
        this.usuario = usuario;
        this.assunto = assunto;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    @ManyToOne
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @ManyToMany
    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "Flashcard{" + "codigo=" + codigo + ", pergunta=" + pergunta + ", resposta=" + resposta + ", nivel=" + nivel + ", titulo=" + titulo + ", publico=" + publico + ", usuario=" + usuario + ", assunto=" + assunto + '}';
    }
    
    
}
