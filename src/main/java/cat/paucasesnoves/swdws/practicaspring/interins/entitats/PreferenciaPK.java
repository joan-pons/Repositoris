package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class PreferenciaPK implements Serializable {
    @Column(name = "nif", nullable = false, length = 9)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nif;
    @Column(name = "ordre", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordre;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreferenciaPK that = (PreferenciaPK) o;

        if (ordre != that.ordre) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + ordre;
        return result;
    }
}
