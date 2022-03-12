package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Cossos", schema = "interins", catalog = "")
public class Cos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCos", nullable = false, length = 4)
    private String idCos;
    @Basic
    @Column(name = "descripcio", nullable = false, length = 100)
    private String descripcio;
    @OneToMany(mappedBy = "cos")
    @JsonIgnore
    private Collection<Especialitat> especialitats;

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
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

        Cos cos = (Cos) o;

        if (idCos != null ? !idCos.equals(cos.idCos) : cos.idCos != null) return false;
        if (descripcio != null ? !descripcio.equals(cos.descripcio) : cos.descripcio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCos != null ? idCos.hashCode() : 0;
        result = 31 * result + (descripcio != null ? descripcio.hashCode() : 0);
        return result;
    }

    public Collection<Especialitat> getEspecialitats() {
        return especialitats;
    }

    public void setEspecialitats(Collection<Especialitat> especialitats) {
        this.especialitats = especialitats;
    }

    @Override
    public String toString() {
        return "Cos{" +
                "idCos='" + idCos + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
