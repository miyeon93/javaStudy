package ch14;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda_ex2 {
	
	public static void main(String[] args) {

		//1.5 1.함수의 결합
		
		Function<String, Integer> f = s -> Integer.parseInt(s, 16); //16진수s란  
		Function<Integer, String> g = i -> Integer.toBinaryString(i); //이진수i 
		
		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println("5-1 andThen FF = "+h.apply("FF")); //"FF" -> 255 -> "11111"
		System.out.println("5-1 compose 2 = "+h2.apply(2)); // 2 -> "10" -> 16 
		
		Function<String, String> f2 = x -> x; //항등함수
//		Function<String,String> f3 = Function.identity();
		System.out.println("5-1 identity = "+f2.apply("AAA"));
//		System.out.println("5-1 identity = "+f3.apply("AAA"));
		System.out.println();
		
		
		//1.5 2. predicate의 결합
		Predicate<Integer> p = i -> i < 100; 
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate(); //i >= 100
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println("5-2 predicate :: ( i>=100 && (i<200 || i%2==0) ) : 150 => "+all.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = "aaa";
		
		Predicate<String> p2 = Predicate.isEqual((str1));
		boolean result1 = p2.test(str2);
		boolean result2 = p2.test(str3);
		
		System.out.println("5-2 isEqual :: str1=abc, str2=abc => "+result1);
		System.out.println("5-2 isEqual :: str1=abc, str3=aaa => "+result2);
		

		
		
	}

}
