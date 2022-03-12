package cat.paucasesnoves.swdws.practicaspring.interins.controllers;

import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Illa;
import cat.paucasesnoves.swdws.practicaspring.interins.entitats.Localitat;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.IllaRepository;
import cat.paucasesnoves.swdws.practicaspring.interins.repositoris.LocalitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("web")
public class FrontController {
    @Autowired
    IllaRepository illaRepository;

    @Autowired
    LocalitatRepository localitatRepository;

    @GetMapping("illes")
    public String mostraIlles(Model model) {
        List<Illa> illes = illaRepository.findAll(Sort.by("nomIlla").ascending());
        model.addAttribute("illes", illes);
        return "illes";
    }

    @GetMapping("localitatsIlla")
    public String mostraIlles(Model model, @RequestParam String idIlla) {
        List<Localitat> localitats = localitatRepository.findAllByidIllaOrderByNomLocalitatAsc(idIlla);
        model.addAttribute("localitats", localitats);
        return "localitats";
    }

    @GetMapping("modificaLocalitat")
    public String modificaLocalitat(Model model, @RequestParam String idLocalitat) {
        Optional<Localitat> op = localitatRepository.findById(idLocalitat);
        if (op.isPresent()) {
            model.addAttribute("illes", illaRepository.findAll(Sort.by("nomIlla").ascending()));
            model.addAttribute("localitat", op.get());
            return "updateLocalitat";
        } else {
            model.addAttribute("Titol", "Error");
            model.addAttribute("missatge", "No s'ha trobat la localitat amb id " + idLocalitat);
            return "resultat";
        }
    }

    @PostMapping("modificaLocalitat")
    public String modificaLocalitat(@ModelAttribute Localitat nova, BindingResult errors, Model model) {
        if (localitatRepository.existsById(nova.getIdLocalitat())) {
            localitatRepository.save(nova);
            model.addAttribute("Titol", "Modificació realitzada");
            model.addAttribute("missatge", "La modificació s'ha efectuat correctament");
            model.addAttribute("localitat", nova);
        } else {
            model.addAttribute("Titol", "Error");
            model.addAttribute("missatge", "No s'ha trobat la localitat amb id " + nova.getIdLocalitat());
        }
        return "resultat";
    }
}