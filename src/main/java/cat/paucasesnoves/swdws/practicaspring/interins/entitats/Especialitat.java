package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Especialitats", schema = "interins", catalog = "")
@IdClass(EspecialitatPK.class)
public class Especialitat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCos", nullable = false, length = 4)
    private String idCos;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEspecialitat", nullable = false, length = 3)
    private String idEspecialitat;
    @Basic
    @Column(name = "descripcio", nullable = false, length = 100)
    private String descripcio;
    @ManyToOne
    @JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false, insertable = false, updatable = false)
    private Cos cos;
    @OneToMany(mappedBy = "especialitat")
    @JsonIgnore
    private Collection<Preferencia> preferencies;

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public String getIdEspecialitat() {
        return idEspecialitat;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Especialitat that = (Especialitat) o;

        if (idCos != null ? !idCos.equals(that.idCos) : that.idCos != null) return false;
        if (idEspecialitat != null ? !idEspecialitat.equals(that.idEspecialitat) : that.idEspecialitat != null)
            return false;
        if (descripcio != null ? !descripcio.equals(that.descripcio) : that.descripcio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCos != null ? idCos.hashCode() : 0;
        result = 31 * result + (idEspecialitat != null ? idEspecialitat.hashCode() : 0);
        result = 31 * result + (descripcio != null ? descripcio.hashCode() : 0);
        return result;
    }

    public Cos getCos() {
        return cos;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public Collection<Preferencia> getPreferencies() {
        return preferencies;
    }

    public void setPreferencies(Collection<Preferencia> preferencies) {
        this.preferencies = preferencies;
    }

    @Override
    public String toString() {
        return "Especialitat{" +
                "idCos='" + idCos + '\'' +
                ", idEspecialitat='" + idEspecialitat + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
