package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class EspecialitatPK implements Serializable {
    @Column(name = "idCos", nullable = false, length = 4)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCos;
    @Column(name = "idEspecialitat", nullable = false, length = 3)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idEspecialitat;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EspecialitatPK that = (EspecialitatPK) o;

        if (idCos != null ? !idCos.equals(that.idCos) : that.idCos != null) return false;
        if (idEspecialitat != null ? !idEspecialitat.equals(that.idEspecialitat) : that.idEspecialitat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCos != null ? idCos.hashCode() : 0;
        result = 31 * result + (idEspecialitat != null ? idEspecialitat.hashCode() : 0);
        return result;
    }
}
