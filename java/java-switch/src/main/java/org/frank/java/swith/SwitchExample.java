package org.frank.java.swith;

public class SwitchExample {
    public static void main(String[] args) {
        String day = "MONDAY";
        String typeOfDay;
        switch (day) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY": System.out.println("THURSDAY");
            case "FRIDAY":
                typeOfDay = "Weekday";
                break;
            case "SATURDAY":
            case "SUNDAY":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(day + " is a " + typeOfDay);
    }
}
