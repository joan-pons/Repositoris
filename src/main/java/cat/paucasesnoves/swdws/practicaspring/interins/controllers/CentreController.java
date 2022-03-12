package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.auxiliars.Missatge;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Centre;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.CentreProjection;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/centres")
public class CentreController {
    @Autowired
    CentreRepository centreRepository;

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
//    public List<Centre> get() {
//        return centreRepository.findAll();
//    }
      public List<CentreProjection> get() {
        return centreRepository.findByLocalitatIdIllaOrderByNomCentreAsc("072");
    }
    @GetMapping(value = "{idCentre}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity get(@PathVariable String idCentre) {
        Optional<Centre> byId = centreRepository.findById(idCentre);
        if (byId.isPresent())
            return ResponseEntity.ok(byId.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity insert(@RequestBody Centre centre) {
        System.out.println("centre = " + centre);
        if (centreRepository.existsById(centre.getIdCentre())) {
            return new ResponseEntity(new Missatge("Ja existeix un centre amb id " + centre.getIdCentre()), HttpStatus.BAD_REQUEST);
        }
        Centre saved = centreRepository.save(centre);
        return ResponseEntity.ok(saved);
    }

    @PutMapping(value = "{idCentre}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Centre centre, @PathVariable String idCentre) {
        System.out.println("centre = " + centre);
        if (!centreRepository.existsById(centre.getIdCentre())) {
            return new ResponseEntity(new Missatge("No existeix cap centre amb id " + centre.getIdCentre()), HttpStatus.NOT_FOUND);
        }
        if (!idCentre.equals(centre.getIdCentre())) {
            return new ResponseEntity(new Missatge("No coincideixen els idCentre del path i de l'objecte"), HttpStatus.BAD_REQUEST);
        }
        Centre saved = centreRepository.save(centre);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(value = "{idCentre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable String idCentre) {
        if (!centreRepository.existsById(idCentre)) {
            return new ResponseEntity(new Missatge("No existeix cap centre amb id " + idCentre), HttpStatus.NOT_FOUND);
        }
        centreRepository.deleteById(idCentre);
        return ResponseEntity.ok(new Missatge("Centre esborrat"));
    }

}
