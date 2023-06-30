package org.frank.java.repository;

import org.springframework.stereotype.Repository;
import org.frank.java.entity.Dummy;

@Repository
public class DummyRepository {
    
    public Dummy findById(String Id){
        return new Dummy();
    }
}
