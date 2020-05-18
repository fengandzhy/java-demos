package org.zhouhy.stream.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

import org.zhouhy.stream.entity.Trader;
import org.zhouhy.stream.entity.Transaction;

public class StreamTest {

	private List<Transaction> transactions = null;
	
	@Before
	public void setUp() throws Exception {
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        this.transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
	}

	
	@Test 
	/**
	 * Find all transactions in the year 2011 and sort them by value (small to high).
	 * */
	public void test1() {		
		List<Transaction> result = transactions.stream().filter(t->t.getYear() == 2011)
									.sorted(Comparator.comparing(Transaction::getValue))
									.collect(Collectors.toList());
		System.out.println(result);
	}
	
	@Test 
	/**
	 * 2.What are all the unique cities where the traders work?
	 * */
	public void test2() {
		transactions.stream().map(t->t.getTrader().getCity())
		.distinct().forEach(System.out::println);
	}
	
	@Test 
	/**
	 * 3.Find all traders from Cambridge and sort them by name.
	 * */
	public void test3() {
		List<Trader> traders = transactions.stream().map(t->t.getTrader())
								.filter(t->t.getCity().equals("Cambridge"))
								.distinct()
								.sorted(Comparator.comparing(Trader::getName))
								.collect(Collectors.toList());
		System.out.println(traders);
	}
	
	@Test 
	/**
	 * 4.Return a string of all traders¡¯ names sorted alphabetically
	 * */
	public void test4() {
		String name = transactions.stream().map(t->t.getTrader().getName())
							.distinct()
							.sorted()							
							.reduce("", (n1,n2)->n1+","+n2).substring(1);
		System.out.println(name);
	}
	
	@Test 
	/**
	 * 5.Are any traders based in Milan?
	 * */
	public void test5() {
		boolean liveInMilan1 = transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
		System.out.println(liveInMilan1);
	}
	
	@Test 
	/**
	 * 6.Print all transactions¡¯ values from the traders living in Cambridge
	 * */
	public void test6() {
		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
								.map(t->t.getValue())
								.forEach(System.out::println);
	}
	
	@Test 
	/**
	 * 7.What¡¯s the highest value of all the transactions?
	 * */
	public void test7() {
		Integer value = transactions.stream().mapToInt(Transaction::getValue).max().getAsInt();
		System.out.println(value);
	}
	
	@Test 
	/**
	 * 8.Find the transaction with the smallest value?
	 * */
	public void test8() {
		Transaction transaction = transactions.stream().sorted(Comparator.comparing(t->t.getValue()))
		.collect(Collectors.toList()).get(0);
		
		System.out.println(transaction);
	}
	
}
