package com.infinite.studentdetails;

import java.sql.Date;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="studentinfo")
@SessionScoped
@Entity
@Table(name="StudentDetails")
public class Student implements Comparator<Integer> {
	 @Id 
	 @Column(name="StudentId")

	private String sId;
	 
	 @Column(name="FirstName")
	private String firstName;
	 
	 @Column(name="LastName")
	private String lastName;
	 
	 @Column(name="Age")
    private int age;
   
	 @Column(name="College")
	private String college;
	 
	 @Column(name="Branch")
	private String branch;
	 
	 @Column(name="YearOfJoin")
	private int yearOfJoin;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYearOfJoin() {
		return yearOfJoin;
	}

	public void setYearOfJoin(int yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	 public int compare(String n1, String n2){
		 return n1.compareTo(n2);
	 }

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", college=" + college + ", branch=" + branch + ", yearOfJoin=" + yearOfJoin + "]";
	}
	 
	 
	
}
