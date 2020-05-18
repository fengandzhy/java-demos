package org.zhouhy.stream.entity;

public class Transaction {
	private final Trader trader;
    private final Integer year;
    private final Integer value;
    
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    
    public Trader getTrader() {
        return this.trader;
    }

    public Integer getYear() {
        return this.year;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}
