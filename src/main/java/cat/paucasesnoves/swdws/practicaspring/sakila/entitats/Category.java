package cat.paucasesnoves.swdws.practicaspring.sakila.entitats;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category", schema = "sakila", catalog = "")
public class Category {
    private Short categoryId;
    private String name;
    private Collection<FilmCategory> filmCategory;

    @Id
    @Column(name = "category_id", nullable = false)
    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 25)
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

        Category that = (Category) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    public Collection<FilmCategory> getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(Collection<FilmCategory> filmCategory) {
        this.filmCategory = filmCategory;
    }
}
