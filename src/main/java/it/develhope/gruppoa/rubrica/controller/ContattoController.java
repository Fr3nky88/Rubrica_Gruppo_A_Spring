package it.develhope.gruppoa.rubrica.controller;

import it.develhope.gruppoa.rubrica.model.Contatto;
import it.develhope.gruppoa.rubrica.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contatto/v1")
public class ContattoController {

    @Autowired
    private ContattoService contattoService;

    @GetMapping(path = "/contatti", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contatto> getContatti() {
        return contattoService.getContatti();
    }
}
