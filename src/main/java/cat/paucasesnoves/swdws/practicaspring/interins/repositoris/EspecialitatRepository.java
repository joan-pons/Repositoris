package cat.paucasesnoves.swdws.practicaspring.interins.repositoris;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Especialitat;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.EspecialitatPK;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.EspecialitatProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecialitatRepository extends JpaRepository<Especialitat, EspecialitatPK> {
    public List<EspecialitatProjection> findAllByIdCosOrderByDescripcio(String idCos);
}
