package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService{
    @Autowired
    ContratRepository contratRepository;

    private static final Logger l = LogManager.getLogger(UserServiceImpl.class);



    @Override
    public List<Contrat> retrieveAllContrat() {
        List<Contrat> cont = null;
        try {
            l.info("start retrieve all contrats");
            cont = (List<Contrat>) contratRepository.findAll();
            for (Contrat ct : cont) {
                l.info("contrat : {}", ct);
            }
            l.info("all contrats retrieved");
        }catch (Exception e) {
            l.error("out with error"+e);
        }
        return cont;
    }


    @Override
    public Contrat addContrat(Contrat c) {
        l.info("Ajouter contrat");
        Contrat c_saved = contratRepository.save(c);
        l.info("contrat {} is created", c_saved);
        return c_saved;
    }

    @Override
    public void deleteContrat(String id) {
        l.info("start deletion");
        contratRepository.deleteById(Integer.parseInt(id));
        l.info("user with id '{}' is deleted", id);
    }

    @Override
    public Contrat updateContrat(Contrat u) {
        l.info("start modification");
        Contrat u_saved = contratRepository.save(u);
        l.info("contrat {} is modified as {} ", u, u_saved);
        return u_saved;
    }

    @Override
    public Contrat retrivecontratbyid(String id) {
        l.info("start retrieve");
        Contrat u =  contratRepository.findById(Integer.parseInt(id)).orElse(null);
        l.info("contrat {} has been retrieved", u);
        return u;
    }
}
