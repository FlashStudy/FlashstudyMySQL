package model;

import javax.persistence.*;

@Entity
public class Flashcard implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String pergunta;
    private String resposta;
    private String nivel;
    private String titulo;
    private String publico;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "disciplina_codigo")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "assunto_codigo")
    private Assunto assunto;

    public Flashcard() {
    }

    public Flashcard(String pergunta, String resposta, String nivel, String titulo, String publico, Usuario usuario, Disciplina disciplina, Assunto assunto) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.nivel = nivel;
        this.titulo = titulo;
        this.publico = publico;
        this.usuario = usuario;
        this.disciplina = disciplina;
        this.assunto = assunto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "Flashcard{" + "codigo=" + codigo + ", pergunta=" + pergunta + ", resposta=" + resposta + ", nivel=" + nivel + ", titulo=" + titulo + ", publico=" + publico + ", usuario=" + usuario + ", disciplina=" + disciplina + ", assunto=" + assunto + '}';
    }

}
