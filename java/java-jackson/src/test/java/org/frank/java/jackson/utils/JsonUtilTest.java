package org.frank.java.jackson.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import org.frank.java.jackson.beans.App;
import org.frank.java.jackson.beans.StatusBean;
import org.frank.java.jackson.beans.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
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
    public void testParseObjectWithClass1() {
        String jsonStr1 = "{\"id\":1,\"name\":\"a\",\"age\":18}";
        User user = JsonUtil.parseObject(jsonStr1, User.class);
        System.out.println(user);
    }
    
    @Test
    public void testParseObjectWithClass2() {
        String jsonStr2 = "{\"id\":1,\"name\":\"app1\",\"users\":[{\"id\":1,\"name\":\"a\",\"age\":18},{\"id\":2,\"name\":\"b\",\"age\":18}]}";
        App app = JsonUtil.parseObject(jsonStr2, App.class);
        System.out.println(app);
    }

    @Test
    public void testParseObjectWithClass3() {
        String jsonStr3 = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 101,\n" +
                "\t\t\t\"name\": \"JCccc1\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 102,\n" +
                "\t\t\t\"name\": \"JCccc2\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 103,\n" +
                "\t\t\t\"name\": \"JCccc3\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"status\": 200\n" +
                "}\n";
        Map<String, Object> map = JsonUtil.parseObject(jsonStr3, Map.class);
        System.out.println(map);
        String msg = String.valueOf(map.get("msg"));
        System.out.println(msg);
        List dataList = (List) map.get("data");
        System.out.println(dataList.toString());
    }

    @Test
    public void testParseObjectWithClass4() {
        String jsonStr4 = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 101,\n" +
                "\t\t\t\"name\": \"JCccc1\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 102,\n" +
                "\t\t\t\"name\": \"JCccc2\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 103,\n" +
                "\t\t\t\"name\": \"JCccc3\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"status\": 200\n" +
                "}\n";
        StatusBean bean = JsonUtil.parseObject(jsonStr4, StatusBean.class);
        System.out.println(bean);
    }

    @Test
    public void testParseObjectWithTypeReference1() {
        String jsonStr1 = "{\"id\":1,\"name\":\"a\",\"age\":18}";
        User user = JsonUtil.parseObject(jsonStr1, new TypeReference<User>() {
        });
        System.out.println(user);
    }

    @Test
    public void testParseObjectWithTypeReference2() {
        String jsonStr2 = "{\"id\":1,\"name\":\"app1\",\"users\":[{\"id\":1,\"name\":\"a\",\"age\":18},{\"id\":2,\"name\":\"b\",\"age\":18}]}";
        App app = JsonUtil.parseObject(jsonStr2, new TypeReference<App>() {
        });
        System.out.println(app);
    }

    @Test
    public void testParseObjectWithTypeReference3() {
        String jsonStr3 = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 101,\n" +
                "\t\t\t\"name\": \"JCccc1\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 102,\n" +
                "\t\t\t\"name\": \"JCccc2\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 103,\n" +
                "\t\t\t\"name\": \"JCccc3\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"status\": 200\n" +
                "}\n" ;
        Map<String, Object> map = JsonUtil.parseObject(jsonStr3, new TypeReference<Map>(){});
        System.out.println(map);
        String  msg = String.valueOf(map.get("msg"));
        System.out.println(msg);
        List dataList = (List) map.get("data");
        System.out.println(dataList.toString());        
    }

    @Test
    public void testParseObjectWithTypeReference4() {
        String jsonStr4 = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 101,\n" +
                "\t\t\t\"name\": \"JCccc1\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 102,\n" +
                "\t\t\t\"name\": \"JCccc2\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 103,\n" +
                "\t\t\t\"name\": \"JCccc3\",\n" +
                "\t\t\t\"age\": 18\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"status\": 200\n" +
                "}\n";
        StatusBean bean = JsonUtil.parseObject(jsonStr4, new TypeReference<StatusBean>(){});
        System.out.println(bean);
    }
}
