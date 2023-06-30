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
    public void testApp(){
        User u1 = new User(1, "a", 18);
        User u2 = new User(2, "b", 18);
        App a1 = new App();
        a1.setId(1);
        a1.setName("app1");
        a1.getUsers().add(u1);
        a1.getUsers().add(u2);
        String appJson = JsonUtil.toJsonString(a1);
        System.out.println(appJson);
        App a2 = JsonUtil.parseObject(appJson, App.class);
        System.out.println(a2);

        App a3 = JsonUtil.parseObject(appJson, new TypeReference<App>(){});
        System.out.println(a3);
    }

    @Test
    public void testStudent(){
        Student student1 = new Student();
        student1.setTrueName("张三");
        Address address1 = new Address();
        address1.setCity("南京");
        address1.setProvince("江苏");

        Address address2 = new Address();
        address2.setCity("合肥");
        address2.setProvince("安徽");
        List<Address> list = new ArrayList<>();
        list.add(address1);
        list.add(address2);
        student1.setAddresses(list);
        
        String studentJson = JsonUtil.toJsonString(student1);
        System.out.println(studentJson);

        Student student2 = JsonUtil.parseObject(studentJson, Student.class);
        System.out.println(student2);

        Student student3 = JsonUtil.parseObject(studentJson, new TypeReference<Student>(){});
        System.out.println(student3);
    }    

    /**
     * 注意这里的驼峰设置 
     * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     * objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
     * 有了以上两个设置就可以把 firstName 转成 first_name  
     * */
    @Test
    public void testEmployee() {
        Employee e1 = new Employee("abc", "a");
        String employeeJson = JsonUtil.toJsonString(e1);
        System.out.println(employeeJson);
        Employee e2 = JsonUtil.parseSnakeObject(employeeJson, Employee.class);
        System.out.println(e2);        
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
