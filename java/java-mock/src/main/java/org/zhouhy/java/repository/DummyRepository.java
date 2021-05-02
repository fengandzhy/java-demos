package org.zhouhy.java.repository;

import org.springframework.stereotype.Repository;
import org.zhouhy.java.entity.Dummy;

@Repository
public class DummyRepository {
    
    public Dummy findById(String Id){
        return new Dummy();
    }
}
