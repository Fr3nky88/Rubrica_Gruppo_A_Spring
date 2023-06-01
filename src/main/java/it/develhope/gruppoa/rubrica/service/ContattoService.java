package it.develhope.gruppoa.rubrica.service;

import it.develhope.gruppoa.rubrica.dao.ContattoDao;
import it.develhope.gruppoa.rubrica.model.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoService {

    @Autowired
    private ContattoDao contattoDao;

    public List<Contatto> getContatti() {
        return contattoDao.getContatti();
    }
}
