package cat.paucasesnoves.swdws.practicaspring.sakila.controllers;

import cat.paucasesnoves.swdws.practicaspring.sakila.entitats.Film;
import cat.paucasesnoves.swdws.practicaspring.sakila.repositoris.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController {
    @Autowired
    FilmRepository filmRepository;

    @GetMapping(path = "",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Film> get(){
        return filmRepository.findAll();
    }
}
