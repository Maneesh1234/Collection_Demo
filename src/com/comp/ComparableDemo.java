package com.comp;
import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	int id;
	String name;
	int age;
	
	@Override
	public int compareTo(Student o) {
		if (age>o.age) return 1;
		else if (age<o.age) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
public class ComparableDemo {
	public static void main(String[] args) {
		Student s1=new Student(1, "Maneesh",25);
		Student s2=new Student(2, "Raju",52);
		Student s3=new Student(3, "Sanu",19);
		List<Student> s=new ArrayList<>();
		s.add(s1);s.add(s2);s.add(s3);
		Collections.sort(s);
		s.forEach(si->System.out.println(si));
		
	}

}
