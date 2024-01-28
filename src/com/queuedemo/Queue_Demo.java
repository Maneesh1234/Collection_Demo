package com.queuedemo;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Demo {
	public static void main(String[] args) {
		Queue<Integer> q= new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(0);
		
		Queue<Integer> q2= new LinkedList<>();
		q2.add(1);
		q2.add(2);
		q2.add(0);
		System.out.println(q.containsAll(q2));
		if (q.equals(q2))
			System.out.println("Value: "+q.equals(q2));
		else 
			System.out.println("Not equal : "+q.equals(q2));
	}

}

