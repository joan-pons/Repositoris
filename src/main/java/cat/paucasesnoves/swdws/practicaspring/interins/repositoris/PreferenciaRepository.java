package cat.paucasesnoves.swdws.practicaspring.interins.repositoris;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Preferencia;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.PreferenciaPK;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.PreferenciaProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenciaRepository extends JpaRepository<Preferencia, PreferenciaPK> {
public List<PreferenciaProjection> findByNifAndIdCosOrderByOrdreAsc(String nif, String idCos);


}
