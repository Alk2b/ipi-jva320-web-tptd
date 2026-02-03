package com.ipi.jva320.Controllers;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalarieController {

    @Autowired
    private SalarieAideADomicileService salarieService;

    @GetMapping(value = "/salaries")
    public String listSalaries(ModelMap model) {
        model.put("salaries", salarieService.getSalaries());
        model.put("nombreSalaries", salarieService.countSalaries());
        return "list";
    }

    @GetMapping(value = "/salaries/{id}")
    public String getSalarie(final ModelMap model,
                             @PathVariable Long id) {
        SalarieAideADomicile salarie = salarieService.getSalarie(id);
        model.put("salarie", salarie);
        model.put("nombreSalaries", salarieService.countSalaries());

        return "detail_Salarie";
    }


    @GetMapping(value = "/salaries/aide/new")
    public String newSalarie(final ModelMap model) {
        model.put("salarie", new SalarieAideADomicile());
        model.put("nombreSalaries", salarieService.countSalaries());
        return "detail_Salarie";
    }

    @PostMapping(value = "/salaries/save")
    public String saveSalarie(SalarieAideADomicile salarie) throws SalarieException {
        salarieService.creerSalarieAideADomicile(salarie);
        return "redirect:/salaries/" + salarie.getId();
    }

    @PostMapping(value = "/salaries/{id}")
    public String updateSalarie(@PathVariable Long id, SalarieAideADomicile salarie) throws SalarieException {
        salarie.setId(id);
        salarieService.updateSalarieAideADomicile(salarie);
        return "redirect:/salaries/" + id;
    }

    @GetMapping(value = "/salaries/{id}/delete")
    public String deleteSalarie(@PathVariable Long id) throws SalarieException {
        salarieService.deleteSalarieAideADomicile(id);
        return "redirect:/salaries";
    }
}