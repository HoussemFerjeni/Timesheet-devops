package tn.esprit.spring.services;

import tn.esprit.spring.entities.Contrat;

import java.util.List;


public interface ContratService {

    List<Contrat> retrieveAllContrat();
    Contrat addContrat(Contrat c);
    void deleteContrat(String id);
    Contrat retrivecontratbyid(String id);
    Contrat updateContrat(Contrat c);
}
