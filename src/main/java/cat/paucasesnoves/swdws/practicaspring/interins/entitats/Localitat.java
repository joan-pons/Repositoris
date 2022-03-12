package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Localitats", schema = "interins", catalog = "")
public class Localitat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLocalitat", nullable = false, length = 9)
    private String idLocalitat;
    @Basic
    @Column(name = "idIlla", nullable = false, length = 3)
    private String idIlla;
    @Basic
    @Column(name = "nomLocalitat", nullable = false, length = 100)
    private String nomLocalitat;
    @OneToMany(mappedBy = "localitat")
    @JsonIgnore
    private Collection<Aspirant> aspirants;
    @OneToMany(mappedBy = "localitat")
    @JsonIgnore
    private Collection<Centre> centres;
    @ManyToOne
    @JoinColumn(name = "idIlla", referencedColumnName = "idIlla", nullable = false, insertable = false, updatable = false)
    private Illa illa;

    public String getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    public String getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(String idIlla) {
        this.idIlla = idIlla;
    }

    public String getNomLocalitat() {
        return nomLocalitat;
    }

    public void setNomLocalitat(String nomLocalitat) {
        this.nomLocalitat = nomLocalitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Localitat localitat = (Localitat) o;

        if (idLocalitat != null ? !idLocalitat.equals(localitat.idLocalitat) : localitat.idLocalitat != null)
            return false;
        if (idIlla != null ? !idIlla.equals(localitat.idIlla) : localitat.idIlla != null) return false;
        if (nomLocalitat != null ? !nomLocalitat.equals(localitat.nomLocalitat) : localitat.nomLocalitat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLocalitat != null ? idLocalitat.hashCode() : 0;
        result = 31 * result + (idIlla != null ? idIlla.hashCode() : 0);
        result = 31 * result + (nomLocalitat != null ? nomLocalitat.hashCode() : 0);
        return result;
    }

    public Collection<Aspirant> getAspirants() {
        return aspirants;
    }

    public void setAspirants(Collection<Aspirant> aspirants) {
        this.aspirants = aspirants;
    }

    public Collection<Centre> getCentres() {
        return centres;
    }

    public void setCentres(Collection<Centre> centres) {
        this.centres = centres;
    }

    public Illa getIlla() {
        return illa;
    }

    public void setIlla(Illa illa) {
        this.illa = illa;
    }

    @Override
    public String toString() {
        return "Localitat{" +
                "idLocalitat='" + idLocalitat + '\'' +
                ", idIlla='" + idIlla + '\'' +
                ", nomLocalitat='" + nomLocalitat + '\'' +
                '}';
    }
}
