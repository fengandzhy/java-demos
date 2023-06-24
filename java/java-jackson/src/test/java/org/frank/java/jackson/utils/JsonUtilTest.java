package org.frank.java.jackson.utils;


import org.frank.java.jackson.beans.App;
import org.frank.java.jackson.beans.User;
import org.junit.Test;

public class JsonUtilTest {
    
    @Test
    public void testToJsonString(){
        User u1 = new User(1,"a",18);
        System.out.println(JsonUtil.toJsonString(u1));

        User u2 = new User(2,"b",18);
        App app = new App();
        app.setId(1);
        app.setName("app1");
        app.getUsers().add(u1);
        app.getUsers().add(u2);

        System.out.println(JsonUtil.toJsonString(app));        
    }
}
