package model;

public class ExecutadoId implements java.io.Serializable {

    private int coddisc;
    private int codcrono;
    private int codhora;
    private String dia;

    public ExecutadoId() {
    }

    public ExecutadoId(int coddisc, int codcrono, int codhora, String dia) {
        this.coddisc = coddisc;
        this.codcrono = codcrono;
        this.codhora = codhora;
        this.dia = dia;
    }

    public int getCoddisc() {
        return this.coddisc;
    }

    public void setCoddisc(int coddisc) {
        this.coddisc = coddisc;
    }

    public int getCodcrono() {
        return this.codcrono;
    }

    public void setCodcrono(int codcrono) {
        this.codcrono = codcrono;
    }

    public int getCodhora() {
        return this.codhora;
    }

    public void setCodhora(int codhora) {
        this.codhora = codhora;
    }

    public String getDia() {
        return this.dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ExecutadoId)) {
            return false;
        }
        ExecutadoId castOther = (ExecutadoId) other;

        return (this.getCoddisc() == castOther.getCoddisc())
                && (this.getCodcrono() == castOther.getCodcrono())
                && (this.getCodhora() == castOther.getCodhora())
                && ((this.getDia() == castOther.getDia()) || (this.getDia() != null && castOther.getDia() != null && this.getDia().equals(castOther.getDia())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getCoddisc();
        result = 37 * result + this.getCodcrono();
        result = 37 * result + this.getCodhora();
        result = 37 * result + (getDia() == null ? 0 : this.getDia().hashCode());
        return result;
    }

}
