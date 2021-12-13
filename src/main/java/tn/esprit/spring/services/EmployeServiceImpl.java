package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements EmployeService{

    @Autowired
    EmployeRepository employeRepository;



}
