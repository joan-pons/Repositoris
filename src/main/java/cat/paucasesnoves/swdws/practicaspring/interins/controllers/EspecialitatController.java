package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Especialitat;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.EspecialitatProjection;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.EspecialitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/especialitats")
public class EspecialitatController {
    @Autowired
    EspecialitatRepository especialitatRepository;

    @GetMapping(path = "{pagina}-{quantitat}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Page<Especialitat> get(@PathVariable int pagina, @PathVariable int quantitat) {
        return especialitatRepository.findAll(PageRequest.of(pagina, quantitat, Sort.by("descripcio").ascending()));
    }

    @GetMapping(path = "perCos/{idCos}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<EspecialitatProjection> get(@PathVariable String idCos) {
        return especialitatRepository.findAllByIdCosOrderByDescripcio(idCos);
    }

}
