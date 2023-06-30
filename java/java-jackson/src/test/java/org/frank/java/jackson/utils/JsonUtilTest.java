package org.frank.java.jackson.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import org.frank.java.jackson.beans.*;
import org.junit.Test;

import java.util.*;

public class JsonUtilTest {
    
    @Test
    public void testUser(){
        User u1 = new User(1, "a", 18);
        String userJson = JsonUtil.toJsonString(u1);
        System.out.println(userJson);

        User u2 = JsonUtil.parseObject(userJson, User.class);
        System.out.println(u2);

        User u3 = JsonUtil.parseObject(userJson, new TypeReference<User>(){});
        System.out.println(u3);

        assert u2 != null;
        System.out.println(u2.equals(u3));        
    }
    
    
    @Test    
    public void testMap(){
        Map<String,Integer> map1=new HashMap<>();
        map1.put("A",1);
        map1.put("B",2);
        map1.put("C",3);
        map1.put("D",4);
        String mapJson = JsonUtil.toJsonString(map1);
        System.out.println(JsonUtil.toJsonString(mapJson));

        @SuppressWarnings("unchecked") Map<String,Integer> map2 = JsonUtil.parseObject(mapJson, Map.class);
        System.out.println(map2);

        Map<String,Integer> map3 = JsonUtil.parseObject(mapJson, new TypeReference<Map<String,Integer>>(){});
        System.out.println(map3);
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
    public void testToJsonString5() {
        Employee e1 = new Employee("abc", "a");
        System.out.println(JsonUtil.toJsonString(e1));
    }

    @Test
    public void testToJsonString6() {
        Manager manager = new Manager("a", new Date());
        System.out.println(JsonUtil.toJsonString(manager));
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
    @SuppressWarnings("unchecked")
    public void testParseObjectWithClass5() {
        String jsonStr5 = "[{\"prov\":\"江苏\",\"cty\":\"南京\"},{\"prov\":\"安徽\",\"cty\":\"合肥\"}]";
        List<Address> addresses = JsonUtil.parseObject(jsonStr5, List.class);
        System.out.println(addresses);
    }

    /**
     * @JsonProperty 序列化反序列化都管用 转成json string 的时候, trueName 变成 name
     * 由json string 转成bean 的时候, name 会直接赋值到 trueName 上
     * 
     * */
    @Test    
    public void testParseObjectWithClass6() {
        String jsonStr6 = "{\"name\":\"张三\",\"addresses\":[{\"prov\":\"江苏\",\"cty\":\"南京\"},{\"prov\":\"安徽\",\"cty\":\"合肥\"}]}";
        Student student = JsonUtil.parseObject(jsonStr6, Student.class);
        System.out.println(student);
    }

    @Test
    public void testParseObjectWithClass7() {
        new Manager("a", new Date());
        String jsonStr7 = JsonUtil.toJsonString(new Manager("a", new Date()));
        System.out.println(jsonStr7);
        
        Manager manager = JsonUtil.parseObject(jsonStr7, Manager.class);
        System.out.println(manager);
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

    /**
     *  相比于上面的List<Address> addresses = JsonUtil.parseObject(jsonStr5, List.class); 
     *  这里写成 List<Address> addresses = JsonUtil.parseObject(jsonStr5, new TypeReference<List<Address>>(){}); 只是起到了避免警告的作用
     * 
     * */
    @Test    
    public void testParseObjectWithTypeReference5() {
        String jsonStr5 = "[{\"prov\":\"江苏\",\"cty\":\"南京\"},{\"prov\":\"安徽\",\"cty\":\"合肥\"}]";
        List<Address> addresses = JsonUtil.parseObject(jsonStr5, new TypeReference<List<Address>>(){});
        System.out.println(addresses);
    }

    @Test
    public void testParseSnakeObject1() {
        String jsonStr1 = "{\"first_name\":\"abc\",\"last_name\":\"a\"}";
        Employee employee = JsonUtil.parseSnakeObject(jsonStr1, Employee.class);
        System.out.println(employee);
    }
}
