package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Disciplina implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nome;

    @OneToMany
    private List<Assunto> assunto;

    public Disciplina() {
    }

    public Disciplina(String nome, List assunto) {
        this.nome = nome;
        this.assunto = assunto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List getAssunto() {
        return assunto;
    }

    public void setAssunto(List assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", assunto=" + assunto + '}';
    }

}
