package cat.paucasesnoves.swdws.practicaspring.interins.repositoris;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Aspirant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AspirantRepository extends JpaRepository<Aspirant, String> {
}
