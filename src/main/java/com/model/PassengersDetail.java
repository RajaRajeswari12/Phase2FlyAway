package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PassengerDetail")
public class PassengersDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int PassengerId;
	
	

	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String Gender;

	public int getPassengerId() {
		return PassengerId;
	}

	public void setPassengerId(int passengerId) {
		PassengerId = passengerId;
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

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "PassengersDetail [PassengerId=" + PassengerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", Gender=" + Gender + "]";
	}
	
	
	
}
