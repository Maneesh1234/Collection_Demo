package com.listdemo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class List_demo {

	public static void main(String[] args) {
		List<Integer> l= Arrays.asList(100,2,30,4,15,6,2,6);
		Collections.sort(l, (e1,e2)->e1>e2?-1:1);
		l.forEach(e->System.out.print(e+" "));
		
		String s="xy564fsaadc2000jjh00123ffdd5b";
		int n=s.length();
		int i=0;
		int m=0, val=0;
		System.out.println();
		while(i<n) {
			while(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9) {
				val=val*10+ s.charAt(i)-'0';
				i+=1;
			}
			if(m<val) m=val;
			val=0;
			i+=1;
			
		}
		System.out.println(m);
		
		System.out.println("find max in string with regular expression for long value");
		String regex="\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(s);
		BigInteger max=BigInteger.ZERO;
		while (matcher.find()) {
			BigInteger num = new BigInteger(matcher.group());
			if (num.compareTo(max)>0) max=num;
		}
		System.out.println(max);
	}

}
