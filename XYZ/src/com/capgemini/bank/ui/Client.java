package com.capgemini.bank.ui;


import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.service.DemandDraftService;
import com.capgemini.bank.service.IDemandDraftService;

public class Client {

	static Scanner scanner=new Scanner(System.in);
	
	// Adding the details to the demand draft object
	
	public DemandDraft getDemandDraft()
	{
		
		DemandDraft demanddraft=new DemandDraft();
		
	    demanddraft.setCustomer_name(promptcustomerName());
	    demanddraft.setPhone_number(promptphonenumber());
	    demanddraft.setIn_favor_of(promptin_favour_of());
	    demanddraft.setDate_of_transaction(LocalDate.now());
	    demanddraft.setDd_amount(prompt_demanddraft_amount());	   
		demanddraft.setDd_description(prompt_demand_remarks());
		demanddraft.setDd_commission(promptddcalculate(demanddraft.getDd_amount()));
		
		return demanddraft;
	}
	
	//Methods to prompt details for the demand draft by the user
	
	
private String promptcustomerName() {
		
		boolean flag=false;
		String customerName;
		do
		{
		System.out.println("Enter the name of the customer : ");
		
		 customerName=scanner.next();
		 flag=customerName.matches("[a-zA-Z]+");
		if(!flag)
		System.out.println("It contains only alphabets! Try again");
		}while(!flag);
		
		return customerName;
	}

	
	
private String promptphonenumber() {
		
		boolean flag=false;
		String phonenumber;
		do
		{
		System.out.println("Enter customer phone number : ");
		 phonenumber=scanner.next();
		 flag=phonenumber.matches("(7|8|9){1}[0-9]{9}");
		if(!flag)		
		System.out.println("Phone number is Invalid ! Enter again");
		}while(!flag);
		
		return phonenumber;
	}

private String promptin_favour_of() {
		
		boolean flag=false;
		String infavourof;
		do
		{
		System.out.println("In favor of : ");
		
		 infavourof=scanner.next();
		 flag=infavourof.matches("[a-zA-Z]+");
		if(!flag)
		System.out.println("It contains only alphabets! Try again");
		
		}while(!flag);
		
		return infavourof;
	}

	private double prompt_demanddraft_amount() {
		
		   double ddamount;
		   System.out.println("Enter Demand Draft amount(in Rs) : ");
		   ddamount=scanner.nextDouble();
		    return ddamount;
		    
		}

	private String prompt_demand_remarks() {
		
		System.out.println("Enter Remarks : ");
		String remarks=scanner.next();
		
		return remarks;
	}

// Method to calculate the commission for the draft amount
private double promptddcalculate(double dd_amount) {
		
		if(dd_amount<=5000)
		{
			return (10+dd_amount);
		}
		else if(dd_amount>5000 && dd_amount<=10000)
		{
			return (41+dd_amount);
		}
		else if(dd_amount>10000 && dd_amount<=100000)
		{
			return (51+dd_amount);
		}
		else
		{
			return (306+dd_amount);
		}
		
	}

//Main method that interacts with the User
	public static void main(String[] args) {
		
		Client client=new Client();
		
		IDemandDraftService demandDraftservice = new DemandDraftService();
		String option="";
		do
		{
			System.out.println("1) Enter Demand Draft Details");
			System.out.println("2) Exit");
			System.out.println("Choose your option");
			int choice=scanner.nextInt();
						
			switch(choice)
			{
			case 1:
				DemandDraft newDraft= client.getDemandDraft();
				int count=demandDraftservice.addDemandDraftDetails(newDraft);
				
				demandDraftservice.getDemandDraftDetails(count);
				break;
				
			   case 2:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Option!!");
					break;
				}
			System.out.println("Do you want to continue: [Y|N]");
			option=scanner.next();
		}while(option.charAt(0)=='y'||option.charAt(0)=='Y');
		System.out.println("Have a Good Day!!");
		
	}

}
