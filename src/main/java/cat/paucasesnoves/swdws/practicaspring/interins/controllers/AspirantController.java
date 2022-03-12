package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Aspirant;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.AspirantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/aspirants")
public class AspirantController {

    @Autowired
    private AspirantRepository aspirantRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Aspirant> get(){
        return aspirantRepository.findAll();
    }
}
