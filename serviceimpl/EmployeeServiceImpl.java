package com.webdeveloper.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.webdeveloper.entity.Employee;
import com.webdeveloper.rowmapper.ExecuteQuery;
import com.webdeveloper.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
		int total;
		String name,address,designation;
		float salary;
		int id,age;
		
		private BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		private ApplicationContext con = new ClassPathXmlApplicationContext("Xml.xml");
		JdbcTemplate jdbc = (JdbcTemplate)con.getBean("template");
		
		public void insert() {
			
			System.err.println("================ insert method executed ================\n");
			try {
				   // for check employee last position======================== = = = = = = = =
				
				 	String query2="select * from employee";
					List<Employee> list = jdbc.query(query2, new ExecuteQuery());
					for(Employee val : list)
					{
						  //System.err.println(val);
						  total=val.getId();
					}
					System.out.println("Your Last Id number:: "+total);
					
				 // End == == == == == == == == == == == == ==
				 id = (total+1);
				 System.out.println("Your Last Id number::After:: "+id);
				 System.err.println("Enter the Employee Name::");
				 name = bfr.readLine();
				 System.err.println("Enter the Employee Address::");
				 address = bfr.readLine();
				 System.err.println("Enter the Employee Age::");
				 age = Integer.parseInt(bfr.readLine());
				 System.err.println("Enter the Employee Designation ::");
				 designation = bfr.readLine();
				 System.err.println("Enter the Employee Salary ::");
				 salary = Float.parseFloat(bfr.readLine());
				 String query1 = "insert into employee(id_no,address,age,designation,name,salary) values(?,?,?,?,?,?)";
				 int result = jdbc.update(query1,id,address,age,designation,name,salary);
				 System.err.println("Inserted Of value:: "+result);
				 
			}catch(Exception e) {
				  System.err.println("exception Occure in the insert concept::"+e);
			}
				
		}
	
		public void select() {
			
			System.err.println("==============Select part started============\n");
			String query1="select * from employee";
			List<Employee> list = jdbc.query(query1, new ExecuteQuery());
			for(Employee val : list)
			{
				  System.err.println("\t\t\t\t\t"+val);
				  total++;
			}
			System.err.println("\n\n =========== Total Employee:: "+total );
			
		}
	
		public void update() {
			
			System.err.println("================Update method executed===============\n");
			
			try {
					
					System.err.print("Enter the Employee Id You want to Update:: ");
					id = Integer.parseInt(bfr.readLine());
					String queryupdate = "update employee set address=? , name=? where id_no="+id;
		
					System.err.print("Enter the Employee new name:: ");
					name = bfr.readLine();
					System.err.print("Enter the Employee new address:: ");
					address = bfr.readLine();
					int result = jdbc.update(queryupdate,address,name);
					if(result==1)
						System.err.println("Yes Update ");
					else
						System.err.println("Not Update");
				
					}catch(Exception e) {
						System.err.println("exception occure in the update method::"+e);
					}
		}
	
		public void delete() {
			
			System.err.println("=============== delete method executed==============");
			try {
			
				String querydelete = "delete from employee where id_no=?";
				System.err.print("Enter the Employee Id You Want to Delete :: ");
				id = Integer.parseInt(bfr.readLine());
				int result = jdbc.update(querydelete,id);
				if(result==1)
					System.err.print("\n::Data Deleted ");
				else
					System.err.println("\n Data not Delete ");
				}catch(Exception e) {
					System.err.println("\n::Exception Occur in the delete method:: "+e);
				}
		}

		public void getById() {
			
			System.err.println("=============== getByid method executed==============");
			try {
				
				System.err.print("Enter the Employee Id You Want to Show Details::");
				id = Integer.parseInt(bfr.readLine());
				String query1 = "select * from employee where id_no="+id;
				List<Employee> list= jdbc.query(query1, new ExecuteQuery());
				System.err.println(list);	
				}catch(Exception e) {
					System.err.println("Exception Occure in the GETBYID METHOD ::"+e);
				}
		}

		public void getByName() {
			try {
				System.out.print("Enter the Name You want to check:: ");
				name = bfr.readLine();
				String query1 = "select * from employee where name=" + name;
				List<Employee> list = jdbc.query(query1, new ExecuteQuery());
				for(Employee e : list)
				{
					 System.out.println("\t\t\t\t\t"+e);
				}
				}catch(Exception e) {
					System.out.println("Exception Occure in the getByName method::"+e);
				}
		}

		public void checkMaxSalary() {
			int size=0;
			float max=0,min=0;
			int r=0;
			float check=0;
			int number=0;
			List<Float> arrmax = new ArrayList();
			List<Integer> arrindex = new ArrayList();
			Employee e = new Employee();
			
			List<Float> arr = new ArrayList<Float>();
			String query1 = "select * from employee";
			List<Employee> list = jdbc.query(query1, new ExecuteQuery());
			size=list.size();
			for(r=0;r<size;r++)
			{
				  e = list.get(r);
				  max = e.getSalary();
				  arrmax.add(max);
				  arrindex.add(r);
			}
			for(r=0;r<size;r++)
			{
				 if(check<arrmax.get(r))
				 {
					   check=arrmax.get(r);
					   number = r;
				 }
					 
			}
			e = list.get(number);
			System.out.println("\t\t\t\t\t"+e);
			
		}

		public void checkByAddress() {
			try {
				System.err.print("Enter the Address name You want to check::");
				String address = bfr.readLine();
				String query1 = "select * from employee where address="+address;
				List<Employee>  list = jdbc.query(query1, new ExecuteQuery());
				for(Employee val : list)
				{
					System.out.println("\t\t\t\t\t"+val);
				}
			}catch(Exception e) {
				System.out.println("Exception Occure in checkByAddress method::"+e);
			}
		}

		public void checkByDesignation() {
			
			try {
				 System.out.println("Check Employee Details According to Designation:: ");
				 String designation = bfr.readLine();
				 String query1 = "select * from employee where designation="+designation;
				 List<Employee> list = jdbc.query(query1, new ExecuteQuery());
				 for(Employee e :  list)
				 {
					 System.out.println("\t\t\t\t\t"+e);
				 }
			}catch(Exception e) {
				System.out.println("Exception Occur in checkByDesignation method::"+e);
			}
		}

}




















