package org.frank.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    
    @Test
    public void Test() throws JsonProcessingException {
        Student student = new Student();
        student.setTrueName("张三");
        Address address1 = new Address();
        address1.setCity("南京");
        address1.setProvince("江苏");

        Address address2 = new Address();
        address2.setCity("合肥");
        address2.setProvince("安徽");
        List<Address> list = new ArrayList<>();
        list.add(address1);
        list.add(address2);
        student.setAddresses(list);
        System.out.println(new ObjectMapper().writeValueAsString(student));
    }
}
