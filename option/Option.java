package com.webdeveloper.option;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Option {

		int result;
		public int option() {
			
			 try {
				  BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
				  System.err.println("** Please Select Any One Option **");
				  System.err.println("Insert       ::*1*::");
				  System.err.println("Select       ::*2*::");
				  System.err.println("Update       ::*3*::");
				  System.err.println("Delete       ::*4*::");
				  System.err.println("SearchById   ::*5*::");
				  System.err.println("SearchByName ::*6*::");
				  System.err.println("MaxSalary    ::*7*::");
				  System.err.println("SearchByAddress*8*::");
				  System.err.println("SearchByDesignation*9*::");
				  System.err.println("Exit         ::*10*::");
				  System.err.print("Click Now :: ");
				  result = Integer.parseInt(bfr.readLine());
				  return result;
			 }catch(Exception e) {
				 System.err.println("Exception Occure in the program::");
			 }
			 return result;
		}
}
