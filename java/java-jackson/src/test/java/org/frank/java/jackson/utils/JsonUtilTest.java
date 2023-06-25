package org.frank.java.jackson.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import org.frank.java.jackson.beans.App;
import org.frank.java.jackson.beans.User;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

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

        Map map=new HashMap();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);

        System.out.println(JsonUtil.toJsonString(map));
    }
    
    @Test
    public void testParseObjectWithClass(){
        String jsonStr1 = "{\"id\":1,\"name\":\"a\",\"age\":18}";
        User user = JsonUtil.parseObject(jsonStr1, User.class);
        System.out.println(user);
        
        String jsonStr2 = "{\"id\":1,\"name\":\"app1\",\"users\":[{\"id\":1,\"name\":\"a\",\"age\":18},{\"id\":2,\"name\":\"b\",\"age\":18}]}";
        App app = JsonUtil.parseObject(jsonStr2, App.class);
        System.out.println(app);
        
        
    }

    @Test
    public void testParseObjectWithTypeReference(){
        String jsonStr1 = "{\"id\":1,\"name\":\"a\",\"age\":18}";
        User user = JsonUtil.parseObject(jsonStr1, new TypeReference<User>(){});
        System.out.println(user);

        String jsonStr2 = "{\"id\":1,\"name\":\"app1\",\"users\":[{\"id\":1,\"name\":\"a\",\"age\":18},{\"id\":2,\"name\":\"b\",\"age\":18}]}";
        App app = JsonUtil.parseObject(jsonStr2, new TypeReference<App>(){});
        System.out.println(app);
        
    }
}
