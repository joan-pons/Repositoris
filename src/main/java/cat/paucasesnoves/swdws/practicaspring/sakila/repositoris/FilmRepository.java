package cat.paucasesnoves.swdws.practicaspring.sakila.repositoris;

import cat.paucasesnoves.swdws.practicaspring.sakila.entitats.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Short> {
}
