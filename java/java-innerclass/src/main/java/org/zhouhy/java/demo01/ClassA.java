package org.zhouhy.java.demo01;

public class ClassA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "name='" + name + '\'' +
                '}';
    }

    public class ClassB {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ClassB{" +
                    "name='" + name + '\'' +
                    '}';
        }
        
        public void print(){
            System.out.println(name+","+this.name);
        }
    }   
}
