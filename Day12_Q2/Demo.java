package com.Day12_Q2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Demo {

	public boolean validate(String name, String mobileNum, String aadharCard) {
		
		boolean checkName = Pattern.matches("[a-zA-Z\\s]{3,8}",name);
		boolean checkMobile = Pattern.matches("[6-9]{1}[0-9]{9}", mobileNum);
		boolean checkAadhar = Pattern.matches("[1-9]{1}[0-9]{11}", aadharCard);
		
		if(checkName && checkMobile && checkAadhar)
		{
			return true;
		}
		else if(!checkName && !checkMobile && !checkAadhar) {
			System.out.println("Citizen details are not valid, enter correct details.");
		}
		else if(!checkName && !checkMobile) {
			System.out.println("Please enter a valid name containing 3 to 8 albhabets only and a valid Indian mobile number.");
			return false;
		}
		else if(!checkName && !checkAadhar) {
			System.out.println("Please enter a valid name containing 3 to 8 albhabets only and a valid aadhar number.");
		}
		else if(!checkMobile && !checkAadhar) {
			System.out.println("Please enter a valid Indian mobile number and aadhar number.");
			return false;
		}
		else if(!checkName) {
			System.out.println("Please enter a valid name containing 3 to 8 alphabets only.");
			return false;
		}
		else if(!checkMobile) {
			System.out.println("Please enter a valid Indian mobile number.");
			return false;
		}
		else if(!checkAadhar) {
			System.out.println("Please enter a valid aadhar number.");
			return false;
		}
		
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name = sc.nextLine();
	
		System.out.println("Enter mobile number:");
		String mobileNum = sc.next();
		
		System.out.println("Enter aadhar number:");
		String aadharNum = sc.next();
		
		sc.close();
		
		
		
		
		Demo d1 = new Demo();
		
		boolean result = d1.validate(name, mobileNum, aadharNum);
		
		if(result == true)
		{
			Citizen c1 = new Citizen();
			
			c1.setName(name);
			c1.setAadharNumber(aadharNum);
			c1.setMobileNumber(mobileNum);
			
			System.out.println("Citizen name is: " + c1.getName());
			System.out.println("Aadhar number is: " + c1.getAadharNumber());
			System.out.println("Mobile number is: " + c1.getMobileNumber());
		}
		else {
			System.out.println("Thank you...");
		}
		
	}
}

/*
Make sure that to perform the following input validations inside validate() method:

name: should contain only alphabets and length should be min 3 and max 8
characters.
aadharNumber: should be numeric and also of length 12.
mobileNumber: should be an Indian mobile number starting with 6,7,8,9 and the
length should be 10.
*/