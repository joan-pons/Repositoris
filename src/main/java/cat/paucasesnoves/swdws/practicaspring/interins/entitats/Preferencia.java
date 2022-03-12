package cat.paucasesnoves.swdws.practicaspring.interins.entitats;

import javax.persistence.*;

@Entity
@IdClass(PreferenciaPK.class)
@Table(name = "Preferencies", schema = "interins", catalog = "")
public class Preferencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nif", nullable = false, length = 9)
    private String nif;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ordre", nullable = false)
    private int ordre;
    @Basic
    @Column(name = "idCos", nullable = false, length = 4)
    private String idCos;
    @Basic
    @Column(name = "idEspecialitat", nullable = false, length = 3)
    private String idEspecialitat;
    @Basic
    @Column(name = "idCentre", nullable = false, length = 8)
    private String idCentre;
    @ManyToOne
    @JoinColumn(name = "nif", referencedColumnName = "Nif", nullable = false, insertable = false, updatable = false)
    private Aspirant aspirant;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "idEspecialitat", referencedColumnName = "idEspecialitat", nullable = false, insertable = false, updatable = false)})
    private Especialitat especialitat;
    @ManyToOne
    @JoinColumn(name = "idCentre", referencedColumnName = "idCentre", nullable = false, insertable = false, updatable = false)
    private Centre centre;

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

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Preferencia that = (Preferencia) o;

        if (ordre != that.ordre) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (idCos != null ? !idCos.equals(that.idCos) : that.idCos != null) return false;
        if (idEspecialitat != null ? !idEspecialitat.equals(that.idEspecialitat) : that.idEspecialitat != null)
            return false;
        if (idCentre != null ? !idCentre.equals(that.idCentre) : that.idCentre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + ordre;
        result = 31 * result + (idCos != null ? idCos.hashCode() : 0);
        result = 31 * result + (idEspecialitat != null ? idEspecialitat.hashCode() : 0);
        result = 31 * result + (idCentre != null ? idCentre.hashCode() : 0);
        return result;
    }

    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }

    public Especialitat getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(Especialitat especialitat) {
        this.especialitat = especialitat;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Preferencia{" +
                "nif='" + nif + '\'' +
                ", ordre=" + ordre +
                ", idCos='" + idCos + '\'' +
                ", idEspecialitat='" + idEspecialitat + '\'' +
                ", idCentre='" + idCentre + '\'' +
                ", aspirant=" + aspirant +
                ", especialitat=" + especialitat +
                ", centre=" + centre +
                '}';
    }

}
