package cat.paucasesnoves.swdws.practicaspring.interins.repositoris;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Centre;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Preferencia;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.PreferenciaPK;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.CentreProjection;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.PreferenciaProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentreRepository extends JpaRepository<Centre, String> {
        public List<Centre> findByIdLocalitatOrderByNomCentreAsc(String idLocalitat);
        public List<CentreProjection> findByLocalitatIdIllaOrderByNomCentreAsc(String idIlla);
}
