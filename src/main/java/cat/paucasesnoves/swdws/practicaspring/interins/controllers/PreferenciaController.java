package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Preferencia;
import cat.paucasesnoves.swdws.practicaspring.interins.projeccions.PreferenciaProjection;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.PreferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/preferencies")
public class PreferenciaController {
    @Autowired
    PreferenciaRepository preferenciaRepository;

    @GetMapping(value = "", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Preferencia> get() {
        return preferenciaRepository.findAll();
    }

    @GetMapping("nif/{nif}-{idCos}")
    public ResponseEntity getPerNif(@PathVariable String nif, @PathVariable String idCos) {
        List<PreferenciaProjection> llista = preferenciaRepository.findByNifAndIdCosOrderByOrdreAsc(nif, idCos);
        if(!llista.isEmpty()){
            return ResponseEntity.ok(llista);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value="", consumes = MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity insert(@RequestBody Preferencia nova){
//        if(preferenciaRepository.existsById(nova.getPreferenciaPk()))
        preferenciaRepository.save(nova);
        return ResponseEntity.ok(nova);
    }
}
