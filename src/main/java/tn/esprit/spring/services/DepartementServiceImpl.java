package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.repository.DepartementRepository;

public class DepartementServiceImpl implements  DepartementService{
    @Autowired
    DepartementRepository departementRepository;


}
