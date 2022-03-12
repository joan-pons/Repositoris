package cat.paucasesnoves.swdws.practicaspring.sakila.entitats;

import javax.persistence.*;

@Entity
@Table(name = "language", schema = "sakila", catalog = "")
public class Language {
    private Short languageId;
    private String name;

    @Id
    @Column(name = "language_id", nullable = false)
    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language that = (Language) o;

        if (languageId != null ? !languageId.equals(that.languageId) : that.languageId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId != null ? languageId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
