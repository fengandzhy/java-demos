package org.frank.java17;

public class SwitchExpressionComplexExample {
    public static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                // 闰年检查
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }

    public static void main(String[] args) {
        int days = getDaysInMonth(2, 2020);
        System.out.println(days); // 输出: 29
    }
}
