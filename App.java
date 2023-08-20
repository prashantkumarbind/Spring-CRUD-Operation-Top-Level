package com.webdeveloper;

import com.webdeveloper.option.Option;
import com.webdeveloper.serviceimpl.EmployeeServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
           EmployeeServiceImpl empsl = new EmployeeServiceImpl();
           
    	   Option opt = new Option();
    	   while(true)
    	   {
    		    int result = opt.option();
    		    switch(result)
    		    {
    		    	case 1:  empsl.insert();
    		    			 break;
    		    	case 2:  empsl.select();
    		    			 break;
    		    	case 3:  empsl.update();
    		    			 break;
    		    	case 4:  empsl.delete();
    		    			 break;
    		    	case 5:  empsl.getById();
	    			 		 break;
    		    	case 6:  empsl.getByName();
			 		 		 break;
    		    	case 7:  empsl.checkMaxSalary();
	 		 		 		 break;
    		    	case 8:  empsl.checkByAddress();
    		    			 break;
    		    	case 9:  empsl.checkByDesignation();
    		    			 break;
    		    	default : System.out.println("Please Select Current Option:: ");
    		    			  break;
    		    	case 10:   System.exit(0);
    		    }
    		    
    	   }
    }
}












