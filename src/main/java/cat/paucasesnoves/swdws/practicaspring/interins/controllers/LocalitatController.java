package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.errades.InterinsException;
import cat.paucasesnoves.swdws.practicaspring.interins.auxiliars.Missatge;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Localitat;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.LocalitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/localitats")
public class LocalitatController {

    @Autowired
    private LocalitatRepository localitatRepository;

    @GetMapping(path = "", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Localitat> get() {
        return localitatRepository.findAll();
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Missatge> post(@RequestBody Localitat nova) {
        if (nova.getIdLocalitat() == null || nova.getNomLocalitat() == null || nova.getIdIlla() == null) {
            throw new InterinsException("Han arribat dades obligatòries sense valor.", HttpStatus.NOT_ACCEPTABLE);
        }
        if (localitatRepository.existsById(nova.getIdLocalitat())) {
            throw new InterinsException("Ja hi ha una localitat amb aquest identificador", HttpStatus.FOUND);
        }
        localitatRepository.save(nova);
        return ResponseEntity.ok(new Missatge("Inserció efectuada"));

    }

    @PutMapping(path = "{idLocalitat}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Missatge> put(@PathVariable String idLocalitat, @RequestBody Localitat nova) {
        if (nova.getIdLocalitat() == null || nova.getNomLocalitat() == null || nova.getIdIlla() == null) {
            throw new InterinsException("Han arribat dades obligatòries sense valor.", HttpStatus.NOT_ACCEPTABLE);
        }
        if (!localitatRepository.existsById(nova.getIdLocalitat())) {
            throw new InterinsException("No hi ha cap localitat amb aquest identificador", HttpStatus.FOUND);
        }
        if (!idLocalitat.equalsIgnoreCase(nova.getIdLocalitat())) {
            throw new InterinsException("Els identificadors no coincideixen", HttpStatus.NOT_ACCEPTABLE);
        }
        localitatRepository.save(nova);
        return ResponseEntity.ok(new Missatge("Modificació efectuada"));

    }
}
