package org.zhouhy.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.java.repository.DummyRepository;

@Service
public class DummyService {
    
    @Autowired
    private DummyRepository repository;
    
    public String getDummyNameUpperCase(String Id){
        repository.findById(Id);
        return Id.toUpperCase();
    }
}
