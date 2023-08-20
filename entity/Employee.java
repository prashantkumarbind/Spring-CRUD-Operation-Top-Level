package com.webdeveloper.entity;

public class Employee {
	
		private String name;
		private String address;
		private int age;
		private String designation;
		private float salary;
		private int id;
		
		
		public String getName() {
			return name;
		}
		public String getAddress() {
			return address;
		}
		public int getAge() {
			return age;
		}
		public String getDesignation() {
			return designation;
		}
		public float getSalary() {
			return salary;
		}
		public int getId() {
			return id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String toString() {
			return "\n **Employee** \n Id::"+id+"\n Name::"+name+"\n Address::"+address+"\n Age::"+age+
					"\n Designation::"+name+"\n Salary::"+salary;
		}
		
}
