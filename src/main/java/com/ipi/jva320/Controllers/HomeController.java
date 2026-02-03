package com.ipi.jva320.Controllers;

import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private SalarieAideADomicileService salarieService;

    @GetMapping(value = "/")
    public String home(final ModelMap model) {
        // msg_home est maintenant géré via messages.properties avec #{msg_home} dans le template
        model.put("nombreSalaries", salarieService.countSalaries());
        return "home";
    }
}