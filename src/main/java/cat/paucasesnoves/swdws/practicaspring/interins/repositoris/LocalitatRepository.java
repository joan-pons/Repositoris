package cat.paucasesnoves.swdws.practicaspring.interins.repositoris;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Localitat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalitatRepository extends JpaRepository<Localitat, String> {
    public List<Localitat> findAllByOrderByNomLocalitatAsc();
    public List<Localitat> findAllByidIllaOrderByNomLocalitatAsc(String idIlla);
}
