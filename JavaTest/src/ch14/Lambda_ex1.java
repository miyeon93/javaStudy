package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Lambda_ex1 {
	
	/**
	 * java.util.function example  
	 * @param args
	 */
	public static void main(String[] args) {
	
		//Supplier 
		Supplier<Integer> supplier = () -> (int) (Math.random()*100)+1;
		System.out.println("1-1. supplier = "+supplier.get());
				
		//Consumer
		Consumer<String> consumer = str -> System.out.println("1-2. consumer = "+str);
		consumer.accept("string");
		
		//Function
		Function<Integer, Integer> function = i -> i+1;
		System.out.println("1-3. function = "+function.apply(1));
		
		UnaryOperator<Integer> uFunction = i -> i+1;
		System.out.println("-> 3-1. function to unaryOperator = "+uFunction.apply(1));
		
		
		//Predicate
		Predicate<Integer> pred = i -> i % 2 == 0;
		System.out.println("1-4. predicate = "+pred.test(4));
		System.out.println();
		
		
		//BiFunction
		BiFunction<Integer,Integer, Integer> maxF = (c, d) -> c > d ? c : d;
		System.out.println("2-1. biFunction = "+maxF.apply(10, 4));
		
		BinaryOperator<Integer> maxBo = (c, d) -> c > d ? c : d;
		System.out.println("-> 3-2. biFunction to binaryOperator = "+maxBo.apply(10,4));
		System.out.println();
		
		//매개변수 3개
		Lambda_param3<String, Integer, Integer, String> t = (str, int1, int2) -> str+" - [ 출근 : "+int1+", 퇴근 : "+int2+" ]"; 
		System.out.println("-> 3-3. "+t.apply("연면", 10, 19));
		System.out.println();
		
		//
		//collection
		List<Integer> arrList = new ArrayList<>();
		for(int i=0; i<10; i++) {
			arrList.add(i);
		}
		
		//void forEach(BiConsumer<K,V> action)
		System.out.println("4-1. foreach =");
		arrList.forEach(i -> System.out.println(i+" , "));
		System.out.println();
		
		//boolean removeIf(Predicate<E> filter)
		arrList.removeIf(x -> x%2==0 || x %3==0);
		System.out.println("4-2. removeIf = "+arrList);
		System.out.println();
		
		//void replaceAll(
		arrList.replaceAll(i -> i*10);
		System.out.println("4-3. replaceAll = "+arrList);
		System.out.println();
		
		
		// 5. 기본형
		List<Integer> alist = new ArrayList<>();
		Supplier<Integer> sa = () -> (int) (Math.random()*100)+1;
		makeRandomList(sa,alist);
		System.out.println("5-1. supplier<T> = "+alist);
		
		List<Integer> blist = new ArrayList<>();
		IntSupplier sb = () -> (int) (Math.random()*100)+1;
		makeRandomList(sb,blist);
		System.out.println("5-2. IntSupplier = "+blist);
		
		
//		Function fa = a -> a * 2;
//		Function<Integer, Integer> fa2 = a -> a * 2;
//		IntFunction<Integer> fi = (a) -> a * 2;
//		UnaryOperator<Integer> fo1 = a -> a * 2;
//		IntUnaryOperator fo = a -> a * 2; //오토박싱 언박싱 수가 줄어들어 성능이더 좋다
		

	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
	
	static <T> void makeRandomList(IntSupplier s, List<Integer> list) {
		for(int i=0; i<10; i++) {
			list.add(s.getAsInt());
		}
	}
	
	
	
}
