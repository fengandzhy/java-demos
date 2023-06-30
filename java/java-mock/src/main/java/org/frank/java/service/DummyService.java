package org.frank.java.service;

import org.frank.java.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
    
    @Autowired
    private DummyRepository repository;
    
    public String getDummyNameUpperCase(String Id){
        repository.findById(Id);
        return Id.toUpperCase();
    }
}
