package com.stalele;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConvertAMToPM {
	static String timeConversion(String s) {
        // Complete this function
		 String[] pmHours =  new String[] {"00","13","14","15","16","17","18","19","20","21","22","23","00"};
	      String[] str = s.split(":");
	      
	      int hour = Integer.parseInt(str[0]);
	      String min = str[1];
	      String ampm = str[2].substring(2,4);
	      String sec = str[2].substring(0,2);
	      
	      StringBuilder newFormat = new StringBuilder();
	      if(ampm.equalsIgnoreCase("PM")){
	        if(hour == 12) {
	          newFormat.append(hour);
	        } else {
	          newFormat.append(pmHours[hour]);  
	        }
	        
	        newFormat.append(":");
	        newFormat.append(min.toString());
	        newFormat.append(":");
	        newFormat.append(sec);
	      } else if(ampm.equalsIgnoreCase("AM")){
	    	  if(hour == 12){
	    		  newFormat.append(pmHours[hour]);
	    	       newFormat.append(":");
	    	       newFormat.append(min.toString());
	    	       newFormat.append(":");
	    	       newFormat.append(sec);
	    	  }
	    	  else
	    		  return s.substring(0,s.length()-2);
	      }
	      return newFormat.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

}
