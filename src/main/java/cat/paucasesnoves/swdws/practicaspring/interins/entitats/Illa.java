package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Illes", schema = "interins", catalog = "")
public class Illa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idIlla", nullable = false, length = 3)
    private String idIlla;
    @Basic
    @Column(name = "nomIlla", nullable = false, length = 45)
    private String nomIlla;
    @OneToMany(mappedBy = "illa")
    @JsonIgnore
    private Collection<Localitat> localitats;

    public String getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(String idIlla) {
        this.idIlla = idIlla;
    }

    public String getNomIlla() {
        return nomIlla;
    }

    public void setNomIlla(String nomIlla) {
        this.nomIlla = nomIlla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Illa illa = (Illa) o;

        if (idIlla != null ? !idIlla.equals(illa.idIlla) : illa.idIlla != null) return false;
        if (nomIlla != null ? !nomIlla.equals(illa.nomIlla) : illa.nomIlla != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIlla != null ? idIlla.hashCode() : 0;
        result = 31 * result + (nomIlla != null ? nomIlla.hashCode() : 0);
        return result;
    }

    public Collection<Localitat> getLocalitats() {
        return localitats;
    }

    public void setLocalitats(Collection<Localitat> localitats) {
        this.localitats = localitats;
    }

    @Override
    public String toString() {
        return "Illa{" +
                "idIlla='" + idIlla + '\'' +
                ", nomIlla='" + nomIlla + '\'' +
                '}';
    }
}
