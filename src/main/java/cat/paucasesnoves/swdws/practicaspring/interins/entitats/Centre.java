package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Centres", schema = "interins", catalog = "")
public class Centre {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCentre", nullable = false, length = 8)
    private String idCentre;
    @Basic
    @Column(name = "nomCentre", nullable = false, length = 100)
    private String nomCentre;
    @Basic
    @Column(name = "idLocalitat", nullable = false, length = 9)
    private String idLocalitat;
    @ManyToOne
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat", nullable = false, insertable = false, updatable = false)
    private Localitat localitat;
    @OneToMany(mappedBy = "centre")
    @JsonIgnore
    private Collection<Preferencia> preferencies;

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public String getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centre centre = (Centre) o;

        if (idCentre != null ? !idCentre.equals(centre.idCentre) : centre.idCentre != null) return false;
        if (nomCentre != null ? !nomCentre.equals(centre.nomCentre) : centre.nomCentre != null) return false;
        if (idLocalitat != null ? !idLocalitat.equals(centre.idLocalitat) : centre.idLocalitat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCentre != null ? idCentre.hashCode() : 0;
        result = 31 * result + (nomCentre != null ? nomCentre.hashCode() : 0);
        result = 31 * result + (idLocalitat != null ? idLocalitat.hashCode() : 0);
        return result;
    }

    public Localitat getLocalitat() {
        return localitat;
    }

    public void setLocalitat(Localitat localitat) {
        this.localitat = localitat;
    }

    public Collection<Preferencia> getPreferencies() {
        return preferencies;
    }

    public void setPreferencies(Collection<Preferencia> preferencies) {
        this.preferencies = preferencies;
    }

    @Override
    public String toString() {
        return "Centre{" +
                "idCentre='" + idCentre + '\'' +
                ", nomCentre='" + nomCentre + '\'' +
                ", idLocalitat='" + idLocalitat + '\'' +
                ", localitat=" + localitat +
                '}';
    }
}
