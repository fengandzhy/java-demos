package org.frank.java17;

/**
 * switch 中可以使用yield 作为 返回值, Java 8 的 switch 是不能有返回值的
 * 用箭头代替了: 
 * */
public class SwitchExample {
    public static void main(String[] args) {
        String day = "MONDAY";
        String typeOfDay = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> {yield "WorkDay";}
            case "SATURDAY", "SUNDAY" -> "Weekend";
            case "OTHER" -> {
                System.out.println("We are Other");
                yield "Other";
            }
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(day + " is a " + typeOfDay);
    }
}
