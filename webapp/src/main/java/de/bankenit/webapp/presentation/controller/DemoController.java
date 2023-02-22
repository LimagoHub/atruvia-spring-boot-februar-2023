package de.bankenit.webapp.presentation.controller;


import de.bankenit.webapp.aspects.Dozent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Dozent
@RestController
@RequestMapping("/demo") // Virtueller Ordner
public class DemoController {


    @GetMapping(path = "/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
    public String gruss() {
        return "Hallo Rest!";
    }
}
