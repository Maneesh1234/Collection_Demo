package com.compt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	int id;
	String name;
	int age;
	
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
class NameComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		return (s1.name.compareTo(s2.name));
		
	}
}
class AgeComparator implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.age>s2.age) return 1;
		else if (s1.age<s2.age) return -1;
		return 0;
		
	}
}
public class ComparatorDemo {
	public static void main(String[] args) {
		Student s1=new Student(1, "Maneesh",25);
		Student s2=new Student(2, "Abhishek",52);
		Student s3=new Student(3, "Sanu",19);
		List<Student> s=new ArrayList<>();
		s.add(s1);s.add(s2);s.add(s3);
		Collections.sort(s, new NameComparator());
		s.forEach(si->System.out.println(si));
		
		System.out.println("*******************");
		Collections.sort(s, new AgeComparator());
		s.forEach(si->System.out.println(si));
		
	}

}
