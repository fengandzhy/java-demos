package org.zhouhy.java.demo02;

public class ClassC {
    private String name;
    private int c = 3;
    public void fun1(){
        final int a = 5;
        int b = 4;
        class ClassD{
            String name;
            void innerFun1(){
                System.out.println(c);
                System.out.println(a);
                System.out.println(b);
                System.out.println(name);
                System.out.println(ClassC.this.name);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        ClassD d = new ClassD();
        d.setName("D");
        d.innerFun1();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
