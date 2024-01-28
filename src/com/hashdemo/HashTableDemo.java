package com.hashdemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
//HashMap doesn’t provide any Enumeration, while Hashtable provides not fail-fast Enumeration.
// Hashtable synchronized (slow performance) ---thread safe
//HashMap unsynchronized---HashMap are not thread-safe,
//LinkedHashMap is a variation of HashMap that preserves the insertion order.
// TreeMap stored element in sorted order according to key
// If thread safety is required, ConcurrentHashMap can be used. (or Hashtable)
// Hashing is a technique of converting a large String to a small String that represents the same String. 
//Map m = Collections.synchronizedMap(new HashMap(...));      //sychronized hashmap
//Failfast - concurrent modification not -- ConcurrentModificationException --- ArrayList, HashMap,Vector, Hashtable, HashSet
//Fail safe - CopyOnWriteArrayList(), ConcurrentHashMap
// HashSet --- normal set, TreeSet--- Sorted order set , LinkedHashSet - Preserve insertion order
//Set , addAll(collection) - union, retainAll(collection)- intersection, removeAll(collection) - difference
public class HashTableDemo {
	public static void main(String[] args) {
		Hashtable<String, Integer> hashtable=new Hashtable<>(5);
		hashtable.put("Maneesh", 90);
		hashtable.put("mark", 85);
		hashtable.put("ant", 95);
		hashtable.put("Mannesh1", 190);
		hashtable.put("mark1", 185);
		hashtable.put("ant1", 195);
		
		
		int val=hashtable.get("mark");
		System.out.println(val);
		
		Enumeration<String> keys=hashtable.keys();
		
		hashtable.remove("mark");
		
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			
			System.out.println("Key : "+ key + " Value : " + hashtable.get(key) );
			
		}
		
		//check whether key prsent or not
		if (hashtable.containsKey("Maneesh")) {
			System.out.println("Maneesh : " +hashtable.get("Maneesh"));
			
		}
		//iterating via enhanced for loop
		for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
			var key = entry.getKey();
			 val = entry.getValue();
			 System.out.println("Key : "+ key + " value : "+ val );
			
		}
		
		System.out.println("Iterator");
		
		Iterator it=hashtable.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key +" "+ hashtable.get(key));
			
		}
		
		System.out.println("fail fast Iterator give error when modify during iteration: For error uncomment 70 line"); 
		Map <String,Integer> m=new HashMap<>(hashtable);
		it=m.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key +" "+ m.get(key));
			//m.put("raju", 70);
			
		}
		
		System.out.println("Fail Safe Iterator: created seprate copy for iteration");
		CopyOnWriteArrayList<Integer> copyon= new CopyOnWriteArrayList <Integer>(new Integer[] {2,5,1,9,7});
		it = copyon.iterator();
		while (it.hasNext()) {
			val = (Integer) it.next();
			System.out.println(val);
			if (val==1) copyon.add(15);
			
			
		}
		
		System.out.println("Fail Safe Iterator: not created seprate copy for iteration (work on original object only)");
		ConcurrentHashMap<String, Integer> conmap=new ConcurrentHashMap<>(hashtable);
		it=conmap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key+ " "+ conmap.get(key));
			conmap.put("one", 1);
			
		}
		
		Stack<Integer> s=new Stack<>();
		for (int i = 0; i < 5; i++) {
			
			s.add(i+1);
			
		}
		System.out.println(s.peek()+" "+s.search(2)+ " "+s.toString()+" "+s.empty());
		
		System.out.println("*********Unmodifiable HashMap*********");
		Map<String, Integer> readOnlyMap = Collections.unmodifiableMap(hashtable);
		
		//readOnlyMap.put("Sanu", 5);
		System.out.println(readOnlyMap);
		
		
		System.out.println("**********Map without generics**********");
		Map myMap= new HashMap();
		myMap.put("maneesh", 1);
		myMap.put("raju", 2);
		myMap.put(5, "my");
		Iterator it1=myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = (String) it1.next().toString();
			System.out.println(myMap.get(key));
			
		}
		
		
		
		
	
	}
}
