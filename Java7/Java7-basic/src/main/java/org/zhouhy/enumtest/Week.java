package org.zhouhy.enumtest;


/**
1）使用enum定义的枚举类默认继承了java.lang.Enum，实现了java.lang.Comparable接口，且不能继承其他类，也不可以被继承。
但枚举类可以实现一个或多个接口。想深入学习必须挖Enum的源码。
2）枚举类的所有实例必须放在第一行显示，不需使用new，不需显示调用构造方法，每个变量都是public static final修饰的，最终以分号结束。
在之后的反编译中，我们就可以理解枚举类其实也是颗语法糖。
3）枚举类的构造方法是私有的，默认的就是private，定义的时候不加也没事。
4）switch()参数可以使用enum。这个在后文有详细代码。
5）非抽象枚举类默认是final的但定义的时候加上final却编译不通过。我们通过后续的反编译可以得到验证。
6）枚举类可以有抽象方法，但是必须在它的实例中实现。后续也会验证这一条。
 * */
public enum Week {
	MONDAY(0,"星期一"),
	TUESDAY(1,"星期二"),
	WEDNESDAY(2,"星期三"),
    THURSDAY(3,"星期四"),
    FRIDAY(4,"星期五"),
    SATURDAY(5,"星期六"),   
    SUNDAY(6,"星期日"); //最后一个类型必须要用分号结束
	
	private int num;
	private String desc;
	
	Week(int num,String desc){
		this.num = num;
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public static Week getWeekByDay(){
		return Week.FRIDAY;
	}
	
	@Override
	public String toString() {
		switch (this) {
	        case MONDAY:
	            return "今天星期一";
	        case TUESDAY:
	            return "今天星期二";
	        case WEDNESDAY:
	            return "今天星期三";
	        case THURSDAY:
	            return "今天星期四";
	        case FRIDAY:
	            return "今天星期五";
	        case SATURDAY:
	            return "今天星期六";
	        case SUNDAY:
	            return "今天星期日";
	        default:
	            return "Unknow Day";
	    }
	}
}
