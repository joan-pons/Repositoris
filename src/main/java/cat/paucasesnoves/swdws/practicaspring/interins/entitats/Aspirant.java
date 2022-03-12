package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Aspirants", schema = "interins", catalog = "")
public class Aspirant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Nif", nullable = false, length = 9)
    private String nif;
    @Basic
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Basic
    @Column(name = "llinatges", nullable = false, length = 45)
    private String llinatges;
    @Basic
    @Column(name = "adreca", nullable = true, length = 100)
    private String adreca;
    @Basic
    @Column(name = "codiPostal", nullable = true, length = 5)
    private String codiPostal;
    @Basic
    @Column(name = "idLocalitat", nullable = true, length = 9)
    private String idLocalitat;
    @ManyToOne
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat", insertable = false, updatable = false)
    private Localitat localitat;
    @OneToMany(mappedBy = "aspirant")
    @JsonIgnore
    private Collection<Preferencia> preferencies;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
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

        Aspirant aspirant = (Aspirant) o;

        if (nif != null ? !nif.equals(aspirant.nif) : aspirant.nif != null) return false;
        if (nom != null ? !nom.equals(aspirant.nom) : aspirant.nom != null) return false;
        if (llinatges != null ? !llinatges.equals(aspirant.llinatges) : aspirant.llinatges != null) return false;
        if (adreca != null ? !adreca.equals(aspirant.adreca) : aspirant.adreca != null) return false;
        if (codiPostal != null ? !codiPostal.equals(aspirant.codiPostal) : aspirant.codiPostal != null) return false;
        if (idLocalitat != null ? !idLocalitat.equals(aspirant.idLocalitat) : aspirant.idLocalitat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (llinatges != null ? llinatges.hashCode() : 0);
        result = 31 * result + (adreca != null ? adreca.hashCode() : 0);
        result = 31 * result + (codiPostal != null ? codiPostal.hashCode() : 0);
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
        return "Aspirant{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", adreca='" + adreca + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                ", idLocalitat='" + idLocalitat + '\'' +
                ", localitat=" + localitat +
                '}';
    }
}
