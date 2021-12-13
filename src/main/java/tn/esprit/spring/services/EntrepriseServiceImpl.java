package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.repository.EntrepriseRepository;

public class EntrepriseServiceImpl implements EntrepriseService {


    @Autowired
    EntrepriseRepository entrepriseRepository;

}
