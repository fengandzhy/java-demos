package org.frank.java.jackson.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import org.frank.java.jackson.beans.*;
import org.junit.Test;

import java.util.*;

public class JsonUtilTest {
    
    @Test
    public void testToJsonString1() {
        User u1 = new User(1, "a", 18);
        System.out.println(JsonUtil.toJsonString(u1));
    }

    @Test
    public void testToJsonString2() {
        User u1 = new User(1, "a", 18);
        User u2 = new User(2, "b", 18);
        App app = new App();
        app.setId(1);
        app.setName("app1");
        app.getUsers().add(u1);
        app.getUsers().add(u2);
        System.out.println(JsonUtil.toJsonString(app));
    }

    @Test
    public void testToJsonString3(){    
        Map<String,Integer> map=new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);

        System.out.println(JsonUtil.toJsonString(map));
    }

    @Test
    public void testToJsonString4() {
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

        System.out.println(JsonUtil.toJsonString(student));
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
    @SuppressWarnings("unchecked")
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
        Map<String,Object> map = JsonUtil.parseObject(jsonStr3, Map.class);
        System.out.println(map);        
        String msg = String.valueOf(Objects.requireNonNull(map).get("msg"));
        System.out.println(msg);
        List<User> dataList = (List<User>) map.get("data");
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
    public void testParseObjectWithClass5() {
        String jsonStr5 = "[{\"prov\":\"江苏\",\"cty\":\"南京\"},{\"prov\":\"安徽\",\"cty\":\"合肥\"}]";
        @SuppressWarnings("unchecked") List<Address> addresses = JsonUtil.parseObject(jsonStr5, List.class);
        System.out.println(addresses);
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
    @SuppressWarnings("unchecked")
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
        Map<String, Object> map = JsonUtil.parseObject(jsonStr3, new TypeReference<Map<String, Object>>(){});
        System.out.println(map);
        String  msg = String.valueOf(Objects.requireNonNull(map).get("msg"));
        System.out.println(msg);
        List<User> dataList = (List<User>) map.get("data");
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
