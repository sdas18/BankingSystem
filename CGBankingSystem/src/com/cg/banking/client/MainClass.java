package com.cg.banking.client;
import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {

	public static void main(String[] args) throws AccountNotFoundException,InvalidPinNumberException {
		BankingServices services = new BankingServicesImpl();
		Scanner sc = new Scanner(System.in);
		String accountType = " ";
		long accountNo = 0;
		int pinNumber = 0;
		long accountNoTo =0;
		long accountNoFrom = 0;
		char ch = ' ';
		do {
			System.out.println("******India Bank Pvt Ltd*******");
			System.out.println("Choose Operation :\n |1) Create New Account| \t |2) Deposit Amount| \t |3) Withdraw Amount| \t |4)Fund Transfer| \t |5)Mini Statment| \t |6)Account Details");
			System.out.println("*********************************");
			int option = sc.nextInt();
			switch(option) {
			case 1: 	System.out.println("****************\nEnter Account type you want to open : \t 1) Savings \t 2) Current:");
							int choice = sc.nextInt();
							switch(choice) {
							case 1 : accountType = "Savings";break;
							case 2 : accountType = "Current";break;
							default : System.out.println("Wrong input!!");break;
							}
							System.out.println("******************\nEnter Initial balance amount :");
							float initBalance = sc.nextFloat();
							try {
							accountNo = services.openAccount(accountType, initBalance);
							}
							catch(InvalidAmountException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("Account credentials generated :");
							System.out.println("\n" + services.getAccountDetails(accountNo));
							System.out.println("************************");
							break;
			case 2 :	System.out.println("*******************");
							int i =0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
								System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo, pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							System.out.println("Enter amount to deposit :");
							float depositAmount = sc.nextFloat();
							System.out.println("current balance :" +services.depositAmount(accountNo, depositAmount));
							System.out.println("*******************************");
							break;
			case 3:	System.out.println("********************************");
							 i =0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
								
								System.exit(0);
							}
							i=0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo, pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								
								System.exit(0);
							}
							else {
								System.out.println("Enter amount to Withdraw :");
								float withdrawAmount = sc.nextFloat();
								try {
									System.out.println("current balance :" +services.withdrawAmount(accountNo, withdrawAmount));
								}
								catch(InsufficentAmountException e) {
									System.out.println(e.getMessage());
								}
								System.out.println("***********************");
							}
							break;

			case 4: 	System.out.println("*************************");
							i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNoFrom = sc.nextLong();
								try {
									services.getAccountDetails(accountNoFrom);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {							
								System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNoFrom,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							i=0;
							while(i<3) {
								System.out.println("Enter Beneficiery Account No :");
								accountNoTo = sc.nextLong();
								try {
									services.getAccountDetails(accountNoFrom);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {							
								System.exit(0);
							}
							System.out.println("Enter Amount To Transfer :");
							float transferAmount = sc.nextFloat();
							services.fundTransfer(accountNoTo, accountNoFrom, transferAmount);
							System.out.println("************fund transfer completed**************");break;
			case 5:	System.out.println("********************************");
							i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
									System.exit(0);
							}
							i = 0;
							while(i<=3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							else
								System.out.println(services.getAccountAllTransaction(accountNo));
								System.out.println("******************************");
								break;
			case 6 : System.out.println("Account Details :");
							i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
									System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) 
								System.exit(0);
							else 
								System.out.println(services.getAccountDetails(accountNo) );
							break;
			default: System.out.println("******************");
			System.out.println("Wrong input!!");
			System.out.println("************************");
			}
			System.out.println("\nWant to continue services? type 'y' | 'Y' for yes or 'n' | 'N' for No.");
			ch = sc.next().charAt(0);
		}while(ch == 'y' || ch=='Y');
		if(ch == 'n' || ch== 'N')
			System.exit(0);
	}
}


