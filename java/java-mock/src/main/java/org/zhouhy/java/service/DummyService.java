package org.zhouhy.java.service;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
    
    public String getDummyNameUpperCase(String Id){
        return Id.toUpperCase();
    }
}
